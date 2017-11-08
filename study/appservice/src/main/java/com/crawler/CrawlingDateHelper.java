package com.crawler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;


/**
 * 爬取数据
 * 
 * @author xsx
 *
 */
public class CrawlingDateHelper {

	public static String getDate(String url) {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(url);
		CloseableHttpResponse response = null;
		InputStream io = null;
		BufferedReader bffer = null;
		try {
			response = httpClient.execute(httpGet);
			HttpEntity entity = response.getEntity();
			io = entity.getContent();
			bffer = new BufferedReader(new InputStreamReader(io));
			
			String content = "";
			String line = "";
			while((line = bffer.readLine()) != null){
				content += line;
			}
			bffer.close();
			io.close();
			return content;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(io != null){
					io.close();
				}
				if(bffer != null){
					bffer.close();
				}
				if(response != null){
					response.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	/**
	 * 正则匹配内容
	 * @param data
	 * @param pattern
	 * @return
	 */
	private static String regexAsString(String data,String pattern){
		Pattern p = Pattern.compile(pattern);
		Matcher matcher = p.matcher(data);
		if(matcher.find()){
			return matcher.group();
		}
		return null;
	}
	
	public static void main(String[] args) {
		String url = "http://www.baidu.com";
		String content = getDate(url);
		String imgStr = "";
		if(content != null){
			//寻找图片
			imgStr = regexAsString(content, "(?<=src=\\/\\/)(.+?)(?=\\s)");
		}
		System.out.println(getDate(url));
		System.out.println(imgStr);
	}
}
