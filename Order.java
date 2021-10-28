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
	float total; // Total price

	float ammount_paid;
	boolean paid;

	ArrayList<Payment> payments = new ArrayList<Payment>();
	ArrayList<LineItem> lineItems = new ArrayList<LineItems>();


	public Order(String id, String address, float total) {

	}
}