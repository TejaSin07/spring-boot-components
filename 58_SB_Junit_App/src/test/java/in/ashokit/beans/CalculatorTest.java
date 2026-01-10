package in.ashokit.beans;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.Test;

public class CalculatorTest {

	@Test //It indicates that this method should be run as a test when using a test runner.
	public void addTest() {
		Calculator c = new Calculator();
		int actual = c.add(3, 6);
		int expec = 9;
		assertEquals(actual, expec);
	}
	
	@Test
	public void mulTest() {
		Calculator c = new Calculator();
		int actualRes = c.mul(2, 2);
		int expectedRes = 4;
		
		assertEquals(expectedRes, actualRes);
	}
//Technically correct — the Java compiler and JUnit do not require you to follow a specific naming convention.

//The test actually tests the method you invoke through the object (c.mul(...) in this case), regardless of the test method’s name.
}
