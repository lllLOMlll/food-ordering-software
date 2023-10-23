package DeliveryMan;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Client.ControllerClient;
import Client.ViewClientEditAccountPanel;
import Database.Order;
import Database.User;
import Model.Model;

public class ControllerDeliveryManViewDelivery implements ActionListener{
	private Model model;
    private ViewDeliveryManViewDeliveryPanel viewDeliveryManViewDeliveryPanel;
    private ControllerDeliveryMan controllerDeliveryMan;
	
    public ControllerDeliveryManViewDelivery(Model model, ViewDeliveryManViewDeliveryPanel viewDeliveryManViewDeliveryPanel, ControllerDeliveryMan controllerDeliveryMan) {
        this.model = model;
        this.viewDeliveryManViewDeliveryPanel = viewDeliveryManViewDeliveryPanel;
        this.controllerDeliveryMan = controllerDeliveryMan;
    
        // Adding the buttons
        viewDeliveryManViewDeliveryPanel.getBtnCompleteConsultation().addActionListener(this);
        
        
    }
	@Override
	public void actionPerformed(ActionEvent e) {
	Object source = e.getSource();
	
	if (source == viewDeliveryManViewDeliveryPanel.getBtnCompleteConsultation()) {
			// Get the selected order ID from the JTable
			int rowIndex = viewDeliveryManViewDeliveryPanel.getTableOrder().getSelectedRow();
			if (rowIndex < 0) {
				// No order selected
				return;
			}
			String orderId = (String) viewDeliveryManViewDeliveryPanel.getTableOrder().getValueAt(rowIndex, 0);

			// Retrieve the selected order from the database
			Order order = model.getDatabaseOrder().getOrder(orderId);
			if (order == null) {
				// Order not found in database
				return;
			}
			
			// Get the data to display
			String restaurant = order.getRestaurant().getName();
			String clientUsername = order.getClientUsername();
			// The address of the user is not in the order database but in the user database
			User user = model.getDatabaseUser().getUser(clientUsername);
			String address = user.getAddress();
			String postalCode = order.getPostalCode();
			
			// Display the data
			viewDeliveryManViewDeliveryPanel.setLabelOrderNumberText("Order: " + orderId);
			viewDeliveryManViewDeliveryPanel.setLabelRestaurantText("Restaurant: " + restaurant);
			viewDeliveryManViewDeliveryPanel.setLabeleliveryAddressText("Address: " + address);
			viewDeliveryManViewDeliveryPanel.setLabelDeliveryPostalCodeText("Postal code: " + postalCode);
	}
		
	}

}
