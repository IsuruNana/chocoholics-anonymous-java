package project4.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import project4.Member;

public class MemberTest {

	Member member;
	
	@Before
	public void setUp() throws Exception {
		member = new Member("The Queen");
		member.setAddress("The Castle");
		member.setCity("London");
	}
	
	@Test
	public void testGetAddress() {
		assertEquals("The Castle", member.getAddress());
	}

	@Test(expected = NumberFormatException.class)
	public void testSetMonth() {
		member.setNumber("0123456789");
	}
	
	@Test
	public void testSanity() {
		member.setCity(member.getCity());
		assertEquals("London", member.getCity());
	}

}
