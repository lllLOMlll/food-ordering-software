package Admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Client.ViewClientEditAccountPanel;
import Client.ViewClientOrderFoodPanel;
import Client.ViewClientOrderHistoryPanel;
import Manager.ViewManagerCreateMenuPanel;
import Manager.ViewManagerDeleteMenuPanel;
import Manager.ViewManagerEditDeliveryManPanel;
import Manager.ViewManagerEditMenuPanel;
import Model.Model;

public class ControllerAdminDeleteRestaurant implements ActionListener {
	private Model model;
	private ViewAdminDeleteRestaurantPanel viewAdminDeleteRestaurantPanel;
	private ControllerAdmin controllerAdmin;
	private ViewAdminEditRestaurantPanel viewAdminEditRestaurantPanel;
	private ViewAdminEditMenuPanel viewAdminEditMenuPanel;
	private ViewAdminDeleteMenuPanel viewAdminDeleteMenuPanel;
	private ViewAdminAddNewMenuPanel viewAdminAddNewMenuPanel;

	// Manager
		private ViewManagerCreateMenuPanel viewManagerCreateMenuPanel;
		private ViewManagerEditMenuPanel viewManagerEditMenuPanel;
		private ViewManagerDeleteMenuPanel viewManagerDeleteMenuPanel;
		private ViewManagerEditDeliveryManPanel viewManagerEditDeliveryManPanel;
		
		// Client
		private ViewClientOrderFoodPanel viewClientOrderFoodPanel;
		private ViewClientOrderHistoryPanel viewClientOrderHistoryPanel;
		private ViewClientEditAccountPanel viewClientEditAccountPanel;

	public ControllerAdminDeleteRestaurant(Model model, ViewAdminDeleteRestaurantPanel viewAdminDeleteRestaurantPanel,
			ControllerAdmin controllerAdmin, ViewAdminEditRestaurantPanel viewAdminEditRestaurantPanel, 
			ViewAdminEditMenuPanel viewAdminEditMenuPanel, ViewAdminDeleteMenuPanel viewAdminDeleteMenuPanel,
			ViewAdminAddNewMenuPanel viewAdminAddNewMenuPanel) {
		this.model = model;
		this.viewAdminDeleteRestaurantPanel = viewAdminDeleteRestaurantPanel;
		this.controllerAdmin = controllerAdmin;
		this.viewAdminEditRestaurantPanel = viewAdminEditRestaurantPanel;
		this.viewAdminEditMenuPanel = viewAdminEditMenuPanel;
		this.viewAdminDeleteMenuPanel = viewAdminDeleteMenuPanel;
		this.viewAdminAddNewMenuPanel = viewAdminAddNewMenuPanel;
		// Manager
		this.viewManagerCreateMenuPanel = controllerAdmin.getViewManagerCreateMenuPanel();
		this.viewManagerEditMenuPanel = controllerAdmin.getViewManagerEditMenuPanel();
		this.viewManagerDeleteMenuPanel = controllerAdmin.getViewManagerDeleteMenuPanel();
		// Client
		this.viewClientOrderFoodPanel = controllerAdmin.getViewClientOrderFoodPanel();

		// Adding the buttons
		viewAdminDeleteRestaurantPanel.getBtnDelete().addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == viewAdminDeleteRestaurantPanel.getBtnDelete()) {
			// Get the selected row index
			int rowIndex = viewAdminDeleteRestaurantPanel.getTable().getSelectedRow();
			if (rowIndex >= 0) {
				// Get the name of the restaurant from the selected row
				String restaurantName = (String) viewAdminDeleteRestaurantPanel.getTable().getValueAt(rowIndex, 0);
				// Display a confirmation dialog box
				int option = JOptionPane.showConfirmDialog(null,
						"Are you sure you want to delete the restaurant " + restaurantName + "?");
				if (option == JOptionPane.YES_OPTION) {
					// Remove the restaurant from the database
					model.getRestaurantDatabase().removeRestaurant(restaurantName);
					// Remove the restaurant from the table
					DefaultTableModel tableModel = (DefaultTableModel) viewAdminDeleteRestaurantPanel.getTable()
							.getModel();
					tableModel.removeRow(rowIndex);

					// Update restaurant tables - ADMIN
					viewAdminEditRestaurantPanel.updateTableRestaurant();
					viewAdminEditMenuPanel.updateTableRestaurant();
					viewAdminDeleteMenuPanel.updateTableRestaurant();
					viewAdminAddNewMenuPanel.updateTableRestaurant();
					
					// Update the restaurant table  - Manager
					viewManagerCreateMenuPanel.updateTableRestaurant();
					viewManagerEditMenuPanel.updateTableRestaurant();
					viewManagerDeleteMenuPanel.updateTableRestaurant();
					
					// Update the restaurant table  - Client
					viewClientOrderFoodPanel.updateTableRestaurant();
				}
			}
		}
	}
}