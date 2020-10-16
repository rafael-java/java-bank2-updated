package bank2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Map.Entry;

/*
 * Updated approach on the banking program, this time using an ArrayList 
 * instead of an array, allowing for many functions and unlimited space. 
 * This class is responsible for declaring the many functions used in this program, related to accounts
 */

public class AccountUtility {

	// declarations
	private List<Account> accounts = new ArrayList<Account>();
	Scanner scan = new Scanner(System.in);
	private Users users = new Users();
	private Struct struct = new Struct();

	// in this program, the following operations, related to users, are declared in
	// the users class
	/*
	 * public boolean findUser(String name) { for (User user : users.getUsers()) {
	 * if (user.getName().equals(name)) { return true; } } return false; }
	 * 
	 * public void removeUser(String name) { if (findUser(name)) {
	 * users.removeUser(name); } }
	 * 
	 * public void listUser() { users.listUsers(); }
	 */

	// the findAccount function checks if there is an account with the same number
	// as the
	// one passed (which is a string, because there could be letters), if there is,
	// it returns
	// true, if there isn't it returns false
	public boolean findAccount(String number) {
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).getNumber().equals(number)) {
				return true;
			}
		}
		return false;
	}

	// the add account function checks if there is an account existing (using
	// the findAccount function), if it doesn't, it adds the account to the accounts
	// list
	public void addAccount(String number, Double balance, User u) {
		if (findAccount(number)) {
			System.out.println(" Account number already exists ");
		} else {
			Account acc = new Account(number, balance, u);
			accounts.add(acc);
		}
	}

	// the listAccount function uses a foreach stream function to print all the
	// information
	// for the accounts. If there is no accounts, prints "no accounts"
	public void listAccounts() {
		if (accounts.isEmpty()) {
			System.out.println(" No accounts");
		}
		accounts.stream().forEach((Account acc) -> System.out.println(" Account " + acc.getNumber() + " Account owner: "
				+ acc.getUser().getName() + " // Account balance: " + acc.getBalance()));
	}

	// the editAccount, which is not used in this program, asks for a number a new
	// number,
	// the first one is checked against the other numbers in the account list using
	// a simple for,
	// and if there is a match, it sets the number to the new number
	public void editAccount(String number, String new_number) {
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).getNumber().equals(number)) {
				accounts.get(i).setNumber(new_number);
			}
		}
	}

	// the removeAccount uses an iterator to check all the accounts, it is not
	// possible to use a
	// for or a for each here because it raises an error. if the number is found, it
	// removes the
	// account from the accounts list
	public void removeAccount(String number) {

		Iterator<Account> iterator = accounts.iterator();
		while (iterator.hasNext()) {
			Account acc = iterator.next();
			if (acc.getNumber().equals(number)) {
				accounts.remove(acc);
			}
		}
	}

	// the showBalance function is not used in this program. It checks if the
	// account exists, if so
	// it finds the number and shows the balance for that account. if not, a message
	// is shown saying that
	// it does not exist
	public void showBalance(String number) {

		if (findAccount(number)) {
			for (Account acc : accounts) {
				if (acc.getNumber().equals(number)) {
					System.out.println("Balance for account number \"" + number + "\":" + acc.getBalance());
				}
			}
		} else {
			System.out.println(" There is no account with number " + number);

		}
	}

	// the addBalances is a new function implemented in this program, it adds the
	// balances for all
	// accounts which have the same owner name, using an iterator. For this to work,
	// there is
	// the need for a double attribute called sum. if there isn't any accounts on
	// the list, it
	// presents a text. Since there cannot be three returns in a function, a class
	// Struct is used,
	// similar to the struct in C++. This function sets the three attributes on the
	// Struct class, one
	// for value (sum) and one for a boolean that returns true if the account
	// exists, and
	// false if the account
	// doesn't exist or the user doesn't exist. This is necessary because if there
	// was just an else
	// clause with a message saying "user not found", it would repeat the message
	// for the amount of times
	// that there is an account. Another attribute is "message" to differ what is an
	// error caused by
	// no user or no account. Another approach would be throwing an error, but that
	// would end the program
	// which is not desired.
	public Struct addBalances(String name) {
		Double sum = 0.0;

		Iterator iterator = accounts.iterator();
		if (iterator.hasNext()) {
			while (iterator.hasNext()) {
				Account acc = (Account) iterator.next();
				if (acc.getUser().getName().equals(name)) {
					struct.setValue(sum += acc.getBalance());
					struct.setBool(true);
				} else {
					struct.setMessage("No user found");
					struct.setBool(false);
				}
			}
		} else {
			struct.setMessage("No account found");
			struct.setBool(false);
		}
		return struct;

//
//		for (Account acc : accounts) {
//			if (acc != null && name.equals(acc.getUser().getName())) {
//				sum += acc.getBalance();
//			} else if (accounts.isEmpty()) {
//			}
//		}
	}

	// function addBalancesSuper is responsible for getting the struct returned by
	// the addbalances function
	// and, if the attribute bool is true, it prints the value (sum), if it's false,
	// it
	// prints the message corresponding
	// to no user or no account found.
	public void addBalancesSuper(String name) {
		struct = this.addBalances(name);
		if (struct.getBool()) {
			System.out.println("Total balance for \"" + name + "\": " + struct.getValue());
		} else {
			System.out.println(struct.getMessage());
		}
	}

	// this function is an auxiliary for the deposit. Using a simple for, it goes
	// through the accounts and if the
	// account is the same as the number inputed, the balance is set to the value +
	// balance and returns true.
	// if the account doesn't exist or there is no accounts, it returns false

	public Boolean deposit(String number, Double value) {
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).getNumber().equals(number)) {
				accounts.get(i).setBalance(accounts.get(i).getBalance() + value);
				return true;
			}
		}
		return false;
	}

	// this is the "super" deposit function, if deposit returns true, it prints
	// done, if it returns false,
	// because there are no accounts or because the account doesn't exist, it prints
	// an error
	public void depositSuper(String number, Double value) {
		if (deposit(number, value)) {
			System.out.println("Done depositing!");
		} else {
			System.out.println("error, check the accounts");
		}
	}

	// same as before, this function is an auxiliary for the withdraw. Using an
	// iterator, it goes
	// through the accounts and if the account is the same as the number inputed,
	// the balance is checked, while the amount of the (balance - value) is below 0,
	// this means that the value cannot be withdrawn and asks for a new value. while
	// the amount of the
	// balance - value is above or equal to 0, it withdraws the value, sets a new
	// balance, and returns true
	// if the account doesn't exist or there is no accounts, it returns false.
	// since withdrawing needs two returns, another time the struct class is used,
	// one attribute to capture the boolean that is used in the super class and
	// another to capture the value that is used in the transfer class
	public Struct withdraw(String number, Double value) {

		Struct struct = new Struct();
		Iterator iterator = accounts.iterator();
		if (iterator.hasNext()) {
			while (iterator.hasNext()) {
				Account account = (Account) iterator.next();
				if (number.equals(account.getNumber())) {
					while ((account.getBalance() - value) < 0) {
						System.out.println("Invalid value. \n Type an amount to withdrawl");
						value = scan.nextDouble();
					}
					while ((account.getBalance() - value) >= 0) {
						account.setBalance(account.getBalance() - value);
						struct.setBool(true);
						struct.setValue(value);
						return struct;
					}
				}
			}
		}
		struct.setBool(false);
		return struct;
	}

	// same as before, this is the "super" withdraw function, if withdraw's struct
	// returns
	// true, it prints done, if it returns false,
	// because there are no accounts or because the account doesn't exist, it prints
	// an error
	public void withdrawSuper(String number, Double value) {
		if (withdraw(number, value).getBool()) {
			System.out.println("Done withdrawing!");
		} else {
			System.out.println("error, check the accounts");
		}
	}

	// this new function is responsible for transferring amounts between accounts
	// (number1 to number2), it uses the normal deposit and withdraw functions so
	// the message "done" doesn't appear several times. It uses an iterator.
	// the function is divided in three steps, the first step is the withdrawing,
	// because the withdraw function is complex, the value is got from the withdraw
	// function's struct and returned for the second step
	public Double transfer_withdraw(String number1, Double value) {
		Iterator iterator = accounts.iterator();
		if (iterator.hasNext()) {
			while (iterator.hasNext()) {
				Account acc = (Account) iterator.next();
				if (acc.getNumber().equals(number1)) {
					Double new_value = this.withdraw(acc.getNumber(), value).getValue();
					return new_value;
				}
			}
		}
		return null;
	}

	// the second step in transferring is the deposit, this time it is simpler, it
	// just gets the new value from the withdraw (in case the value is not possible
	// to be withdrawn), then it deposits that new_value into the account with
	// number2.
	// it also uses an iterator to iterate through the list
	public Boolean transfer_deposit(String number1, String number2, Double value) {
		Iterator iterator = accounts.iterator();
		Double new_value = transfer_withdraw(number1, value);
		if (iterator.hasNext()) {
			while (iterator.hasNext()) {
				Account acc = (Account) iterator.next();
				if (acc.getNumber().equals(number2)) {
					this.deposit(acc.getNumber(), new_value);
					return true;
				}
			}
		}
		return false;
	}

	// the last step, which is referenced in the main class, is to get a message
	// saying done or error
	public void transferSuper(String number1, String number2, Double value) {
		if (transfer_deposit(number1, number2, value)) {
			System.out.println("Done!");
		} else {
			System.out.println("error, check the accounts");
		}
	}

	// the last function is a special function that asks for a string, if the string
	// is empty, it asks for a new string, if it is not empty, it returns the
	// string. This is used every time a string is required from the user
	public String askForString() {
		String string = scan.nextLine();
		while (string.isEmpty()) {
			System.out.println("You didn't type anything, please try again now");
			string = scan.nextLine();
		}
		return string;
	}
}
