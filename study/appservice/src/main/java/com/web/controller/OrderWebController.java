package com.web.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.base.model.OrderCustom;
import com.base.model.Page;
import com.base.service.BOrderService;

/**
 * 订单Controller
 * 
 * @author xsx
 *
 */
@Controller
@RequestMapping("/order")
public class OrderWebController {

	@Resource
	private BOrderService bOrderService;

	
	/**
	 * 商家获取订单
	 * @param busId
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getOrderByBusId")
	public Page<OrderCustom> getOrderByBusId(Integer busId,
			Page<OrderCustom> page) {
		page.setPageNo(page.getPageNo() == 0 ? 1 : page.getPageNo());
		bOrderService.getOrderByBusId(busId, page);
		return page;
	}
	
}
