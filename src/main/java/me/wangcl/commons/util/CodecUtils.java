package me.wangcl.commons.util;

import org.apache.commons.codec.binary.Base64;

import java.io.UnsupportedEncodingException;

/**
 * 编码相关工具类。
 *
 * @author wangcl
 */
public class CodecUtils {

	/**
	 * 将字符串进行base64编码
	 *
	 * @param data 待加密字符串
	 * @param charset 字符编码
	 * @return
	 */
	public static String base64Encode(String data, String charset) {
		return Base64.encodeBase64String(getBytes(data, charset));
	}

	/**
	 * 将字符串按指定编码转换成字节数组。
	 *
	 * @param s 字符串
	 * @param charset 字符编码
	 * @return 字节数组
	 */
	public static byte[] getBytes(String s, String charset) {
		if (s == null) {
			return null;
		}
		if (charset == null || "".equals(charset)) {
			return s.getBytes();
		}

		try {
			return s.getBytes(charset);
		} catch (UnsupportedEncodingException e) {
			return null;
		}
	}

}
