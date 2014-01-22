package Data;


public class SavingsAccount implements Account {

	private String accountName;
	private double accountBalance; 
	
	public SavingsAccount(String n, double b) {
		accountName = n;
		accountBalance = b;
		// TODO Auto-generated constructor stub
	}
	
	public String getAccountName() {
		return accountName;
	}
	
	public double getAccountBalance() {
		return accountBalance;
	}
	
	public void setAccountBalance(double b) {
		accountBalance = b;
	}

	public void withdraw(double a) {
		accountBalance -= a;
	}

	public void deposit(double a) {
		accountBalance += a;
	}

	public String toString() {
		return String.format("%-20s%6.2f%-4s", getAccountName() + ":", getAccountBalance(), "");
	}

	public String toSave() {
		return "S,"+getAccountName()+","+getAccountBalance()+",";
	}

	public ACCOUNTTYPE getAccountType() {
		return ACCOUNTTYPE.valueOf("S");
	}

}
