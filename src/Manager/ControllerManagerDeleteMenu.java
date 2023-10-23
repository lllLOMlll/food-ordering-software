package Manager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Admin.ControllerAdmin;
import Database.Restaurant;
import Model.Model;

public class ControllerManagerDeleteMenu implements ActionListener {
	private Model model;
    private ViewManagerDeleteMenuPanel viewManagerDeleteMenuPanel;
    private ControllerManager controllerManager;
	
    public ControllerManagerDeleteMenu(Model model, ViewManagerCreateMenuPanel viewManagerCreateMenuPanel, ControllerManager controllerManager, ViewManagerDeleteMenuPanel viewManagerDeleteMenuPanel) {
        this.model = model;
        this.viewManagerDeleteMenuPanel = viewManagerDeleteMenuPanel;
        this.controllerManager = controllerManager;
    
        // Adding the buttons
        viewManagerDeleteMenuPanel.getBtnSelect().addActionListener(this);
        viewManagerDeleteMenuPanel.getBtnDeleteMenu().addActionListener(this);
      
        
        
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == viewManagerDeleteMenuPanel.getBtnSelect()) {
            // Get the selected restaurant name from the table
            int selectedRow = viewManagerDeleteMenuPanel.getTableRestaurant().getSelectedRow();
            if (selectedRow == -1) {
                // If no row is selected, show an error message and return
                JOptionPane.showMessageDialog(viewManagerDeleteMenuPanel, "Please select a restaurant first.");
                return;
            }
            
            // Manager can delete the menu of his restaurant only
            String selectedRestaurantName = viewManagerDeleteMenuPanel.getTableRestaurant().getValueAt(selectedRow, 0).toString();
            if (!selectedRestaurantName.equalsIgnoreCase(model.getCurrentUser().getRestaurantName())) {
			    JOptionPane.showMessageDialog(viewManagerDeleteMenuPanel, "You can modify the menu of your restaurant only", "Error", JOptionPane.ERROR_MESSAGE);
			    return;
			}
            // Get the menu items for the selected restaurant from the database
            Restaurant selectedRestaurant = model.getRestaurantDatabase().getRestaurant(selectedRestaurantName);
            List<Database.Menu> menuItems = model.getMenuDatabase().getMenuItems(selectedRestaurant);

            // Clear the table model and add the menu items to the table
            DefaultTableModel menuTableModel = (DefaultTableModel) viewManagerDeleteMenuPanel.getTableCreateMenu().getModel();
            menuTableModel.setRowCount(0);
            for (Database.Menu menuItem : menuItems) {
                Object[] rowData = {menuItem.getItemName(), menuItem.getPrice()};
                menuTableModel.addRow(rowData);
            }
        }

        // Delete Menu
        if (source == viewManagerDeleteMenuPanel.getBtnDeleteMenu()) {
            // Get the selected restaurant name from the table
            int selectedRow = viewManagerDeleteMenuPanel.getTableRestaurant().getSelectedRow();
            if (selectedRow == -1) {
                // If no row is selected, show an error message and return
                JOptionPane.showMessageDialog(viewManagerDeleteMenuPanel, "Please select a restaurant first.");
                return;
            }
            String selectedRestaurantName = viewManagerDeleteMenuPanel.getTableRestaurant().getValueAt(selectedRow, 0).toString();

            // Get the selected restaurant from the database and delete its menu
            Restaurant selectedRestaurant = model.getRestaurantDatabase().getRestaurant(selectedRestaurantName);
            model.getMenuDatabase().deleteMenu(selectedRestaurant);

            // Clear the table model
            DefaultTableModel menuTableModel = (DefaultTableModel) viewManagerDeleteMenuPanel.getTableCreateMenu().getModel();
            menuTableModel.setRowCount(0);

            // Show a success message
            JOptionPane.showMessageDialog(viewManagerDeleteMenuPanel, "Menu deleted successfully.");
        }

    
    
    }
}

