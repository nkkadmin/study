package com.ssh.lose.dao;

import com.ssh.lose.po.User;

public interface UserDAO extends BaseDAO<User> {

	User login(String name, String password);
	
}
