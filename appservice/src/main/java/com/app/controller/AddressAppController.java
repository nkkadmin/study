package com.app.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.model.AjaxJson;
import com.base.controller.BaseController;
import com.base.model.Address;
import com.base.service.BAddressService;
import com.base.util.BeanHelper;
import com.base.util.DateHelper;

@Controller
@RequestMapping("/addressApp")
public class AddressAppController extends BaseController {

	final static String TABLENAME = "address";

	@Resource
	private BAddressService addressService;

	/**
	 * 根据用户id获取用户地址
	 * 
	 * @param userId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getAddressByUserId", method = RequestMethod.GET)
	public AjaxJson getAddressByUserId(Integer userId) {
		List<Address> list = addressService.getAddressByUserId(userId);
		return responseInfo("获取成功", true, null, list);
	}

	/**
	 * 添加地址
	 * @param address
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getAddressByUserId", method = RequestMethod.POST)
	public AjaxJson addAddress(Address address) {
		if (address == null || address.getUid() == null
				|| address.getAddress() == null) {
			return responseInfo("存在为空的数据，请认真填写后提交！", false);
		}
		Map<String, Object> map = BeanHelper.objectToMap(address);
		address.setStatu("1");
		address.setCreatetime(DateHelper.nowDate());
		int num;
		try {
			num = addressService.insertData(map, TABLENAME);
			if (num == 1) {
				return responseInfo("地址添加成功", true, null, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseInfo("地址添加失败", false, null, null);

	}
}
