package com.base.service;

import com.base.model.User;

/**
 * 公用用户管理
 * 
 * @author xsx
 *
 */
public interface BUservice extends BBaseService<User> {
	
	/**
	 * 根据用户名获取
	 * @param loginName
	 * @return
	 */
	public User quertByLoginName(String loginName);
}
