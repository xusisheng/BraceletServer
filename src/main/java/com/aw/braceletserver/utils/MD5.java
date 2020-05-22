package com.aw.braceletserver.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
	public static String getMD5Str(String str) {
		byte[] byteArray = getMD5(str);
		StringBuffer md5StrBuff = new StringBuffer();
		for (byte element : byteArray) {
			if (Integer.toHexString(0xFF & element).length() == 1) {
				md5StrBuff.append("0").append(Integer.toHexString(0xFF & element));
			} else {
				md5StrBuff.append(Integer.toHexString(0xFF & element));
			}
		}
		return md5StrBuff.toString().toUpperCase();
	}

	public static byte[] getMD5(String str) {
		MessageDigest messageDigest = null;
		try {
			messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.reset();
			messageDigest.update(str.getBytes("UTF-8"));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return messageDigest.digest();
	}

	public String getMD5Str(byte[] b) {
		MessageDigest messageDigest = null;
		try {
			messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.reset();
			messageDigest.update(b);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		byte[] byteArray = messageDigest.digest();
		StringBuffer md5StrBuff = new StringBuffer();
		for (byte element : byteArray) {
			if (Integer.toHexString(0xFF & element).length() == 1) {
				md5StrBuff.append("0").append(Integer.toHexString(0xFF & element));
			} else {
				md5StrBuff.append(Integer.toHexString(0xFF & element));
			}
		}
		return md5StrBuff.toString();
	}
}
