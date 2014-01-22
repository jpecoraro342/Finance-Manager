package Data;

public class Wallet extends CheckingAccount {

	public Wallet(String n, double b) {
		super(n, b);
	}
	
	public ACCOUNTTYPE getAccountType() {
		return ACCOUNTTYPE.valueOf("W");
	}

	public String toString() {
		return String.format("%-20s%6.2f%-4s", getAccountName() + ":", getAccountBalance(), "");
	}

	public String toSave() {
		return "W,"+getAccountName()+","+getAccountBalance()+",";
	}

}
