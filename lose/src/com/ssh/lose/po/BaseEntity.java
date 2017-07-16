package com.ssh.lose.po;

import java.util.HashMap;
import java.util.Map;

public class BaseEntity {

	private Map<String,Object> extraInfo = new HashMap<String,Object>();

	public Map<String, Object> getExtraInfo() {
		return extraInfo;
	}

	public void setExtraInfo(Map<String, Object> extraInfo) {
		this.extraInfo = extraInfo;
	}
	
}
