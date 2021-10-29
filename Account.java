import java.util.ArrayList;
import java.time.LocalDate;

/**
 * Account owns ShoppingCart and Orders.
 * 
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
	 * Makes a new Order and stores it in the ArrayList field orders.
	 * Creates the Order using LineItems from ShoppingCart as an argument.
	 * 
	 * @param id		ID of the Order to be created.
	 */
	public void makeOrder(String orderId) {
		Order order = new Order(orderId, billing_address, shoppingCart.getLineItems());
		orders.add(order);
	}
}