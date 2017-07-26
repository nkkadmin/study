package com.base.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.base.mapper.ShopMapper;
import com.base.model.Page;
import com.base.model.Shop;
import com.base.service.BShopService;

@Service("bShopService")
public class BShopServiceImpl extends BBaseServiceImpl<Shop> implements
		BShopService {

	@Resource
	private ShopMapper shopMapper;

	@Override
	public Page<Shop> getShopByUserId(Integer userId, Page<Shop> page) {
		if (userId == null)
			return null;
		shopMapper.getShopByUserId(userId);
		return page;
	}

	@Override
	public Page<Shop> getShopByTypeId(Integer typeId, Page<Shop> page) {
		if (typeId == null)
			return null;
		shopMapper.getShopByTypeId(typeId);
		return page;
	}

}
