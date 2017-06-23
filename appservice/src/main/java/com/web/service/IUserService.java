package com.web.service;

import com.base.model.User;

public interface IUserService {

	public User getUserByLoginName(String loginName);
	
}
