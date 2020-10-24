/**
 * Account class is an object class that extends to other Account classes.
 * 
 * @author Maudiel Romero , Alex Miller
 *
 */
import java.text.DecimalFormat;

public abstract class Account {
	private Profile holder;
	private double balance;
	private Date dateOpen;
	
	DecimalFormat df = new DecimalFormat("#.##");
	/**
	 * constructor for Account Object
	 * 
	 * @param holder refers to profile fname and lname 
	 * @param balance refers to users money balance
	 * @param dateOpen refers to user created account
	 */
	public void Account(Profile holder, double balance, Date dateOpen) {
		this.holder = holder;
		this.balance = balance;
		this.dateOpen = dateOpen;
	}
	/**
	 * constructor for Account Object with only holder information
	 * @param holder refers to users first and last name
	 */
	public void Account(Profile holder) {
		this.holder=holder;
	}

	/**
	 * getter method to get the Account balance
	 * @return this.balance refers to current userbalance
	 */
	public double getBalance() {
		return this.balance;
	}

	/**
	 * takes money out of an Account
	 * 
	 * @param amount refers to amount being taken out of Account
	 * 
	 */
	public void debit(double amount) {
		this.balance -= amount;
	}

	/**
	 * checks if two Account objects are equal to each other in both profile and extended classes
	 * @param obj refers to Account being passed through
	 * @return true if Account and Account types are the same or false if otherwise
	 */
	public boolean equals(Object obj) {
		if(obj !=null && obj.getClass()== getClass()) {	
			return this.holder.equals(((Account)obj).holder);
		}
		return false;
	}

	/**
	 * adds money to an Account
	 * @param amount refers to amount being added to this.Account 
	 */
	public void credit(double amount) {
		this.balance += amount;
	}

	/**
	 * Prints the Account information in correct format 
	 * @return this.holder.toString() + "* $" + balance + "*" + this.dateOpen.toString()
	 */
	@Override
	public String toString() {
		return   this.holder.toString() + "* $" +  df.format(balance)+ "*" + this.dateOpen.toString() ;
	}

	/**
	 * abstract method for monthlyInterest
	 *@return null 
	 */
	public abstract double monthlyInterest();

	/**
	 * abstract method for monthlyFee
	 **@return null
	 */
	public abstract double monthlyFee();

	/**
	 * getter method to get the Account Profile
	 * @return this.holder refers to fist and last name in for user profile
	 */
	public Profile getProfile() {
		return this.holder;
	}
	/**
	 * getter method to get the Account date opened
	 * @return this.dateOpen user Date opened
	 */
	public Date getDateOpen() {
		return this.dateOpen;
	}
	/**
	 * setter method to set the Account balance
	 * @param newBalance is the Accounts new balance
	 */
	public void setBalance(double newBalance) {
		this.balance=newBalance;
	}

}