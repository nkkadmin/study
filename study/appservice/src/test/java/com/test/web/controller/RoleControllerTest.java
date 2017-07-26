package com.test.web.controller;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.base.util.DateHelper;
import com.web.controller.UserWebController;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"classpath:spring-servlet.xml","classpath:application.xml"})
public class RoleControllerTest {

	
	@Resource
	private UserWebController userWebController;
	
	MockMvc mockMvc; //springmvc提供Controller的测试类
	
	
	@Before
	public void setup(){
		mockMvc = MockMvcBuilders.standaloneSetup(userWebController).build();
	}
	
	@Test
	public void addUser() throws Exception{
		String jsonStr = "{\"name\":\"ceshi\",\"createtime\":'"+DateHelper.nowDate()+"',\"statu\":\"1\"}";
		ResultActions resultActions = this.mockMvc.perform(MockMvcRequestBuilders.post("/user/addUser.do").accept(MediaType.APPLICATION_JSON).param("user",jsonStr));
		MvcResult mvcResult = resultActions.andReturn();
		String result = mvcResult.getResponse().getContentAsString();
		System.out.println(result);
	}
}
