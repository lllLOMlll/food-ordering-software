package Client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import Database.User;
import Database.DatabaseUser;
import Login.ControllerLogin;
import Login.ViewLoginFrame;
import Model.Model;

public class ControllerOpenNewAccount implements ActionListener {
	// Creating private variable of my Model
	private Model model;
	// Creating private variables for the Frame and Panel of my Controller
	private ViewOpenNewAccountFrame viewOpenNewAccountFrame;
	private ViewOpenNewAccountPanel viewOpenNewAccountPanel;
	// Creating a private variable Database (to identify the user and his access
	// level)
	private DatabaseUser databaseUser;
	// Creating private variables to other Controllers to which the ControllerLogin
	// connects
	private ControllerLogin controllerLogin;

	public ControllerOpenNewAccount(Model model, ViewOpenNewAccountFrame viewOpenNewAccountFrame,
			ControllerLogin controllerLogin) {
		this.model = model;
		this.viewOpenNewAccountFrame = viewOpenNewAccountFrame;
		this.controllerLogin = controllerLogin;

		// Creating the Panel for the OpenNewAccount
		viewOpenNewAccountPanel = new ViewOpenNewAccountPanel();

		// Adding the panel to the frame
		viewOpenNewAccountFrame.setContentPane(viewOpenNewAccountPanel);

		// Adding the buttons
		viewOpenNewAccountPanel.getBtnReturn().addActionListener(this);
		viewOpenNewAccountPanel.getBtnSave().addActionListener(this);
		viewOpenNewAccountPanel.getBtnVerify().addActionListener(this);
		viewOpenNewAccountPanel.getBtnQuit().addActionListener(this);		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if ((JButton) e.getSource() == viewOpenNewAccountPanel.getBtnReturn()) {
			viewOpenNewAccountFrame.setVisible(false);
			controllerLogin.getViewLoginFrame().setVisible(true);
			controllerLogin.getViewLoginFrame().setNewPanel(controllerLogin.getViewLoginPanel());
			
			// Clear all the info entered by the user
			viewOpenNewAccountPanel.getTfUsername().setText("");
			viewOpenNewAccountPanel.getPwfPassword().setText("");
			viewOpenNewAccountPanel.getPwfConfirmPassword().setText("");
			viewOpenNewAccountPanel.getTfLastName().setText("");
			viewOpenNewAccountPanel.getTfFirstName().setText("");
			viewOpenNewAccountPanel.getTfAddress().setText("");
			viewOpenNewAccountPanel.getTfEmail().setText("");
			viewOpenNewAccountPanel.getFtfPhoneNumber().setText("");
		}

		if ((JButton) e.getSource() == viewOpenNewAccountPanel.getBtnSave()) {
			// Get user input from the form
			String username = viewOpenNewAccountPanel.getTfUsername().getText().trim();
			if (username.isEmpty()) {
			    JOptionPane.showMessageDialog(viewOpenNewAccountFrame, "Please enter a username.", "Error", JOptionPane.ERROR_MESSAGE);
			    return;
			} else if (username.contains(" ")) {
			    JOptionPane.showMessageDialog(viewOpenNewAccountFrame, "Username should not contain spaces", "Error", JOptionPane.ERROR_MESSAGE);
			    return;
			}

			String password = new String(viewOpenNewAccountPanel.getPwfPassword().getPassword()).trim();
			String confirmPassword = new String(viewOpenNewAccountPanel.getPwfConfirmPassword().getPassword()).trim();
			if (password.isEmpty() || confirmPassword.isEmpty()) {
			    JOptionPane.showMessageDialog(viewOpenNewAccountFrame, "Please enter a password and confirm it.", "Error", JOptionPane.ERROR_MESSAGE);
			    return;
			}
			if (password.contains(" ") || confirmPassword.contains(" ")) {
			    JOptionPane.showMessageDialog(viewOpenNewAccountFrame, "The password cannot contain spaces. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
			    return;
			}
			if (!password.equals(confirmPassword)) {
			    JOptionPane.showMessageDialog(viewOpenNewAccountFrame, "The passwords do not match. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
			    return;
			}


			String lastName = viewOpenNewAccountPanel.getTfLastName().getText().trim();
			if (lastName.isEmpty()) {
			    JOptionPane.showMessageDialog(viewOpenNewAccountFrame, "Please enter a last name.", "Error", JOptionPane.ERROR_MESSAGE);
			    return;
			} else if (lastName.matches(".*\\d.*")) {
			    JOptionPane.showMessageDialog(viewOpenNewAccountFrame, "Last name cannot contain numbers.", "Error", JOptionPane.ERROR_MESSAGE);
			    return;
			}


			String firstName = viewOpenNewAccountPanel.getTfFirstName().getText().trim();
			if (firstName.isEmpty()) {
			    JOptionPane.showMessageDialog(viewOpenNewAccountFrame, "Please enter a last name.", "Error", JOptionPane.ERROR_MESSAGE);
			    return;
			} else if (firstName.matches(".*\\d.*")) {
			    JOptionPane.showMessageDialog(viewOpenNewAccountFrame, "Last name cannot contain numbers.", "Error", JOptionPane.ERROR_MESSAGE);
			    return;
			}


			String address = viewOpenNewAccountPanel.getTfAddress().getText().trim();
			if (address.isEmpty()) {
			    JOptionPane.showMessageDialog(viewOpenNewAccountFrame, "Please enter an address.", "Error", JOptionPane.ERROR_MESSAGE);
			    return;
			}

			String email = viewOpenNewAccountPanel.getTfEmail().getText().trim();
			if (email.isEmpty()) {
			    JOptionPane.showMessageDialog(viewOpenNewAccountFrame, "Please enter an email address.", "Error", JOptionPane.ERROR_MESSAGE);
			    return;
			}
			/*Email validation explanation
			 *  \\b: Matches a word boundary, which means it matches the beginning or end of a word (in this case, the email address).
				[\\w.%-]+: Matches one or more word characters (\\w, which includes letters, digits, and underscores), dots (.), percent signs (%), and hyphens (-).
				@: Matches the "@" symbol, which separates the local part of the email address from the domain part.
				[-.\\w]+: Matches one or more word characters, dots, and hyphens in the domain part of the email address.
				\\.: Matches a literal dot character.
				[A-Za-z]{2,4}: Matches two to four letters (either uppercase or lowercase) at the end of the email address, which represents the top-level domain (such as .com, .edu, .org, etc.).
			 */
			if (!email.matches("\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b")) {
			    JOptionPane.showMessageDialog(viewOpenNewAccountFrame, "Please enter a valid email address.", "Error", JOptionPane.ERROR_MESSAGE);
			    return;
			}

			String phoneNumber = viewOpenNewAccountPanel.getFtfPhoneNumber().getText().replaceAll("[^\\d]", "");
			String unmaskedPhoneNumber = viewOpenNewAccountPanel.getFtfPhoneNumber().getText().replaceAll("\\D", "");
			if (unmaskedPhoneNumber.length() != 10) {
			    JOptionPane.showMessageDialog(viewOpenNewAccountFrame, "Please enter a 10-digit phone number.", "Error", JOptionPane.ERROR_MESSAGE);
			    return;
			}

			// Verify that the username don't already exist
			if (model.getUserDatabase().containsUser(username)) {
			    JOptionPane.showMessageDialog(viewOpenNewAccountFrame, "This username already exists. Please choose another username.", "Error", JOptionPane.ERROR_MESSAGE);
			    return;
			}

			// Create a new User object
			User newUser = new User(username, password, lastName, firstName, address, email, phoneNumber, "client", "");

			// Add the new user to the database
			model.getUserDatabase().addUser(newUser, "");

			// Display a success message
			JOptionPane.showMessageDialog(viewOpenNewAccountFrame, "User account has been created successfully.",
					"Success", JOptionPane.INFORMATION_MESSAGE);

			// Clear all the info entered by the user
			viewOpenNewAccountPanel.getTfUsername().setText("");
			viewOpenNewAccountPanel.getPwfPassword().setText("");
			viewOpenNewAccountPanel.getPwfConfirmPassword().setText("");
			viewOpenNewAccountPanel.getTfLastName().setText("");
			viewOpenNewAccountPanel.getTfFirstName().setText("");
			viewOpenNewAccountPanel.getTfAddress().setText("");
			viewOpenNewAccountPanel.getTfEmail().setText("");
			viewOpenNewAccountPanel.getFtfPhoneNumber().setText("");

			// Get back to the login screen
			viewOpenNewAccountFrame.setVisible(false);
			controllerLogin.getViewLoginFrame().setVisible(true);
			controllerLogin.getViewLoginFrame().setNewPanel(controllerLogin.getViewLoginPanel());
		}
		
		if ((JButton) e.getSource() == viewOpenNewAccountPanel.getBtnQuit()) {
			JOptionPane.showMessageDialog(null, "Thank you for using a MajorSofware product", "Exit",
					JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		}
		
		if ((JButton) e.getSource() == viewOpenNewAccountPanel.getBtnVerify()) {
			String username = viewOpenNewAccountPanel.getTfUsername().getText().trim();
			if (username.isEmpty()) {
			    JOptionPane.showMessageDialog(viewOpenNewAccountFrame, "Please enter a username.", "Error", JOptionPane.ERROR_MESSAGE);
			    return;
			}

			if (model.getUserDatabase().containsUser(username)) {
			    JOptionPane.showMessageDialog(viewOpenNewAccountFrame, "This username already exists. Please choose another username.", "Error", JOptionPane.ERROR_MESSAGE);
			    return;
			}

			JOptionPane.showMessageDialog(viewOpenNewAccountFrame, "This username is available.", "Success", JOptionPane.INFORMATION_MESSAGE);

		}
	}

}
