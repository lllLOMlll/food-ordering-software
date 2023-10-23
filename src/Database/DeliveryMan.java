package Database;

import java.util.ArrayList;

public class DeliveryMan {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private ArrayList<String> deliveryAreas;

    public DeliveryMan(String firstName, String lastName, String phoneNumber, ArrayList<String> deliveryAreas) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.deliveryAreas = deliveryAreas;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public ArrayList<String> getDeliveryAreas() {
        return deliveryAreas;
    }

    public void setDeliveryAreas(ArrayList<String> deliveryAreas) {
        this.deliveryAreas = deliveryAreas;
    }
}