package Data;

public class OtherAccount extends SavingsAccount {

	public OtherAccount(String n, double b) {
		super(n, b);
	}
	
	public ACCOUNTTYPE getAccountType() {
		return ACCOUNTTYPE.valueOf("O");
	}

	public String toString() {
		return String.format("%-20s%6.2f%-4s", getAccountName() + ":", getAccountBalance(), "");
	}

	public String toSave() {
		return "O,"+getAccountName()+","+getAccountBalance()+",";
	}


}
