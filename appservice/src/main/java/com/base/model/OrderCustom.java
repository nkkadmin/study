package com.base.model;

/**
 * 订单实体扩展类
 * 
 * @author xsx
 *
 */
public class OrderCustom extends Order {

	// 商品id
	private Integer shipId;
	// 商品名称
	private String shopName;
	// 商品图片
	private String shipImg;
	// 价格
	private double price;
	// 折扣价
	private double discountPrice;
	// 商品分类
	private Integer typeId;
	public Integer getShipId() {
		return shipId;
	}
	public void setShipId(Integer shipId) {
		this.shipId = shipId;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getShipImg() {
		return shipImg;
	}
	public void setShipImg(String shipImg) {
		this.shipImg = shipImg;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getDiscountPrice() {
		return discountPrice;
	}
	public void setDiscountPrice(double discountPrice) {
		this.discountPrice = discountPrice;
	}
	public Integer getTypeId() {
		return typeId;
	}
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

}
