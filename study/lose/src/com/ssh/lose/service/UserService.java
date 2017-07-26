package com.ssh.lose.service;

import java.util.List;

import com.ssh.lose.po.Page;
import com.ssh.lose.po.User;

public interface UserService {

	public void save(User user);

	public List<User> load();

	public User get(int id);

	public void delete(User user);

	public void update(User user);

	// ����ҳ
	public List<User> loadPage(Page page);
	
	//�ܼ�¼��
	public int count();
	
	public User login(String name,String password);
}