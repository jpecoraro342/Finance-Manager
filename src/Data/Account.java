package Data;

public interface Account {
	void withdraw (double a);
	
	void deposit (double a);
	
	double getAccountBalance();
	
	void setAccountBalance(double b);
	
	ACCOUNTTYPE getAccountType();
	
	String getAccountName();
	
	String toString();
	
	String toSave();
}
