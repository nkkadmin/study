package com.base.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间工具类
 * 
 * @author xsx
 *
 */
public class DateHelper {

	// 各种时间格式
	public static final SimpleDateFormat date_sdf = new SimpleDateFormat(
			"yyyy-MM-dd");
	// 各种时间格式
	public static final SimpleDateFormat yyyyMMdd = new SimpleDateFormat(
			"yyyyMMdd");
	// 各种时间格式
	public static final SimpleDateFormat date_sdf_wz = new SimpleDateFormat(
			"yyyy年MM月dd日");
	public static final SimpleDateFormat time_sdf = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm");
	public static final SimpleDateFormat yyyymmddhhmmss = new SimpleDateFormat(
			"yyyyMMddHHmmss");
	public static final SimpleDateFormat short_time_sdf = new SimpleDateFormat(
			"HH:mm");
	public static final SimpleDateFormat datetimeFormat = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");

	/**
	 * 获取当前时间 返回格式：yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static String nowDate() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return df.format(new Date()).toString();
	}
	
}
