package Database;

import java.util.HashMap;
import java.util.Map;

public class Order {
    private String orderId;
    /**
	 * @return the restaurant
	 */
	public Restaurant getRestaurant() {
		return restaurant;
	}

	/**
	 * @param restaurant the restaurant to set
	 */
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	private String clientUsername;
    private String deliveryDate; // Format: yyyy/MM/dd
    private String deliveryTime; // Format: HH:mm
    private String postalCode;
    private Map<String, OrderItem> items;
    private Restaurant restaurant; 

    private boolean restaurateurPending;
    private boolean deliveryManPending;
    private boolean deliveryManAccepted;
    private boolean delivered;

    public Order(String orderId, String clientUsername, String deliveryDate, String deliveryTime, String postalCode, Restaurant restaurant,boolean restaurateurPending, boolean deliveryManPending, boolean deliveryManAccepted, boolean delivered) {
        this.orderId = orderId;
        this.clientUsername = clientUsername;
        this.deliveryDate = deliveryDate;
        this.deliveryTime = deliveryTime;
        this.postalCode = postalCode;
        this.items = new HashMap<>();
        this.restaurant = restaurant;
        this.restaurateurPending = restaurateurPending; // Use the parameter value
        this.deliveryManPending = deliveryManPending; // Use the parameter value
        this.deliveryManAccepted = deliveryManAccepted;
        this.delivered = delivered; // Use the parameter value
    }

	public void addItem(String itemName, double price, int quantity) {
		OrderItem item = new OrderItem(itemName, price, quantity);
		items.put(itemName, item);
	}

	public static class OrderItem {
		private String itemName;
		private double price;
		private int quantity;

		public OrderItem(String itemName, double price, int quantity) {
			this.itemName = itemName;
			this.price = price;
			this.quantity = quantity;
		}

		public String getItemName() {
			return itemName;
		}

		public double getPrice() {
			return price;
		}

		public int getQuantity() {
			return quantity;
		}

		/**
		 * @param itemName the itemName to set
		 */
		public void setItemName(String itemName) {
			this.itemName = itemName;
		}

		/**
		 * @param price the price to set
		 */
		public void setPrice(double price) {
			this.price = price;
		}

		/**
		 * @param quantity the quantity to set
		 */
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
	}

	/**
	 * @return the clientUsername
	 */
	public String getClientUsername() {
		return clientUsername;
	}

	/**
	 * @return the deliveryDate
	 */
	public String getDeliveryDate() {
		return deliveryDate;
	}

	/**
	 * @return the deliveryTime
	 */
	public String getDeliveryTime() {
		return deliveryTime;
	}

	/**
	 * @return the postalCode
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * @return the items
	 */
	public Map<String, OrderItem> getItems() {
		return items;
	}

	/**
	 * @param clientUsername the clientUsername to set
	 */
	public void setClientUsername(String clientUsername) {
		this.clientUsername = clientUsername;
	}

	/**
	 * @param deliveryDate the deliveryDate to set
	 */
	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	/**
	 * @param deliveryTime the deliveryTime to set
	 */
	public void setDeliveryTime(String deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	/**
	 * @param postalCode the postalCode to set
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	/**
	 * @param items the items to set
	 */
	public void setItems(Map<String, OrderItem> items) {
		this.items = items;
	}

	// Add the missing getOrderId() method
	public String getOrderId() {
		return orderId;
	}

	// Add the missing setOrderId() method
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	
	public boolean isRestaurateurPending() {
        return restaurateurPending;
    }

    public void setRestaurateurPending(boolean restaurateurPending) {
        this.restaurateurPending = restaurateurPending;
    }

    public boolean isDeliveryManPending() {
        return deliveryManPending;
    }

    public void setDeliveryManPending(boolean deliveryManPending) {
        this.deliveryManPending = deliveryManPending;
    }

    public boolean isDelivered() {
        return delivered;
    }

    public void setDelivered(boolean delivered) {
        this.delivered = delivered;
    }

	public boolean isDeliveryManAccepted() {
		return deliveryManAccepted;
	}

	public void setDeliveryManAccepted(boolean deliveryManAccepted) {
		this.deliveryManAccepted = deliveryManAccepted;
	}

}