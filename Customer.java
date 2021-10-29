public class Customer {
	private String id;
	private String address;
	private String phone;
	private String email;

	// private WebUser webUser; // Optional
	private Account account; // Created in constructor

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
	
}