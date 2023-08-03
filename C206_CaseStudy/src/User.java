/**
 * 
 */

/**
 * @author jiaan
 *
 */
public class User {
	private String userId;
    private String name;
    private String email;
    private String password;
	
    public User(String userId, String password, String name, String email) {
		
		this.userId = userId;
		this.password = password;
		this.name = name;
		this.email = email;
	}

	public String getUserId() {
		return userId;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}

}
