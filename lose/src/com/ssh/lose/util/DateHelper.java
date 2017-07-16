package com.ssh.lose.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间处理类
 * 
 * @author xsx
 *
 */
public class DateHelper {

	/**
	 * 获取当前时间
	 * @param pattern 时间格式
	 * @return
	 */
	public static String getNowDate(String pattern){
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		return format.format(new Date());
	}
}
