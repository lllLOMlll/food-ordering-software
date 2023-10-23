package Admin;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class ViewAddNewRestaurantPanel extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldRestaurantAddress;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewAdminAddNewRestaurantPanel frame = new ViewAdminAddNewRestaurantPanel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ViewAddNewRestaurantPanel() {
		setTitle("Food Ordering Software");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 680);
		setLocationRelativeTo(null);
		setResizable(false);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu FileMenu = new JMenu("File");
		menuBar.add(FileMenu);
		
		JMenuItem DisconnectFileMenu = new JMenuItem("Disconnect");
		FileMenu.add(DisconnectFileMenu);
		
		JMenuItem QuitFileMenu = new JMenuItem("Quit");
		FileMenu.add(QuitFileMenu);
		
		JMenu RestaurantMenu = new JMenu("Restaurant");
		menuBar.add(RestaurantMenu);
		
		JMenuItem CreateRestaurantMenuItem = new JMenuItem("Create");
		RestaurantMenu.add(CreateRestaurantMenuItem);
		
		JMenuItem EditRestaurantMenuItem = new JMenuItem("Edit");
		RestaurantMenu.add(EditRestaurantMenuItem);
		
		JMenuItem DeleteRestaurantMenuItem = new JMenuItem("Delete");
		RestaurantMenu.add(DeleteRestaurantMenuItem);
		
		JMenu MenuMenu = new JMenu("Menu");
		menuBar.add(MenuMenu);
		
		JMenuItem AddMenuMenu = new JMenuItem("Add");
		MenuMenu.add(AddMenuMenu);
		
		JMenuItem EditMenuMenu = new JMenuItem("Edit");
		MenuMenu.add(EditMenuMenu);
		
		JMenuItem DeleteMenuMenu = new JMenuItem("Delete");
		MenuMenu.add(DeleteMenuMenu);
		
		JMenu DeliveryManMenu = new JMenu("Delivery Man");
		menuBar.add(DeliveryManMenu);
		
		JMenuItem AddDeliveryManMenu = new JMenuItem("Add");
		DeliveryManMenu.add(AddDeliveryManMenu);
		
		JMenuItem EditDeliveryManMenu = new JMenuItem("Edit");
		DeliveryManMenu.add(EditDeliveryManMenu);
		
		JMenuItem DeleteDeliveryManMenu = new JMenuItem("Delete");
		DeliveryManMenu.add(DeleteDeliveryManMenu);
		getContentPane().setLayout(null);
		
		JLabel lbAddNewRestaurant = new JLabel("Add new restaurant");
		lbAddNewRestaurant.setHorizontalAlignment(SwingConstants.CENTER);
		lbAddNewRestaurant.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbAddNewRestaurant.setBounds(495, 11, 185, 26);
		getContentPane().add(lbAddNewRestaurant);
		
		JLabel lbRestaurantName = new JLabel("Restaurant name:");
		lbRestaurantName.setBounds(391, 60, 112, 14);
		getContentPane().add(lbRestaurantName);
		
		JLabel lblRestaurantAddress = new JLabel("Restaurant Address");
		lblRestaurantAddress.setBounds(391, 85, 112, 14);
		getContentPane().add(lblRestaurantAddress);
		
		JLabel lblTelephoneNumber = new JLabel("Telephone Number");
		lblTelephoneNumber.setBounds(391, 111, 112, 14);
		getContentPane().add(lblTelephoneNumber);
		
		JTextField textFieldRestaurantName = new JTextField();
		textFieldRestaurantName.setBounds(495, 57, 214, 20);
		getContentPane().add(textFieldRestaurantName);
		textFieldRestaurantName.setColumns(10);
		
		textFieldRestaurantAddress = new JTextField();
		textFieldRestaurantAddress.setColumns(10);
		textFieldRestaurantAddress.setBounds(495, 82, 214, 20);
		getContentPane().add(textFieldRestaurantAddress);
		
		JFormattedTextField formattedTextFieldTelephoneNumber = new JFormattedTextField();
		formattedTextFieldTelephoneNumber.setBounds(495, 110, 214, 20);
		getContentPane().add(formattedTextFieldTelephoneNumber);
		
		JLabel lblOppeningTime = new JLabel("Opening Time");
		lblOppeningTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblOppeningTime.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblOppeningTime.setBounds(495, 141, 185, 26);
		getContentPane().add(lblOppeningTime);
		
		JLabel lblDay = new JLabel("Day");
		lblDay.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDay.setBounds(391, 165, 72, 14);
		getContentPane().add(lblDay);
		
		JLabel lblSunday = new JLabel("Sunday");
		lblSunday.setBounds(391, 190, 72, 14);
		getContentPane().add(lblSunday);
		
		JLabel lblMonday = new JLabel("Monday");
		lblMonday.setBounds(391, 224, 72, 14);
		getContentPane().add(lblMonday);
		
		JLabel lblTuesday = new JLabel("Tuesday");
		lblTuesday.setBounds(391, 261, 72, 14);
		getContentPane().add(lblTuesday);
		
		JLabel lblWe = new JLabel("Wednesday");
		lblWe.setBounds(391, 295, 72, 14);
		getContentPane().add(lblWe);
		
		JLabel lblThuersday = new JLabel("Thursday");
		lblThuersday.setBounds(391, 331, 72, 14);
		getContentPane().add(lblThuersday);
		
		JLabel lblFriday = new JLabel("Friday");
		lblFriday.setBounds(391, 367, 72, 14);
		getContentPane().add(lblFriday);
		
		JLabel lblSaturday = new JLabel("Saturday");
		lblSaturday.setBounds(391, 402, 72, 14);
		getContentPane().add(lblSaturday);
		
		JLabel lblOpeningTime = new JLabel("Opening Time");
		lblOpeningTime.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblOpeningTime.setBounds(473, 165, 84, 14);
		getContentPane().add(lblOpeningTime);
		
		JLabel lblClosingTime = new JLabel("Closing Time");
		lblClosingTime.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblClosingTime.setBounds(639, 165, 101, 14);
		getContentPane().add(lblClosingTime);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
		comboBox.setBounds(473, 186, 38, 22);
		getContentPane().add(comboBox);
		
		JLabel lblNewLabel = new JLabel(" h");
		lblNewLabel.setBounds(511, 190, 9, 14);
		getContentPane().add(lblNewLabel);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55"}));
		comboBox_1.setBounds(521, 186, 38, 22);
		getContentPane().add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
		comboBox_2.setBounds(473, 220, 38, 22);
		getContentPane().add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
		comboBox_3.setBounds(473, 257, 38, 22);
		getContentPane().add(comboBox_3);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
		comboBox_4.setBounds(473, 291, 38, 22);
		getContentPane().add(comboBox_4);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
		comboBox_5.setBounds(473, 327, 38, 22);
		getContentPane().add(comboBox_5);
		
		JComboBox comboBox_6 = new JComboBox();
		comboBox_6.setModel(new DefaultComboBoxModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
		comboBox_6.setBounds(473, 363, 38, 22);
		getContentPane().add(comboBox_6);
		
		JComboBox comboBox_7 = new JComboBox();
		comboBox_7.setModel(new DefaultComboBoxModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
		comboBox_7.setBounds(473, 398, 38, 22);
		getContentPane().add(comboBox_7);
		
		JLabel lblNewLabel_1 = new JLabel(" h");
		lblNewLabel_1.setBounds(511, 224, 18, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(" h");
		lblNewLabel_2.setBounds(511, 261, 18, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel(" h");
		lblNewLabel_3.setBounds(511, 295, 18, 14);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel(" h");
		lblNewLabel_4.setBounds(511, 331, 18, 14);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel(" h");
		lblNewLabel_5.setBounds(511, 367, 18, 14);
		getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel(" h");
		lblNewLabel_6.setBounds(511, 402, 18, 14);
		getContentPane().add(lblNewLabel_6);
		
		JComboBox comboBox_1_1 = new JComboBox();
		comboBox_1_1.setModel(new DefaultComboBoxModel(new String[] {"00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55"}));
		comboBox_1_1.setBounds(521, 220, 38, 22);
		getContentPane().add(comboBox_1_1);
		
		JComboBox comboBox_1_1_1 = new JComboBox();
		comboBox_1_1_1.setModel(new DefaultComboBoxModel(new String[] {"00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55"}));
		comboBox_1_1_1.setBounds(521, 257, 38, 22);
		getContentPane().add(comboBox_1_1_1);
		
		JComboBox comboBox_1_1_2 = new JComboBox();
		comboBox_1_1_2.setModel(new DefaultComboBoxModel(new String[] {"00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55"}));
		comboBox_1_1_2.setBounds(521, 291, 38, 22);
		getContentPane().add(comboBox_1_1_2);
		
		JComboBox comboBox_1_1_3 = new JComboBox();
		comboBox_1_1_3.setModel(new DefaultComboBoxModel(new String[] {"00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55"}));
		comboBox_1_1_3.setBounds(521, 327, 38, 22);
		getContentPane().add(comboBox_1_1_3);
		
		JComboBox comboBox_1_1_4 = new JComboBox();
		comboBox_1_1_4.setModel(new DefaultComboBoxModel(new String[] {"00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55"}));
		comboBox_1_1_4.setBounds(521, 363, 38, 22);
		getContentPane().add(comboBox_1_1_4);
		
		JComboBox comboBox_1_1_5 = new JComboBox();
		comboBox_1_1_5.setModel(new DefaultComboBoxModel(new String[] {"00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55"}));
		comboBox_1_1_5.setBounds(521, 398, 38, 22);
		getContentPane().add(comboBox_1_1_5);
		
		JComboBox comboBox_1_1_6 = new JComboBox();
		comboBox_1_1_6.setModel(new DefaultComboBoxModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
		comboBox_1_1_6.setBounds(639, 186, 38, 22);
		getContentPane().add(comboBox_1_1_6);
		
		JComboBox comboBox_1_1_7 = new JComboBox();
		comboBox_1_1_7.setModel(new DefaultComboBoxModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
		comboBox_1_1_7.setBounds(639, 220, 38, 22);
		getContentPane().add(comboBox_1_1_7);
		
		JComboBox comboBox_1_1_8 = new JComboBox();
		comboBox_1_1_8.setModel(new DefaultComboBoxModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
		comboBox_1_1_8.setBounds(639, 257, 38, 22);
		getContentPane().add(comboBox_1_1_8);
		
		JComboBox comboBox_1_1_9 = new JComboBox();
		comboBox_1_1_9.setModel(new DefaultComboBoxModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
		comboBox_1_1_9.setBounds(639, 291, 38, 22);
		getContentPane().add(comboBox_1_1_9);
		
		JComboBox comboBox_1_1_10 = new JComboBox();
		comboBox_1_1_10.setModel(new DefaultComboBoxModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
		comboBox_1_1_10.setBounds(639, 327, 38, 22);
		getContentPane().add(comboBox_1_1_10);
		
		JComboBox comboBox_1_1_11 = new JComboBox();
		comboBox_1_1_11.setModel(new DefaultComboBoxModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
		comboBox_1_1_11.setBounds(639, 363, 38, 22);
		getContentPane().add(comboBox_1_1_11);
		
		JComboBox comboBox_1_1_12 = new JComboBox();
		comboBox_1_1_12.setModel(new DefaultComboBoxModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
		comboBox_1_1_12.setBounds(639, 398, 38, 22);
		getContentPane().add(comboBox_1_1_12);
		
		JLabel lblNewLabel_7 = new JLabel(" h");
		lblNewLabel_7.setBounds(676, 190, 9, 14);
		getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_7_1 = new JLabel(" h");
		lblNewLabel_7_1.setBounds(676, 224, 9, 14);
		getContentPane().add(lblNewLabel_7_1);
		
		JLabel lblNewLabel_7_2 = new JLabel(" h");
		lblNewLabel_7_2.setBounds(676, 261, 9, 14);
		getContentPane().add(lblNewLabel_7_2);
		
		JLabel lblNewLabel_7_3 = new JLabel(" h");
		lblNewLabel_7_3.setBounds(676, 295, 9, 14);
		getContentPane().add(lblNewLabel_7_3);
		
		JLabel lblNewLabel_7_4 = new JLabel(" h");
		lblNewLabel_7_4.setBounds(676, 331, 9, 14);
		getContentPane().add(lblNewLabel_7_4);
		
		JLabel lblNewLabel_7_5 = new JLabel(" h");
		lblNewLabel_7_5.setBounds(676, 367, 9, 14);
		getContentPane().add(lblNewLabel_7_5);
		
		JLabel lblNewLabel_7_6 = new JLabel(" h");
		lblNewLabel_7_6.setBounds(676, 402, 9, 14);
		getContentPane().add(lblNewLabel_7_6);
		
		JComboBox comboBox_1_1_6_1 = new JComboBox();
		comboBox_1_1_6_1.setModel(new DefaultComboBoxModel(new String[] {"00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55"}));
		comboBox_1_1_6_1.setBounds(686, 186, 38, 22);
		getContentPane().add(comboBox_1_1_6_1);
		
		JComboBox comboBox_1_1_6_2 = new JComboBox();
		comboBox_1_1_6_2.setModel(new DefaultComboBoxModel(new String[] {"00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55"}));
		comboBox_1_1_6_2.setBounds(687, 220, 38, 22);
		getContentPane().add(comboBox_1_1_6_2);
		
		JComboBox comboBox_1_1_6_3 = new JComboBox();
		comboBox_1_1_6_3.setModel(new DefaultComboBoxModel(new String[] {"00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55"}));
		comboBox_1_1_6_3.setBounds(687, 257, 38, 22);
		getContentPane().add(comboBox_1_1_6_3);
		
		JComboBox comboBox_1_1_6_4 = new JComboBox();
		comboBox_1_1_6_4.setModel(new DefaultComboBoxModel(new String[] {"00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55"}));
		comboBox_1_1_6_4.setBounds(687, 291, 38, 22);
		getContentPane().add(comboBox_1_1_6_4);
		
		JComboBox comboBox_1_1_6_5 = new JComboBox();
		comboBox_1_1_6_5.setModel(new DefaultComboBoxModel(new String[] {"00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55"}));
		comboBox_1_1_6_5.setBounds(687, 327, 38, 22);
		getContentPane().add(comboBox_1_1_6_5);
		
		JComboBox comboBox_1_1_6_6 = new JComboBox();
		comboBox_1_1_6_6.setModel(new DefaultComboBoxModel(new String[] {"00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55"}));
		comboBox_1_1_6_6.setBounds(686, 363, 38, 22);
		getContentPane().add(comboBox_1_1_6_6);
		
		JComboBox comboBox_1_1_6_7 = new JComboBox();
		comboBox_1_1_6_7.setModel(new DefaultComboBoxModel(new String[] {"00", "05", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55"}));
		comboBox_1_1_6_7.setBounds(687, 398, 38, 22);
		getContentPane().add(comboBox_1_1_6_7);
		
		JButton btnResetAllTheTimes = new JButton("Reset all the opening times");
		btnResetAllTheTimes.setBounds(391, 427, 333, 23);
		getContentPane().add(btnResetAllTheTimes);
		
		JLabel lblNewLabel_8 = new JLabel("Delivery Area");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_8.setBounds(391, 461, 333, 26);
		getContentPane().add(lblNewLabel_8);
		
		JButton btnUpdateDeliveryArea = new JButton("Update Delivery Area");
		btnUpdateDeliveryArea.setBounds(534, 514, 175, 20);
		getContentPane().add(btnUpdateDeliveryArea);

		// create the table
		table = new JTable();
		table.setBackground(Color.WHITE);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"A1A (example)"},
				{""},
				{""},
				{null},
				{null},
			},
			new String[] {
				"Delivery Area"
			}
		));
		table.setBorder(new LineBorder(Color.LIGHT_GRAY));
		table.setToolTipText("");
		table.setBounds(440, 492, 80, 80);
		getContentPane().add(table);
		
		JLabel lblDeliveryArea = new JLabel("Delivery Area:");
		lblDeliveryArea.setBounds(534, 489, 84, 14);
		getContentPane().add(lblDeliveryArea);
		
		JFormattedTextField frmtdtxtflDeliveryArea = new JFormattedTextField();
		frmtdtxtflDeliveryArea.setHorizontalAlignment(SwingConstants.CENTER);
		frmtdtxtflDeliveryArea.setForeground(Color.LIGHT_GRAY);
		frmtdtxtflDeliveryArea.setText("A1A");
		frmtdtxtflDeliveryArea.setBounds(607, 486, 38, 20);
		getContentPane().add(frmtdtxtflDeliveryArea);
		
		JButton btnDeleteDeliveryArea = new JButton("Delete Delivery Area");
		btnDeleteDeliveryArea.setBounds(534, 545, 175, 20);
		getContentPane().add(btnDeleteDeliveryArea);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.setBounds(506, 576, 112, 23);
		getContentPane().add(btnNewButton);

		// add action listener to the button
		btnUpdateDeliveryArea.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String deliveryArea = btnUpdateDeliveryArea.getText();
		        int row = table.getSelectedRow();
		        if (row >= 0) {
		            table.setValueAt(deliveryArea, row, 0);
		        }
		    }
		});
	}
}

