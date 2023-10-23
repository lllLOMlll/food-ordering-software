package Client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.UUID;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Database.Order;
import Database.Restaurant;
import Model.Model;

public class ControllerClientOrderFood implements ActionListener {
	private Model model;
	private ViewClientOrderFoodPanel viewClientOrderFoodPanel;
	private ControllerClient controllerClient;
	private ViewClientOrderHistoryPanel viewClientOrderHistoryPanel;

	public ControllerClientOrderFood(Model model, ViewClientOrderFoodPanel viewClientOrderFoodPanel,
	        ControllerClient controllerClient, ViewClientOrderHistoryPanel viewClientOrderHistoryPanel) {
	    this.model = model;
	    this.viewClientOrderFoodPanel = viewClientOrderFoodPanel;
	    this.controllerClient = controllerClient;
	    this.viewClientOrderHistoryPanel = viewClientOrderHistoryPanel;

		// Adding the buttons
		viewClientOrderFoodPanel.getBtnSelect().addActionListener(this);
		viewClientOrderFoodPanel.getBtnAdd().addActionListener(this);
		viewClientOrderFoodPanel.getBtnDelete().addActionListener(this);
		viewClientOrderFoodPanel.getBtnOrder().addActionListener(this);
		viewClientOrderFoodPanel.getBtnAddItemOrder().addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == viewClientOrderFoodPanel.getBtnSelect()) {
			// Get the selected restaurant name from the table
			int selectedRow = viewClientOrderFoodPanel.getTableRestaurant().getSelectedRow();
			if (selectedRow == -1) {
				// If no row is selected, show an error message and return
				JOptionPane.showMessageDialog(viewClientOrderFoodPanel, "Please select a restaurant first.");
				return;
			}
			String selectedRestaurantName = viewClientOrderFoodPanel.getTableRestaurant().getValueAt(selectedRow, 0)
					.toString();

			// Get the menu items for the selected restaurant from the database
			Restaurant selectedRestaurant = model.getRestaurantDatabase().getRestaurant(selectedRestaurantName);
			List<Database.Menu> menuItems = model.getMenuDatabase().getMenuItems(selectedRestaurant);

			// Clear the table model and add the menu items to the table
			DefaultTableModel menuTableModel = (DefaultTableModel) viewClientOrderFoodPanel.getTableCreateMenu()
					.getModel();
			menuTableModel.setRowCount(0);
			for (Database.Menu menuItem : menuItems) {
				Object[] rowData = { menuItem.getItemName(), menuItem.getPrice() };
				menuTableModel.addRow(rowData);
			}
		}

		// Edit Menu
		if (source == viewClientOrderFoodPanel.getBtnAdd()) {
			// Get the selected row in the table
			int selectedRow = viewClientOrderFoodPanel.getTableCreateMenu().getSelectedRow();
			if (selectedRow == -1) {
				// If no row is selected, show an error message and return
				JOptionPane.showMessageDialog(viewClientOrderFoodPanel, "Please select an item to edit.");
				return;
			}

			// Get the values of the selected row
			String itemName = viewClientOrderFoodPanel.getTableCreateMenu().getValueAt(selectedRow, 0).toString();
			double itemPrice = Double
					.parseDouble(viewClientOrderFoodPanel.getTableCreateMenu().getValueAt(selectedRow, 1).toString());

			// Set the values in the text fields
			viewClientOrderFoodPanel.getTfMeal().setText(itemName);
			viewClientOrderFoodPanel.getTfPrice().setText(Double.toString(itemPrice));

		}

