package Client;

import java.awt.Color;
import java.awt.Font;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import Database.Order;
import Model.Model;

public class ViewClientOrderHistoryPanel extends JPanel {
	private JFormattedTextField frmtdtxtfTelephoneNumber;
	private JFormattedTextField frmtdtxtfPostalCode;
	private JTable tableMealInOrder;
	private JTable tableYourOrders;
	private JButton btnYourOrders;
	private JFormattedTextField frmtdtxtfDeliveryTimeHour;
	private JFormattedTextField frmtdtxtfDeliveryTimeyyymmdd;
	private Model model;
	/**
	 * Create the panel.
	 */
	public ViewClientOrderHistoryPanel(Model model) {
		this.model = model;
		setBounds(100, 100, 1200, 680);
		setLayout(null);

		JLabel lblYourOrders = new JLabel("Your Orders");
		lblYourOrders.setHorizontalAlignment(SwingConstants.CENTER);
		lblYourOrders.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblYourOrders.setBounds(55, 15, 251, 23);
		add(lblYourOrders);

		
		tableYourOrders = new JTable();
		tableYourOrders.setModel(new DefaultTableModel(
			    new Object[][] {},
			    new String[] {
			        "Order ID", "Date"
			    }
			));

		tableYourOrders.setToolTipText("");
		tableYourOrders.setBorder(new LineBorder(Color.LIGHT_GRAY));
		tableYourOrders.setBackground(Color.WHITE);
		JScrollPane scrollPane = new JScrollPane(tableYourOrders);
		scrollPane.setBounds(55, 49, 251, 448);
		add(scrollPane);
		
		
		btnYourOrders = new JButton("Select");
		btnYourOrders.setBounds(55, 508, 251, 23);
		add(btnYourOrders);
		
		JLabel lbViewOrder = new JLabel("View Order");
		lbViewOrder.setHorizontalAlignment(SwingConstants.CENTER);
		lbViewOrder.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbViewOrder.setBounds(438, 11, 224, 26);
		add(lbViewOrder);
		
		JLabel lbDeliveryTimeyyymmdd = new JLabel("Delivery Time (yyyy/mm/dd): ");
		lbDeliveryTimeyyymmdd.setHorizontalAlignment(SwingConstants.RIGHT);
		lbDeliveryTimeyyymmdd.setBounds(438, 60, 156, 14);
		add(lbDeliveryTimeyyymmdd);
		
		JLabel lblTelephoneNumber = new JLabel("Postal Code:");
		lblTelephoneNumber.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelephoneNumber.setBounds(438, 122, 156, 14);
		add(lblTelephoneNumber);
		 try {
	            MaskFormatter postalcode = new MaskFormatter("U#U #U#");
	            frmtdtxtfPostalCode = new JFormattedTextField(postalcode);
	            frmtdtxtfPostalCode.setBounds(605, 119, 57, 20);
	            add(frmtdtxtfPostalCode);
	        } catch (ParseException e) {
	     
	        	frmtdtxtfPostalCode = null;
	        }

		// Set the formatted text field's value
		 this.frmtdtxtfTelephoneNumber = frmtdtxtfPostalCode;
		
		 JLabel lblMealInOrder = new JLabel("Meal in Order");
			lblMealInOrder.setHorizontalAlignment(SwingConstants.LEFT);
			lblMealInOrder.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblMealInOrder.setBounds(437, 170, 326, 26);
			add(lblMealInOrder);

			// Create the table
			tableMealInOrder = new JTable();
			tableMealInOrder.setBackground(Color.WHITE);
			tableMealInOrder.setModel(new DefaultTableModel(new Object[][] {
				
			},
			        new String[] { "Item", "Price", "Quantity" }));
			tableMealInOrder.setBorder(new LineBorder(Color.LIGHT_GRAY));
			tableMealInOrder.setToolTipText("");

			// Create a JScrollPane and add the table to it
			JScrollPane scrollPane1 = new JScrollPane(tableMealInOrder);
			scrollPane1.setBounds(438, 207, 447, 294);
			add(scrollPane1);
			
			JLabel lblLastName = new JLabel("Delivery Time:");
			lblLastName.setHorizontalAlignment(SwingConstants.RIGHT);
			lblLastName.setBounds(438, 90, 156, 14);
			add(lblLastName);
			try {
			    MaskFormatter deliveryTime = new MaskFormatter("##'h' ##'m'");
			    frmtdtxtfDeliveryTimeHour = new JFormattedTextField(deliveryTime);
			    frmtdtxtfDeliveryTimeHour.setBounds(605, 87, 57, 20);
			    add(frmtdtxtfDeliveryTimeHour);
			} catch (ParseException e) {
			    frmtdtxtfDeliveryTimeHour = null;
			    e.printStackTrace();
			}
			try {
			    MaskFormatter deliveryDate = new MaskFormatter("####/##/##");
			    frmtdtxtfDeliveryTimeyyymmdd = new JFormattedTextField(deliveryDate);
			    frmtdtxtfDeliveryTimeyyymmdd.setBounds(605, 57, 78, 23);
			    add(frmtdtxtfDeliveryTimeyyymmdd);
			} catch (ParseException e) {
			    frmtdtxtfDeliveryTimeyyymmdd = null;
			    e.printStackTrace();
			}
	}
	
	

