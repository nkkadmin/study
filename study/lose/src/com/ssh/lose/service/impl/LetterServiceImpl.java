package com.ssh.lose.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssh.lose.dao.LetterDAO;
import com.ssh.lose.po.Letter;
import com.ssh.lose.po.Page;
import com.ssh.lose.service.LetterService;

@Service("letterService")
public class LetterServiceImpl implements LetterService {

	@Autowired
	private LetterDAO letterDAO;
	
	@Override
	public void save(Letter letter) {
		letterDAO.save(letter);
	}

	@Override
	public List<Letter> load() {
		return letterDAO.load();
	}

	@Override
	public Letter get(int id) {
		return letterDAO.get(id);
	}

	@Override
	public void delete(Letter letter) {
		letterDAO.delete(letter);
	}

	@Override
	public void update(Letter letter) {
		letterDAO.update(letter);
	}

	@Override
	public List<Letter> loadPage(Page page) {
		return letterDAO.loadPage(page);
	}

	@Override
	public int count() {
		return letterDAO.count();
	}

}
