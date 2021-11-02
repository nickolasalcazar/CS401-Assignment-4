/**
 * WebUser represents the online web account of a Customer. A Customer may or
 * may not be assoicated with a WebUser. WebUser is created created and managed
 * by Customer. Only one WebUser may be assigned to a Customer.
 */
public class WebUser {
	private String login_id; // email
	private String password;
	private UserState userState = UserState.NEW;

	/**
	 * Class constructor for WebUser. UserState is set to NEW by default.
	 */
	public WebUser(String login_id, String password) {
		this.login_id = login_id;
		this.password = password;
	}

	public String getLoginId() { return login_id; }

	public UserState getUserState() { return userState; }

	public void setUserState(UserState userState) { this.userState = userState; }

	/**
	 * Returns a String listing the contents of WebUser in the format:
	 * "login_id, password, userState".
	 */
	public String toString() {
		return login_id + ", " + password + ", " + userState;
	}
}