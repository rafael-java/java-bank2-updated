package bank2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/*
 * Updated approach on the banking program, this time using an ArrayList 
 * instead of an array, allowing for many operations and unlimited space. 
 */

public class MainBank2 {

	public static void main(String[] args) {

		// declarations
		AccountUtility util1 = new AccountUtility();
		Scanner scan = new Scanner(System.in);
		Users users = new Users();

		// main menu and menu1 text
		System.out.println("Welcome to the Bank Program");
		System.out.println("Type 1 for inputs (add and remove), 2 for operations (deposit etc), 3 to exist");
		Integer number = scan.nextInt();

		// a while (true) [loop1] so it checks twice for the number typed, if there
		// wasn't this, it would check for the number only once and then go back to the
		// menu
		while (true) {

			// if the number is 1, it enter the inputs menu and it enters loop2:
			while (number == 1) {
				// this loop needs a new number, so it is declared
				Integer new_number = 0;
				// and a new menu [menu2] appears, with some options for input operations
				System.out.println(
						"Type 1 to add a user, 2 to remove a user, 3 to add accounts, \n 4 to list accounts and users, 5 to remove an account, 6 to go back to the menu");
				// the inputed number is the new number
				new_number = scan.nextInt();

				// if the new number is 6, it breaks out of loop2 and returns to the loop1
				if (new_number == 6) {
					// shows the menu1 text
					System.out.println("Type 1 for more inputs, 2 for operations, 3 to exit");
					// sets the number, not the new_number
					number = scan.nextInt();
					break;
				}
				// if the new number is not 6, it enters loop3
				while (new_number != 6) {

					// while the new_number is 1, it adds a user
					while (new_number == 1) {
						// asking for the name
						System.out.println("Type a name for the user");
						// there is a function that asks for a string, checks if it's not empty and
						// returns that string
						String userName = util1.askForString();
						// function to add user
						users.addUser(userName);
						// returns to the menu2 text
						System.out.println(
								"Type 1 to add a user, 2 to remove a user, 3 to add accounts, \n 4 to list accounts and users, 5 to remove an account, 6 to go back to the menu");
						new_number = scan.nextInt();
					}

					// while the new_number is 2, it removes a user
					while (new_number == 2) {
						// Function that asks for a string, checks if it's not empty and
						// returns that string
						System.out.println("Type a name for the user");
						String userName = util1.askForString();
						// if the checkUserExists function returns true, it removes user
						// if the user doesn't exist, it shows a message "user doesn't exist"
						if (!users.checkUserExists(userName)) {
							System.out.println("User does not exist, please add a user first");
						} else {
							users.removeUser(userName);
						}
						// returns to the menu2 text
						System.out.println(
								"Type 1 to add a user, 2 to remove a user, 3 to add accounts, \n 4 to list accounts and users, 5 to remove an account, 6 to go back to the menu");
						new_number = scan.nextInt();
					}

					// while the new_number is 3, it adds an account
					while (new_number == 3) {
						// ask for string function for the number (which is a string because it can
						// contain letters)
						System.out.println("Type a number for the account");
						String accNumber = util1.askForString();
						// the first double to be typed will correspond to the amount for the balance
						System.out.println("Type an amount for the balance");
						Double accBalance = scan.nextDouble();
						// ask for string function for the owner's name
						System.out.println("Type a name for the owner");
						String accOwner = util1.askForString();

						// if the checkUserExists function returns true, it adds the account
						// using the find user function, which adds the user to the users list and
						// returns the user if that user exists
						// if the user doesn't exist, it shows a message "user doesn't exist"
						if (!users.checkUserExists(accOwner)) {
							System.out.println("User doesn't exist, please add a user first");
						} else {
							util1.addAccount(accNumber, accBalance, users.findUser(accOwner));
						}
						// returns to the menu2 text
						System.out.println(
								"Type 1 to add a user, 2 to remove a user, 3 to add accounts, \n 4 to list accounts and users, 5 to remove an account, 6 to go back to the menu");
						new_number = scan.nextInt();
					}

					// while the new_number is 4, it lists the accounts and the users
					while (new_number == 4) {
						System.out.println("List of accounts: ");
						util1.listAccounts();
						System.out.println("- - - - - - - - - - - - - - - - - - - - - - ");
						System.out.println("List of users: ");
						users.listUsers();
						// returns to the menu2 text
						System.out.println(
								"Type 1 to add a user, 2 to remove a user, 3 to add accounts, \n 4 to list accounts and users, 5 to remove an account, 6 to go back to the menu");
						new_number = scan.nextInt();
					}

					// while the new_number is 5, it removes an account
					while (new_number == 5) {
						// ask for string for the number of the account
						System.out.println("Type a number for the account");
						String accNumber = util1.askForString();

						// function to remove the account
						util1.removeAccount(accNumber);
						// returns to the menu2 text
						System.out.println(
								"Type 1 to add a user, 2 to remove a user, 3 to add accounts, \n 4 to list accounts and users, 5 to remove an account, 6 to go back to the menu");
						new_number = scan.nextInt();
					}

					// if the new_number is greater than 6 or less than 1, it shows the invalid
					// number message and asks for a new number
					while (new_number > 6 || new_number < 1) {
						System.out.println("Invalid number");
						// returns to the menu2 text
						System.out.println(
								"Type 1 to add a user, 2 to remove a user, 3 to add accounts, \n 4 to list accounts and users, 5 to remove an account, 6 to go back to the menu");
						new_number = scan.nextInt();
					}
					
					// this is necessary while inside the loop, otherwise it would show the menu2 message again 
					// if the new number is 6, it breaks out of loop2 and returns to the loop1
					if (new_number == 6) {
						// shows the menu1 text
						System.out.println("Type 1 for more inputs, 2 for operations, 3 to exit");
						// sets the number, not the new_number
						number = scan.nextInt();
						break;
					}
				} // end of loop3
			} // end of loop2

			// if the number is 2, it enter the operations menu and it enters this loop
			// [loop4]
			while (number == 2) {

				// another new number is required, so it is declared here
				Integer new_number = 0;
				// menu3 text, for the operations
				System.out.println(
						"Type 1 to deposit, 2 to withdraw, 3 to transfer, \n 4 to add balances for the same owner, 5 to list accounts, 6 to go back to the menu");
				new_number = scan.nextInt();

				// if the new number is 6, it breaks out of the loop4 and returns to loop1
				if (new_number == 6) {
					// shows the menu1 text
					System.out.println("Type 1 for inputs, 2 for more operations, 3 to exit program");
					// sets the number, not the new_number
					number = scan.nextInt();
					break;
				}

				// if the new number is not 6, it enters loop5
				while (new_number != 6) {

					// while new_number is 1, it deposits
					while (new_number == 1) {

						// asks for a string for the number
						System.out.println("Type a number for the account");
						String accNumber = util1.askForString();

						// the first double will be the value to deposit
						System.out.println("Type a value to deposit");
						Double value = scan.nextDouble();

						// function to deposit
						util1.depositSuper(accNumber, value);

						// menu3 text
						System.out.println(
								"Type 1 to deposit, 2 to withdraw, 3 to transfer, \n 4 to add balances for the same owner, 5 to list accounts, 6 to go back to the menu");
						new_number = scan.nextInt();
					}

					// while the new_number is 2, it withdraws
					while (new_number == 2) {
						// asks for a string for the number of the account
						System.out.println("Type a number for the account");
						String accNumber = util1.askForString();
						// next double will be the value to withdraw
						System.out.println("Type a value to withdraw");
						Double value = scan.nextDouble();
						// function to withdraw
						util1.withdrawSuper(accNumber, value);
						// menu3 text
						System.out.println(
								"Type 1 to deposit, 2 to withdraw, 3 to transfer, \n 4 to add balances for the same owner, 5 to list accounts, 6 to go back to the menu");
						new_number = scan.nextInt();
					}
					// while the new_number is 3, it transfers
					while (new_number == 3) {
						// ask for a string for the number of the account to deposit
						System.out.println("Type a number for the account to withdraw");
						String accNumber1 = util1.askForString();
						// ask for a string for the number of the account to withdraw
						System.out.println("Type a number for the account to deposit");
						String accNumber2 = util1.askForString();
						// next double will be the value to transfer
						System.out.println("Type a value to transfer");
						Double value = scan.nextDouble();

						// function to transfer
						util1.transferSuper(accNumber1, accNumber2, value);
						// menu3 text
						System.out.println(
								"Type 1 to deposit, 2 to withdraw, 3 to transfer, \n 4 to add balances for the same owner, 5 to list accounts, 6 to go back to the menu");
						new_number = scan.nextInt();
					}

					// while the new_number is 4, it adds balances for the same owner
					while (new_number == 4) {
						System.out.println("Type a name for the accounts owner to add balances");
						String userName = util1.askForString();
						// function to add balances
						util1.addBalancesSuper(userName);
						// menu3 text
						System.out.println(
								"Type 1 to deposit, 2 to withdraw, 3 to transfer, \n 4 to add balances for the same owner, 5 to list accounts, 6 to go back to the menu");
						new_number = scan.nextInt();
					}
					// while the new_number is 5, it lists the accounts
					while (new_number == 5) {
						// function to list accounts
						util1.listAccounts();
						// menu3 text
						System.out.println(
								"Type 1 to deposit, 2 to withdraw, 3 to transfer, \n 4 to add balances for the same owner, 5 to list accounts, 6 to go back to the menu");
						new_number = scan.nextInt();
					}
					// this is necessary while inside the loop, otherwise it would show the menu3 message again 
					// if the new number is 6. It breaks out of the loop4 and returns to loop1
					if (new_number == 6) {
						// shows the menu1 text
						System.out.println("Type 1 for inputs, 2 for more operations, 3 to exit program");
						// sets the number, not the new_number
						number = scan.nextInt();
						break;
					}

				} // end of loop5
			} // end of loop4
				// for the loop2, if the number is 3, it breaks out of the loop.
			if (number == 3) {
				break;
			}
		} // end of loop1
	}
}