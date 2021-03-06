package com.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.service.AddressAppService;
import com.base.commons.constant.MessageConstant;
import com.base.controller.BaseController;
import com.base.model.Address;
import com.base.model.AjaxJson;
import com.base.service.BAddressService;
import com.base.util.BeanHelper;
import com.base.util.DateHelper;

@Controller
@RequestMapping("/addressApp")
public class AddressAppController extends BaseController {
	
	final static String TABLENAME = "address";

	@Resource
	private BAddressService addressService;
	@Resource
	private AddressAppService addressAppService;

	/**
	 * 鏍规嵁鐢ㄦ埛id鑾峰彇鐢ㄦ埛鍦板潃
	 * 
	 * @param userId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getAddressByUserId", method = RequestMethod.GET)
	public AjaxJson getAddressByUserId(Integer userId) {
		List<Address> list = addressService.getAddressByUserId(userId);
		return responseInfo("鑾峰彇鎴愬姛", true, null, list);
	}
	
	/**
	 * 鏍规嵁鐢ㄦ埛id鑾峰彇榛樿鐨勫湴鍧�锛屽鏋滄病鏈夐粯璁ゅ湴鍧�锛岃繑鍥炵涓�鏉�
	 * 
	 * @param userId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getUserDefaultAddress", method = RequestMethod.POST)
	public Address getUserDefaultAddress() {
		Address address = addressAppService.getAddressByIsDefault(getCurrentUser().getId());
		if(address == null){
			List<Address> list = addressService.getAddressByUserId(getCurrentUser().getId());
			if(list != null && list.size() > 0){
				address = list.get(0);
			}
		}
		return address;
	}

	/**
	 * 娣诲姞鍦板潃
	 * 
	 * @param address
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/addAddress", method = RequestMethod.POST)
	public AjaxJson addAddress(Address address) {
		if (address == null || address.getAddress() == null || address.getReceiver() == null
				|| address.getReceiverphone() == null) {
			return responseInfo(MessageConstant.INPUT_HAS_NULL, false);
		}

		Address addr = null;
		if (address.getIsdefault().equals("1")) { // 璇存槑璁剧疆浜嗛粯璁わ紝闇�瑕佹妸鍘熸潵鐨勯粯璁ゅ幓鎺�
			addr = addressAppService.getAddressByIsDefault(getCurrentUser().getId());
		}
		try {
			address.setAddress(new String(address.getAddress().getBytes("ISO8859-1"), "UTF-8"));
			address.setReceiver(new String(address.getReceiver().getBytes("ISO8859-1"), "UTF-8"));
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		address.setUid(4); // TODO
		address.setStatu("1");
		address.setCreatetime(DateHelper.nowDate());
		Map<String, Object> map = BeanHelper.objectToMap(address);
		int num;
		try {
			num = addressService.insertData(map, TABLENAME);
			if (num == 1) {
				if (addr != null) {
					// 灏嗗師鏉ョ殑榛樿鍘绘帀
					addr.setIsdefault("0");
					Map<String, Object> oldMap = BeanHelper.objectToMap(addr);
					addressService.updateByPK(oldMap, addr.getId(), TABLENAME);
				}
				return responseInfo(MessageConstant.ADD_SUCCESS, true, null, null);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseInfo(MessageConstant.ADD_FALIL, false, null, null);
	}

	/**
	 * 鍒犻櫎鍦板潃
	 * 
	 * @param id
	 *            鍦板潃id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/deleteByPK", method = RequestMethod.GET)
	public AjaxJson deleteByPK(Integer id) {
		try {
			Map<String, Object> map = new HashMap();
			map.put("statu", "0");
			addressService.updateByPK(map, id, TABLENAME);
			return responseInfo(MessageConstant.DELETE_SUCCESS, true, null, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseInfo(MessageConstant.DELETE_FAIL, true, null, null);
	}
}
