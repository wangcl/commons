package cc.wangcl.commons.util;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * String utilities.
 *
 * @author wangcl
 */
public class StringUtils {

	public static final byte SPACE = (byte) 0x20;

	/**
	 * convert the source string to a fixed size string in UTF-8.
	 *
	 * @param source     String to be converted
	 * @param sizeInByte size in byte
	 * @return fixed size String
	 */
	public static String toFixedSize(String source, int sizeInByte) {
		if (source == null) {
			source = "";
		}

		StringBuilder sb = new StringBuilder();
		int size = 0;
		for (int i = 0; i < source.length(); i++) { // String.length returns the length of code unit
			char ch = source.charAt(i);
			int charLength = String.valueOf(ch).getBytes(StandardCharsets.UTF_8).length; // get length (in byte) of each character
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

	/**
	 * split String with delimiter.
	 *
	 * @param src       source String
	 * @param delimiter delimiter
	 * @return List of Strings
	 */
	public static List<String> split(final String src, final String delimiter) {
		if (src == null || src.isEmpty()) {
			return new ArrayList<>(0);
		}

		List<String> list = new ArrayList<>();
		int start = 0, end;
		while ((end = src.indexOf(delimiter, start)) >= 0) {
			list.add(src.substring(start, end));
			start = end + delimiter.length();
		}
		list.add(src.substring(start));

		return list;
	}

}
