package com.base.model;

public class Menu {
    private Integer id;

    private String name;

    private String url;

    private String commont;
    
    private String statu;

    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column menu.id
     *
     * @param id the value for menu.id
     *
     * @mbggenerated Tue Jun 27 13:46:53 CST 2017
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column menu.name
     *
     * @return the value of menu.name
     *
     * @mbggenerated Tue Jun 27 13:46:53 CST 2017
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column menu.name
     *
     * @param name the value for menu.name
     *
     * @mbggenerated Tue Jun 27 13:46:53 CST 2017
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column menu.url
     *
     * @return the value of menu.url
     *
     * @mbggenerated Tue Jun 27 13:46:53 CST 2017
     */
    public String getUrl() {
        return url;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column menu.url
     *
     * @param url the value for menu.url
     *
     * @mbggenerated Tue Jun 27 13:46:53 CST 2017
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column menu.commont
     *
     * @return the value of menu.commont
     *
     * @mbggenerated Tue Jun 27 13:46:53 CST 2017
     */
    public String getCommont() {
        return commont;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column menu.commont
     *
     * @param commont the value for menu.commont
     *
     * @mbggenerated Tue Jun 27 13:46:53 CST 2017
     */
    public void setCommont(String commont) {
        this.commont = commont;
    }

	public String getStatu() {
		return statu;
	}

	public void setStatu(String statu) {
		this.statu = statu;
	}
    
}