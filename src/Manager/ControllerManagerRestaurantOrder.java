package Manager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Database.Order;
import Database.Restaurant;
import DeliveryMan.ControllerDeliveryMan;
import DeliveryMan.ViewDeliveryMadePanel;
import Model.Model;

public class ControllerManagerRestaurantOrder implements ActionListener {
	private Model model;
	private ViewManagerRestaurantOrderPanel viewManagerRestaurantOrderPanel;
	private ControllerManager controllerManager;

	public ControllerManagerRestaurantOrder(Model model,
			ViewManagerRestaurantOrderPanel viewManagerRestaurantOrderPanel, ControllerManager controllerManager) {
		this.model = model;
		this.viewManagerRestaurantOrderPanel = viewManagerRestaurantOrderPanel;
		this.controllerManager = controllerManager;

		// Adding the buttons
		viewManagerRestaurantOrderPanel.getBtnSelectRestaurant().addActionListener(this);
		viewManagerRestaurantOrderPanel.getBtnSelectRestaurantsOrder().addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
	    Object source = e.getSource();

	    // Select the Restaurant
	    if (source == viewManagerRestaurantOrderPanel.getBtnSelectRestaurant()) {
	        int selectedRow = viewManagerRestaurantOrderPanel.getTableRestaurant().getSelectedRow();
	        if (selectedRow == -1) {
	            // If no row is selected, show an error message and return
	            JOptionPane.showMessageDialog(viewManagerRestaurantOrderPanel, "Please select a restaurant first.");
	            return;
	        }
	        // The manager can edit the menu of his restaurant only
	        String selectedRestaurantName = viewManagerRestaurantOrderPanel.getTableRestaurant()
	                .getValueAt(selectedRow, 0).toString();
	        if (!selectedRestaurantName.equalsIgnoreCase(model.getCurrentUser().getRestaurantName())) {
	            JOptionPane.showMessageDialog(viewManagerRestaurantOrderPanel,
	                    "You can only see the orders of your restaurant", "Error", JOptionPane.ERROR_MESSAGE);
	            return;
	        }

	        // Retrieve the orders of the selected restaurant from the database
	        HashMap<String, Order> allOrders = model.getDatabaseOrder().getOrders();
	        DefaultTableModel tableModel = (DefaultTableModel) viewManagerRestaurantOrderPanel.getTableRestaurantsOrder().getModel();

	        // Clear the current orders from the JTable
	        tableModel.setRowCount(0);

	        // Populate the JTable with orders associated with the selected restaurant
	        for (Order order : allOrders.values()) {
	            if (order.getRestaurant().getName().equals(selectedRestaurantName)) {
	                tableModel.addRow(new Object[] { order.getOrderId() });
	            }
	        }
	    }
		
		// Select the Order
		if (source == viewManagerRestaurantOrderPanel.getBtnSelectRestaurantsOrder()) {
		
			// Get the selected order ID from the JTable
			int rowIndex = viewManagerRestaurantOrderPanel.getTableRestaurantsOrder().getSelectedRow();
			if (rowIndex < 0) {
				// No order selected
				return;
			}
			String orderId = (String) viewManagerRestaurantOrderPanel.getTableRestaurantsOrder().getValueAt(rowIndex, 0);

			// Retrieve the selected order from the database
			Order order = model.getDatabaseOrder().getOrder(orderId);
			if (order == null) {
				// Order not found in database
				return;
			}

			// Display the delivery time (date and hour) and postal code in the appropriate
			// fields
			viewManagerRestaurantOrderPanel.getFrmtdtxtfDeliveryTimeyyymmdd().setText(order.getDeliveryDate());
			viewManagerRestaurantOrderPanel.getFrmtdtxtfDeliveryTimeHour().setText(order.getDeliveryTime());
			viewManagerRestaurantOrderPanel.getFrmtdtxtfPostalCode().setText(order.getPostalCode());

			// Display the items of the selected order in the table
			DefaultTableModel tableModel = (DefaultTableModel) viewManagerRestaurantOrderPanel.getTableMealInOrder()
					.getModel();
			tableModel.setRowCount(0);
			for (Order.OrderItem item : order.getItems().values()) {
				Object[] row = { item.getItemName(), item.getPrice(), item.getQuantity() };
				tableModel.addRow(row);

			}
		}
	}

}
