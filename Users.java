package bank2;

/*
 * Updated approach on the banking program, this time using an ArrayList 
 * instead of an array, allowing for many operations and unlimited space. 
 * This class is responsible for declaring the many functions used in this program, related to users
 */

import java.util.ArrayList;

public class Users {

	// declaration of the arrayList
	private ArrayList<User> users = new ArrayList<User>();
	
	// getters and setters
	public ArrayList<User> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}

	// functions related to the users list are created
	// the first function checks if the user exists, if it does, it returns true
	public boolean checkUserExists (String name) {
		for (User u : users) {
			if (users.get(users.indexOf(u)).getName().equals(name)) {
				return true;
			}
		}
		return false;
	}
	
	// function to check the user, it checks if the user exists (when it returns true, it prints a message)
	// if so, it returns true if the user doesn't exist, it could check if the string is empty, 
	// if so, it would return true, but this is not necessary for the application because of the askForString function
	// since this is used in two cases on the program, this function becomes necessary
	public boolean checkUser(String name) {
		if (checkUserExists (name)) {
			System.out.println("User already exists");
			return true;
		}
//			else if (name.isEmpty() || name.equals("") || name.length() == 0){
//			System.out.println("User name is empty, try again");
//			return true;
//		}
		return false;
	}

	// function to add a user, if the check user (checks if it exists) returns true, it returns nothing
	// if the check user returns false, it creates a new user, adds the user to the list and prints "Done"
	public void addUser(String name) {
		if (checkUser(name)) {
			return;
		} else {
			User user = new User(name);
			users.add(user);
			System.out.println("Done!");
		}
	}
	// return users.get(users.indexOf(user));

	// function to edit users, not used in this program
	public void editUsers(String name, String new_name) {
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getName().equals(name)) {
				users.get(i).setName(new_name);
			}
		}
	}
	
	// function to list users, using a for each. If there is no users, prints "no users"
	public void listUsers() {
		if (users.isEmpty()) {
			System.out.println (" No users");
		}
		for (User u : users) {
			System.out.println(" "+u.getName());
		}
	}

	// function to find a user, using a simple for, if the user name is equal to the inputed string, it returns that user
	public User findUser(String name) {
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getName().equals(name)) {
				return users.get(i);
			}
		}
		return null;
	}

	// function to remove a user, using a simple for, if the user name is equal to the inputed string, it removes that user
	public void removeUser(String name) {
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getName().equals(name)) {
				users.remove(users.get(i));
			}
		}
	}
}
