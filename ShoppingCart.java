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
	 * @return lineItems, an ArrayList containing the LineItems of
	 * ShoppingCart.
	 */
	public ArrayList<LineItem> getLineItems() { return lineItems; }

	/**
	 * Returns a deep copy the contents of this ShoppingCart as a new
	 * ShoppingCart.
	 * 
	 * @return Deep copy of the contents of lineItems.
	 */
	public ArrayList<LineItem> deepCopyLineItems() {
		ArrayList<LineItem> deepCopy = new ArrayList<LineItem>();
		for (int i=0; i<lineItems.size(); i++) {
			Product product = lineItems.get(i).getProduct();
			float price = lineItems.get(i).getPrice();
			int qty = lineItems.get(i).getQty();
			deepCopy.add(new LineItem(product, price, qty));
		}
		return deepCopy;
	}

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

	/**
	 * Removes a lineItem from lineItems
	 * @return True if lineItem is removed, false otherwise.
	 */
	public boolean removeLineItem(Product product) {
		if (lineItems.isEmpty()) return false;
		for (int i = 0; i < lineItems.size(); i++) {
			if (lineItems.get(i).getProduct() == product) {
				lineItems.remove(i);
				return true;
			}
		}
		return false;
	}

	/**
	 * @return String listing all LineItems line-by-line.
	 */
	public String toString() {
		String s = "";
		for (int i=0; i<lineItems.size(); i++) {
			if (i != (lineItems.size() - 1)) {
				s+=lineItems.get(i).getProduct().getName() + ", ";
			} else s+=lineItems.get(i).getProduct().getName();
		}
		return s;
	}
}