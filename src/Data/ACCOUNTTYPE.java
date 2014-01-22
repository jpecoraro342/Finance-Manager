package Data;

public enum ACCOUNTTYPE {
	
	C ("CheckingAccount"),
	S ("SavingsAccount"),
	W ("Wallet"),
	O ("OtherAccount");
	
	String type;
	
	ACCOUNTTYPE (String t) {
		type = t;
	}
}
