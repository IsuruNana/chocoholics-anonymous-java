package project4.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import project4.Service;

public class ServiceTestRobert {
	Service ser;
	@Before
	public void setUp() throws Exception {
		ser = new Service();
		ser.setServiceFee(100.00);
		ser.setServiceNumber("123456");
		ser.setServiceName("Safe Space Time");
		
	}

	
	@Test
	public void testFee() {
		assertEquals(100.00, ser.getServiceFee(), 0.0);
	} 
	
	@Test(expected = NumberFormatException.class)
	public void testFailure() {
		ser.setServiceFee(-1.00);
	}
	
	
	@Test
	public void testSanity() {
		ser.setServiceFee(ser.getServiceFee());
		assertEquals(100.00, ser.getServiceFee(), 0.0);

	}
	
}
