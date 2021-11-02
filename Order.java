import java.util.ArrayList;
import java.time.LocalDate;

public class Order {
	private String id;
	private LocalDate ordered;
	private LocalDate shipped;
	private String ship_to;
	private OrderStatus status = OrderStatus.NEW;
	private float total; // equal to the sum of the price of all LineItems

	private float ammount_paid;
	private boolean payment_complete; // When ammount_paid == total

	ArrayList<Payment> payments = new ArrayList<Payment>();
	ArrayList<LineItem> lineItems = new ArrayList<LineItem>();

	/**
	 * Constructor for Order. OrderStatus is set to NEW by default upon
	 * creation.
	 * 
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

	public void setStatus(OrderStatus newStatus) { status = newStatus; }

	/**
	 * Make a Payment to an Order.
	 * 
	 * @exception
	 */
	//public void makePayment() { TODO }

	/**
	 * @return String listing properties of Order, as well as the list of
	 * Payments made to Order.
	 */
	public String toString() {
		String s = "";

		s+="                id: " + id;
		s+="\n         ordered: " + ordered;
		s+="\n         shipped: " + shipped;
		s+="\n         ship_to: " + ship_to;
		s+="\n          status: " + status;
		s+="\n           total: " + total;
		s+="\n     amount_paid: " + ammount_paid;
		s+="\npayment_complete: " + payment_complete;
		s+="\nPayments:\n";

		for (int i=0; i<payments.size(); i++) {

		}

		return s;
	}
}