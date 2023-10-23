package DeliveryMan;

import java.awt.Color;
import java.awt.Font;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import Database.Order;
import Model.Model;

public class ViewDeliveryManViewDeliveryPanel extends JPanel {
	private JTable tableOrder;
	private JButton btnCompleteConsultation;
	private JLabel lblOrderNumber;
	private JLabel lblRestaurant;
	private JLabel lblDeliveryAddress;
	private JLabel lblDeliveryPostalCode;
	private Model model;
	private JLabel lbOrder;
	/**
	 * Create the panel.
	 */
	public ViewDeliveryManViewDeliveryPanel(Model model) {
		this.model = model;
		setBounds(100, 100, 1200, 680);
		setLayout(null);



		JLabel lbViewDelivery = new JLabel("View Delivery");
		lbViewDelivery.setHorizontalAlignment(SwingConstants.LEFT);
		lbViewDelivery.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbViewDelivery.setBounds(526, 11, 237, 26);
		add(lbViewDelivery);

	
		
		JLabel lblOrder = new JLabel("Orders");
		lblOrder.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrder.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblOrder.setBounds(154, 68, 165, 23);
		add(lblOrder);
		
		tableOrder = new JTable();
		tableOrder.setModel(new DefaultTableModel(
		    new Object[][] {},
		    new String[] {
		        "Order", "Client", "Delivery Date", "Restaurant"
		    }
		));
		tableOrder.setToolTipText("");
		tableOrder.setBorder(new LineBorder(Color.LIGHT_GRAY));
		tableOrder.setBackground(Color.WHITE);

		JScrollPane scrollPane = new JScrollPane(tableOrder);
		scrollPane.setBounds(68, 97, 615, 369);
		add(scrollPane);
		
		btnCompleteConsultation = new JButton("Complete Consultation");
		btnCompleteConsultation.setBounds(749, 208, 165, 23);
		add(btnCompleteConsultation);
		
		lblOrderNumber = new JLabel("ORDER:");
		lblOrderNumber.setBounds(749, 108, 558, 14);
		add(lblOrderNumber);
		
		lblRestaurant = new JLabel("RESTAURANT:");
		lblRestaurant.setBounds(749, 133, 558, 14);
		add(lblRestaurant);
		
		lblDeliveryAddress = new JLabel("DELIVERY ADDRESS:");
		lblDeliveryAddress.setBounds(749, 158, 558, 14);
		add(lblDeliveryAddress);
		
		lblDeliveryPostalCode = new JLabel("POSTAL CODE:  ");
		lblDeliveryPostalCode.setBounds(749, 183, 558, 14);
		add(lblDeliveryPostalCode);
		
		lbOrder = new JLabel("");
		lbOrder.setBounds(645, 48, 315, 14);
		add(lbOrder);
	}

	public void populateDeliveryTable() {
	    DefaultTableModel tableModel = new DefaultTableModel(new Object[][] {}, new String[] {"Order ID", "Client", "Delivery Date", "Restaurant"});
	    tableOrder.setModel(tableModel);
	
	    for (Map.Entry<String, Order> entry : model.getDatabaseOrder().getOrders().entrySet()) {
	        Order order = entry.getValue();

	        if (order.isDeliveryManPending()) {
	            tableModel.addRow(new Object[] {
	                order.getOrderId(),
	                order.getClientUsername(),
	                order.getDeliveryDate(),
	                order.getRestaurant().getName()
	            });
	        }
	    }
	}
	/**
	 * @return the tableRestaurant
	 */
	public JTable getTableRestaurant() {
		return tableOrder;
	}
	/**
	 * @param tableRestaurant the tableRestaurant to set
	 */
	public void setTableRestaurant(JTable tableRestaurant) {
		this.tableOrder = tableRestaurant;
	}

	/**
	 * @return the btnCompleteConsultation
	 */
	public JButton getBtnCompleteConsultation() {
		return btnCompleteConsultation;
	}
	/**
	 * @param btnCompleteConsultation the btnCompleteConsultation to set
	 */
	public void setBtnCompleteConsultation(JButton btnCompleteConsultation) {
		this.btnCompleteConsultation = btnCompleteConsultation;
	}
	/**
	 * @return the lblOrderNumber
	 */
	public JLabel getLblOrderNumber() {
		return lblOrderNumber;
	}
	// To modify Order number w
	public void setLabelOrderNumberText(String text) {
	    lblOrderNumber.setText(text);
	}
	/**
	 * @return the lblRestaurant
	 */
	public JLabel getLblRestaurant() {
		return lblRestaurant;
	}
	/**
	 * @param lblRestaurant the lblRestaurant to set
	 */
	public void setLblRestaurant(JLabel lblRestaurant) {
		this.lblRestaurant = lblRestaurant;
	}
	
	// To modify restaurant
	public void setLabelRestaurantText(String text) {
		lblRestaurant.setText(text);
	}
	/**
	 * @return the lblDeliveryAddress
	 */
	public JLabel getLblDeliveryAddress() {
		return lblDeliveryAddress;
	}
	/**
	 * @param lblDeliveryAddress the lblDeliveryAddress to set
	 */
	public void setLblDeliveryAddress(JLabel lblDeliveryAddress) {
		this.lblDeliveryAddress = lblDeliveryAddress;
	}
	// To modify address
	public void setLabeleliveryAddressText(String text) {
		lblDeliveryAddress.setText(text);
	}
	/**
	 * @return the lblDeliveryPostalCode
	 */
	public JLabel getLblDeliveryPostalCode() {
		return lblDeliveryPostalCode;
	}
	/**
	 * @param lblDeliveryPostalCode the lblDeliveryPostalCode to set
	 */
	
	public void setLblDeliveryPostalCode(JLabel lblDeliveryPostalCode) {
		this.lblDeliveryPostalCode = lblDeliveryPostalCode;
	}
	
	// To modify Postal Code
	public void setLabelDeliveryPostalCodeText(String text) {
		lblDeliveryPostalCode.setText(text);
	}
	public JTable getTableOrder() {
		return tableOrder;
	}

	public void setTableOrder(JTable tableOrder) {
		this.tableOrder = tableOrder;
	}
	
	
}
