package cc.wangcl.commons.util;

import org.junit.*;

import java.io.UnsupportedEncodingException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class StringUtilsTest {

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
	public void testGetBlanks() {
		String s = StringUtils.getBlanks(10);
		assertNotNull(s);
		assertEquals(s.length(), 10);
		System.out.println("{" + s + "}");
	}

	@Test
	public void testFitInFixedSize() throws UnsupportedEncodingException {
		String source = "中文字符串测试";
		String encoding = "utf-8";
		String result = StringUtils.fitToFixedSize(source, encoding, 10);
		assertNotNull(result);
		assertEquals(result.length(), 4); // characters
		System.out.println("{" + result + "}");

		source = "this is an English string";
		result = StringUtils.fitToFixedSize(source, encoding, 9);
		assertNotNull(result);
		assertEquals("this is a", result);
		System.out.println("{" + result + "}");

		source = "abcde";
		result = StringUtils.fitToFixedSize(source, encoding, 10);
		assertNotNull(result);
		assertEquals("abcde     ", result);
		System.out.println("{" + result + "}");
	}

}
