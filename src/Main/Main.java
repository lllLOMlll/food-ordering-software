package Main;

import Database.DatabaseDeliveryMan;
import Database.DatabaseMenu;
import Database.DatabaseOrder;
import Database.DatabaseRestaurant;
import Database.User;
import Database.DatabaseUser;
import Database.Restaurant;
import Login.ControllerLogin;
import Login.ViewLoginFrame;
import Login.MainFrame;
import Model.Model;

public class Main {

    public static void main(String[] args) {
        // Databases
        DatabaseUser databaseUser = new DatabaseUser();
        DatabaseRestaurant databaseRestaurant = new DatabaseRestaurant();
        DatabaseMenu databaseMenu = new DatabaseMenu();
        DatabaseDeliveryMan databaseDeliveryMan = new DatabaseDeliveryMan();
        DatabaseOrder databaseOrder = new DatabaseOrder();
        
        

   
        // Model
        Model model = new Model(databaseUser, databaseRestaurant, databaseMenu, databaseDeliveryMan, databaseOrder);

        // Frame
        MainFrame mainFrame = new MainFrame();

        // View
        ViewLoginFrame viewLoginFrame = new ViewLoginFrame();

        // Main Controllers 
        ControllerLogin logincontroller = new ControllerLogin(model, viewLoginFrame);
        

        // Initial view
        viewLoginFrame.setVisible(true);
        
        
    }
}

