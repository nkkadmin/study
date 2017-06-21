package com.base.service;

import java.util.List;

import com.base.model.User;

/**
 * 公用用户管理
 * 
 * @author xsx
 *
 */
public interface BUservice {

	public int insert(User user);

	public int insertSelective(User record);

	public int updateByPrimaryKeySelective(User record);

	public int updateByPrimaryKey(User record);

	public User selectByPrimaryKey(Integer userId);
	
	public int deleteByPrimaryKey(Integer userId);
	
	public List<User> getAllUser();
}
