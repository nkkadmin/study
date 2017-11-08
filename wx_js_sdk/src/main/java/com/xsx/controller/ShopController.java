package com.xsx.controller;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.xsx.util.Decript;
import com.xsx.util.wxJsSdk.WXJsSdkAPIUtils;


@Controller
@RequestMapping("/shop")
public class ShopController {

	@RequestMapping(value="/info")
	public ModelAndView info(Integer empId,String code,HttpServletRequest request){
		ModelAndView mv = new ModelAndView("shopInfo");
		mv.addObject("empId", empId);
		mv.addObject("code", code);
		String jurl = request.getScheme()+"://"+request.getServerName() + request.getContextPath() + "/shop/shopSub?empId="+empId+"&&code="+code;
		mv.addObject("jurl", jurl);
		//时间戳
		String timestamp = String.valueOf(new Date().getTime()).substring(0, 10);
		//生成签名的随机串
		String nonceStr = UUID.randomUUID().toString().replace("-", "").substring(0, 15);
		String url = request.getRequestURL().toString();
		if(request.getQueryString() != null){
			url = url + "?" + request.getQueryString();
		}
		//签名
		String signature = null;
		Map tokenMap = WXJsSdkAPIUtils.getAccessToken();
		System.out.println("====tokenMap====:"+tokenMap);
		String accessToken = (tokenMap != null && tokenMap.get("access_token") != null) ? tokenMap.get("access_token").toString() : null;
		System.out.println("====accessToken====:"+accessToken);
		if(accessToken == null){
			return null;
		}
		Map ticketMap = WXJsSdkAPIUtils.getTicket(accessToken);
		String ticket = (ticketMap != null && ticketMap.get("ticket") != null) ? ticketMap.get("ticket").toString() : null;
		if (ticket != null && nonceStr != null && timestamp != null
				&& url != null) {
			String appStr = "jsapi_ticket=" + ticket + "&noncestr=" + nonceStr
					+ "&timestamp=" + timestamp + "&url=" + url;
			System.out.println(appStr);
			signature = Decript.SHA1(appStr);
			System.out.println(signature);
		}
		mv.addObject("appid", WXJsSdkAPIUtils.APPID);
		mv.addObject("timestamp", timestamp);
		mv.addObject("nonceStr", nonceStr);
		mv.addObject("signature", signature);
		return mv;
	}
	
	@RequestMapping(value="/shopSub")
	public ModelAndView shopSub(Integer empId,String code,HttpServletRequest request){
		ModelAndView mv = new ModelAndView("shopSub");
		mv.addObject("empId", empId);
		mv.addObject("code", code);
		return mv;
	}
}
