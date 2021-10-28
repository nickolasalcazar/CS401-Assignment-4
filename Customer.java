public class Customer {
	private int id;
	private String address;
	private String phone;
	private String email;

	// private WebUser webUser;
	// private Account account; // Created in constructor

	public Customer(int id, String address, String phone, String email) {
		this.id = id;
		this.address = address;
		this.phone = phone;
		this.email = email;
		// account = new Account(/* paremeters */);
	}

	public int getId() { return id; }

	public String getAddress() { return address; }

	public String getPhone() { return phone; }

	public String getEmail() { return email; }
}