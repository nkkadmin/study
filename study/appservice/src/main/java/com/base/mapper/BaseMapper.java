package com.base.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.base.model.Page;

public interface BaseMapper {

	public Map<String,Object> queryByPK(@Param("paramMap") Map<String,Object> paramMap);
	
	/**
	 * 获取全部数据
	 * @return
	 */
	public List<Map<String,Object>> queryForListAll(@Param("paramMap") Map<String,Object> paramMap,Page<?> page);
	
	/**
	 * 根据唯一标示删除数据
	 * @param pk
	 * @return
	 */
    public void deleteDataByPK(@Param("paramMap") Map<String,Object> paramMap);
    
    /**
     * 修改数据
     * @param paramMap   需要修改的数据：  key 为数据库字段，value为要修改的值
     * @param tableName  数据名称
     * @param id  主鍵
     * @return
     */
    public int updateByPK(@Param("paramMap") Map<String,Object> paramMap,@Param("id") Integer id,@Param("tableName") String tableName);
    
    /**
     * 添加数据
     * @param paramMap  需要添加的数据   key为数据库字段名，value为插入的数据
     * @param tableName
     * @param PK 用于返回最新插入的主键值
     * @return
     */
    public int insertData(@Param("paramMap") Map<String,Object> paramMap,@Param("tableName") String tableName);
}
