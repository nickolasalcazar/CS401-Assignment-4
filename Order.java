import java.util.ArrayList;
import java.time.LocalDate;

public class Order {
	enum OrderStatus {
		New, Hold, Shipped, Delivered, Closed
	}

	private String id;
	private LocalDate ordered;
	private LocalDate shipped;
	private String ship_to;
	private OrderStatus status;
	private float total; // equal to the sum of the price of all LineItems

	private float ammount_paid;
	private boolean paid;

	ArrayList<Payment> payments = new ArrayList<Payment>();
	ArrayList<LineItem> lineItems = new ArrayList<LineItem>();

	/**
	 * @param id		Order ID.
	 * @param address	Shipping address.
	 * @param lineItems	ArrayList containing LineItems, presumably
	 * 					sourced from a ShoppingCart object.
	 */
	public Order(String id, String address, ArrayList<LineItem> lineItems) {
		this.id = id;
		ship_to = address;
		this.total = total;
	}

	public String getId() { return id; }

	public String getAddress() { return ship_to; }

	public ArrayList<LineItem> getLineItems() { return lineItems; }


	public void setStatus(OrderStatus newStatus) {
		status = newStatus;
	}
}