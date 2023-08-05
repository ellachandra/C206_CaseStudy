/**
 * 
 */

/**
 *
 *
 */

//edited by ella add contact number
public class User {
	private String userId;
	private String password;
    private String name;
    private int number;
    private String email;
   
	
    public User(String userId, String password, String name, int number, String email) {
		
		this.userId = userId;
		this.password = password;
		this.name = name;
		this.number = number;
		this.email = email;
	}

    
    //getter methods
	public String getUserId() {
		return userId;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public int getNumber() {
		return number;
	}
	public String getPassword() {
		return password;
	}

	

}
