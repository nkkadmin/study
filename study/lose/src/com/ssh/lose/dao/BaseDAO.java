package com.ssh.lose.dao;

import java.util.List;

import com.ssh.lose.po.Page;

public interface BaseDAO<T> {

	//����
	public void save(T t);
	
	//����id��ѯ
	public T get(int id);
	
	//��ȡȫ������
	public List<T> load();
	
	//����idɾ��
	public void delete(T t);
	
	//�޸�
	public void update(T t);
	
	//����ҳ
	public List<T> loadPage(Page page);
	//�ܼ�¼��
	public int count();
}
