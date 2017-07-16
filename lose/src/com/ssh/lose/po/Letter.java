package com.ssh.lose.po;

/**
 * ¸ÐÐ»ÐÅ
 * @author xsx
 *
 */
public class Letter {

	private int id;
	private int user_id;
	private String title;
	private String toname;
	private String thankinfo;
	private String create_time;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getToname() {
		return toname;
	}
	public void setToname(String toname) {
		this.toname = toname;
	}
	public String getThankinfo() {
		return thankinfo;
	}
	public void setThankinfo(String thankinfo) {
		this.thankinfo = thankinfo;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	
}
