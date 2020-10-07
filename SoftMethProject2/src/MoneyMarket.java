/**
	 * @author Maudiel Romero, Alex Miller
	 *
	 */
public class MoneyMarket extends Account{
	private int withdrawals;
	/**
	 * 
	 * @param holder
	 * @param balance
	 * @param dateOpen
	 * @param withdrawals
	 */
	public MoneyMarket(Profile holder, Double balance, Date dateOpen,int withdrawals) {
		super.Account(holder, balance, dateOpen);
		this.withdrawals = withdrawals; 
	}
	public MoneyMarket(Profile holder) {
	}
	/**
	 * 
	 * @return monthly refers to interest double 0.0002083
	 */
	@Override
	public double monthlyInterest() {
		double MoneyMarketInterest = 0.0002083;
		return MoneyMarketInterest;
		
	}
	/**
	 * adds fee based on sufficient funds and withdrawn more than 7 times  
	 * @return fee refers to monthly fee of 12 or 0 depending on users balance 
	 */
	@Override
	public double monthlyFee() {
		// TODO Auto-generated method stub
		int fee = 12; 
		double balance = 2500; // for later must get this info from superclass or subclass
		if (this.withdrawals > 6 || balance > super.getBalance() ) {
			return fee;
		}else {
			fee = 0;
		return 0;}
	}
	/**
	 * 
	 * @param profile
	 * @return
	 */
	@Override
	public String toString() {
		return "moneymarket" + super.toString();
	}

}
