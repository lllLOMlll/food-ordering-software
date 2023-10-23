package Restaurateur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import Admin.ControllerAdmin;
import Admin.ViewAdminFrame;
import Admin.ViewAdminPanel;
import Client.ControllerClientEditAccount;
import Database.DatabaseUser;
import Database.User;
import Login.ControllerLogin;
import Model.Model;

public class ControllerRestaurateur implements ActionListener {
	// Creating private variable of my Model
	private Model model;
	// Creating private variable for the Frame my Controller
	private ViewRestaurateurFrame viewRestaurateurFrame;
	// Creating private variables for the Panels of my Controller
	private ViewRestaurateurPanel viewRestaurateurPanel;
	private ViewRestaurateurAcceptOrderPanel viewRestaurateurAcceptOrderPanel;
	private ViewRestaurateurOrderReadyPanel viewRestaurateurOrderReadyPanel;
	// Creating private variables to other Controllers to which the ControllerLogin
	// connects
	private ControllerLogin controllerLogin;
	// Creating a private variable Database (to identify the user and his access
	// level)
	private DatabaseUser databaseUser;
	private User currentUser;
	private ControllerAdmin controllerAdmin;

	public ControllerRestaurateur(Model model, ViewRestaurateurFrame viewRestaurateurFrame,
			ControllerLogin controllerLogin, ControllerAdmin controllerAdmin) {
		this.model = model;
		this.viewRestaurateurFrame = viewRestaurateurFrame;
		this.controllerLogin = controllerLogin;
		this.controllerAdmin = controllerAdmin;

		// Creating the panels for the Restaurateur frame
		viewRestaurateurPanel = new ViewRestaurateurPanel();
		viewRestaurateurAcceptOrderPanel = controllerAdmin.getViewRestaurateurAcceptOrderPanel();
		viewRestaurateurOrderReadyPanel = controllerAdmin.getViewRestaurateurOrderReadyPanel();

		// Adding the controllers
		ControllerRestaurateurAcceptOrder controllerRestaurateurAcceptOrder = new ControllerRestaurateurAcceptOrder(
				model, viewRestaurateurAcceptOrderPanel, this);
		ControllerRestaurateurOrderReady controllerRestaurateurOrderReady = new ControllerRestaurateurOrderReady(model,
				viewRestaurateurOrderReadyPanel, this);

		// Assign actions to buttons
		viewRestaurateurFrame.getQuitFileMenu().addActionListener(this);
		viewRestaurateurFrame.getDisconnectFileMenu().addActionListener(this);

		// Adding the panel to the frame
		viewRestaurateurFrame.setContentPane(viewRestaurateurPanel);

		// Assign actions to JMenuItem - RESTAURATEUR FRAME
		viewRestaurateurFrame.getDisconnectFileMenu().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "See you soon!", "Disconnecting", JOptionPane.INFORMATION_MESSAGE);
				viewRestaurateurFrame.setVisible(false);
				controllerLogin.getViewLoginFrame().setVisible(true);
				controllerLogin.getViewLoginFrame().setNewPanel(controllerLogin.getViewLoginPanel());

			}
		});

		viewRestaurateurFrame.getQuitFileMenu().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Thank you for using a MajorSofware product", "Exit",
						JOptionPane.INFORMATION_MESSAGE);
				System.exit(0);

			}
		});

		viewRestaurateurFrame.getAcceptOrderMenuItem().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				viewRestaurateurFrame.setContentPane(viewRestaurateurAcceptOrderPanel);
				viewRestaurateurAcceptOrderPanel.populateOrderTable();
			}
		});

		viewRestaurateurFrame.getMarkOrderAsReadyMenuItem().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				viewRestaurateurFrame.setContentPane(viewRestaurateurOrderReadyPanel);
				viewRestaurateurOrderReadyPanel.populateOrderTable();
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

	public ViewRestaurateurFrame getViewRestaurateurFrame() {
		return viewRestaurateurFrame;
	}

	public ViewRestaurateurPanel getViewRestaurateurPanel() {
		return viewRestaurateurPanel;
	}

	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}
}
