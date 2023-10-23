package Restaurateur;

import java.awt.Color;
import java.awt.Font;
import java.text.ParseException;
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

public class ViewRestaurateurOrderReadyPanel extends JPanel {
	private JFormattedTextField frmtdtxtfTelephoneNumber;
	private JFormattedTextField frmtdtxtfPostalCode;
	private JTable tableMealInOrder;
	private JButton btnOrderReady;
	private JTable tablePendingOrder;
	private JButton btnSelectOrderReady;
	private JFormattedTextField frmtdtxtfDeliveryTimeHour;
	private JFormattedTextField frmtdtxtfDeliveryTimeyyymmdd;
	private Model model;
	/**
	 * Create the panel.
	 */
	public ViewRestaurateurOrderReadyPanel(Model model) {
		this.model = model;
		setBounds(100, 100, 1200, 680);
		setLayout(null);

		JLabel lblOrderAccepted = new JLabel("Order Accepted");
		lblOrderAccepted.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrderAccepted.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblOrderAccepted.setBounds(55, 15, 251, 23);
		add(lblOrderAccepted);

		
		tablePendingOrder = new JTable();
		tablePendingOrder.setModel(new DefaultTableModel(
			new Object[][] {
				{"1. Order..."},
			},
			new String[] {
				"Order"
			}
		));
		tablePendingOrder.setToolTipText("");
		tablePendingOrder.setBorder(new LineBorder(Color.LIGHT_GRAY));
		tablePendingOrder.setBackground(Color.WHITE);
		JScrollPane scrollPane = new JScrollPane(tablePendingOrder);
		scrollPane.setBounds(55, 49, 334, 457);
		add(scrollPane);
		
		btnSelectOrderReady = new JButton("Select");
		btnSelectOrderReady.setBounds(55, 517, 334, 23);
		add(btnSelectOrderReady);
		
		JLabel lbOrderReady = new JLabel("Order Ready");
		lbOrderReady.setHorizontalAlignment(SwingConstants.CENTER);
		lbOrderReady.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbOrderReady.setBounds(438, 11, 224, 26);
		add(lbOrderReady);
		
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

			btnOrderReady = new JButton("Order Ready");
			btnOrderReady.setBounds(582, 517, 181, 58);
			add(btnOrderReady);

			// create the table
			tableMealInOrder = new JTable();
			tableMealInOrder.setBackground(Color.WHITE);
			tableMealInOrder.setModel(
			        new DefaultTableModel(
				new Object[][] {
					{null, null, null},
					{null, null, null},
				},
				new String[] {
					"Item", "New column", "New column"
				}
			)
			);
			tableMealInOrder.setBorder(new LineBorder(Color.LIGHT_GRAY));
			tableMealInOrder.setToolTipText("");
			tableMealInOrder.setBounds(438, 207, 447, 299);
			add(tableMealInOrder);


	

			
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
			    frmtdtxtfDeliveryTimeyyymmdd.setBounds(605, 57, 57, 20);
			    add(frmtdtxtfDeliveryTimeyyymmdd);
			} catch (ParseException e) {
			    frmtdtxtfDeliveryTimeyyymmdd = null;
			    e.printStackTrace();
			}
	
	}
	
	public void populateOrderTable() {
	    DefaultTableModel tableModel = new DefaultTableModel(new Object[][] {}, new String[] {"Order ID", "Client", "Delivery Date", "Restaurant"});
	    tablePendingOrder.setModel(tableModel);
	
	    for (Map.Entry<String, Order> entry : model.getDatabaseOrder().getOrders().entrySet()) {
	        Order order = entry.getValue();

	        if (!order.isRestaurateurPending()) {
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
	 * @return the btnOrderReady
	 */
	public JButton getBtnOrderReady() {
		return btnOrderReady;
	}
	/**
	 * @param btnOrderReady the btnOrderReady to set
	 */
	public void setBtnOrderReady(JButton btnOrderReady) {
		this.btnOrderReady = btnOrderReady;
	}
	/**
	 * @return the tablePendingOrder
	 */
	public JTable getTablePendingOrder() {
		return tablePendingOrder;
	}
	/**
	 * @param tablePendingOrder the tablePendingOrder to set
	 */
	public void setTablePendingOrder(JTable tablePendingOrder) {
		this.tablePendingOrder = tablePendingOrder;
	}
	/**
	 * @return the btnSelectOrderReady
	 */
	public JButton getBtnSelectOrderReady() {
		return btnSelectOrderReady;
	}
	/**
	 * @param btnSelectOrderReady the btnSelectOrderReady to set
	 */
	public void setBtnSelectOrderReady(JButton btnSelectOrderReady) {
		this.btnSelectOrderReady = btnSelectOrderReady;
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
