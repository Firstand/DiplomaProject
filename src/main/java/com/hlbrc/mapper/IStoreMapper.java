package com.hlbrc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;


import com.hlbrc.entity.Store;

public interface IStoreMapper{
	//增
	public int insert(Store store)throws Exception;
	//删
	public void deleteById(@Param("store_id")int id)throws Exception;
	//改
	public int update(Store store) throws Exception;
	//查
	public List<Store> queryAll()throws Exception;
	public List<Store> queryStore(@Param("startIndex")int startIndex,@Param("onePageCount")int onePageCount,@Param("column")String column,@Param("value")String value) throws Exception;
	public Store queryByTel(@Param("store_manager_id")String tel) throws Exception;
	public Store queryById(@Param("store_id")int id) throws Exception;
	//统计个数
	public int countAll() throws Exception;
	public int countStore(@Param("column")String column,@Param("value")String value)throws Exception;
	//设置
	public void setstop(@Param("store_id")int id) throws Exception;
	public void setstart(@Param("store_id")int id) throws Exception;
	

}
