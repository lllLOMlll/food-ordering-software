package Database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DatabaseDeliveryMan {
    // The deliveryman are associated with their phone number
    private HashMap<String, DeliveryMan> deliveryMen;

    public DatabaseDeliveryMan() {
        deliveryMen = new HashMap<>();
    }

    public void addDeliveryMan(DeliveryMan deliveryMan) {
        deliveryMen.put(deliveryMan.getPhoneNumber(), deliveryMan);
    }
    
    public boolean containsDeliveryMan(String phoneNumber) {
        return deliveryMen.containsKey(phoneNumber);
    }

    public List<DeliveryMan> getAllDeliveryMen() {
        return new ArrayList<>(deliveryMen.values());
    }

    public void removeDeliveryMan(String phoneNumber) {
        deliveryMen.remove(phoneNumber);
    }
}
