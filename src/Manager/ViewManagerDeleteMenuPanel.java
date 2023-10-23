package Manager;

import java.awt.Color;
import java.awt.Font;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import Database.Restaurant;
import Model.Model;

public class ViewManagerDeleteMenuPanel extends JPanel {

	private JTable tableRestaurant;
	private DefaultTableModel restaurantTableModel;
	private JButton btnSelect;
	private JTable tableCreateMenu;
	private JButton btnDeleteMenu;
	private Model model;
	
	/**
	 * Create the panel.
	 */
	public ViewManagerDeleteMenuPanel(Model model) {
		this.model = model;
		setBounds(100, 100, 1200, 680);
		setLayout(null);



		JLabel lbDeleteMenu = new JLabel("Delete Menu");
		lbDeleteMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lbDeleteMenu.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbDeleteMenu.setBounds(413, 11, 350, 26);
		add(lbDeleteMenu);

	
		
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
		
		btnDeleteMenu = new JButton("Delete Menu");
		btnDeleteMenu.setBounds(504, 427, 163, 23);
		add(btnDeleteMenu);
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
	 * @return the btnDeleteMenu
	 */
	public JButton getBtnDeleteMenu() {
		return btnDeleteMenu;
	}
	/**
	 * @param btnDeleteMenu the btnDeleteMenu to set
	 */
	public void setBtnDeleteMenu(JButton btnDeleteMenu) {
		this.btnDeleteMenu = btnDeleteMenu;
	}

}
