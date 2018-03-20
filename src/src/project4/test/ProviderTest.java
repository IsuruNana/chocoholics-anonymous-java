package project4.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import project4.Provider;

/*
 * ProviderTest
 * 
 * @version 2.0
 * 
 * @author Richard Rice
 */

public class ProviderTest {

	
Provider testing;
	
	@Before
	public void setUp() throws Exception {
		testing = new Provider();
		testing.setName("Business Guy");
		testing.setAddress("Akiba");
		testing.setCity("Tokyo");
		testing.setNumber("987654321");
	}
		
	
	@Test
	public void successTest() {
		assertEquals("Business Guy", testing.getName());
		assertEquals("Akiba", testing.getAddress());
		assertEquals("Tokyo", testing.getCity());
		assertEquals("987654321", testing.getNumber());
	}
	
	@Test
	public void sanityTest() {
		testing.setName("New Guy");
		testing.setName(testing.getName());
		assertEquals("New Guy", testing.getName());
	}
	
	@Test(expected = NumberFormatException.class)
	public void failTest() {
		testing.printProviderDetails();
	}
	

}
