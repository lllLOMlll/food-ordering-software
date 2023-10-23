package Client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import Admin.ControllerAdmin;
import Admin.ViewAdminAddNewMenuPanel;
import Database.Order;
import Model.Model;

public class ControllerClientOrderHistory implements ActionListener {
	private Model model;
	private ViewClientOrderHistoryPanel viewClientOrderHistoryPanel;
	private ControllerClient controllerClient;

	public ControllerClientOrderHistory(Model model, ViewClientOrderHistoryPanel viewClientOrderHistoryPanel,
			ControllerClient controllerClient) {
		this.model = model;
		this.viewClientOrderHistoryPanel = viewClientOrderHistoryPanel;
		this.controllerClient = controllerClient;

		// Adding the buttons
		viewClientOrderHistoryPanel.getBtnYourOrders().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == viewClientOrderHistoryPanel.getBtnYourOrders()) {
			// Get the selected order ID from the JTable
			int rowIndex = viewClientOrderHistoryPanel.getTableYourOrders().getSelectedRow();
			if (rowIndex < 0) {
				// No order selected
				return;
			}
			String orderId = (String) viewClientOrderHistoryPanel.getTableYourOrders().getValueAt(rowIndex, 0);

			// Retrieve the selected order from the database
			Order order = model.getDatabaseOrder().getOrder(orderId);
			if (order == null) {
				// Order not found in database
				return;
			}

			// Display the delivery time (date and hour) and postal code in the appropriate
			// fields
			viewClientOrderHistoryPanel.getFrmtdtxtfDeliveryTimeyyymmdd().setText(order.getDeliveryDate());
			viewClientOrderHistoryPanel.getFrmtdtxtfDeliveryTimeHour().setText(order.getDeliveryTime());
			viewClientOrderHistoryPanel.getFrmtdtxtfPostalCode().setText(order.getPostalCode());

			// Display the items of the selected order in the table
			DefaultTableModel tableModel = (DefaultTableModel) viewClientOrderHistoryPanel.getTableMealInOrder()
					.getModel();
			tableModel.setRowCount(0);
			for (Order.OrderItem item : order.getItems().values()) {
				Object[] row = { item.getItemName(), item.getPrice(), item.getQuantity() };
				tableModel.addRow(row);

			}

		}
	}
}
