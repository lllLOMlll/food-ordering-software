package Client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Database.User;
import Model.Model;

public class ControllerClientEditAccount implements ActionListener {
	private Model model;
	private ViewClientEditAccountPanel viewClientEditAccountPanel;
	private ControllerClient controllerClient;
	private String username;
	private String unmaskedPhoneNumber;

	public ControllerClientEditAccount(Model model, ViewClientEditAccountPanel viewClientEditAccountPanel,
			ControllerClient controllerClient) {
		this.model = model;
		this.viewClientEditAccountPanel = viewClientEditAccountPanel;
		this.controllerClient = controllerClient;

		// Adding the buttons
		viewClientEditAccountPanel.getBtnVerify().addActionListener(this);
		viewClientEditAccountPanel.getBtnSave().addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();

		// Verify Username
		if (source == viewClientEditAccountPanel.getBtnVerify()) {
			String username = viewClientEditAccountPanel.getTfUsername().getText().trim();
			if (username.isEmpty()) {
				JOptionPane.showMessageDialog(viewClientEditAccountPanel, "Please enter a username", "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			if (model.getUserDatabase().containsUser(username)) {
				JOptionPane.showMessageDialog(viewClientEditAccountPanel, "This username already exist", "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			JOptionPane.showMessageDialog(viewClientEditAccountPanel, "This username is available.", "Success",
					JOptionPane.INFORMATION_MESSAGE);
		}

		// Saving
		if (source == viewClientEditAccountPanel.getBtnSave()) {
			String username = viewClientEditAccountPanel.getTfUsername().getText();
			if (username.isEmpty()) {
				JOptionPane.showMessageDialog(viewClientEditAccountPanel, "Username cannot be empty", "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			} else if (username.contains(" ")) {
				JOptionPane.showMessageDialog(viewClientEditAccountPanel, "Username should not contain spaces", "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			String password = new String(viewClientEditAccountPanel.getPwfPassword().getPassword()).trim();
			String confirmPassword = new String(viewClientEditAccountPanel.getPwfConfirmPassword().getPassword())
					.trim();
			if (password.isEmpty() || confirmPassword.isEmpty()) {
				JOptionPane.showMessageDialog(viewClientEditAccountPanel, "Please enter a password and confirm it.",
						"Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			if (password.contains(" ") || confirmPassword.contains(" ")) {
				JOptionPane.showMessageDialog(viewClientEditAccountPanel,
						"The password cannot contain spaces. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			if (!password.equals(confirmPassword)) {
				JOptionPane.showMessageDialog(viewClientEditAccountPanel,
						"The passwords do not match. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			String lastName = viewClientEditAccountPanel.getTfLastName().getText();
			if (lastName.isEmpty()) {
				JOptionPane.showConfirmDialog(viewClientEditAccountPanel, "Last Name cannot be empty", "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			} else if (lastName.matches(".*\\d.*")) {
				JOptionPane.showMessageDialog(viewClientEditAccountPanel, "Last name cannot contain numbers.", "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			String oldPassword = new String(viewClientEditAccountPanel.getPwfOldPassword().getPassword()).trim();
			boolean isOldPasswordCorrect = model.isOldPasswordCorrect(username, oldPassword);

			if (!isOldPasswordCorrect) {
			    JOptionPane.showMessageDialog(viewClientEditAccountPanel, "Old password does not match.", "Error",
			            JOptionPane.ERROR_MESSAGE);
			    return;
			} else {
			    // Continue with the process (e.g., updating the user's information)
			}

			
			String firstName = viewClientEditAccountPanel.getTfFirstName().getText();
			if (firstName.isEmpty()) {
				JOptionPane.showConfirmDialog(viewClientEditAccountPanel, "First Name cannot be empty", "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			} else if (lastName.matches(".*\\d.*")) {
				JOptionPane.showMessageDialog(viewClientEditAccountPanel, "First name cannot contain numbers.", "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			String email = viewClientEditAccountPanel.getTfEmail().getText();
			if (email.isEmpty()) {
				JOptionPane.showMessageDialog(viewClientEditAccountPanel, "Please enter an email address.", "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			/*
			 * Email validation explanation \\b: Matches a word boundary, which means it
			 * matches the beginning or end of a word (in this case, the email address).
			 * [\\w.%-]+: Matches one or more word characters (\\w, which includes letters,
			 * digits, and underscores), dots (.), percent signs (%), and hyphens (-).
			 * 
			 * @: Matches the "@" symbol, which separates the local part of the email
			 * address from the domain part. [-.\\w]+: Matches one or more word characters,
			 * dots, and hyphens in the domain part of the email address. \\.: Matches a
			 * literal dot character. [A-Za-z]{2,4}: Matches two to four letters (either
			 * uppercase or lowercase) at the end of the email address, which represents the
			 * top-level domain (such as .com, .edu, .org, etc.).
			 */
			if (!email.matches("\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b")) {
				JOptionPane.showMessageDialog(viewClientEditAccountPanel, "Please enter a valid email address.",
						"Error", JOptionPane.ERROR_MESSAGE);
				return;
			}

			String address = viewClientEditAccountPanel.getTfAddress().getText();
			if (address.isEmpty()) {
				JOptionPane.showMessageDialog(viewClientEditAccountPanel, "Please enter an address.", "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			String phoneNumber = viewClientEditAccountPanel.getFtfPhoneNumber().getText().replaceAll("[^\\d]", "");
			String unmaskedPhoneNumber = viewClientEditAccountPanel.getFtfPhoneNumber().getText().replaceAll("\\D", "");
			if (unmaskedPhoneNumber.length() != 10) {
			    JOptionPane.showMessageDialog(viewClientEditAccountPanel, "Please enter a 10-digit phone number.", "Error", JOptionPane.ERROR_MESSAGE);
			    return;
			}
			
	
			User user = model.getUserDatabase().getUser(username);
			// Verify that the username don't already exist
			if (model.getUserDatabase().containsUser(username)) {
				 if (username.equals(user.getUsername())) {
					 
				 } else {
				JOptionPane.showMessageDialog(viewClientEditAccountPanel,
						"This username already exists. Please choose another username.", "Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			}

			// Create a new User object
			User newUser = new User(username, password, lastName, firstName, address, email, phoneNumber, "client", "");

			// Add the new user to the database
			model.getUserDatabase().addUser(newUser, "");

			// Display a success message
			JOptionPane.showMessageDialog(viewClientEditAccountPanel, "User account has been created successfully.",
					"Success", JOptionPane.INFORMATION_MESSAGE);

			// Clear all the info entered by the user
			viewClientEditAccountPanel.getTfUsername().setText("");
			viewClientEditAccountPanel.getPwfPassword().setText("");
			viewClientEditAccountPanel.getPwfConfirmPassword().setText("");
			viewClientEditAccountPanel.getTfLastName().setText("");
			viewClientEditAccountPanel.getTfFirstName().setText("");
			viewClientEditAccountPanel.getTfAddress().setText("");
			viewClientEditAccountPanel.getTfEmail().setText("");
			viewClientEditAccountPanel.getFtfPhoneNumber_1().setText("");
			viewClientEditAccountPanel.getPwfOldPassword().setText("");
		}

	}
}
