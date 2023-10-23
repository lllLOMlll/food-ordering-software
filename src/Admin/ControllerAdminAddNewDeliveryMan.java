package Admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Database.DatabaseDeliveryMan;
import Database.DatabaseRestaurant;
import Database.DeliveryMan;
import Manager.ControllerManager;
import Manager.ViewManagerEditDeliveryManPanel;
import Model.Model;
import Validation.Validation;

public class ControllerAdminAddNewDeliveryMan implements ActionListener {
	private Model model;
	private ViewAdminAddNewDeliveryManPanel viewAdminAddNewDeliveryManPanel;
	private ControllerAdmin controllerAdmin;
	private DatabaseDeliveryMan databaseDeliveryMan;
	private ViewAdminEditDeliveryManPanel viewAdminEditDeliveryManPanel;
	private ViewAdminDeleteDeliveryManPanel viewAdminDeleteDeliveryManPanel;
	private ViewManagerEditDeliveryManPanel viewManagerEditDeliveryManPanel;
	private ControllerManager controllerManager;


	public ControllerAdminAddNewDeliveryMan(Model model, ViewAdminAddNewDeliveryManPanel viewAdminAddNewDeliveryManPanel,
	        ControllerAdmin controllerAdmin, ViewAdminEditDeliveryManPanel viewAdminEditDeliveryManPanel) {
	    this.model = model;
	    this.viewAdminAddNewDeliveryManPanel = viewAdminAddNewDeliveryManPanel;
	    this.controllerAdmin = controllerAdmin;
	    this.databaseDeliveryMan = model.getDeliveryManDatabase();
	    this.viewAdminEditDeliveryManPanel = viewAdminEditDeliveryManPanel;
	    this.viewAdminDeleteDeliveryManPanel = controllerAdmin.getViewAdminDeleteDeliveryManPanel();
	    this.viewManagerEditDeliveryManPanel = controllerAdmin.getViewManagerEditDeliveryManPanel();

		// Adding the buttons
		viewAdminAddNewDeliveryManPanel.getBtnUpdateDeliveryArea().addActionListener(this);
		viewAdminAddNewDeliveryManPanel.getBtnDeleteDeliveryArea().addActionListener(this);
		viewAdminAddNewDeliveryManPanel.getBtnSave().addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == viewAdminAddNewDeliveryManPanel.getBtnUpdateDeliveryArea()) {
			String deliveryArea = viewAdminAddNewDeliveryManPanel.getFrmtdtxtflDeliveryArea_1().getText();
			DefaultTableModel model = (DefaultTableModel) viewAdminAddNewDeliveryManPanel.getTableDeliveryArea()
					.getModel();
			model.addRow(new Object[] { deliveryArea });
			viewAdminAddNewDeliveryManPanel.getFrmtdtxtflDeliveryArea_1().setText("");
		}

		if (source == viewAdminAddNewDeliveryManPanel.getBtnDeleteDeliveryArea()) {
			DefaultTableModel model = (DefaultTableModel) viewAdminAddNewDeliveryManPanel.getTableDeliveryArea()
					.getModel();
			int row = viewAdminAddNewDeliveryManPanel.getTableDeliveryArea().getSelectedRow();
			if (row >= 0) {
				model.removeRow(row);
			}
		}

		if (source == viewAdminAddNewDeliveryManPanel.getBtnSave()) {
		    // Get data from the fields
		    String firstName = viewAdminAddNewDeliveryManPanel.getTfFistName().getText();
		    if (!Validation.isValidName(firstName, viewAdminAddNewDeliveryManPanel)) {
		        return;
		    }
		    String lastName = viewAdminAddNewDeliveryManPanel.getTextLastName().getText();
		    if (!Validation.isValidName(lastName, viewAdminAddNewDeliveryManPanel)) {
		        return;
		    }
		    String telephoneNumber = viewAdminAddNewDeliveryManPanel.getFrmtdtxtfTelephoneNumber_1().getText();

		 // Retrieve the delivery areas from the table
		    DefaultTableModel tableModel = (DefaultTableModel) viewAdminAddNewDeliveryManPanel.getTableDeliveryArea().getModel();
		    ArrayList<String> deliveryAreas = new ArrayList<>();
		    for (int i = 0; i < tableModel.getRowCount(); i++) {
		    String postalCode = (String) tableModel.getValueAt(i, 0);
		    deliveryAreas.add(postalCode);
		    }

		    DeliveryMan newDeliveryMan = new DeliveryMan(firstName, lastName, telephoneNumber, deliveryAreas);

		    // Add the new user to the database
		    model.getDeliveryManDatabase().addDeliveryMan(newDeliveryMan);

		    // Show message dialog box with saved information
		    String message = "New Delivery Man added: " + "\n" + "First Name: " + newDeliveryMan.getFirstName() + "\n"
		            + "Last Name: " + newDeliveryMan.getLastName() + "\n" + "Telephone Number: "
		            + newDeliveryMan.getPhoneNumber() + "\n" + "Delivery area: "
		            + newDeliveryMan.getDeliveryAreas().toString() + "\n";

		    JOptionPane.showMessageDialog(viewAdminAddNewDeliveryManPanel, message, "Delivery Man  added",
		            JOptionPane.INFORMATION_MESSAGE);
		    
			// Update other Delivery Man tables (Admin)
		    viewAdminEditDeliveryManPanel.updateTableDeliveryMan();
		    viewAdminDeleteDeliveryManPanel.updateTableDeliveryMan();
		    
		    // Update other Delivery Man tables (Manager)
		    viewManagerEditDeliveryManPanel.updateTableDeliveryMan();
		    
		    // Reset all the fields
		    viewAdminAddNewDeliveryManPanel.getTfFistName().setText("");
		    viewAdminAddNewDeliveryManPanel.getTextLastName().setText("");
		    viewAdminAddNewDeliveryManPanel.getFrmtdtxtfTelephoneNumber_1().setText("");
			((DefaultTableModel) viewAdminAddNewDeliveryManPanel.getTableDeliveryArea().getModel()).setRowCount(0);
		}
	}
}
