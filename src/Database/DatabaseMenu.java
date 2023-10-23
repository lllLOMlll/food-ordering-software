package Database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatabaseMenu {
    private Map<String, List<Menu>> menus;

    public DatabaseMenu() {
        menus = new HashMap<>();
    }

    public void addMenuItems(Restaurant restaurant, List<Menu> items) {
        String restaurantName = restaurant.getName();
        if (!menus.containsKey(restaurantName)) {
            menus.put(restaurantName, new ArrayList<>());
        }
        menus.get(restaurantName).addAll(items);
    }

    public List<Menu> getMenuItems(Restaurant restaurant) {
        String restaurantName = restaurant.getName();
        return menus.getOrDefault(restaurantName, new ArrayList<>());
    }

    public void removeMenuItem(Restaurant restaurant, String itemName) {
        String restaurantName = restaurant.getName();
        List<Menu> items = menus.getOrDefault(restaurantName, new ArrayList<>());
        items.removeIf(item -> item.getItemName().equals(itemName));
    }
    
    public void addMenuItem(Restaurant restaurant, Menu menuItem) {
        String restaurantName = restaurant.getName();
        if (!menus.containsKey(restaurantName)) {
            menus.put(restaurantName, new ArrayList<>());
        }
        menus.get(restaurantName).add(menuItem);
    }

    public void updateMenuItem(Restaurant restaurant, Menu menuItem) {
        String restaurantName = restaurant.getName();
        List<Menu> items = menus.getOrDefault(restaurantName, new ArrayList<>());
        for (Menu item : items) {
            if (item.getItemName().equals(menuItem.getItemName())) {
                item.setPrice(menuItem.getPrice());
                return;
            }
        }    
    }
    
    public void deleteMenu(Restaurant restaurant) {
        String restaurantName = restaurant.getName();
        menus.remove(restaurantName);
    }
}
