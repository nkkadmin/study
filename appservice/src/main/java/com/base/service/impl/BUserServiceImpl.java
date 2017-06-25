package com.base.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.base.mapper.UserMapper;
import com.base.model.User;
import com.base.service.BUserService;

 
@Service("bUserService")
public class BUserServiceImpl extends BBaseServiceImpl<User> implements BUserService {
	
	@Resource
	private UserMapper userMapper;
	
	public User getUserByLoginName(String loginName) {
		return userMapper.getUserByLoginName(loginName);
	}
}
