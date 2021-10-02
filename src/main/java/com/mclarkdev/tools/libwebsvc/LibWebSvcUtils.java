package com.mclarkdev.tools.libwebsvc;

import java.security.MessageDigest;

public class LibWebSvcUtils {

	public static String sumSHA256(byte[] in) {

		try {

			MessageDigest md = MessageDigest.getInstance("SHA-256");
			return bytesToHex(md.digest(in));
		} catch (Exception e) {

			return null;
		}
	}

	public static String bytesToHex(byte[] bytes) {

		if (bytes == null) {

			throw new IllegalArgumentException("supplied value cannot be null");
		}

		char[] hexArray = "0123456789ABCDEF".toCharArray();

		char[] hexChars = new char[bytes.length * 2];

		for (int j = 0; j < bytes.length; j++) {

			int v = bytes[j] & 0xFF;
			hexChars[j * 2] = hexArray[v >>> 4];
			hexChars[j * 2 + 1] = hexArray[v & 0x0F];
		}
		return new String(hexChars);
	}
}