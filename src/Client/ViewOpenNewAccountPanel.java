package Client;

import java.awt.EventQueue;
import java.awt.Font;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

public class ViewOpenNewAccountPanel extends JPanel {
	private JTextField tfUsername;
	private JButton btnVerify;
	private JPasswordField pwfPassword;
	private JPasswordField pwfConfirmPassword;
	private JTextField tfLastName;
	private JTextField tfFirstName;
	private JTextField tfAddress;
	private JTextField tfEmail;
	private JFormattedTextField ftfPhoneNumber;
	private JButton btnSave;
	private JButton btnReturn;
	private JButton btnQuit;

	

	/**
	 * Create the frame.
	 */
	public ViewOpenNewAccountPanel() {

		setBounds(100, 100, 450, 425);
		setLayout(null);

		JLabel lbNewAccount = new JLabel("Open New Account");
		lbNewAccount.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbNewAccount.setBounds(142, 11, 149, 33);
		add(lbNewAccount);

		JLabel lbConfirmPassword = new JLabel("Password");
		lbConfirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lbConfirmPassword.setBounds(28, 100, 102, 14);
		add(lbConfirmPassword);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblUsername.setBounds(28, 64, 102, 14);
		add(lblUsername);

		JLabel lbConfirmPassword_2 = new JLabel("Confirm Password");
		lbConfirmPassword_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lbConfirmPassword_2.setBounds(28, 135, 102, 14);
		add(lbConfirmPassword_2);

		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblLastName.setBounds(28, 170, 102, 14);
		add(lblLastName);

		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblFirstName.setBounds(28, 205, 102, 14);
		add(lblFirstName);

		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblAddress.setBounds(28, 236, 102, 14);
		add(lblAddress);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblEmail.setBounds(28, 271, 102, 14);
		add(lblEmail);

		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPhoneNumber.setBounds(28, 306, 102, 14);
		add(lblPhoneNumber);

		tfUsername = new JTextField();
		tfUsername.setColumns(10);
		tfUsername.setBounds(122, 61, 206, 20);
		add(tfUsername);

		tfLastName = new JTextField();
		tfLastName.setColumns(10);
		tfLastName.setBounds(122, 167, 206, 20);
		add(tfLastName);

		tfFirstName = new JTextField();
		tfFirstName.setColumns(10);
		tfFirstName.setBounds(122, 202, 206, 20);
		add(tfFirstName);

		tfAddress = new JTextField();
		tfAddress.setColumns(10);
		tfAddress.setBounds(122, 233, 206, 20);
		add(tfAddress);

		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		tfEmail.setBounds(122, 268, 206, 20);
		add(tfEmail);

		pwfPassword = new JPasswordField();
		pwfPassword.setBounds(122, 97, 206, 20);
		add(pwfPassword);

		pwfConfirmPassword = new JPasswordField();
		pwfConfirmPassword.setBounds(122, 132, 206, 20);
		add(pwfConfirmPassword);

		JLabel homeTelephoneLabel = new JLabel("Home telephone: ");
		JFormattedTextField ftfPhoneNumber;
		 try {
	            MaskFormatter telephoneNumber = new MaskFormatter("(###) ###-####");
	            ftfPhoneNumber = new JFormattedTextField(telephoneNumber);
	            ftfPhoneNumber.setBounds(122, 303, 206, 20);
	            add(ftfPhoneNumber);
	        } catch (ParseException e) {
	     
	            ftfPhoneNumber = null;
	        }

		// Set the formatted text field's value
		 this.ftfPhoneNumber = ftfPhoneNumber;

		btnVerify = new JButton("Verify");
		btnVerify.setBounds(335, 60, 89, 23);
		add(btnVerify);

		btnSave = new JButton("Save");
		btnSave.setBounds(89, 347, 89, 23);
		add(btnSave);

		btnReturn = new JButton("Return");
		btnReturn.setBounds(188, 347, 89, 23);
		add(btnReturn);

		btnQuit = new JButton("Quit");
		btnQuit.setBounds(287, 347, 89, 23);
		add(btnQuit);
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
	 * @return the btnSave
	 */
	public JButton getBtnSave() {
		return btnSave;
	}



	/**
	 * @param btnSave the btnSave to set
	 */
	public void setBtnSave(JButton btnSave) {
		this.btnSave = btnSave;
	}



	/**
	 * @return the btnReturn
	 */
	public JButton getBtnReturn() {
		return btnReturn;
	}



	/**
	 * @param btnReturn the btnReturn to set
	 */
	public void setBtnReturn(JButton btnReturn) {
		this.btnReturn = btnReturn;
	}



	/**
	 * @return the btnQuit
	 */
	public JButton getBtnQuit() {
		return btnQuit;
	}



	/**
	 * @param btnQuit the btnQuit to set
	 */
	public void setBtnQuit(JButton btnQuit) {
		this.btnQuit = btnQuit;
	}

}
