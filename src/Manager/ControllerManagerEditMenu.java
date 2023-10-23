package Manager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Database.Restaurant;
import Model.Model;

public class ControllerManagerEditMenu implements ActionListener {
	private Model model;
	private ViewManagerEditMenuPanel viewManagerEditMenuPanel;
	private ControllerManager controllerManager;

	public ControllerManagerEditMenu(Model model, ViewManagerEditMenuPanel viewManagerEditMenuPanel,
			ControllerManager controllerManager) {
		this.model = model;
		this.viewManagerEditMenuPanel = viewManagerEditMenuPanel;
		this.controllerManager = controllerManager;

		// Adding the buttons
		viewManagerEditMenuPanel.getBtnSelect().addActionListener(this);
		viewManagerEditMenuPanel.getBtnAddItem().addActionListener(this);
		viewManagerEditMenuPanel.getBtnEditMenu().addActionListener(this);
		viewManagerEditMenuPanel.getBtnDeleteItem().addActionListener(this);

	}

	@Override
    public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == viewManagerEditMenuPanel.getBtnSelect()) {
			// Get the selected restaurant name from the table
			int selectedRow = viewManagerEditMenuPanel.getTableRestaurant().getSelectedRow();
			if (selectedRow == -1) {
				// If no row is selected, show an error message and return
				JOptionPane.showMessageDialog(viewManagerEditMenuPanel, "Please select a restaurant first.");
				return;
			}
			
			// The manager can edit the menu of his restaurant only
			String selectedRestaurantName = viewManagerEditMenuPanel.getTableRestaurant().getValueAt(selectedRow, 0)
					.toString();
			if (!selectedRestaurantName.equalsIgnoreCase(model.getCurrentUser().getRestaurantName())) {
			    JOptionPane.showMessageDialog(viewManagerEditMenuPanel, "You can modify the menu of your restaurant only", "Error", JOptionPane.ERROR_MESSAGE);
			    return;
			}


			// Get the menu items for the selected restaurant from the database
			Restaurant selectedRestaurant = model.getRestaurantDatabase().getRestaurant(selectedRestaurantName);
			List<Database.Menu> menuItems = model.getMenuDatabase().getMenuItems(selectedRestaurant);

			// Clear the table model and add the menu items to the table
			DefaultTableModel menuTableModel = (DefaultTableModel) viewManagerEditMenuPanel.getTableCreateMenu()
					.getModel();
			menuTableModel.setRowCount(0);
			for (Database.Menu menuItem : menuItems) {
				Object[] rowData = { menuItem.getItemName(), menuItem.getPrice() };
				menuTableModel.addRow(rowData);
			}
		}

		// Add item
		if (source == viewManagerEditMenuPanel.getBtnAddItem()) {
			// Get the selected restaurant name from the table
			int selectedRow = viewManagerEditMenuPanel.getTableRestaurant().getSelectedRow();
			if (selectedRow == -1) {
				// If no row is selected, show an error message and return
				JOptionPane.showMessageDialog(viewManagerEditMenuPanel, "Please select a restaurant first.");
				return;
			}
			String selectedRestaurantName = viewManagerEditMenuPanel.getTableRestaurant().getValueAt(selectedRow, 0)
					.toString();

			// Get the text from tfItem and tfPrice
			String item = viewManagerEditMenuPanel.getTfItem().getText();
			double price = Double.parseDouble(viewManagerEditMenuPanel.getTfPrice().getText());

			// Format the price string
			String priceStr = String.format("%.2f", price);

			// Add the item and price to the database
			Restaurant selectedRestaurant = model.getRestaurantDatabase().getRestaurant(selectedRestaurantName);
			Database.Menu newMenuItem = new Database.Menu(item, price);
			model.getMenuDatabase().addMenuItem(selectedRestaurant, newMenuItem);

			// Add the item and price to the table
			DefaultTableModel menuTableModel = (DefaultTableModel) viewManagerEditMenuPanel.getTableCreateMenu()
					.getModel();
			menuTableModel.addRow(new Object[] { item, priceStr });

			// Reset the textfields
			viewManagerEditMenuPanel.getTfItem().setText("");
			viewManagerEditMenuPanel.getTfPrice().setText("");
		}

		// Delete item
		if (source == viewManagerEditMenuPanel.getBtnDeleteItem()) {
			int selectedRow = viewManagerEditMenuPanel.getTableCreateMenu().getSelectedRow();
			DefaultTableModel model = (DefaultTableModel) viewManagerEditMenuPanel.getTableCreateMenu().getModel();
			if (selectedRow != -1) { // Check if a row is selected
				// Get the selected restaurant name from the table
				int restaurantSelectedRow = viewManagerEditMenuPanel.getTableRestaurant().getSelectedRow();
				if (restaurantSelectedRow == -1) {
					// If no row is selected, show an error message and return
					JOptionPane.showMessageDialog(viewManagerEditMenuPanel, "Please select a restaurant first.");
					return;
				}
				String selectedRestaurantName = viewManagerEditMenuPanel.getTableRestaurant()
						.getValueAt(restaurantSelectedRow, 0).toString();

				// Get the selected item from the table
				String selectedItemName = model.getValueAt(selectedRow, 0).toString();
				double selectedItemPrice = Double.parseDouble(model.getValueAt(selectedRow, 1).toString());

				// Remove the selected item from the database
				Restaurant selectedRestaurant = this.model.getRestaurantDatabase()
						.getRestaurant(selectedRestaurantName);
				this.model.getMenuDatabase().removeMenuItem(selectedRestaurant, selectedItemName);

				// Remove the selected row from the table
				model.removeRow(selectedRow);
			}
		}

		// Edit Menu
		if (source == viewManagerEditMenuPanel.getBtnEditMenu()) {
			// Get the selected row in the table
			int selectedRow = viewManagerEditMenuPanel.getTableCreateMenu().getSelectedRow();
			if (selectedRow == -1) {
				// If no row is selected, show an error message and return
				JOptionPane.showMessageDialog(viewManagerEditMenuPanel, "Please select an item to edit.");
				return;
			}

			// Get the values of the selected row
			String itemName = viewManagerEditMenuPanel.getTableCreateMenu().getValueAt(selectedRow, 0).toString();
			double itemPrice = Double
					.parseDouble(viewManagerEditMenuPanel.getTableCreateMenu().getValueAt(selectedRow, 1).toString());

			// Set the values in the text fields
			viewManagerEditMenuPanel.getTfItem().setText(itemName);
			viewManagerEditMenuPanel.getTfPrice().setText(Double.toString(itemPrice));

		}

	}
}
