package com.web.service;

import java.util.List;

import com.app.model.User;

public interface IUserService {

	public boolean addUser(User user);
	
	public boolean login(User user);
	
	public List<User> userList();
	
	public User getUserByLoginName(String loginName);
	
	public User updateUser(User user);
}
