package com.web.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.base.mapper.UserMapper;
import com.base.model.User;
import com.web.service.IUserService;

@Service("userService")
public class UserService implements IUserService {

	@Resource
	private UserMapper userMapper;
	
	@Override
	public User getUserByLoginName(String loginName) {
		return userMapper.getUserByLoginName(loginName);
	}
}
