package Manager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import Admin.ControllerAdmin;
import Admin.ViewAdminFrame;
import Admin.ViewAdminPanel;
import Database.DatabaseUser;
import Database.User;
import DeliveryMan.ControllerDeliveryManViewDelivery;
import Login.ControllerLogin;
import Model.Model;

public class ControllerManager implements ActionListener {
	// Creating private variable of my Model
	private Model model;
	// Creating private variable for the Frame my Controller
	private ViewManagerFrame viewManagerFrame;
	// Creating private variables for the Panels of my Controller
	private ViewManagerPanel viewManagerPanel;
	private ViewManagerRestaurantOrderPanel viewManagerRestaurantOrderPanel;
	private ViewManagerCreateMenuPanel viewManagerCreateMenuPanel;
	private ViewManagerEditMenuPanel viewManagerEditMenuPanel;
	private ViewManagerDeleteMenuPanel viewManagerDeleteMenuPanel;
	private ViewManagerEditDeliveryManPanel viewManagerEditDeliveryManPanel;
	// Creating private variables to other Controllers to which the ControllerLogin
	// connects
	private ControllerLogin controllerLogin;
	private ControllerAdmin controllerAdmin;
	// Creating a private variable Database (to identify the user and his access
	// level)
	private DatabaseUser databaseUser;
	private User currentUser;

