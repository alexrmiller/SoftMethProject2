import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author Maudiel Romero, Alex Miller 
 *
 */
class DateTest {
	int month, day, year; 
	/**
	 * test if dates are proper
	 * Test method for {@link Date#isValid()}.
	 */
	@Test
	void testIsValid() {
		
		//positive tests
		Date DateTest1 = new Date(month = 02, day= 05, year= 2030);
		Date DateTest2 = new Date(month = 12, day= 11, year= 1900);
		
		
		assertEquals(true, DateTest1.isValid());
		assertEquals(true, DateTest2.isValid());
		
	}
	/**
	 * test if month is over 1
	 * Test method for {@link Date#isValid()}.
	 */
	@Test
	void testIsValid2() {
		
		Date DateTest3 = new Date(month=13, day=2, year=2020);
		assertEquals(false, DateTest3.isValid());
	}
	/**
	 * test if day is over 31
	 * Test method for {@link Date#isValid()}.
	 */
	@Test
	void testIsValid3() {
		//months over 31 days
		Date DateTest5 = new Date(month=4, day=32, year=220);
		assertEquals(false, DateTest5.isValid());
	}
	/**
	 * test if day is over 31
	 * Test method for {@link Date#isValid()}.
	 */
	@Test
	void testIsValid4() {
		//Months with 30 days 
		Date DateTest4 = new Date(month=4, day=31, year=2020);
		assertEquals(false, DateTest4.isValid());
	}
	/**
	 * test if //invalid - 0 nonpositive
	 * Test method for {@link Date#isValid()}.
	 */
	@Test
	void testIsValid5() {
		
		Date DateTest6 = new Date(month=0, day=29, year=2010);
		assertEquals(false, DateTest6.isValid());
	}
}
