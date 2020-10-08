import java.text.DecimalFormat;

/**
 * @authorMaudiel Romero , Alex Miller
 *
 */
public class Savings extends Account {
	private boolean isLoyal;

	DecimalFormat df = new DecimalFormat("#.##");
	
	public Savings(Profile holder) {
		super.Account(holder);
	}
	/**
	 * 
	 * @param holder
	 * @param balance
	 * @param dateOpen
	 * @param isLoyal
	 */
	public Savings(Profile holder, Double balance, Date dateOpen, boolean isLoyal) {
		super.Account(holder, balance, dateOpen);
		this.isLoyal = isLoyal;
	}


	/**
	 * 
	 * @return SavingsInterest refers monthly intrest of 0.00005416667 or
	 *         0.0002916667 depending on users loyalty status
	 */
	@Override
	public double monthlyInterest() {
		if (this.isLoyal == false) {
			String ret = df.format(this.getBalance() * .0035);
			 return Double.parseDouble(ret);
		} else {
			String ret = df.format(this.getBalance() * .0025);
			 return Double.parseDouble(ret);
		}
	}

	/**
	 * checks the balance quota to see if fee is applicable
	 * 
	 * @return fee refers to 5 or 0 depending on users balance
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
	 * 
	 * @param profile
	 * @return
	 */
	@Override
	public String toString() {
		return isLoyal ? "*Savings*" + super.toString() + "*special Savings account*" : "*Savings*" + super.toString() + "*";
	}
/*	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Savings) {
			return super.equals(obj) && this.isLoyal == ((Savings)obj).isLoyal;
		}
		return false;
	}
*/
}
