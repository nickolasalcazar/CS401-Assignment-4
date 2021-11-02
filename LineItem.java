/**
 * LineItem represents a Product that has been added to a ShoppingCart.
 * It records the price and quantity of the Product, and a reference to the
 * Product object that it represents.
 */
public class LineItem {
	private float price;
	private int qty;

	private Product product;

	public LineItem(Product product, float price, int qty) {
		this.product = product;
		this.price = price;
		this.qty = qty;
	}

	public float getPrice() { return price; }

	public int getQty() { return qty; }

	public void setQty(int qty) { this.qty = qty; }

	public Product getProduct() { return product; }

	public String toString() {
		return product.getName() + " x " + qty + " at $" + price;
	}
}