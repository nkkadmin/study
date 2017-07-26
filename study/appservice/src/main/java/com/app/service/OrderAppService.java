package com.app.service;

import org.apache.ibatis.annotations.Param;

import com.base.model.Order;

public interface OrderAppService {

	/**
	 * 添加订单，返回当前插入数据的订单号
	 * @param order
	 * @return
	 */
	public int insert(@Param("order") Order order);
}
