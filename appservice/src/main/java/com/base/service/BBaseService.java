package com.base.service;

import java.util.List;
import java.util.Map;

/**
 * 公共service
 * @author xsx
 *
 * @param <T>
 */
public interface BBaseService<T> {

	/**
	 * 获取指定对象
	 * 
	 * @param t
	 * @param tableName
	 * @param pk
	 * @return
	 */
	public T queryByPK(T t, String tableName, Integer pk) throws Exception;

	/**
	 * 获取全部数据
	 * 
	 * @return
	 */
	public List<T> queryForListAll(T t, String tableName) throws Exception;

	/**
	 * 根据唯一标识删除数据
	 * 
	 * @param pk
	 * @return
	 */
	public void deleteDataByPK(String tableName,Integer pk) throws Exception;

	/**
	 * 修改数据
	 * 
	 * @param map
	 *            需要修改的数据： key 为数据库字段，value为要修改的值
	 * @param id
	 *            主鍵
	 * @return
	 */
	public int updateByPK(Map<String, Object> map, String tableName) throws Exception;

	/**
	 * 添加数据
	 * 
	 * @param paramMap
	 *            需要添加的数据 key为数据库字段名，value为插入的数据
	 * @param tableName
	 * @return
	 */
	public int insertData(Map<String, Object> map, String tableName) throws Exception;
}
