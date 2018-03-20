package project4.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import project4.DateTime;

public class DateTimeTest {
	DateTime dt;
	
	@Before
	public void setUp() throws Exception {
		dt = new DateTime();
		dt.setDayOfMonth(6);
		dt.setMonth(12);
		dt.setYear(2017);
	}

	@Test
	public void testGetMonth() {
		assertEquals(12, dt.getMonth());
	}

	@Test(expected = NumberFormatException.class)
	public void testSetMonth() {
		dt.setMonth(13);
	}

	@Test
	public void testSanity() {
		dt.setYear(dt.getYear());
		assertEquals(2017, dt.getYear());
	}

}
