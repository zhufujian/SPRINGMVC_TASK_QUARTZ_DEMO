package com.study.demo.task.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;



public class DateCompare {

	public static final String PATTERN_19 = "yyyy-MM-dd HH:mm:ss";
	public static final String PATTERN_14 = "yyyyMMddHHmmss";
	public final static String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
	public final static String YYYY_MM_DDHHMMSS = "yyyy-MM-dd HH:mm:ss";
	public static SimpleDateFormat SDF_YMDHMS = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");

	/**
	 * 比较currentDate 是否比 compareDate 晚
	 * 
	 * @param currentDate
	 * @param compareDate
	 * @param pattern
	 * @return
	 */
	public static boolean isAfter(String currentDate, String compareDate,
			String pattern) {
		if (StringUtils.isEmpty(pattern)) {
			pattern = PATTERN_19;
		}
		try {
			SimpleDateFormat formater = new SimpleDateFormat(pattern);
			Date current = formater.parse(currentDate);
			Date compare = formater.parse(compareDate);
			return (current != null && compare != null) ? current
					.after(compare) : false;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * yyyy-MM-dd HH:mm:ss --> yyyyMMddHHmmss
	 * 
	 * @param dateStr
	 * @return
	 */
	public static String dateStrToYMDStr(String dateStr) {
		try {
			Date date = dateStrToDate(dateStr, YYYY_MM_DDHHMMSS);
			if (null != date) {
				SimpleDateFormat SDF_YYYYMMDDHHMMSS = new SimpleDateFormat(
						"yyyyMMddHHmmss");
				return SDF_YYYYMMDDHHMMSS.format(date);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * @param dateStr
	 * @return
	 * @throws ParseException
	 */
	public static Date dateStrToDate(String dateStr, String format)
			throws ParseException {
		if (!FuncUtils.isNull(dateStr)) {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			return sdf.parse(dateStr);
		}
		return null;
	}

	public static String getCurrentDateTimeStr() {
		SimpleDateFormat dataFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String timeString = dataFormat.format(date);
		return timeString;
	}

	public static String addMinute(String minute) {
		if (FuncUtils.isNull(minute)) {
			return null;
		}
		try {
			int minuteInt = Integer.valueOf(minute);
			java.util.Date newDate = new java.util.Date();
			Calendar cal = Calendar.getInstance();
			System.out.print(newDate);
			cal.setTime(newDate);
			cal.add(Calendar.MINUTE, minuteInt);
			Date nextDate = cal.getTime();
			String next_dateStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
					.format(nextDate);
			return next_dateStr;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	/*
	 * 从某个时间点，增加分钟，取得新时间点的字符串
	 */
	public static String addMinuteAndSecond(String lastQueryTime, String minute) {
		if (FuncUtils.isNull(minute) || FuncUtils.isNull(lastQueryTime)) {
			return null;
		}
		int minuteInt = Integer.valueOf(minute)-1;
		Date newDate = DateCompare.stringToUtilDate(lastQueryTime);
		Calendar cal = Calendar.getInstance();
		System.out.print(newDate);
		cal.setTime(newDate);
		cal.add(Calendar.MINUTE, minuteInt);
		cal.add(Calendar.SECOND, 59);
		Date nextDate = cal.getTime();
		String next_dateStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
				.format(nextDate);
		return next_dateStr;
	}
	public static String addMinute(String lastQueryTime, String minute) {
		if (FuncUtils.isNull(minute) || FuncUtils.isNull(lastQueryTime)) {
			return null;
		}
		int minuteInt = Integer.valueOf(minute);
		Date newDate = DateCompare.stringToUtilDate(lastQueryTime);
		Calendar cal = Calendar.getInstance();
		System.out.print(newDate);
		cal.setTime(newDate);
		cal.add(Calendar.MINUTE, minuteInt);
		Date nextDate = cal.getTime();
		String next_dateStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
				.format(nextDate);
		return next_dateStr;
	}


	public static java.util.Date stringToUtilDate(String str) {
		if (null != str && str.length() > 0) {
			try {
				// 日期和时间都有
				return (new SimpleDateFormat(YYYY_MM_DDHHMMSS)).parse(str);
			} catch (ParseException ex) {
				ex.printStackTrace();
				return null;
			}
		} else
			return null;
	}
    /**
     * 计算相差秒数 日期格式yyyy-MM-dd HH:mm:ss
     */
    public static int compareSeconds(String strDate, String strDate2)
    {
        SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try
        {
            Date date = dataFormat.parse(strDate);
            Date date2 = dataFormat.parse(strDate2);
            long compare = (date2.getTime() - date.getTime())/1000 ;
            String compareStr = String.valueOf(compare);
            return Integer.parseInt(compareStr);
        } catch (ParseException e)
        {
            e.printStackTrace();
        }
        return 0;
    }
    public static String addSecond(String lastQueryTime, String second) {
		if (FuncUtils.isNull(second) || FuncUtils.isNull(lastQueryTime)) {
			return "";
		}
		int secondInt = Integer.valueOf(second);
		Date newDate = DateCompare.stringToUtilDate(lastQueryTime);
		Calendar cal = Calendar.getInstance();
		cal.setTime(newDate);
		cal.add(Calendar.SECOND, secondInt);
		Date nextDate = cal.getTime();
		String next_dateStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
				.format(nextDate);
		return next_dateStr;
	}
	public static void main(String args[]) {
		//System.out.println(DateCompare.addMinute("2014-09-24 14:54:50","35"));
		System.out.print(DateCompare.compareSeconds("2014-09-24 14:54:50", "2014-09-24 14:50:50"));
	}
}
