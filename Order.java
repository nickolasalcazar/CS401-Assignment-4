import java.util.ArrayList;
import java.time.LocalDate;

public class Order {
	enum OrderStatus {
		New, Hold, Shipped, Delivered, Closed
	}

	String id;
	LocalDate ordered;
	LocalDate shipped;
	String ship_to;
	OrderStatus status;
	float total; // equal to the sum of the price of all LineItems

	float ammount_paid;
	boolean paid;

	ArrayList<Payment> payments = new ArrayList<Payment>();
	ArrayList<LineItem> lineItems = new ArrayList<LineItems>();

	/**
	 * 
	 */
	public Order(String id, String address, ArrayList<LineItem> lineItems) {
		this.id = id;
		ship_to = address;
		this.total = total;

	}
}