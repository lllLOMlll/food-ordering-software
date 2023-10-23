package Restaurateur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Client.ControllerClient;
import Database.Order;
import Model.Model;

public class ControllerRestaurateurAcceptOrder implements ActionListener {
	private Model model;
	private ViewRestaurateurAcceptOrderPanel viewRestaurateurAcceptOrderPanel;
	private ControllerRestaurateur controllerRestaurateur;

	public ControllerRestaurateurAcceptOrder(Model model,
			ViewRestaurateurAcceptOrderPanel viewRestaurateurAcceptOrderPanel,
			ControllerRestaurateur controllerRestaurateur) {
		this.model = model;
		this.viewRestaurateurAcceptOrderPanel = viewRestaurateurAcceptOrderPanel;
		this.controllerRestaurateur = controllerRestaurateur;

		// Adding the buttons
		viewRestaurateurAcceptOrderPanel.getBtnSelectPendingOrder().addActionListener(this);
		viewRestaurateurAcceptOrderPanel.getBtnAcceptOrder().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();

		// Select an display order in the table
		if (source == viewRestaurateurAcceptOrderPanel.getBtnSelectPendingOrder()) {
			// Get the selected order ID from the JTable
			int rowIndex = viewRestaurateurAcceptOrderPanel.getTablePendingOrder().getSelectedRow();
			if (rowIndex < 0) {
				// No order selected
				return;
			}
			String orderId = (String) viewRestaurateurAcceptOrderPanel.getTablePendingOrder().getValueAt(rowIndex, 0);

			// Retrieve the selected order from the database
			Order order = model.getDatabaseOrder().getOrder(orderId);
			if (order == null) {
				// Order not found in database
				return;
			}

			// Display the delivery time (date and hour) and postal code in the appropriate
			// fields
			viewRestaurateurAcceptOrderPanel.getFrmtdtxtfDeliveryTimeyyymmdd().setText(order.getDeliveryDate());
			viewRestaurateurAcceptOrderPanel.getFrmtdtxtfDeliveryTimeHour().setText(order.getDeliveryTime());
			viewRestaurateurAcceptOrderPanel.getFrmtdtxtfPostalCode().setText(order.getPostalCode());

			// Display the items of the selected order in the table
			DefaultTableModel tableModel = (DefaultTableModel) viewRestaurateurAcceptOrderPanel.getTableMealInOrder()
					.getModel();
			tableModel.setRowCount(0);
			for (Order.OrderItem item : order.getItems().values()) {
				Object[] row = { item.getItemName(), item.getPrice(), item.getQuantity() };
				tableModel.addRow(row);

			}
		}

		// Accept an order
		if (source == viewRestaurateurAcceptOrderPanel.getBtnAcceptOrder()) {
			// Get the selected order ID from the JTable
			int rowIndex = viewRestaurateurAcceptOrderPanel.getTablePendingOrder().getSelectedRow();
			if (rowIndex < 0) {
				// No order selected
				return;
			}
			String orderId = (String) viewRestaurateurAcceptOrderPanel.getTablePendingOrder().getValueAt(rowIndex, 0);

			// Retrieve the selected order from the database
			Order order = model.getDatabaseOrder().getOrder(orderId);
			if (order == null) {
				// Order not found in database
				return;
			}

			// Display a confirmation dialog with order information
			String message = "Are you sure you want to accept the following order?\n\n";
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
				model.getDatabaseOrder().getOrder(orderId).setRestaurateurPending(false);

				// Removing the order from the table
				DefaultTableModel tableModel = (DefaultTableModel) viewRestaurateurAcceptOrderPanel
						.getTablePendingOrder().getModel();
				tableModel.removeRow(rowIndex);

				// Removing the data displayed of that order
				viewRestaurateurAcceptOrderPanel.getFrmtdtxtfDeliveryTimeyyymmdd().setText("");
				viewRestaurateurAcceptOrderPanel.getFrmtdtxtfDeliveryTimeHour().setText("");
				viewRestaurateurAcceptOrderPanel.getFrmtdtxtfPostalCode().setText("");
				
				// Removing the meals in the order
				DefaultTableModel mealTableModel = (DefaultTableModel) viewRestaurateurAcceptOrderPanel.getTableMealInOrder().getModel();
				mealTableModel.setRowCount(0);
			}
		}

	}
}