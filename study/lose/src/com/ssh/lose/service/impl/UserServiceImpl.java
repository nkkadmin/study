package com.ssh.lose.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssh.lose.dao.UserDAO;
import com.ssh.lose.po.Page;
import com.ssh.lose.po.User;
import com.ssh.lose.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	@Override
	public void save(User user) {
		userDAO.save(user);
	}

	@Override
	public List<User> load() {
		return userDAO.load();
	}

	@Override
	public User get(int id) {
		return userDAO.get(id);
	}

	@Override
	public void delete(User user) {
		userDAO.delete(user);
	}

	@Override
	public void update(User user) {
		userDAO.update(user);
	}

	@Override
	public List<User> loadPage(Page page) {
		return userDAO.loadPage(page);
	}

	@Override
	public int count() {
		return userDAO.count();
	}

	@Override
	public User login(String name, String password) {
		return userDAO.login(name,password);
	}



}
