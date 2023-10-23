package Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import Database.User;
import Database.DatabaseDeliveryMan;
import Database.DatabaseMenu;
import Database.DatabaseOrder;
import Database.DatabaseRestaurant;
import Database.DatabaseUser;
import Database.DeliveryMan;
import Database.Menu;
import Database.Order;
import Database.Restaurant;
import Login.ViewLoginFrame;
import Login.ViewLoginPanel;

public class Model extends JFrame {

	private ViewLoginPanel viewLoginPanel;
	private DatabaseUser databaseUser;
	private DatabaseRestaurant databaseRestaurant;
	private DatabaseMenu databaseMenu;
	private DatabaseDeliveryMan databaseDeliveryMan;
	private DatabaseOrder databaseOrder;
	private DefaultTableModel restaurantTableModel;
	private User currentUser;

	


	public Model(DatabaseUser databaseUser, DatabaseRestaurant databaseRestaurant, 
			DatabaseMenu databaseMenu, DatabaseDeliveryMan databaseDeliveryMan, DatabaseOrder databaseOrder) {
		this.databaseUser = databaseUser;
		this.databaseRestaurant = databaseRestaurant;
		this.databaseMenu = databaseMenu;
		this.databaseDeliveryMan = databaseDeliveryMan;
		this.databaseOrder = databaseOrder;

	
		setCurrentUser(null);
		// User database
		// Creating users
		User admin1 = new User("LOM", "fj", "Major", "Louis-Olivier", "48 Thomas-Chapais, Sainte-Julie", "louis.olivier.major@gmail.com", "438-825-8175", "admin", "");
		User delivery1 = new User("D", "fj", "D", "D", "48 Thomas-Chapais, Sainte-Julie", "d@gmail.com", "438-825-8175", "delivery", "");
		User client1 = new User("C", "fj", "C", "C", "24 Belisle, Saint-Andre-Avellin", "c@example.com", "4505555678", "client", "");
		User restaurateur1 = new User("R1", "fj", "R", "R", "48 Thomas-Chapais, Sainte-Julie", "r@gmail.com", "438-825-8175", "restaurateur", "Le Major");
		User restaurateur2 = new User("R2", "fj", "R", "R", "48 Thomas-Chapais, Sainte-Julie", "r@gmail.com", "438-825-8175", "restaurateur", "Taco Taco!");
		User manager1 = new User("M1", "fj", "M1", "M1", "48 Thomas-Chapais, Sainte-Julie", "m@gmail.com", "438-825-8175", "manager", "Le Major");
		User manager2 = new User("M2", "fj", "M2", "M2", "48 Thomas-Chapais, Sainte-Julie", "m@gmail.com", "438-825-8175", "manager", "Taco Taco!");
		User dummyUser = new User("dummy", "", "", "", "", "", "", "", "");
		setCurrentUser(dummyUser);

		// Adding users to the database 
		databaseUser.addUser(admin1, "");
		databaseUser.addUser(delivery1, "");
		databaseUser.addUser(client1, "");
		databaseUser.addUser(restaurateur1, "");
		databaseUser.addUser(manager1, "Le Major");
		databaseUser.addUser(manager2, "Taco Taco!");
		databaseUser.addUser(dummyUser, getName());
		// Restaurant database
		Restaurant major = new Restaurant("Le Major", "24 Belisle, St-Julie", "4504547894", Arrays.asList("H3K", "H5J"), "15", "00", "23", "00", "15", "00", "23", "00", "15", "00", "23", "00", "15", "00", "23", "00", "15", "00", "23", "00", "15", "00", "23", "00", "15", "00", "23", "00");
		Restaurant taco = new Restaurant("Taco Taco!", "48 St-Jacques, Montreal", "5141234567", Arrays.asList("H6G", "H3P"), "10", "00", "23", "00", "10", "00", "23", "00", "10", "00", "23", "00", "10", "00", "23", "00", "10", "00", "23", "00", "10", "00", "23", "00", "10", "00", "23", "00");

		// Adding restaurant to the database
		databaseRestaurant.addRestaurant(major);
		databaseRestaurant.addRestaurant(taco);
		
		// Menu database
		// Creating menu items for restaurant 1
		Menu majorItem1 = new Menu("Poutine", 8.99);
		Menu majorItem2 = new Menu("Burger", 10.99);
		Menu majorItem3 = new Menu("Pasta", 12.99);
		Menu majorItem4 = new Menu("Salade", 6.99);
		Menu majorItem5 = new Menu("Sandwich", 7.99);
		Menu majorItem6 = new Menu("Pizza", 11.99);
		Menu majorItem7 = new Menu("Soup", 4.99);
		Menu majorItem8 = new Menu("Chicken Wings", 9.99);
		Menu majorItem9 = new Menu("Tacos", 8.99);
		Menu majorItem10 = new Menu("Sushi", 14.99);
		// Adding menu items to restaurant 1
		databaseMenu.addMenuItems(major, Arrays.asList(majorItem1, majorItem2, majorItem3, majorItem4, majorItem5, majorItem6, majorItem7, majorItem8, majorItem9, majorItem10));

		// Creating menu items for restaurant 2
		Menu tacoItem1 = new Menu("Taco", 2.99);
		Menu tacoItem2 = new Menu("Burrito", 7.99);
		Menu tacoItem3 = new Menu("Quesadilla", 6.99);
		Menu tacoItem4 = new Menu("Nachos", 5.99);
		Menu tacoItem5 = new Menu("Enchiladas", 9.99);
		Menu tacoItem6 = new Menu("Tostadas", 4.99);
		Menu tacoItem7 = new Menu("Tamales", 8.99);
		Menu tacoItem8 = new Menu("Salsa and Chips", 3.99);
		Menu tacoItem9 = new Menu("Guacamole", 4.99);
		Menu tacoItem10 = new Menu("Churros", 3.99);
		// Adding menu items to restaurant 2
		databaseMenu.addMenuItems(taco, Arrays.asList(tacoItem1, tacoItem2, tacoItem3, tacoItem4, tacoItem5, tacoItem6, tacoItem7, tacoItem8, tacoItem9, tacoItem10));

		
		// Delivery Man database
		DeliveryMan roger = new DeliveryMan("Roger", "Tremblay", "5141247894", new ArrayList<>(Arrays.asList("H3H", "H6J")));
		DeliveryMan john = new DeliveryMan("John", "Copperfield", "5143451647", new ArrayList<>(Arrays.asList("H4G", "H8H")));
		DeliveryMan melanie = new DeliveryMan("Melanie", "Dubois", "4183489691", new ArrayList<>(Arrays.asList("H4G", "H8H")));
		DeliveryMan judith = new DeliveryMan("Judith", "Lussier", "4184567896", new ArrayList<>(Arrays.asList("H4G", "H8H")));
		DeliveryMan suzan = new DeliveryMan("Suzan", "Doroth", "4181257894", new ArrayList<>(Arrays.asList("H3H", "H6J")));
		// Adding Delivery Man to the database
		databaseDeliveryMan.addDeliveryMan(roger);
		databaseDeliveryMan.addDeliveryMan(john);
		databaseDeliveryMan.addDeliveryMan(melanie);
		databaseDeliveryMan.addDeliveryMan(judith);
		databaseDeliveryMan.addDeliveryMan(suzan);
		
		// Create orders
        Order leMajorOrder = new Order("order1", client1.getUsername(), "20230510", "1830", "H3K", major, true, false, false, false);
        leMajorOrder.addItem("Poutine", 8.99, 2);
        Order tacoTacoOrder = new Order("order2", client1.getUsername(), "20230511", "1930", "H6G", taco, true, false, false, false);
        tacoTacoOrder.addItem("Nachos", 5.99, 6);
		// Adding order
        databaseOrder.addOrder("order1", leMajorOrder);
        databaseOrder.addOrder("order2", tacoTacoOrder);
        


	}
	

