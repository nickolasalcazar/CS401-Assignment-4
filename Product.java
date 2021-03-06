/**
 * Product represents a kind of product. Product represents the id, name, and
 * supplier as Strings. Product does not record price or quantity purchased.
 */
public class Product {
	private String id;
	private String name;
	private String supplier;

	/**
	 * Constructor for Product class.
	 * 
	 * @param name		Name of product.
	 * @param id		ID of product.
	 * @param supplier	Name of supplier.
	 */
	public Product(String name, String id, String supplier) {
		this.name = name;
		this.id = id;
		this.supplier = supplier;
	}

	public String getId() { return id; }

	public String getName() { return name; }

	public String supplier() { return supplier; }

	/**
	 * Returns true if product is equal to the this.product,
	 * false if otherwise. Checks equality by comparing the id of the
	 * two Product objects.
	 * 
	 * @param	product	The other product being compared for equality.
	 * @return			Boolean value representing the equality between
	 * 					product and this.product.
	 */
	public boolean equals(Product product) {
		return this.id == product.getId();
	}

	/**
	 * Returns a String listing the contents of Product in the format:
	 * "name, id, supplier".
	 */
	public String toString() { return name + ", " + id + ", " + supplier; }
}