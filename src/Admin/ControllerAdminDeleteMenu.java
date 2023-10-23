package Admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Database.Restaurant;
import Model.Model;

public class ControllerAdminDeleteMenu implements ActionListener {
	private Model model;
    private ViewAdminDeleteMenuPanel viewAdminDeleteMenuPanel;
    private ControllerAdmin controllerAdmin;
    ControllerAdminDeleteMenu(Model model, ViewAdminDeleteMenuPanel viewAdminDeleteMenuPanel, ControllerAdmin controllerAdmin) {
        this.model = model;
        this.viewAdminDeleteMenuPanel = viewAdminDeleteMenuPanel;
        this.controllerAdmin = controllerAdmin;
        
        // Adding the buttons
        viewAdminDeleteMenuPanel.getBtnSelect().addActionListener(this);
        viewAdminDeleteMenuPanel.getBtnDeleteMenu().addActionListener(this);
    }
	

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == viewAdminDeleteMenuPanel.getBtnSelect()) {
            // Get the selected restaurant name from the table
            int selectedRow = viewAdminDeleteMenuPanel.getTableRestaurant().getSelectedRow();
            if (selectedRow == -1) {
                // If no row is selected, show an error message and return
                JOptionPane.showMessageDialog(viewAdminDeleteMenuPanel, "Please select a restaurant first.");
                return;
            }
            String selectedRestaurantName = viewAdminDeleteMenuPanel.getTableRestaurant().getValueAt(selectedRow, 0).toString();

            // Get the menu items for the selected restaurant from the database
            Restaurant selectedRestaurant = model.getRestaurantDatabase().getRestaurant(selectedRestaurantName);
            List<Database.Menu> menuItems = model.getMenuDatabase().getMenuItems(selectedRestaurant);

            // Clear the table model and add the menu items to the table
            DefaultTableModel menuTableModel = (DefaultTableModel) viewAdminDeleteMenuPanel.getTableCreateMenu().getModel();
            menuTableModel.setRowCount(0);
            for (Database.Menu menuItem : menuItems) {
                Object[] rowData = {menuItem.getItemName(), menuItem.getPrice()};
                menuTableModel.addRow(rowData);
            }
        }

        // Delete Menu
        if (source == viewAdminDeleteMenuPanel.getBtnDeleteMenu()) {
            // Get the selected restaurant name from the table
            int selectedRow = viewAdminDeleteMenuPanel.getTableRestaurant().getSelectedRow();
            if (selectedRow == -1) {
                // If no row is selected, show an error message and return
                JOptionPane.showMessageDialog(viewAdminDeleteMenuPanel, "Please select a restaurant first.");
                return;
            }
            String selectedRestaurantName = viewAdminDeleteMenuPanel.getTableRestaurant().getValueAt(selectedRow, 0).toString();

            // Get the selected restaurant from the database and delete its menu
            Restaurant selectedRestaurant = model.getRestaurantDatabase().getRestaurant(selectedRestaurantName);
            model.getMenuDatabase().deleteMenu(selectedRestaurant);

            // Clear the table model
            DefaultTableModel menuTableModel = (DefaultTableModel) viewAdminDeleteMenuPanel.getTableCreateMenu().getModel();
            menuTableModel.setRowCount(0);

            // Show a success message
            JOptionPane.showMessageDialog(viewAdminDeleteMenuPanel, "Menu deleted successfully.");
        }

    
    
    }
}

