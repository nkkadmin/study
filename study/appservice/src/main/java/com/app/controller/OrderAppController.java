package com.app.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.service.OrderAppService;
import com.base.commons.constant.MessageConstant;
import com.base.commons.constant.OrderConstant;
import com.base.controller.BaseController;
import com.base.model.AjaxJson;
import com.base.model.Order;
import com.base.model.OrderCustom;
import com.base.model.Page;
import com.base.service.BOrderService;
import com.base.util.DateHelper;

@Controller
@RequestMapping("/orderApp")
public class OrderAppController extends BaseController {

	@Resource
	private BOrderService bOrderService;
	@Resource
	private OrderAppService orderAppService;
	
	private static String TABLENAME = "xsxteam.order";

	/**
	 * 用户获取订单
	 * 
	 * @param userId
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getOrderByUserId")
	public Page<OrderCustom> getOrderByUserId(Page<OrderCustom> page) {
		page.setPageNo(page.getPageNo() == 0 ? 1 : page.getPageNo());
		bOrderService.getShopByUserId(getCurrentUser().getId(), page);
		return page;
	}
	
	
	/**
	 * 立即下单
	 * @param order
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/createOrder",method=RequestMethod.POST)
	public AjaxJson createOrder(Order order){
		try {
			order.setStatu(OrderConstant.ORDER_CREATE);
			order.setUid(getCurrentUser().getId());
			order.setCreatetime(DateHelper.nowDate());
			if(order.getSid() == null || order.getUid() == null || order.getPaynum() == null || order.getDeliveryaddressid() == null){
				return responseInfo(MessageConstant.ORDER_CREATE_FAIL, false);
			}
			int num = orderAppService.insert(order);
			if(num > 0){
				return responseInfo(MessageConstant.ORDER_CREATE_SUCCESS, true,order.getId());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseInfo(MessageConstant.ORDER_CREATE_FAIL, false);
	}
	
	/**
	 * 付款
	 * @param order
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/pay",method=RequestMethod.POST)
	public AjaxJson pay(Integer orderId){
		Map<String,Object> map = new HashMap();
		map.put("statu", OrderConstant.ORDER_PAY);
		try {
			int num = bOrderService.updateByPK(map, orderId, TABLENAME);
			if(num > 0){
				return responseInfo(MessageConstant.ORDER_PAY_SUCCESS, true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseInfo(MessageConstant.ORDER_PAY_FAIL, true);
	}
}
