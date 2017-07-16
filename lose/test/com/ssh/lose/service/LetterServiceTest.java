package com.ssh.lose.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LetterServiceTest {
	
	private ApplicationContext applicationContext;

	private LetterService letterService;

	{
		applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		letterService = (LetterService)applicationContext.getBean("letterService");
	}

	@Test
	public void testSave() {
		fail("Not yet implemented");
	}

	@Test
	public void testLoad() {
		System.out.println(letterService.load());
	}

	@Test
	public void testGet() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testLoadPage() {
		fail("Not yet implemented");
	}

	@Test
	public void testCount() {
		fail("Not yet implemented");
	}

}
