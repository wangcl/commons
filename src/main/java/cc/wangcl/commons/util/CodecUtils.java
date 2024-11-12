package cc.wangcl.commons.util;

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
	 * 将字符串按指定字符集转换成字节数组。
	 *
	 * @param s       字符串
	 * @param charset 字符集
	 * @return 字节数组
	 */
	public static byte[] getBytes(String s, String charset) {
		if (s == null) {
			return null;
		}
		if (charset == null || charset.isEmpty()) {
			return s.getBytes();
		}

		try {
			return s.getBytes(charset);
		} catch (UnsupportedEncodingException e) {
			return null;
		}
	}

	/**
	 * 将字符串进行 base64 编码。
	 *
	 * @param data    字符串
	 * @param charset 字符集
	 * @return base64 编码后的字符串
	 */
	public static String encodeBase64(String data, String charset) {
		return Base64.encodeBase64String(getBytes(data, charset));
	}

	/**
	 * 将字节数据进行 base64 编码。
	 *
	 * @param binaryData 字节数组
	 * @return base64 编码后的字节数组
	 */
	public static byte[] encodeBase64(byte[] binaryData) {
		return Base64.encodeBase64(binaryData);
	}

	/**
	 * 将字节数据进行 base64 编码。
	 *
	 * @param binaryData 字节数组
	 * @return base64 编码后的字符串
	 */
	public static String encodeBase64String(byte[] binaryData) {
		return Base64.encodeBase64String(binaryData);
	}

	/**
	 * 将 base64 字节数组进行解码。
	 *
	 * @param base64Data base64 字节数组
	 * @return 解码后字节数组
	 */
	public static byte[] decodeBase64(byte[] base64Data) {
		return Base64.decodeBase64(base64Data);
	}

	/**
	 * 将字节数组进行 md5 编码。
	 *
	 * @param data 字节数组
	 * @return md5 编码后的字节数组
	 */
	public static byte[] md5(byte[] data) {
		return DigestUtils.md5(data);
	}

	/**
	 * 将字符串按指定的字符集进行 md5 编码，返回 16 进制字符串。
	 *
	 * @param data    字节数组
	 * @param charset 字符集
	 * @return md5 编码后的十六进制字符串
	 */
	public static String md5Hex(String data, String charset) {
		return DigestUtils.md5Hex(getBytes(data, charset));
	}

	/**
	 * 将字节数组进行 sha1 编码。
	 *
	 * @param data 字节数组
	 * @return sha1 编码字节数组
	 */
	public static byte[] sha1(byte[] data) {
		return DigestUtils.sha1(data);
	}

	/**
	 * 将字符串按指定的字符集进行 sha1 编码，返回 16 进制字符串。
	 *
	 * @param data    字符串
	 * @param charset 字符集
	 * @return sha1 编码后的十六进制字符串
	 */
	public static String sha1Hex(String data, String charset) {
		return DigestUtils.sha1Hex(getBytes(data, charset));
	}

	/**
	 * 将字节数组进行 sha256 编码。
	 *
	 * @param data 字节数组
	 * @return sha256 编码后的字节数组
	 */
	public static byte[] sha256(byte[] data) {
		return DigestUtils.sha256(data);
	}

	/**
	 * 将字符串按指定的字符集进行 sha256 编码，返回 16 进制字符串。
	 *
	 * @param data    字符串
	 * @param charset 字符集
	 * @return sha256 编码后的十六进制字符串
	 */
	public static String sha256Hex(String data, String charset) {
		return DigestUtils.sha256Hex(getBytes(data, charset));
	}

	/**
	 * 将字节数组进行 sha384 编码。
	 *
	 * @param data 字节数组
	 * @return sha384 编码后的字节数组
	 */
	public static byte[] sha384(byte[] data) {
		return DigestUtils.sha384(data);
	}

	/**
	 * 将字符串按指定的字符集进行 sha384 编码，返回 16 进制字符串。
	 *
	 * @param data    字符串
	 * @param charset 字符集
	 * @return sha384 编码后的十六进制字符串
	 */
	public static String sha384Hex(String data, String charset) {
		return DigestUtils.sha384Hex(getBytes(data, charset));
	}

	/**
	 * 将字节数组进行 sha512 编码。
	 *
	 * @param data 字节数组
	 * @return sha512 编码后的字节数组
	 */
	public static byte[] sha512(byte[] data) {
		return DigestUtils.sha512(data);
	}

	/**
	 * 将字符串按指定的字符集进行 sha512 编码，返回 16 进制字符串
	 *
	 * @param data    字符串
	 * @param charset 字符集
	 * @return sha512 编码后的十六进制字符串
	 */
	public static String sha512Hex(String data, String charset) {
		return DigestUtils.sha512Hex(getBytes(data, charset));
	}

}
