package com.base.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.base.mapper.BaseMapper;
import com.base.myException.CustomException;
import com.base.service.BBaseService;
import com.base.util.BeanHelper;

/**
 * 公共service
 * @author xsx
 *
 * @param <T>
 */
public class BBaseServiceImpl<T> implements BBaseService<T> {

	@Resource
	private BaseMapper baseMappper;

	public T queryByPK(T t, String tableName, Integer pk) throws Exception {
		if (t == null || tableName == null || pk == null) {
			throw new CustomException("存在为空的参数：【t】：" + t + ",【tableName】：" + tableName + ",【pk】:" + pk);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("tableName", tableName);
		map.put("id", pk);
		Map<String, Object> resultMap = baseMappper.queryByPK(map);
		t = (T) BeanHelper.mapToObjectReflect(resultMap, t.getClass());
		return t;
	}

	public List<T> queryForListAll(T t, String tableName) throws Exception {
		if (t == null || tableName == null) {
			throw new CustomException("存在为空的参数：【t】：" + t + ",【tableName】：" + tableName);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("tableName", tableName);
		List<T> list = new ArrayList<>();
		List<Map<String, Object>> searchMap = baseMappper.queryForListAll(map);
		for (Map<String, Object> objMap : searchMap) {
			list.add((T) BeanHelper.mapToObjectReflect(objMap, t.getClass()));
		}
		return list;
	}

	public void deleteDataByPK(String tableName,Integer pk) throws Exception {
		if (pk == null) {
			throw new CustomException("存在为空的参数：【pk】：" + pk);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("tableName", tableName);
		map.put("id", pk);
		baseMappper.deleteDataByPK(map);
	}

	public int updateByPK(Map<String, Object> map, String tableName) throws Exception {
		if (map == null || tableName == null) {
			throw new CustomException("存在为空的参数：【map】：" + map + ",【tableName】：" + tableName);
		}
		return baseMappper.updateByPK(map, Integer.parseInt(map.get("id").toString()), tableName);
	}

	public int insertData(Map<String, Object> map, String tableName) throws Exception {
		if (map == null || tableName == null) {
			throw new CustomException("存在为空的参数：【map】：" + map + ",【tableName】：" + tableName);
		}
		return baseMappper.insertData(map, tableName);
	}

}
