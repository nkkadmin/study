package com.base.controller;

import java.util.List;

import com.app.model.AjaxJson;

public class BaseController {

	public AjaxJson responseInfo(boolean success){
		return responseInfo(null, success, null, null);
	}
	
	
	public AjaxJson responseInfo(String message,boolean success){
		return responseInfo(message, success, null, null);
	}
	
	public AjaxJson responseInfo(String message,boolean success,Object data){
		return responseInfo(message, success, data, null);
	}
	
	/**
	 * 输出数据
	 * @param message
	 * @param success
	 * @param data
	 * @param list
	 * @return
	 */
	public AjaxJson responseInfo(String message,boolean success,Object data,List list){
		AjaxJson ajax = new AjaxJson(message, success, list, data);
		return ajax;
	}
}
