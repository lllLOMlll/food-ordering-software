package Login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class ViewLoginFrame extends JFrame {

	private JPanel contentPane;
	private JLabel lbUsername;
	private JTextField textUsername;
	private JLabel lbPassword;
	private JPasswordField passwordField;
	private JButton btnLogIn;
	private JButton btnSignUp;

	/**
	 * Create the frame.
	 */
	public ViewLoginFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 680);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

	}
	// Method to set a Panel with the right Frame
	public void setNewPanel(JPanel panel) {
		setContentPane(panel);
		revalidate();
		repaint();

	}
}
