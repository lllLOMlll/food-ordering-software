package Validation;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Validation {

		public static boolean isValidName(String name, JPanel panel) {
			if (name.isEmpty()) {
				JOptionPane.showMessageDialog(panel, "Please enter a name (firt or last).", "Error", JOptionPane.ERROR_MESSAGE);
				return false;
			} else if (name.matches(".*\\d.*")) {
				JOptionPane.showMessageDialog(panel, "Name cannot contain numbers.", "Error",
						JOptionPane.ERROR_MESSAGE);
				return false;
			}
			return true;
		}
	}


