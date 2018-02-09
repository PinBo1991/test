package com.dzpykj.confirm;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.lang3.StringUtils;

/**
 * 密码盐值加密
 * @author ChaiXY
 */
public class MD5SaltUtils {

	private static final String[] HEX_DIGITS = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d",
			"e", "f" };

	/**
	 * 验证传入的密码是否与正确的密码相等
	 * @param correctPw 正确的密码
	 * @param tobeValidPw 待验证的密码
	 * @param salt 盐值
	 * @return 传入的密码是否与正确的密码相等(true/false)
	 */
	public static boolean isPassword(String correctPw, String salt, String tobeValidPw)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		if (StringUtils.isBlank(correctPw) || StringUtils.isBlank(tobeValidPw)) {
			throw new IllegalArgumentException("两个密码均不能为空");
		}
		return correctPw.equals(getEncodedPw(salt, tobeValidPw));
	}

	/**
	 * 将传入的密码加密(默认字符编码集为UTF-8)
	 * @param salt 盐值
	 * @param tobeEncodedPw 待加密的密码
	 * @return 加密过的密码
	 */
	public static String getEncodedPw(String salt, String tobeEncodedPw)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		return getEncodedPw(salt, tobeEncodedPw, "utf-8");
	}

	/**
	 * 将传入的密码加密
	 * @param salt 盐值
	 * @param tobeEncodedPw 待加密的密码
	 * @param charsetName 编码集
	 * @return 加密过的密码
	 */
	public static String getEncodedPw(String salt, String tobeEncodedPw, String charsetName)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		if (StringUtils.isNotBlank(tobeEncodedPw)) {
			tobeEncodedPw = tobeEncodedPw + "{" + salt + "}";
		} else {
			throw new IllegalArgumentException("待加密密码不能为空");
		}
		MessageDigest instance = MessageDigest.getInstance("MD5");
		instance.update(tobeEncodedPw.getBytes(charsetName));
		byte md5ByteArray[] = instance.digest();
		// byte[] md5ByteArray =instance.digest(tobeEncodedPw.getBytes("utf-8"));

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < md5ByteArray.length; i++) {
			int n = md5ByteArray[i];
			if (n < 0) {
				n = 256 + n;
			}
			int d1 = n / 16;
			int d2 = n % 16;
			sb.append(HEX_DIGITS[d1] + HEX_DIGITS[d2]);
		}
		return sb.toString();
	}

}
