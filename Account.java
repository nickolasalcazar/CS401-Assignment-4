import java.util.ArrayList;
import java.time.LocalDate;

public class Account {
	String id;
	String billing_address;
	Boolean is_closed = false;
	LocalDate open;
	LocalDate closed; // Assigned when Account is closed

	// ShoppingCart shoppingCart; // 1-to-1
	// ArrayList<Order> orders = new ArrayList<Order>(); // 1-to-*

	public Account(String id, String address) {
		this.id = id;
		billing_address = address;

		open = LocalDate.now();

		// shoppingCart = new ShoppingCart(); // 1 per Account

		System.out.println("Account opened on " + open.toString());
	}
}