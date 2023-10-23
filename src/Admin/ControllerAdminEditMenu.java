package Admin;

import java.awt.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Database.Restaurant;
import Model.Model;

public class ControllerAdminEditMenu implements ActionListener {
	private Model model;
	private ViewAdminEditMenuPanel viewAdminEditMenuPanel;
	private ControllerAdmin controllerAdmin;
	private ViewAdminDeleteRestaurantPanel viewAdminDeleteRestaurantPanel;
	private List<Database.Menu> modifiedItems = new ArrayList<>();

	public ControllerAdminEditMenu(Model model, ViewAdminEditMenuPanel viewAdminEditMenuPanel,
			ControllerAdmin controllerAdmin, ViewAdminDeleteRestaurantPanel viewAdminDeleteRestaurantPanel) {
		this.model = model;
		this.viewAdminEditMenuPanel = viewAdminEditMenuPanel;
		this.controllerAdmin = controllerAdmin;
		this.viewAdminDeleteRestaurantPanel = viewAdminDeleteRestaurantPanel;

		// Adding the buttons
		viewAdminEditMenuPanel.getBtnSelect().addActionListener(this);
		viewAdminEditMenuPanel.getBtnAddItem().addActionListener(this);
		viewAdminEditMenuPanel.getBtnDeleteItem().addActionListener(this);
		viewAdminEditMenuPanel.getBtnSaveMenu().addActionListener(this);
		viewAdminEditMenuPanel.getBtnEditItem().addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == viewAdminEditMenuPanel.getBtnSelect()) {
			// Get the selected restaurant name from the table
			int selectedRow = viewAdminEditMenuPanel.getTableRestaurant().getSelectedRow();
			if (selectedRow == -1) {
				// If no row is selected, show an error message and return
				JOptionPane.showMessageDialog(viewAdminEditMenuPanel, "Please select a restaurant first.");
				return;
			}
			String selectedRestaurantName = viewAdminEditMenuPanel.getTableRestaurant().getValueAt(selectedRow, 0)
					.toString();

			// Get the menu items for the selected restaurant from the database
			Restaurant selectedRestaurant = model.getRestaurantDatabase().getRestaurant(selectedRestaurantName);
			List<Database.Menu> menuItems = model.getMenuDatabase().getMenuItems(selectedRestaurant);

			// Clear the table model and add the menu items to the table
			DefaultTableModel menuTableModel = (DefaultTableModel) viewAdminEditMenuPanel.getTableCreateMenu()
					.getModel();
			menuTableModel.setRowCount(0);
			for (Database.Menu menuItem : menuItems) {
				Object[] rowData = { menuItem.getItemName(), menuItem.getPrice() };
				menuTableModel.addRow(rowData);
			}
		}

		// Add item
		if (source == viewAdminEditMenuPanel.getBtnAddItem()) {
			// Get the selected restaurant name from the table
			int selectedRow = viewAdminEditMenuPanel.getTableRestaurant().getSelectedRow();
			if (selectedRow == -1) {
				// If no row is selected, show an error message and return
				JOptionPane.showMessageDialog(viewAdminEditMenuPanel, "Please select a restaurant first.");
				return;
			}
			String selectedRestaurantName = viewAdminEditMenuPanel.getTableRestaurant().getValueAt(selectedRow, 0)
					.toString();

			// Get the text from tfItem and tfPrice
			String item = viewAdminEditMenuPanel.getTfItem().getText();
			double price = Double.parseDouble(viewAdminEditMenuPanel.getTfPrice().getText());

			// Format the price string
			String priceStr = String.format("%.2f", price);

			// Add the item and price to the database
			Restaurant selectedRestaurant = model.getRestaurantDatabase().getRestaurant(selectedRestaurantName);
			Database.Menu newMenuItem = new Database.Menu(item, price);
			model.getMenuDatabase().addMenuItem(selectedRestaurant, newMenuItem);

			// Add the item and price to the table
			DefaultTableModel menuTableModel = (DefaultTableModel) viewAdminEditMenuPanel.getTableCreateMenu()
					.getModel();
			menuTableModel.addRow(new Object[] { item, priceStr });

			// Reset the textfields
			viewAdminEditMenuPanel.getTfItem().setText("");
			viewAdminEditMenuPanel.getTfPrice().setText("");
		}

