package Database;

import java.util.HashMap;

public class DatabaseUser {
    private HashMap<String, User> users;

    public DatabaseUser() {
        users = new HashMap<>();
    }

    public void addUser(User user, String restaurantName) {
        user.setRestaurantName(restaurantName);
        users.put(user.getUsername(), user);
    }

    public User getUser(String username) {
        return users.get(username);
    }

    public boolean containsUser(String username) {
        return users.containsKey(username);
    }

    public void removeUser(String username) {
        users.remove(username);
    }
}
