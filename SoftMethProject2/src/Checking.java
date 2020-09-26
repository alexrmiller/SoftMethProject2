
public class Checking extends Account {
	private boolean directDeposit;

	public Checking(boolean directDeposit) {
		super.Account(holder, balance, dateOpen);
		this.directDeposit=directDeposit;
		
	}
	
	@Override
	public double monthlyInterest() {
		
	}

	@Override
	public double monthlyFee() {
		
	}
	
	@Override
	public String toString() {
		
	}
}
