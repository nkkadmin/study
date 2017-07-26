package com.ssh.lose.service;


import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssh.lose.po.Page;
import com.ssh.lose.po.User;
import com.ssh.lose.util.DateHelper;
import com.ssh.lose.util.StringHelper;

public class UserServiceTest {

	private ApplicationContext applicationContext;

	private UserService userService;

	{
		applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		userService = (UserService)applicationContext.getBean("userService");
		System.out.println("applicationContext:" + applicationContext + "//userService:" + userService);
	}

	@Test
	public void testSave() {
		User user = new User();
		user.setName("testcvcv");
		user.setPassword("123123");
		user.setTelphone("15821292493");
		user.setStatu("ÓÐÐ§");
		user.setCreate_time(DateHelper.getNowDate("yyyy-MM-dd HH:mm:ss"));
		userService.save(user);
	}
	
	@Test
	public void testList(){
		List<User> list = userService.load();
		System.out.println("list....>"+list);
		System.out.println(StringHelper.toJson(list));
	}
	
	@Test
	public void testGet(){
		System.out.println(userService.get(1));
	}

	@Test
	public void testLoad(){
		System.out.println(StringHelper.toJson(userService.load()));
	}
	
	@Test
	public void testDelete(){
		User user = userService.get(3);
		userService.delete(user);
	}
	
	@Test
	public void testUpdate(){
		User user = userService.get(4);
		user.setName("testUp");
		userService.update(user);
	}
	
	@Test
	public void testLoadPage(){
		List<User> ret = userService.loadPage(new Page(1, 10));
		int countSize = userService.count();
		Page page = new Page(1, 10, countSize, ret);
		System.out.println(StringHelper.toJson(page));
	}

}
