
public class Checking extends Account {
	private boolean directDeposit;

	/**
	 * 
	 * @param holder
	 * @param balance
	 * @param dateOpen
	 * @param directDeposit
	 */
	public Checking(Profile holder, Double balance, Date dateOpen,boolean directDeposit) {
		super.Account(holder, balance, dateOpen);
		
		this.directDeposit=directDeposit;	
	}
	public Checking(Profile holder) {
		super.equals(holder);
	}
	
	/**
	 * interest for month is 5% / 12 = 0.000416667
	 * @return CheckingInterest refers to monthly interest
	 */
	@Override
	public double monthlyInterest() {
		double CheckingInterest = 0.0000416667;
		if (this.directDeposit = false) {
			return CheckingInterest;
		}else {
			CheckingInterest = 0;
		return CheckingInterest;
		}
	}
	/**
	 * Checks if account holds sufficient funds of >= 1500 
	 * @return 0 refers to balance is > than 1500 else return 25
	 */
	@Override
	public double monthlyFee() {
		double balance = 1500;
		if (balance >= super.getBalance()) {
			return 0; 
		}else {
			balance= 25;
		return balance; 	
		}
	}
	/**
	 * have the difference between Intrest and fee as once var. 
	 * @param profile
	 * @return
	 */
	@Override
	public String toString() {
		return "checking" + super.toString();
	}
}