	public void populateOrderTable() {
	    // Get the current client's username
	    String clientUsername = model.getCurrentUser().getUsername();

	    // Retrieve all orders for the current client from the database
	    ArrayList<Order> clientOrders = new ArrayList<>();
	    for (Order order : model.getDatabaseOrder().getOrders().values()) {
	        if (order.getClientUsername().equals(clientUsername)) {
	            clientOrders.add(order);
	        }
	    }

	    // Assuming you have access to the table (tableYourOrders)
	    DefaultTableModel tableModel = (DefaultTableModel) tableYourOrders.getModel();

	    // Clear the table model first
	    tableModel.setRowCount(0);

	    // Add rows to the table model directly
	    for (Order order : clientOrders) {
	        tableModel.addRow(new Object[] {
	            order.getOrderId(),
	            order.getDeliveryDate(),
	            order.getDeliveryTime(),
	            order.getPostalCode()
	        });
	    }
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
	 * @return the frmtdtxtfPostalCode
	 */
	public JFormattedTextField getFrmtdtxtfPostalCode() {
		return frmtdtxtfPostalCode;
	}
	/**
	 * @param frmtdtxtfPostalCode the frmtdtxtfPostalCode to set
	 */
	public void setFrmtdtxtfPostalCode(JFormattedTextField frmtdtxtfPostalCode) {
		this.frmtdtxtfPostalCode = frmtdtxtfPostalCode;
	}
	/**
	 * @return the tableMealInOrder
	 */
	public JTable getTableMealInOrder() {
		return tableMealInOrder;
	}
	/**
	 * @param tableMealInOrder the tableMealInOrder to set
	 */
	public void setTableMealInOrder(JTable tableMealInOrder) {
		this.tableMealInOrder = tableMealInOrder;
	}
	/**
	 * @return the tableYourOrders
	 */
	public JTable getTableYourOrders() {
		return tableYourOrders;
	}
	/**
	 * @param tableYourOrders the tableYourOrders to set
	 */
	public void setTableYourOrders(JTable tableYourOrders) {
		this.tableYourOrders = tableYourOrders;
	}
	/**
	 * @return the btnYourOrders
	 */
	public JButton getBtnYourOrders() {
		return btnYourOrders;
	}
	/**
	 * @param btnYourOrders the btnYourOrders to set
	 */
	public void setBtnYourOrders(JButton btnYourOrders) {
		this.btnYourOrders = btnYourOrders;
	}
	/**
	 * @return the frmtdtxtfDeliveryTimeHour
	 */
	public JFormattedTextField getFrmtdtxtfDeliveryTimeHour() {
		return frmtdtxtfDeliveryTimeHour;
	}
	/**
	 * @param frmtdtxtfDeliveryTimeHour the frmtdtxtfDeliveryTimeHour to set
	 */
	public void setFrmtdtxtfDeliveryTimeHour(JFormattedTextField frmtdtxtfDeliveryTimeHour) {
		this.frmtdtxtfDeliveryTimeHour = frmtdtxtfDeliveryTimeHour;
	}
	/**
	 * @return the frmtdtxtfDeliveryTimeyyymmdd
	 */
	public JFormattedTextField getFrmtdtxtfDeliveryTimeyyymmdd() {
		return frmtdtxtfDeliveryTimeyyymmdd;
	}
	/**
	 * @param frmtdtxtfDeliveryTimeyyymmdd the frmtdtxtfDeliveryTimeyyymmdd to set
	 */
	public void setFrmtdtxtfDeliveryTimeyyymmdd(JFormattedTextField frmtdtxtfDeliveryTimeyyymmdd) {
		this.frmtdtxtfDeliveryTimeyyymmdd = frmtdtxtfDeliveryTimeyyymmdd;
	}

}
