package Admin;

import java.awt.Color;
import java.awt.Font;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import Model.Model;

public class ViewAdminAddNewDeliveryManPanel extends JPanel {
	private JButton btnDeleteMenu;
	private JFormattedTextField frmtdtxtfTelephoneNumber;
	private JTextField textLastName;
	private JTextField tfFistName;
	private JFormattedTextField frmtdtxtfTelephoneNumber_1;
	private JTable tableDeliveryArea;
	private JFormattedTextField frmtdtxtflDeliveryArea_1;
	private JButton btnUpdateDeliveryArea;
	private JButton btnDeleteDeliveryArea;
	private JButton btnSave;
	private Model model;
	/**
	 * Create the panel.
	 */
	public ViewAdminAddNewDeliveryManPanel() {
		this.model = model;
		
		setBounds(100, 100, 1200, 680);
		setLayout(null);



		JLabel lbAddNewDeliveryMan = new JLabel("Add New Delivery Man");
		lbAddNewDeliveryMan.setHorizontalAlignment(SwingConstants.CENTER);
		lbAddNewDeliveryMan.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbAddNewDeliveryMan.setBounds(359, 11, 404, 26);
		add(lbAddNewDeliveryMan);
		
		JLabel lbFirstName = new JLabel("First Name");
		lbFirstName.setBounds(359, 60, 126, 14);
		add(lbFirstName);
		
		tfFistName = new JTextField();
		tfFistName.setBounds(495, 57, 214, 20);
		add(tfFistName);
		tfFistName.setColumns(10);
		
		JLabel lblTelephoneNumber = new JLabel("Telephone Number:");
		lblTelephoneNumber.setBounds(359, 122, 126, 14);
		add(lblTelephoneNumber);
		 try {
	            MaskFormatter telephoneNumber = new MaskFormatter("(###) ###-####");
	            frmtdtxtfTelephoneNumber_1 = new JFormattedTextField(telephoneNumber);
	            frmtdtxtfTelephoneNumber_1.setBounds(495, 119, 214, 20);
	            add(frmtdtxtfTelephoneNumber_1);
	        } catch (ParseException e) {
	     
	        	frmtdtxtfTelephoneNumber_1 = null;
	        }

		// Set the formatted text field's value
		 this.frmtdtxtfTelephoneNumber = frmtdtxtfTelephoneNumber_1;
		
		 JLabel lblNewLabel_8 = new JLabel("Delivery Area");
			lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblNewLabel_8.setBounds(359, 147, 404, 26);
			add(lblNewLabel_8);

			btnUpdateDeliveryArea = new JButton("Update Area");
			btnUpdateDeliveryArea.setBounds(495, 398, 126, 20);
			add(btnUpdateDeliveryArea);

			// create the table
			tableDeliveryArea = new JTable();
			tableDeliveryArea.setBackground(Color.WHITE);
			tableDeliveryArea.setModel(
					new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Delivery Area"
				}
			));
			tableDeliveryArea.setBorder(new LineBorder(Color.LIGHT_GRAY));
			tableDeliveryArea.setToolTipText("");
			tableDeliveryArea.setBounds(495, 187, 126, 166);
			add(tableDeliveryArea);


			JFormattedTextField frmtdtxtflDeliveryArea = null;
			try {
			    MaskFormatter formatter = new MaskFormatter("U#U");
			    formatter.setPlaceholderCharacter('_');
			    frmtdtxtflDeliveryArea_1 = new JFormattedTextField(formatter);
			} catch (java.text.ParseException e) {
			    e.printStackTrace();
			}
			frmtdtxtflDeliveryArea_1.setHorizontalAlignment(SwingConstants.CENTER);
			frmtdtxtflDeliveryArea_1.setForeground(Color.BLACK);
			frmtdtxtflDeliveryArea_1.setBounds(583, 367, 38, 20);
			add(frmtdtxtflDeliveryArea_1);

			btnDeleteDeliveryArea = new JButton("Delete Area ");
			btnDeleteDeliveryArea.setBounds(495, 429, 126, 20);
			add(btnDeleteDeliveryArea);
			
			JLabel lblDeliveryArea = new JLabel("Delivery Area:");
			lblDeliveryArea.setBounds(495, 373, 78, 14);
			add(lblDeliveryArea);
			
			btnSave = new JButton("Save");
			btnSave.setBounds(495, 458, 126, 20);
			add(btnSave);
			
			JLabel lblLastName = new JLabel("Last Name");
			lblLastName.setBounds(359, 90, 126, 14);
			add(lblLastName);
			
			textLastName = new JTextField();
			textLastName.setColumns(10);
			textLastName.setBounds(495, 88, 214, 20);
			add(textLastName);


		
		
	}
	/**
	 * @return the btnDeleteMenu
	 */
	public JButton getBtnDeleteMenu() {
		return btnDeleteMenu;
	}
	/**
	 * @param btnDeleteMenu the btnDeleteMenu to set
	 */
	public void setBtnDeleteMenu(JButton btnDeleteMenu) {
		this.btnDeleteMenu = btnDeleteMenu;
	}
	/**
	 * @return the frmtdtxtfTelephoneNumber
	 */
	public JFormattedTextField getFrmtdtxtfTelephoneNumber() {
		return frmtdtxtfTelephoneNumber;
	}
	/**
	 * @param frmtdtxtfTelephoneNumber the frmtdtxtfTelephoneNumber to set
	 */
	public void setFrmtdtxtfTelephoneNumber(JFormattedTextField frmtdtxtfTelephoneNumber) {
		this.frmtdtxtfTelephoneNumber = frmtdtxtfTelephoneNumber;
	}
	/**
	 * @return the textLastName
	 */
	public JTextField getTextLastName() {
		return textLastName;
	}
	/**
	 * @param textLastName the textLastName to set
	 */
	public void setTextLastName(JTextField textLastName) {
		this.textLastName = textLastName;
	}
	/**
	 * @return the tfFistName
	 */
	public JTextField getTfFistName() {
		return tfFistName;
	}
	/**
	 * @param tfFistName the tfFistName to set
	 */
	public void setTfFistName(JTextField tfFistName) {
		this.tfFistName = tfFistName;
	}
	/**
	 * @return the frmtdtxtfTelephoneNumber_1
	 */
	public JFormattedTextField getFrmtdtxtfTelephoneNumber_1() {
		return frmtdtxtfTelephoneNumber_1;
	}
	/**
	 * @param frmtdtxtfTelephoneNumber_1 the frmtdtxtfTelephoneNumber_1 to set
	 */
	public void setFrmtdtxtfTelephoneNumber_1(JFormattedTextField frmtdtxtfTelephoneNumber_1) {
		this.frmtdtxtfTelephoneNumber_1 = frmtdtxtfTelephoneNumber_1;
	}
	/**
	 * @return the tableDeliveryArea
	 */
	public JTable getTableDeliveryArea() {
		return tableDeliveryArea;
	}
	/**
	 * @param tableDeliveryArea the tableDeliveryArea to set
	 */
	public void setTableDeliveryArea(JTable tableDeliveryArea) {
		this.tableDeliveryArea = tableDeliveryArea;
	}
	/**
	 * @return the frmtdtxtflDeliveryArea_1
	 */
	public JFormattedTextField getFrmtdtxtflDeliveryArea_1() {
		return frmtdtxtflDeliveryArea_1;
	}
	/**
	 * @param frmtdtxtflDeliveryArea_1 the frmtdtxtflDeliveryArea_1 to set
	 */
	public void setFrmtdtxtflDeliveryArea_1(JFormattedTextField frmtdtxtflDeliveryArea_1) {
		this.frmtdtxtflDeliveryArea_1 = frmtdtxtflDeliveryArea_1;
	}
	/**
	 * @return the btnUpdateDeliveryArea
	 */
	public JButton getBtnUpdateDeliveryArea() {
		return btnUpdateDeliveryArea;
	}
	/**
	 * @param btnUpdateDeliveryArea the btnUpdateDeliveryArea to set
	 */
	public void setBtnUpdateDeliveryArea(JButton btnUpdateDeliveryArea) {
		this.btnUpdateDeliveryArea = btnUpdateDeliveryArea;
	}
	/**
	 * @return the btnDeleteDeliveryArea
	 */
	public JButton getBtnDeleteDeliveryArea() {
		return btnDeleteDeliveryArea;
	}
	/**
	 * @param btnDeleteDeliveryArea the btnDeleteDeliveryArea to set
	 */
	public void setBtnDeleteDeliveryArea(JButton btnDeleteDeliveryArea) {
		this.btnDeleteDeliveryArea = btnDeleteDeliveryArea;
	}
	/**
	 * @return the btnSaveDeliveryArea
	 */
	public JButton getBtnSaveDeliveryArea() {
		return btnSave;
	}
	/**
	 * @param btnSaveDeliveryArea the btnSaveDeliveryArea to set
	 */
	public void setBtnSaveDeliveryArea(JButton btnSaveDeliveryArea) {
		this.btnSave = btnSaveDeliveryArea;
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

}
