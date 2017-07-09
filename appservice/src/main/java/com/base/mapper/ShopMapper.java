package com.base.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.base.model.Shop;

public interface ShopMapper {
     
	/**
	 * 
	 * @param userId
	 * @return
	 */
	public List<Shop> getShopByUserId(@Param("userId") Integer userId);
	
	/**
	 * 
	 * @param typeId
	 * @return
	 */
	public List<Shop> getShopByTypeId(@Param("typeId") Integer typeId);
}