package Manager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Admin.ControllerAdmin;
import Admin.ViewAdminAddNewDeliveryManPanel;
import Admin.ViewAdminDeleteDeliveryManPanel;
import Admin.ViewAdminEditDeliveryManPanel;
import Database.DeliveryMan;
import Model.Model;
import Validation.Validation;

public class ControllerManagerEditDeliveryMan implements ActionListener{
	private Model model;
    private ViewManagerEditDeliveryManPanel viewManagerEditDeliveryManPanel;
    private ControllerManager controllerManager;
    private ControllerAdmin controllerAdmin;
    
    private ViewAdminAddNewDeliveryManPanel viewAdminAddNewDeliveryManPanel;
    private ViewAdminEditDeliveryManPanel viewAdminEditDeliveryManPanel;
    private ViewAdminDeleteDeliveryManPanel viewAdminDeleteDeliveryManPanel;
	
    public ControllerManagerEditDeliveryMan(Model model, ViewManagerEditDeliveryManPanel viewManagerEditDeliveryManPanel, ControllerManager controllerManager, ControllerAdmin controllerAdmin) {
        this.model = model;
        this.viewManagerEditDeliveryManPanel = viewManagerEditDeliveryManPanel;
        this.controllerManager = controllerManager;
        this.controllerAdmin = controllerAdmin;
        
        this.viewAdminEditDeliveryManPanel = controllerAdmin.getViewAdminEditDeliveryManPanel();
        this.viewAdminDeleteDeliveryManPanel = controllerAdmin.getViewAdminDeleteDeliveryManPanel();
    
        // Adding the buttons
        viewManagerEditDeliveryManPanel.getBtnSaveDeliveryArea().addActionListener(this);
        viewManagerEditDeliveryManPanel.getBtnDeleteDeliveryArea().addActionListener(this);
        viewManagerEditDeliveryManPanel.getBtnSaveDeliveryMan().addActionListener(this);
        viewManagerEditDeliveryManPanel.getBtnUpdateDeliveryArea().addActionListener(this);
        viewManagerEditDeliveryManPanel.getBtnSelectDeliveryMan().addActionListener(this);
        
    }
	
	
    @Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
	    if (source == viewManagerEditDeliveryManPanel.getBtnSelectDeliveryMan()) {
	        // Get the selected row from the delivery man table
	        int selectedRow = viewManagerEditDeliveryManPanel.getTableDeliveryMan().getSelectedRow();
	        if (selectedRow != -1) { // Check that a row is actually selected
	            // Get the first name of the selected delivery man
	            String firstName = (String) viewManagerEditDeliveryManPanel.getTableDeliveryMan().getValueAt(selectedRow, 0);  
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
	            	viewManagerEditDeliveryManPanel.getTfFistName().setText(deliveryMan.getFirstName());
	            	viewManagerEditDeliveryManPanel.getTextLastName().setText(deliveryMan.getLastName());
	            	viewManagerEditDeliveryManPanel.getFrmtdtxtfTelephoneNumber_1().setText(deliveryMan.getPhoneNumber());
	                // Display the delivery man's delivery areas in the table
	                DefaultTableModel deliveryAreaTableModel = (DefaultTableModel) viewManagerEditDeliveryManPanel.getTableDeliveryArea().getModel();
	                deliveryAreaTableModel.setRowCount(0);
	                for (String deliveryArea : deliveryMan.getDeliveryAreas()) {
	                    deliveryAreaTableModel.addRow(new Object[] {deliveryArea});
	                }
	            }
	        }
	    }
	    
		if (source == viewManagerEditDeliveryManPanel.getBtnSaveDeliveryMan()) {
		    // Get data from the fields
		    String firstName = viewManagerEditDeliveryManPanel.getTfFistName().getText();
		    if (!Validation.isValidName(firstName, viewManagerEditDeliveryManPanel)) {
		        return;
		    }
		    String lastName = viewManagerEditDeliveryManPanel.getTextLastName().getText();
		    if (!Validation.isValidName(lastName, viewManagerEditDeliveryManPanel)) {
		        return;
		    }
		    String telephoneNumber = viewManagerEditDeliveryManPanel.getFrmtdtxtfTelephoneNumber_1().getText();

		 // Retrieve the delivery areas from the table
		    DefaultTableModel tableModel = (DefaultTableModel) viewManagerEditDeliveryManPanel.getTableDeliveryArea().getModel();
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

		    JOptionPane.showMessageDialog(viewManagerEditDeliveryManPanel, message, "Delivery Man  added",
		            JOptionPane.INFORMATION_MESSAGE);
		    
			// Update other Delivery Man tables (Admin)
//		    viewAdminAddNewDeliveryManPanel.updateTableDeliveryMan();
		    viewAdminEditDeliveryManPanel.updateTableDeliveryMan();
		    viewAdminDeleteDeliveryManPanel.updateTableDeliveryMan();
		    // Update other Delivery Man tables (Manager)
		    viewManagerEditDeliveryManPanel.updateTableDeliveryMan();
		    
		    // Reset all the fields
		    viewManagerEditDeliveryManPanel.getTfFistName().setText("");
		    viewManagerEditDeliveryManPanel.getTextLastName().setText("");
		    viewManagerEditDeliveryManPanel.getFrmtdtxtfTelephoneNumber_1().setText("");
			((DefaultTableModel) viewManagerEditDeliveryManPanel.getTableDeliveryArea().getModel()).setRowCount(0);
		}
		
	    if (source == viewManagerEditDeliveryManPanel.getBtnUpdateDeliveryArea()) {
			String deliveryArea = viewManagerEditDeliveryManPanel.getFrmtdtxtflDeliveryArea_1().getText();
			DefaultTableModel model = (DefaultTableModel) viewManagerEditDeliveryManPanel.getTableDeliveryArea()
					.getModel();
			model.addRow(new Object[] { deliveryArea });
			viewManagerEditDeliveryManPanel.getFrmtdtxtflDeliveryArea_1().setText("");
		}

		if (source == viewManagerEditDeliveryManPanel.getBtnDeleteDeliveryArea()) {
			DefaultTableModel model = (DefaultTableModel) viewManagerEditDeliveryManPanel.getTableDeliveryArea()
					.getModel();
			int row = viewManagerEditDeliveryManPanel.getTableDeliveryArea().getSelectedRow();
			if (row >= 0) {
				model.removeRow(row);
			}
		}

	
	}

}
	    
	    
	    
	
