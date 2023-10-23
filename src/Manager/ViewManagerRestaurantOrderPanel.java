package Manager;

import java.awt.Color;
import java.awt.Font;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

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
import Database.Restaurant;
import Model.Model;

import java.awt.Component;

public class ViewManagerRestaurantOrderPanel extends JPanel {
	private JFormattedTextField frmtdtxtfTelephoneNumber;
	private JFormattedTextField frmtdtxtfPostalCode;
	private JTable tableMealInOrder;
	private JTable tableRestaurant;
	private JButton btnSelectRestaurant;
	private JFormattedTextField frmtdtxtfDeliveryTimeHour;
	private JFormattedTextField frmtdtxtfDeliveryTimeyyymmdd;
	private JTable tableRestaurantsOrder;
	private JButton btnSelectRestaurantsOrder;
	private JScrollPane scrollPane;
	private Model model;
	private DefaultTableModel restaurantTableModel;

	/**
	 * Create the panel.
	 */
	public ViewManagerRestaurantOrderPanel(Model model) {
		this.model = model;
		setBounds(100, 100, 1200, 680);
		setLayout(null);

		JLabel lblRestaurant = new JLabel("Restaurant");
		lblRestaurant.setHorizontalAlignment(SwingConstants.CENTER);
		lblRestaurant.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblRestaurant.setBounds(55, 15, 251, 23);
		add(lblRestaurant);

		// Initialize the table first
		tableRestaurant = new JTable();

		// Set the model on the table
		restaurantTableModel = new DefaultTableModel(new Object[][] {}, new String[] { "Restaurant" });
		tableRestaurant.setModel(restaurantTableModel);
		// Update the table with the restaurants
		updateRestaurantTable("Le Major");
		updateRestaurantTable("Taco Taco!");
		tableRestaurant.setToolTipText("");
		tableRestaurant.setBorder(new LineBorder(Color.LIGHT_GRAY));
		tableRestaurant.setBackground(Color.WHITE);
		scrollPane = new JScrollPane(tableRestaurant);
		scrollPane.setBounds(65, 49, 251, 510);
		add(scrollPane);

		btnSelectRestaurant = new JButton("Select");
		btnSelectRestaurant.setBounds(55, 570, 251, 23);
		add(btnSelectRestaurant);

		JLabel lbViewOrder = new JLabel("View Order");
		lbViewOrder.setHorizontalAlignment(SwingConstants.CENTER);
		lbViewOrder.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbViewOrder.setBounds(627, 11, 224, 26);
		add(lbViewOrder);

		JLabel lbDeliveryTimeyyymmdd = new JLabel("Delivery Time (yyyy/mm/dd): ");
		lbDeliveryTimeyyymmdd.setHorizontalAlignment(SwingConstants.RIGHT);
		lbDeliveryTimeyyymmdd.setBounds(593, 50, 190, 14);
		add(lbDeliveryTimeyyymmdd);

		JLabel lblTelephoneNumber = new JLabel("Postal Code:");
		lblTelephoneNumber.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelephoneNumber.setBounds(627, 109, 156, 14);
		add(lblTelephoneNumber);
		try {
			MaskFormatter postalcode = new MaskFormatter("U#U #U#");
			frmtdtxtfPostalCode = new JFormattedTextField(postalcode);
			frmtdtxtfPostalCode.setBounds(793, 106, 57, 20);
			add(frmtdtxtfPostalCode);
		} catch (ParseException e) {

			frmtdtxtfPostalCode = null;
		}

		// Set the formatted text field's value
		this.frmtdtxtfTelephoneNumber = frmtdtxtfPostalCode;

		JLabel lblMealInOrder = new JLabel("Meal in Order");
		lblMealInOrder.setHorizontalAlignment(SwingConstants.LEFT);
		lblMealInOrder.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMealInOrder.setBounds(627, 134, 326, 26);
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
		JScrollPane scrollPane = new JScrollPane(tableMealInOrder);
		scrollPane.setBounds(627, 170, 447, 389);
		add(scrollPane);



		JLabel lblLastName = new JLabel("Delivery Time:");
		lblLastName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLastName.setBounds(627, 75, 156, 14);
		add(lblLastName);
		try {
			MaskFormatter deliveryTime = new MaskFormatter("##'h' ##'m'");
			frmtdtxtfDeliveryTimeHour = new JFormattedTextField(deliveryTime);
			frmtdtxtfDeliveryTimeHour.setBounds(793, 72, 57, 20);
			add(frmtdtxtfDeliveryTimeHour);
		} catch (ParseException e) {
			frmtdtxtfDeliveryTimeHour = null;
			e.printStackTrace();
		}
		try {
			MaskFormatter deliveryDate = new MaskFormatter("####/##/##");
			frmtdtxtfDeliveryTimeyyymmdd = new JFormattedTextField(deliveryDate);
			frmtdtxtfDeliveryTimeyyymmdd.setBounds(793, 47, 68, 20);
			add(frmtdtxtfDeliveryTimeyyymmdd);

			tableRestaurantsOrder = new JTable();
			tableRestaurantsOrder.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Order ID" }));
			tableRestaurantsOrder.setToolTipText("");
			tableRestaurantsOrder.setBorder(new LineBorder(Color.LIGHT_GRAY));
			tableRestaurantsOrder.setBackground(Color.WHITE);
			tableRestaurantsOrder.setBounds(332, 50, 251, 510);
			add(tableRestaurantsOrder);

			btnSelectRestaurantsOrder = new JButton("Select");
			btnSelectRestaurantsOrder.setBounds(332, 570, 251, 23);
			add(btnSelectRestaurantsOrder);

			JLabel lblRestaurantsOrder = new JLabel("Restaurant's Order");
			lblRestaurantsOrder.setHorizontalAlignment(SwingConstants.CENTER);
			lblRestaurantsOrder.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblRestaurantsOrder.setBounds(332, 15, 251, 23);
			add(lblRestaurantsOrder);
		} catch (ParseException e) {
			frmtdtxtfDeliveryTimeyyymmdd = null;
			e.printStackTrace();
		}
	}

