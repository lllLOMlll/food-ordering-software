package Client;

import java.awt.Component;
import java.awt.Font;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import Model.Model;

public class ViewClientEditAccountPanel extends JPanel {

	private JFormattedTextField ftfPhoneNumber;
	private JTextField tfUsername;
	private JButton btnVerify;
	private JPasswordField pwfPassword;
	private JPasswordField pwfOldPassword;
	private JPasswordField pwfConfirmPassword;
	private JTextField tfLastName;
	private JTextField tfFirstName;
	private JTextField tfAddress;
	private JTextField tfEmail;
	private JFormattedTextField ftfPhoneNumber_1;
	private JButton btnSave;
	private Model model;

	/**
	 * Create the panel.
	 */
	public ViewClientEditAccountPanel(Model model) {
		this.model = model;
		setBounds(100, 100, 1200, 680);
		setLayout(null);
		
		JLabel lbEditClientAccount = new JLabel("Edit Client Account");
		lbEditClientAccount.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbEditClientAccount.setBounds(142, 11, 149, 33);
		add(lbEditClientAccount);

		JLabel lbConfirmPassword = new JLabel("New Password");
		lbConfirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lbConfirmPassword.setBounds(28, 129, 102, 14);
		add(lbConfirmPassword);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblUsername.setBounds(28, 67, 102, 14);
		add(lblUsername);

		JLabel lbConfirmPassword_2 = new JLabel("Confirm Password");
		lbConfirmPassword_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lbConfirmPassword_2.setBounds(28, 157, 102, 14);
		add(lbConfirmPassword_2);

		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblLastName.setBounds(28, 188, 102, 14);
		add(lblLastName);

		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblFirstName.setBounds(28, 216, 102, 14);
		add(lblFirstName);

		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblAddress.setBounds(28, 250, 102, 14);
		add(lblAddress);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblEmail.setBounds(28, 278, 102, 14);
		add(lblEmail);

		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPhoneNumber.setBounds(28, 306, 102, 14);
		add(lblPhoneNumber);

		tfUsername = new JTextField();
		tfUsername.setColumns(10);
		tfUsername.setBounds(122, 64, 206, 20);
		add(tfUsername);

		tfLastName = new JTextField();
		tfLastName.setColumns(10);
		tfLastName.setBounds(122, 185, 206, 20);
		add(tfLastName);

		tfFirstName = new JTextField();
		tfFirstName.setColumns(10);
		tfFirstName.setBounds(122, 213, 206, 20);
		add(tfFirstName);

		tfAddress = new JTextField();
		tfAddress.setColumns(10);
		tfAddress.setBounds(122, 244, 206, 20);
		add(tfAddress);

		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		tfEmail.setBounds(122, 275, 206, 20);
		add(tfEmail);

		pwfPassword = new JPasswordField();
		pwfPassword.setBounds(122, 126, 206, 20);
		add(pwfPassword);

		pwfConfirmPassword = new JPasswordField();
		pwfConfirmPassword.setBounds(122, 154, 206, 20);
		add(pwfConfirmPassword);

		JLabel homeTelephoneLabel = new JLabel("Home telephone: ");
		 try {
	            MaskFormatter telephoneNumber = new MaskFormatter("(###) ###-####");
	            ftfPhoneNumber_1 = new JFormattedTextField(telephoneNumber);
	            ftfPhoneNumber_1.setBounds(122, 303, 206, 20);
	            add(ftfPhoneNumber_1);
	        } catch (ParseException e) {
	     
	            ftfPhoneNumber_1 = null;
	        }

		// Set the formatted text field's value
		 this.ftfPhoneNumber = ftfPhoneNumber_1;

		btnVerify = new JButton("Verify");
		btnVerify.setBounds(335, 62, 89, 23);
		add(btnVerify);

		btnSave = new JButton("Save");
		btnSave.setBounds(181, 334, 89, 23);
		add(btnSave);
		
		JLabel lblOldPassword = new JLabel("Old Password");
		lblOldPassword.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblOldPassword.setBounds(28, 101, 102, 14);
		add(lblOldPassword);
		
		pwfOldPassword = new JPasswordField();
		pwfOldPassword.setBounds(122, 95, 206, 20);
		add(pwfOldPassword);
	}