	public ControllerManager(Model model, ViewManagerFrame viewManagerFrame, ControllerLogin controllerLogin, ControllerAdmin controllerAdmin) {
		this.model = model;
		this.viewManagerFrame = viewManagerFrame;
		this.controllerLogin = controllerLogin;
		this.controllerAdmin = controllerAdmin;

		// Creating the panels for the Manager frame
		viewManagerPanel = new ViewManagerPanel();
		viewManagerRestaurantOrderPanel = controllerAdmin.getViewManagerRestaurantOrderPanel();
		viewManagerCreateMenuPanel = controllerAdmin.getViewManagerCreateMenuPanel();
		viewManagerEditMenuPanel = controllerAdmin.getViewManagerEditMenuPanel();
		viewManagerDeleteMenuPanel = controllerAdmin.getViewManagerDeleteMenuPanel();
		viewManagerEditDeliveryManPanel = controllerAdmin.getViewManagerEditDeliveryManPanel();
		
		// Adding the controllers
		ControllerManagerRestaurantOrder controllerManagerRestaurantOrder = new ControllerManagerRestaurantOrder(model, viewManagerRestaurantOrderPanel, this);
		ControllerManagerCreateMenu controllerManagerCreateMenu = new ControllerManagerCreateMenu(model, viewManagerCreateMenuPanel, this);
		ControllerManagerEditMenu controllerManagerEditMenu = new ControllerManagerEditMenu(model, viewManagerEditMenuPanel, this);
		ControllerManagerDeleteMenu controllerManagerDeleteMenu = new ControllerManagerDeleteMenu(model, viewManagerCreateMenuPanel, this, viewManagerDeleteMenuPanel);
		ControllerManagerEditDeliveryMan controllerManagerEditDeliveryMan = new ControllerManagerEditDeliveryMan(model, viewManagerEditDeliveryManPanel, this, controllerAdmin);
		
		// Adding the panel to the frame
		viewManagerFrame.setContentPane(viewManagerPanel);

		// Assign actions to buttons
		viewManagerFrame.getQuitFileMenu().addActionListener(this);
		viewManagerFrame.getDisconnectFileMenu().addActionListener(this);
		
		// Assign actions to JMenuItem - MANAGER FRAME
		viewManagerFrame.getDisconnectFileMenu().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "See you soon!", "Disconnecting", JOptionPane.INFORMATION_MESSAGE);
				viewManagerFrame.setVisible(false);
				controllerLogin.getViewLoginFrame().setVisible(true);
				controllerLogin.getViewLoginFrame().setNewPanel(controllerLogin.getViewLoginPanel());

			}
		});

		viewManagerFrame.getQuitFileMenu().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Thank you for using a MajorSofware product", "Exit",
						JOptionPane.INFORMATION_MESSAGE);
				System.exit(0);

			}
		});
		
		viewManagerFrame.getViewRestaurantOrdersMenuItem().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				viewManagerFrame.setContentPane(viewManagerRestaurantOrderPanel);
				viewManagerRestaurantOrderPanel.populateOrderTable();

			}
		});
		
		viewManagerFrame.getCreateMenuMenuyItem().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				viewManagerFrame.setContentPane(viewManagerCreateMenuPanel);

			}
		});
		
		viewManagerFrame.getEditMenuMenuMenuItem().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				viewManagerFrame.setContentPane(viewManagerEditMenuPanel);

			}
		});
		
		viewManagerFrame.getDeleteMenuMenuItem().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				viewManagerFrame.setContentPane(viewManagerDeleteMenuPanel);

			}
		});
		
		viewManagerFrame.getMntmEditDeliveryMan().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				viewManagerFrame.setContentPane(viewManagerEditDeliveryManPanel);

			}
		});
	}

	/**
	 * @return the viewManagerRestaurantOrderPanel
	 */
	public ViewManagerRestaurantOrderPanel getViewManagerRestaurantOrderPanel() {
		return viewManagerRestaurantOrderPanel;
	}

	/**
	 * @param viewManagerRestaurantOrderPanel the viewManagerRestaurantOrderPanel to set
	 */
	public void setViewManagerRestaurantOrderPanel(ViewManagerRestaurantOrderPanel viewManagerRestaurantOrderPanel) {
		this.viewManagerRestaurantOrderPanel = viewManagerRestaurantOrderPanel;
	}

	/**
	 * @return the viewManagerCreateMenuPanel
	 */
	public ViewManagerCreateMenuPanel getViewManagerCreateMenuPanel() {
	    return viewManagerCreateMenuPanel;
	}


	/**
	 * @param viewManagerCreateMenuPanel the viewManagerCreateMenuPanel to set
	 */
	public void setViewManagerCreateMenuPanel(ViewManagerCreateMenuPanel viewManagerCreateMenuPanel) {
		this.viewManagerCreateMenuPanel = viewManagerCreateMenuPanel;
	}

	/**
	 * @return the viewManagerEditMenuPanel
	 */
	public ViewManagerEditMenuPanel getViewManagerEditMenuPanel() {
		return viewManagerEditMenuPanel;
	}

	/**
	 * @param viewManagerEditMenuPanel the viewManagerEditMenuPanel to set
	 */
	public void setViewManagerEditMenuPanel(ViewManagerEditMenuPanel viewManagerEditMenuPanel) {
		this.viewManagerEditMenuPanel = viewManagerEditMenuPanel;
	}

	/**
	 * @return the viewManagerDeleteMenuPanel
	 */
	public ViewManagerDeleteMenuPanel getViewManagerDeleteMenuPanel() {
		return viewManagerDeleteMenuPanel;
	}

	/**
	 * @param viewManagerDeleteMenuPanel the viewManagerDeleteMenuPanel to set
	 */
	public void setViewManagerDeleteMenuPanel(ViewManagerDeleteMenuPanel viewManagerDeleteMenuPanel) {
		this.viewManagerDeleteMenuPanel = viewManagerDeleteMenuPanel;
	}

	/**
	 * @return the viewManagerEditDeliveryManPanel
	 */
	public ViewManagerEditDeliveryManPanel getViewManagerEditDeliveryManPanel() {
		return viewManagerEditDeliveryManPanel;
	}

	/**
	 * @param viewManagerEditDeliveryManPanel the viewManagerEditDeliveryManPanel to set
	 */
	public void setViewManagerEditDeliveryManPanel(ViewManagerEditDeliveryManPanel viewManagerEditDeliveryManPanel) {
		this.viewManagerEditDeliveryManPanel = viewManagerEditDeliveryManPanel;
	}

	/**
	 * @param viewManagerFrame the viewManagerFrame to set
	 */
	public void setViewManagerFrame(ViewManagerFrame viewManagerFrame) {
		this.viewManagerFrame = viewManagerFrame;
	}

	/**
	 * @param viewManagerPanel the viewManagerPanel to set
	 */
	public void setViewManagerPanel(ViewManagerPanel viewManagerPanel) {
		this.viewManagerPanel = viewManagerPanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		
	}
	
	public ViewManagerFrame getViewManagerFrame() {
		return viewManagerFrame;
	}

	public ViewManagerPanel getViewManagerPanel() {
		return viewManagerPanel;
	}
	
	public User getCurrentUser() {
	    return currentUser;
	}

	public void setCurrentUser(User currentUser) {
	    this.currentUser = currentUser;
	}
}
