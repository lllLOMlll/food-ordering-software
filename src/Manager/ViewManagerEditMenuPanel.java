package Manager;

import java.awt.Color;
import java.awt.Font;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import Database.Restaurant;
import Model.Model;

public class ViewManagerEditMenuPanel extends JPanel {
	private JTable tableRestaurant;
	private JButton btnSelect;
	private JTable tableCreateMenu;
	private JButton btnEditMenu;
	private JLabel lblNewLabel;
	private JLabel lblPrice;
	private JTextField tfItem;
	private JTextField tfPrice;
	private JButton btnAddItem;
	private JButton btnDeleteItem;
	private DefaultTableModel restaurantTableModel;
	private Model model;
	/**
	 * Create the panel.
	 * @param model 
	 */
	public ViewManagerEditMenuPanel(Model model) {
		this.model = model;
		setBounds(100, 100, 1200, 680);
		setLayout(null);



		JLabel lbEditMenu = new JLabel("Edit Menu");
		lbEditMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lbEditMenu.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbEditMenu.setBounds(413, 11, 350, 26);
		add(lbEditMenu);


		JLabel lblNewLabel_8 = new JLabel("Add Item");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_8.setBounds(413, 461, 356, 26);
		add(lblNewLabel_8);

	
		
		JLabel lblRestaurant = new JLabel("Restaurant");
		lblRestaurant.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblRestaurant.setBounds(107, 15, 126, 23);
		add(lblRestaurant);
		
		// Initialize the table first
		tableRestaurant = new JTable();

		// Set the model on the table
		restaurantTableModel = new DefaultTableModel(
		    new Object[][] {},
		    new String[] {"Restaurant"}
		);
		tableRestaurant.setModel(restaurantTableModel);

		// Update the table with the restaurants
		updateRestaurantTable("Le Major");
		updateRestaurantTable("Taco Taco!");
		tableRestaurant.setToolTipText("");
		tableRestaurant.setBorder(new LineBorder(Color.LIGHT_GRAY));
		tableRestaurant.setBackground(Color.WHITE);
		tableRestaurant.setBounds(68, 47, 165, 369);
		add(tableRestaurant);
		
		btnSelect = new JButton("Select");
		btnSelect.setBounds(70, 427, 163, 23);
		add(btnSelect);
		
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
		scrollPane.setBounds(413, 47, 350, 369);
		add(scrollPane);
		
		btnEditMenu = new JButton("Edit Menu");
		btnEditMenu.setBounds(545, 427, 95, 23);
		add(btnEditMenu);
		
		lblNewLabel = new JLabel("Item:");
		lblNewLabel.setBounds(413, 498, 52, 14);
		add(lblNewLabel);
		
		lblPrice = new JLabel("Price ($):");
		lblPrice.setBounds(413, 528, 52, 14);
		add(lblPrice);
		
		tfItem = new JTextField();
		tfItem.setBounds(469, 498, 297, 20);
		add(tfItem);
		tfItem.setColumns(10);
		
		tfPrice = new JTextField();
		tfPrice.setBounds(469, 523, 86, 20);
		add(tfPrice);
		tfPrice.setColumns(10);
		
		JButton btnEditItem = new JButton("Edit Item");
		btnEditItem.setBounds(545, 556, 95, 23);
		add(btnEditItem);
		
		btnAddItem = new JButton("Add Item");
		btnAddItem.setBounds(413, 556, 95, 23);
		add(btnAddItem);
		
		btnDeleteItem = new JButton("Delete Item");
		btnDeleteItem.setBounds(668, 556, 95, 23);
		add(btnDeleteItem);
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
	public void updateRestaurantTable(String restaurantName) {
		// Add a new row to the table model with the name of the restaurant
		restaurantTableModel.addRow(new Object[] { restaurantName });
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
	/**
	 * @return the tableCreateMenu
	 */
	public JTable getTableCreateMenu() {
		return tableCreateMenu;
	}
	/**
	 * @param tableCreateMenu the tableCreateMenu to set
	 */
	public void setTableCreateMenu(JTable tableCreateMenu) {
		this.tableCreateMenu = tableCreateMenu;
	}
	/**
	 * @return the btnEditMenu
	 */
	public JButton getBtnEditMenu() {
		return btnEditMenu;
	}
	/**
	 * @param btnEditMenu the btnEditMenu to set
	 */
	public void setBtnEditMenu(JButton btnEditMenu) {
		this.btnEditMenu = btnEditMenu;
	}
	/**
	 * @return the lblNewLabel
	 */
	public JLabel getLblNewLabel() {
		return lblNewLabel;
	}
	/**
	 * @param lblNewLabel the lblNewLabel to set
	 */
	public void setLblNewLabel(JLabel lblNewLabel) {
		this.lblNewLabel = lblNewLabel;
	}
	/**
	 * @return the lblPrice
	 */
	public JLabel getLblPrice() {
		return lblPrice;
	}
	/**
	 * @param lblPrice the lblPrice to set
	 */
	public void setLblPrice(JLabel lblPrice) {
		this.lblPrice = lblPrice;
	}
	/**
	 * @return the tfItem
	 */
	public JTextField getTfItem() {
		return tfItem;
	}
	/**
	 * @param tfItem the tfItem to set
	 */
	public void setTfItem(JTextField tfItem) {
		this.tfItem = tfItem;
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
	 * @return the btnAddItem
	 */
	public JButton getBtnAddItem() {
		return btnAddItem;
	}
	/**
	 * @param btnAddItem the btnAddItem to set
	 */
	public void setBtnAddItem(JButton btnAddItem) {
		this.btnAddItem = btnAddItem;
	}
	/**
	 * @return the btnDeleteItem
	 */
	public JButton getBtnDeleteItem() {
		return btnDeleteItem;
	}
	/**
	 * @param btnDeleteItem the btnDeleteItem to set
	 */
	public void setBtnDeleteItem(JButton btnDeleteItem) {
		this.btnDeleteItem = btnDeleteItem;
	}

}
