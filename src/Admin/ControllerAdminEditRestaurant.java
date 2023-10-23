package Admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Database.Restaurant;
import Model.Model;


public class ControllerAdminEditRestaurant implements ActionListener{
    private Model model;
    private ViewAdminEditRestaurantPanel viewAdminEditRestaurantPanel;
    private ControllerAdmin controllerAdmin;
    
    public ControllerAdminEditRestaurant(Model model, ViewAdminEditRestaurantPanel viewAdminEditRestaurantPanel, ControllerAdmin controllerAdmin) {
        this.model = model;
        this.viewAdminEditRestaurantPanel = viewAdminEditRestaurantPanel;
        this.controllerAdmin = controllerAdmin;
        
        // Adding the buttons
        viewAdminEditRestaurantPanel.getBtnSelect().addActionListener(this);
        viewAdminEditRestaurantPanel.getBtnSave().addActionListener(this);
        
    }


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == viewAdminEditRestaurantPanel.getBtnSelect()) {
	        // Get the selected row index
	        int rowIndex = viewAdminEditRestaurantPanel.getTable().getSelectedRow();
	        if (rowIndex >= 0) {
	            // Get the name of the restaurant from the selected row
	            String restaurantName = (String) viewAdminEditRestaurantPanel.getTable().getValueAt(rowIndex, 0);

	            // Retrieve the restaurant object from the database
	            Restaurant retrievedRestaurant = model.getRestaurantDatabase().getRestaurant(restaurantName);


	            // Retrieve the name, address, phone number, postal code, opening and closing time of the restaurant
	            String restaurantNameDatabase = retrievedRestaurant.getName();	           
	            String restaurantAddress = retrievedRestaurant.getAddress();
	            String restaurantPhoneNumber = retrievedRestaurant.getTelephoneNumber();
	          

	            // Retrieve the postal codes from the retrieved restaurant
	            List<String> postalCodes = retrievedRestaurant.getDeliveryAreas();

	            // Get the table model for the postal codes table
	            DefaultTableModel postalCodeTableModel = (DefaultTableModel) viewAdminEditRestaurantPanel.getTableDeliveryArea().getModel();

	            // Clear the table model (otherwise, all the postal codes will add to each other)
	            postalCodeTableModel.setRowCount(0);

	            // Add the postal codes to the table model
	            for (String postalCode : postalCodes) {
	                postalCodeTableModel.addRow(new Object[] { postalCode });
	            }

	            // Set the updated table model on the table
	            viewAdminEditRestaurantPanel.getTableDeliveryArea().setModel(postalCodeTableModel);

	            

	            String sundayOpening1 = retrievedRestaurant.getSundayOpening1();
	            String sundayOpening2 = retrievedRestaurant.getSundayOpening2();
	            String sundayClosing1 = retrievedRestaurant.getSundayClosing1();
	            String sundayClosing2 = retrievedRestaurant.getSundayClosing2();
	            
	            String mondayOpening1 = retrievedRestaurant.getMondayOpening1();
	            String mondayOpening2 = retrievedRestaurant.getMondayOpening2();
	            String mondayClosing1 = retrievedRestaurant.getMondayClosing1();
	            String mondayClosing2 = retrievedRestaurant.getMondayClosing2();
	            
	            String tuesdayOpening1 = retrievedRestaurant.getTuesdayOpening1();
	            String tuesdayOpening2 = retrievedRestaurant.getTuesdayOpening2();
	            String tuesdayClosing1 = retrievedRestaurant.getTuesdayClosing1();
	            String tuesdayClosing2 = retrievedRestaurant.getTuesdayClosing2();
	            
	            String wednesdayOpening1 = retrievedRestaurant.getWednesdayOpening1();
	            String wednesdayOpening2 = retrievedRestaurant.getWednesdayOpening2();
	            String wednesdayClosing1 = retrievedRestaurant.getWednesdayClosing1();
	            String wednesdayClosing2 = retrievedRestaurant.getWednesdayClosing2();
	            
	            String thursdayOpening1 = retrievedRestaurant.getThursdayOpening1();
	            String thursdayOpening2 = retrievedRestaurant.getThursdayOpening2();
	            String thursdayClosing1 = retrievedRestaurant.getThursdayClosing1();
	            String thursdayClosing2 = retrievedRestaurant.getThursdayClosing2();
	            
	            String fridayOpening1 = retrievedRestaurant.getFridayOpening1();
	            String fridayOpening2 = retrievedRestaurant.getFridayOpening2();
	            String fridayClosing1 = retrievedRestaurant.getFridayClosing1();
	            String fridayClosing2 = retrievedRestaurant.getFridayClosing2();
	            
	            String saturdayOpening1 = retrievedRestaurant.getSaturdayOpening1();
	            String saturdayOpening2 = retrievedRestaurant.getSaturdayOpening2();
	            String saturdayClosing1 = retrievedRestaurant.getSaturdayClosing1();
	            String saturdayClosing2 = retrievedRestaurant.getSaturdayClosing2();
	            

	            // Update the text field with the data of the restaurant
	            viewAdminEditRestaurantPanel.getTfRestaurantName().setText(restaurantNameDatabase);
	            viewAdminEditRestaurantPanel.getTfRestaurantAddress().setText(restaurantAddress);
	            viewAdminEditRestaurantPanel.getFrmtdtxtfTelephoneNumber().setText(restaurantPhoneNumber);
	            
	            viewAdminEditRestaurantPanel.getCbSundayOpening1().setSelectedItem(sundayOpening1);
	            viewAdminEditRestaurantPanel.getCbSundayOpening2().setSelectedItem(sundayOpening2);
	            viewAdminEditRestaurantPanel.getCbSundayClosing1().setSelectedItem(sundayClosing1);
	            viewAdminEditRestaurantPanel.getCbSundayClosing2().setSelectedItem(sundayClosing2);
	            
	            viewAdminEditRestaurantPanel.getCbMondayOpening1().setSelectedItem(mondayOpening1);
	            viewAdminEditRestaurantPanel.getCbMondayOpening2().setSelectedItem(mondayOpening2);
	            viewAdminEditRestaurantPanel.getCbMondayClosing1().setSelectedItem(mondayClosing1);
	            viewAdminEditRestaurantPanel.getCbMondayClosing2().setSelectedItem(mondayClosing2);
	            
	            viewAdminEditRestaurantPanel.getCbTuesdayOpening1().setSelectedItem(tuesdayOpening1);
	            viewAdminEditRestaurantPanel.getCbTuesdayOpening2().setSelectedItem(tuesdayOpening2);
	            viewAdminEditRestaurantPanel.getCbTuesdayClosing1().setSelectedItem(tuesdayClosing1);
	            viewAdminEditRestaurantPanel.getCbTuesdayClosing2().setSelectedItem(tuesdayClosing2);
	            
	            viewAdminEditRestaurantPanel.getCbWednesdayOpening1().setSelectedItem(wednesdayOpening1);
	            viewAdminEditRestaurantPanel.getCbWednesdayOpening2().setSelectedItem(wednesdayOpening2);
	            viewAdminEditRestaurantPanel.getCbWednesdayClosing1().setSelectedItem(wednesdayClosing1);
	            viewAdminEditRestaurantPanel.getCbWednesdayClosing2().setSelectedItem(wednesdayClosing2);
	            
	            viewAdminEditRestaurantPanel.getCbThursdayOpening1().setSelectedItem(thursdayOpening1);
	            viewAdminEditRestaurantPanel.getCbThursdayOpening2().setSelectedItem(thursdayOpening2);
	            viewAdminEditRestaurantPanel.getCbThursdayClosing1().setSelectedItem(thursdayClosing1);
	            viewAdminEditRestaurantPanel.getCbThursdayClosing2().setSelectedItem(thursdayClosing2);
	            
	            viewAdminEditRestaurantPanel.getCbFridayOpening1().setSelectedItem(fridayOpening1);
	            viewAdminEditRestaurantPanel.getCbFridayOpening2().setSelectedItem(fridayOpening2);
	            viewAdminEditRestaurantPanel.getCbFridayClosing1().setSelectedItem(fridayClosing1);
	            viewAdminEditRestaurantPanel.getCbFridayClosing2().setSelectedItem(fridayClosing2);
	            
	            viewAdminEditRestaurantPanel.getCbSaturdayOpening1().setSelectedItem(saturdayOpening1);
	            viewAdminEditRestaurantPanel.getCbSaturdayOpening2().setSelectedItem(saturdayOpening2);
	            viewAdminEditRestaurantPanel.getCbSaturdayClosing1().setSelectedItem(saturdayClosing1);
	            viewAdminEditRestaurantPanel.getCbSaturdayClosing2().setSelectedItem(saturdayClosing2);
	        }
	    }
		
		if (e.getSource() == viewAdminEditRestaurantPanel.getBtnSave()) {
		    // Debugging: Print a message to indicate that the Save button was clicked
		    System.out.println("Save button clicked.");

		    // Debugging: Print the name of the restaurant you're trying to retrieve
		    String restaurantName = viewAdminEditRestaurantPanel.getTfRestaurantName().getText();
		    System.out.println("Trying to retrieve restaurant with name: " + restaurantName);

		    // Debugging: Print all stored restaurant names in the database
		    model.getRestaurantDatabase().debugPrintAllRestaurants();

		    // Retrieve the restaurant object from the database
		    Restaurant retrievedRestaurant = model.getRestaurantDatabase().getRestaurant(restaurantName);

		    // Debugging: Print the retrieved restaurant object
		    System.out.println("Retrieved restaurant object: " + retrievedRestaurant);

		    if (retrievedRestaurant != null) {  // Check if retrievedRestaurant is null
		        // Update the fields of the retrieved restaurant object
		        retrievedRestaurant.setName(viewAdminEditRestaurantPanel.getTfRestaurantName().getText());
		        retrievedRestaurant.setAddress(viewAdminEditRestaurantPanel.getTfRestaurantAddress().getText());
		        retrievedRestaurant.setTelephoneNumber(viewAdminEditRestaurantPanel.getFrmtdtxtfTelephoneNumber().getText());

		        // Save the updated restaurant object back to the database
		        model.getRestaurantDatabase().addRestaurant(retrievedRestaurant);

		        // Show a message to confirm the update
		        JOptionPane.showMessageDialog(null, "Restaurant information updated successfully.");
		    } else {
		        // Debugging: Print a message if the restaurant is not found
		        System.out.println("Restaurant not found in the database.");
		        JOptionPane.showMessageDialog(null, "Restaurant not found in the database.");
		    }
		}



		}
		
	}