	public DefaultTableModel getRestaurantTableModel() {
		return restaurantTableModel;
	}

	public void setRestaurantTableModel(DefaultTableModel restaurantTableModel) {
		this.restaurantTableModel = restaurantTableModel;
	}

	// Method to update the tables that display restaurants
	public void updateTableRestaurant() {
		DefaultTableModel restaurantTableModel = (DefaultTableModel) tableRestaurant.getModel();
		restaurantTableModel.setRowCount(0);
		List<Restaurant> restaurants = model.getRestaurantDatabase().getAllRestaurants();
		for (Restaurant restaurant : restaurants) {
			String[] row = new String[] { restaurant.getName() };
			restaurantTableModel.addRow(row);
		}
	}

	public void updateRestaurantTable(String restaurantName) {
		// Add a new row to the table model with the name of the restaurant
		restaurantTableModel.addRow(new Object[] { restaurantName });
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
	 * @return the btnSelectRestaurant
	 */
	public JButton getBtnSelectRestaurant() {
		return btnSelectRestaurant;
	}

	/**
	 * @param btnSelectRestaurant the btnSelectRestaurant to set
	 */
	public void setBtnSelectRestaurant(JButton btnSelectRestaurant) {
		this.btnSelectRestaurant = btnSelectRestaurant;
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

	/**
	 * @return the tableRestaurantsOrder
	 */
	public JTable getTableRestaurantsOrder() {
		return tableRestaurantsOrder;
	}

	/**
	 * @param tableRestaurantsOrder the tableRestaurantsOrder to set
	 */
	public void setTableRestaurantsOrder(JTable tableRestaurantsOrder) {
		this.tableRestaurantsOrder = tableRestaurantsOrder;
	}

	/**
	 * @return the btnSelectRestaurantsOrder
	 */
	public JButton getBtnSelectRestaurantsOrder() {
		return btnSelectRestaurantsOrder;
	}

	/**
	 * @param btnSelectRestaurantsOrder the btnSelectRestaurantsOrder to set
	 */
	public void setBtnSelectRestaurantsOrder(JButton btnSelectRestaurantsOrder) {
		this.btnSelectRestaurantsOrder = btnSelectRestaurantsOrder;
	}

	/**
	 * @return the scrollPane
	 */
	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	/**
	 * @param scrollPane the scrollPane to set
	 */
	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}
}
