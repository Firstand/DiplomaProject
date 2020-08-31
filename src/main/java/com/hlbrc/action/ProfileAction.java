package com.hlbrc.action;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.hlbrc.biz.ManagerBiz;
import com.hlbrc.entity.Manager;
import com.hlbrc.entity.Profileimg;
import com.hlbrc.enums.IRole;
import com.hlbrc.util.Log;
/**
 * 用户头像/背景处理控制层
 * @author ZY
 *
 */
@Controller
public class ProfileAction {
	@Autowired
	ManagerBiz biz_manager;
	
	/**
	 * 个人信息
	 * @param session
	 * @return
	 */
	@RequestMapping(path="profile",method=RequestMethod.GET)
	public String profile(HttpSession session){
		Manager manager = (Manager)session.getAttribute("manager");
		if(manager==null)
		{
			return "publics/login.jsp";
		}
		return "common_admin/profile.jsp";
	}
	
	@RequestMapping(path="profile",method=RequestMethod.POST)
	public String profile(String exampleInputEmail_2,String exampleInputpwd_2) {
		return "common_admin/profile.jsp";
	}
	
	/**
	 * 上传图片
	 * @param file
	 * @param flag
	 * @param httpsession
	 * @return
	 */
	@RequestMapping(path="upload_img")
	public String upload_img(@RequestParam("file")MultipartFile file,String flag,HttpSession httpsession) {
		//定义文件保存的本地路径
        //对文文件的全名进行截取然后在后缀名进行删选。
        int begin = file.getOriginalFilename().indexOf(".");
        int last = file.getOriginalFilename().length();
        if(!"pro_backgroud".equals(flag)) {
        	begin+=1;
        }
        //获得文件后缀名
        String a = file.getOriginalFilename().substring(begin, last);
        //文件名为当前时间
        Date curData = new Date();
        long d = curData.getTime();
  		String mainFile = String.valueOf(d);
  		String filename=mainFile+a;
  		String separator = File.separator+""; 
	  	String realPath = httpsession.getServletContext().getRealPath("");
	  	realPath = realPath.substring(0, realPath.indexOf(separator));
  	    String localPath=realPath+"/diplomaproject_img/"+flag;
		String path=localPath+"/"+filename;
	    try {
			byte[] bytes = file.getBytes();
			FileUtils.writeByteArrayToFile(new File(path),bytes);
			Profileimg profileimg = new Profileimg();
			profileimg.setPro_file_img_path(filename);
			if("pro_backgroud".equals(flag)) {
				profileimg.setPro_file_img_type(IRole.PRO_BACKGROUD);
			}
			else {
				profileimg.setPro_file_img_type(IRole.PRO_HEAD_PROTRAIT);
			}
			Manager manager = (Manager) httpsession.getAttribute("manager");
			profileimg.setManager(manager);
			profileimg.setCreat_time(new Date());
			biz_manager.insertImg(profileimg);
			manager = biz_manager.queryByTel(manager.getManager_tel());
			List<Manager> manager_not = biz_manager.queryAll_not(manager.getManager_tel());
			httpsession.setAttribute("manager", manager);
			httpsession.setAttribute("manager_not", manager_not);
		} catch (IOException e1) {
			e1.printStackTrace();
			Log.logger.debug("ProfileAction中upload_img()方法出错啦！图片上传失败："+e1.getMessage());
			return "error/404.jsp";	
		} catch (Exception e) {
			e.printStackTrace();
			Log.logger.debug("ProfileAction中upload_img()方法出错啦！图片相关信息数据库写入失败："+e.getMessage());
			return "error/500.jsp";	
		}
	    return "";
	}
}
