import java.text.DecimalFormat;

public class Checking extends Account {
	private boolean directDeposit;
	
	DecimalFormat df = new DecimalFormat("#.##");

	/**
	 * 
	 * @param holder
	 * @param balance
	 * @param dateOpen
	 * @param directDeposit
	 */
	public Checking(Profile holder, Double balance, Date dateOpen, boolean directDeposit) {
		super.Account(holder, balance, dateOpen);

		this.directDeposit = directDeposit;
	}
	
	public Checking(Profile holder) {
		super.Account(holder);
	}

	/**
	 * interest for month is 5% / 12 = 0.000416667
	 * 
	 * @return CheckingInterest refers to monthly interest
	 */
	@Override
	public double monthlyInterest(){
		String ret = df.format(this.getBalance() * .0005);
		 return Double.parseDouble(ret);
	}

	/**
	 * Checks if account holds sufficient funds of >= 1500
	 * 
	 * @return 0 refers to balance is > than 1500 else return 25
	 */
	@Override
	public double monthlyFee() {
		if (this.directDeposit==true) {
			return 0;
		}
		else if(1500 > super.getBalance()) {
			return 25;
		} else {
			return 0;
		}
	}

	/**
	 * have the difference between Intrest and fee as once var.
	 * 
	 * @param profile
	 * @return
	 */
	@Override
	public String toString() {
		return directDeposit ? "*Checking*" + super.toString() + "*direct deposit account*" : "*Checking*" + super.toString() + "*";
	}
	
	/*
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Checking) {
			return super.equals(obj) && this.directDeposit == ((Checking) obj).directDeposit;
		}
		return false;
	}
	*/
}
