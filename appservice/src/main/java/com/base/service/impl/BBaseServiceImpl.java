package com.base.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.base.mapper.BaseMapper;
import com.base.service.BBaseService;
import com.base.util.BeanHelper;

public class BBaseServiceImpl<T> implements BBaseService<T> {

	@Resource
	private BaseMapper baseMappper;

	@Override
	public T queryByPK(T t, String tableName, Integer pk) {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("tableName", tableName);
		map.put("id", pk);
		Map<String, Object> resultMap = baseMappper.queryByPK(map);
		t = (T) BeanHelper.mapToObjectReflect(resultMap, t.getClass());
		return t;
	}

	@Override
	public List<T> queryForListAll(T t, String tableName) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("tableName", tableName);
		List<T> list = new ArrayList<>();
		List<Map<String, Object>> searchMap = baseMappper.queryForListAll(map);
		for (Map<String, Object> objMap : searchMap) {
			list.add((T)BeanHelper.mapToObjectReflect(objMap, t.getClass()));
		}
		return list;
	}

	@Override
	public int deleteDataByPK(Integer pk) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", pk);
		return baseMappper.deleteDataByPK(map);
	}

	@Override
	public int updateByPK(Map<String,Object> map, String tableName) {
		return baseMappper.updateByPK(map, Integer.parseInt(map.get("id").toString()), tableName);
	}

	@Override
	public int insertData(Map<String, Object> paramMap, String tableName) {
		return baseMappper.insertData(paramMap, tableName);
	}

}
