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

public class ViewAcceptingDeliveryPanel extends JPanel {
	private JTable tableOrder;
	private JButton btnAcceptingDelivery;
	private Model model;
	/**
	 * Create the panel.
	 */
	public ViewAcceptingDeliveryPanel(Model model) {
		this.model = model;
		setBounds(100, 100, 1200, 680);
		setLayout(null);



		JLabel lbAcceptingADelivery = new JLabel("Accepting a Delivery");
		lbAcceptingADelivery.setHorizontalAlignment(SwingConstants.LEFT);
		lbAcceptingADelivery.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbAcceptingADelivery.setBounds(526, 11, 237, 26);
		add(lbAcceptingADelivery);

	
		
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
		
		btnAcceptingDelivery = new JButton("Accepting Delivery");
		btnAcceptingDelivery.setBounds(453, 391, 278, 63);
		add(btnAcceptingDelivery);
	}
	
	public void populateDeliveryTable() {
	    DefaultTableModel tableModel = new DefaultTableModel(new Object[][] {}, new String[] {"Order ID", "Client", "Delivery Date", "Restaurant"});
	    tableOrder.setModel(tableModel);
	
	    for (Map.Entry<String, Order> entry : model.getDatabaseOrder().getOrders().entrySet()) {
	        Order order = entry.getValue();

	        if (order.isDeliveryManPending() && !order.isDeliveryManAccepted()) {
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
	 * @return the tableOrder
	 */
	public JTable getTableOrder() {
		return tableOrder;
	}
	/**
	 * @param tableOrder the tableOrder to set
	 */
	public void setTableOrder(JTable tableOrder) {
		this.tableOrder = tableOrder;
	}
	/**
	 * @return the btnSelectOrder
	 */

	/**
	 * @return the btnAcceptingDelivery
	 */
	public JButton getBtnAcceptingDelivery() {
		return btnAcceptingDelivery;
	}
	/**
	 * @param btnAcceptingDelivery the btnAcceptingDelivery to set
	 */
	public void setBtnAcceptingDelivery(JButton btnAcceptingDelivery) {
		this.btnAcceptingDelivery = btnAcceptingDelivery;
	}


}
