package DeliveryMan;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.Model;

public class ControllerDeliveryManMade implements ActionListener{
	private Model model;
    private ViewDeliveryMadePanel viewDeliveryMadePanel;
    private ControllerDeliveryMan controllerDeliveryMan;
	
    public ControllerDeliveryManMade(Model model, ViewDeliveryMadePanel viewDeliveryMadePanelPanel, ControllerDeliveryMan controllerDeliveryMan) {
        this.model = model;
        this.viewDeliveryMadePanel = viewDeliveryMadePanelPanel;
        this.controllerDeliveryMan = controllerDeliveryMan;
    
        // Adding the buttons
//      viewAdminEditRestaurantPanel.getBtnSelect().addActionListener(this);
        
        
    }
    
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
