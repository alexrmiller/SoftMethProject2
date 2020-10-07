
public abstract class Account {
	private Profile holder;
	private double balance;
	private Date dateOpen;
	
	/**
	 * 
	 * @param holder
	 * @param balance
	 * @param dateOpen
	 */
	public void Account(Profile holder, double balance, Date dateOpen) {
		this.holder=holder;
		this.balance=balance;
		this.dateOpen=dateOpen;
	}
	/**
	 * 
	 * 
	 * @return this.balance
	 */
	public double getBalance() {
		return this.balance;
	}
	/**
	 * 
	 * @param amount refers to
	 * @return this.balance -= amount
	 */
	public void debit(double amount) {
		this.balance -= amount;
	}
	/**
	 * 
	 * @param acc
	 * @return true if or false if 
	 */
	public boolean equals(Account acc) {
		if(this.holder.equals(acc.holder) && this.balance==acc.balance && this.dateOpen.compareTo(acc.dateOpen)==0) {
			return true;
		}
		return false;
	}
	/**
	 * 
	 * @param amount
	 * @return this.balance += amount
	 */
	public void credit(double amount) {
		this.balance += amount;
	}
	/**
	 * 
	 * 
	 * @return return this.holder.toString() + this.balance + this.dateOpen.toString()
	 */
	@Override
	public String toString() {
		return this.holder.toString() + this.balance + this.dateOpen.toString();
	}
	/**
	 * 
	 * 
	 */
	//these are TO DO
	
	public abstract double monthlyInterest();
	/**
	 * 
	 */
	public abstract double monthlyFee();
	
	public Profile getProfile() {
		return this.holder;
	}
	
	public Date getDateOpen() {
		return this.dateOpen;
	}
	

}
