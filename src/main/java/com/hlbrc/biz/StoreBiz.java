package com.hlbrc.biz;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hlbrc.entity.Store;
import com.hlbrc.mapper.IStoreMapper;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/**
 * 门店逻辑层
 * @author ZY
 *
 */
@Service("StoreBiz")
@Transactional(readOnly=true)
public class StoreBiz {
	@Autowired
	private IStoreMapper store_mapper ;
	
	/**
	 * 添加门店
	 * @param store
	 * @throws Exception
	 */
	public void insert(Store store) throws Exception {
		store.setStore_regist_time(new Timestamp(new Date().getTime()));
		store.setStore_state("1");
		store_mapper.insert(store);
	}
	/**
	 * 根据Id删除门店
	 * @param id
	 * @throws Exception
	 */
	public void deleteById(int id) throws Exception{
		store_mapper.deleteById(id);
	}
	/**
	 * 修改门店信息
	 * @param store
	 * @throws Exception
	 */
	public void update(Store store) throws Exception {
		store_mapper.update(store);
	}
	/**
	 * 设置门店停用
	 * @param id
	 * @throws Exception
	 */
	public void setstop(int id)throws Exception {
		store_mapper.setstop(id);
	}
	/**
	 * 设置门店启用
	 * @param id
	 * @throws Exception
	 */
	public void setstart(int id)throws Exception {
		store_mapper.setstart(id);
	}
	/**
	 * 获取所有门店信息
	 * @return 门店集合
	 * @throws Exception
	 */
	public List<Store> queryAll() throws Exception{
		return store_mapper.queryAll();
	}
	/**
	 * 通过电话号获取门店信息
	 * @param tel
	 * @return 门店信息
	 * @throws Exception
	 */
	public Store queryByTel(String tel) throws Exception{
		return store_mapper.queryByTel(tel);
	}
	/**
	 * 通过id获取门店信息
	 * @param id
	 * @return 门店信息
	 * @throws Exception
	 */
	public Store queryById(int id)throws Exception {
		return store_mapper.queryById(id);
	}
	/**
	 * 获取门店信息，实现分页
	 * @param startIndex
	 * @param onePageCount
	 * @param column
	 * @param value
	 * @return 门店集合
	 * @throws Exception
	 */
	public List<Store> queryStore(int startIndex,int onePageCount,String column,String value) throws Exception{
		return store_mapper.queryStore(startIndex,onePageCount,column,value);
	}
	/**
	 * 获取所有门店个数
	 * @return 门店个数
	 * @throws Exception
	 */
	public int countAll()throws Exception {
		return store_mapper.countAll();
	}
	/**
	 * 获取符合要求的门店个数
	 * @param column
	 * @param value
	 * @return 门店个数
	 * @throws Exception
	 */
	public int countStore(String column,String value)throws Exception {
		return store_mapper.countStore(column,value);
	}
	/**
	 * 从excel中导入用户数据
	 * @param file
	 * @return 导入用户数据的个数
	 * @throws Exception
	 */
	public int importFromExcel(File file)throws Exception {
		// TODO 自动生成的方法存根
		int i = 0;
		Workbook one=null;
		try {
			one = Workbook.getWorkbook(file);
			Sheet firstsheet=one.getSheet(0);
			for(int k=1;k<firstsheet.getRows();k++){
				Store store=new Store();
				String s[]=new String[9];
				System.out.println("列数："+firstsheet.getColumns());
				for(int p=0;p<firstsheet.getColumns();p++){
					Cell onecell=firstsheet.getCell(p,k);
					s[p]=onecell.getContents();
					}
				store.setStore_name(s[0]);
				store.setStore_address(s[1]);
				store.setStore_type(s[2]);
				store.setStore_regist_time(new Timestamp(new Date().getTime()));
				store.setStore_state("1");
				store.setStore_manager_id(s[3]);
				store.setStore_manager_name(s[4]);
				if(this.queryByTel(store.getStore_manager_id())==null)
				{
				insert(store);
				i=i+1;
				}
			}
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (BiffException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		finally{
			one.close();
		}
		
	return i;
		
	}
			

}
