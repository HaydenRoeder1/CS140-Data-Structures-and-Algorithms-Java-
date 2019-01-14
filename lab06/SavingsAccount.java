package lab06;

public class SavingsAccount extends BankAccount {
	private double rate;
	public SavingsAccount(double balance, double rate1) {
		super(balance);
		if(rate1 < 0) {
			throw new IllegalArgumentException("Rate must be positive");
		}
		rate = rate1;
	}
	@Override
	public void deposit(double amount) {
		if(amount < 0) {
			throw new IllegalArgumentException("Deposit amount must be positive");
		}
		double actDeposit = amount * (1+rate);
		super.deposit(actDeposit);
	}
	public double getRate() {return rate;}
	
	@Override
	public String toString() {
		return super.toString() + "@ " + rate + "%";
	}
}
