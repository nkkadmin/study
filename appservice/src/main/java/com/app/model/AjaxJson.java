package com.app.model;

import java.util.List;
import java.util.Map;

public class AjaxJson {

	
	private String message;
	private boolean success;
	//private List<Map<String,Object>> list;
	private List list;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	
	
}
