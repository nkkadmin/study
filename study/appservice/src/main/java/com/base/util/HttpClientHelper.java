package com.base.util;

import java.nio.charset.UnsupportedCharsetException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class HttpClientHelper {

	/**
	 * post请求
	 * @param url
	 * @return
	 */
	public static String post(String url,String param){
		HttpClient client = new DefaultHttpClient();
		HttpPost post = new HttpPost(url);
		//传参
		String content = param;
		StringEntity ent = null;
		
		try {
			ent = new StringEntity(content, "utf-8");
		} catch (UnsupportedCharsetException e) {
			e.printStackTrace();
		}
		post.addHeader("Content-Type", "application/json;charset=utf-8");
		post.setEntity(ent);
		System.out.println("URI:"+post.getURI());
		
		try {
			HttpResponse response = client.execute(post);
			if(response.getStatusLine().getStatusCode() == 200){
				HttpEntity responseEntity = response.getEntity();
				String responseStr = EntityUtils.toString(responseEntity);
				return responseStr;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
