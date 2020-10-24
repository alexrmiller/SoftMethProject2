/**
 * Savings class that extends Account Class
 * 
 * @authorMaudiel Romero , Alex Miller
 *
 */
import java.text.DecimalFormat;
public class Savings extends Account {
	private boolean isLoyal;

	DecimalFormat df = new DecimalFormat("#.##");
	
	/**
	 * Constructor for Savings type Account
	 * 
	 * @param holder refers to Profile fist and last name
	 * @param balance refers to users account balance
	 * @param dateOpen refers to date user made account
	 * @param isLoyal refers to users savings loyalty status 
	 */
	public Savings(Profile holder, Double balance, Date dateOpen, boolean isLoyal) {
		super.Account(holder, balance, dateOpen);
		this.isLoyal = isLoyal;
	}
	/**
	 * Constructor for Savings type Account with only Profile
	 * 
	 * @param holder refers to Account Profile fist and last name
	 */
	public Savings(Profile holder) {
		super.Account(holder);
	}

	/**
	 * Get's the monthly interest on account based on if loyal or not
	 * 
	 * @return Double.parseDouble(ret) refers to is users depending on loyaty status
	 */
	@Override
	public double monthlyInterest() {
		if (this.isLoyal == false) {
			String ret = df.format(this.getBalance() * (.0035/12));
			 return Double.parseDouble(ret);
		} else {
			String ret = df.format(this.getBalance() * (.0025/12));
			 return Double.parseDouble(ret);
		}
	}

	/**
	 * checks the balance quota to see if fee is applicable
	 * 
	 * @return 5 or 0 depending if user has balance over 300
	 */
	@Override
	public double monthlyFee() {
		if (300 > super.getBalance()) {
			return 5;
		} else {
			return 0;
		}
	}

	/**
	 * returns string for Users full acount 
	 * @return "*Savings*" + super.toString() + "*special Savings account*" if loyal or "*Savings*" + super.toString() + "*" if not
	 */
	@Override
	public String toString() {
		return isLoyal ? "*Savings*" + super.toString() + "*special Savings account*" : "*Savings*" + super.toString() + "*";
	}

}
