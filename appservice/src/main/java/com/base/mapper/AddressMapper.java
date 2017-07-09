package com.base.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.base.model.Address;

public interface AddressMapper {

	/**
	 * 用户获取配送地址
	 * 
	 * @param userId
	 * @return
	 */
	public List<Address> getAddressByUserId(@Param("userId") Integer userId);
}