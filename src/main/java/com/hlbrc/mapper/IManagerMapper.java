package com.hlbrc.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.hlbrc.entity.Manager;

/**
 * 管理员 持久层
 * @author ZY
 *
 */
public interface IManagerMapper{
	//mybatis中的接口，每次只对应一条sql
	//增
	public void insert(Manager manager)throws Exception;
	//删
	public void deleteById(@Param("manager_id")int id) throws Exception;
	//改
	public void update(Manager manager) throws Exception;
	public void creatMessageTable(@Param("table_name")String table_name)throws Exception;
	//查
	public List<Manager> queryAll()throws Exception;
	public List<Manager> queryAll_not(@Param("manager_tel")String tel)throws Exception;
	public Manager queryByTel(@Param("manager_tel")String tel)throws Exception;
	public Manager queryById(@Param("manager_id")int id) throws Exception;
	public List<Manager> queryManager(@Param("startIndex")int startIndex,@Param("onePageCount")int onePageCount,@Param("manager_name")String manager_name) throws Exception;
	//统计个数
	public int countAll() throws Exception;
	public int countManager(@Param("manager_name")String manager_name)throws Exception;
	
	
}
