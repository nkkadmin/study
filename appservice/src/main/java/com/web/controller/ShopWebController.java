package com.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.AjaxJson;
import com.base.commons.constant.MessageConstant;
import com.base.controller.BaseController;
import com.base.model.Page;
import com.base.model.Shop;
import com.base.service.BShopService;
import com.base.util.BeanHelper;

/**
 * 商品管理
 * 
 * @author xsx
 *
 */
@Controller
@RequestMapping("/shop")
public class ShopWebController extends BaseController {

	private static final String TABLENAME = "shop";
	
	@Resource
	private BShopService bShopService;

	final String UI_URL = "manager/shop";

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView loginUI() {
		return new ModelAndView(UI_URL + "/index");
	}

	@RequestMapping(value = "/addUI", method = RequestMethod.GET)
	public ModelAndView addUI() {
		return new ModelAndView(UI_URL + "/edit");
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/editUI", method = RequestMethod.GET)
	public ModelAndView editUI(Integer id) {
		ModelAndView mv = new ModelAndView(UI_URL + "/edit");
		try {
			Shop shop = bShopService.queryByPK(new Shop(), TABLENAME, id);
			mv.addObject("shop", shop);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}
	
	
	/**
	 * 获取商品列表
	 * 
	 * @return
	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST)
	@ResponseBody
	public Page<Shop> list(Page<Shop> page) {
		page.setPageNo(page.getPageNo() == 0 ? 1 : page.getPageNo());
		try {
			page = bShopService.queryForListAllPage(new Shop(), TABLENAME, page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return page;
	}
	
	/**
	 * 修改商品信息
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/updateByPK", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson updateByPK(Shop shop) {
		boolean isSuccess = true;
		String message = MessageConstant.UPDATE_SUCCESS;
		try {
			if (shop.getId() == null) {
				isSuccess = false;
				message = "参数不合法";
			} else {
				Map<String, Object> map = BeanHelper.objectToMap(shop);
				if (bShopService.updateByPK(map, TABLENAME) != 1) {
					isSuccess = false;
					message = MessageConstant.UPDATE_FALIL;
				}
			}
			return responseInfo(message, isSuccess);
		} catch (Exception e) {
			e.printStackTrace();
			return responseInfo("服务异常", false);
		}
	}

	/**
	 * 删除商品
	 * 
	 * @param loginName
	 * @return
	 */
	@RequestMapping(value = "/deleteByUserId", method = RequestMethod.GET)
	@ResponseBody
	public AjaxJson deleteByUserId(Integer id) {
		boolean isSuccess = true;
		String message = "删除成功";
		try {
			if (id == null) {
				isSuccess = false;
				message = "参数不合理!";
			} else {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("id", id);
				map.put("statu", "0"); // 不做物理删除，做标记删除
				bShopService.updateByPK(map, TABLENAME);
			}
			return responseInfo(message, isSuccess);
		} catch (Exception e) {
			e.printStackTrace();
			return responseInfo("服务异常", false);
		}
	}


}
