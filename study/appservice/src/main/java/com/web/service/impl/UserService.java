package com.web.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.app.model.User;
import com.base.util.PropertisHelper;
import com.web.service.IUserService;

@Service("userService")
public class UserService implements IUserService {

	private static final String fileName = "dataMap.properties";
	
	@Override
	public boolean addUser(User user) {
		String key = user.getLoginName();
		String value = user.getLoginName() + ";" + user.getPassword() + ";" + user.getUsername() + ";" + user.getSex() + ";" + user.getAge();
		return PropertisHelper.writer(key, value, fileName);
	}

	@Override
	public boolean login(User user) {
		String value = PropertisHelper.read(fileName, user.getLoginName());
		if(value != null){
			String password = value.split(";")[1];
			if(user.getPassword().equals(password)){
				return true;
			}
		}
		return false;
	}

	@Override
	public List<User> userList() {
		String[] values = PropertisHelper.readAll(fileName);
		List<User> list = new ArrayList<>();
		User user = null;
		for(String str : values){
			user = new User();
			String[] s = str.split(";");
			user.setLoginName(s[0]);
			user.setPassword(s[1]);
			user.setUsername(s[2]);
			user.setSex(s[3]);
			user.setAge(Integer.parseInt(s[4]));
			list.add(user);
		}
		return list;
	}

	@Override
	public User getUserByLoginName(String loginName) {
		String value = PropertisHelper.read(fileName, loginName);
		if(value != null){
			User user = new User();
			String[] s = value.split(";");
			user.setLoginName(s[0]);
			user.setPassword(s[1]);
			user.setUsername(s[2]);
			user.setSex(s[3]);
			user.setAge(Integer.parseInt(s[4]));
			return user;
		}
		return null;
	}

	@Override
	public User updateUser(User user) {
		String value = PropertisHelper.read(fileName, user.getLoginName());
		if(value == null){
			return null;
		}else{
			String key = user.getLoginName();
			String valueUpdate = user.getLoginName() + ";" + user.getPassword() + ";" + user.getUsername() + ";" + user.getSex() + ";" + user.getAge();
			boolean b =  PropertisHelper.writer(key, valueUpdate, fileName);
			if(b){
				return user;
			}
		}
		return null;
	}

}
