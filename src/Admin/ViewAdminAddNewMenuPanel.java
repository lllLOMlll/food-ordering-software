package Admin;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import Database.Restaurant;
import Model.Model;

public class ViewAdminAddNewMenuPanel extends JPanel {
	
	private JTable tableRestaurant;
	private JButton btnSelect;
	private JTable tableCreateMenu;
	private JButton btnCreateMenu;
	
	private JLabel lblNewLabel;
	private JLabel lblPrice;
	private JTextField tfItem;
	private JTextField tfPrice;
	private DefaultTableModel restaurantTableModel;
	private JButton btnAddItem;
	private JScrollPane scrollPane;
	private JButton btnDeleteLine;
	private Model model;
	/**
	 * Create the panel.
	 */
	public ViewAdminAddNewMenuPanel(Model model) {
		this.model = model;
		setBounds(100, 100, 1200, 680);
		setLayout(null);



		JLabel lbCreateMenu = new JLabel("Create Menu");
		lbCreateMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lbCreateMenu.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbCreateMenu.setBounds(413, 11, 350, 26);
		add(lbCreateMenu);


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
		scrollPane = new JScrollPane(tableCreateMenu);
		scrollPane.setBounds(413, 47, 350, 369);
		add(scrollPane);
		
		btnCreateMenu = new JButton("Create Menu");
		btnCreateMenu.setBounds(413, 427, 142, 23);
		add(btnCreateMenu);
		
		lblNewLabel = new JLabel("Item:");
		lblNewLabel.setBounds(413, 498, 52, 14);
		add(lblNewLabel);
		
		lblPrice = new JLabel("Price ($):");
		lblPrice.setBounds(413, 528, 52, 14);
		add(lblPrice);
		
		tfItem = new JTextField();
		tfItem.setBounds(469, 498, 294, 20);
		add(tfItem);
		tfItem.setColumns(10);
		
		tfPrice = new JTextField();
		tfPrice.setBounds(469, 525, 86, 20);
		add(tfPrice);
		tfPrice.setColumns(10);

		// Add a FocusListener to the text field to validate the input when the user leaves the field
		tfPrice.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String input = tfPrice.getText().trim();
				if (!input.matches("\\d+(\\.\\d{2})?")) {
					JOptionPane.showMessageDialog(null, "Invalid price format. Please enter a price in the format of XX.XX");
					tfPrice.setText("");
					tfPrice.requestFocus();
				}
			}
		});

		
		btnAddItem = new JButton("Add Item");
		btnAddItem.setBounds(545, 556, 95, 23);
		add(btnAddItem);
		
		btnDeleteLine = new JButton("Delete Line");
		btnDeleteLine.setBounds(621, 427, 142, 23);
		add(btnDeleteLine);
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
	/**
	 * @return the btnDeleteLine
	 */
	public JButton getBtnDeleteLine() {
		return btnDeleteLine;
	}

	/**
	 * @param btnDeleteLine the btnDeleteLine to set
	 */
	public void setBtnDeleteLine(JButton btnDeleteLine) {
		this.btnDeleteLine = btnDeleteLine;
	}

	public void updateRestaurantTable(String restaurantName) {
	    // Add a new row to the table model with the name of the restaurant
	    restaurantTableModel.addRow(new Object[] {restaurantName});
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
	 * @return the btnCreateMenu
	 */
	public JButton getBtnCreateMenu() {
		return btnCreateMenu;
	}
	/**
	 * @param btnCreateMenu the btnCreateMenu to set
	 */
	public void setBtnCreateMenu(JButton btnCreateMenu) {
		this.btnCreateMenu = btnCreateMenu;
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
	 * @return the restaurantTableModel
	 */
	public DefaultTableModel getRestaurantTableModel() {
		return restaurantTableModel;
	}

	/**
	 * @param restaurantTableModel the restaurantTableModel to set
	 */
	public void setRestaurantTableModel(DefaultTableModel restaurantTableModel) {
		this.restaurantTableModel = restaurantTableModel;
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
}
