/**
 * LineItem represents a Product that has been added to a ShoppingCart.
 * It records the price and quantity of the Product, and a reference to the
 * Product object that it represents.
 */
public class LineItem {
	private float price;
	private int qty;

	private Product product;

	public Product(float price, int qty) {
		this.price = price;
		this.qty = qty;
	}

	public float getPrice() { return price; }

	public Product getProduct() { return product; }
}