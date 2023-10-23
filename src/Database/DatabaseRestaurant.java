package Database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DatabaseRestaurant {
    private HashMap<String, Restaurant> restaurants;

    public DatabaseRestaurant() {
        restaurants = new HashMap<>();
    }

    public void addRestaurant(Restaurant restaurant) {
        restaurants.put(restaurant.getName(), restaurant);
    }

    public Restaurant getRestaurant(String name) {
        return restaurants.get(name);    
    }
    
    public List<Restaurant> getAllRestaurants() {
        return new ArrayList<>(restaurants.values());
    }

    public boolean containsRestaurant(String name) {
        return restaurants.containsKey(name);
    }

    public void removeRestaurant(String name) {
        restaurants.remove(name);
    }
    
    public void debugPrintAllRestaurants() {
        System.out.println("Listing all stored restaurants:");
        for (String name : restaurants.keySet()) {
            System.out.println(name);
        }
    }
  
  
}

