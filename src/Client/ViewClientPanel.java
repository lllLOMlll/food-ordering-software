package Client;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Database.User;

public class ViewClientPanel extends JPanel {

	private Object username;
	private Object model;

	/**
	 * Create the panel.
	 */
	public ViewClientPanel() {
		setBounds(100, 100, 1200, 680);
		setLayout(null);
	
		
		JLabel lblWelcome = new JLabel("Welcome ...");
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblWelcome.setBounds(40, 43, 376, 40);
		add(lblWelcome);
		
		JLabel lblNewLabel = new JLabel("Acces level : CLIENT");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(40, 109, 226, 22);
		add(lblNewLabel);
	}

}
