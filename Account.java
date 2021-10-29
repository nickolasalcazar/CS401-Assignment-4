import java.util.ArrayList;
import java.time.LocalDate;

/**
 * Account manages ShoppingCart and Orders, and is associated with a single
 * Customer and WebUser. Can add LineItems to ShoppingCart and create Orders
 * based off of the contents of ShoppingCart. Can also access and manage
 * an associated WebUser account.
 */
public class Account {
	String id;
	String billing_address;
	boolean is_closed = false;
	LocalDate open;
	LocalDate closed; // Assigned when Account is closed

	ShoppingCart shoppingCart; // 1-to-1
	ArrayList<Order> orders = new ArrayList<Order>(); // 1-to-*

	/**
	 * Constructor for Account objects. Creates an associated ShoppingCart
	 * and ArrayList of Order objects called orders.
	 * 
	 * @param id		Account ID.
	 * @param address	Account address.
	 */
	public Account(String id, String address) {
		this.id = id;
		billing_address = address;

		open = LocalDate.now();

		shoppingCart = new ShoppingCart(); // 1 per Account

		System.out.println("Account opened on " + open.toString());
	}

	/**
	 * Makes a new Order and stores it in the ArrayList orders. Creates the
	 * Order using LineItems from ShoppingCart. After the Order has been
	 * from ShoppingCart, ShoppingCart is emptied.
	 * 
	 * @param id		ID of the Order to be created.
	 */
	public void makeOrder(String orderId) {
		Order order = new Order(orderId, billing_address, shoppingCart.getLineItems());
		orders.add(order);
		shoppingCart.clearLineItems();
	}

	/**
	 * Adds a Product to ShoppingCart with an associated price and quantity.
	 */
	public void addToShoppingCart(Product product, float price, int qty) {
		shoppingCart.addLineItem(product, price, qty);
	}

	//public void removeFromShoppingCart(Product product, int qty) {}
}