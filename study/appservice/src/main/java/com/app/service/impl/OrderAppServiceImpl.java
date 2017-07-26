package com.app.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.app.service.OrderAppService;
import com.base.mapper.OrderMapper;
import com.base.model.Order;


@Service("orderAppService")
public class OrderAppServiceImpl implements OrderAppService {
	
	@Resource
	private OrderMapper orderMapper;

	@Override
	public int insert(Order order) {
		return orderMapper.insert(order);
	}

}
