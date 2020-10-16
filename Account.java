package bank2;

import java.util.concurrent.atomic.AtomicInteger;

/*
 * Updated approach on the banking program, this time using an ArrayList 
 * instead of an array, allowing for many operations and unlimited space. 
 * This class declares the account 
 */

public class Account {

	// declarations of attributes
	private String number;
	// this is not used, but there is an Id
    private static int counter = 0;
    public final int objectId;
	private Double balance;
	private User user;
	
	// this is not used, the Id is set when the account is created
	public Account() {
        this.objectId = counter;
        this.counter++;
	}

	// constructor for the account
	public Account(String number, Double balance, User user) {
		this();
		this.number = number;
		this.balance = balance;
		this.user = user;
	}

	// getters and setters
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	// no setter for the ID, because it is set when the account is created
	public int getObjectId() {
		return objectId;
	}

//	public void deposit (Float value) {
//		this.balance = this.balance + value;
//	}
//
//	public void debit (Float value) {
//		this.balance = this.balance - value;
//	}

}
