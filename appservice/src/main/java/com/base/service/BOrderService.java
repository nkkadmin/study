package com.base.service;

import com.base.model.Order;
import com.base.model.OrderCustom;
import com.base.model.Page;

/**
 * 订单service
 * 
 * @author xsx
 *
 */
public interface BOrderService extends BBaseService<Order> {

	/**
	 * 获取商家订单
	 * 
	 * @param busId
	 *            商家id
	 * @return
	 */
	public Page<OrderCustom> getOrderByBusId(Integer busId, Page<OrderCustom> page);

	/**
	 * 用户获取订单
	 * 
	 * @param userId
	 * @return
	 */
	public Page<OrderCustom> getShopByUserId(Integer userId, Page<OrderCustom> page);
}
