package com.base.service;

import com.base.model.User;

/**
 * 公用用户管理
 * 
 * @author xsx
 *
 */
public interface BUserService extends BBaseService<User> {
	
	/**
	 * 根据登录名查询
	 * @param loginName
	 * @return
	 */
	public User getUserByLoginName(String loginName);
}
