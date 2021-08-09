package me.wangcl.commons.util;

import java.io.UnsupportedEncodingException;

/**
 * String utilities.
 *
 * @author wangcl
 */
public class StringUtils {

	public static final byte SPACE = (byte) 0x20;

	/**
	 * convert the source string into a fixed size string.
	 *
	 * @param source     String to be converted
	 * @param encoding   encoding
	 * @param sizeInByte size in byte
	 * @return fixed size String
	 */
	public static String toFixedSize(String source, String encoding, int sizeInByte)
			throws UnsupportedEncodingException {
		if (source == null) {
			source = "";
		}

		StringBuilder sb = new StringBuilder();
		int size = 0;
		for (int i = 0; i < source.length(); i++) { // String.length returns the length of characters
			char ch = source.charAt(i);
			int charLength = String.valueOf(ch).getBytes(encoding).length; // get length (in byte) of each character
			if (size + charLength <= sizeInByte) {
				sb.append(ch);
				size += charLength;
			}
		}
		String result = sb.toString();

		return result + getSpaces(sizeInByte - size);
	}

	/**
	 * get spaces in size.
	 *
	 * @param sizeInByte spaces in byte
	 * @return spaces String
	 */
	public static String getSpaces(int sizeInByte) {
		if (sizeInByte <= 0) {
			return "";
		}

		byte[] bytes = new byte[sizeInByte];
		for (int i = 0; i < sizeInByte; i++) {
			bytes[i] = SPACE;
		}

		return new String(bytes);
	}

}
