package com.app.service;

import com.base.model.Address;

public interface AddressAppService {

	/**
	 * 获取默认地址
	 * @return
	 */
	public Address getAddressByIsDefault(Integer userId);
}
