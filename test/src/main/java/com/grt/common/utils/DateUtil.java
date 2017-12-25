package com.grt.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	
	/**
	 * 比较时间
	 * @return t1大返回1,t2大返回-1,相同返回0
	 */
	public static int timeCompare(Date t1,Date t2){
		return t1.compareTo(t2);
	}
	
	/**
	 * 传入时间增加[天]
	 */
	public static Date addDay(Date date,int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, +day);
        return calendar.getTime();
    }
    
	/**
	 * 传入时间减少[天]
	 */
	public static Date descDay(Date date,int day) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, -day);
		return calendar.getTime();
	}
	
	/**
	 * 传入时间增加[月]
	 */
    public static Date addMonth(Date date,int month) {
    	Calendar calendar = Calendar.getInstance();
    	calendar.setTime(date);
    	calendar.add(Calendar.MONTH, +month);
    	return calendar.getTime();
    }	
	
    /**
     * 传入时间减少[月]
     */
    public static Date descMonth(Date date,int month) {
    	Calendar calendar = Calendar.getInstance();
    	calendar.setTime(date);
    	calendar.add(Calendar.MONTH, -month);
    	return calendar.getTime();
    }	
    
    /**
     * 传入时间增加[年]
     */
    public static Date addYear(Date date,int year) {
    	Calendar calendar = Calendar.getInstance();
    	calendar.setTime(date);
    	calendar.add(Calendar.YEAR, +year);
    	return calendar.getTime();
    }	
    
    /**
     * 传入时间减少[年]
     */
    public static Date descYear(Date date,int year) {
    	Calendar calendar = Calendar.getInstance();
    	calendar.setTime(date);
    	calendar.add(Calendar.YEAR, -year);
    	return calendar.getTime();
    }	
	/**
	 * 时间转为Integer(精确到年月日)
	 */
	public static Integer DateToInteger(Date date) {
		int num = Integer.valueOf(new SimpleDateFormat("yyyyMMdd").format(date));
		return num;
	}
	
	/**
	 * 时间转为Long(精确到年月日时分秒)
	 */
	public static Long DateToLong(Date date) {
		long num = Long.valueOf(new SimpleDateFormat("yyyyMMddHHmmss").format(date));
		return num;
	}
	
	/**
	 * 获取当天的开始时间
	 */
	public static long getDayStart(){
		String startStr = new SimpleDateFormat("yyyyMMdd").format(new Date())+"000000";
		long start = Long.valueOf(startStr);
		return start;
	}
	
	/**
	 * 获取当天的结束时间
	 */
	public static long getDayEnd(){
		String endStr = new SimpleDateFormat("yyyyMMdd").format(new Date())+"235959";
		long end = Long.valueOf(endStr);
		return end;
	}
	
	/**
	 * 将日期转为字符串
	 * @param date 要转化为字符串的日期,如:当前时间为new Date()
	 * @param format 要将日期转为怎样格式的字符串形式 如:yyyy-MM-dd
	 */
	//yyyy-MM-dd-HH-mm-ss-SSSS-E
	//yyyy年MM月dd日HH时mm分ss秒 SSSS E
	public static String date2str(Date date,String format){
		return new SimpleDateFormat(format).format(date);
	}
	
	/**
	 * @param format 要转化日期的格式 如:yyyy-MM-dd
	 * @param dateStr 要转化的日期字符串 如:1991-04-03
	 * @throws ParseException format与dateStr格式不一致报异常
	 */
	public static Date str2date(String format,String dateStr) throws ParseException{
		return new SimpleDateFormat(format).parse(dateStr);
	}
	public static void main(String[] args) throws InterruptedException, ParseException {
		
//		System.out.println(date2str(new Date(),"yyyy-MM-dd-HH-mm-ss-SSSS-E")); //2017-03-08-17-16-59-0165-星期三
//		System.out.println(date2str(new Date(),"yyyy年MM月dd日HH时mm分ss秒 SSSS E"));//2017年03月08日17时16分59秒 0193 星期三
//		System.out.println(str2date("yyyy-MM-dd","1991-04-03")); //Wed Apr 03 00:00:00 CST 1991
//		System.out.println(date2str(descDay(new Date(), 1),"yyyyMMdd"));//2017年03月08日17时16分59秒 0193 星期三
		
//		Date t1 = new Date();
//		Thread.sleep(4);
//		Date t2 = new Date();
//		System.out.println(timeCompare(t1, t2));
	}
}