	/**
	 * @return the ftfPhoneNumber
	 */
	public JFormattedTextField getFtfPhoneNumber() {
		return ftfPhoneNumber;
	}

	/**
	 * @param ftfPhoneNumber the ftfPhoneNumber to set
	 */
	public void setFtfPhoneNumber(JFormattedTextField ftfPhoneNumber) {
		this.ftfPhoneNumber = ftfPhoneNumber;
	}

	/**
	 * @return the tfUsername
	 */
	public JTextField getTfUsername() {
		return tfUsername;
	}

	/**
	 * @param tfUsername the tfUsername to set
	 */
	public void setTfUsername(JTextField tfUsername) {
		this.tfUsername = tfUsername;
	}

	/**
	 * @return the btnVerify
	 */
	public JButton getBtnVerify() {
		return btnVerify;
	}

	/**
	 * @param btnVerify the btnVerify to set
	 */
	public void setBtnVerify(JButton btnVerify) {
		this.btnVerify = btnVerify;
	}

	/**
	 * @return the pwfPassword
	 */
	public JPasswordField getPwfPassword() {
		return pwfPassword;
	}

	/**
	 * @param pwfPassword the pwfPassword to set
	 */
	public void setPwfPassword(JPasswordField pwfPassword) {
		this.pwfPassword = pwfPassword;
	}

	/**
	 * @return the pwfOldPassword
	 */
	public JPasswordField getPwfOldPassword() {
		return pwfOldPassword;
	}

	/**
	 * @param pwfOldPassword the pwfOldPassword to set
	 */
	public void setPwfOldPassword(JPasswordField pwfOldPassword) {
		this.pwfOldPassword = pwfOldPassword;
	}

	/**
	 * @return the pwfConfirmPassword
	 */
	public JPasswordField getPwfConfirmPassword() {
		return pwfConfirmPassword;
	}

	/**
	 * @param pwfConfirmPassword the pwfConfirmPassword to set
	 */
	public void setPwfConfirmPassword(JPasswordField pwfConfirmPassword) {
		this.pwfConfirmPassword = pwfConfirmPassword;
	}

	/**
	 * @return the tfLastName
	 */
	public JTextField getTfLastName() {
		return tfLastName;
	}

	/**
	 * @param tfLastName the tfLastName to set
	 */
	public void setTfLastName(JTextField tfLastName) {
		this.tfLastName = tfLastName;
	}

	/**
	 * @return the tfFirstName
	 */
	public JTextField getTfFirstName() {
		return tfFirstName;
	}

	/**
	 * @param tfFirstName the tfFirstName to set
	 */
	public void setTfFirstName(JTextField tfFirstName) {
		this.tfFirstName = tfFirstName;
	}

	/**
	 * @return the tfAddress
	 */
	public JTextField getTfAddress() {
		return tfAddress;
	}

	/**
	 * @param tfAddress the tfAddress to set
	 */
	public void setTfAddress(JTextField tfAddress) {
		this.tfAddress = tfAddress;
	}

	/**
	 * @return the tfEmail
	 */
	public JTextField getTfEmail() {
		return tfEmail;
	}

	/**
	 * @param tfEmail the tfEmail to set
	 */
	public void setTfEmail(JTextField tfEmail) {
		this.tfEmail = tfEmail;
	}

	/**
	 * @return the ftfPhoneNumber_1
	 */
	public JFormattedTextField getFtfPhoneNumber_1() {
		return ftfPhoneNumber_1;
	}

	/**
	 * @param ftfPhoneNumber_1 the ftfPhoneNumber_1 to set
	 */
	public void setFtfPhoneNumber_1(JFormattedTextField ftfPhoneNumber_1) {
		this.ftfPhoneNumber_1 = ftfPhoneNumber_1;
	}

	/**
	 * @return the btnSave
	 */
	public JButton getBtnSave() {
		return btnSave;
	}

	/**
	 * @param btnSave the btnSave to set
	 */

}
