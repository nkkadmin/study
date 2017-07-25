package com.app.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.app.service.AddressAppService;
import com.base.mapper.AddressMapper;
import com.base.model.Address;


@Service("/addressAppService")
public class AddressAppServiceImpl implements AddressAppService {
	
	@Resource
	private AddressMapper addressMapper;

	@Override
	public Address getAddressByIsDefault() {
		return addressMapper.getAddressByIsDefault();
	}

	
}
