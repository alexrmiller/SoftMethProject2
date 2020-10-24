import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
/**
 * @author Maudiel Romero, Alex Miller 
 *
 */
class CheckingTest {
	Date date = new Date(10, 10, 2010);
	Profile prof = new Profile("fist","last");
	Profile prof2 = new Profile("fist","name");
	
	/**
	 * test interest fee is .42 when balance = 1000.00
	 * Test method for {@link Date#isValid()}.
	 */	
	@Test 
	void testMonthlyInterest() {
		Checking AccountHolder = new Checking(prof, 1000.00,date,true);
		AccountHolder.monthlyInterest();
		
		
		assertEquals(0.04, AccountHolder.monthlyInterest());
		
	}

	/**
	 * test if fee is 0 for directDeposit = true
	 * Test method for {@link Date#isValid()}.
	 */	
	@Test
	void testMonthlyFee() {
		Checking AccountHolder = new Checking(prof, 300.00,date,true);
		AccountHolder.monthlyInterest();
		
		
		assertEquals(0, AccountHolder.monthlyFee());
	}
	
	/**
	 * test if fee is 25 if directDeposit = false
	 * Test method for {@link Date#isValid()}.
	 */	
	@Test 
	void Fee() {
		Checking AccountHolder = new Checking(prof, 300.00,date,false);
		AccountHolder.monthlyInterest();
		
		
		assertEquals(25, AccountHolder.monthlyFee());
	}
	
	/**
	 * test if fee is 25 if balance is less than 1500
	 * Test method for {@link Date#isValid()}.
	 */	
	@Test
	void Feebalance() {
		Checking AccountHolder = new Checking(prof, 1499.00,date,false);
		AccountHolder.monthlyInterest();
		
		
		assertEquals(25, AccountHolder.monthlyFee());
	}

}
