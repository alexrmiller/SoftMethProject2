import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
/**
 * @author Maudiel Romero, Alex Miller 
 *
 */
class MoneyMarketTest {
	Date date = new Date(10, 10, 2010);
	Profile prof = new Profile("fist","last");
	Profile prof2 = new Profile("fist","name");
	
	/**
	 * test monthly fee of 1000, should = .21
	 * Test method for {@link Date#isValid()}.
	 */
	@Test
	void testMonthlyInterest() {
		
		
		//cehck1 
		MoneyMarket AccountHolder = new MoneyMarket(prof,1000.00,date,100);
		AccountHolder.monthlyInterest();
		
		
		assertEquals(0.54, AccountHolder.monthlyInterest());
		
	}
	
	
	/**
	 * test for no fees if no withdraws and balance > 2500.00
	 * Test method for {@link Date#isValid()}.
	 */
	@Test
	void testMonthlyFee() {
	
		MoneyMarket Acc = new MoneyMarket(prof,3000.00,date,0); 	
		assertEquals(0, Acc.monthlyFee());
	}
	
	/**
	 * test for 12 if withdraws over 6
	 * Test method for {@link Date#isValid()}.
	 */	
	@Test
	void feeWithdraw() {
		MoneyMarket Acc = new MoneyMarket(prof,3000.00,date,7);

		assertEquals(12, Acc.monthlyFee());
	}
	
	/**
	 * test for 12 when withdraws is less than 6 and Balance < 2500
	 * Test method for {@link Date#isValid()}.
	 */	
	@Test
	void feeBalance() {
		MoneyMarket Acc = new MoneyMarket(prof,2000.00,date,5);
		assertEquals(12, Acc.monthlyFee());
	}

}
