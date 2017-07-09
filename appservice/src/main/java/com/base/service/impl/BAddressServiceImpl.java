package com.base.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.base.mapper.AddressMapper;
import com.base.model.Address;
import com.base.service.BAddressService;

@Service("bAddressService")
public class BAddressServiceImpl extends BBaseServiceImpl<Address> implements
		BAddressService {

	@Resource
	private AddressMapper addressMapper;

	@Override
	public List<Address> getAddressByUserId(Integer userId) {
		if (userId == null)
			return null;
		return addressMapper.getAddressByUserId(userId);
	}

}
