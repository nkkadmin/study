package com.ssh.lose.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ʱ�䴦����
 * 
 * @author xsx
 *
 */
public class DateHelper {

	/**
	 * ��ȡ��ǰʱ��
	 * @param pattern ʱ���ʽ
	 * @return
	 */
	public static String getNowDate(String pattern){
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		return format.format(new Date());
	}
}
