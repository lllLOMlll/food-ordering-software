package Client;

import java.awt.Color;
import java.awt.Font;
import java.text.DecimalFormat;
import java.text.ParseException;
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
import javax.swing.text.NumberFormatter;

import Database.Restaurant;
import Model.Model;

import java.awt.Component;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewClientOrderFoodPanel extends JPanel {
	private JFormattedTextField frmtdtxtfTelephoneNumber;
	private JFormattedTextField frmtdtxtfPostalCode;
	private JTable tableRestaurant;
	private JFormattedTextField frmtdtxtfDeliveryTimeHour;
	private JFormattedTextField frmtdtxtfDeliveryTimeyyymmdd;
	private JTable tableMenu;
	private JTextField tfMeal;
	private JTextField tfPrice;
	private JFormattedTextField tfQuantity;
	private JTable tableOrder;
	private JScrollPane scrollPane;
	private JButton btnAdd;
	private JButton btnDelete;
	private JButton btnOrder;
	private Model model;
	private DefaultTableModel restaurantTableModel;
	private JButton btnSelect;
	private JTable tableCreateMenu;
	private JButton btnAddItemOrder;

	/**
	 * Create the panel.
	 */
	public ViewClientOrderFoodPanel(Model model) {
		this.model = model;
		setBounds(100, 100, 1200, 680);
		setLayout(null);

		JLabel lblRestaurant = new JLabel("Order Accepted");
		lblRestaurant.setHorizontalAlignment(SwingConstants.CENTER);
		lblRestaurant.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblRestaurant.setBounds(55, 143, 251, 23);
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
				tableRestaurant.setBounds(65, 177, 224, 309);
				add(tableRestaurant);

		
		JLabel lbOrderFood = new JLabel("OrderFood");
		lbOrderFood.setHorizontalAlignment(SwingConstants.CENTER);
		lbOrderFood.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbOrderFood.setBounds(438, 11, 224, 26);
		add(lbOrderFood);
		
		JLabel lbDeliveryTimeyyymmdd = new JLabel("Delivery Time (yyyy/mm/dd): ");
		lbDeliveryTimeyyymmdd.setHorizontalAlignment(SwingConstants.RIGHT);
		lbDeliveryTimeyyymmdd.setBounds(399, 60, 195, 19);
		add(lbDeliveryTimeyyymmdd);
		
		JLabel lblTelephoneNumber = new JLabel("Postal Code:");
		lblTelephoneNumber.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelephoneNumber.setBounds(438, 122, 156, 14);
		add(lblTelephoneNumber);
		
		try {
	            MaskFormatter postalcode = new MaskFormatter("U#U");
	            frmtdtxtfPostalCode = new JFormattedTextField(postalcode);
	            frmtdtxtfPostalCode.setBounds(605, 119, 57, 20);
	            add(frmtdtxtfPostalCode);
	        } catch (ParseException e) {
	     
	        	frmtdtxtfPostalCode = null;
	        }

		// Set the formatted text field's value
		 this.frmtdtxtfTelephoneNumber = frmtdtxtfPostalCode;


	

			
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
			    
			    JLabel lblMenu = new JLabel("Menu");
			    lblMenu.setHorizontalAlignment(SwingConstants.CENTER);
			    lblMenu.setFont(new Font("Tahoma", Font.BOLD, 13));
			    lblMenu.setBounds(316, 143, 208, 23);
			    add(lblMenu);
			    
			    tableCreateMenu = new JTable();
				tableCreateMenu.setModel(new DefaultTableModel(
					    new Object[][] {
							
					    },
					    new String[] {
					        "Item", "Price"
					    }
					));
				tableCreateMenu.setToolTipText("");
				tableCreateMenu.setBorder(new LineBorder(Color.LIGHT_GRAY));
				tableCreateMenu.setBackground(Color.WHITE);
				JScrollPane scrollPane = new JScrollPane(tableCreateMenu);
				scrollPane.setBounds(316, 178, 208, 308);
				add(scrollPane);
			    
			 
			    JLabel lblMeal = new JLabel("Meal:");
			    lblMeal.setBounds(534, 178, 60, 14);
			    add(lblMeal);
			    
			    JLabel lblPrice = new JLabel("Price:");
			    lblPrice.setBounds(534, 207, 60, 14);
			    add(lblPrice);
			    
			    JLabel lblQuantity = new JLabel("Quantity:");
			    lblQuantity.setBounds(534, 240, 60, 14);
			    add(lblQuantity);
			    
			    JLabel lblMaximum = new JLabel("(Max 10)");
			    lblMaximum.setBounds(534, 265, 60, 14);
			    add(lblMaximum);
			    
			    tfMeal = new JTextField();
			    tfMeal.setBounds(604, 175, 150, 20);
			    tfMeal.setEditable(false);
			    add(tfMeal);
			    tfMeal.setColumns(10);
			    
			    tfPrice = new JTextField();
			    tfPrice.setColumns(10);
			    tfPrice.setBounds(604, 204, 47, 20);
			    tfPrice.setEditable(false);
			    add(tfPrice);
			    
			    NumberFormatter formatter = new NumberFormatter(new DecimalFormat("##"));
			    tfQuantity = new JFormattedTextField(formatter);
			    tfQuantity.setColumns(10);
			    tfQuantity.setBounds(605, 237, 47, 20);
			    add(tfQuantity);

			    
			    btnAdd = new JButton("Add Item");
			    btnAdd.addActionListener(new ActionListener() {
			    	public void actionPerformed(ActionEvent e) {
			    	}
			    });
			    btnAdd.setBounds(357, 497, 126, 20);
			    add(btnAdd);
			    
			    btnDelete = new JButton("Delete Item from your order");
			    btnDelete.setBounds(534, 322, 220, 23);
			    add(btnDelete);
			    
			    
			    tableOrder = new JTable();
			    tableOrder.setModel(new DefaultTableModel(
							    new Object[][] {
									
							    },
							    new String[] {
							        "Item", "Price", "Quantity"
							    }
							));
			    tableOrder.setToolTipText("");
			    tableOrder.setBorder(new LineBorder(Color.LIGHT_GRAY));
			    tableOrder.setBackground(Color.WHITE);
						JScrollPane scrollPaneTableOrder = new JScrollPane(tableOrder);
						scrollPaneTableOrder.setBounds(764, 175, 404, 311);
						add(scrollPaneTableOrder);
						
				
			    
			    JLabel lblOrder = new JLabel("Order");
			    lblOrder.setHorizontalAlignment(SwingConstants.CENTER);
			    lblOrder.setFont(new Font("Tahoma", Font.BOLD, 13));
			    lblOrder.setBounds(867, 148, 208, 23);
			    add(lblOrder);
			    
			    btnOrder = new JButton("Pass your order");
			    btnOrder.setBounds(564, 410, 167, 35);
			    add(btnOrder);
			    
			    btnSelect = new JButton("Select Restaurant");
			    btnSelect.setBounds(86, 497, 189, 23);
			    add(btnSelect);
			    
			    btnAddItemOrder = new JButton("Add to your order");
			    btnAddItemOrder.setBounds(534, 288, 220, 23);
			    add(btnAddItemOrder);
			} catch (ParseException e) {
			    frmtdtxtfDeliveryTimeyyymmdd = null;
			    e.printStackTrace();
			}
	}

	/**
	 * @return the btnAddItemOrder
	 */
	public JButton getBtnAddItemOrder() {
		return btnAddItemOrder;
	}

	/**
	 * @param btnAddItemOrder the btnAddItemOrder to set
	 */
	public void setBtnAddItemOrder(JButton btnAddItemOrder) {
		this.btnAddItemOrder = btnAddItemOrder;
	}

	/**
	 * @return the restaurantTableModel
	 */
	public DefaultTableModel getRestaurantTableModel() {
		return restaurantTableModel;
	}

	/**
	 * @return the tableCreateMenu
	 */
	public JTable getTableCreateMenu() {
		return tableCreateMenu;
	}

	/**
	 * @param restaurantTableModel the restaurantTableModel to set
	 */
	public void setRestaurantTableModel(DefaultTableModel restaurantTableModel) {
		this.restaurantTableModel = restaurantTableModel;
	}

	/**
	 * @param tableCreateMenu the tableCreateMenu to set
	 */
	public void setTableCreateMenu(JTable tableCreateMenu) {
		this.tableCreateMenu = tableCreateMenu;
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

	/**
	 * @return the btnOrder
	 */
	public JButton getBtnOrder() {
		return btnOrder;
	}

	/**
	 * @param btnOrder the btnOrder to set
	 */
	public void setBtnOrder(JButton btnOrder) {
		this.btnOrder = btnOrder;
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
	 * @return the tableMenu
	 */
	public JTable getTableMenu() {
		return tableMenu;
	}

	/**
	 * @param tableMenu the tableMenu to set
	 */
	public void setTableMenu(JTable tableMenu) {
		this.tableMenu = tableMenu;
	}

	/**
	 * @return the tfMeal
	 */
	public JTextField getTfMeal() {
		return tfMeal;
	}

	/**
	 * @param tfMeal the tfMeal to set
	 */
	public void setTfMeal(JTextField tfMeal) {
		this.tfMeal = tfMeal;
	}

	/**
	 * @return the tfPrice
	 */
	public JTextField getTfPrice() {
		return tfPrice;
	}

	/**
	 * @param tfPrice the tfPrice to set
	 */
	public void setTfPrice(JTextField tfPrice) {
		this.tfPrice = tfPrice;
	}

	/**
	 * @return the tfQuantity
	 */
	public JTextField getTfQuantity() {
		return tfQuantity;
	}

	/**
	 * @param tfQuantity the tfQuantity to set
	 */
	public void setTfQuantity(JFormattedTextField tfQuantity) {
		this.tfQuantity = tfQuantity;
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

	/**
	 * @return the btnAdd
	 */
	public JButton getBtnAdd() {
		return btnAdd;
	}

	/**
	 * @param btnAdd the btnAdd to set
	 */
	public void setBtnAdd(JButton btnAdd) {
		this.btnAdd = btnAdd;
	}

	/**
	 * @return the btnDelete
	 */
	public JButton getBtnDelete() {
		return btnDelete;
	}

	/**
	 * @param btnDelete the btnDelete to set
	 */
	public void setBtnDelete(JButton btnDelete) {
		this.btnDelete = btnDelete;
	}
}
