package Manager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.plaf.synth.SynthOptionPaneUI;
import javax.swing.table.DefaultTableModel;

import Database.Restaurant;
import Model.Model;

public class ControllerManagerCreateMenu implements ActionListener {
	private Model model;
	private ViewManagerCreateMenuPanel viewManagerCreateMenuPanel;
	private ControllerManager controllerManager;

	public ControllerManagerCreateMenu(Model model, ViewManagerCreateMenuPanel viewManagerCreateMenuPanel,
			ControllerManager controllerManager) {
		this.model = model;
		this.viewManagerCreateMenuPanel = viewManagerCreateMenuPanel;
		this.controllerManager = controllerManager;

		// Adding the buttons
		viewManagerCreateMenuPanel.getBtnSelect().addActionListener(this);
		viewManagerCreateMenuPanel.getBtnAddItem().addActionListener(this);
		viewManagerCreateMenuPanel.getBtnCreateMenu().addActionListener(this);
		viewManagerCreateMenuPanel.getBtnDeleteItem().addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == viewManagerCreateMenuPanel.getBtnSelect()) {
			// Get the selected restaurant name from the table
			int selectedRow = viewManagerCreateMenuPanel.getTableRestaurant().getSelectedRow();
			if (selectedRow == -1) {
				// If no row is selected, show an error message and return
				JOptionPane.showMessageDialog(viewManagerCreateMenuPanel, "Please select a restaurant first.");
				return;
			}
			
			// The manager can create a menu only for his restaurant.
			String selectedRestaurantName = viewManagerCreateMenuPanel.getTableRestaurant().getValueAt(selectedRow, 0)
					.toString();
			if (!selectedRestaurantName.equalsIgnoreCase(model.getCurrentUser().getRestaurantName())) {
			    JOptionPane.showMessageDialog(viewManagerCreateMenuPanel, "You can modify the menu of your restaurant only", "Error", JOptionPane.ERROR_MESSAGE);
			    return;
			}

			
			// Get the menu items for the selected restaurant from the database
			Restaurant selectedRestaurant = model.getRestaurantDatabase().getRestaurant(selectedRestaurantName);
			System.out.println(selectedRestaurant);
			List<Database.Menu> menuItems = model.getMenuDatabase().getMenuItems(selectedRestaurant);
		}
		
		 if (source == viewManagerCreateMenuPanel.getBtnAddItem()) {
	            // Get the text from tfItem and tfPrice
	            String item = viewManagerCreateMenuPanel.getTfItem().getText();
	            double price = Double.parseDouble(viewManagerCreateMenuPanel.getTfPrice().getText());

	            // Format the price string
	            String priceStr = String.format("%.2f", price);

	            // Add the item and price to the table
	            DefaultTableModel model = (DefaultTableModel) viewManagerCreateMenuPanel.getTableCreateMenu().getModel();
	            model.addRow(new Object[] {item, priceStr});
	            
	            // Reset the textfields
	            viewManagerCreateMenuPanel.getTfItem().setText("");
	            viewManagerCreateMenuPanel.getTfPrice().setText("");
	        }
		 
		  // Delete a line
	        if (source == viewManagerCreateMenuPanel.getBtnDeleteItem()) {
	            int selectedRow = viewManagerCreateMenuPanel.getTableCreateMenu().getSelectedRow();
	            DefaultTableModel model = (DefaultTableModel) viewManagerCreateMenuPanel.getTableCreateMenu().getModel();
	            if (selectedRow != -1) { // Check if a row is selected
	                model.removeRow(selectedRow);
	            }
	        }
	        
	        if (source == viewManagerCreateMenuPanel.getBtnCreateMenu()) {
	            // Get the selected restaurant name from the table
	            int selectedRow = viewManagerCreateMenuPanel.getTableRestaurant().getSelectedRow();
	            if (selectedRow == -1) {
	                // If no row is selected, show an error message and return
	                JOptionPane.showMessageDialog(viewManagerCreateMenuPanel, "Please select a restaurant first.");
	                return;
	            }
	            String selectedRestaurantName = viewManagerCreateMenuPanel.getTableRestaurant().getValueAt(selectedRow, 0).toString();

	            // Get the menu items for the selected restaurant from the database
	            Restaurant selectedRestaurant = model.getRestaurantDatabase().getRestaurant(selectedRestaurantName);
	            List<Database.Menu> menuItems = model.getMenuDatabase().getMenuItems(selectedRestaurant);

	            // Clear the existing menu items for the selected restaurant
	            model.getMenuDatabase().deleteMenu(selectedRestaurant);

	            // Get the new menu items from the table and add them to the database
	            List<Database.Menu> newMenuItems = new ArrayList<>();
	            DefaultTableModel createMenuTableModel = (DefaultTableModel) viewManagerCreateMenuPanel.getTableCreateMenu().getModel();
	            int rowCount = createMenuTableModel.getRowCount();
	            for (int i = 0; i < rowCount; i++) {
	                String itemName = createMenuTableModel.getValueAt(i, 0).toString();
	                double price = Double.parseDouble(createMenuTableModel.getValueAt(i, 1).toString());
	                newMenuItems.add(new Database.Menu(itemName, price));
	            }
	            model.getMenuDatabase().addMenuItems(selectedRestaurant, newMenuItems);

	            // Show a success message
	            JOptionPane.showMessageDialog(viewManagerCreateMenuPanel, "Menu updated successfully.");

	            // Clear the table
	            createMenuTableModel.setRowCount(0);
	        }

	}
}
