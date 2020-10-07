/**
	 * @authorMaudiel Romero , Alex Miller
	 *
	 */
public class Savings extends Account{
	private boolean isLoyal;
	
	/**
	 * 
	 * @param holder
	 * @param balance
	 * @param dateOpen
	 * @param isLoyal 
	 */
	public Savings(Profile holder, Double balance, Date dateOpen,boolean isLoyal) {
		super.Account(holder, balance, dateOpen);
		this.isLoyal = isLoyal;
	}
	public Savings(Profile holder) {
	}
	/**
	 * 
	 * @return SavingsInterest refers monthly intrest of 0.00005416667 or 0.0002916667 depending on users loyalty status
	 */
	@Override
	public double monthlyInterest() {
		double SavingsInterest = 0.00005416667;
		if (this.isLoyal = false) {
			return SavingsInterest;
		}else {
			SavingsInterest = 0.0002916667;
		return SavingsInterest;
		}
	}
	/**
	 * checks the balance quota to see if fee is applicable 
	 * @return fee refers to 5 or 0 depending on users balance
	 */
	@Override
	public double monthlyFee() {
		int fee = 5; 
		double balance = 300; // for later must get this info from superclass or subclass
		if (balance >= super.getBalance()) {
			return fee;
		}else {
			fee = 0;
		return 0;
		}
	}
	
	/**
	 * 
	 * @param profile
	 * @return
	 */
//	@Override
//	public String toString() {
//		
//	}

}
