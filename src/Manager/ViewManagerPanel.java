package Manager;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ViewManagerPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public ViewManagerPanel() {
		setBounds(100, 100, 1200, 680);
		setLayout(null);
		
		JLabel lblWelcome = new JLabel("Welcome ...");
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblWelcome.setBounds(40, 43, 376, 40);
		add(lblWelcome);
		
		JLabel lblNewLabel = new JLabel("Acces level : MANAGER");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(40, 109, 226, 22);
		add(lblNewLabel);
	}

}
