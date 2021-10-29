enum UserState { New, Active, Blocked, Banned }

/**
 * WebUser represents the online web account of a Customer. A Customer may or
 * may not have an assoicated WebUser. WebUser is created created and managed
 * by Customer.
 */
public class WebUser {
	private String login_id;
	private String password;
	private UserState userState;

	/**
	 * Class constructor for WebUser.
	 */
	public WebUser(String login_id, String password, UserState userState) {
		this.login_id = login_id;
		this.password = password;
		this.userState = userState;
	}

	public String getLoginId() { return login_id; }

	public UserState getUserState() { return userState; }

	public void setUserState(UserState userState) { this.userState = userState; }
}