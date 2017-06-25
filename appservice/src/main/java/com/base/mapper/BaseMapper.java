package com.base.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface BaseMapper {

	public Map<String,Object> queryByPK(@Param("paramMap") Map<String,Object> paramMap);
	
	/**
	 * 获取全部数据
	 * @return
	 */
	public List<Map<String,Object>> queryForListAll(@Param("paramMap") Map<String,Object> paramMap);
	
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
     * @return
     */
    public int insertData(@Param("paramMap") Map<String,Object> paramMap,@Param("tableName") String tableName);
}
