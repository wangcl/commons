package cc.wangcl.commons.util;

/**
 * Integer utilities.
 *
 * @author wangcl
 */
public class IntegerUtils {

	/**
	 * Convert a byte to 8-bits binary string with leading zeros.
	 *
	 * @param b byte
	 * @return binary string
	 */
	public static String toBinaryString(byte b) {
		return toBinaryString(b, 1);
	}

	/**
	 * Convert a byte to 16-bits binary string with leading zeros.
	 *
	 * @param s short
	 * @return binary string
	 */
	public static String toBinaryString(short s) {
		return toBinaryString(s, 2);
	}

	/**
	 * Convert an integer to 32-bits binary string with leading zeros.
	 *
	 * @param i integer
	 * @return binary string
	 */
	public static String toBinaryString(int i) {
		return toBinaryString(i, 4);
	}

	/**
	 * Convert an integer to binary string with leading zeros.
	 *
	 * @param i        integer
	 * @param byteSize size of bytes
	 * @return binary string
	 */
	public static String toBinaryString(int i, int byteSize) {
		if (byteSize > 4 || byteSize <= 0) byteSize = 4;
		String s = Integer.toBinaryString(i);
		int diffSize = 8 * byteSize - s.length();
		StringBuilder sb = new StringBuilder();
		for (int j = 0; j < diffSize; j++) {
			sb.append("0");
		}
		sb.append(s);
		return sb.toString().toUpperCase();
	}

}
