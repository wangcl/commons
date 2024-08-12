package cc.wangcl.commons.util;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

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
	public void testGetSpaces() {
		String s = StringUtils.getSpaces(10);
		assertNotNull(s);
		assertEquals(s.length(), 10);
		System.out.println("{" + s + "}");
	}

	@Test
	public void testLimit() {
		String source = "中文字符串测试";
		String result = StringUtils.limit(source, 10);
		assertNotNull(result);
		assertEquals(result.length(), 3); // characters
		assertEquals("中文字", result);
		System.out.println("{" + result + "}");
	}

	@Test
	public void testToFixedSize() {
		String source = "中文字符串测试";
		String result = StringUtils.toFixedSize(source, 10);
		assertNotNull(result);
		assertEquals(result.length(), 4); // characters
		System.out.println("{" + result + "}");

		source = "this is an English string";
		result = StringUtils.toFixedSize(source, 9);
		assertNotNull(result);
		assertEquals("this is a", result);
		System.out.println("{" + result + "}");

		source = "abcde";
		result = StringUtils.toFixedSize(source, 10);
		assertNotNull(result);
		assertEquals("abcde     ", result);
		System.out.println("{" + result + "}");
	}

	@Test
	public void testSplit() {
		String src;
		List<String> list;

		src = "a.b.c";
		list = StringUtils.split(src, ".");
		System.out.println(list);

		src = "a.b.";
		list = StringUtils.split(src, ".");
		System.out.println(list);

		src = ".a.b";
		list = StringUtils.split(src, ".");
		System.out.println(list);

		src = ".a.b.";
		list = StringUtils.split(src, ".");
		System.out.println(list);

		src = ".a...b.";
		list = StringUtils.split(src, ".");
		System.out.println(list);

		src = "a!^b!^c";
		list = StringUtils.split(src, "!^");
		System.out.println(list);

		src = "!^a!^!^b!^!^c!^";
		list = StringUtils.split(src, "!^");
		System.out.println(list);

		src = "!^";
		list = StringUtils.split(src, "!^");
		System.out.println(list);

		src = "abc";
		list = StringUtils.split(src, "!^");
		System.out.println(list);
	}

	@Test
	public void testAppendLetters() {
		assertEquals(StringUtils.appendLetters("string", "x", 0), "string");
		assertEquals(StringUtils.appendLetters("string", "x", -5), "string");
		assertEquals(StringUtils.appendLetters("string", "x", 5), "stringxxxxx");
	}

	@Test
	public void testPrependLetters() {
		assertEquals(StringUtils.prependLetters("string", "x", 0), "string");
		assertEquals(StringUtils.prependLetters("string", "x", -5), "string");
		assertEquals(StringUtils.prependLetters("string", "x", 5), "xxxxxstring");
	}

	@Test
	public void testToBinaryString() {
		int i = 0;
		assertEquals("00000000", StringUtils.toBinaryString(i));
		i = 64;
		assertEquals("01000000", StringUtils.toBinaryString(i));
		i = 127;
		assertEquals("01111111", StringUtils.toBinaryString(i));
		i = 128;
		assertEquals("10000000", StringUtils.toBinaryString(i));
		i = 256;
		assertEquals("0000000100000000", StringUtils.toBinaryString(i));

		i = -1;
		assertEquals("11111111111111111111111111111111", StringUtils.toBinaryString(i));
	}

	@Test
	public void testMask() {
		assertEquals("", StringUtils.mask(null, 1, 2));
		assertEquals("", StringUtils.mask("", 1, 2));

		String s = "1234567890";
		assertEquals("1234567890", StringUtils.mask(s, 20, 4));
		assertEquals("1234567890", StringUtils.mask(s, 4, -1));
		assertEquals("1234******", StringUtils.mask(s, 4, 20));
		assertEquals("1234****90", StringUtils.mask(s, 4, 4));
		assertEquals("123456**90", StringUtils.mask(s, -4, 2));
	}

}
