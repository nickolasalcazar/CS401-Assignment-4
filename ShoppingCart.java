import java.util.ArrayList;
import java.time.LocalDate;

public class ShoppingCart {
	private LocalDate created;

	ArrayList<LineItem> lineItems;

	/**
	 * Constructor of ShoppingCart. Instantiates an empty ArrayList
	 * of LineItems.
	 */
	public ShoppingCart() {
		created = LocalDate.now();

		lineItems = new ArrayList<LineItem>();
	}

	LocalDate getDateCreated() { return created; }

	/**
	 * Returns lineItems.
	 */
	public ArrayList<LineItem> getLineItems() {
		return lineItems;
	}
}