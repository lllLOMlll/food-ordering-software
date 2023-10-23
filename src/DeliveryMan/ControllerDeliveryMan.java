package DeliveryMan;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import Admin.ControllerAdmin;
import Admin.ViewAdminFrame;
import Admin.ViewAdminPanel;
import Client.ControllerClientEditAccount;
import Client.ViewClientFrame;
import Database.DatabaseUser;
import Database.User;
import Login.ControllerLogin;
import Model.Model;

public class ControllerDeliveryMan implements ActionListener {
	// Creating private variable of my Model
	private Model model;
	// Creating private variable for the Frame my Controller
	private ViewDeliveryManFrame viewDeliveryManFrame;
	// Creating private variables for the Panels of my Controller
	private ViewDeliveryManPanel viewDeliveryManPanel;
	private ViewDeliveryManViewDeliveryPanel viewDeliveryManViewDeliveryPanel;
	private ViewAcceptingDeliveryPanel viewAcceptingDeliveryPanel;
	private ViewDeliveryMadePanel ViewDeliveryMadePanel;
	// Creating private variables to other Controllers to which the ControllerLogin
	// connects
	private ControllerLogin controllerLogin;
	private ControllerAdmin controllerAdmin;
	// Creating a private variable Database (to identify the user and his access
	// level)
	private DatabaseUser databaseUser;
	private User currentUser;

	public ControllerDeliveryMan(Model model, ViewDeliveryManFrame viewDeliveryManFrame,
			ControllerLogin controllerLogin, ControllerAdmin controllerAdmin) {
		this.model = model;
		this.viewDeliveryManFrame = viewDeliveryManFrame;
		this.controllerLogin = controllerLogin;

		// Creating the panels for the Delivery Man
		viewDeliveryManPanel = new ViewDeliveryManPanel();
		viewDeliveryManViewDeliveryPanel = controllerAdmin.getViewDeliveryManViewDeliveryPanel();
		viewAcceptingDeliveryPanel = controllerAdmin.getViewAcceptingDeliveryPanel();
		ViewDeliveryMadePanel = controllerAdmin.getViewDeliveryMadePanel();
		
		// Adding the controllers
		ControllerDeliveryManViewDelivery controllerDeliveryManViewDelivery  = new ControllerDeliveryManViewDelivery(model, viewDeliveryManViewDeliveryPanel, this);
		ControllerDeliveryManAccepting controllerDeliveryManAccepting = new ControllerDeliveryManAccepting(model, viewAcceptingDeliveryPanel, this);
		ControllerDeliveryManMade controllerDeliveryManMade = new ControllerDeliveryManMade(model, ViewDeliveryMadePanel, this);

		// Adding the panel to the frame
		viewDeliveryManFrame.setNewPanelDeliveryMan(viewDeliveryManPanel);

		// Assign actions to buttons
		viewDeliveryManFrame.getQuitFileMenu().addActionListener(this);
		viewDeliveryManFrame.getDisconnectFileMenu().addActionListener(this);

		// Assign actions to JMenuItem - ADMIN FRAME
				viewDeliveryManFrame.getDisconnectFileMenu().addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						JOptionPane.showMessageDialog(null, "See you soon!", "Disconnecting", JOptionPane.INFORMATION_MESSAGE);
						viewDeliveryManFrame.setVisible(false);
						controllerLogin.getViewLoginFrame().setVisible(true);
						controllerLogin.getViewLoginFrame().setNewPanel(controllerLogin.getViewLoginPanel());

					}
				});

				viewDeliveryManFrame.getQuitFileMenu().addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						JOptionPane.showMessageDialog(null, "Thank you for using a MajorSofware product", "Exit",
								JOptionPane.INFORMATION_MESSAGE);
						System.exit(0);

					}
				});
				
				viewDeliveryManFrame.getViewDeliveriesMenuItem().addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						viewDeliveryManFrame.setContentPane(viewDeliveryManViewDeliveryPanel);
						viewDeliveryManViewDeliveryPanel.populateDeliveryTable();
		
					}
				});
				
				viewDeliveryManFrame.getAcceptDeliveriesMenuItem().addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						viewDeliveryManFrame.setContentPane(viewAcceptingDeliveryPanel);
						viewAcceptingDeliveryPanel.populateDeliveryTable();
						
					}
				});
				
				viewDeliveryManFrame.getEndDeliveriesMenuItem().addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						viewDeliveryManFrame.setContentPane(ViewDeliveryMadePanel);
						ViewDeliveryMadePanel.populateDeliveryTable();
					}
				});
				
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	
		
	}
	
	public ViewDeliveryManFrame getViewDeliveryManFrame() {
		return viewDeliveryManFrame;
	}

	public ViewDeliveryManPanel getViewDeliveryManPanel() {
		return viewDeliveryManPanel;
	}
	
	public User getCurrentUser() {
	    return currentUser;
	}

	public void setCurrentUser(User currentUser) {
	    this.currentUser = currentUser;
	}
}
