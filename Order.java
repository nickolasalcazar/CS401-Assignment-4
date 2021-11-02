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
	 * Make a Payment to an Order. Creates a new Payment and stores it in the
	 * ArrayList payments. Updates amount_paid. If amount is totally paid,
	 * payment_complete is updated to true.
	 * 
	 * @param 	id			Id of payment. Not checked for uniqueness.
	 * @param 	amount		Amount paid to total.
	 * @param 	details		Details about the payment.
	 * @throws	OverpaidException
	 */
	public void makePayment(String id, float amount, String details)
	throws OverpaidException {
		if ((amount + calculateAmountPaid()) > total)
			throw new OverpaidException("Overpaid total amount.");
		payments.add(new Payment(id, amount, details));
		updateAmountPaid();
		if (amount_paid == total) payment_complete = true;
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
		if (payments.isEmpty()) {
			s+="No Payments\n";
		} else {
			for (int i=0; i<payments.size(); i++) 
				{ s+=payments.get(i).toString(); }
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
	 * Updates current amount paid from all payments. Updates amount_paid.
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