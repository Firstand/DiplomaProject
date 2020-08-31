package com.hlbrc.biz;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.hlbrc.entity.Manager;
import com.hlbrc.entity.Profileimg;
import com.hlbrc.entity.Store;
import com.hlbrc.mapper.IManagerMapper;
import com.hlbrc.mapper.IProfileimgMapper;
import com.hlbrc.mapper.IStoreMapper;
import com.hlbrc.util.MD5;
import com.hlbrc.util.Time;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
/**
 * ����Ա�߼���
 * @author ZY
 *
 */
@SuppressWarnings("restriction")
@Service("ManagerBiz")
@Transactional(readOnly = true)
public class ManagerBiz {
	@Autowired
	private IManagerMapper manager_mapper;
	@Autowired
	private IStoreMapper store_mapper;
	
	/**
	 * ��ӹ���Ա
	 * @param manager
	 * @throws Exception
	 */
	@Transactional(rollbackFor=Throwable.class)
	public void insert(Manager manager) throws Exception{	
		manager_mapper.insert(manager);  
	}
	/**
	 * ��ȡ���й���Ա
	 * @return ����Ա����
	 * @throws Exception
	 */
	public List<Manager> queryAll() throws Exception {
		return manager_mapper.queryAll();
	}
	/**
	 * ��ȡ��������������й���Ա
	 * @param tel
	 * @return ����Ա����
	 * @throws Exception
	 */
	public List<Manager> queryAll_not(String tel) throws Exception {
		return manager_mapper.queryAll_not(tel);
	}
	/**
	 * ͨ���ֻ��Ų�ѯ��ȡ����Ա��Ϣ
	 * @param tel
	 * @return ����Ա��Ϣ
	 * @throws Exception
	 */
	public Manager queryByTel(String tel) throws Exception{
		return manager_mapper.queryByTel(tel);
	}
	/**
	 * ͨ��Id��ȡ����Ա��Ϣ
	 * @param id
	 * @return ����Ա��Ϣ
	 * @throws Exception
	 */
	public Manager queryById(int id)throws Exception {
		return manager_mapper.queryById(id);
	}
	/**
	 * ��ȡһ�������Ĺ���Ա����ҳ
	 * @param startIndex
	 * @param onePageCount
	 * @param name
	 * @return ����Ա����
	 * @throws Exception
	 */
	public List<Manager> queryManager(int startIndex,int onePageCount,String name)throws Exception {
		return manager_mapper.queryManager(startIndex,onePageCount,name);
	}
	/**
	 * ͳ�ƹ���Ա����
	 * @return ����Ա����
	 * @throws Exception
	 */
	public int countAll() throws Exception{
		return manager_mapper.countAll();
	}
	/**
	 * ����name��ȡ����Ա������ģ����ѯ
	 * @param name
	 * @return ����Ա����
	 * @throws Exception
	 */
	public int countManager(String name) throws Exception{
		return manager_mapper.countManager(name);
	}
	/**
	 * �޸Ĺ���Ա��Ϣ
	 * @param manager
	 * @param store
	 * @throws Exception
	 */
	@Transactional(rollbackFor=Throwable.class)
	public void updatems(Manager manager,Store store)throws Exception{
		store_mapper.update(store);
		manager_mapper.update(manager);
	}
	/**
	 * �޸Ĺ���Ա��Ϣ
	 * @param manager
	 * @throws Exception
	 */
	@Transactional(rollbackFor=Throwable.class)
	public void update(Manager manager)throws Exception {
		manager_mapper.update(manager);
	}
	/**
	 * ����
	 * @param file
	 * @return ����Ĺ���Ա����
	 * @throws Exception
	 */
	@Transactional(rollbackFor=Throwable.class)
	public int importFromExcel(File file) throws Exception{
		int i = 0;
		Workbook one=null;
		try {
			one = Workbook.getWorkbook(file);
			Sheet firstsheet=one.getSheet(0);
			for(int k=1;k<firstsheet.getRows();k++){
				Manager m=new Manager();
				String s[]=new String[9];
				System.out.println("������"+firstsheet.getColumns());
				for(int p=0;p<firstsheet.getColumns();p++){
					Cell onecell=firstsheet.getCell(p,k);
					s[p]=onecell.getContents();
					}
				m.setManager_tel(s[3]);
				m.setManager_name(s[4]);
				m.setManager_email(s[5]);
				m.setManager_idcard_num(s[6]);
//				m.setManager_address(s[7]);
				m.setManager_regist_time(new Timestamp(new Date().getTime()));
				m.setManager_img_path("");
				String sfz=s[6];
				String birthday = sfz.substring(6, 14);
				//ͨ�����֤�����������
				int day = Integer.parseInt(sfz.substring(10, 14));
				int age = Time.Getyear() - Integer.parseInt(sfz.substring(6, 10));
				if (Integer.parseInt(Time.Getmonth() + Time.Getday()) < day)
					age = age - 1;
				//ͨ�����֤�����ж��Ա�
				String sex;
				if (Integer.parseInt(sfz.substring(16, 17)) % 2 == 0)
					sex = "Ů";
				else
					sex = "��";	
				m.setManager_age(age);
				m.setManager_sex(sex);
				m.setManager_password(MD5.getMD5(Base64.encode((sfz.substring(12,18)).getBytes())));
				m.setManager_birth_time(birthday);
				if(this.queryByTel(m.getManager_tel())==null)
				{
					manager_mapper.insert(m);
					i=i+1;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (BiffException e) {
			e.printStackTrace();
		}
		finally{
			one.close();
		}
		return i;
	}
	/**
	 * ɾ������Ա
	 * @param mid
	 * @param sid
	 * @throws Exception
	 */
	@Transactional(rollbackFor=Throwable.class)
	public void deleteById(int mid,int sid)throws Exception{
		store_mapper.deleteById(sid);
		manager_mapper.deleteById(mid);
	}
	/**
	 * �������������¼��
	 * @param table_name
	 * @throws Exception
	 */
	@Transactional(rollbackFor=Throwable.class)
	public void creatMessageTable(String table_name)throws Exception {
		manager_mapper.creatMessageTable(table_name);
	}
	@Autowired
	private IProfileimgMapper profileimg_mapper;
	/**
	 * ���ͷ��/����
	 * @param profileimg
	 * @throws Exception
	 */
	@Transactional(rollbackFor=Throwable.class)
	public void insertImg(Profileimg profileimg) throws Exception {
		profileimg_mapper.insertImg(profileimg);
	}

}
