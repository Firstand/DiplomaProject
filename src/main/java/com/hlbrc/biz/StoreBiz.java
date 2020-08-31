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
 * �ŵ��߼���
 * @author ZY
 *
 */
@Service("StoreBiz")
@Transactional(readOnly=true)
public class StoreBiz {
	@Autowired
	private IStoreMapper store_mapper ;
	
	/**
	 * ����ŵ�
	 * @param store
	 * @throws Exception
	 */
	public void insert(Store store) throws Exception {
		store.setStore_regist_time(new Timestamp(new Date().getTime()));
		store.setStore_state("1");
		store_mapper.insert(store);
	}
	/**
	 * ����Idɾ���ŵ�
	 * @param id
	 * @throws Exception
	 */
	public void deleteById(int id) throws Exception{
		store_mapper.deleteById(id);
	}
	/**
	 * �޸��ŵ���Ϣ
	 * @param store
	 * @throws Exception
	 */
	public void update(Store store) throws Exception {
		store_mapper.update(store);
	}
	/**
	 * �����ŵ�ͣ��
	 * @param id
	 * @throws Exception
	 */
	public void setstop(int id)throws Exception {
		store_mapper.setstop(id);
	}
	/**
	 * �����ŵ�����
	 * @param id
	 * @throws Exception
	 */
	public void setstart(int id)throws Exception {
		store_mapper.setstart(id);
	}
	/**
	 * ��ȡ�����ŵ���Ϣ
	 * @return �ŵ꼯��
	 * @throws Exception
	 */
	public List<Store> queryAll() throws Exception{
		return store_mapper.queryAll();
	}
	/**
	 * ͨ���绰�Ż�ȡ�ŵ���Ϣ
	 * @param tel
	 * @return �ŵ���Ϣ
	 * @throws Exception
	 */
	public Store queryByTel(String tel) throws Exception{
		return store_mapper.queryByTel(tel);
	}
	/**
	 * ͨ��id��ȡ�ŵ���Ϣ
	 * @param id
	 * @return �ŵ���Ϣ
	 * @throws Exception
	 */
	public Store queryById(int id)throws Exception {
		return store_mapper.queryById(id);
	}
	/**
	 * ��ȡ�ŵ���Ϣ��ʵ�ַ�ҳ
	 * @param startIndex
	 * @param onePageCount
	 * @param column
	 * @param value
	 * @return �ŵ꼯��
	 * @throws Exception
	 */
	public List<Store> queryStore(int startIndex,int onePageCount,String column,String value) throws Exception{
		return store_mapper.queryStore(startIndex,onePageCount,column,value);
	}
	/**
	 * ��ȡ�����ŵ����
	 * @return �ŵ����
	 * @throws Exception
	 */
	public int countAll()throws Exception {
		return store_mapper.countAll();
	}
	/**
	 * ��ȡ����Ҫ����ŵ����
	 * @param column
	 * @param value
	 * @return �ŵ����
	 * @throws Exception
	 */
	public int countStore(String column,String value)throws Exception {
		return store_mapper.countStore(column,value);
	}
	/**
	 * ��excel�е����û�����
	 * @param file
	 * @return �����û����ݵĸ���
	 * @throws Exception
	 */
	public int importFromExcel(File file)throws Exception {
		// TODO �Զ����ɵķ������
		int i = 0;
		Workbook one=null;
		try {
			one = Workbook.getWorkbook(file);
			Sheet firstsheet=one.getSheet(0);
			for(int k=1;k<firstsheet.getRows();k++){
				Store store=new Store();
				String s[]=new String[9];
				System.out.println("������"+firstsheet.getColumns());
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
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (BiffException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		finally{
			one.close();
		}
		
	return i;
		
	}
			

}
