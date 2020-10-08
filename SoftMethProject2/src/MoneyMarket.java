import java.text.DecimalFormat;

/**
 * @author Maudiel Romero, Alex Miller
 *
 */
public class MoneyMarket extends Account {
	private int withdrawals;
	
	DecimalFormat df = new DecimalFormat("#.##");

	/**
	 * 
	 * @param holder
	 * @param balance
	 * @param dateOpen
	 * @param withdrawals
	 */
	public MoneyMarket(Profile holder, Double balance, Date dateOpen, int withdrawals) {
		super.Account(holder, balance, dateOpen);
		this.withdrawals = withdrawals;
	}

	public MoneyMarket(Profile holder) {
		super.Account(holder);
	}
	
	public void withdrawal2() {
		this.withdrawals++;
	}

	/**
	 * 
	 * @return monthly refers to interest double 0.0002083
	 */
	@Override
	public double monthlyInterest() {
		 String ret = df.format(this.getBalance() * .0065);
		 return Double.parseDouble(ret);

	}

	/**
	 * adds fee based on sufficient funds and withdrawn more than 7 times
	 * 
	 * @return fee refers to monthly fee of 12 or 0 depending on users balance
	 */
	@Override
	public double monthlyFee() {
		if(this.withdrawals>6) {
			return 12;
		}
		else if (2500 > super.getBalance()) {
			return 12;
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
		return "*Money Market*" + super.toString() + "*" + withdrawals + " withdrawals*";
	}

	/*
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof MoneyMarket) {
			return super.equals(obj) && this.withdrawals == ((MoneyMarket) obj).withdrawals;
		}
		return false;
	}
	*/
}
