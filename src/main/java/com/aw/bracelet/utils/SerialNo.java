package com.aw.bracelet.utils;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class SerialNo {

	public SerialNo() {
	}

	public static synchronized String getUNID() {
		String currentTime = getCurrentDateString("yyMMddHHmmssSSS");
		if (compareTime == null || compareTime.compareTo(currentTime) != 0) {
			compareTime = currentTime;
			sequence = 1L;
		} else {
			sequence++;
		}

		return (new StringBuilder(sequencePrefix).append(String.valueOf(currentTime))).append(
				numberFormat.format(sequence)).toString();
	}

	public static synchronized String getDateID() {
		String currentTime = getCurrentDateString("yyyyMMdd");
		if (compareTime == null || compareTime.compareTo(currentTime) != 0) {
			compareTime = currentTime;
			sequence = 1L;
		} else {
			sequence++;
		}
		return (new StringBuilder(sequencePrefix).append(String.valueOf(currentTime))).append(
				numberFormat.format(sequence)).toString();
	}

	/**
	 * 字符串长度为30
	 * 
	 * @return
	 */
	public static synchronized String getLongUNID() {
		String currentTime = getCurrentDateString("yyyyMMddHHmmssSSS");
		if (longTime == null || longTime.compareTo(currentTime) != 0) {
			longTime = currentTime;
			longSequence = 1L;
		} else {
			longSequence++;
		}
		return (new StringBuilder(sequencePrefix).append(String.valueOf(currentTime))).append(
				longFormat.format(longSequence)).toString();
	}

	public static String getSerialforDB() {
		return getCurrentDateString("yyMMddHHmmssSSS");
	}
	public static String getDateSerial() {
		return getCurrentDateString("yyyyMMddHHmmssSSS");
	}
	public static String getShortSerial() {
		return getCurrentDateString("mmssSSS");
	}

	public static synchronized String getSmallUNID() {
		String currentTime = getCurrentDateString("yyMMddHHmmss");
		if (smallTime == null || smallTime.compareTo(currentTime) != 0) {
			smallTime = currentTime;
			smallSequence = 1L;
		} else {
			smallSequence++;
		}
		return (new StringBuilder(sequencePrefix).append(String.valueOf(currentTime))).append(
				smallFormat.format(smallSequence)).toString();
	}

	private static long sequence;
	private static String compareTime;
	private static NumberFormat numberFormat;
	private static long smallSequence;
	private static String smallTime;
	private static NumberFormat smallFormat;

	private static long longSequence;
	private static String longTime;
	private static NumberFormat longFormat;
	// 从配置文件读取，用于集群，表示是那一台机器
//	@Value("${sequencePrefix}")
	private static String sequencePrefix="1";

	static {
		numberFormat = NumberFormat.getInstance();
		numberFormat.setGroupingUsed(false);
		numberFormat.setMinimumIntegerDigits(3);
		numberFormat.setMaximumIntegerDigits(3);
		smallFormat = NumberFormat.getInstance();
		smallFormat.setGroupingUsed(false);
		smallFormat.setMinimumIntegerDigits(2);
		smallFormat.setMaximumIntegerDigits(2);
		longFormat = NumberFormat.getInstance();
		// 是否允许分组 1123456=》1,123,456
		longFormat.setGroupingUsed(false);
		// 允许小整数位数
		longFormat.setMinimumIntegerDigits(11);
		// 允许大整数位数
		longFormat.setMaximumIntegerDigits(11);
		// 从配置文件读取，用于集群
//		sequencePrefix = ResourceBundle.getBundle("system").getString("sequencePrefix");

	}

	private static String getCurrentDateString(String formatString) {
		Date currentDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat(formatString, Locale.PRC);
		return dateFormat.format(currentDate);
	}

	public static void main(String[] args) {
		String pk = SerialNo.getLongUNID();
		System.out.println(pk);
		System.out.println(pk.length());
	}
}
