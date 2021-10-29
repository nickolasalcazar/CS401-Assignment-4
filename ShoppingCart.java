import java.util.ArrayList;
import java.time.LocalDate;

public class ShoppingCart {
	private LocalDate created;

	private ArrayList<LineItem> lineItems;

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

	/**
	 * Remove a quantity of a product from the ShoppingCart. Removes
	 * a Product object from the ArrayList lineItems.
	 * 
	 * @param product	Product to remove.
	 * @param qty		Quantity of the the product.
	 */
	//public void addProduct(Product product, int qty) { }

	// public void removeProduct(Product product, int qty) { }
}