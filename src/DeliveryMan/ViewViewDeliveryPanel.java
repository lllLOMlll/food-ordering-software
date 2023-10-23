//package DeliveryMan;
//
//import java.awt.Color;
//import java.awt.Font;
//import java.util.Map;
//
//import javax.swing.JButton;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//import javax.swing.JTable;
//import javax.swing.JTextField;
//import javax.swing.SwingConstants;
//import javax.swing.border.LineBorder;
//import javax.swing.table.DefaultTableModel;
//
//import Database.Order;
//import Model.Model;
//
//public class ViewViewDeliveryPanel extends JPanel {
//	private JTable tableOrder;
//	private JButton btnSelectOrder;
//	private JButton btnCompleteConsultation;
//	private JLabel lblOrderNumber;
//	private JLabel lblRestaurant;
//	private JLabel lblDeliveryAddress;
//	private JLabel lblDeliveryPostalCode;
//	private Model model;
//	/**
//	 * Create the panel.
//	 */
//	public ViewViewDeliveryPanel(Model model) {
//		this.model = model;
//		setBounds(100, 100, 1200, 680);
//		setLayout(null);
//
//
//
//		JLabel lbViewDelivery = new JLabel("View Delivery");
//		lbViewDelivery.setHorizontalAlignment(SwingConstants.LEFT);
//		lbViewDelivery.setFont(new Font("Tahoma", Font.BOLD, 18));
//		lbViewDelivery.setBounds(526, 11, 237, 26);
//		add(lbViewDelivery);
//
//	
//		
//		JLabel lblOrder = new JLabel("Order");
//		lblOrder.setHorizontalAlignment(SwingConstants.CENTER);
//		lblOrder.setFont(new Font("Tahoma", Font.BOLD, 13));
//		lblOrder.setBounds(68, 15, 165, 23);
//		add(lblOrder);
//		
//		tableOrder = new JTable();
//		tableOrder.setModel(new DefaultTableModel(
//		    new Object[][] {
//		        {"Wed, Jan 30..."},
//		    },
//		    new String[] {
//		        "Order"
//		    }
//		));
//		tableOrder.setToolTipText("");
//		tableOrder.setBorder(new LineBorder(Color.LIGHT_GRAY));
//		tableOrder.setBackground(Color.WHITE);
//		tableOrder.setBounds(68, 47, 165, 369);
//		add(tableOrder);
//		
//		btnSelectOrder = new JButton("Select");
//		btnSelectOrder.setBounds(70, 427, 163, 23);
//		add(btnSelectOrder);
//		
//		btnCompleteConsultation = new JButton("Complete Consultation");
//		btnCompleteConsultation.setBounds(526, 148, 165, 23);
//		add(btnCompleteConsultation);
//		
//		lblOrderNumber = new JLabel("Order #: 1");
//		lblOrderNumber.setBounds(526, 48, 415, 14);
//		add(lblOrderNumber);
//		
//		lblRestaurant = new JLabel("Restaurant #: 1");
//		lblRestaurant.setBounds(526, 73, 415, 14);
//		add(lblRestaurant);
//		
//		lblDeliveryAddress = new JLabel("Delivery Address: 123 Fake Street, Montreal");
//		lblDeliveryAddress.setBounds(526, 98, 415, 14);
//		add(lblDeliveryAddress);
//		
//		lblDeliveryPostalCode = new JLabel("Delivery Postal Code:  J4H 5G5");
//		lblDeliveryPostalCode.setBounds(526, 123, 165, 14);
//		add(lblDeliveryPostalCode);
//	}
//	public void populateOrderTable() {
//	    DefaultTableModel tableModel = new DefaultTableModel(new Object[][] {}, new String[] {"Order ID", "Client", "Delivery Date", "Restaurant"});
//	    tableOrder.setModel(tableModel);
//	
//	    for (Map.Entry<String, Order> entry : model.getDatabaseOrder().getOrders().entrySet()) {
//	        Order order = entry.getValue();
//
//	        if (!order.isRestaurateurPending()) {
//	            tableModel.addRow(new Object[] {
//	                order.getOrderId(),
//	                order.getClientUsername(),
//	                order.getDeliveryDate(),
//	                order.getRestaurant().getName()
//	            });
//	        }
//	    }
//	}
//	/**
//	 * @return the tableRestaurant
//	 */
//	public JTable getTableRestaurant() {
//		return tableOrder;
//	}
//	/**
//	 * @param tableRestaurant the tableRestaurant to set
//	 */
//	public void setTableRestaurant(JTable tableRestaurant) {
//		this.tableOrder = tableRestaurant;
//	}
//	/**
//	 * @return the btnSelect
//	 */
//	public JButton getBtnSelect() {
//		return btnSelectOrder;
//	}
//	/**
//	 * @param btnSelect the btnSelect to set
//	 */
//	public void setBtnSelect(JButton btnSelect) {
//		this.btnSelectOrder = btnSelect;
//	}
//	/**
//	 * @return the btnCompleteConsultation
//	 */
//	public JButton getBtnCompleteConsultation() {
//		return btnCompleteConsultation;
//	}
//	/**
//	 * @param btnCompleteConsultation the btnCompleteConsultation to set
//	 */
//	public void setBtnCompleteConsultation(JButton btnCompleteConsultation) {
//		this.btnCompleteConsultation = btnCompleteConsultation;
//	}
//	/**
//	 * @return the lblOrderNumber
//	 */
//	public JLabel getLblOrderNumber() {
//		return lblOrderNumber;
//	}
//	/**
//	 * @param lblOrderNumber the lblOrderNumber to set
//	 */
//	public void setLblOrderNumber(JLabel lblOrderNumber) {
//		this.lblOrderNumber = lblOrderNumber;
//	}
//	/**
//	 * @return the lblRestaurant
//	 */
//	public JLabel getLblRestaurant() {
//		return lblRestaurant;
//	}
//	/**
//	 * @param lblRestaurant the lblRestaurant to set
//	 */
//	public void setLblRestaurant(JLabel lblRestaurant) {
//		this.lblRestaurant = lblRestaurant;
//	}
//	/**
//	 * @return the lblDeliveryAddress
//	 */
//	public JLabel getLblDeliveryAddress() {
//		return lblDeliveryAddress;
//	}
//	/**
//	 * @param lblDeliveryAddress the lblDeliveryAddress to set
//	 */
//	public void setLblDeliveryAddress(JLabel lblDeliveryAddress) {
//		this.lblDeliveryAddress = lblDeliveryAddress;
//	}
//	/**
//	 * @return the lblDeliveryPostalCode
//	 */
//	public JLabel getLblDeliveryPostalCode() {
//		return lblDeliveryPostalCode;
//	}
//	/**
//	 * @param lblDeliveryPostalCode the lblDeliveryPostalCode to set
//	 */
//	public void setLblDeliveryPostalCode(JLabel lblDeliveryPostalCode) {
//		this.lblDeliveryPostalCode = lblDeliveryPostalCode;
//	}
//
//}
