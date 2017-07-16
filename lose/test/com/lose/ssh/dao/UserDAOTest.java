package com.lose.ssh.dao;

import org.junit.Test;

import com.ssh.lose.dao.UserDAO;
import com.ssh.lose.dao.impl.UserDAOImpl;
import com.ssh.lose.po.User;
import com.ssh.lose.util.DateHelper;

public class UserDAOTest {

	@Test
	public void testSave() {
		User user = new User();
		user.setName("testss");
		user.setPassword("123");
		user.setTelphone("15821292493");
		user.setStatu("ÓÐÐ§");
		user.setCreate_time(DateHelper.getNowDate("yyyy-MM-dd HH:mm:ss"));
		UserDAO dao = new UserDAOImpl();
		dao.save(user);
	}

}
