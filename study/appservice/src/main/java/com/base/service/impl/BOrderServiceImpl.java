package com.base.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.base.mapper.OrderMapper;
import com.base.model.Order;
import com.base.model.OrderCustom;
import com.base.model.Page;
import com.base.service.BOrderService;

@Service("bOrderService")
public class BOrderServiceImpl extends BBaseServiceImpl<Order> implements
		BOrderService {

	@Resource
	private OrderMapper orderMapper;

	@Override
	public Page<OrderCustom> getOrderByBusId(Integer busId,
			Page<OrderCustom> page) {
		if (busId == null)
			return null;
		List<OrderCustom> orders = orderMapper.getOrderByBusId(busId,page);
		page.setRows(orders);
		return page;
	}

	@Override
	public Page<OrderCustom> getShopByUserId(Integer userId,
			Page<OrderCustom> page) {
		if (userId == null)
			return null;
		List<OrderCustom> orders = orderMapper.getShopByUserId(userId);
		page.setRows(orders);
		return page;
	}

}
