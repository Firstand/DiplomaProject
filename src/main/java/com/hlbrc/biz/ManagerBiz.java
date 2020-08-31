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
 * 管理员逻辑层
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
	 * 添加管理员
	 * @param manager
	 * @throws Exception
	 */
	@Transactional(rollbackFor=Throwable.class)
	public void insert(Manager manager) throws Exception{	
		manager_mapper.insert(manager);  
	}
	/**
	 * 获取所有管理员
	 * @return 管理员集合
	 * @throws Exception
	 */
	public List<Manager> queryAll() throws Exception {
		return manager_mapper.queryAll();
	}
	/**
	 * 获取除本人以外的所有管理员
	 * @param tel
	 * @return 管理员集合
	 * @throws Exception
	 */
	public List<Manager> queryAll_not(String tel) throws Exception {
		return manager_mapper.queryAll_not(tel);
	}
	/**
	 * 通过手机号查询获取管理员信息
	 * @param tel
	 * @return 管理员信息
	 * @throws Exception
	 */
	public Manager queryByTel(String tel) throws Exception{
		return manager_mapper.queryByTel(tel);
	}
	/**
	 * 通过Id获取管理员信息
	 * @param id
	 * @return 管理员信息
	 * @throws Exception
	 */
	public Manager queryById(int id)throws Exception {
		return manager_mapper.queryById(id);
	}
	/**
	 * 获取一定数量的管理员，分页
	 * @param startIndex
	 * @param onePageCount
	 * @param name
	 * @return 管理员集合
	 * @throws Exception
	 */
	public List<Manager> queryManager(int startIndex,int onePageCount,String name)throws Exception {
		return manager_mapper.queryManager(startIndex,onePageCount,name);
	}
	/**
	 * 统计管理员个数
	 * @return 管理员个数
	 * @throws Exception
	 */
	public int countAll() throws Exception{
		return manager_mapper.countAll();
	}
	/**
	 * 根据name获取管理员个数，模糊查询
	 * @param name
	 * @return 管理员个数
	 * @throws Exception
	 */
	public int countManager(String name) throws Exception{
		return manager_mapper.countManager(name);
	}
	/**
	 * 修改管理员信息
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
	 * 修改管理员信息
	 * @param manager
	 * @throws Exception
	 */
	@Transactional(rollbackFor=Throwable.class)
	public void update(Manager manager)throws Exception {
		manager_mapper.update(manager);
	}
	/**
	 * 导入
	 * @param file
	 * @return 导入的管理员个数
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
				System.out.println("列数："+firstsheet.getColumns());
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
				//通过身份证号码计算年龄
				int day = Integer.parseInt(sfz.substring(10, 14));
				int age = Time.Getyear() - Integer.parseInt(sfz.substring(6, 10));
				if (Integer.parseInt(Time.Getmonth() + Time.Getday()) < day)
					age = age - 1;
				//通过身份证号码判断性别
				String sex;
				if (Integer.parseInt(sfz.substring(16, 17)) % 2 == 0)
					sex = "女";
				else
					sex = "男";	
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
	 * 删除管理员
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
	 * 创建个人聊天记录表
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
	 * 添加头像/背景
	 * @param profileimg
	 * @throws Exception
	 */
	@Transactional(rollbackFor=Throwable.class)
	public void insertImg(Profileimg profileimg) throws Exception {
		profileimg_mapper.insertImg(profileimg);
	}

}
