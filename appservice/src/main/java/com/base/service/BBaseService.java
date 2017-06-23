package com.base.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface BBaseService<T> {

	/**
	 * 获取指定对象
	 * 
	 * @param t
	 * @param tableName
	 * @param pk
	 * @return
	 */
	public T queryByPK(T t, String tableName, Integer pk);

	/**
	 * 获取全部数据
	 * 
	 * @return
	 */
	public List<T> queryForListAll(T t, String tableName);

	/**
	 * 根据唯一标示删除数据
	 * 
	 * @param pk
	 * @return
	 */
	public int deleteDataByPK(Integer pk);

	/**
	 * 修改数据
	 * 
	 * @param map
	 *            需要修改的数据： key 为数据库字段，value为要修改的值
	 * @param id
	 *            主鍵
	 * @return
	 */
	public int updateByPK(Map<String, Object> map, String tableName);

	/**
	 * 添加数据
	 * 
	 * @param paramMap
	 *            需要添加的数据 key为数据库字段名，value为插入的数据
	 * @param tableName
	 * @return
	 */
	public int insertData(Map<String, Object> paramMap, String tableName);
}
