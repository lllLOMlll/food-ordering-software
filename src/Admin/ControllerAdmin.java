package Admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import Client.ViewClientEditAccountPanel;
import Client.ViewClientOrderFoodPanel;
import Client.ViewClientOrderHistoryPanel;
import Client.ViewOpenNewAccountFrame;
import Database.Restaurant;
import Database.User;
import DeliveryMan.ViewAcceptingDeliveryPanel;
import DeliveryMan.ViewDeliveryMadePanel;
import DeliveryMan.ViewDeliveryManViewDeliveryPanel;
import Database.DatabaseDeliveryMan;
import Database.DatabaseRestaurant;
import Database.DatabaseUser;
import Login.ControllerLogin;
import Login.ViewLoginFrame;
import Login.ViewLoginPanel;
import Manager.ControllerManager;
import Manager.ViewManagerCreateMenuPanel;
import Manager.ViewManagerDeleteMenuPanel;
import Manager.ViewManagerEditDeliveryManPanel;
import Manager.ViewManagerEditMenuPanel;
import Manager.ViewManagerRestaurantOrderPanel;
import Model.Model;
import Restaurateur.ViewRestaurateurAcceptOrderPanel;
import Restaurateur.ViewRestaurateurOrderReadyPanel;

public class ControllerAdmin implements ActionListener {
	// Creating private variable of my Model
	private Model model;
	private User currentUser;
	// Creating private variable for the Frame my Controller
	private ViewAdminFrame viewAdminFrame;
	// Creating private variables for the Panels of my Controller
	private ViewAdminPanel viewAdminPanel;
	private ViewAdminAddNewRestaurantPanel viewAdminAddNewRestaurantPanel;
	private ViewAdminEditRestaurantPanel viewAdminEditRestaurantPanel;
	private ViewAdminDeleteRestaurantPanel viewAdminDeleteRestaurantPanel;
	private ViewAdminAddNewMenuPanel viewAdminAddNewMenuPanel;
	private ViewAdminEditMenuPanel viewAdminEditMenuPanel;
	private ViewAdminDeleteMenuPanel viewAdminDeleteMenuPanel;
	private ViewAdminAddNewDeliveryManPanel viewAdminAddNewDeliveryManPanel;
	private ViewAdminEditDeliveryManPanel viewAdminEditDeliveryManPanel;
	private ViewAdminDeleteDeliveryManPanel viewAdminDeleteDeliveryManPanel;
	
	// Manager
	private ViewManagerCreateMenuPanel viewManagerCreateMenuPanel;
	private ViewManagerEditMenuPanel viewManagerEditMenuPanel;
	private ViewManagerDeleteMenuPanel viewManagerDeleteMenuPanel;
	private ViewManagerEditDeliveryManPanel viewManagerEditDeliveryManPanel;
	private ViewManagerRestaurantOrderPanel viewManagerRestaurantOrderPanel;
	
	// Client
	private ViewClientOrderFoodPanel viewClientOrderFoodPanel;
	private ViewClientOrderHistoryPanel viewClientOrderHistoryPanel;
	private ViewClientEditAccountPanel viewClientEditAccountPanel;
	
	// Restaurateur
	private ViewRestaurateurAcceptOrderPanel viewRestaurateurAcceptOrderPanel;
	private ViewRestaurateurOrderReadyPanel viewRestaurateurOrderReadyPanel;
	
	// Delivery Man
	private ViewDeliveryManViewDeliveryPanel viewDeliveryManViewDeliveryPanel;
	private ViewAcceptingDeliveryPanel viewAcceptingDeliveryPanel;
	private ViewDeliveryMadePanel viewDeliveryMadePanel;
	
	
	/**
	 * @return the viewManagerEditMenuPanel
	 */
	public ViewManagerEditMenuPanel getViewManagerEditMenuPanel() {
		return viewManagerEditMenuPanel;
	}



	// Creating private variables to other Controllers to which the ControllerLogin
	// connects
	private ControllerManager controllerManager;
	private ControllerLogin controllerLogin;
	// Creating a private variable Database (to identify the user and his access
	// level)
	private DatabaseUser databaseUser;
	private DatabaseDeliveryMan databaseDeliveryMan;
	private DatabaseRestaurant databaseRestaurant;

	


