package appservice.user.controller;

import com.base.util.HttpClientHelper;


public class UserControllerTest {

	
	public static void main(String[] args) {
		addUser();
	}
	
	public static void addUser(){
		String url = "http://localhost:8082/appservice/user/addUser.do";
		String param = "{\"loginName\":\"xsx\",\"password\":\"123456\",\"confirmPassword\":\"123456\",\"sex\":\"man\",\"age\":\"18\",\"userName\":\"谢生翔\"}";
		HttpClientHelper httpClientHelper = new HttpClientHelper();
		String resultStr = httpClientHelper.post(url, param);
		System.out.println(resultStr);
	}
}
