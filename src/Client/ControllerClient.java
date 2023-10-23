package Client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import Admin.ControllerAdmin;
import Admin.ControllerAdminEditRestaurant;
import Admin.ViewAdminFrame;
import Admin.ViewAdminPanel;
import Database.User;
import Login.ControllerLogin;
import Model.Model;

public class ControllerClient implements ActionListener {
	// Creating private variable of my Model
	private Model model;
	private User currentUser;
	// Creating private variable for the Frame my Controller
	private ViewClientFrame viewClientFrame;
	// Creating private variables for the Panels of my Controller
	private ViewClientPanel viewClientPanel;
	private ViewClientEditAccountPanel viewClientEditAccountPanel;
	private ViewClientDeleteAccountPanel viewClientDeleteAccountPanel;
	private ViewClientOrderFoodPanel viewClientOrderFoodPanel;
	private ViewClientOrderHistoryPanel viewClientOrderHistoryPanel;
	// Creating private variables to other Controllers to which the ControllerLogin
	// connects
	private ControllerLogin controllerLogin;
	private ControllerAdmin controllerAdmin;

	public ControllerClient(Model model, ViewClientFrame viewClientFrame, ControllerLogin controllerLogin,
			ControllerAdmin controllerAdmin) {
		this.model = model;
		this.viewClientFrame = viewClientFrame;
		this.controllerLogin = controllerLogin;
		this.controllerAdmin = controllerAdmin;

		// Creating the panels for the AdminFrame
		viewClientPanel = new ViewClientPanel();
		viewClientEditAccountPanel = controllerAdmin.getViewClientEditAccountPanel();
		viewClientDeleteAccountPanel = new ViewClientDeleteAccountPanel();
		viewClientOrderFoodPanel = controllerAdmin.getViewClientOrderFoodPanel();
		viewClientOrderHistoryPanel = controllerAdmin.getViewClientOrderHistoryPanel();

		// Adding the controllers
		ControllerClientEditAccount controllerClientEditAccount = new ControllerClientEditAccount(model,
				viewClientEditAccountPanel, this);
		ControllerClientDeleteAccount controllerClientDeleteAccount = new ControllerClientDeleteAccount(model,
				viewClientDeleteAccountPanel, this);
		ControllerClientOrderFood controllerClientOrderFood = new ControllerClientOrderFood(model,
				viewClientOrderFoodPanel, this, viewClientOrderHistoryPanel);
		ControllerClientOrderHistory controllerClientOrderHistory = new ControllerClientOrderHistory(model,
				viewClientOrderHistoryPanel, this);

		// Adding the welcome panel to the frame
		viewClientFrame.setContentPane(viewClientPanel);

		// Assign actions to buttons
		viewClientFrame.getQuitFileMenu().addActionListener(this);
		viewClientFrame.getDisconnectFileMenu().addActionListener(this);

		// Assign actions to JMenuItem - RESTAURATEUR FRAME
		viewClientFrame.getDisconnectFileMenu().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "See you soon!", "Disconnecting", JOptionPane.INFORMATION_MESSAGE);
				viewClientFrame.setVisible(false);
				controllerLogin.getViewLoginFrame().setVisible(true);
				controllerLogin.getViewLoginFrame().setNewPanel(controllerLogin.getViewLoginPanel());

			}
		});

		viewClientFrame.getQuitFileMenu().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Thank you for using a MajorSofware product", "Exit",
						JOptionPane.INFORMATION_MESSAGE);
				System.exit(0);

			}
		});

		viewClientFrame.getEditAccount().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				viewClientFrame.setContentPane(viewClientEditAccountPanel);

				// Display data user info
				String clientUsername = model.getCurrentUser().getUsername();
				viewClientEditAccountPanel.getTfUsername().setText(clientUsername);

				String lastName = model.getCurrentUser().getLastName();
				viewClientEditAccountPanel.getTfLastName().setText(lastName);

				String firstName = model.getCurrentUser().getFirstName();
				viewClientEditAccountPanel.getTfFirstName().setText(firstName);

				String address = model.getCurrentUser().getAddress();
				viewClientEditAccountPanel.getTfAddress().setText(address);

				String email = model.getCurrentUser().getEmail();
				viewClientEditAccountPanel.getTfEmail().setText(email);

				String phoneNumber = model.getCurrentUser().getPhoneNumber();
				viewClientEditAccountPanel.getFtfPhoneNumber_1().setText(phoneNumber);

			}
		});

		viewClientFrame.getDeleteAccount().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				viewClientFrame.setContentPane(viewClientDeleteAccountPanel);
				// Display data user info
				String clientUsername = model.getCurrentUser().getUsername();
				viewClientDeleteAccountPanel.getTfUsername().setText(clientUsername);

				String lastName = model.getCurrentUser().getLastName();
				viewClientDeleteAccountPanel.getTfLastName().setText(lastName);

				String firstName = model.getCurrentUser().getFirstName();
				viewClientDeleteAccountPanel.getTfFirstName().setText(firstName);

				String address = model.getCurrentUser().getAddress();
				viewClientDeleteAccountPanel.getTfAddress().setText(address);

				String email = model.getCurrentUser().getEmail();
				viewClientDeleteAccountPanel.getTfEmail().setText(email);

				String phoneNumber = model.getCurrentUser().getPhoneNumber();
				viewClientDeleteAccountPanel.getFtfPhoneNumber_1().setText(phoneNumber);
			}
		});

		viewClientFrame.getOrderFood().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				viewClientFrame.setContentPane(viewClientOrderFoodPanel);
			}
		});

		viewClientFrame.getOrderHistory().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				viewClientFrame.setContentPane(viewClientOrderHistoryPanel);
				viewClientOrderHistoryPanel.populateOrderTable();

			}
		});

	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}

	public ViewClientFrame getViewClientFrame() {
		return viewClientFrame;
	}

	public ViewClientPanel getViewClientPanel() {
		return viewClientPanel;
	}

	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}

}
