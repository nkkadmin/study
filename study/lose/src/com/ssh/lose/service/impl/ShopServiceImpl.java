package com.ssh.lose.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssh.lose.dao.ShopDAO;
import com.ssh.lose.po.Page;
import com.ssh.lose.po.Shop;
import com.ssh.lose.service.ShopService;


@Service
public class ShopServiceImpl implements ShopService {

	@Autowired
	private ShopDAO shopDAO;
	
	@Override
	public void save(Shop shop) {
		shopDAO.save(shop);
	}

	@Override
	public List<Shop> load() {
		return shopDAO.load();
	}

	@Override
	public Shop get(int id) {
		return shopDAO.get(id);
	}

	@Override
	public void delete(Shop shop) {
		shopDAO.delete(shop);
	}

	@Override
	public void update(Shop shop) {
		shopDAO.update(shop);
	}

	@Override
	public List<Shop> loadPage(Page page) {
		return shopDAO.loadPage(page);
	}

	@Override
	public int count() {
		return shopDAO.count();
	}

}
