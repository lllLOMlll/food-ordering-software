package Database;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private String name;
    private String address;
    private String telephoneNumber;
    private List<String> deliveryAreas;
    // Sunday opening and closing time
    private String sundayOpening1;
    private String sundayOpening2;
    private String sundayClosing1;
    private String sundayClosing2;
    // Monday opening and closing time
    private String mondayOpening1;
    private String mondayOpening2;
    private String mondayClosing1;
    private String mondayClosing2;
    //  Thuesay opening and closing time
    private String tuesdayOpening1;
    private String tuesdayOpening2;
    private String tuesdayClosing1;
    private String tuesdayClosing2;
    // Wednesday opening and closing time
    private String wednesdayOpening1;
    private String wednesdayOpening2;
    private String wednesdayClosing1;
    private String wednesdayClosing2;
    // Thursday opening and closing time
    private String thursdayOpening1;
    private String thursdayOpening2;
    private String thursdayClosing1;
    private String thursdayClosing2;
    // Friday opening and closing time
    private String fridayOpening1;
    private String fridayOpening2;
    private String fridayClosing1;
    private String fridayClosing2;
    // Saturday opening and closing time
    private String saturdayOpening1;
    private String saturdayOpening2;
    private String saturdayClosing1;
    private String saturdayClosing2;
    
    // You can add more fields if necessary, like opening and closing times

    public Restaurant(String name, String address, String telephoneNumber, List<String> deliveryAreas, String sundayOpening1, String sundayOpening2, String sundayClosing1, String sundayClosing2, String mondayOpening1, String mondayOpening2, String mondayClosing1, String mondayClosing2, String tuesdayOpening1, String tuesdayOpening2, String tuesdayClosing1, String tuesdayClosing2, String wednesdayOpening1, String wednesdayOpening2, String wednesdayClosing1, String wednesdayClosing2, String thursdayOpening1, String thursdayOpening2, String thursdayClosing1, String thursdayClosing2, String fridayOpening1, String fridayOpening2, String fridayClosing1, String fridayClosing2, String SaturdayOpening1, String SaturdayOpening2, String SaturdayClosing1, String SaturdayClosing2) {
        this.name = name;
        this.address = address;
        this.telephoneNumber = telephoneNumber;
        this.deliveryAreas = new ArrayList<>(deliveryAreas);
//        this.deliveryAreas = new ArrayList<>();
        this.sundayOpening1 = sundayOpening1;
        this.sundayOpening2 = sundayOpening2;
        this.sundayClosing1 = sundayClosing1;
        this.sundayClosing2 = sundayClosing2;
        this.mondayOpening1 = mondayOpening1;
        this.mondayOpening2 = mondayOpening2;
        this.mondayClosing1 = mondayClosing1;
        this.mondayClosing2 = mondayClosing2;
        this.tuesdayOpening1 = tuesdayOpening1;
        this.tuesdayOpening2 = tuesdayOpening2;
        this.tuesdayClosing1 = tuesdayClosing1;
        this.tuesdayClosing2 = tuesdayClosing2;
        this.wednesdayOpening1 = wednesdayOpening1;
        this.wednesdayOpening2 = wednesdayOpening2;
        this.wednesdayClosing1 = wednesdayClosing1;
        this.wednesdayClosing2 = wednesdayClosing2;
        this.thursdayOpening1 = thursdayOpening1;
        this.thursdayOpening2 = thursdayOpening2;
        this.thursdayClosing1 = thursdayClosing1;
        this.thursdayClosing2 = thursdayClosing2;
        this.fridayOpening1 = fridayOpening1;
        this.fridayOpening2 = fridayOpening2;
        this.fridayClosing1 = fridayClosing1;
        this.fridayClosing2 = fridayClosing2;
        this.saturdayOpening1 = SaturdayOpening1;
        this.saturdayOpening2 = SaturdayOpening2;
        this.saturdayClosing1 = SaturdayClosing1;
        this.saturdayClosing2 = SaturdayClosing2;
    }


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the telephoneNumber
	 */
	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	/**
	 * @param telephoneNumber the telephoneNumber to set
	 */
	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public void addDeliveryArea(String postalCode) {
	    deliveryAreas.add(postalCode);
	}

	public void removeDeliveryArea(String postalCode) {
	    deliveryAreas.remove(postalCode);
	}

	public List<String> getDeliveryAreas() {
	    return deliveryAreas;
	}

	public void setDeliveryAreas(List<String> deliveryAreas) {
	    this.deliveryAreas = deliveryAreas;
	}

	/**
	 * @return the sundayOpening1
	 */
	public String getSundayOpening1() {
		return sundayOpening1;
	}

	/**
	 * @param sundayOpening1 the sundayOpening1 to set
	 */
	public void setSundayOpening1(String sundayOpening1) {
		this.sundayOpening1 = sundayOpening1;
	}

	/**
	 * @return the sundayOpening2
	 */
	public String getSundayOpening2() {
		return sundayOpening2;
	}

	/**
	 * @param sundayOpening2 the sundayOpening2 to set
	 */
	public void setSundayOpening2(String sundayOpening2) {
		this.sundayOpening2 = sundayOpening2;
	}

	/**
	 * @return the sundayClosing1
	 */
	public String getSundayClosing1() {
		return sundayClosing1;
	}

	/**
	 * @param sundayClosing1 the sundayClosing1 to set
	 */
	public void setSundayClosing1(String sundayClosing1) {
		this.sundayClosing1 = sundayClosing1;
	}

	/**
	 * @return the sundayClosing2
	 */
	public String getSundayClosing2() {
		return sundayClosing2;
	}

	/**
	 * @param sundayClosing2 the sundayClosing2 to set
	 */
	public void setSundayClosing2(String sundayClosing2) {
		this.sundayClosing2 = sundayClosing2;
	}

	/**
	 * @return the mondayOpening1
	 */
	public String getMondayOpening1() {
		return mondayOpening1;
	}

	/**
	 * @param mondayOpening1 the mondayOpening1 to set
	 */
	public void setMondayOpening1(String mondayOpening1) {
		this.mondayOpening1 = mondayOpening1;
	}

	/**
	 * @return the mondayOpening2
	 */
	public String getMondayOpening2() {
		return mondayOpening2;
	}

	/**
	 * @param mondayOpening2 the mondayOpening2 to set
	 */
	public void setMondayOpening2(String mondayOpening2) {
		this.mondayOpening2 = mondayOpening2;
	}

	/**
	 * @return the mondayClosing1
	 */
	public String getMondayClosing1() {
		return mondayClosing1;
	}

	/**
	 * @param mondayClosing1 the mondayClosing1 to set
	 */
	public void setMondayClosing1(String mondayClosing1) {
		this.mondayClosing1 = mondayClosing1;
	}

	/**
	 * @return the mondayClosing2
	 */
	public String getMondayClosing2() {
		return mondayClosing2;
	}

	/**
	 * @param mondayClosing2 the mondayClosing2 to set
	 */
	public void setMondayClosing2(String mondayClosing2) {
		this.mondayClosing2 = mondayClosing2;
	}

	/**
	 * @return the tuesdayOpening1
	 */
	public String getTuesdayOpening1() {
		return tuesdayOpening1;
	}

	/**
	 * @param tuesdayOpening1 the tuesdayOpening1 to set
	 */
	public void setTuesdayOpening1(String tuesdayOpening1) {
		this.tuesdayOpening1 = tuesdayOpening1;
	}

	/**
	 * @return the tuesdayOpening2
	 */
	public String getTuesdayOpening2() {
		return tuesdayOpening2;
	}

	/**
	 * @param tuesdayOpening2 the tuesdayOpening2 to set
	 */
	public void setTuesdayOpening2(String tuesdayOpening2) {
		this.tuesdayOpening2 = tuesdayOpening2;
	}

	/**
	 * @return the tuesdayClosing1
	 */
	public String getTuesdayClosing1() {
		return tuesdayClosing1;
	}

	/**
	 * @param tuesdayClosing1 the tuesdayClosing1 to set
	 */
	public void setTuesdayClosing1(String tuesdayClosing1) {
		this.tuesdayClosing1 = tuesdayClosing1;
	}

	/**
	 * @return the tuesdayClosing2
	 */
	public String getTuesdayClosing2() {
		return tuesdayClosing2;
	}

	/**
	 * @param tuesdayClosing2 the tuesdayClosing2 to set
	 */
	public void setTuesdayClosing2(String tuesdayClosing2) {
		this.tuesdayClosing2 = tuesdayClosing2;
	}

	/**
	 * @return the wednesdayOpening1
	 */
	public String getWednesdayOpening1() {
		return wednesdayOpening1;
	}

	/**
	 * @param wednesdayOpening1 the wednesdayOpening1 to set
	 */
	public void setWednesdayOpening1(String wednesdayOpening1) {
		this.wednesdayOpening1 = wednesdayOpening1;
	}

	/**
	 * @return the wednesdayOpening2
	 */
	public String getWednesdayOpening2() {
		return wednesdayOpening2;
	}

	/**
	 * @param wednesdayOpening2 the wednesdayOpening2 to set
	 */
	public void setWednesdayOpening2(String wednesdayOpening2) {
		this.wednesdayOpening2 = wednesdayOpening2;
	}

	/**
	 * @return the wednesdayClosing1
	 */
	public String getWednesdayClosing1() {
		return wednesdayClosing1;
	}

	/**
	 * @param wednesdayClosing1 the wednesdayClosing1 to set
	 */
	public void setWednesdayClosing1(String wednesdayClosing1) {
		this.wednesdayClosing1 = wednesdayClosing1;
	}

	/**
	 * @return the wednesdayClosing2
	 */
	public String getWednesdayClosing2() {
		return wednesdayClosing2;
	}

	/**
	 * @param wednesdayClosing2 the wednesdayClosing2 to set
	 */
	public void setWednesdayClosing2(String wednesdayClosing2) {
		this.wednesdayClosing2 = wednesdayClosing2;
	}

	/**
	 * @return the thursdayOpening1
	 */
	public String getThursdayOpening1() {
		return thursdayOpening1;
	}

	/**
	 * @param thursdayOpening1 the thursdayOpening1 to set
	 */
	public void setThursdayOpening1(String thursdayOpening1) {
		this.thursdayOpening1 = thursdayOpening1;
	}

	/**
	 * @return the thursdayOpening2
	 */
	public String getThursdayOpening2() {
		return thursdayOpening2;
	}

	/**
	 * @param thursdayOpening2 the thursdayOpening2 to set
	 */
	public void setThursdayOpening2(String thursdayOpening2) {
		this.thursdayOpening2 = thursdayOpening2;
	}

	/**
	 * @return the thursdayClosing1
	 */
	public String getThursdayClosing1() {
		return thursdayClosing1;
	}

	/**
	 * @param thursdayClosing1 the thursdayClosing1 to set
	 */
	public void setThursdayClosing1(String thursdayClosing1) {
		this.thursdayClosing1 = thursdayClosing1;
	}

	/**
	 * @return the thursdayClosing2
	 */
	public String getThursdayClosing2() {
		return thursdayClosing2;
	}

	/**
	 * @param thursdayClosing2 the thursdayClosing2 to set
	 */
	public void setThursdayClosing2(String thursdayClosing2) {
		this.thursdayClosing2 = thursdayClosing2;
	}

	/**
	 * @return the fridayOpening1
	 */
	public String getFridayOpening1() {
		return fridayOpening1;
	}

	/**
	 * @param fridayOpening1 the fridayOpening1 to set
	 */
	public void setFridayOpening1(String fridayOpening1) {
		this.fridayOpening1 = fridayOpening1;
	}

	/**
	 * @return the fridayOpening2
	 */
	public String getFridayOpening2() {
		return fridayOpening2;
	}

	/**
	 * @param fridayOpening2 the fridayOpening2 to set
	 */
	public void setFridayOpening2(String fridayOpening2) {
		this.fridayOpening2 = fridayOpening2;
	}

	/**
	 * @return the fridayClosing1
	 */
	public String getFridayClosing1() {
		return fridayClosing1;
	}

	/**
	 * @param fridayClosing1 the fridayClosing1 to set
	 */
	public void setFridayClosing1(String fridayClosing1) {
		this.fridayClosing1 = fridayClosing1;
	}

	/**
	 * @return the fridayClosing2
	 */
	public String getFridayClosing2() {
		return fridayClosing2;
	}

	/**
	 * @param fridayClosing2 the fridayClosing2 to set
	 */
	public void setFridayClosing2(String fridayClosing2) {
		this.fridayClosing2 = fridayClosing2;
	}

	/**
	 * @return the saturdayOpening1
	 */
	public String getSaturdayOpening1() {
		return saturdayOpening1;
	}

	/**
	 * @param saturdayOpening1 the saturdayOpening1 to set
	 */
	public void setSaturdayOpening1(String saturdayOpening1) {
		saturdayOpening1 = saturdayOpening1;
	}

	/**
	 * @return the saturdayOpening2
	 */
	public String getSaturdayOpening2() {
		return saturdayOpening2;
	}

	/**
	 * @param saturdayOpening2 the saturdayOpening2 to set
	 */
	public void setSaturdayOpening2(String saturdayOpening2) {
		saturdayOpening2 = saturdayOpening2;
	}

	/**
	 * @return the saturdayClosing1
	 */
	public String getSaturdayClosing1() {
		return saturdayClosing1;
	}

	/**
	 * @param saturdayClosing1 the saturdayClosing1 to set
	 */
	public void setSaturdayClosing1(String saturdayClosing1) {
		saturdayClosing1 = saturdayClosing1;
	}

	/**
	 * @return the saturdayClosing2
	 */
	public String getSaturdayClosing2() {
		return saturdayClosing2;
	}

	/**
	 * @param saturdayClosing2 the saturdayClosing2 to set
	 */
	public void setSaturdayClosing2(String saturdayClosing2) {
		saturdayClosing2 = saturdayClosing2;
	}

	public String getOpeningHours(Restaurant restaurant) {
	    String openingHours = "Opening and closing times: \n";
	    openingHours += "Sunday: " + restaurant.getSundayOpening1() + "h" + restaurant.getSundayClosing1() + " to " +
	        restaurant.getSundayOpening2() + "h" + restaurant.getSundayClosing2() + "\n";
	    openingHours += "Monday: " + restaurant.getMondayOpening1() + "h" + restaurant.getMondayClosing1() + " to " +
	        restaurant.getMondayOpening2() + "h" + restaurant.getMondayClosing2() + "\n";
	    openingHours += "Tuesday: " + restaurant.getTuesdayOpening1() + "h" + restaurant.getTuesdayClosing1() + " to " +
	        restaurant.getTuesdayOpening2() + "h" + restaurant.getTuesdayClosing2() + "\n";
	    openingHours += "Wednesday: " + restaurant.getWednesdayOpening1() + "h" + restaurant.getWednesdayClosing1() + " to " +
	        restaurant.getWednesdayOpening2() + "h" + restaurant.getWednesdayClosing2() + "\n";
	    openingHours += "Thursday: " + restaurant.getThursdayOpening1() + "h" + restaurant.getThursdayClosing1() + " to " +
	        restaurant.getThursdayOpening2() + "h" + restaurant.getThursdayClosing2() + "\n";
	    openingHours += "Friday: " + restaurant.getFridayOpening1() + "h" + restaurant.getFridayClosing1() + " to " +
	        restaurant.getFridayOpening2() + "h" + restaurant.getFridayClosing2() + "\n";
	    openingHours += "Saturday: " + restaurant.getSaturdayOpening1() + "h" + restaurant.getSaturdayClosing1() + " to " +
	        restaurant.getSaturdayOpening2() + "h" + restaurant.getSaturdayClosing2() + "\n";
	    return openingHours;
	}


    
}
