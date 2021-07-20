package com.bank.models;

import static org.junit.Assert.*;

import org.junit.Test;

public class CustomerTest {

		Customer c = new Customer(1, "Mahmood", "UlHussan", "mahmood", "mahmoo1234", "password",
				100);
	@Test
	public void testGetCustomerId() {
		int expected = 1;
		int actual = c.getCustomerId();
		assertEquals(expected,actual);

	}

	@Test
	public void testGetFirstName() {
		String expected = "Mahmood";
		String actual = c.getFirstName();
		assertEquals(expected,actual);
}

}