		// Adding items to you order
		if (source == viewClientOrderFoodPanel.getBtnAddItemOrder()) {
			// Get the values from the text fields
			String meal = viewClientOrderFoodPanel.getTfMeal().getText();
			String price = viewClientOrderFoodPanel.getTfPrice().getText();
			String quantityStr = viewClientOrderFoodPanel.getTfQuantity().getText();
			int quantity = 0;
			try {
			    quantity = Integer.parseInt(quantityStr);
			} catch (NumberFormatException ex) {
			    JOptionPane.showMessageDialog(viewClientOrderFoodPanel, "Please enter a valid quantity.", "Error", JOptionPane.ERROR_MESSAGE);
			    return;
			}
			
			// Validation to make sure that the user selected an item
			if (meal.isEmpty()) {
				JOptionPane.showMessageDialog(viewClientOrderFoodPanel, "Please select a item", "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			// Validation for the quantity
			if (quantityStr.isEmpty()) {
				JOptionPane.showMessageDialog(viewClientOrderFoodPanel, "Please indicate a quantity", "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			// Validation for the quantity (not over 10)
			if (quantity > 10) {
				JOptionPane.showMessageDialog(viewClientOrderFoodPanel, "The max quantity is 10", "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			// Validation for the quantity (not 0 or less)
			if (quantity <= 0) {
				JOptionPane.showMessageDialog(viewClientOrderFoodPanel, "The quantity can not be 0 or negative", "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			// Create a new row for the table
			Object[] row = { meal, price, quantity };

			// Get the table model for the tableOrder and add the new row to it
			DefaultTableModel model = (DefaultTableModel) viewClientOrderFoodPanel.getTableOrder().getModel();
			model.addRow(row);

			// Clearing the fields
			viewClientOrderFoodPanel.getTfMeal().setText("");
			viewClientOrderFoodPanel.getTfPrice().setText("");
			viewClientOrderFoodPanel.getTfQuantity().setText("");
		}

		// Delete an item in the order
		if (source == viewClientOrderFoodPanel.getBtnDelete()) {
			int selectedRow = viewClientOrderFoodPanel.getTableOrder().getSelectedRow();
			DefaultTableModel model = (DefaultTableModel) viewClientOrderFoodPanel.getTableOrder().getModel();
			if (selectedRow != -1) { // Check if a row is selected
				// Get the selected restaurant name from the table
				int restaurantSelectedRow = viewClientOrderFoodPanel.getTableOrder().getSelectedRow();
				if (restaurantSelectedRow == -1) {
					// If no row is selected, show an error message and return
					JOptionPane.showMessageDialog(viewClientOrderFoodPanel, "Please select a restaurant first.");
					return;
				}

				// Remove the selected row from the table
				model.removeRow(selectedRow);
			}
		}
		
		// Save the order
		if (source == viewClientOrderFoodPanel.getBtnOrder()) {
			
			// Get the required data from the view
			String clientUsername = model.getCurrentUser().getUsername();
			String deliveryDate = viewClientOrderFoodPanel.getFrmtdtxtfDeliveryTimeyyymmdd().getText();
			String deliveryTime = viewClientOrderFoodPanel.getFrmtdtxtfDeliveryTimeHour().getText();
			String postalCode = viewClientOrderFoodPanel.getFrmtdtxtfPostalCode().getText();
			// This line will generate a UUID and convert it to a string, which can be used as a unique order ID. UUIDs have 128 bits and are represented by 32 hexadecimal digits, displayed in 5 groups separated by hyphens, for a total of 36 characters (32 alphanumeric characters and 4 hyphens). The probability of generating duplicate UUIDs is extremely low, making them suitable for use as unique IDs.
			String orderId = UUID.randomUUID().toString();
			
			// Restaurant name
			// Get the selected restaurant name from the table
			int selectedRow = viewClientOrderFoodPanel.getTableRestaurant().getSelectedRow();
			if (selectedRow == -1) {
			    // If no row is selected, show an error message and return
			    JOptionPane.showMessageDialog(viewClientOrderFoodPanel, "Please select a restaurant first.");
			    return;
			}
			String selectedRestaurantName = viewClientOrderFoodPanel.getTableRestaurant().getValueAt(selectedRow, 0)
			        .toString();

			// Get the Restaurant object for the selected restaurant from the database
			Restaurant selectedRestaurant = model.getRestaurantDatabase().getRestaurant(selectedRestaurantName);

	
			// Create a new Order object
			Order order = new Order(orderId, clientUsername, deliveryDate, deliveryTime, postalCode, selectedRestaurant, true, false, false, false);



			// Get the table model from the order table
			DefaultTableModel orderTableModel = (DefaultTableModel) viewClientOrderFoodPanel.getTableOrder().getModel();

			// Iterate through the table rows and add the items to the Order object
			for (int i = 0; i < orderTableModel.getRowCount(); i++) {
			    String itemName = orderTableModel.getValueAt(i, 0).toString();
			    double itemPrice = Double.parseDouble(orderTableModel.getValueAt(i, 1).toString());
			    int itemQuantity = Integer.parseInt(orderTableModel.getValueAt(i, 2).toString());
			    order.addItem(itemName, itemPrice, itemQuantity);
			}


	
			// Save the order in the database
			model.getDatabaseOrder().addOrder(orderId, order);
			
	
			
		    // Update the order history panel
		    viewClientOrderHistoryPanel.populateOrderTable();

			// Clear the order table and other input fields
			orderTableModel.setRowCount(0);
			viewClientOrderFoodPanel.getFrmtdtxtfDeliveryTimeyyymmdd().setText("");
			viewClientOrderFoodPanel.getFrmtdtxtfDeliveryTimeHour().setText("");
			viewClientOrderFoodPanel.getFrmtdtxtfPostalCode().setText("");
			viewClientOrderFoodPanel.getTfQuantity().setText("");

			// Show a success message
			JOptionPane.showMessageDialog(viewClientOrderFoodPanel, "Order saved successfully.");

		}
		
	}
}
