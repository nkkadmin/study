package com.base.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.base.model.OrderCustom;
import com.base.model.Page;

public interface OrderMapper {

	/**
	 * 获取商家订单
	 * 
	 * @param busId
	 *            商家id
	 * @return
	 */
	public List<OrderCustom> getOrderByBusId(@Param("busId") Integer busId,Page<OrderCustom> page);

	/**
	 * 用户获取订单
	 * 
	 * @param userId
	 * @return
	 */
	public List<OrderCustom> getShopByUserId(@Param("userId") Integer userId);

}