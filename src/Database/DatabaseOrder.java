package Database;

import java.util.HashMap;

public class DatabaseOrder {
    private HashMap<String, Order> orders;

    public DatabaseOrder() {
        orders = new HashMap<>();
    }

    public void addOrder(String orderId, Order order) {
        orders.put(orderId, order);
    }

    public Order getOrder(String orderId) {
        return orders.get(orderId);
    }

    public boolean containsOrder(String orderId) {
        return orders.containsKey(orderId);
    }

    public void removeOrder(String orderId) {
        orders.remove(orderId);
    }

    // Add the missing getOrders() method
    public HashMap<String, Order> getOrders() {
        return orders;
    }
}