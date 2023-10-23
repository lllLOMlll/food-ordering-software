package Login;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;



public class ViewLoginPanel extends JPanel {
	private JTextField textUsername;
	private JPasswordField passwordField;
	private JButton btnLogIn;
	private JButton btnSignUp;

	/**
	 * Create the panel.
	 */
	public ViewLoginPanel() {
	
		setBounds(100, 100, 1200, 680);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome to Major Restaurant");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(55, 33, 310, 31);
		add(lblNewLabel);
		
		JLabel lbUsername = new JLabel("Username");
		lbUsername.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbUsername.setToolTipText("Username");
		lbUsername.setBounds(55, 75, 209, 20);
		add(lbUsername);
		
		textUsername = new JTextField();
		textUsername.setBounds(55, 103, 192, 20);
		add(textUsername);
		textUsername.setColumns(10);
		
		JLabel lbPassword = new JLabel("Password");
		lbPassword.setToolTipText("Password");
		lbPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbPassword.setBounds(55, 134, 209, 20);
		add(lbPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(55, 161, 192, 20);
		add(passwordField);
		
		btnLogIn = new JButton("Log In");
		btnLogIn.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLogIn.setBounds(55, 204, 89, 23);
		add(btnLogIn);
		
		JLabel lbYouDontHaveAccount = new JLabel("You dont have an account?");
		lbYouDontHaveAccount.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbYouDontHaveAccount.setBounds(55, 253, 286, 20);
		add(lbYouDontHaveAccount);
		
		btnSignUp = new JButton("Sign Up");
		btnSignUp.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSignUp.setBounds(55, 284, 89, 23);
		add(btnSignUp);
	}

	/**
	 * @return the textUsername
	 */
	public JTextField getTextUsername() {
		return textUsername;
	}

	/**
	 * @param textUsername the textUsername to set
	 */
	public void setTextUsername(JTextField textUsername) {
		this.textUsername = textUsername;
	}

	/**
	 * @return the passwordField
	 */
	public JPasswordField getPasswordField() {
		return passwordField;
	}

	/**
	 * @param passwordField the passwordField to set
	 */
	public void setPasswordField(JPasswordField passwordField) {
		this.passwordField = passwordField;
	}

	/**
	 * @return the btnLogIn
	 */
	public JButton getBtnLogIn() {
		return btnLogIn;
	}

	/**
	 * @param btnLogIn the btnLogIn to set
	 */
	public void setBtnLogIn(JButton btnLogIn) {
		this.btnLogIn = btnLogIn;
	}

	/**
	 * @return the btnSignUp
	 */
	public JButton getBtnSignUp() {
		return btnSignUp;
	}

	/**
	 * @param btnSignUp the btnSignUp to set
	 */
	public void setBtnSignUp(JButton btnSignUp) {
		this.btnSignUp = btnSignUp;
	}

}
