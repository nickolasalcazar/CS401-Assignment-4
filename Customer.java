public class Customer {
	private String id;
	private String address;
	private String phone;
	private String email;

	private WebUser webUser = null;
	private Account account;

	public Customer(String id, String address, String phone, String email) {
		this.id = id;
		this.address = address;
		this.phone = phone;
		this.email = email;
		account = new Account(id, address);
	}

	public String getId() { return id; }

	public String getAddress() { return address; }

	public String getPhone() { return phone; }

	public String getEmail() { return email; }

	public Account getAccount() { return account; }

	/**
	 * Creates a WebUser if one has not already been created and assigns it to
	 * this Customer.
	 * 
	 * @param password	Password of WebUser.
	 */
	public void makeWebUser(String password) {
		if (webUser != null) webUser = new WebUser(email, password);
	}

	/**
	 * Returns a String listing the contents of Product in the format:
	 * "id, address, phone, email".
	 */
	public String toString() {
		return id + ", " + address + ", " + phone + ", " + email;
	}
}