package com.base.mapper;

import org.apache.ibatis.annotations.Param;

import com.base.model.User;

public interface UserMapper {
	/**
	 * 根据登录名查询
	 * @param loginName
	 * @return
	 */
	public User getUserByLoginName(@Param("loginName") String loginName);
}