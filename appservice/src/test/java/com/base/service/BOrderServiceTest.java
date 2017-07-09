package com.base.service;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.base.model.OrderCustom;
import com.base.model.Page;

/**
 * 订单单元测试
 * @author xsx
 *
 */
@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations = {"classpath:application.xml","classpath:spring-servlet.xml"}) 
public class BOrderServiceTest {
	
	@Autowired
	private BOrderService orderService;
	
	@Test
	public void getOrderByBusId(){
		Page<OrderCustom> page = new Page<OrderCustom>();
		page.setPageNo(1);
		Integer busId = 14;
		page = orderService.getOrderByBusId(busId, page);
		System.out.println(page);
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
