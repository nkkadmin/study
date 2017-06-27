package com.app.model;

import java.util.List;

public class AjaxJson {

	private String message;
	private boolean success;
	private List list;
	private Object data = null;

	public AjaxJson() {
	}

	public AjaxJson(String message, boolean success, List list, Object data) {
		super();
		this.message = message;
		this.success = success;
		this.list = list;
		this.data = data;
	}

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

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
