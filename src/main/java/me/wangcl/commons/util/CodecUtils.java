package me.wangcl.commons.util;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.UnsupportedEncodingException;

/**
 * 编码相关工具类。
 *
 * @author wangcl
 */
public class CodecUtils {

	/**
	 * 将字符串按指定编码转换成字节数组。
	 *
	 * @param s       字符串
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

	/**
	 * 将字符串进行base64编码
	 *
	 * @param data    待加密字符串
	 * @param charset 字符编码
	 * @return
	 */
	public static String encodeBase64(String data, String charset) {
		return Base64.encodeBase64String(getBytes(data, charset));
	}

	/**
	 * 将字节数据进行base64编码
	 *
	 * @param binaryData
	 * @return
	 */
	public static byte[] encodeBase64(byte[] binaryData) {
		return Base64.encodeBase64(binaryData);
	}

	/**
	 * 将字节数据进行base64编码
	 *
	 * @param binaryData
	 * @return
	 */
	public static String encodeBase64String(byte[] binaryData) {
		return Base64.encodeBase64String(binaryData);
	}

	/**
	 * 将base64字节数组进行解码
	 *
	 * @param base64Data
	 * @return
	 */
	public static byte[] decodeBase64(byte[] base64Data) {
		return Base64.decodeBase64(base64Data);
	}

	/**
	 * 将字节数组进行md5编码
	 *
	 * @param data
	 * @return
	 */
	public static byte[] md5(byte[] data) {
		return DigestUtils.md5(data);
	}

	/**
	 * 将字符串按指定的字符集进行md5编码，返回16进制字符串
	 *
	 * @param data
	 * @param charset
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String md5Hex(String data, String charset) {
		return DigestUtils.md5Hex(getBytes(data, charset));
	}

	/**
	 * 将字节数组进行sha1编码
	 *
	 * @param data
	 * @return
	 */
	public static byte[] sha1(byte[] data) {
		return DigestUtils.sha1(data);
	}

	/**
	 * 将字符串按指定的字符集进行sha1编码，返回16进制字符串
	 *
	 * @param data
	 * @param charset
	 * @return
	 */
	public static String sha1Hex(String data, String charset) {
		return DigestUtils.sha1Hex(getBytes(data, charset));
	}

	/**
	 * 将字节数组进行sha256编码
	 *
	 * @param data
	 * @return
	 */
	public static byte[] sha256(byte[] data) {
		return DigestUtils.sha256(data);
	}

	/**
	 * 将字符串按指定的字符集进行sha256编码，返回16进制字符串
	 *
	 * @param data
	 * @param charset
	 * @return
	 */
	public static String sha256Hex(String data, String charset) {
		return DigestUtils.sha256Hex(getBytes(data, charset));
	}

}
