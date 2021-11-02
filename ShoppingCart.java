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
	 * Returns lineItems, an ArrayList containing the LineItems of
	 * ShoppingCart.
	 */
	public ArrayList<LineItem> getLineItems() { return lineItems; }

	/**
	 * Empties ShoppingCart of its LineItems.
	 */
	public void clearLineItems() { lineItems.clear(); }

	/**
	 * Remove a quantity of a Product from ShoppingCart. Removes a Product
	 * object from the ArrayList lineItems.
	 * 
	 * @param product	Product to remove.
	 * @param price		Price of LineItem.
	 * @param qty		Quantity of the Product to remove.
	 */
	public void addLineItem(Product product, float price, int qty) {
		for (int i = 0; i < lineItems.size(); i++) {
			// If product already exists in lineItems, add extra qty
			if (lineItems.get(i).getProduct().equals(product)) {
				lineItems.get(i).setQty(lineItems.get(i).getQty() + qty);
				return;
			}
		}
		lineItems.add(new LineItem(product, price, qty));
	}

	// public void removeProduct(Product product, int qty) { }

	/**
	 * @return String listing all LineItems line-by-line.
	 */
	public String toString() {
		String s = "";
		for (int i=0; i<lineItems.size(); i++) {
			s+=lineItems.get(i).getProduct().getName();
			if (i != lineItems.size() - 1) s+="\n";
		}
		return s;
	}
}