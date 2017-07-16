package com.ssh.lose.po;

import java.util.List;

/**
 * ��ҳʵ�����װ
 * 
 * @author xsx
 *
 */
public class Page {

	private int pageCount; // ����ҳ
	private int inPage; // ��ǰҳ
	private int pageSize; // ÿҳ��ʾ��������
	private int countSize; // ��������¼
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
