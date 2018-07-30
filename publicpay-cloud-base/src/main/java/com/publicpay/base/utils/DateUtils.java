package com.publicpay.base.utils;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * 日期工具类
 * @author yanfei.zhao
 */
public class DateUtils {
	private static Logger log = LoggerFactory.getLogger(DateUtils.class);

	/**
	 * 默认日期格式
	 */
	private static final String DEFAULT_DATE_FMT = "yyyy-MM-dd HH:mm:ss";

	/**
	 * 获得该月第一天
	 * @param year
	 * @param month
	 * @return
	 */
	public static String getFirstDayOfMonth(int year, int month) {
		Calendar cal = Calendar.getInstance();
		// 设置年份
		cal.set(Calendar.YEAR, year);
		// 设置月份
		cal.set(Calendar.MONTH, month - 1);
		// 获取某月最小天数
		int firstDay = cal.getActualMinimum(Calendar.DAY_OF_MONTH);
		// 设置日历中月份的最小天数
		cal.set(Calendar.DAY_OF_MONTH, firstDay);
		// 格式化日期
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String firstDayOfMonth = sdf.format(cal.getTime());
		return firstDayOfMonth;
	}

	/**
	 * 获得该月最后一天
	 * @param year
	 * @param month
	 * @return
	 */
	public static String getLastDayOfMonth(int year, int month) {
		Calendar cal = Calendar.getInstance();
		// 设置年份
		cal.set(Calendar.YEAR, year);
		// 设置月份
		cal.set(Calendar.MONTH, month - 1);
		// 获取某月最大天数
		int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		// 设置日历中月份的最大天数
		cal.set(Calendar.DAY_OF_MONTH, lastDay);
		// 格式化日期
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String lastDayOfMonth = sdf.format(cal.getTime());
		return lastDayOfMonth;
	}

	/**
	 * 将日期对象转换为字符串
	 * @param date
	 * @param fmt
	 * @return
	 */
	public static String parseDate2Str(final Date date, String fmt) {
		if (StringUtils.isBlank(fmt)) {
			log.debug("Use default date format.");
			fmt = DEFAULT_DATE_FMT;
		}

		SimpleDateFormat sdf = new SimpleDateFormat(fmt);
		sdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
		return sdf.format(date);
	}

	/**
	 * 将字符串转换为日期类型对象
	 * @param dateStr
	 * @param fmt
	 * @return
	 */
	public static Date parseStr2Date(final String dateStr, String fmt) {
		if (StringUtils.isBlank(fmt)) {
			log.debug("Use default date format.");
			fmt = DEFAULT_DATE_FMT;
		}

		SimpleDateFormat sdf = new SimpleDateFormat(fmt);
		Date date = null;

		try {
			date = sdf.parse(dateStr);
		} catch (ParseException e) {
			log.error("Invalid request, " + dateStr + " is invalid format.");
		}

		return date;
	}

	/**
	 * 获取当前年
	 * @return
	 */
	public static String getCurrentYear() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		Date date = new Date();
		return sdf.format(date);
	}

	/**
	 * 获取当前月份
	 * @return
	 */
	public static String getCurrentMonth() {
		SimpleDateFormat sdf = new SimpleDateFormat("MM");
		Date date = new Date();
		return sdf.format(date);
	}

}
