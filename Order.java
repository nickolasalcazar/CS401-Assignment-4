import java.util.ArrayList;
import java.time.LocalDate;

public class Order {
	private String id;
	private LocalDate ordered;
	private LocalDate shipped;
	private String ship_to;
	private OrderStatus status = OrderStatus.NEW;
	private float total; // equal to the sum of the price of all LineItems

	private float amount_paid;
	private boolean payment_complete; // When amount_paid == total

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
		total = calculateTotal();
		updateAmountPaid();
	}

	public String getId() { return id; }

	public String getAddress() { return ship_to; }

	public ArrayList<LineItem> getLineItems() { return lineItems; }

	public float getTotal() { return total; }

	public void setStatus(OrderStatus newStatus) { status = newStatus; }

	/**
	 * Make a Payment to an Order.
	 * 
	 * @exception
	 */
	public void makePayment() {
		// TODO
	}

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
		s+="\n     amount_paid: " + amount_paid;
		s+="\npayment_complete: " + payment_complete;
		s+="\nPayments:\n";

		for (int i=0; i<payments.size(); i++) {

		}

		return s;
	}

	/**
	 * @return Total price of all line items.
	 */
	private float calculateTotal() {
		float t = 0;
		for (int i=0; i<lineItems.size(); i++) {
			t+=lineItems.get(i).getPrice() * lineItems.get(i).getQty();
		}
		return t;
	}

	/**
	 * Udpates current amount paid from all payments. Updates amount_paid.
	 */
	private void updateAmountPaid() { amount_paid = calculateAmountPaid(); }

	/**
	 * Calculates and returns current amount paid from all payments.
	 * 
	 * @return Total amount paid from all payments.
	 */
	private float calculateAmountPaid() {
		float t = 0;
		for (int i=0; i<payments.size(); i++) {
			t+=payments.get(i).getTotal();
		}
		return t;
	}
}