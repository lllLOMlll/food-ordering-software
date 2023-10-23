package Admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.plaf.synth.SynthOptionPaneUI;
import javax.swing.table.DefaultTableModel;

import Database.DeliveryMan;
import Manager.ViewManagerEditDeliveryManPanel;
import Model.Model;
import Validation.Validation;

public class ControllerAdminEditDeliveryMan implements ActionListener {
	private Model model;
	private ViewAdminEditDeliveryManPanel viewAdminEditDeliveryManPanel;
	private ControllerAdmin controllerAdmin;
	private ViewAdminAddNewDeliveryManPanel viewAdminAddNewDeliveryManPanel;
	private ViewManagerEditDeliveryManPanel viewManagerEditDeliveryManPanel;

	public ControllerAdminEditDeliveryMan(Model model, ViewAdminEditDeliveryManPanel viewAdminEditDeliveryManPanel,
			ControllerAdmin controllerAdmin, ViewAdminAddNewDeliveryManPanel viewAdminAddNewDeliveryManPanel) {
		this.model = model;
		this.viewAdminEditDeliveryManPanel = viewAdminEditDeliveryManPanel;
		this.controllerAdmin = controllerAdmin;
		this.viewAdminAddNewDeliveryManPanel = viewAdminAddNewDeliveryManPanel;
		this.viewManagerEditDeliveryManPanel = controllerAdmin.getViewManagerEditDeliveryManPanel();

		// Adding the buttons
		viewAdminEditDeliveryManPanel.getBtnSelect().addActionListener(this);
        viewAdminEditDeliveryManPanel.getBtnSaveDeliveryArea().addActionListener(this);
        viewAdminEditDeliveryManPanel.getBtnDeleteDeliveryArea().addActionListener(this);
        viewAdminEditDeliveryManPanel.getBtnSaveDeliveryMan().addActionListener(this);
        viewAdminEditDeliveryManPanel.getBtnUpdateDeliveryArea().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
	    if (source == viewAdminEditDeliveryManPanel.getBtnSelectDeliveryMan()) {
	        // Get the selected row from the delivery man table
	        int selectedRow = viewAdminEditDeliveryManPanel.getTableDeliveryMan().getSelectedRow();
	        if (selectedRow != -1) { // Check that a row is actually selected
	            // Get the first name of the selected delivery man
	            String firstName = (String) viewAdminEditDeliveryManPanel.getTableDeliveryMan().getValueAt(selectedRow, 0);  
	            // Find the delivery man in the database based on their first name
	            DeliveryMan deliveryMan = null;
	            for (DeliveryMan dm : model.getDeliveryManDatabase().getAllDeliveryMen()) {
	                if (dm.getFirstName().equals(firstName)) {
	                    deliveryMan = dm;
	                    break;
	                }
	            }
	            if (deliveryMan != null) {
	                // Display the delivery man's information in the text fields
	                viewAdminEditDeliveryManPanel.getTfFistName().setText(deliveryMan.getFirstName());
	                viewAdminEditDeliveryManPanel.getTextLastName().setText(deliveryMan.getLastName());
	                viewAdminEditDeliveryManPanel.getFrmtdtxtfTelephoneNumber_1().setText(deliveryMan.getPhoneNumber());
	                // Display the delivery man's delivery areas in the table
	                DefaultTableModel deliveryAreaTableModel = (DefaultTableModel) viewAdminEditDeliveryManPanel.getTableDeliveryArea().getModel();
	                deliveryAreaTableModel.setRowCount(0);
	                for (String deliveryArea : deliveryMan.getDeliveryAreas()) {
	                    deliveryAreaTableModel.addRow(new Object[] {deliveryArea});
	                }
	            }
	        }
	    }
	    
		if (source == viewAdminEditDeliveryManPanel.getBtnSaveDeliveryMan()) {
		    // Get data from the fields
		    String firstName = viewAdminEditDeliveryManPanel.getTfFistName().getText();
		    if (!Validation.isValidName(firstName, viewAdminEditDeliveryManPanel)) {
		        return;
		    }
		    String lastName = viewAdminEditDeliveryManPanel.getTextLastName().getText();
		    if (!Validation.isValidName(lastName, viewAdminEditDeliveryManPanel)) {
		        return;
		    }
		    String telephoneNumber = viewAdminEditDeliveryManPanel.getFrmtdtxtfTelephoneNumber_1().getText();

		 // Retrieve the delivery areas from the table
		    DefaultTableModel tableModel = (DefaultTableModel) viewAdminEditDeliveryManPanel.getTableDeliveryArea().getModel();
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

		    JOptionPane.showMessageDialog(viewAdminEditDeliveryManPanel, message, "Delivery Man  added",
		            JOptionPane.INFORMATION_MESSAGE);
		    
			// Update other Delivery Man tables Admin
		    viewAdminEditDeliveryManPanel.updateTableDeliveryMan();
		    viewAdminEditDeliveryManPanel.updateTableDeliveryMan();
		    // Update other Delivery Man tables Manager
		    viewManagerEditDeliveryManPanel.updateTableDeliveryMan();
		    
		    // Reset all the fields
		    viewAdminEditDeliveryManPanel.getTfFistName().setText("");
		    viewAdminEditDeliveryManPanel.getTextLastName().setText("");
		    viewAdminEditDeliveryManPanel.getFrmtdtxtfTelephoneNumber_1().setText("");
			((DefaultTableModel) viewAdminEditDeliveryManPanel.getTableDeliveryArea().getModel()).setRowCount(0);
		}
		
	    if (source == viewAdminEditDeliveryManPanel.getBtnUpdateDeliveryArea()) {
			String deliveryArea = viewAdminEditDeliveryManPanel.getFrmtdtxtflDeliveryArea_1().getText();
			DefaultTableModel model = (DefaultTableModel) viewAdminEditDeliveryManPanel.getTableDeliveryArea()
					.getModel();
			model.addRow(new Object[] { deliveryArea });
			viewAdminEditDeliveryManPanel.getFrmtdtxtflDeliveryArea_1().setText("");
		}

		if (source == viewAdminEditDeliveryManPanel.getBtnDeleteDeliveryArea()) {
			DefaultTableModel model = (DefaultTableModel) viewAdminEditDeliveryManPanel.getTableDeliveryArea()
					.getModel();
			int row = viewAdminEditDeliveryManPanel.getTableDeliveryArea().getSelectedRow();
			if (row >= 0) {
				model.removeRow(row);
			}
		}

	
	}

}
	    
	    
	    
	
