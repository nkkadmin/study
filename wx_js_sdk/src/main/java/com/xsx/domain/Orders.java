package com.xsx.domain;

public class Orders {
	private Integer id;

	private String receiptname;
	private String receiptphone;

	private String receiptaddress;

	private Integer phonepaytypeid;

	private Integer empid;

	private String shopname;

	private String createdate;

	private Integer statu;

	private String empName;
	
	private String clientip;

	public Integer getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column orders.id
	 *
	 * @param id
	 *            the value for orders.id
	 *
	 * @mbggenerated Tue Oct 31 11:27:22 CST 2017
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column orders.receiptname
	 *
	 * @return the value of orders.receiptname
	 *
	 * @mbggenerated Tue Oct 31 11:27:22 CST 2017
	 */
	public String getReceiptname() {
		return receiptname;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column orders.receiptname
	 *
	 * @param receiptname
	 *            the value for orders.receiptname
	 *
	 * @mbggenerated Tue Oct 31 11:27:22 CST 2017
	 */
	public void setReceiptname(String receiptname) {
		this.receiptname = receiptname;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column orders.receiptphone
	 *
	 * @return the value of orders.receiptphone
	 *
	 * @mbggenerated Tue Oct 31 11:27:22 CST 2017
	 */
	public String getReceiptphone() {
		return receiptphone;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column orders.receiptphone
	 *
	 * @param receiptphone
	 *            the value for orders.receiptphone
	 *
	 * @mbggenerated Tue Oct 31 11:27:22 CST 2017
	 */
	public void setReceiptphone(String receiptphone) {
		this.receiptphone = receiptphone;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column orders.receiptaddress
	 *
	 * @return the value of orders.receiptaddress
	 *
	 * @mbggenerated Tue Oct 31 11:27:22 CST 2017
	 */
	public String getReceiptaddress() {
		return receiptaddress;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column orders.receiptaddress
	 *
	 * @param receiptaddress
	 *            the value for orders.receiptaddress
	 *
	 * @mbggenerated Tue Oct 31 11:27:22 CST 2017
	 */
	public void setReceiptaddress(String receiptaddress) {
		this.receiptaddress = receiptaddress;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column orders.phonepaytypeid
	 *
	 * @return the value of orders.phonepaytypeid
	 *
	 * @mbggenerated Tue Oct 31 11:27:22 CST 2017
	 */
	public Integer getPhonepaytypeid() {
		return phonepaytypeid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column orders.phonepaytypeid
	 *
	 * @param phonepaytypeid
	 *            the value for orders.phonepaytypeid
	 *
	 * @mbggenerated Tue Oct 31 11:27:22 CST 2017
	 */
	public void setPhonepaytypeid(Integer phonepaytypeid) {
		this.phonepaytypeid = phonepaytypeid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column orders.empid
	 *
	 * @return the value of orders.empid
	 *
	 * @mbggenerated Tue Oct 31 11:27:22 CST 2017
	 */
	public Integer getEmpid() {
		return empid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column orders.empid
	 *
	 * @param empid
	 *            the value for orders.empid
	 *
	 * @mbggenerated Tue Oct 31 11:27:22 CST 2017
	 */
	public void setEmpid(Integer empid) {
		this.empid = empid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column orders.shopid
	 *
	 * @return the value of orders.shopid
	 *
	 * @mbggenerated Tue Oct 31 11:27:22 CST 2017
	 */
	public String getShopname() {
		return shopname;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column orders.shopid
	 *
	 * @param shopid
	 *            the value for orders.shopid
	 *
	 * @mbggenerated Tue Oct 31 11:27:22 CST 2017
	 */
	public void setShopname(String shopname) {
		this.shopname = shopname;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column orders.createDate
	 *
	 * @return the value of orders.createDate
	 *
	 * @mbggenerated Tue Oct 31 11:27:22 CST 2017
	 */
	public String getCreatedate() {
		return createdate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column orders.createDate
	 *
	 * @param createdate
	 *            the value for orders.createDate
	 *
	 * @mbggenerated Tue Oct 31 11:27:22 CST 2017
	 */
	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the
	 * value of the database column orders.statu
	 *
	 * @return the value of orders.statu
	 *
	 * @mbggenerated Tue Oct 31 11:27:22 CST 2017
	 */
	public Integer getStatu() {
		return statu;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the
	 * value of the database column orders.statu
	 *
	 * @param statu
	 *            the value for orders.statu
	 *
	 * @mbggenerated Tue Oct 31 11:27:22 CST 2017
	 */
	public void setStatu(Integer statu) {
		this.statu = statu;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getClientip() {
		return clientip;
	}

	public void setClientip(String clientip) {
		this.clientip = clientip;
	}
}