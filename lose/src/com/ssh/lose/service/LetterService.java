package com.ssh.lose.service;

import java.util.List;

import com.ssh.lose.po.Letter;
import com.ssh.lose.po.Page;

public interface LetterService {

	public void save(Letter letter);

	public List<Letter> load();

	public Letter get(int id);

	public void delete(Letter letter);

	public void update(Letter letter);

	// 带分页
	public List<Letter> loadPage(Page page);
	
	//总记录数
	public int count();
}