	public DatabaseUser getUserDatabase() {
		return databaseUser;
	}

	public DatabaseUser getDatabaseUser() {
		return databaseUser;
	}


	public void setDatabaseUser(DatabaseUser databaseUser) {
		this.databaseUser = databaseUser;
	}


	public DatabaseRestaurant getDatabaseRestaurant() {
		return databaseRestaurant;
	}


	public void setDatabaseRestaurant(DatabaseRestaurant databaseRestaurant) {
		this.databaseRestaurant = databaseRestaurant;
	}


	public DatabaseMenu getDatabaseMenu() {
		return databaseMenu;
	}


	public void setDatabaseMenu(DatabaseMenu databaseMenu) {
		this.databaseMenu = databaseMenu;
	}


	public DatabaseDeliveryMan getDatabaseDeliveryMan() {
		return databaseDeliveryMan;
	}


	public void setDatabaseDeliveryMan(DatabaseDeliveryMan databaseDeliveryMan) {
		this.databaseDeliveryMan = databaseDeliveryMan;
	}


	/**
	 * @return the databaseOrder
	 */
	public DatabaseOrder getDatabaseOrder() {
		return databaseOrder;
	}


	/**
	 * @param databaseOrder the databaseOrder to set
	 */
	public void setDatabaseOrder(DatabaseOrder databaseOrder) {
		this.databaseOrder = databaseOrder;
	}


	public DatabaseRestaurant getRestaurantDatabase() {
		return databaseRestaurant;
	}
	
	public DatabaseMenu getMenuDatabase() {
		return databaseMenu;
	}
	
	public DatabaseDeliveryMan getDeliveryManDatabase() {
	    return databaseDeliveryMan;
	}

//	public void updateRestaurantTable() {
//        // Get all the restaurants from the database
//        List<Restaurant> restaurants = databaseRestaurant.getAllRestaurants();
//
//        // Clear the table model
//        restaurantTableModel.setRowCount(0);
//
//        // Loop through the restaurants and add them to the table model
//        for (Restaurant restaurant : restaurants) {
//            Object[] rowData = {restaurant.getName()};
//            restaurantTableModel.addRow(rowData);
//        }
//    }
	
	// Method to verify the Username, Password and Access level of the user
	public boolean validateUsernameAndPassword(String username, char[] password, String requiredAccessLevel) {
		User user = databaseUser.getUser(username);
		if (user != null) {
			String inputPassword = new String(password);
			return user.getPassword().equals(inputPassword) && user.getAccessLevel().equals(requiredAccessLevel);
		}
		return false;
	}

//	public Restaurant getRestaurant(String restaurantName) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	public User getCurrentUser() {
	    return currentUser;
	}

	public void setCurrentUser(User currentUser) {
	    this.currentUser = currentUser;
	}
	
	public boolean isOldPasswordCorrect(String username, String oldPassword) {
	    // Retrieve the user object from the database using the username
	    User user = databaseUser.getUser(username);

	    // If the user object is not null, compare the old password with the user's password
	    if (user != null) {
	        return user.getPassword().equals(oldPassword);
	    }

	    // Return false if the user object is null
	    return false;
	}

	
}


