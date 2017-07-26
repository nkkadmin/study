package com.ssh.lose.service;

import java.util.List;

import com.ssh.lose.po.Page;
import com.ssh.lose.po.Shop;

public interface ShopService {

	public void save(Shop shop);

	public List<Shop> load();

	public Shop get(int id);

	public void delete(Shop shop);

	public void update(Shop shop);

	// ����ҳ
	public List<Shop> loadPage(Page page);
	
	//�ܼ�¼��
	public int count();
}
