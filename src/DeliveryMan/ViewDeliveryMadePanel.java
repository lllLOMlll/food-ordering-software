package DeliveryMan;

import java.awt.Color;
import java.awt.Font;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import Database.Order;
import Model.Model;

public class ViewDeliveryMadePanel extends JPanel {
	private JTable tableOrder;
	private JButton btnSelectOrder;
	private JButton btnDeliveryDone;
	private JLabel lblOrderNumber;
	private JLabel lblRestaurant;
	private JLabel lblDeliveryAddress;
	private JLabel lblDeliveryPostalCode;
	private Model model;
	/**
	 * Create the panel.
	 */
	public ViewDeliveryMadePanel(Model model) {
		this.model = model;
		setBounds(100, 100, 1200, 680);
		setLayout(null);



		JLabel lbDeliveryDone = new JLabel("Delivery Done");
		lbDeliveryDone.setHorizontalAlignment(SwingConstants.LEFT);
		lbDeliveryDone.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbDeliveryDone.setBounds(526, 11, 237, 26);
		add(lbDeliveryDone);

	
		
		JLabel lblOrder = new JLabel("Order");
		lblOrder.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrder.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblOrder.setBounds(68, 15, 165, 23);
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
		scrollPane.setBounds(68, 97, 855, 270);
		add(scrollPane);
		
		btnSelectOrder = new JButton("Select");
		btnSelectOrder.setBounds(70, 427, 163, 23);
		add(btnSelectOrder);
		
		btnDeliveryDone = new JButton("Delivery Done");
		btnDeliveryDone.setBounds(526, 148, 165, 23);
		add(btnDeliveryDone);
		
		lblOrderNumber = new JLabel("Order #: 1");
		lblOrderNumber.setBounds(526, 48, 415, 14);
		add(lblOrderNumber);
		
		lblRestaurant = new JLabel("Restaurant #: 1");
		lblRestaurant.setBounds(526, 73, 415, 14);
		add(lblRestaurant);
		
		lblDeliveryAddress = new JLabel("Delivery Address: 123 Fake Street, Montreal");
		lblDeliveryAddress.setBounds(526, 98, 415, 14);
		add(lblDeliveryAddress);
		
		lblDeliveryPostalCode = new JLabel("Delivery Postal Code:  J4H 5G5");
		lblDeliveryPostalCode.setBounds(526, 123, 165, 14);
		add(lblDeliveryPostalCode);
	}
	
	public void populateDeliveryTable() {
	    DefaultTableModel tableModel = new DefaultTableModel(new Object[][] {}, new String[] {"Order ID", "Client", "Delivery Date", "Restaurant"});
	    tableOrder.setModel(tableModel);
	
	    for (Map.Entry<String, Order> entry : model.getDatabaseOrder().getOrders().entrySet()) {
	        Order order = entry.getValue();

	        if (order.isDeliveryManAccepted()) {
	            tableModel.addRow(new Object[] {
	                order.getOrderId(),
	                order.getClientUsername(),
	                order.getDeliveryDate(),
	                order.getRestaurant().getName()
	            });
	        }
	    }
	}

}
