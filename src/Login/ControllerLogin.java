package Login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import Admin.ControllerAdmin;
import Admin.ViewAdminFrame;
import Client.ControllerClient;
import Client.ControllerOpenNewAccount;
import Client.ViewClientFrame;
import Client.ViewClientOrderHistoryPanel;
import Client.ViewOpenNewAccountFrame;
import Database.User;
import Database.DatabaseUser;
import DeliveryMan.ControllerDeliveryMan;
import DeliveryMan.ViewDeliveryManFrame;
import Manager.ControllerManager;
import Manager.ViewManagerFrame;
import Model.Model;
import Restaurateur.ControllerRestaurateur;
import Restaurateur.ViewRestaurateurFrame;

public class ControllerLogin implements ActionListener {
	// Creating private variable of my Model
	private Model model;
	// Creating private variables for the Frame and Panel of my controller
	private ViewLoginFrame viewLoginFrame;
	private ViewLoginPanel viewLoginPanel;
	// Creating a private variable Database (to identify the user and his access
	// level)
	private DatabaseUser databaseUser;
	// Creating private variables for the Frame and Panel to which my Controller
	// connect
	private ViewAdminFrame viewAdminFrame;
	private ViewClientFrame viewClientFrame;
	private ViewManagerFrame viewManagerFrame;
	private ViewDeliveryManFrame viewDeliveryManFrame;
	private ViewRestaurateurFrame viewRestaurateurFrame;
	private ViewOpenNewAccountFrame viewOpenNewAccountFrame;

	// Creating private variables to other Controllers to which the ControllerLogin
	// connects
	private ControllerOpenNewAccount controllerOpenNewAccount;
	private ControllerAdmin controllerAdmin;
	private ControllerClient controllerClient;
	private ControllerDeliveryMan controllerDeliveryMan;
	private ControllerManager controllerManager;
	private ControllerRestaurateur controllerRestaurateur;
	
	private ViewClientOrderHistoryPanel viewClientOrderHistoryPanel;
	

	public ControllerLogin(Model model, ViewLoginFrame viewLoginFrame) {
		this.model = model;
		this.viewLoginFrame = viewLoginFrame;
	
	

		// Creating a instance of the Frames connecting to the LoginFrame
		viewLoginPanel = new ViewLoginPanel();
		viewOpenNewAccountFrame = new ViewOpenNewAccountFrame();
		viewAdminFrame = new ViewAdminFrame();
		viewClientFrame = new ViewClientFrame();
		viewDeliveryManFrame = new ViewDeliveryManFrame();
		viewManagerFrame = new ViewManagerFrame();
		viewRestaurateurFrame = new ViewRestaurateurFrame();

		// Creating an instance of the controllers
		controllerOpenNewAccount = new ControllerOpenNewAccount(model, viewOpenNewAccountFrame, this);
		controllerAdmin = new ControllerAdmin(model, viewAdminFrame, this, controllerManager);
		controllerClient = new ControllerClient(model, viewClientFrame, this, controllerAdmin);
		controllerDeliveryMan = new ControllerDeliveryMan(model, viewDeliveryManFrame, this, controllerAdmin);
		controllerManager = new ControllerManager(model, viewManagerFrame, this, controllerAdmin);
		controllerRestaurateur = new ControllerRestaurateur(model, viewRestaurateurFrame, this, controllerAdmin);

		
		
		// Adding the panel to the frame
		viewLoginFrame.setNewPanel(viewLoginPanel);

		// Adding the buttons
		viewLoginPanel.getBtnLogIn().addActionListener(this);
		viewLoginPanel.getBtnSignUp().addActionListener(this);

	}

	// Assuring that the user is showed the "Welcome" panel instead of the last panel consulted.
	@Override
	public void actionPerformed(ActionEvent e) {
		if ((JButton) e.getSource() == viewLoginPanel.getBtnLogIn()) {
			String username = viewLoginPanel.getTextUsername().getText();
			char[] password = viewLoginPanel.getPasswordField().getPassword();
			
			User user = model.getUserDatabase().getUser(username);

			if (user != null && user.getPassword().equals(new String(password))) {
				System.out.println("Welcome " + user.getFirstName() + "!");

				switch (user.getAccessLevel()) {
				case "admin":
					viewAdminFrame.setVisible(true);
					model.setCurrentUser(user);
					
					controllerAdmin.getViewAdminFrame().setNewPanelAdmin(controllerAdmin.getViewAdminPanel());
					break;
				case "client":
					viewClientFrame.setVisible(true);
					model.setCurrentUser(user);
//					viewClientOrderHistoryPanel.populateOrderTable();
					controllerClient.getViewClientFrame().setNewPanelClient(controllerClient.getViewClientPanel());
					
					break;
				case "delivery":
					viewDeliveryManFrame.setVisible(true);
					model.setCurrentUser(user);
					controllerDeliveryMan.getViewDeliveryManFrame().setNewPanelDeliveryMan(controllerDeliveryMan.getViewDeliveryManPanel());
					break;
				case "manager":
					viewManagerFrame.setVisible(true);
					model.setCurrentUser(user);
					controllerManager.getViewManagerFrame().setNewPanelManager(controllerManager.getViewManagerPanel());
					break;
				case "restaurateur":
					viewRestaurateurFrame.setVisible(true);
					model.setCurrentUser(user);
					controllerRestaurateur.getViewRestaurateurFrame().setNewPanelRestaurateur(controllerRestaurateur.getViewRestaurateurPanel());
					break;
				default:
					System.out.println("Invalid access level!");
					break;
				}

				// Reset the text fields
				viewLoginFrame.setVisible(false);
				viewLoginPanel.getTextUsername().setText("");
				viewLoginPanel.getPasswordField().setText("");
			} else {
				JOptionPane.showMessageDialog(viewLoginFrame, "Invalid username or password!", "Error",
						JOptionPane.ERROR_MESSAGE);
				viewLoginPanel.getTextUsername().setText("");
				viewLoginPanel.getPasswordField().setText("");
			}
		// Reset texfield and show Open New Account frame
		} else if ((JButton) e.getSource() == viewLoginPanel.getBtnSignUp()) {
			viewLoginPanel.getTextUsername().setText("");
			viewLoginPanel.getPasswordField().setText("");
			viewLoginFrame.setVisible(false);
			viewOpenNewAccountFrame.setVisible(true);

		}
	}

	public ViewLoginFrame getViewLoginFrame() {
		return viewLoginFrame;
	}

	public ViewLoginPanel getViewLoginPanel() {
		return viewLoginPanel;
	}

}
