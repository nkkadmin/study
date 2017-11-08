package com.app.Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 跨域
 * @author xsx
 *
 */
public class CorsFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		System.out.println("==============filter=========");
		HttpServletRequest request = (HttpServletRequest)arg0;
		HttpServletResponse response = (HttpServletResponse)arg1;
	/*	//指定允许其他访问的域
		response.setHeader("Access-Control-Allow-Origin", "*");
		//指定响应类型
		response.setHeader("Access-Control-Allow-Origin", "POST, GET, DELETE, OPTIONS, DELETE");
		// 响应头设置
		response.setHeader("Access-Control-Allow-Headers", "Content-Type, x-requested-with, X-Custom-Header, HaiYi-Access-Token");
		*/
		
		
		/* response.setHeader("Pragma", "no-cache");
         response.setHeader("Cache-Control", "no-cache");
         response.setDateHeader("Expires", 0L);
         response.addHeader("access-control-allow-headers", "Origin, X-Requested-With, Content-Type, Accept");
         response.addHeader("Access-Control-Allow-Origin", "*");
		if("OPTIONS".equals(request.getMethod())){
			response.setStatus(204);
		}*/
		arg2.doFilter(arg0, arg1);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	
}
