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
import javax.swing.SwingConstants;

public class ViewClientDeleteAccountPanel extends JPanel {
	private JFormattedTextField ftfPhoneNumber;
	private JTextField tfUsername;
	private JPasswordField pwfConfirmPassword;
	private JTextField tfLastName;
	private JTextField tfFirstName;
	private JTextField tfAddress;
	private JTextField tfEmail;
	private JFormattedTextField ftfPhoneNumber_1;
	private JButton btnDelete;
	/**
	 * Create the panel.
	 */
	public ViewClientDeleteAccountPanel() {
		setBounds(100, 100, 1200, 680);
		setLayout(null);
		
		JLabel lbDeleteClientAccount = new JLabel("Delete Client Account");
		lbDeleteClientAccount.setHorizontalAlignment(SwingConstants.CENTER);
		lbDeleteClientAccount.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbDeleteClientAccount.setBounds(122, 11, 206, 33);
		add(lbDeleteClientAccount);

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

		btnDelete = new JButton("Delete Account");
		btnDelete.setBounds(122, 334, 209, 67);
		add(btnDelete);
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
	 * @return the pwfPassword
	 */

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
	 * @return the btnDelete
	 */
	public JButton getBtnDelete() {
		return btnDelete;
	}
	/**
	 * @param btnDelete the btnDelete to set
	 */
	public void setBtnDelete(JButton btnDelete) {
		this.btnDelete = btnDelete;
	}

}
