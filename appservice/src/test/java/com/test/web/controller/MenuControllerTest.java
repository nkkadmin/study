package com.test.web.controller;

import javax.servlet.ServletContext;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.web.controller.MenuWebController;

@RunWith(SpringJUnit4ClassRunner.class)
// 此处调用Spring单元测试类
@WebAppConfiguration
// 调用javaWEB的组件，比如自动注入ServletContext Bean等等
@ContextConfiguration(locations = { "classpath:application.xml",
		"classpath:spring-servlet.xml" })
// 加载Spring配置文件
public class MenuControllerTest {

	@Autowired
	private MenuWebController menuWebController;

	MockMvc mockMvc;

	@Autowired
	ServletContext context;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(menuWebController).build();
	}

	@org.junit.Test
	public void addMenu() throws Exception {

		// 准备参数
		String content = "{\"name\":\"用户管理\",\"url\":\"/user/userlist.do\",\"statu\":\"1\"}";
		// 发送请求
		ResultActions resultActions = this.mockMvc
				.perform(MockMvcRequestBuilders.post("/menu/addMenu.do")
						.accept(MediaType.APPLICATION_JSON)
						.param("menu", content));
		MvcResult mvcResult = resultActions.andReturn();
		String result = mvcResult.getResponse().getContentAsString();
		System.out.println("返回数据：" + result);
	}

}
