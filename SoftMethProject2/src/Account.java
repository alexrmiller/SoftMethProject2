
public abstract class Account {
	private Profile holder;
	private double balance;
	private Date dateOpen;
	
	public void Account(Profile holder, double balance, Date dateOpen) {
		this.holder=holder;
		this.balance=balance;
		this.dateOpen=dateOpen;
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	public void debit(double amount) {
		this.balance -= amount;
	}
	
	public boolean equals(Account acc) {
		if(this.holder.equals(acc.holder) && this.balance==acc.balance && this.dateOpen.compareTo(acc.dateOpen)==0) {
			return true;
		}
		return false;
	}
	public void credit(double amount) {
		this.balance += amount;
	}
	
	@Override
	public String toString() {
		return this.holder.toString() + this.balance + this.dateOpen.toString();
	}
	
	//these are TO DO
	public abstract double monthlyInterest{}
	
	public abstract double monthlyFee(){}

}
