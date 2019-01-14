package lab06;

public class BankAccount {
	private double balance;
	private int idNum;
	private static int numAccounts = 0;
	
	public BankAccount(double balance1) {
		if(balance1 < 0) {
			throw new IllegalArgumentException("Bad Input");
		}
		balance = balance1;
		numAccounts = idNum;
		numAccounts++;
	}
	public double getBalance() {return balance;}
	public int getIDNum() {return idNum;}
	
	static void reset() {
		numAccounts = 0;
	}
	@Override
	public String toString() {
		return "Acct. #" + idNum + " has $" + balance + ".";	
	}
	public void deposit(double amount) {
		if(amount < 0)
			throw new IllegalArgumentException("Deposit amount must be positive");
		balance += amount;
	}
	public double withdraw(double amount) {
		if(amount < 0)
			throw new IllegalArgumentException("Withdraw amount must be positive");
		if(balance >= amount) {
			balance -= amount;
			return amount;
		}
		else {
			double retAmt = balance;
			balance = 0;
			return retAmt;
		}
	}
	
}
