package com.suncent.sso.utils;

import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
import java.util.Map;
import java.util.TreeMap;

/**
 * MD5加密工具类
 * 
 * @author Administrator
 *
 */
public class MD5Utils {

	/**
	 * MD5加密
	 * 
	 * @param str
	 * @return
	 */
	// MD5加码。32位
	public static String MD5(String inStr) {
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
		char[] charArray = inStr.toCharArray();
		byte[] byteArray = new byte[charArray.length];

		for (int i = 0; i < charArray.length; i++)
			byteArray[i] = (byte) charArray[i];

		byte[] md5Bytes = md5.digest(byteArray);

		StringBuffer hexValue = new StringBuffer();

		for (int i = 0; i < md5Bytes.length; i++) {
			int val = ((int) md5Bytes[i]) & 0xff;
			if (val < 16)
				hexValue.append("0");
			hexValue.append(Integer.toHexString(val));
		}

		return hexValue.toString();
	}

	/**
	 * MD5解密
	 * 
	 * @param md5Str
	 * @return
	 */
	public static String KL(String md5Str) {
		char[] a = md5Str.toCharArray();
		for (int i = 0; i < a.length; i++) {
			a[i] = (char) (a[i] ^ 't');
		}
		String s = new String(a);
		return s;
	}

	// 加密后解密
	public static String JM(String inStr) {
		char[] a = inStr.toCharArray();
		for (int i = 0; i < a.length; i++) {
			a[i] = (char) (a[i] ^ 't');
		}
		String k = new String(a);
		return k;
	}
	
	public static String getMD5String(String rawString) { // 用来计算MD5的函数
		String[] hexArray = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F" };
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(rawString.getBytes());
			byte[] rawBit = md.digest();
			String outputMD5 = " ";
			for (int i = 0; i < 16; i++) {
				outputMD5 = outputMD5 + hexArray[rawBit[i] >>> 4 & 0x0f];
				outputMD5 = outputMD5 + hexArray[rawBit[i] & 0x0f];
			}
			return outputMD5.trim();
		} catch (Exception e) {
			System.out.println("计算MD5值发生错误");
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 生成秘钥
	 * 
	 * @param tm
	 * @param key
	 * @return
	 */
	public static String createSign(TreeMap<String, String> tm, String key) {
		StringBuffer buf = new StringBuffer(key);
		for (Map.Entry<String, String> en : tm.entrySet()) {
			String name = en.getKey();
			String value = en.getValue();
			if (!"sign".equals(name) && !"param".equals(name) && value != null && value.length() > 0
					&& !"null".equals(value)) {
				buf.append(name).append('=').append(value).append('&');
			}
		}
		String _buf = buf.toString();
		return _buf.substring(0, _buf.length() - 1);
	}

	/**
	 * 将文件转成base64 字符串
	 * 
	 * @param path文件路径
	 * @return *
	 * @throws Exception
	 */

	public static String encodeBase64File(String path) throws Exception {
		File file = new File(path);
		;
		FileInputStream inputFile = new FileInputStream(file);
		byte[] buffer = new byte[(int) file.length()];
		inputFile.read(buffer);
		inputFile.close();
		// return new BASE64Encoder().encode(buffer);
		return "";
	}

	public static void main(String[] args) {
		String s = new String("abc123");
		String a = MD5(s);
		System.out.println("原始：" + s);
		System.out.println("MD5后：" + a);
	}
}
