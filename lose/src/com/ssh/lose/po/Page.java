package com.ssh.lose.po;

import java.util.List;

/**
 * 分页实体类封装
 * 
 * @author xsx
 *
 */
public class Page {

	private int pageCount; // 共几页
	private int inPage; // 当前页
	private int pageSize; // 每页显示几条数据
	private int countSize; // 共几条记录
	private List list;

	public Page(int inPage, int pageSize) {
		this.inPage = (inPage - 1) * 10;
		this.pageSize = pageSize;
	}

	public Page(int inPage, int pageSize, int countSize, List list) {
		this.inPage = inPage;
		this.pageSize = pageSize;
		this.countSize = countSize;
		this.list = list;
		if (countSize % pageSize == 0) {
			this.pageCount = countSize / pageSize;
		} else {
			this.pageCount = (countSize / pageSize) + 1;
		}
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getInPage() {
		return inPage;
	}

	public void setInPage(int inPage) {
		this.inPage = inPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCountSize() {
		return countSize;
	}

	public void setCountSize(int countSize) {
		this.countSize = countSize;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}
}
