package com.app.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.base.model.OrderCustom;
import com.base.model.Page;
import com.base.service.BOrderService;

@Controller
@RequestMapping("/orderApp")
public class OrderAppController {

	@Resource
	private BOrderService bOrderService;

	/**
	 * 用户获取订单
	 * 
	 * @param userId
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getOrderByUserId")
	public Page<OrderCustom> getOrderByUserId(Integer userId,
			Page<OrderCustom> page) {
		System.out.println(userId);
		page.setPageNo(page.getPageNo() == 0 ? 1 : page.getPageNo());
		bOrderService.getShopByUserId(userId, page);
		return page;
	}
}
