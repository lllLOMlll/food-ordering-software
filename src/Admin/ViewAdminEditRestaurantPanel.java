package Admin;

import java.awt.Color;
import java.awt.Font;
import java.text.ParseException;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import Database.DatabaseRestaurant;
import Database.Restaurant;
import Model.Model;

public class ViewAdminEditRestaurantPanel extends JPanel {
	private DefaultTableModel restaurantTableModel;
	private JTable tableDeliveryArea;
	private JTextField tfRestaurantName;
	private JFormattedTextField frmtdtxtfTelephoneNumber;
	private JComboBox cbSundayOpening1;
	private JComboBox cbSundayOpening2;
	private JComboBox cbSundayClosing1;
	private JComboBox cbSundayClosing2;
	private JComboBox cbMondayOpening1;
	private JComboBox cbMondayOpening2;
	private JComboBox cbMondayClosing1;
	private JComboBox cbMondayClosing2;
	private JComboBox cbTuesdayOpening1;
	private JComboBox cbTuesdayOpening2;
	private JComboBox cbTuesdayClosing1;
	private JComboBox cbTuesdayClosing2;
	private JComboBox cbWednesdayOpening1;
	private JComboBox cbWednesdayOpening2;
	private JComboBox cbWednesdayClosing1;
	private JComboBox cbWednesdayClosing2;
	private JComboBox cbThursdayOpening1;
	private JComboBox cbThursdayOpening2;
	private JComboBox cbThursdayClosing1;
	private JComboBox cbThursdayClosing2;
	private JComboBox cbFridayOpening1;
	private JComboBox cbFridayOpening2;
	private JComboBox cbFridayClosing1;
	private JComboBox cbFridayClosing2;
	private JComboBox cbSaturdayOpening1;
	private JComboBox cbSaturdayOpening2;
	private JComboBox cbSaturdayClosing1;
	private JComboBox cbSaturdayClosing2;
	private JButton btnResetAllTheTimes;
	private JButton btnUpdateDeliveryArea;
	private JButton btnDeleteDeliveryArea;
	private JButton btnSave;
	private JFormattedTextField frmtdtxtflDeliveryArea;
	private JTextField tfRestaurantAddress;
	private JTable tableRestaurant;
	private JButton btnSelect;
	private DatabaseRestaurant databaseRestaurant;
	private Model model;
	/**
	 * Create the panel.
	 */
	public ViewAdminEditRestaurantPanel(Model model) {
		this.model = model;

		setBounds(100, 100, 1200, 680);
		setLayout(null);



		JLabel lbEditRestaurant = new JLabel("Edit Restaurant");
		lbEditRestaurant.setHorizontalAlignment(SwingConstants.CENTER);
		lbEditRestaurant.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbEditRestaurant.setBounds(495, 11, 185, 26);
		add(lbEditRestaurant);

		JLabel lbRestaurantName = new JLabel("Restaurant name:");
		lbRestaurantName.setBounds(359, 60, 126, 14);
		add(lbRestaurantName);

		JLabel lblRestaurantAddress = new JLabel("Restaurant Address:");
		lblRestaurantAddress.setBounds(359, 85, 126, 14);
		add(lblRestaurantAddress);

		JLabel lblTelephoneNumber = new JLabel("Telephone Number:");
		lblTelephoneNumber.setBounds(359, 113, 126, 14);
		add(lblTelephoneNumber);

		tfRestaurantName = new JTextField();
		tfRestaurantName.setBounds(495, 57, 214, 20);
		add(tfRestaurantName);
		tfRestaurantName.setColumns(10);

		tfRestaurantAddress = new JTextField();
		tfRestaurantAddress.setColumns(10);
		tfRestaurantAddress.setBounds(495, 82, 214, 20);
		add(tfRestaurantAddress);


		
		JFormattedTextField frmtdtxtfTelephoneNumber;
		 try {
	            MaskFormatter telephoneNumber = new MaskFormatter("(###) ###-####");
	            frmtdtxtfTelephoneNumber = new JFormattedTextField(telephoneNumber);
	            frmtdtxtfTelephoneNumber.setBounds(495, 110, 214, 20);
	            add(frmtdtxtfTelephoneNumber);
	        } catch (ParseException e) {
	     
	        	frmtdtxtfTelephoneNumber = null;
	        }

		// Set the formatted text field's value
		 this.frmtdtxtfTelephoneNumber = frmtdtxtfTelephoneNumber;

		JLabel lblOppeningTime = new JLabel("Opening Time");
		lblOppeningTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblOppeningTime.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblOppeningTime.setBounds(495, 141, 185, 26);
		add(lblOppeningTime);

		JLabel lblDay = new JLabel("Day");
		lblDay.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDay.setBounds(391, 165, 72, 14);
		add(lblDay);

		JLabel lblSunday = new JLabel("Sunday");
		lblSunday.setBounds(391, 190, 72, 14);
		add(lblSunday);

		JLabel lblMonday = new JLabel("Monday");
		lblMonday.setBounds(391, 224, 72, 14);
		add(lblMonday);

		JLabel lblTuesday = new JLabel("Tuesday");
		lblTuesday.setBounds(391, 261, 72, 14);
		add(lblTuesday);

		JLabel lblWe = new JLabel("Wednesday");
		lblWe.setBounds(391, 295, 72, 14);
		add(lblWe);

		JLabel lblThuersday = new JLabel("Thursday");
		lblThuersday.setBounds(391, 331, 72, 14);
		add(lblThuersday);

		JLabel lblFriday = new JLabel("Friday");
		lblFriday.setBounds(391, 367, 72, 14);
		add(lblFriday);

		JLabel lblSaturday = new JLabel("Saturday");
		lblSaturday.setBounds(391, 402, 72, 14);
		add(lblSaturday);

		JLabel lblOpeningTime = new JLabel("Opening Time");
		lblOpeningTime.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblOpeningTime.setBounds(473, 165, 84, 14);
		add(lblOpeningTime);

		JLabel lblClosingTime = new JLabel("Closing Time");
		lblClosingTime.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblClosingTime.setBounds(639, 165, 101, 14);
		add(lblClosingTime);

		cbSundayOpening1 = new JComboBox();
		cbSundayOpening1.setModel(new DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08",
				"09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
		cbSundayOpening1.setBounds(473, 186, 48, 22);
		add(cbSundayOpening1);

		JLabel lblNewLabel = new JLabel(" h");
		lblNewLabel.setBounds(519, 190, 26, 14);
		add(lblNewLabel);

		cbSundayOpening2 = new JComboBox();
		cbSundayOpening2.setModel(new DefaultComboBoxModel(
				new String[] { "00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55" }));
		cbSundayOpening2.setBounds(531, 186, 48, 22);
		add(cbSundayOpening2);

		cbMondayOpening1 = new JComboBox();
		cbMondayOpening1.setModel(new DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07",
				"08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
		cbMondayOpening1.setBounds(473, 220, 48, 22);
		add(cbMondayOpening1);

		cbTuesdayOpening1 = new JComboBox();
		cbTuesdayOpening1.setModel(new DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07",
				"08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
		cbTuesdayOpening1.setBounds(473, 257, 48, 22);
		add(cbTuesdayOpening1);

		cbWednesdayOpening1 = new JComboBox();
		cbWednesdayOpening1.setModel(new DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07",
				"08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
		cbWednesdayOpening1.setBounds(473, 291, 48, 22);
		add(cbWednesdayOpening1);

		cbThursdayOpening1 = new JComboBox();
		cbThursdayOpening1.setModel(new DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07",
				"08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
		cbThursdayOpening1.setBounds(473, 327, 48, 22);
		add(cbThursdayOpening1);

		cbFridayOpening1 = new JComboBox();
		cbFridayOpening1.setModel(new DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07",
				"08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
		cbFridayOpening1.setBounds(473, 363, 48, 22);
		add(cbFridayOpening1);

		cbSaturdayOpening1 = new JComboBox();
		cbSaturdayOpening1.setModel(new DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07",
				"08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
		cbSaturdayOpening1.setBounds(473, 398, 48, 22);
		add(cbSaturdayOpening1);

		JLabel lblNewLabel_1 = new JLabel(" h");
		lblNewLabel_1.setBounds(519, 224, 18, 14);
		add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel(" h");
		lblNewLabel_2.setBounds(519, 261, 18, 14);
		add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel(" h");
		lblNewLabel_3.setBounds(519, 295, 18, 14);
		add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel(" h");
		lblNewLabel_4.setBounds(519, 331, 18, 14);
		add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel(" h");
		lblNewLabel_5.setBounds(519, 367, 18, 14);
		add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel(" h");
		lblNewLabel_6.setBounds(519, 402, 18, 14);
		add(lblNewLabel_6);

		cbMondayOpening2 = new JComboBox();
		cbMondayOpening2.setModel(new DefaultComboBoxModel(
				new String[] { "00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55" }));
		cbMondayOpening2.setBounds(529, 220, 50, 22);
		add(cbMondayOpening2);

		cbTuesdayOpening2 = new JComboBox();
		cbTuesdayOpening2.setModel(new DefaultComboBoxModel(
				new String[] { "00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55" }));
		cbTuesdayOpening2.setBounds(531, 257, 48, 22);
		add(cbTuesdayOpening2);

		cbWednesdayOpening2 = new JComboBox();
		cbWednesdayOpening2.setModel(new DefaultComboBoxModel(
				new String[] { "00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55" }));
		cbWednesdayOpening2.setBounds(531, 291, 48, 22);
		add(cbWednesdayOpening2);

		cbThursdayOpening2 = new JComboBox();
		cbThursdayOpening2.setModel(new DefaultComboBoxModel(
				new String[] { "00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55" }));
		cbThursdayOpening2.setBounds(531, 327, 48, 22);
		add(cbThursdayOpening2);

		cbFridayOpening2 = new JComboBox();
		cbFridayOpening2.setModel(new DefaultComboBoxModel(
				new String[] { "00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55" }));
		cbFridayOpening2.setBounds(531, 363, 48, 22);
		add(cbFridayOpening2);

		cbSaturdayOpening2 = new JComboBox();
		cbSaturdayOpening2.setModel(new DefaultComboBoxModel(
				new String[] { "00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55" }));
		cbSaturdayOpening2.setBounds(531, 398, 48, 22);
		add(cbSaturdayOpening2);

		cbSundayClosing1 = new JComboBox();
		cbSundayClosing1.setModel(new DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07",
				"08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
		cbSundayClosing1.setBounds(639, 186, 48, 22);
		add(cbSundayClosing1);

		cbMondayClosing1 = new JComboBox();
		cbMondayClosing1.setModel(new DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07",
				"08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
		cbMondayClosing1.setBounds(639, 220, 48, 22);
		add(cbMondayClosing1);

		cbTuesdayClosing1 = new JComboBox();
		cbTuesdayClosing1.setModel(new DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07",
				"08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
		cbTuesdayClosing1.setBounds(639, 257, 48, 22);
		add(cbTuesdayClosing1);

		cbWednesdayClosing1 = new JComboBox();
		cbWednesdayClosing1.setModel(new DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07",
				"08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
		cbWednesdayClosing1.setBounds(639, 291, 48, 22);
		add(cbWednesdayClosing1);

		cbThursdayClosing1 = new JComboBox();
		cbThursdayClosing1.setModel(new DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07",
				"08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
		cbThursdayClosing1.setBounds(639, 327, 48, 22);
		add(cbThursdayClosing1);

		cbFridayClosing1 = new JComboBox();
		cbFridayClosing1.setModel(new DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07",
				"08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
		cbFridayClosing1.setBounds(639, 363, 48, 22);
		add(cbFridayClosing1);

		cbSaturdayClosing1 = new JComboBox();
		cbSaturdayClosing1.setModel(new DefaultComboBoxModel(new String[] { "00", "01", "02", "03", "04", "05", "06", "07",
				"08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23" }));
		cbSaturdayClosing1.setBounds(639, 398, 48, 22);
		add(cbSaturdayClosing1);

		JLabel lblNewLabel_7 = new JLabel(" h");
		lblNewLabel_7.setBounds(688, 190, 21, 14);
		add(lblNewLabel_7);

		JLabel lblNewLabel_7_1 = new JLabel(" h");
		lblNewLabel_7_1.setBounds(688, 224, 21, 14);
		add(lblNewLabel_7_1);

		JLabel lblNewLabel_7_2 = new JLabel(" h");
		lblNewLabel_7_2.setBounds(688, 261, 21, 14);
		add(lblNewLabel_7_2);

		JLabel lblNewLabel_7_3 = new JLabel(" h");
		lblNewLabel_7_3.setBounds(688, 295, 21, 14);
		add(lblNewLabel_7_3);

		JLabel lblNewLabel_7_4 = new JLabel(" h");
		lblNewLabel_7_4.setBounds(688, 331, 21, 14);
		add(lblNewLabel_7_4);

		JLabel lblNewLabel_7_5 = new JLabel(" h");
		lblNewLabel_7_5.setBounds(688, 367, 18, 14);
		add(lblNewLabel_7_5);

		JLabel lblNewLabel_7_6 = new JLabel(" h");
		lblNewLabel_7_6.setBounds(688, 402, 21, 14);
		add(lblNewLabel_7_6);

		cbSundayClosing2 = new JComboBox();
		cbSundayClosing2.setModel(new DefaultComboBoxModel(
				new String[] { "00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55" }));
		cbSundayClosing2.setBounds(700, 186, 48, 22);
		add(cbSundayClosing2);

		cbMondayClosing2 = new JComboBox();
		cbMondayClosing2.setModel(new DefaultComboBoxModel(
				new String[] { "00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55" }));
		cbMondayClosing2.setBounds(702, 220, 48, 22);
		add(cbMondayClosing2);

		cbTuesdayClosing2 = new JComboBox();
		cbTuesdayClosing2.setModel(new DefaultComboBoxModel(
				new String[] { "00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55" }));
		cbTuesdayClosing2.setBounds(702, 257, 48, 22);
		add(cbTuesdayClosing2);

		cbWednesdayClosing2 = new JComboBox();
		cbWednesdayClosing2.setModel(new DefaultComboBoxModel(
				new String[] { "00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55" }));
		cbWednesdayClosing2.setBounds(702, 291, 48, 22);
		add(cbWednesdayClosing2);

		cbThursdayClosing2 = new JComboBox();
		cbThursdayClosing2.setModel(new DefaultComboBoxModel(
				new String[] { "00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55" }));
		cbThursdayClosing2.setBounds(702, 327, 48, 22);
		add(cbThursdayClosing2);

		cbFridayClosing2 = new JComboBox();
		cbFridayClosing2.setModel(new DefaultComboBoxModel(
				new String[] { "00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55" }));
		cbFridayClosing2.setBounds(702, 363, 48, 22);
		add(cbFridayClosing2);

		cbSaturdayClosing2 = new JComboBox();
		cbSaturdayClosing2.setModel(new DefaultComboBoxModel(
				new String[] { "00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55" }));
		cbSaturdayClosing2.setBounds(702, 398, 48, 22);
		add(cbSaturdayClosing2);

		btnResetAllTheTimes = new JButton("Reset all the opening times");
		btnResetAllTheTimes.setBounds(391, 427, 357, 23);
		add(btnResetAllTheTimes);

		JLabel lblNewLabel_8 = new JLabel("Delivery Area");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_8.setBounds(391, 461, 333, 26);
		add(lblNewLabel_8);

		btnUpdateDeliveryArea = new JButton("Update Delivery Area");
		btnUpdateDeliveryArea.setBounds(534, 514, 175, 20);
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
		tableDeliveryArea.setBounds(430, 492, 90, 80);
		add(tableDeliveryArea);

		JLabel lblDeliveryArea = new JLabel("Delivery Area:");
		lblDeliveryArea.setBounds(534, 489, 90, 14);
		add(lblDeliveryArea);

		try {
		    MaskFormatter formatter = new MaskFormatter("U#U");
		    formatter.setPlaceholderCharacter('_');
		    frmtdtxtflDeliveryArea = new JFormattedTextField(formatter);
		} catch (java.text.ParseException e) {
		    e.printStackTrace();
		}
		frmtdtxtflDeliveryArea.setHorizontalAlignment(SwingConstants.CENTER);
		frmtdtxtflDeliveryArea.setForeground(Color.BLACK);
		frmtdtxtflDeliveryArea.setBounds(615, 489, 38, 20);
		add(frmtdtxtflDeliveryArea);

		btnDeleteDeliveryArea = new JButton("Delete Delivery Area");
		btnDeleteDeliveryArea.setBounds(534, 545, 175, 20);
		add(btnDeleteDeliveryArea);

		btnSave = new JButton("Save");
		btnSave.setBounds(506, 576, 112, 23);
		add(btnSave);
		
		JLabel lblRestaurant = new JLabel("Restaurant");
		lblRestaurant.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblRestaurant.setBounds(107, 15, 126, 23);
		add(lblRestaurant);
		
		  // Initialize the table and its model
        restaurantTableModel = new DefaultTableModel(new Object[][] {}, new String[] { "Restaurant" });
        tableRestaurant = new JTable(restaurantTableModel);

        // Update the table with the restaurants
        List<Restaurant> restaurants = model.getRestaurantDatabase().getAllRestaurants();
        for (Restaurant restaurant : restaurants) {
            String[] row = new String[] { restaurant.getName() };
            restaurantTableModel.addRow(row);
        }


				tableRestaurant.setToolTipText("");
				tableRestaurant.setBorder(new LineBorder(Color.LIGHT_GRAY));
				tableRestaurant.setBackground(Color.WHITE);
				tableRestaurant.setBounds(68, 47, 165, 369);
				add(tableRestaurant);
		
		btnSelect = new JButton("Select");
		btnSelect.setBounds(70, 427, 163, 23);
		add(btnSelect);
		
	}
	//Method to update the tables that display restaurants
	public void updateTableRestaurant() {
	    DefaultTableModel restaurantTableModel = (DefaultTableModel) tableRestaurant.getModel();
	    restaurantTableModel.setRowCount(0);
	    List<Restaurant> restaurants = model.getRestaurantDatabase().getAllRestaurants();
	    for (Restaurant restaurant : restaurants) {
	        String[] row = new String[] { restaurant.getName() };
	        restaurantTableModel.addRow(row);
	    }
	}

	
	public void addRestaurantToTable(String restaurantName) {
	    DefaultTableModel model = (DefaultTableModel) tableRestaurant.getModel();
	    model.addRow(new Object[]{restaurantName});
	}


	public DefaultTableModel getTableDeliveryAreaModel() {
	    return (DefaultTableModel) tableDeliveryArea.getModel();
	}
	
	public void updateTableWithRestaurants(List<String> restaurants) {
	    restaurantTableModel.setRowCount(0);
	    for (String restaurant : restaurants) {
	        restaurantTableModel.addRow(new Object[] { restaurant });
	    }
	}

	
	public void updateRestaurantTable(String restaurantName) {
	    // Add a new row to the table model with the name of the restaurant
	    restaurantTableModel.addRow(new Object[] {restaurantName});
	}

	   
	   public JTable getTable() {
		    return tableRestaurant;
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
	 * @return the tfRestaurantName
	 */
	public JTextField getTfRestaurantName() {
		return tfRestaurantName;
	}
	/**
	 * @param tfRestaurantName the tfRestaurantName to set
	 */
	public void setTfRestaurantName(JTextField tfRestaurantName) {
		this.tfRestaurantName = tfRestaurantName;
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
	 * @return the cbSundayOpening1
	 */
	public JComboBox getCbSundayOpening1() {
		return cbSundayOpening1;
	}
	/**
	 * @param cbSundayOpening1 the cbSundayOpening1 to set
	 */
	public void setCbSundayOpening1(JComboBox cbSundayOpening1) {
		this.cbSundayOpening1 = cbSundayOpening1;
	}
	/**
	 * @return the cbSundayOpening2
	 */
	public JComboBox getCbSundayOpening2() {
		return cbSundayOpening2;
	}
	/**
	 * @param cbSundayOpening2 the cbSundayOpening2 to set
	 */
	public void setCbSundayOpening2(JComboBox cbSundayOpening2) {
		this.cbSundayOpening2 = cbSundayOpening2;
	}
	/**
	 * @return the cbSundayClosing1
	 */
	public JComboBox getCbSundayClosing1() {
		return cbSundayClosing1;
	}
	/**
	 * @param cbSundayClosing1 the cbSundayClosing1 to set
	 */
	public void setCbSundayClosing1(JComboBox cbSundayClosing1) {
		this.cbSundayClosing1 = cbSundayClosing1;
	}
	/**
	 * @return the cbSundayClosing2
	 */
	public JComboBox getCbSundayClosing2() {
		return cbSundayClosing2;
	}
	/**
	 * @param cbSundayClosing2 the cbSundayClosing2 to set
	 */
	public void setCbSundayClosing2(JComboBox cbSundayClosing2) {
		this.cbSundayClosing2 = cbSundayClosing2;
	}
	/**
	 * @return the cbMondayOpening1
	 */
	public JComboBox getCbMondayOpening1() {
		return cbMondayOpening1;
	}
	/**
	 * @param cbMondayOpening1 the cbMondayOpening1 to set
	 */
	public void setCbMondayOpening1(JComboBox cbMondayOpening1) {
		this.cbMondayOpening1 = cbMondayOpening1;
	}
	/**
	 * @return the cbMondayOpening2
	 */
	public JComboBox getCbMondayOpening2() {
		return cbMondayOpening2;
	}
	/**
	 * @param cbMondayOpening2 the cbMondayOpening2 to set
	 */
	public void setCbMondayOpening2(JComboBox cbMondayOpening2) {
		this.cbMondayOpening2 = cbMondayOpening2;
	}
	/**
	 * @return the cbMondayClosing1
	 */
	public JComboBox getCbMondayClosing1() {
		return cbMondayClosing1;
	}
	/**
	 * @param cbMondayClosing1 the cbMondayClosing1 to set
	 */
	public void setCbMondayClosing1(JComboBox cbMondayClosing1) {
		this.cbMondayClosing1 = cbMondayClosing1;
	}
	/**
	 * @return the cbMondayClosing2
	 */
	public JComboBox getCbMondayClosing2() {
		return cbMondayClosing2;
	}
	/**
	 * @param cbMondayClosing2 the cbMondayClosing2 to set
	 */
	public void setCbMondayClosing2(JComboBox cbMondayClosing2) {
		this.cbMondayClosing2 = cbMondayClosing2;
	}
	/**
	 * @return the cbTuesdayOpening1
	 */
	public JComboBox getCbTuesdayOpening1() {
		return cbTuesdayOpening1;
	}
	/**
	 * @param cbTuesdayOpening1 the cbTuesdayOpening1 to set
	 */
	public void setCbTuesdayOpening1(JComboBox cbTuesdayOpening1) {
		this.cbTuesdayOpening1 = cbTuesdayOpening1;
	}
	/**
	 * @return the cbTuesdayOpening2
	 */
	public JComboBox getCbTuesdayOpening2() {
		return cbTuesdayOpening2;
	}
	/**
	 * @param cbTuesdayOpening2 the cbTuesdayOpening2 to set
	 */
	public void setCbTuesdayOpening2(JComboBox cbTuesdayOpening2) {
		this.cbTuesdayOpening2 = cbTuesdayOpening2;
	}
	/**
	 * @return the cbTuesdayClosing1
	 */
	public JComboBox getCbTuesdayClosing1() {
		return cbTuesdayClosing1;
	}
	/**
	 * @param cbTuesdayClosing1 the cbTuesdayClosing1 to set
	 */
	public void setCbTuesdayClosing1(JComboBox cbTuesdayClosing1) {
		this.cbTuesdayClosing1 = cbTuesdayClosing1;
	}
	/**
	 * @return the cbTuesdayClosing2
	 */
	public JComboBox getCbTuesdayClosing2() {
		return cbTuesdayClosing2;
	}
	/**
	 * @param cbTuesdayClosing2 the cbTuesdayClosing2 to set
	 */
	public void setCbTuesdayClosing2(JComboBox cbTuesdayClosing2) {
		this.cbTuesdayClosing2 = cbTuesdayClosing2;
	}
	/**
	 * @return the cbWednesdayOpening1
	 */
	public JComboBox getCbWednesdayOpening1() {
		return cbWednesdayOpening1;
	}
	/**
	 * @param cbWednesdayOpening1 the cbWednesdayOpening1 to set
	 */
	public void setCbWednesdayOpening1(JComboBox cbWednesdayOpening1) {
		this.cbWednesdayOpening1 = cbWednesdayOpening1;
	}
	/**
	 * @return the cbWednesdayOpening2
	 */
	public JComboBox getCbWednesdayOpening2() {
		return cbWednesdayOpening2;
	}
	/**
	 * @param cbWednesdayOpening2 the cbWednesdayOpening2 to set
	 */
	public void setCbWednesdayOpening2(JComboBox cbWednesdayOpening2) {
		this.cbWednesdayOpening2 = cbWednesdayOpening2;
	}
	/**
	 * @return the cbWednesdayClosing1
	 */
	public JComboBox getCbWednesdayClosing1() {
		return cbWednesdayClosing1;
	}
	/**
	 * @param cbWednesdayClosing1 the cbWednesdayClosing1 to set
	 */
	public void setCbWednesdayClosing1(JComboBox cbWednesdayClosing1) {
		this.cbWednesdayClosing1 = cbWednesdayClosing1;
	}
	/**
	 * @return the cbWednesdayClosing2
	 */
	public JComboBox getCbWednesdayClosing2() {
		return cbWednesdayClosing2;
	}
	/**
	 * @param cbWednesdayClosing2 the cbWednesdayClosing2 to set
	 */
	public void setCbWednesdayClosing2(JComboBox cbWednesdayClosing2) {
		this.cbWednesdayClosing2 = cbWednesdayClosing2;
	}
	/**
	 * @return the cbThursdayOpening1
	 */
	public JComboBox getCbThursdayOpening1() {
		return cbThursdayOpening1;
	}
	/**
	 * @param cbThursdayOpening1 the cbThursdayOpening1 to set
	 */
	public void setCbThursdayOpening1(JComboBox cbThursdayOpening1) {
		this.cbThursdayOpening1 = cbThursdayOpening1;
	}
	/**
	 * @return the cbThursdayOpening2
	 */
	public JComboBox getCbThursdayOpening2() {
		return cbThursdayOpening2;
	}
	/**
	 * @param cbThursdayOpening2 the cbThursdayOpening2 to set
	 */
	public void setCbThursdayOpening2(JComboBox cbThursdayOpening2) {
		this.cbThursdayOpening2 = cbThursdayOpening2;
	}
	/**
	 * @return the cbThursdayClosing1
	 */
	public JComboBox getCbThursdayClosing1() {
		return cbThursdayClosing1;
	}
	/**
	 * @param cbThursdayClosing1 the cbThursdayClosing1 to set
	 */
	public void setCbThursdayClosing1(JComboBox cbThursdayClosing1) {
		this.cbThursdayClosing1 = cbThursdayClosing1;
	}
	/**
	 * @return the cbThursdayClosing2
	 */
	public JComboBox getCbThursdayClosing2() {
		return cbThursdayClosing2;
	}
	/**
	 * @param cbThursdayClosing2 the cbThursdayClosing2 to set
	 */
	public void setCbThursdayClosing2(JComboBox cbThursdayClosing2) {
		this.cbThursdayClosing2 = cbThursdayClosing2;
	}
	/**
	 * @return the cbFridayOpening1
	 */
	public JComboBox getCbFridayOpening1() {
		return cbFridayOpening1;
	}
	/**
	 * @param cbFridayOpening1 the cbFridayOpening1 to set
	 */
	public void setCbFridayOpening1(JComboBox cbFridayOpening1) {
		this.cbFridayOpening1 = cbFridayOpening1;
	}
	/**
	 * @return the cbFridayOpening2
	 */
	public JComboBox getCbFridayOpening2() {
		return cbFridayOpening2;
	}
	/**
	 * @param cbFridayOpening2 the cbFridayOpening2 to set
	 */
	public void setCbFridayOpening2(JComboBox cbFridayOpening2) {
		this.cbFridayOpening2 = cbFridayOpening2;
	}
	/**
	 * @return the cbFridayClosing1
	 */
	public JComboBox getCbFridayClosing1() {
		return cbFridayClosing1;
	}
	/**
	 * @param cbFridayClosing1 the cbFridayClosing1 to set
	 */
	public void setCbFridayClosing1(JComboBox cbFridayClosing1) {
		this.cbFridayClosing1 = cbFridayClosing1;
	}
	/**
	 * @return the cbFridayClosing2
	 */
	public JComboBox getCbFridayClosing2() {
		return cbFridayClosing2;
	}
	/**
	 * @param cbFridayClosing2 the cbFridayClosing2 to set
	 */
	public void setCbFridayClosing2(JComboBox cbFridayClosing2) {
		this.cbFridayClosing2 = cbFridayClosing2;
	}
	/**
	 * @return the cbSaturdayOpening1
	 */
	public JComboBox getCbSaturdayOpening1() {
		return cbSaturdayOpening1;
	}
	/**
	 * @param cbSaturdayOpening1 the cbSaturdayOpening1 to set
	 */
	public void setCbSaturdayOpening1(JComboBox cbSaturdayOpening1) {
		this.cbSaturdayOpening1 = cbSaturdayOpening1;
	}
	/**
	 * @return the cbSaturdayOpening2
	 */
	public JComboBox getCbSaturdayOpening2() {
		return cbSaturdayOpening2;
	}
	/**
	 * @param cbSaturdayOpening2 the cbSaturdayOpening2 to set
	 */
	public void setCbSaturdayOpening2(JComboBox cbSaturdayOpening2) {
		this.cbSaturdayOpening2 = cbSaturdayOpening2;
	}
	/**
	 * @return the cbSaturdayClosing1
	 */
	public JComboBox getCbSaturdayClosing1() {
		return cbSaturdayClosing1;
	}
	/**
	 * @param cbSaturdayClosing1 the cbSaturdayClosing1 to set
	 */
	public void setCbSaturdayClosing1(JComboBox cbSaturdayClosing1) {
		this.cbSaturdayClosing1 = cbSaturdayClosing1;
	}
	/**
	 * @return the cbSaturdayClosing2
	 */
	public JComboBox getCbSaturdayClosing2() {
		return cbSaturdayClosing2;
	}
	/**
	 * @param cbSaturdayClosing2 the cbSaturdayClosing2 to set
	 */
	public void setCbSaturdayClosing2(JComboBox cbSaturdayClosing2) {
		this.cbSaturdayClosing2 = cbSaturdayClosing2;
	}
	/**
	 * @return the btnResetAllTheTimes
	 */
	public JButton getBtnResetAllTheTimes() {
		return btnResetAllTheTimes;
	}
	/**
	 * @param btnResetAllTheTimes the btnResetAllTheTimes to set
	 */
	public void setBtnResetAllTheTimes(JButton btnResetAllTheTimes) {
		this.btnResetAllTheTimes = btnResetAllTheTimes;
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
	 * @return the frmtdtxtflDeliveryArea
	 */
	public JFormattedTextField getFrmtdtxtflDeliveryArea() {
		return frmtdtxtflDeliveryArea;
	}
	/**
	 * @param frmtdtxtflDeliveryArea the frmtdtxtflDeliveryArea to set
	 */
	public void setFrmtdtxtflDeliveryArea(JFormattedTextField frmtdtxtflDeliveryArea) {
		this.frmtdtxtflDeliveryArea = frmtdtxtflDeliveryArea;
	}
	/**
	 * @return the tfRestaurantAddress
	 */
	public JTextField getTfRestaurantAddress() {
		return tfRestaurantAddress;
	}
	/**
	 * @param tfRestaurantAddress the tfRestaurantAddress to set
	 */
	public void setTfRestaurantAddress(JTextField tfRestaurantAddress) {
		this.tfRestaurantAddress = tfRestaurantAddress;
	}
	/**
	 * @return the tableRestaurant
	 */
	public JTable getTableRestaurant() {
		return tableRestaurant;
	}
	/**
	 * @param tableRestaurant the tableRestaurant to set
	 */
	public void setTableRestaurant(JTable tableRestaurant) {
		this.tableRestaurant = tableRestaurant;
	}
	/**
	 * @return the btnSelect
	 */
	public JButton getBtnSelect() {
		return btnSelect;
	}
	/**
	 * @param btnSelect the btnSelect to set
	 */
	public void setBtnSelect(JButton btnSelect) {
		this.btnSelect = btnSelect;
	}
}