		// Delete item
		if (source == viewAdminEditMenuPanel.getBtnDeleteItem()) {
			int selectedRow = viewAdminEditMenuPanel.getTableCreateMenu().getSelectedRow();
			DefaultTableModel model = (DefaultTableModel) viewAdminEditMenuPanel.getTableCreateMenu().getModel();
			if (selectedRow != -1) { // Check if a row is selected
				// Get the selected restaurant name from the table
				int restaurantSelectedRow = viewAdminEditMenuPanel.getTableRestaurant().getSelectedRow();
				if (restaurantSelectedRow == -1) {
					// If no row is selected, show an error message and return
					JOptionPane.showMessageDialog(viewAdminEditMenuPanel, "Please select a restaurant first.");
					return;
				}
				String selectedRestaurantName = viewAdminEditMenuPanel.getTableRestaurant()
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
		if (source == viewAdminEditMenuPanel.getBtnEditItem()) {
			// Get the selected row in the table
			int selectedRow = viewAdminEditMenuPanel.getTableCreateMenu().getSelectedRow();
			if (selectedRow == -1) {
				// If no row is selected, show an error message and return
				JOptionPane.showMessageDialog(viewAdminEditMenuPanel, "Please select an item to edit.");
				return;
			}

			// Get the values of the selected row
			String itemName = viewAdminEditMenuPanel.getTableCreateMenu().getValueAt(selectedRow, 0).toString();
			double itemPrice = Double
					.parseDouble(viewAdminEditMenuPanel.getTableCreateMenu().getValueAt(selectedRow, 1).toString());

			// Set the values in the text fields
			viewAdminEditMenuPanel.getTfItem().setText(itemName);
			viewAdminEditMenuPanel.getTfPrice().setText(Double.toString(itemPrice));

		}

//     // Save menu
//        if (source == viewAdminEditMenuPanel.getBtnSaveMenu()) {
//            // Get the selected restaurant name from the table
//            int selectedRow = viewAdminEditMenuPanel.getTableRestaurant().getSelectedRow();
//            if (selectedRow == -1) {
//                // If no row is selected, show an error message and return
//                JOptionPane.showMessageDialog(viewAdminEditMenuPanel, "Please select a restaurant first.");
//                return;
//            }
//            String selectedRestaurantName = viewAdminEditMenuPanel.getTableRestaurant().getValueAt(selectedRow, 0).toString();
//
//            // Get the menu items for the selected restaurant from the database
//            Restaurant selectedRestaurant = model.getRestaurantDatabase().getRestaurant(selectedRestaurantName);
//            List<Database.Menu> menuItems = model.getMenuDatabase().getMenuItems(selectedRestaurant);
//
//            // Update the selected item in the database with the values from the table
//            int selectedMenuItemIndex = viewAdminEditMenuPanel.getTableCreateMenu().getSelectedRow();
//            if (selectedMenuItemIndex != -1) {
//                String selectedItemName = viewAdminEditMenuPanel.getTableCreateMenu().getValueAt(selectedMenuItemIndex, 0).toString();
//                double selectedItemPrice = Double.parseDouble(viewAdminEditMenuPanel.getTableCreateMenu().getValueAt(selectedMenuItemIndex, 1).toString());
//                Database.Menu selectedMenuItem = new Database.Menu(selectedItemName, selectedItemPrice);
//
//                // Find the index of the selected item in the modified items list
//                int modifiedItemIndex = modifiedItems.indexOf(selectedMenuItem);
//                if (modifiedItemIndex != -1) {
//                    // Update the item in the database
//                    model.getMenuDatabase().updateMenuItem(selectedRestaurant, selectedMenuItem);
//                    modifiedItems.set(modifiedItemIndex, selectedMenuItem);
//                } else {
//                    // Add the new item to the database
//                    model.getMenuDatabase().addMenuItem(selectedRestaurant, selectedMenuItem);
//                    modifiedItems.add(selectedMenuItem);
//                }
//            }
//
//            // Show a success message
//            JOptionPane.showMessageDialog(viewAdminEditMenuPanel, "Menu updated successfully.");
//        }

	}
}
