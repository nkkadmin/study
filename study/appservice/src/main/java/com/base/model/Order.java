package com.base.model;

public class Order {
    private Integer id;
    private Integer uid;

    private Integer sid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order.deliveryaddressid
     *
     * @mbggenerated Tue Jun 27 13:46:53 CST 2017
     */
    private Integer deliveryaddressid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order.createtime
     *
     * @mbggenerated Tue Jun 27 13:46:53 CST 2017
     */
    private String createtime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order.statu
     *
     * @mbggenerated Tue Jun 27 13:46:53 CST 2017
     */
    private String statu;
    
    private Integer paynum;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order.id
     *
     * @return the value of order.id
     *
     * @mbggenerated Tue Jun 27 13:46:53 CST 2017
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order.id
     *
     * @param id the value for order.id
     *
     * @mbggenerated Tue Jun 27 13:46:53 CST 2017
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order.uid
     *
     * @return the value of order.uid
     *
     * @mbggenerated Tue Jun 27 13:46:53 CST 2017
     */
    public Integer getUid() {
        return uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order.uid
     *
     * @param uid the value for order.uid
     *
     * @mbggenerated Tue Jun 27 13:46:53 CST 2017
     */
    public void setUid(Integer uid) {
        this.uid = uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order.sid
     *
     * @return the value of order.sid
     *
     * @mbggenerated Tue Jun 27 13:46:53 CST 2017
     */
    public Integer getSid() {
        return sid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order.sid
     *
     * @param sid the value for order.sid
     *
     * @mbggenerated Tue Jun 27 13:46:53 CST 2017
     */
    public void setSid(Integer sid) {
        this.sid = sid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order.deliveryaddressid
     *
     * @return the value of order.deliveryaddressid
     *
     * @mbggenerated Tue Jun 27 13:46:53 CST 2017
     */
    public Integer getDeliveryaddressid() {
        return deliveryaddressid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order.deliveryaddressid
     *
     * @param deliveryaddressid the value for order.deliveryaddressid
     *
     * @mbggenerated Tue Jun 27 13:46:53 CST 2017
     */
    public void setDeliveryaddressid(Integer deliveryaddressid) {
        this.deliveryaddressid = deliveryaddressid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order.createtime
     *
     * @return the value of order.createtime
     *
     * @mbggenerated Tue Jun 27 13:46:53 CST 2017
     */
    public String getCreatetime() {
        return createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order.createtime
     *
     * @param createtime the value for order.createtime
     *
     * @mbggenerated Tue Jun 27 13:46:53 CST 2017
     */
    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order.statu
     *
     * @return the value of order.statu
     *
     * @mbggenerated Tue Jun 27 13:46:53 CST 2017
     */
    public String getStatu() {
        return statu;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order.statu
     *
     * @param statu the value for order.statu
     *
     * @mbggenerated Tue Jun 27 13:46:53 CST 2017
     */
    public void setStatu(String statu) {
        this.statu = statu;
    }

	public Integer getPaynum() {
		return paynum;
	}

	public void setPaynum(Integer paynum) {
		this.paynum = paynum;
	}
    
    
}