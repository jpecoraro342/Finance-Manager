package Application;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import Data.CheckingAccount;
import Data.UserProfile;

public class Console {
	
	private static Scanner input;
	private static Scanner menu = new Scanner(System.in);
	private static Data.UserProfile profile;
	private static String menuSelection;
	

	public static void startProgram() throws FileNotFoundException {
		input = new Scanner (System.in);
		
		System.out.printf("%-12s%-4s%n", "Load Save", "[L]");
		System.out.printf("%-12s%-4s%n%n", "Start New", "[N]");
		
		String menuSelection = input.next();
		if (menuSelection.equalsIgnoreCase("l")) {
			loadProfile();
		}
		else if (menuSelection.equalsIgnoreCase("n")) {
			newProfile();
		}
	}

	private static void newProfile() {
		profile = new UserProfile();
		runProfileManager();
	}
	
	private static void runProfileManager() {
		System.out.println(profile);
		char selection = mainMenuOptions();
		if (selection == Character.UNASSIGNED) {
			int n = Integer.parseInt(menuSelection);
			Data.Account acc = profile.getAccount(n);
			accountOptions(acc);
		}
		else {
			switch (selection) {
				case 'N': {
					getNewAccountInfo();
					break;
				}
				case 'S': {
					try {
						profile.save();
					} catch (IOException e) {
						System.err.println(e.getMessage());
					}
					break;
				}
				case 'L': {
					break;
				}
				case 'Q': {
					System.exit(0);
				}
			}
		}
		
		runProfileManager();
	}

	private static void getNewAccountInfo() {
		String t = askAccountType();
		String n = askName();
		double b = askStartingBalance(n);
		profile.addAccount(t,n,b);
	}
	
	private static String askAccountType() {
		System.out.println("\nPlease Choose The Type of Account You Would Like to Add");
		System.out.println("Checking Account [C]");
		System.out.println("Savings Account [S]");
		System.out.println("Wallet [W]");
		System.out.println("Other [O]\n");
		String t = input.next();
		return t;
	}
	
	private static String askName() {
		System.out.println("What would you like to title this Account?");
		String n = input.next();
		n += input.nextLine();
		return n;
	}

	private static double askStartingBalance(String n) {
		System.out.println("What is the starting balance of " + n + "?");
		double balance = input.nextDouble();
		return balance;
	}
	
	private static void accountOptions(Data.Account a) {
		switch (a.getAccountType()) {
			case C: {
				System.out.println(a + "\n");
				System.out.print("Withdraw [W]\n" + "Deposit [D]\n" + "Debit Card [C]\n" );
				
				break;
			}
			case S: {
				System.out.println(a + "\n");
				System.out.print("Withdraw [W]\n" + "Deposit [D]\n" );
				
				break;
			}
			case W: {
				System.out.println(a + "\n");
				System.out.print("Withdraw [W]\n" + "Deposit [D]\n" + "Purchase [P]\n" );
				
				break;
			}
			case O: {
				System.out.println(a + "\n");
				System.out.print("Withdraw [W]\n" + "Deposit [D]\n" );
				
			}
		}
		
		String t = input.next();
		char[] tr = t.toUpperCase().toCharArray();
		double amount;
		switch (tr[0]) {
			case 'W': {
				System.out.println("How much would you like to withdraw?");
				amount = input.nextDouble();
				a.withdraw(amount);
				break;
			}
			case 'D': {
				System.out.println("How much would you like to deposit?");
				amount = input.nextDouble();
				a.deposit(amount);
				break;
			}
			case 'C': {
				System.out.println("How much is the item you would like to use your debit card for?");
				amount = input.nextDouble();
				CheckingAccount c = (Data.CheckingAccount) a;
				c.debit(amount);
				break;
			}
			case 'P': {
				System.out.println("How much is the item you would like to purchase?");
				amount = input.nextDouble();
				CheckingAccount c = (Data.CheckingAccount) a;
				c.debit(amount);
			}
		}
	}

	private static char mainMenuOptions() {
		System.out.printf("%-17s%-10s%-10s%-10s%n%n", "New Account [N]", "Save [S]", "Load [L]", "Quit [Q]");
		menuSelection = menu.next();
		try {
			Integer.parseInt(menuSelection);
			return Character.UNASSIGNED;
		}
		catch (Exception e) {
		}
		char[] select = menuSelection.toUpperCase().toCharArray();
		return select[0];
	}

	private static void loadProfile() throws FileNotFoundException {
		profile = new UserProfile();
		profile.load();
		runProfileManager();
	}
}
