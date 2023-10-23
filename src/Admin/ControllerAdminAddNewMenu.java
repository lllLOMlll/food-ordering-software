package Admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Database.Restaurant;
import Model.Model;

public class ControllerAdminAddNewMenu implements ActionListener {
	private Model model;
    private ViewAdminAddNewMenuPanel viewAdminAddNewMenuPanel;
    private ControllerAdmin controllerAdmin;
	
    public ControllerAdminAddNewMenu(Model model, ViewAdminAddNewMenuPanel viewAdminAddNewMenuPanel, ControllerAdmin controllerAdmin) {
        this.model = model;
        this.viewAdminAddNewMenuPanel = viewAdminAddNewMenuPanel;
        this.controllerAdmin = controllerAdmin;
        
        // Adding the buttons
        viewAdminAddNewMenuPanel.getBtnSelect().addActionListener(this);
        viewAdminAddNewMenuPanel.getBtnCreateMenu().addActionListener(this);
        viewAdminAddNewMenuPanel.getBtnAddItem().addActionListener(this);
        viewAdminAddNewMenuPanel.getBtnDeleteLine().addActionListener(this);
    }
	
	
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == viewAdminAddNewMenuPanel.getBtnSelect()) {
            // Get the selected restaurant name from the table
            int selectedRow = viewAdminAddNewMenuPanel.getTableRestaurant().getSelectedRow();
            if (selectedRow == -1) {
                // If no row is selected, show an error message and return
                JOptionPane.showMessageDialog(viewAdminAddNewMenuPanel, "Please select a restaurant first.");
                return;
            }
            String selectedRestaurantName = viewAdminAddNewMenuPanel.getTableRestaurant().getValueAt(selectedRow, 0).toString();

            // Get the menu items for the selected restaurant from the database
            Restaurant selectedRestaurant = model.getRestaurantDatabase().getRestaurant(selectedRestaurantName);
            List<Database.Menu> menuItems = model.getMenuDatabase().getMenuItems(selectedRestaurant);
        }
        
        if (source == viewAdminAddNewMenuPanel.getBtnAddItem()) {
            // Get the text from tfItem and tfPrice
            String item = viewAdminAddNewMenuPanel.getTfItem().getText();
            double price = Double.parseDouble(viewAdminAddNewMenuPanel.getTfPrice().getText());

            // Format the price string
            String priceStr = String.format("%.2f", price);

            // Add the item and price to the table
            DefaultTableModel model = (DefaultTableModel) viewAdminAddNewMenuPanel.getTableCreateMenu().getModel();
            model.addRow(new Object[] {item, priceStr});
            
            // Reset the textfields
            viewAdminAddNewMenuPanel.getTfItem().setText("");
            viewAdminAddNewMenuPanel.getTfPrice().setText("");
        }
        
        // Delete a line
        if (source == viewAdminAddNewMenuPanel.getBtnDeleteLine()) {
            int selectedRow = viewAdminAddNewMenuPanel.getTableCreateMenu().getSelectedRow();
            DefaultTableModel model = (DefaultTableModel) viewAdminAddNewMenuPanel.getTableCreateMenu().getModel();
            if (selectedRow != -1) { // Check if a row is selected
                model.removeRow(selectedRow);
            }
        }
        
        if (source == viewAdminAddNewMenuPanel.getBtnCreateMenu()) {
            // Get the selected restaurant name from the table
            int selectedRow = viewAdminAddNewMenuPanel.getTableRestaurant().getSelectedRow();
            if (selectedRow == -1) {
                // If no row is selected, show an error message and return
                JOptionPane.showMessageDialog(viewAdminAddNewMenuPanel, "Please select a restaurant first.");
                return;
            }
            String selectedRestaurantName = viewAdminAddNewMenuPanel.getTableRestaurant().getValueAt(selectedRow, 0).toString();

            // Get the menu items for the selected restaurant from the database
            Restaurant selectedRestaurant = model.getRestaurantDatabase().getRestaurant(selectedRestaurantName);
            List<Database.Menu> menuItems = model.getMenuDatabase().getMenuItems(selectedRestaurant);

            // Clear the existing menu items for the selected restaurant
            model.getMenuDatabase().deleteMenu(selectedRestaurant);

            // Get the new menu items from the table and add them to the database
            List<Database.Menu> newMenuItems = new ArrayList<>();
            DefaultTableModel createMenuTableModel = (DefaultTableModel) viewAdminAddNewMenuPanel.getTableCreateMenu().getModel();
            int rowCount = createMenuTableModel.getRowCount();
            for (int i = 0; i < rowCount; i++) {
                String itemName = createMenuTableModel.getValueAt(i, 0).toString();
                double price = Double.parseDouble(createMenuTableModel.getValueAt(i, 1).toString());
                newMenuItems.add(new Database.Menu(itemName, price));
            }
            model.getMenuDatabase().addMenuItems(selectedRestaurant, newMenuItems);

            // Show a success message
            JOptionPane.showMessageDialog(viewAdminAddNewMenuPanel, "Menu updated successfully.");

            // Clear the table
            createMenuTableModel.setRowCount(0);
        }




    }
}
