package bank2;

/*
 * Updated approach on the banking program, this time using an ArrayList 
 * instead of an array, allowing for many operations and unlimited space. 
 * This class declares the user 
 */

public class User {

	// the only attribute is the name
	private String name;

	// constructors
	public User () {
		
	}
	
	public User(String name) {
		this.name = name;
	}

	// getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
