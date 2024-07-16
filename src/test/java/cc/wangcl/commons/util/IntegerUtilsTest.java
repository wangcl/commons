package cc.wangcl.commons.util;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IntegerUtilsTest {

	@BeforeClass
	public static void setUpClass() {
	}

	@AfterClass
	public static void tearDownClass() {
	}

	@Before
	public void setUp() {
	}

	@After
	public void tearDown() {
	}

	@Test
	public void testToBinaryString() {
		int i = 0;
		String s = IntegerUtils.toBinaryString(i);
		assertEquals(s, "00000000000000000000000000000000");
	}

}
