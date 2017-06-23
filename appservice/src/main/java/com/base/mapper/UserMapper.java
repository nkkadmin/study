package com.base.mapper;

import org.apache.ibatis.annotations.Param;

import com.base.model.User;


public interface UserMapper {
  
	public User getUserByLoginName(@Param("loginName") String loginName);
}