package cc.wangcl.commons.util;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
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
	public void testToFixedSize() throws UnsupportedEncodingException {
		String source = "中文字符串测试";
		String encoding = "utf-8";
		String result = StringUtils.toFixedSize(source, encoding, 10);
		assertNotNull(result);
		assertEquals(result.length(), 4); // characters
		System.out.println("{" + result + "}");

		source = "this is an English string";
		result = StringUtils.toFixedSize(source, encoding, 9);
		assertNotNull(result);
		assertEquals("this is a", result);
		System.out.println("{" + result + "}");

		source = "abcde";
		result = StringUtils.toFixedSize(source, encoding, 10);
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

}
