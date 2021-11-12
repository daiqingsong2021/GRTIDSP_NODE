package com.grtidsp.common.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 时间函数
 * 
 * @author daiqingsong
 * @date 2021-10
 */
@Slf4j
public class TimeUtil {
	
	/**
	 * 得到格式为yyyy-MM-dd HH:mm:ss的当前时间
	 *
	 * @return 时间字符串
	 */
	public static String getNowDate(String pattern) {
		return Date2String(new Date(), pattern);
	}

	public static Date strToDate(String time) throws ParseException{
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		if (StringUtils.isEmpty(time)) {
			return null;
		}
		Date date = formatter.parse(time);
		return date;
	}

	public static String getNowBegin10MonthDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, -10);
		return Date2String(calendar.getTime(), "yyyy-MM");
	}

	/**
	 * 将date对象转换为指定格式的时间字符串
	 *
	 * @param date    Date对象
	 * @param pattern Date要格式化的规范
	 * @return 时间字符串
	 */
	public static String Date2String(Date date, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}

	/**
	 * 将String对象转换为指定格式的时间字符串
	 *
	 * @param
	 * @param pattern Date要格式化的规范
	 * @return 时间字符串
	 */
	public static String Date2String(String sDate, String formater, String pattern) {
		try {
			SimpleDateFormat format = new SimpleDateFormat(formater);
			Date date = format.parse(sDate);
			SimpleDateFormat sdf = new SimpleDateFormat(pattern);
			return sdf.format(date);
		} catch (Exception ex) {
			return "";
		}
	}

	/**
	 * yyyy/MM
	 *
	 */
	public static String getFullYM() {
		String formater = "yyyy-MM";
		SimpleDateFormat format = new SimpleDateFormat(formater);
		Date myDate = new Date();
		return format.format(myDate);
	}

	/**
	 * yyyy-MM-dd
	 *
	 */
	public static String getFullDate() {
		String formater = "yyyy-MM-dd";
		SimpleDateFormat format = new SimpleDateFormat(formater);
		Date myDate = new Date();
		return format.format(myDate);
	}

	/**
	 * yyyyMMdd
	 *
	 */
	public static String getFullDate2() {
		String formater = "yyyyMMdd";
		SimpleDateFormat format = new SimpleDateFormat(formater);
		Date myDate = new Date();
		return format.format(myDate);
	}

	/**
	 * yyyy/MM/dd
	 *
	 */
	public static String getFullFormatDate() {
		String formater = "yyyy/MM/dd";
		SimpleDateFormat format = new SimpleDateFormat(formater);
		Date myDate = new Date();
		return format.format(myDate);
	}

	/**
	 * state 1 前一个小时，-1 后一个小时
	 */
	@SuppressWarnings("deprecation")
	public static String getFullDate(int state) {
		String formater = "yyyy-MM-dd";
		SimpleDateFormat format = new SimpleDateFormat(formater);
		Date myDate = new Date();
		if (state == 1)
			myDate.setHours(myDate.getHours() + 1);
		else if (state == -1)
			myDate.setHours(myDate.getHours() - 1);
		return format.format(myDate);
	}

	/**
	 * state 转换成字符串
	 *
	 */
	@SuppressWarnings("deprecation")
	public static String getDateTimeH(int state) {
		String formater = "yyyy-MM-ddHH";
		SimpleDateFormat format = new SimpleDateFormat(formater);
		Date myDate = new Date();
		if (state == 1)
			myDate.setHours(myDate.getHours() + 1);
		else
			myDate.setHours(myDate.getHours() - 1);
		// myDate.
		return format.format(myDate);
	}

	public static String getDateTimeH() {
		String formater = "yyyy-MM-ddHH";
		SimpleDateFormat format = new SimpleDateFormat(formater);
		Date myDate = new Date();
		return format.format(myDate);
	}

	/**
	 * 返回格式化的日期
	 *
	 */
	public static String getFullDate(String sDate) throws Exception{
		String formater = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat format = new SimpleDateFormat(formater);
		Date date = format.parse(sDate);
		formater = "yyyy-MM-dd";
		format = new SimpleDateFormat(formater);
		return format.format(date);
	}

	/**
	 * getCurDateTime
	 *
	 */
	public static String getCurDateTime() {
		String formater = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat format = new SimpleDateFormat(formater);
		Date myDate = new Date();
		return format.format(myDate);
	}

	/**
	 * getFullDateTime
	 *
	 */
	public static String getFullDateTime(String sDate) {
		try {
			String formater = "yyyy-MM-dd HH:mm:ss";
			SimpleDateFormat format = new SimpleDateFormat(formater);
			Date date = format.parse(sDate);
			return format.format(date);
		} catch (Exception ex) {
			return "";
		}
	}

	/**
	 * yyyy-M-d
	 *
	 */
	public static String getSimpleDate() {
		String formater = "yyyy-M-d";
		SimpleDateFormat format = new SimpleDateFormat(formater);
		Date myDate = new Date();
		return format.format(myDate);
	}

	/**
	 * yyyy
	 *
	 */
	public static String getFullYear() {
		String formater = "yyyy";
		SimpleDateFormat format = new SimpleDateFormat(formater);
		Date myDate = new Date();
		return format.format(myDate);
	}
	/**
	 * yyyy
	 *
	 */
	public static String getFullMM() {
		String formater = "MM";
		SimpleDateFormat format = new SimpleDateFormat(formater);
		Date myDate = new Date();
		return format.format(myDate);
	}
	/**
	 * 字符串根据
	 *
	 */
	public static String getSomeDate(String sDate, int iDay) {
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = format.parse(sDate);
			long Time = (date.getTime() / 1000) + 60 * 60 * 24 * iDay;
			date.setTime(Time * 1000);
			return format.format(date);
		} catch (Exception ex) {
			return "";
		}
	}

	/**
	 * 返回修改后的
	 *
	 * @param sTime
	 * @param iTime
	 * @return
	 */
	public static String getSomeTime(String sTime, int iTime) {
		try {
			SimpleDateFormat format = new SimpleDateFormat("H:mm:ss");
			Date date = format.parse(sTime);
			long Time = (date.getTime() / 1000) + iTime;
			date.setTime(Time * 1000);
			return format.format(date);
		} catch (Exception ex) {
			return "";
		}
	}

	/**
	 * 字符串根据
	 *
	 */
	public static String getSomeHour(String sDate, int hour) {
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = format.parse(sDate);
			long Time = (date.getTime() / 1000) + 60 * 60 * hour;
			date.setTime(Time * 1000);
			return format.format(date);
		} catch (Exception ex) {
			return "";
		}
	}

	// 返回日期的差值

	public static int getNumericDatePeriod(String sDate) {
		int iTime = 0;
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date date = format.parse(sDate);
			Date date1 = new Date();
			iTime = (int) ((date.getTime() - date1.getTime()) / 1000L);
		} catch (Exception ex) {
		}
		return iTime;
	}

	public static int getDateDiff(String sDate) {
		int iTime = 0;
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = format.parse(sDate);
			Date date1 = new Date();
			iTime = (int) ((date.getTime() - date1.getTime()) / 1000L);
		} catch (Exception ex) {
		}
		return iTime;
	}

	// 判断日期的前后
	public static boolean isDateLater(String sDate, String sDate1) {
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = format.parse(sDate);
			Date date1 = format.parse(sDate1);
			if (date.after(date1))
				return true;
			else
				return false;
		} catch (Exception ex) {
			return false;
		}
	}

	// 判断时间的前后
	public static boolean isTimeLater(String sDate, String sDate1) {
		try {
			SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
			Date date = format.parse(sDate);
			Date date1 = format.parse(sDate1);
			if (date.after(date1))
				return true;
			else
				return false;
		} catch (Exception ex) {
			return false;
		}
	}

	public static Date Format(String s) {
		Date lastdt = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			lastdt = sdf.parse(s);
		} catch (Exception e) {
		}
		return lastdt;
	}

	public static Date FullFormat(String s) {
		Date lastdt = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			lastdt = sdf.parse(s);
		} catch (Exception e) {
		}
		return lastdt;
	}

	public static String getCurTime() {
		String formater = "HH:mm:ss";
		SimpleDateFormat format = new SimpleDateFormat(formater);
		Date myDate = new Date();
		return format.format(myDate);
	}

	public static String getCureDateString() {
		final String dayNames[] = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
		Calendar calendar = Calendar.getInstance();
		;
		Date date = new Date();
		calendar.setTime(date);
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		if (dayOfWeek < 0)
			dayOfWeek = 0;
		SimpleDateFormat format = new SimpleDateFormat("yyyy年M月d日");
		Date myDate = new Date();
		return format.format(myDate) + " " + dayNames[dayOfWeek];
	}

	public static String getDateYYYY_MM_DD(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date.getTime());
	}

	public static String getDateYYYY_MM_DD(String sdate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		try {
			date = sdf.parse(sdate);
		} catch (ParseException e) {
			log.info("getDateYYYY_MM_DD: ParseException", e);
		}
		return sdf.format(date.getTime());
	}

	/**
	 * 把传过来的日期格式化为:HH:mm:ss
	 *
	 * @param date
	 * @return String
	 */
	public static String getDateHH_mm_ss(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		return sdf.format(date.getTime());
	}

	/**
	 * 把传过来的日期格式化为:yyyy-MM-dd HH:mm:ss
	 *
	 * @param date
	 * @return String
	 */
	public static String getDateYYYY_MM_DD_HH_MM_SS(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date.getTime());
	}

	/**
	 * 把传过来的日期格式化为:yyyyMMdd
	 *
	 * @param date
	 * @return String
	 */
	public static String getDateYYYYMMDD(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		return sdf.format(date.getTime());
	}
	/**
	 * 把传过来的日期格式化为:yyyyMMdd
	 *
	 * @param date
	 * @return String
	 */
	public static String getDateYYYYMM(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM");
		return sdf.format(date.getTime());
	}
	/**
	 * 传过来的日期格式化为:yyyy-MM-dd
	 *
	 * @param date
	 * @return
	 */
	public static String getDateYYYYMMDD3(String date) {
		if (!StringUtils.isEmpty(date)) {
			String year = date.substring(0, 4);
			String month = date.substring(5, 7);
			String day = date.substring(8, 10);
			return year + "年" + month + "月" + day + "日";
		} else {
			return "";
		}
	}

	/**
	 * 传过来的日期格式化为:yyyy-MM-dd 转化为首位不带0的年月日
	 *
	 * @param date
	 * @return
	 */
	public static String getDateYYYYMMDD3_add(String date) {
		String year = date.substring(0, 4);
		int month = Integer.parseInt(date.substring(5, 7));
		int day = Integer.parseInt(date.substring(8, 10));
		return year + "年" + month + "月" + day + "日";
	}

	/**
	 * 把传过来的日期格式化为:yyyyMMdd
	 *
	 * @param date
	 * @return String
	 */
	public static String getDateYYYYMMDD(String date) {
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date2 = new Date();
		try {
			date2 = sdf.parse(date);
		} catch (ParseException e) {
			log.info("getDateYYYYMMDD: ParseException", e);
		}
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		String str = format.format(date2);
		return str;
	}

	/**
	 * 把传过来的日期格式化为:yyyy年MM月dd日
	 *
	 * @param date
	 * @return String
	 */
	public static String getDateYYYYMMDD2(Date date) {
		SimpleDateFormat yyyySdf = new SimpleDateFormat("yyyy");
		SimpleDateFormat mmSdf = new SimpleDateFormat("MM");
		SimpleDateFormat ddSdf = new SimpleDateFormat("dd");
		String year = yyyySdf.format(date.getTime());
		String month = mmSdf.format(date.getTime());
		String day = ddSdf.format(date.getTime());
		return year + "年" + month + "月" + day + "日";
	}

	/**
	 * 把传过来的日期格式化为:yyyyMMdd HH:mm:ss
	 *
	 * @param date
	 * @return String
	 */
	public static String getDateYYYYMMDDHHMMDD(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
		return sdf.format(date.getTime());
	}

	/**
	 * 把传过来的日期格式化为:yyyy/MM/dd
	 *
	 * @param date
	 * @return String
	 */
	public static String getDateYMD(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		return sdf.format(date.getTime());
	}

	/**
	 * 把传过来的日期格式化为:yyyy/MM/dd HH:mm:ss
	 *
	 * @param date
	 * @return String
	 */
	public static String getDateYMDHMD(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		return sdf.format(date.getTime());
	}

	/**
	 * 获得日期的星期
	 *
	 * @param date 需要查的日期DATE类型
	 * @return String
	 */
	public static String getDayOfWeek(Date date) {
		String dayNames[] = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		return dayNames[dayOfWeek - 1];
	}

	/**
	 * 日期的加法
	 *
	 * @param source Date型的原来的日期
	 * @param days   int需要进行相加(相减)的天数
	 * @return Date 出错返回null
	 */
	public static Date addDay(Date source, int days) {
		Calendar cal = new GregorianCalendar();
		cal.setTime(source);
		cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH) + days);
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			date = sdf.parse(new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime()));
			return date;
		} catch (Exception e) {
			log.info("addDay: Exception", e);
			return null;
		}
	}

	/**
	 * 日期的加法
	 *
	 * @param source Date型的原来的日期
	 * @param days   int需要进行相加(相减)的天数
	 * @return Date 出错返回null
	 */
	public static String addDay(String source, int days) {
		SimpleDateFormat sdff = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date Sdate = sdff.parse(source);
			Calendar cal = new GregorianCalendar();
			cal.setTime(Sdate);
			cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH) + days);
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			date = sdf.parse(new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss").format(cal.getTime()));

			return sdf.format(date.getTime());
		} catch (Exception e) {
			log.info("addDay: Exception", e);
			return null;
		}
	}

	public static String add23hh59mm59ss(String source, int days) {
		SimpleDateFormat sdff = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date Sdate = sdff.parse(source);
			Calendar cal = new GregorianCalendar();
			cal.setTime(Sdate);
			cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH) + days);
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			date = sdf.parse(new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss").format(cal.getTime()));

			return sdf.format(date.getTime() - 1);
		} catch (Exception e) {
			log.info("add23hh59mm59ss: Exception", e);
			return null;
		}
	}

	/**
	 * 获取今天的日期，格式为:yyyy-MM-dd HH:mm:ss
	 *
	 * @return String
	 */
	public static String getNowYYYY_MM_DD_HH_MM_SS() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date.getTime());
	}

	/**
	 * 获取今天的日期，格式为:yyyy-MM-dd HH:mm:ss
	 *
	 * @return String
	 */
	public static String getNowHH_MM_DD() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		return sdf.format(date.getTime());
	}

	/**
	 * 获取今天的日期,格式为:yyyy-MM-dd
	 *
	 * @return String
	 */
	public static String getNowYYYY_MM_DD() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date.getTime());
	}

	/**
	 * 获取今天的日期,格式为:yyyyMMdd HH:mm:ss
	 *
	 * @return String
	 */
	public static String getNowYYYYMMDDHHMMDD() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
		return sdf.format(date.getTime());
	}

	/**
	 * 获取今天的日期,格式为:yyyyMMdd
	 *
	 * @return String
	 */
	public static String getNowYYYYMMDD() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		return sdf.format(date.getTime());
	}

	/**
	 * 获取今天的日期,格式为:yyyy/mm/dd HH:mm:ss
	 *
	 * @return String
	 */
	public static String getNowYMDHMS() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		return sdf.format(date.getTime());
	}

	/**
	 * 获取今天的日期,格式为:yyyy/mm/dd
	 *
	 * @return String
	 */
	public static String getNowYMD() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		return sdf.format(date.getTime());
	}

	/**
	 * 获取今天的星期数
	 *
	 * @return String
	 */
	public static String getNowOfWeek() {
		return getDayOfWeek(new Date());
	}

	/**
	 * 获取今天相加(减)的日期
	 *
	 * @param days int型的相加(减)的天数
	 * @return Date
	 */
	public static Date addNow(int days) {
		return addDay(new Date(), days);
	}

	/**
	 * 获取java.sql.Date类型的数据，格式只能是"yyyy-MM-dd"
	 *
	 * @param date 传入的java.util.Date 数据
	 * @return java.util.Date
	 */
	public static java.sql.Date getSqlDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String str = sdf.format(date);
		return java.sql.Date.valueOf(str);
	}

	/**
	 * 获取现在和传如日期的相隔年数
	 *
	 * @param date 日期类型
	 * @return Int
	 */
	public static int YearDiffer(Date date) {
		Calendar cal = Calendar.getInstance();
		int nowday = cal.get(Calendar.YEAR);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		int day = Integer.parseInt(sdf.format(date));
		int n = nowday - day;
		return n;
	}

	/**
	 * 获取现在和传如日期的相隔年数
	 *
	 * @param type 1 秒，2分钟 3小时
	 * @return long
	 */
	public static long compare_date(String startTime, String endTime, int type) {
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		long diff = 0;
		try {
			diff = sd.parse(endTime).getTime() - sd.parse(startTime).getTime();
		} catch (Exception exception) {
			log.info("compare_date: Exception", exception);
		}
		if (type == 1) {
			diff = diff / 1000;
		} else if (type == 2) {
			diff = diff / (1000 * 60);
		} else if (type == 3) {
			diff = diff / (1000 * 60 * 60);
		}
		return diff;

	}

	/**
	 * 获取现在和传如日期的相隔年数
	 *
	 * @param type 1 秒，2分钟 3小时
	 * @return long
	 */
	public static long compare_dateByday(String startTime, String endTime, int type) {
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		long diff = 0;
		try {
			diff = sd.parse(endTime).getTime() - sd.parse(startTime).getTime();
		} catch (Exception exception) {
			log.info("compare_dateByday: Exception", exception);
		}
		if (type == 1) {
			diff = diff / 1000;
		} else if (type == 2) {
			diff = diff / (1000 * 60);
		} else if (type == 3) {
			diff = diff / (1000 * 60 * 60);
		}
		return diff;

	}

	/**
	 * 日期的加法
	 *
	 * @param
	 * @param type   1 年 2 月 3 天
	 * @param num    int需要进行相加(相减)的数量
	 * @return Date 出错返回null
	 */
	public static String adddate(Date dates, int type, int num) {
		try {
			Calendar  cal  =  Calendar.getInstance();
			cal.setTime(dates);
			if (type == 1) {
				cal.add(Calendar.YEAR, num);// 日期加减年
			} else if (type == 2) {
				cal.add(Calendar.MONTH, num);// 日期加减月
			} else if (type == 3) {
				cal.add(Calendar.DAY_OF_YEAR, num);// 日期加减天
			}
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date = sdf.parse(new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime()));
			return sdf.format(date.getTime());
		} catch (Exception e) {
			log.info("adddate: Exception", e);
			return null;
		}
	}

	/**
	 * 获取当前时间精确到毫秒
	 *
	 * @return long
	 */
	public static String getyyyyMMddHHmmssSSS(Date date) {
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
		String myTime = sdFormat.format(date);
		return myTime;

	}

	/**
	 * 功能: 将输入的日期转换为中文日期（例如: 2007-10-05 --> 二○○七年十月五日) 说明：此程序假定输入格式为yyyy-mm-dd, 且年月日部分都为数字, 没有加上非法
	 *
	 * @param str
	 * @return
	 */
	public static String formatChineseStr(String str) {
		StringBuffer sb = new StringBuffer();
		int pos1 = str.indexOf("-");
		int pos2 = str.lastIndexOf("-");
		for (int i = 0; i < 4; i++) {
			sb.append(formatDigit(str.charAt(i)));
		}
		sb.append('年');
		if (getMidLen(str, pos1, pos2) == 1) {
			sb.append(formatDigit(str.charAt(5)) + "月");
			if (str.charAt(7) != '0') {
				if (getLastLen(str, pos2) == 1) {
					sb.append(formatDigit(str.charAt(7)) + "日");
				}
				if (getLastLen(str, pos2) == 2) {
					if (str.charAt(7) != '1' && str.charAt(8) != '0') {
						sb.append(formatDigit(str.charAt(7)) + "十" + formatDigit(str.charAt(8)) + "日");
					} else if (str.charAt(7) != '1' && str.charAt(8) == '0') {
						sb.append(formatDigit(str.charAt(7)) + "十日");
					} else if (str.charAt(7) == '1' && str.charAt(8) != '0') {
						sb.append("十" + formatDigit(str.charAt(8)) + "日");
					} else {
						sb.append("十日");
					}
				}
			} else {
				sb.append(formatDigit(str.charAt(8)) + "日");
			}
		}
		if (getMidLen(str, pos1, pos2) == 2) {
			if (str.charAt(5) != '0' && str.charAt(6) != '0') {
				sb.append("十" + formatDigit(str.charAt(6)) + "月");
				if (getLastLen(str, pos2) == 1) {
					sb.append(formatDigit(str.charAt(8)) + "日");
				}
				if (getLastLen(str, pos2) == 2) {
					if (str.charAt(8) != '0') {
						if (str.charAt(8) != '1' && str.charAt(9) != '0') {
							sb.append(formatDigit(str.charAt(8)) + "十" + formatDigit(str.charAt(9)) + "日");
						} else if (str.charAt(8) != '1' && str.charAt(9) == '0') {
							sb.append(formatDigit(str.charAt(8)) + "十日");
						} else if (str.charAt(8) == '1' && str.charAt(9) != '0') {
							sb.append("十" + formatDigit(str.charAt(9)) + "日");
						} else {
							sb.append("十日");
						}
					} else {
						sb.append(formatDigit(str.charAt(9)) + "日");
					}
				}
			} else if (str.charAt(5) != '0' && str.charAt(6) == '0') {
				sb.append("十月");
				if (getLastLen(str, pos2) == 1) {
					sb.append(formatDigit(str.charAt(8)) + "日");
				}
				if (getLastLen(str, pos2) == 2) {
					if (str.charAt(8) != '0') {
						if (str.charAt(8) != '1' && str.charAt(9) != '0') {
							sb.append(formatDigit(str.charAt(8)) + "十" + formatDigit(str.charAt(9)) + "日");
						} else if (str.charAt(8) != '1' && str.charAt(9) == '0') {
							sb.append(formatDigit(str.charAt(8)) + "十日");
						} else if (str.charAt(8) == '1' && str.charAt(9) != '0') {
							sb.append("十" + formatDigit(str.charAt(9)) + "日");
						} else {
							sb.append("十日");
						}
					} else {
						sb.append(formatDigit(str.charAt(9)) + "日");
					}
				}
			} else {
				sb.append(formatDigit(str.charAt(6)) + "月");
				if (getLastLen(str, pos2) == 1) {
					sb.append(formatDigit(str.charAt(8)) + "日");
				}
				if (getLastLen(str, pos2) == 2) {
					if (str.charAt(8) != '0') {
						if (str.charAt(8) != '1' && str.charAt(9) != '0') {
							sb.append(formatDigit(str.charAt(8)) + "十" + formatDigit(str.charAt(9)) + "日");
						} else if (str.charAt(8) != '1' && str.charAt(9) == '0') {
							sb.append(formatDigit(str.charAt(8)) + "十日");
						} else if (str.charAt(8) == '1' && str.charAt(9) != '0') {
							sb.append("十" + formatDigit(str.charAt(9)) + "日");
						} else {
							sb.append("十日");
						}
					} else {
						sb.append(formatDigit(str.charAt(9)) + "日");
					}
				}
			}
		}
		return sb.toString();
	}

	public static char formatDigit(char sign) {
		if (sign == '0')
			sign = '〇';
		if (sign == '1')
			sign = '一';
		if (sign == '2')
			sign = '二';
		if (sign == '3')
			sign = '三';
		if (sign == '4')
			sign = '四';
		if (sign == '5')
			sign = '五';
		if (sign == '6')
			sign = '六';
		if (sign == '7')
			sign = '七';
		if (sign == '8')
			sign = '八';
		if (sign == '9')
			sign = '九';
		return sign;
	}

	public static int getMidLen(String str, int pos1, int pos2) {
		return str.substring(pos1 + 1, pos2).length();
	}

	public static int getLastLen(String str, int pos2) {
		return str.substring(pos2 + 1).length();
	}
	public static Integer getNumericDatePeriod(Date nowDate) {
		Calendar  from  =  Calendar.getInstance();
	    from.setTime(nowDate);
	    Calendar  to  =  Calendar.getInstance();
	    to.setTime(new Date());
		int day = (int) ((to.getTimeInMillis()  -  from.getTimeInMillis())  /  (24  *  3600  *  1000));
		return day;
	}
	public static void main(String[] args) {
//		System.out.println(getNumericDatePeriod());
//		System.out.println(getNowYYYYMMDDHHMMDD());
//		System.out.println(getNowYYYY_MM_DD_HH_MM_SS());
//		System.out.println(getNowYMDHMS());
//		System.out.println(YearDiffer(java.sql.Date.valueOf("2003-01-02")));
	}
}
