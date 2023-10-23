package DeliveryMan;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Database.Order;
import Database.User;
import Model.Model;

public class ControllerDeliveryManAccepting implements ActionListener {
	private Model model;
	private ViewAcceptingDeliveryPanel viewAcceptingDeliveryPanel;
	private ControllerDeliveryMan controllerDeliveryMan;

	public ControllerDeliveryManAccepting(Model model, ViewAcceptingDeliveryPanel viewAcceptingDeliveryPanel,
			ControllerDeliveryMan controllerDeliveryMan) {
		this.model = model;
		this.viewAcceptingDeliveryPanel = viewAcceptingDeliveryPanel;
		this.controllerDeliveryMan = controllerDeliveryMan;

		// Adding the buttons
		viewAcceptingDeliveryPanel.getBtnAcceptingDelivery().addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
	Object source = e.getSource();
	
	if (source == viewAcceptingDeliveryPanel.getBtnAcceptingDelivery()) {
		int rowIndex = viewAcceptingDeliveryPanel.getTableOrder().getSelectedRow();
		if (rowIndex < 0) {
			// If not order selected stop
			return;
		}
		
		String orderId = (String) viewAcceptingDeliveryPanel.getTableOrder().getValueAt(rowIndex, 0);
		
		Order order = model.getDatabaseOrder().getOrder(orderId);
		
		// Get the data to display
		String restaurant = order.getRestaurant().getName();
		String clientUsername = order.getClientUsername();
		// The address of the user is not in the order database but in the user database
		User user = model.getDatabaseUser().getUser(clientUsername);
		String firstName = model.getDatabaseUser().getUser(clientUsername).getFirstName();
		String lastName = model.getDatabaseUser().getUser(clientUsername).getLastName();
		String address = user.getAddress();
		String postalCode = order.getPostalCode();
		
		// Display a confirmation dialog with order information
		String message = "You are confirming that you are accepting this order?\n\n";
		message += "Order ID: " + orderId + "\n";
		message += "Restaurant: " + restaurant + "\n";
		message += "Client name: " + firstName + " " + lastName + "\n";
		message += "Username: " + clientUsername + "\n";
		message += "Address: " + address + "\n";
		message += "Postal Code: " + postalCode + "\n";
		
		int response = JOptionPane.showConfirmDialog(null, message, "Confirm Accept Order",
				JOptionPane.YES_NO_OPTION);
		
		// If the delivery man accepts the delivery
		if(response == JOptionPane.YES_OPTION) {
			// Set "deliveryManPending" to true
			order.setDeliveryManAccepted(true);
			
			// Remove the order from the table
			DefaultTableModel orderTableModel = (DefaultTableModel) viewAcceptingDeliveryPanel.getTableOrder().getModel();
			orderTableModel.setRowCount(0);	
		}
	
		
	}
		
	}

}
