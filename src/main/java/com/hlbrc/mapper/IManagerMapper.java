package com.hlbrc.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.hlbrc.entity.Manager;

/**
 * ����Ա �־ò�
 * @author ZY
 *
 */
public interface IManagerMapper{
	//mybatis�еĽӿڣ�ÿ��ֻ��Ӧһ��sql
	//��
	public void insert(Manager manager)throws Exception;
	//ɾ
	public void deleteById(@Param("manager_id")int id) throws Exception;
	//��
	public void update(Manager manager) throws Exception;
	public void creatMessageTable(@Param("table_name")String table_name)throws Exception;
	//��
	public List<Manager> queryAll()throws Exception;
	public List<Manager> queryAll_not(@Param("manager_tel")String tel)throws Exception;
	public Manager queryByTel(@Param("manager_tel")String tel)throws Exception;
	public Manager queryById(@Param("manager_id")int id) throws Exception;
	public List<Manager> queryManager(@Param("startIndex")int startIndex,@Param("onePageCount")int onePageCount,@Param("manager_name")String manager_name) throws Exception;
	//ͳ�Ƹ���
	public int countAll() throws Exception;
	public int countManager(@Param("manager_name")String manager_name)throws Exception;
	
	
}
