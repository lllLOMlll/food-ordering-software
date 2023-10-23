package Admin;

import javax.swing.JPanel;

import Database.User;

import javax.swing.JLabel;
import java.awt.Font;

public class ViewAdminPanel extends JPanel {
	private JLabel lblWelcome;

	/**
	 * Create the panel.
	 */
	public ViewAdminPanel() {
		setBounds(100, 100, 1200, 680);
		setLayout(null);
		
		lblWelcome = new JLabel("Welcome...");
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblWelcome.setBounds(40, 43, 376, 40);
		add(lblWelcome);
		
		JLabel lblNewLabel = new JLabel("Acces level : ADMINISTRATOR");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(40, 109, 226, 22);
		add(lblNewLabel);
		
	}
	
}
