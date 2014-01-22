package Data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class UserProfile {
	private List<Account> accounts;
	private File saveLocation;
	
	/**
	 * creates a new UserProfile initializing accounts array and the default save location
	 */
	public UserProfile () {
		accounts = new ArrayList<Account>();
		saveLocation = new File("savedProfile.csv");
	}
	
	/**
	 * Creates a new User Profile initializing accounts array, and a save location
	 * 
	 * @param File f
	 */
	public UserProfile (File save) {
		accounts = new ArrayList<Account>();
		saveLocation = save;
	}
	
	public void load() {
		Scanner fileSave;
		try {
			fileSave = new Scanner(saveLocation);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
			fileSave = null;
		}
		fileSave.useDelimiter(",");
		
		String accountType = "";
		String accountName = "";
		double accountBalance = 0;
		
		while (fileSave.hasNext()) {
			try {
				accountType = fileSave.next().toUpperCase();
				accountName = fileSave.next();
				accountBalance = fileSave.nextDouble();
				
				addAccount(accountType, accountName, accountBalance);
			}
			catch (Exception e) {
				break;
			}
			fileSave.nextLine();
		}
		fileSave.close();
	}
	
	public void save() throws IOException {
		PrintWriter writeSave = new PrintWriter (saveLocation);
		for (int i = 0; i < accounts.size(); i ++) {
			writeSave.println(accounts.get(i).toSave());
		}
		writeSave.close();
	}

	public void addAccount(String accountType, String accountName, double accountBalance) {
		ACCOUNTTYPE type = ACCOUNTTYPE.valueOf(accountType.toUpperCase());
		switch (type) {
		
			case C: {
				Account checking = new CheckingAccount(accountName, accountBalance);
				accounts.add(checking);
				break;
			}
			
			case S: {
				Account savings = new SavingsAccount(accountName, accountBalance);
				accounts.add(savings);
				break;
			}
		
			case W: {
				Account wallet = new Wallet(accountName, accountBalance);
				accounts.add(wallet);
				break;
			}
			
			case O: {
				Account folder = new OtherAccount(accountName, accountBalance);
				accounts.add(folder);
			}
			
		}
	}
	
	public void addAccount(String accountType, String accountName) {
		addAccount(accountType, accountName, 0);
	}
	
	public String toString() {
		String profileDisplay = "";
		profileDisplay+= String.format("%20s%n%n", "Accounts");
		for (int i = 0; i < accounts.size(); i++) {
			profileDisplay+= String.format("%-30s%-1s%1d%-1s%n", accounts.get(i), "[" , i , "]");
		}
		return profileDisplay;
	}
	
	public Account getAccount(int n) {
		for (int i = 0; i < accounts.size(); i ++) {
			if ( n== i) 
				return accounts.get(i);
		}
		return null;
	}
}
