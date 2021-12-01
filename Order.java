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
		ordered = LocalDate.now();
		ship_to = address;
		this.lineItems = lineItems;
		total = calculateTotal();
		updateAmountPaid();
	}

	public String getId() { return id; }

	public String getAddress() { return ship_to; }

	public ArrayList<LineItem> getLineItems() { return lineItems; }

	public float getTotal() { return total; }

	public void setStatus(OrderStatus newStatus) { status = newStatus; }

	/**
	 * Make a Payment to an Order. Creates a new Payment and stores it in
	 * payments. Payment id is set to the index of the Payment in the payments.
	 * 
	 * @param 	amount		Amount paid to total.
	 * @throws	OverpaidException
	 */
	public void makePayment(float amount)
	throws OverpaidException {
		if ((amount + calculateAmountPaid()) > total)
			throw new OverpaidException("Overpaid total amount.");
		payments.add(new Payment(String.valueOf(payments.size()), amount));
		updateAmountPaid();
		if (amount_paid == total) payment_complete = true;
	}

	/**
	 * @return String listing properties, Payments, and LineItems associated
	 * with this Order.
	 */
	public String toString() {
		String s = "";
		s+="              id: " + id;
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
			for (int i=0; i<payments.size(); i++) {
				s+=payments.get(i).toString();
			}
		}
		if (lineItems.isEmpty()) {
			s+="No Line Items";
		} else {
			s+="Products:\n";
			for (int i=0; i<lineItems.size(); i++) {
				if (i != (lineItems.size() - 1)) {
					s+=lineItems.get(i).getProduct().getName() + ", ";
				} else s+=lineItems.get(i).getProduct().getName();
			}
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