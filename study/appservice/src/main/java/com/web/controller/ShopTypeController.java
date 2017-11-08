package com.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.base.commons.constant.MessageConstant;
import com.base.controller.BaseController;
import com.base.model.AjaxJson;
import com.base.model.Page;
import com.base.model.ShopType;
import com.base.service.BShopTypeService;
import com.base.util.BeanHelper;
import com.base.util.StringHelper;

/**
 * 商品类型Controller
 * 
 * @author xsx
 *
 */
@Controller
@RequestMapping("/shopType")
public class ShopTypeController extends BaseController {

	final static String UI_URL = "manager/Shop";

	@Resource
	private BShopTypeService bShopTypeService;

	private static final String TABLENAME = "shoptype";

	/**
	 * 跳转商品类型列表页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView loginUI() {
		return new ModelAndView(UI_URL + "typeList");
	}

	/**
	 * 跳转商品类型添加
	 * 
	 * @return
	 */
	@RequestMapping(value = "/addUI", method = RequestMethod.GET)
	public ModelAndView addUserUI() {
		return new ModelAndView(UI_URL + "/typeAdd");
	}

	/**
	 * 跳转商品类型修改页面
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/editUI", method = RequestMethod.GET)
	public ModelAndView editUI(Integer id) {
		ModelAndView mv = new ModelAndView(UI_URL + "/typeAdd");
		try {
			ShopType shopType = bShopTypeService.queryByPK(new ShopType(),
					TABLENAME, id);
			mv.addObject("shopType", shopType);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mv;
	}

	/**
	 * 获取全部商品类型
	 * @param page
	 * @param name
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/queryAllShopType", method = RequestMethod.POST)
	public Page<ShopType> queryAllShopType(Page<ShopType> page,String name) {
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("tableName", TABLENAME);
			if(!StringHelper.isEmpty(name)){
				map.put("name", name);
			}
			return bShopTypeService.queryForListAllPage(new ShopType(), map, page);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 修改
	 * @param shopType
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public AjaxJson update(ShopType shopType) {
		if (shopType == null || shopType.getId() == null
				|| shopType.getName() == null) {
			return responseInfo(MessageConstant.INPUT_HAS_NULL, false);
		}
		try {
			Map<String, Object> map = BeanHelper.objectToMap(shopType);
			int num = bShopTypeService.updateByPK(map,shopType.getId(), TABLENAME);
			if (num == 1)
				return responseInfo(MessageConstant.UPDATE_SUCCESS, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseInfo(MessageConstant.UPDATE_FALIL, false);
	}
}
