package cc.wangcl.commons.util;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * String utilities.
 *
 * @author wangcl
 */
public class StringUtils {

	public static final byte SPACE = (byte) 0x20;

	/**
	 * truncate String into the max size in byte.
	 *
	 * @param source   source String
	 * @param maxBytes max size in byte
	 * @return String
	 */
	public static String limit(String source, int maxBytes) {
		if (source == null || maxBytes <= 0) {
			return "";
		}

		source = source.trim();
		if (source.getBytes(StandardCharsets.UTF_8).length <= maxBytes) {
			return source;
		}

		int index = 0, bytes = 0;
		while (index < source.length()) {
			int codePoint = source.codePointAt(index);
			int len = new String(Character.toChars(codePoint)).getBytes(StandardCharsets.UTF_8).length;
			bytes += len;
			if (bytes > maxBytes) {
				break;
			}
			index += Character.charCount(codePoint);
		}
		return source.substring(0, index);
	}

	/**
	 * convert the source string to a fixed size string in UTF-8.
	 *
	 * @param source     String to be converted
	 * @param sizeInByte size in byte
	 * @return fixed size String
	 */
	public static String toFixedSize(String source, int sizeInByte) {
		if (sizeInByte <= 0) {
			return "";
		}

		if (source == null) {
			source = "";
		}

		int index = 0, bytes = 0;
		while (index < source.length()) {
			int codePoint = source.codePointAt(index);
			int len = new String(Character.toChars(codePoint)).getBytes(StandardCharsets.UTF_8).length;
			if (bytes + len > sizeInByte) {
				break;
			}
			bytes += len;
			index += Character.charCount(codePoint);
		}

		return source.substring(0, index) + getSpaces(sizeInByte - bytes);
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
		Arrays.fill(bytes, SPACE);

		return new String(bytes, StandardCharsets.UTF_8);
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

	/**
	 * append letters to a String.
	 *
	 * @param src    source String
	 * @param letter letter to append
	 * @param count  count of letters
	 * @return String
	 */
	public static String appendLetters(String src, String letter, int count) {
		if (count <= 0) {
			return src;
		}

		StringBuilder sb = new StringBuilder(src);
		for (int i = 0; i < count; i++) {
			sb.append(letter);
		}
		return sb.toString();
	}

}
