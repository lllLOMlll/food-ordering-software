package Client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;

public class ViewOpenNewAccountFrame extends JFrame {

	private JPanel contentPane;
	private JTextField tfUsername;
	private JTextField tfLastName;
	private JTextField tfFirstName;
	private JTextField tfAddress;
	private JTextField tfEmail;
	private JPasswordField pwfPassword;
	private JPasswordField pwfConfirmPassword;
	private JButton btnVerify;
	private JButton btnSave;
	private JButton btnReturn;
	private JButton btnQuit;
	private JFormattedTextField ftfPhoneNumber;


	/**
	 * Create the frame.
	 */
	public ViewOpenNewAccountFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 425);
		setLocationRelativeTo(null);
		setResizable(false);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbNewAccount = new JLabel("Open New Account");
		lbNewAccount.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbNewAccount.setBounds(142, 11, 149, 33);
		contentPane.add(lbNewAccount);
		
		JLabel lbConfirmPassword = new JLabel("Password");
		lbConfirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lbConfirmPassword.setBounds(28, 100, 102, 14);
		contentPane.add(lbConfirmPassword);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblUsername.setBounds(28, 64, 102, 14);
		contentPane.add(lblUsername);
		
		JLabel lbConfirmPassword_2 = new JLabel("Confirm Password");
		lbConfirmPassword_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lbConfirmPassword_2.setBounds(28, 135, 102, 14);
		contentPane.add(lbConfirmPassword_2);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblLastName.setBounds(28, 170, 102, 14);
		contentPane.add(lblLastName);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblFirstName.setBounds(28, 205, 102, 14);
		contentPane.add(lblFirstName);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblAddress.setBounds(28, 236, 102, 14);
		contentPane.add(lblAddress);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblEmail.setBounds(28, 271, 102, 14);
		contentPane.add(lblEmail);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPhoneNumber.setBounds(28, 306, 102, 14);
		contentPane.add(lblPhoneNumber);
		
		tfUsername = new JTextField();
		tfUsername.setColumns(10);
		tfUsername.setBounds(122, 61, 206, 20);
		contentPane.add(tfUsername);
		
		tfLastName = new JTextField();
		tfLastName.setColumns(10);
		tfLastName.setBounds(122, 167, 206, 20);
		contentPane.add(tfLastName);
		
		tfFirstName = new JTextField();
		tfFirstName.setColumns(10);
		tfFirstName.setBounds(122, 202, 206, 20);
		contentPane.add(tfFirstName);
		
		tfAddress = new JTextField();
		tfAddress.setColumns(10);
		tfAddress.setBounds(122, 233, 206, 20);
		contentPane.add(tfAddress);
		
		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		tfEmail.setBounds(122, 268, 206, 20);
		contentPane.add(tfEmail);
		
		pwfPassword = new JPasswordField();
		pwfPassword.setBounds(122, 97, 206, 20);
		contentPane.add(pwfPassword);
		
		pwfConfirmPassword = new JPasswordField();
		pwfConfirmPassword.setBounds(122, 132, 206, 20);
		contentPane.add(pwfConfirmPassword);
		
		ftfPhoneNumber = new JFormattedTextField();
		ftfPhoneNumber.setBounds(122, 303, 206, 20);
		contentPane.add(ftfPhoneNumber);
		
		btnVerify = new JButton("Verify");
		btnVerify.setBounds(335, 60, 89, 23);
		contentPane.add(btnVerify);
		
		btnSave = new JButton("Save");
		btnSave.setBounds(89, 347, 89, 23);
		contentPane.add(btnSave);
		
		btnReturn = new JButton("Return");
		btnReturn.setBounds(188, 347, 89, 23);
		contentPane.add(btnReturn);
		
		btnQuit = new JButton("Quit");
		btnQuit.setBounds(287, 347, 89, 23);
		contentPane.add(btnQuit);
		
		
	}
	
}