	public ControllerAdmin(Model model, ViewAdminFrame viewAdminFrame, ControllerLogin controllerLogin, ControllerManager controllerManager) {
	    this.model = model;
	    this.viewAdminFrame = viewAdminFrame;
	    this.controllerLogin = controllerLogin;
	    this.controllerManager = controllerManager;
	    // Set the database instances
	    this.databaseUser = model.getUserDatabase();
	    this.databaseDeliveryMan = model.getDeliveryManDatabase();
	    this.databaseRestaurant = model.getRestaurantDatabase();
	    
	    // Creating the panels for the Admin
	    viewAdminPanel = new ViewAdminPanel();
	    viewAdminAddNewRestaurantPanel = new ViewAdminAddNewRestaurantPanel();
	    viewAdminEditRestaurantPanel = new ViewAdminEditRestaurantPanel(model);
	    viewAdminDeleteRestaurantPanel = new ViewAdminDeleteRestaurantPanel(model);
	    viewAdminAddNewMenuPanel = new ViewAdminAddNewMenuPanel(model);
	    viewAdminEditMenuPanel = new ViewAdminEditMenuPanel(model);
	    viewAdminDeleteMenuPanel = new ViewAdminDeleteMenuPanel(model);
	    viewAdminAddNewDeliveryManPanel = new ViewAdminAddNewDeliveryManPanel();
	    viewAdminEditDeliveryManPanel = new ViewAdminEditDeliveryManPanel(model);
	    viewAdminDeleteDeliveryManPanel = new ViewAdminDeleteDeliveryManPanel(model);
	    
	    // Create panel for Manager
	    viewManagerCreateMenuPanel = new ViewManagerCreateMenuPanel(model);
	    viewManagerEditMenuPanel = new ViewManagerEditMenuPanel(model);
	    viewManagerDeleteMenuPanel = new ViewManagerDeleteMenuPanel(model);
	    viewManagerEditDeliveryManPanel = new ViewManagerEditDeliveryManPanel(model);
	    viewManagerRestaurantOrderPanel = new ViewManagerRestaurantOrderPanel(model);
	    
	    // Create panel for Client
	    viewClientOrderFoodPanel = new ViewClientOrderFoodPanel(model);
	    viewClientOrderHistoryPanel = new ViewClientOrderHistoryPanel(model);
		viewClientEditAccountPanel = new ViewClientEditAccountPanel(model);
		
		// Create panel for Restaurateur
		viewRestaurateurAcceptOrderPanel =  new ViewRestaurateurAcceptOrderPanel(model);
		viewRestaurateurOrderReadyPanel = new ViewRestaurateurOrderReadyPanel(model);

		// Create panel for Restaurateur
		viewDeliveryManViewDeliveryPanel = new ViewDeliveryManViewDeliveryPanel(model);
		viewAcceptingDeliveryPanel = new ViewAcceptingDeliveryPanel(model);
		viewDeliveryMadePanel = new ViewDeliveryMadePanel(model);
		
		// Adding the controllers
		ControllerAdminEditRestaurant controllerAdminEditRestaurant = new ControllerAdminEditRestaurant(model,
				viewAdminEditRestaurantPanel, this);
		ControllerAdminDeleteRestaurant controllerAdminDeleteRestaurant = new ControllerAdminDeleteRestaurant(model,
				viewAdminDeleteRestaurantPanel, this, viewAdminEditRestaurantPanel, viewAdminEditMenuPanel, viewAdminDeleteMenuPanel, viewAdminAddNewMenuPanel);
		ControllerAdminAddNewMenu controllerAdminAddNewMenu = new ControllerAdminAddNewMenu(model,
				viewAdminAddNewMenuPanel, this);
		ControllerAdminEditMenu controllerAdminEditMenu = new ControllerAdminEditMenu(model, viewAdminEditMenuPanel,
				this, viewAdminDeleteRestaurantPanel);
		ControllerAdminDeleteMenu controllerAdminDeleteMenu = new ControllerAdminDeleteMenu(model,
				viewAdminDeleteMenuPanel, this);
		ControllerAdminAddNewDeliveryMan controllerAdminAddNewDeliveryMan = new ControllerAdminAddNewDeliveryMan(model,
				viewAdminAddNewDeliveryManPanel, this, viewAdminEditDeliveryManPanel);
		ControllerAdminEditDeliveryMan controllerAdminEditDeliveryMan = new ControllerAdminEditDeliveryMan(model,
				viewAdminEditDeliveryManPanel, this, viewAdminAddNewDeliveryManPanel);
		ControllerAdminDeleteDeliveryMan controllerAdminDeleteDeliveryMan = new ControllerAdminDeleteDeliveryMan(model,
				viewAdminDeleteDeliveryManPanel, this, viewAdminAddNewDeliveryManPanel);

		// Adding the panel to the frame
		viewAdminFrame.setNewPanelAdmin(viewAdminPanel);

		// Assign actions to JMenuItem - ADMIN FRAME
		viewAdminFrame.getDisconnectFileMenu().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "See you soon!", "Disconnecting", JOptionPane.INFORMATION_MESSAGE);
				viewAdminFrame.setVisible(false);
				controllerLogin.getViewLoginFrame().setVisible(true);
				controllerLogin.getViewLoginFrame().setNewPanel(controllerLogin.getViewLoginPanel());

			}
		});

		viewAdminFrame.getQuitFileMenu().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Thank you for using a MajorSofware product", "Exit",
						JOptionPane.INFORMATION_MESSAGE);
				System.exit(0);

			}
		});

		viewAdminFrame.getCreateRestaurantMenuItem().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				viewAdminFrame.setContentPane(viewAdminAddNewRestaurantPanel);

			}
		});

		viewAdminFrame.getEditRestaurantMenuItem().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				viewAdminFrame.setContentPane(viewAdminEditRestaurantPanel);

			}
		});

		viewAdminFrame.getDeleteRestaurantMenuItem().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				viewAdminFrame.setContentPane(viewAdminDeleteRestaurantPanel);

			}
		});

		viewAdminFrame.getAddMenuMenu().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				viewAdminFrame.setContentPane(viewAdminAddNewMenuPanel);

			}
		});

		viewAdminFrame.getEditMenuMenu().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				viewAdminFrame.setContentPane(viewAdminEditMenuPanel);

			}
		});

		viewAdminFrame.getDeleteMenuMenu().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				viewAdminFrame.setContentPane(viewAdminDeleteMenuPanel);

			}
		});

		viewAdminFrame.getAddDeliveryManMenu().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				viewAdminFrame.setContentPane(viewAdminAddNewDeliveryManPanel);

			}
		});

		viewAdminFrame.getEditDeliveryManMenu().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				viewAdminFrame.setContentPane(viewAdminEditDeliveryManPanel);

			}
		});

		viewAdminFrame.getDeleteDeliveryManMenu().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				viewAdminFrame.setContentPane(viewAdminDeleteDeliveryManPanel);

			}
		});

		// Assign actions to buttons - ADD NEW RESTAURANT PANEL
		viewAdminAddNewRestaurantPanel.getBtnResetAllTheTimes().addActionListener(this);
		viewAdminAddNewRestaurantPanel.getBtnSave().addActionListener(this);
		viewAdminAddNewRestaurantPanel.getBtnUpdateDeliveryArea().addActionListener(this);
		viewAdminAddNewRestaurantPanel.getBtnDeleteDeliveryArea().addActionListener(this);
		viewAdminAddNewRestaurantPanel.getFrmtdtxtflDeliveryArea().addActionListener(this);
		viewAdminAddNewRestaurantPanel.getCbSundayOpening1().addActionListener(this);
		viewAdminAddNewRestaurantPanel.getCbSundayOpening2().addActionListener(this);
		viewAdminAddNewRestaurantPanel.getCbSundayClosing1().addActionListener(this);
		viewAdminAddNewRestaurantPanel.getCbSundayClosing2().addActionListener(this);
		viewAdminAddNewRestaurantPanel.getCbMondayOpening1().addActionListener(this);
		viewAdminAddNewRestaurantPanel.getCbMondayOpening2().addActionListener(this);
		viewAdminAddNewRestaurantPanel.getCbMondayClosing1().addActionListener(this);
		viewAdminAddNewRestaurantPanel.getCbMondayClosing2().addActionListener(this);
		viewAdminAddNewRestaurantPanel.getCbTuesdayOpening1().addActionListener(this);
		viewAdminAddNewRestaurantPanel.getCbTuesdayOpening2().addActionListener(this);
		viewAdminAddNewRestaurantPanel.getCbTuesdayClosing1().addActionListener(this);
		viewAdminAddNewRestaurantPanel.getCbTuesdayClosing2().addActionListener(this);
		viewAdminAddNewRestaurantPanel.getCbWednesdayOpening1().addActionListener(this);
		viewAdminAddNewRestaurantPanel.getCbWednesdayOpening2().addActionListener(this);
		viewAdminAddNewRestaurantPanel.getCbWednesdayClosing1().addActionListener(this);
		viewAdminAddNewRestaurantPanel.getCbWednesdayClosing2().addActionListener(this);
		viewAdminAddNewRestaurantPanel.getCbThursdayOpening1().addActionListener(this);
		viewAdminAddNewRestaurantPanel.getCbThursdayOpening2().addActionListener(this);
		viewAdminAddNewRestaurantPanel.getCbThursdayClosing1().addActionListener(this);
		viewAdminAddNewRestaurantPanel.getCbThursdayClosing2().addActionListener(this);
		viewAdminAddNewRestaurantPanel.getCbFridayOpening1().addActionListener(this);
		viewAdminAddNewRestaurantPanel.getCbFridayOpening2().addActionListener(this);
		viewAdminAddNewRestaurantPanel.getCbFridayClosing1().addActionListener(this);
		viewAdminAddNewRestaurantPanel.getCbFridayClosing2().addActionListener(this);
		viewAdminAddNewRestaurantPanel.getCbSaturdayOpening1().addActionListener(this);
		viewAdminAddNewRestaurantPanel.getCbSaturdayOpening2().addActionListener(this);
		viewAdminAddNewRestaurantPanel.getCbSaturdayClosing1().addActionListener(this);
		viewAdminAddNewRestaurantPanel.getCbSaturdayClosing2().addActionListener(this);

	}




	


	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		// ADD NEW RESTAURANT
		if (source == viewAdminAddNewRestaurantPanel.getBtnResetAllTheTimes()) {

		}
		if (source == viewAdminAddNewRestaurantPanel.getBtnSave()) {

			// Get data from the fields
			String name = viewAdminAddNewRestaurantPanel.getTfRestaurantName().getText();
			String address = viewAdminAddNewRestaurantPanel.getTfRestaurantAddress().getText();
			String telephoneNumber = viewAdminAddNewRestaurantPanel.getFrmtdtxtfTelephoneNumber().getText();

			List<String> deliveryArea = new ArrayList<String>();
			DefaultTableModel tableModel = (DefaultTableModel) viewAdminAddNewRestaurantPanel.getTableDeliveryArea().getModel();
			for (int i = 0; i < tableModel.getRowCount(); i++) {
			    String postalCode = (String) tableModel.getValueAt(i, 0);
			    deliveryArea.add(postalCode);
			}


			// Create a new Restaurant object
			Restaurant newRestaurant = new Restaurant(name, address, telephoneNumber, deliveryArea,
					viewAdminAddNewRestaurantPanel.getCbSundayOpening1().getSelectedItem().toString(),
					viewAdminAddNewRestaurantPanel.getCbSundayOpening2().getSelectedItem().toString(),
					viewAdminAddNewRestaurantPanel.getCbSundayClosing1().getSelectedItem().toString(),
					viewAdminAddNewRestaurantPanel.getCbSundayClosing2().getSelectedItem().toString(),
					viewAdminAddNewRestaurantPanel.getCbMondayOpening1().getSelectedItem().toString(),
					viewAdminAddNewRestaurantPanel.getCbMondayOpening2().getSelectedItem().toString(),
					viewAdminAddNewRestaurantPanel.getCbMondayClosing1().getSelectedItem().toString(),
					viewAdminAddNewRestaurantPanel.getCbMondayClosing2().getSelectedItem().toString(),
					viewAdminAddNewRestaurantPanel.getCbTuesdayOpening1().getSelectedItem().toString(),
					viewAdminAddNewRestaurantPanel.getCbTuesdayOpening2().getSelectedItem().toString(),
					viewAdminAddNewRestaurantPanel.getCbTuesdayClosing1().getSelectedItem().toString(),
					viewAdminAddNewRestaurantPanel.getCbTuesdayClosing2().getSelectedItem().toString(),
					viewAdminAddNewRestaurantPanel.getCbWednesdayOpening1().getSelectedItem().toString(),
					viewAdminAddNewRestaurantPanel.getCbWednesdayOpening2().getSelectedItem().toString(),
					viewAdminAddNewRestaurantPanel.getCbWednesdayClosing1().getSelectedItem().toString(),
					viewAdminAddNewRestaurantPanel.getCbWednesdayClosing2().getSelectedItem().toString(),
					viewAdminAddNewRestaurantPanel.getCbThursdayOpening1().getSelectedItem().toString(),
					viewAdminAddNewRestaurantPanel.getCbThursdayOpening2().getSelectedItem().toString(),
					viewAdminAddNewRestaurantPanel.getCbThursdayClosing1().getSelectedItem().toString(),
					viewAdminAddNewRestaurantPanel.getCbThursdayClosing2().getSelectedItem().toString(),
					viewAdminAddNewRestaurantPanel.getCbFridayOpening1().getSelectedItem().toString(),
					viewAdminAddNewRestaurantPanel.getCbFridayOpening2().getSelectedItem().toString(),
					viewAdminAddNewRestaurantPanel.getCbFridayClosing1().getSelectedItem().toString(),
					viewAdminAddNewRestaurantPanel.getCbFridayClosing2().getSelectedItem().toString(),
					viewAdminAddNewRestaurantPanel.getCbSaturdayOpening1().getSelectedItem().toString(),
					viewAdminAddNewRestaurantPanel.getCbSaturdayOpening2().getSelectedItem().toString(),
					viewAdminAddNewRestaurantPanel.getCbSaturdayClosing1().getSelectedItem().toString(),
					viewAdminAddNewRestaurantPanel.getCbSaturdayClosing2().getSelectedItem().toString());


			// Add the newRestaurant object to the RestaurantDatabase
			databaseRestaurant.addRestaurant(newRestaurant);

			// Update the restaurant table - Admin
			viewAdminEditRestaurantPanel.updateTableRestaurant();
			viewAdminDeleteRestaurantPanel.updateTableRestaurant();
			viewAdminEditMenuPanel.updateTableRestaurant();
			viewAdminDeleteMenuPanel.updateTableRestaurant();
			viewAdminAddNewMenuPanel.updateTableRestaurant();
			
			// Update the restaurant table  - Manager
			viewManagerCreateMenuPanel.updateTableRestaurant();
			viewManagerEditMenuPanel.updateTableRestaurant();
			viewManagerDeleteMenuPanel.updateTableRestaurant();
			viewManagerRestaurantOrderPanel.updateTableRestaurant();
			
			// Update the restaurant table  - Client
			viewClientOrderFoodPanel.updateTableRestaurant();
			


			// Reset all the fields
			viewAdminAddNewRestaurantPanel.getTfRestaurantName().setText("");
			viewAdminAddNewRestaurantPanel.getTfRestaurantAddress().setText("");
			viewAdminAddNewRestaurantPanel.getFrmtdtxtfTelephoneNumber().setText("");
			viewAdminAddNewRestaurantPanel.getFrmtdtxtflDeliveryArea().setText("");
			((DefaultTableModel) viewAdminAddNewRestaurantPanel.getTableDeliveryArea().getModel()).setRowCount(0);
			viewAdminAddNewRestaurantPanel.getCbSundayOpening1().setSelectedIndex(0);
			viewAdminAddNewRestaurantPanel.getCbSundayOpening2().setSelectedIndex(0);
			viewAdminAddNewRestaurantPanel.getCbSundayClosing1().setSelectedIndex(0);
			viewAdminAddNewRestaurantPanel.getCbSundayClosing2().setSelectedIndex(0);
			viewAdminAddNewRestaurantPanel.getCbMondayOpening1().setSelectedIndex(0);
			viewAdminAddNewRestaurantPanel.getCbMondayOpening2().setSelectedIndex(0);
			viewAdminAddNewRestaurantPanel.getCbMondayClosing1().setSelectedIndex(0);
			viewAdminAddNewRestaurantPanel.getCbMondayClosing2().setSelectedIndex(0);
			viewAdminAddNewRestaurantPanel.getCbTuesdayOpening1().setSelectedIndex(0);
			viewAdminAddNewRestaurantPanel.getCbTuesdayOpening2().setSelectedIndex(0);
			viewAdminAddNewRestaurantPanel.getCbTuesdayClosing1().setSelectedIndex(0);
			viewAdminAddNewRestaurantPanel.getCbTuesdayClosing2().setSelectedIndex(0);
			viewAdminAddNewRestaurantPanel.getCbWednesdayOpening1().setSelectedIndex(0);
			viewAdminAddNewRestaurantPanel.getCbWednesdayOpening2().setSelectedIndex(0);
			viewAdminAddNewRestaurantPanel.getCbWednesdayClosing1().setSelectedIndex(0);
			viewAdminAddNewRestaurantPanel.getCbWednesdayClosing2().setSelectedIndex(0);
			viewAdminAddNewRestaurantPanel.getCbThursdayOpening1().setSelectedIndex(0);
			viewAdminAddNewRestaurantPanel.getCbThursdayOpening2().setSelectedIndex(0);
			viewAdminAddNewRestaurantPanel.getCbThursdayClosing1().setSelectedIndex(0);
			viewAdminAddNewRestaurantPanel.getCbThursdayClosing2().setSelectedIndex(0);
			viewAdminAddNewRestaurantPanel.getCbFridayOpening1().setSelectedIndex(0);
			viewAdminAddNewRestaurantPanel.getCbFridayOpening2().setSelectedIndex(0);
			viewAdminAddNewRestaurantPanel.getCbFridayClosing1().setSelectedIndex(0);
			viewAdminAddNewRestaurantPanel.getCbFridayClosing2().setSelectedIndex(0);
			viewAdminAddNewRestaurantPanel.getCbSaturdayOpening1().setSelectedIndex(0);
			viewAdminAddNewRestaurantPanel.getCbSaturdayOpening2().setSelectedIndex(0);
			viewAdminAddNewRestaurantPanel.getCbSaturdayClosing1().setSelectedIndex(0);
			viewAdminAddNewRestaurantPanel.getCbSaturdayClosing2().setSelectedIndex(0);

			// Show message dialog box with saved information
			String message = "New restaurant added: " + newRestaurant.getName() + "\n" + "Address: "
					+ newRestaurant.getAddress() + "\n" + "Telephone number: " + newRestaurant.getTelephoneNumber()
					+ "\n" + "Delivery area: " + newRestaurant.getDeliveryAreas().toString() + "\n"
					+ "Opening and closing times: " + newRestaurant.getOpeningHours(newRestaurant);
			JOptionPane.showMessageDialog(viewAdminAddNewRestaurantPanel, message, "Restaurant added",
					JOptionPane.INFORMATION_MESSAGE);

		}

		if (source == viewAdminAddNewRestaurantPanel.getBtnUpdateDeliveryArea()) {
			String deliveryArea = viewAdminAddNewRestaurantPanel.getFrmtdtxtflDeliveryArea().getText();
			DefaultTableModel model = (DefaultTableModel) viewAdminAddNewRestaurantPanel.getTableDeliveryArea()
					.getModel();
			model.addRow(new Object[] { deliveryArea });
			viewAdminAddNewRestaurantPanel.getFrmtdtxtflDeliveryArea().setText("");
		}

		if (source == viewAdminAddNewRestaurantPanel.getBtnDeleteDeliveryArea()) {
			DefaultTableModel model = (DefaultTableModel) viewAdminAddNewRestaurantPanel.getTableDeliveryArea()
					.getModel();
			int row = viewAdminAddNewRestaurantPanel.getTableDeliveryArea().getSelectedRow();
			if (row >= 0) {
				model.removeRow(row);

			}
		}
	}

	public ViewManagerRestaurantOrderPanel getViewManagerRestaurantOrderPanel() {
		return viewManagerRestaurantOrderPanel;
	}







	public void setViewManagerRestaurantOrderPanel(ViewManagerRestaurantOrderPanel viewManagerRestaurantOrderPanel) {
		this.viewManagerRestaurantOrderPanel = viewManagerRestaurantOrderPanel;
	}







	public ViewAdminFrame getViewAdminFrame() {
		return viewAdminFrame;
	}

	public ViewAdminPanel getViewAdminPanel() {
		return viewAdminPanel;
	}
	
	/**
	 * @return the viewAdminDeleteDeliveryManPanel
	 */
	public ViewAdminDeleteDeliveryManPanel getViewAdminDeleteDeliveryManPanel() {
		return viewAdminDeleteDeliveryManPanel;
	}

	/**
	 * @param viewAdminDeleteDeliveryManPanel the viewAdminDeleteDeliveryManPanel to set
	 */
	public void setViewAdminDeleteDeliveryManPanel(ViewAdminDeleteDeliveryManPanel viewAdminDeleteDeliveryManPanel) {
		this.viewAdminDeleteDeliveryManPanel = viewAdminDeleteDeliveryManPanel;
	}

	/**
	 * @return the viewAdminAddNewDeliveryManPanel
	 */
	public ViewAdminAddNewDeliveryManPanel getViewAdminAddNewDeliveryManPanel() {
		return viewAdminAddNewDeliveryManPanel;
	}

	/**
	 * @param viewAdminAddNewDeliveryManPanel the viewAdminAddNewDeliveryManPanel to set
	 */
	public void setViewAdminAddNewDeliveryManPanel(ViewAdminAddNewDeliveryManPanel viewAdminAddNewDeliveryManPanel) {
		this.viewAdminAddNewDeliveryManPanel = viewAdminAddNewDeliveryManPanel;
	}



	/**
	 * @return the model
	 */
	public Model getModel() {
		return model;
	}



	/**
	 * @param model the model to set
	 */
	public void setModel(Model model) {
		this.model = model;
	}



	/**
	 * @return the viewAdminAddNewRestaurantPanel
	 */
	public ViewAdminAddNewRestaurantPanel getViewAdminAddNewRestaurantPanel() {
		return viewAdminAddNewRestaurantPanel;
	}



	/**
	 * @param viewAdminAddNewRestaurantPanel the viewAdminAddNewRestaurantPanel to set
	 */
	public void setViewAdminAddNewRestaurantPanel(ViewAdminAddNewRestaurantPanel viewAdminAddNewRestaurantPanel) {
		this.viewAdminAddNewRestaurantPanel = viewAdminAddNewRestaurantPanel;
	}



	/**
	 * @return the viewAdminEditRestaurantPanel
	 */
	public ViewAdminEditRestaurantPanel getViewAdminEditRestaurantPanel() {
		return viewAdminEditRestaurantPanel;
	}



	/**
	 * @param viewAdminEditRestaurantPanel the viewAdminEditRestaurantPanel to set
	 */
	public void setViewAdminEditRestaurantPanel(ViewAdminEditRestaurantPanel viewAdminEditRestaurantPanel) {
		this.viewAdminEditRestaurantPanel = viewAdminEditRestaurantPanel;
	}



	/**
	 * @return the viewAdminDeleteRestaurantPanel
	 */
	public ViewAdminDeleteRestaurantPanel getViewAdminDeleteRestaurantPanel() {
		return viewAdminDeleteRestaurantPanel;
	}



	/**
	 * @param viewAdminDeleteRestaurantPanel the viewAdminDeleteRestaurantPanel to set
	 */
	public void setViewAdminDeleteRestaurantPanel(ViewAdminDeleteRestaurantPanel viewAdminDeleteRestaurantPanel) {
		this.viewAdminDeleteRestaurantPanel = viewAdminDeleteRestaurantPanel;
	}



	/**
	 * @return the viewAdminAddNewMenuPanel
	 */
	public ViewAdminAddNewMenuPanel getViewAdminAddNewMenuPanel() {
		return viewAdminAddNewMenuPanel;
	}



	/**
	 * @param viewAdminAddNewMenuPanel the viewAdminAddNewMenuPanel to set
	 */
	public void setViewAdminAddNewMenuPanel(ViewAdminAddNewMenuPanel viewAdminAddNewMenuPanel) {
		this.viewAdminAddNewMenuPanel = viewAdminAddNewMenuPanel;
	}


	/**
	 * @return the viewAdminEditMenuPanel
	 */
	public ViewAdminEditMenuPanel getViewAdminEditMenuPanel() {
		return viewAdminEditMenuPanel;
	}

	/**
	 * @param viewAdminEditMenuPanel the viewAdminEditMenuPanel to set
	 */
	public void setViewAdminEditMenuPanel(ViewAdminEditMenuPanel viewAdminEditMenuPanel) {
		this.viewAdminEditMenuPanel = viewAdminEditMenuPanel;
	}

	/**
	 * @return the viewAdminDeleteMenuPanel
	 */
	public ViewAdminDeleteMenuPanel getViewAdminDeleteMenuPanel() {
		return viewAdminDeleteMenuPanel;
	}

	/**
	 * @param viewAdminDeleteMenuPanel the viewAdminDeleteMenuPanel to set
	 */
	public void setViewAdminDeleteMenuPanel(ViewAdminDeleteMenuPanel viewAdminDeleteMenuPanel) {
		this.viewAdminDeleteMenuPanel = viewAdminDeleteMenuPanel;
	}

	/**
	 * @return the viewAdminEditDeliveryManPanel
	 */
	public ViewAdminEditDeliveryManPanel getViewAdminEditDeliveryManPanel() {
		return viewAdminEditDeliveryManPanel;
	}

	/**
	 * @param viewAdminEditDeliveryManPanel the viewAdminEditDeliveryManPanel to set
	 */
	public void setViewAdminEditDeliveryManPanel(ViewAdminEditDeliveryManPanel viewAdminEditDeliveryManPanel) {
		this.viewAdminEditDeliveryManPanel = viewAdminEditDeliveryManPanel;
	}

	/**
	 * @return the controllerLogin
	 */
	public ControllerLogin getControllerLogin() {
		return controllerLogin;
	}

	/**
	 * @param controllerLogin the controllerLogin to set
	 */
	public void setControllerLogin(ControllerLogin controllerLogin) {
		this.controllerLogin = controllerLogin;
	}

	/**
	 * @return the databaseUser
	 */
	public DatabaseUser getDatabaseUser() {
		return databaseUser;
	}

	/**
	 * @param databaseUser the databaseUser to set
	 */
	public void setDatabaseUser(DatabaseUser databaseUser) {
		this.databaseUser = databaseUser;
	}

	/**
	 * @return the databaseDeliveryMan
	 */
	public DatabaseDeliveryMan getDatabaseDeliveryMan() {
		return databaseDeliveryMan;
	}

	/**
	 * @param databaseDeliveryMan the databaseDeliveryMan to set
	 */
	public void setDatabaseDeliveryMan(DatabaseDeliveryMan databaseDeliveryMan) {
		this.databaseDeliveryMan = databaseDeliveryMan;
	}

	/**
	 * @return the databaseRestaurant
	 */
	public DatabaseRestaurant getDatabaseRestaurant() {
		return databaseRestaurant;
	}

	/**
	 * @param databaseRestaurant the databaseRestaurant to set
	 */
	public void setDatabaseRestaurant(DatabaseRestaurant databaseRestaurant) {
		this.databaseRestaurant = databaseRestaurant;
	}


	/**
	 * @param viewAdminFrame the viewAdminFrame to set
	 */
	public void setViewAdminFrame(ViewAdminFrame viewAdminFrame) {
		this.viewAdminFrame = viewAdminFrame;
	}


	/**
	 * @param viewAdminPanel the viewAdminPanel to set
	 */
	public void setViewAdminPanel(ViewAdminPanel viewAdminPanel) {
		this.viewAdminPanel = viewAdminPanel;
	}
	

	/**
	 * @return the viewClientOrderFoodPanel
	 */
	public ViewClientOrderFoodPanel getViewClientOrderFoodPanel() {
		return viewClientOrderFoodPanel;
	}

	/**
	 * @param viewClientOrderFoodPanel the viewClientOrderFoodPanel to set
	 */
	public void setViewClientOrderFoodPanel(ViewClientOrderFoodPanel viewClientOrderFoodPanel) {
		this.viewClientOrderFoodPanel = viewClientOrderFoodPanel;
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
	 * @return the viewManagerCreateMenuPanel
	 */
	public ViewManagerCreateMenuPanel getViewManagerCreateMenuPanel() {
		return viewManagerCreateMenuPanel;
	}

	/**
	 * @param viewManagerEditMenuPanel the viewManagerEditMenuPanel to set
	 */
	public void setViewManagerEditMenuPanel(ViewManagerEditMenuPanel viewManagerEditMenuPanel) {
		this.viewManagerEditMenuPanel = viewManagerEditMenuPanel;
	}

	/**
	 * @param viewManagerCreateMenuPanel the viewManagerCreateMenuPanel to set
	 */
	public void setViewManagerCreateMenuPanel(ViewManagerCreateMenuPanel viewManagerCreateMenuPanel) {
		this.viewManagerCreateMenuPanel = viewManagerCreateMenuPanel;
	}
	
	public User getCurrentUser() {
	    return currentUser;
	}

	public void setCurrentUser(User currentUser) {
	    this.currentUser = currentUser;
	}
	/**
	 * @return the viewClientEditAccountPanel
	 */
	public ViewClientEditAccountPanel getViewClientEditAccountPanel() {
		return viewClientEditAccountPanel;
	}

	/**
	 * @param viewClientEditAccountPanel the viewClientEditAccountPanel to set
	 */
	public void setViewClientEditAccountPanel(ViewClientEditAccountPanel viewClientEditAccountPanel) {
		this.viewClientEditAccountPanel = viewClientEditAccountPanel;
	}


	/**
	 * @return the viewClientOrderHistoryPanel
	 */
	public ViewClientOrderHistoryPanel getViewClientOrderHistoryPanel() {
		return viewClientOrderHistoryPanel;
	}

	/**
	 * @param viewClientOrderHistoryPanel the viewClientOrderHistoryPanel to set
	 */
	public void setViewClientOrderHistoryPanel(ViewClientOrderHistoryPanel viewClientOrderHistoryPanel) {
		this.viewClientOrderHistoryPanel = viewClientOrderHistoryPanel;
	}


	public ViewRestaurateurAcceptOrderPanel getViewRestaurateurAcceptOrderPanel() {
		return viewRestaurateurAcceptOrderPanel;
	}


	public void setViewRestaurateurAcceptOrderPanel(ViewRestaurateurAcceptOrderPanel viewRestaurateurAcceptOrderPanel) {
		this.viewRestaurateurAcceptOrderPanel = viewRestaurateurAcceptOrderPanel;
	}


	public ViewRestaurateurOrderReadyPanel getViewRestaurateurOrderReadyPanel() {
		return viewRestaurateurOrderReadyPanel;
	}


	public void setViewRestaurateurOrderReadyPanel(ViewRestaurateurOrderReadyPanel viewRestaurateurOrderReadyPanel) {
		this.viewRestaurateurOrderReadyPanel = viewRestaurateurOrderReadyPanel;
	}

	public ViewDeliveryManViewDeliveryPanel getViewDeliveryManViewDeliveryPanel() {
		return viewDeliveryManViewDeliveryPanel;
	}

	public void setViewDeliveryManViewDeliveryPanel(ViewDeliveryManViewDeliveryPanel viewDeliveryManViewDeliveryPanel) {
		this.viewDeliveryManViewDeliveryPanel = viewDeliveryManViewDeliveryPanel;
	}

	public ViewAcceptingDeliveryPanel getViewAcceptingDeliveryPanel() {
		return viewAcceptingDeliveryPanel;
	}

	public void setViewAcceptingDeliveryPanel(ViewAcceptingDeliveryPanel viewAcceptingDeliveryPanel) {
		this.viewAcceptingDeliveryPanel = viewAcceptingDeliveryPanel;
	}

	public ViewDeliveryMadePanel getViewDeliveryMadePanel() {
		return viewDeliveryMadePanel;
	}

	public void setViewDeliveryMadePanel(ViewDeliveryMadePanel viewDeliveryMadePanel) {
		this.viewDeliveryMadePanel = viewDeliveryMadePanel;
	}


}
