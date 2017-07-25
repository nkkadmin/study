package com.app.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.base.model.Page;
import com.base.model.Shop;
import com.base.service.BShopService;

/**
 * 商品Controller
 * @author xsx
 *
 */
@Controller
@RequestMapping("/shopApp")
public class ShopAppController {
	
	final String TABLENAME = "shop";

	@Resource
	private BShopService bShopService;

	/**
	 * 用户获取订单
	 * 
	 * @param userId
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/queryAllShop")
	public Page<Shop> queryAllShop(Page<Shop> page) {
		page.setPageNo(page.getPageNo() == 0 ? 1 : page.getPageNo());
		System.out.println(page.getPageNo());
		try {
			bShopService.queryForListAllPage(new Shop(), TABLENAME, page);
			return page;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * 获取shop
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/queryShopByPK")
	public Shop queryShopByPK(Integer id) {
		try {
			Shop shop = bShopService.queryByPK(new Shop(), TABLENAME, id);
			return shop;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
