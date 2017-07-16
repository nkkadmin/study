package com.ssh.lose.dao;

import java.util.List;

import com.ssh.lose.po.Page;

public interface BaseDAO<T> {

	//保存
	public void save(T t);
	
	//根据id查询
	public T get(int id);
	
	//获取全部数据
	public List<T> load();
	
	//根据id删除
	public void delete(T t);
	
	//修改
	public void update(T t);
	
	//带分页
	public List<T> loadPage(Page page);
	//总记录数
	public int count();
}
