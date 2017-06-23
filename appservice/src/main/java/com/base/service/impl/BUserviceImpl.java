package com.base.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.base.mapper.UserMapper;
import com.base.model.User;
import com.base.service.BUservice;


@Service("bUservice")
public class BUserviceImpl extends BBaseServiceImpl<User> implements BUservice {
	
	@Resource
	private UserMapper userMapper;

	@Override
	public User quertByLoginName(String loginName) {
		// TODO Auto-generated method stub
		return null;
	}

}
