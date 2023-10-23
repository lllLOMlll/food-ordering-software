package Admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Database.DeliveryMan;
import Model.Model;

public class ControllerAdminDeleteDeliveryMan implements ActionListener{
	private Model model;
    private ViewAdminDeleteDeliveryManPanel viewAdminDeleteDeliveryManPanel;
    private ControllerAdmin controllerAdmin;
    private ViewAdminAddNewDeliveryManPanel viewAdminAddNewDeliveryManPanel;
    private ViewAdminEditDeliveryManPanel viewAdminEditDeliveryManPanel;
    
    public ControllerAdminDeleteDeliveryMan(Model model, ViewAdminDeleteDeliveryManPanel viewAdminDeleteDeliveryManPanel, 
    		ControllerAdmin controllerAdmin, ViewAdminAddNewDeliveryManPanel viewAdminAddNewDeliveryManPanel) {
        this.model = model;
        this.viewAdminDeleteDeliveryManPanel = viewAdminDeleteDeliveryManPanel;
        this.controllerAdmin = controllerAdmin;
        this.viewAdminAddNewDeliveryManPanel = viewAdminAddNewDeliveryManPanel;
        this.viewAdminEditDeliveryManPanel = controllerAdmin.getViewAdminEditDeliveryManPanel();
        
        // Adding the buttons
        viewAdminDeleteDeliveryManPanel.getBtnDelete().addActionListener(this);

        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewAdminDeleteDeliveryManPanel.getBtnDelete()) {
            // Get the selected row index
            int rowIndex = viewAdminDeleteDeliveryManPanel.getTableDeliveryMan().getSelectedRow();
            if (rowIndex >= 0) {
                // Get the delivery man from the selected row
                DeliveryMan deliveryMan = model.getDeliveryManDatabase().getAllDeliveryMen().get(rowIndex);
                String firstName = deliveryMan.getFirstName();

                // Display a confirmation dialog box
                int option = JOptionPane.showConfirmDialog(null,
                        "Are you sure you want to delete the delivery man " + firstName + "?");
                if (option == JOptionPane.YES_OPTION) {
                    // Remove the delivery man from the database
                    model.getDeliveryManDatabase().removeDeliveryMan(deliveryMan.getPhoneNumber());
                    // Remove the delivery man from the table
                    DefaultTableModel tableModel = (DefaultTableModel) viewAdminDeleteDeliveryManPanel.getTableDeliveryMan()
                            .getModel();
                    tableModel.removeRow(rowIndex);
                    
                //Update table DeliveryMan
                viewAdminEditDeliveryManPanel.updateTableDeliveryMan();
                }
            }
        }
    }
}
