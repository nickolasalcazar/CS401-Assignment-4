import java.time.LocalDate;

/**
 * Payment represents a single payment to an Order. One or more payments may be
 * assigned to a single order.
 */
public class Payment {
	private String id;
	private LocalDate date;
	private float total;	// Ammount paid
	private String details;

	/**
	 * Constructor for payment. Paremeter details is not required for this
	 * constructor and is left empty.
	 * 
	 * @param id		Id of payment. Not checked for uniqueness.
	 * @param total		Amount paid.
	 */
	public Payment(String id, float total) {
		this.id = id;
		this.total = total;
		this.details = "";	// Left empty
		date = LocalDate.now();
	}

	/**
	 * Constructor for payment. Includes parameter details.
	 * 
	 * @param id		Id of payment. Not checked for uniqueness.
	 * @param total		Amount paid.
	 * @param details 	Details about the payment.
	 */
	public Payment(String id, float total, String details) {
		this.id = id;
		this.total = total;
		this.details = details;
		date = LocalDate.now();
	}

	public String getId() { return id; }

	public LocalDate getDate() { return date; }

	public float getTotal() { return total; }

	public String getDetails() { return details; } 

	public void setDetails(String details) { this.details = details; }

	public String toString() {
		return id + " " + date + " " + total + " " + details + "\n";
	}
}