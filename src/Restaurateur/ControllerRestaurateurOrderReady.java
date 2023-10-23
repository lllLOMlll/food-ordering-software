package Restaurateur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Client.ControllerClient;
import Database.Order;
import Model.Model;

public class ControllerRestaurateurOrderReady implements ActionListener {
	private Model model;
	private ViewRestaurateurOrderReadyPanel viewRestaurateurOrderReadyPanel;
	private ControllerRestaurateur controllerRestaurateur;

	public ControllerRestaurateurOrderReady(Model model,
			ViewRestaurateurOrderReadyPanel viewRestaurateurOrderReadyPanel,
			ControllerRestaurateur controllerRestaurateur) {
		this.model = model;
		this.viewRestaurateurOrderReadyPanel = viewRestaurateurOrderReadyPanel;
		this.controllerRestaurateur = controllerRestaurateur;

		// Adding the buttons
		viewRestaurateurOrderReadyPanel.getBtnSelectOrderReady().addActionListener(this);
		viewRestaurateurOrderReadyPanel.getBtnOrderReady().addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();

		// Select and display an order
		if (source == viewRestaurateurOrderReadyPanel.getBtnSelectOrderReady()) {
			// Get the selected order ID from the JTable
			int rowIndex = viewRestaurateurOrderReadyPanel.getTablePendingOrder().getSelectedRow();
			if (rowIndex < 0) {
				// No order selected
				return;
			}
			String orderId = (String) viewRestaurateurOrderReadyPanel.getTablePendingOrder().getValueAt(rowIndex, 0);

			// Retrieve the selected order from the database
			Order order = model.getDatabaseOrder().getOrder(orderId);
			if (order == null) {
				// Order not found in database
				return;
			}

			// Display the delivery time (date and hour) and postal code in the appropriate
			// fields
			viewRestaurateurOrderReadyPanel.getFrmtdtxtfDeliveryTimeyyymmdd().setText(order.getDeliveryDate());
			viewRestaurateurOrderReadyPanel.getFrmtdtxtfDeliveryTimeHour().setText(order.getDeliveryTime());
			viewRestaurateurOrderReadyPanel.getFrmtdtxtfPostalCode().setText(order.getPostalCode());

			// Display the items of the selected order in the table
			DefaultTableModel tableModel = (DefaultTableModel) viewRestaurateurOrderReadyPanel.getTableMealInOrder()
					.getModel();
			tableModel.setRowCount(0);
			for (Order.OrderItem item : order.getItems().values()) {
				Object[] row = { item.getItemName(), item.getPrice(), item.getQuantity() };
				tableModel.addRow(row);

			}
		}

		// Mark an order as ready
		if (source == viewRestaurateurOrderReadyPanel.getBtnOrderReady()) {
			// Get the selected order ID from the JTable
			int rowIndex = viewRestaurateurOrderReadyPanel.getTablePendingOrder().getSelectedRow();
			if (rowIndex < 0) {
				// No order selected
				return;
			}
			String orderId = (String) viewRestaurateurOrderReadyPanel.getTablePendingOrder().getValueAt(rowIndex, 0);

			// Retrieve the selected order from the database
			Order order = model.getDatabaseOrder().getOrder(orderId);
			if (order == null) {
				// Order not found in database
				return;
			}

			// Display a confirmation dialog with order information
			String message = "You are confirming that this order is ready?\n\n";
			message += "Order ID: " + order.getOrderId() + "\n";
			message += "Client: " + order.getClientUsername() + "\n";
			message += "Delivery Date: " + order.getDeliveryDate() + "\n";
			message += "Delivery Time: " + order.getDeliveryTime() + "\n";
			message += "Postal Code: " + order.getPostalCode() + "\n";
			message += "Restaurant: " + order.getRestaurant().getName() + "\n";

			int response = JOptionPane.showConfirmDialog(null, message, "Confirm Accept Order",
					JOptionPane.YES_NO_OPTION);

			if (response == JOptionPane.YES_OPTION) {
				// Changing the status of the order
				model.getDatabaseOrder().getOrder(orderId).setDeliveryManPending(true);

				// Removing the order from the table
				DefaultTableModel tableModel = (DefaultTableModel) viewRestaurateurOrderReadyPanel
						.getTablePendingOrder().getModel();
				tableModel.removeRow(rowIndex);
				
				// Removing the data displayed of that order
				viewRestaurateurOrderReadyPanel.getFrmtdtxtfDeliveryTimeyyymmdd().setText("");
				viewRestaurateurOrderReadyPanel.getFrmtdtxtfDeliveryTimeHour().setText("");
				viewRestaurateurOrderReadyPanel.getFrmtdtxtfPostalCode().setText("");
				
				// Removing the meals in the order
				DefaultTableModel mealTableModel = (DefaultTableModel) viewRestaurateurOrderReadyPanel.getTableMealInOrder().getModel();
				mealTableModel.setRowCount(0);
			}
		}
	}

}
