package bank2;

// Since there cannot be three returns in a function, a class Struct is used,
// similar to the struct in C++.

public class Struct {

	// declarations
	Double value;
	Boolean bool;
	String message;
	
	//constructor
	public Struct () {
	}
	
	// getters and setters
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Double getValue() {
		return value;
	}
	public void setValue(Double value) {
		this.value = value;
	}
	public Boolean getBool() {
		return bool;
	}
	public void setBool(Boolean bool) {
		this.bool = bool;
	}
	
	
}
