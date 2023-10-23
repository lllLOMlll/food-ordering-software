package Client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.JOptionPane;

import Login.ControllerLogin;
import Model.Model;

public class ControllerClientDeleteAccount implements ActionListener{
	private Model model;
    private ViewClientDeleteAccountPanel viewClientDeleteAccountPanel;
    private ControllerClient controllerClient;
    private ControllerLogin controllerLogin;
	
    public ControllerClientDeleteAccount(Model model, ViewClientDeleteAccountPanel viewClientDeleteAccountPanel, ControllerClient controllerClient) {
        this.model = model;
        this.viewClientDeleteAccountPanel = viewClientDeleteAccountPanel;
        this.controllerClient = controllerClient;
        this.controllerLogin = controllerLogin;
    
        // Adding the buttons
        viewClientDeleteAccountPanel.getBtnDelete().addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == viewClientDeleteAccountPanel.getBtnDelete()) {
            String clientUsername = model.getCurrentUser().getUsername();

            String confirmPassword = new String(viewClientDeleteAccountPanel.getPwfConfirmPassword().getPassword());
            boolean isOldPasswordCorrect = model.isOldPasswordCorrect(clientUsername, confirmPassword);

            if (!isOldPasswordCorrect) {
                JOptionPane.showMessageDialog(viewClientDeleteAccountPanel, "This is not your password.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            } else {
                // Remove the user
                model.getUserDatabase().removeUser(clientUsername);
                JOptionPane.showMessageDialog(viewClientDeleteAccountPanel, "Your account has been deleted!", "Confirmation",
                        JOptionPane.INFORMATION_MESSAGE);
                
             // Get back to the login screen
//                viewClientDeleteAccountPanel.setVisible(false);
//    			controllerLogin.getViewLoginFrame().setVisible(true);
//    			controllerLogin.getViewLoginFrame().setNewPanel(controllerLogin.getViewLoginPanel());
            }
        }
    }
}
