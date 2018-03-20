package project4.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import project4.Service;

public class ServiceTest {
	Service service = new Service("Leeches", "123456", 50.00);
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetServiceName() {
		assertEquals("Leeches", service.getServiceName());
	}
	
	@Test(expected = NumberFormatException.class)
	public void testSetServiceFee() {
		service.setServiceFee(-20.00);
	}
	
	@Test
	public void testSanity() {
		service.setServiceFee(service.getServiceFee());
		assertEquals(50.00, service.getServiceFee(), 0.0);
	}
}
