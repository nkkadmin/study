package com.base.service;

import java.util.List;

import com.base.model.Address;

public interface BAddressService extends BBaseService<Address>{
	
	/**
	 * 用户获取配送地址
	 * @param userId
	 * @return
	 */
	public List<Address> getAddressByUserId(Integer userId);
}
