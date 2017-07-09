package com.base.service;

import com.base.model.Page;
import com.base.model.Shop;

public interface BShopService extends BBaseService<Shop> {

	/**
	 * 根据商家id获取商品
	 * 
	 * @param userId
	 *            用户id
	 * @return
	 */
	public Page<Shop> getShopByUserId(Integer userId, Page<Shop> page);

	/**
	 * 根据类型id获取商品
	 * 
	 * @param typeId
	 *            商品类型
	 * @return
	 */
	public Page<Shop> getShopByTypeId(Integer typeId, Page<Shop> page);

}
