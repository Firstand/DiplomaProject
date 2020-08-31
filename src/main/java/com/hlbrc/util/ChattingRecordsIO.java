package com.hlbrc.util;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringReader;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
//import java.util.Collection;
//import java.util.Date;
//import java.util.Iterator;
import java.util.List;
//import java.util.ListIterator;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import net.sf.json.JSONArray;

import com.hlbrc.entity.Message;
import com.hlbrc.enums.IRole;

import net.sf.json.JSONObject;

/**
 * 操作多种方式读写文件的类
 * @author ZY
 *
 */
public class ChattingRecordsIO {
	/**
	 * 以字节为单位写入文件
	 * @param user_filename 用户文件夹
	 * @param fileName 文件名
	 * @param content 内容
	 * @throws IOException
	 */
	public void writeFileByBytes(String user_filename,String fileName,String content) throws IOException {
		OutputStream out =null;//字节输出流
		File file = null;
		try {
			String filePath = getFilePath(user_filename,fileName);
			file = new File(filePath);
			if(!file.exists()){
			    //先得到文件的上级目录,并创建上级目录,在创建文件
				if(!file.getParentFile().mkdir()) {
					file.getParentFile().getParentFile().mkdir();
				}
			    try {
			        //创建文件
			        file.createNewFile();
			    } catch (IOException e) {
			        e.printStackTrace();
			    }
			}
			out=new FileOutputStream(file,true);  //打开文件输出流
			content = content+"\n";
			byte[] bytes= content.getBytes();  //读取输出流中的字节
			out.write(bytes);     //写入文件
			out.flush();
			System.out.println("写文件："+file.getAbsolutePath()+"成功！");
		} catch(IOException e) {
			throw new IOException("写文件："+file.getAbsolutePath()+"失败！\n"+e.getMessage());
		} finally {      //内容总执行
			if(out!=null) {
				try {
					out.close();  //关闭此输出流并释放与此流相关联的任何系统资源。 
				}catch(IOException el) {
				}
			}
		}
	}
	/**
	 * 以字节为单位写入文件
	 * @param content 内容
	 * @throws IOException"WeChat", "creat_member_card.json"
	 */
	public void writeFileByBytesWx(String filename,String content) throws IOException {
		OutputStream out =null;//字节输出流
		File file = null;
		try {
			String filePath = getFilePathWx("WeChat",filename);
			System.out.println(filePath);
			file = new File(filePath);
			if(!file.exists()){
			    //先得到文件的上级目录,并创建上级目录,在创建文件
				if(!file.getParentFile().mkdir()) {
					file.getParentFile().getParentFile().mkdir();
				}
			    try {
			        //创建文件
			        file.createNewFile();
			    } catch (IOException e) {
			        e.printStackTrace();
			    }
			}
			out=new FileOutputStream(file);  //打开文件输出流
			content = content+"\n";
			byte[] bytes= content.getBytes();  //读取输出流中的字节
			out.write(bytes);     //写入文件
			out.flush();
			System.out.println("写文件："+file.getAbsolutePath()+"成功！");
		} catch(IOException e) {
			throw new IOException("写文件："+file.getAbsolutePath()+"失败！\n"+e.getMessage());
		} finally {      //内容总执行
			if(out!=null) {
				try {
					out.close();  //关闭此输出流并释放与此流相关联的任何系统资源。 
				}catch(IOException el) {
				}
			}
		}
	}
	/**
	 * 以字节为单位写入文件
	 * @param content 内容
	 * @throws IOException"WeChat", "creat_member_card_taken.xml,creat_member_card_appid_appsecret.xml"
	 */
	public void writeFileByBytesXml(String filename,Object content,@SuppressWarnings("rawtypes") Class myclass) throws IOException {
		File file = null;
		try {
			String filePath = getFilePathXml("WeChat",filename);
			System.out.println(filePath);
			file = new File(filePath);
			if(!file.exists()){
			    //先得到文件的上级目录,并创建上级目录,在创建文件
				if(!file.getParentFile().mkdir()) {
					file.getParentFile().getParentFile().mkdir();
				}
			    try {
			        //创建文件
			        file.createNewFile();
			    } catch (IOException e) {
			        e.printStackTrace();
			    }
			}
			JAXBContext context = JAXBContext.newInstance(myclass);		
			Marshaller shaller = context.createMarshaller();				
			shaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);				
			shaller.marshal(content, file);  //输出到文件d:\\customer.xml		
			shaller.marshal(content, System.out);//输出到控制台
			System.out.println("写文件："+file.getAbsolutePath()+"成功！");
		} catch(JAXBException e) {
			throw new IOException("写文件："+file.getAbsolutePath()+"失败！\n"+e.getMessage());
		}
	}
	/**
	 * 将xml文件转换位java对象
	 * @param filename
	 * @param myclass
	 * @return
	 * @throws IOException 
	 */
	public Object getContentXml(String filename,@SuppressWarnings("rawtypes") Class myclass) throws IOException {
		Object xmlObject = null;
		String filePath = getFilePathXml("WeChat",filename);
	    try {
	    	//读取XML文件
	        BufferedReader bf = new BufferedReader(new FileReader(filePath));
	        StringBuilder builder = new StringBuilder();
	        String line = "";
	        while((line = bf.readLine()) != null){
	            builder.append(line);
	        }
	        JAXBContext context = JAXBContext.newInstance(myclass);
	        // 进行将Xml转成对象的核心接口  
	        Unmarshaller unmarshaller = context.createUnmarshaller();
	        StringReader sr = new StringReader(builder.toString()); 
	        xmlObject = unmarshaller.unmarshal(sr);
	        bf.close();
	    } catch (JAXBException e) {
	    	throw new IOException("写文件："+filePath+"失败！\n"+e.getMessage());
	    }
	    return xmlObject; 
	}
	/**
	 * 读取文件内容
	 * @param filePath
	 * @return 聊天记录集合
	 */
	public List<Message> readFile(String filePath) {
		List<Message> list = new ArrayList<Message>();
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		FileReader reader = null;
		BufferedReader br = null;
		File file = null;
		try {
			file= new File(filePath);
			if(file.exists()){
			    //先得到文件的上级目录,并创建上级目录,在创建文件
			    //System.out.println("得到文件的上级目录:"+file.getParentFile().mkdir());
				reader = new FileReader(filePath);		     
				br = new BufferedReader(reader);// 建立一个对象，它把文件内容转成计算机能读懂的语言
				String line = null;
				Message m = null;
				while ((line = br.readLine()) != null) 
				{	//一次读入一行数据
					JSONObject obj = JSONObject.fromObject(line);
					m = new Message();
					String[] senders = obj.getString("table_name_sender").split("_");
					String[] accepters = obj.getString("table_name_accepter").split("_");
					m.setSender_id(Integer.parseInt(senders[2]));
					m.setContent(obj.getString("content"));
					m.setContent_type(IRole.TEXT);
					m.setFlag(obj.getString("flag"));
					m.setAccepter_id(Integer.parseInt(accepters[2]));
					m.setTable_name_sender(obj.getString("table_name_sender"));
					m.setTable_name_accepter(obj.getString("table_name_accepter"));
					m.setCreat_time(new Timestamp(sd.parse(obj.getString("date")).getTime()));
					m.setIsself(obj.getBoolean("isSelf"));
					list.add(m);
				}
			}
			else {
				throw new IOException("读取文件失败！未找到文件："+file.getAbsolutePath()+",请检查文件路径是否正确！");
			}
		} catch (IOException e){
			System.err.println("读取文件："+file.getAbsolutePath()+"失败！");
//			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} finally {//内容总执行
			if(reader!=null) {
				try {
					reader.close();//关闭流并释放与之相关联的任何系统资源。
				}catch(IOException el) {
				}
			}
			if(br!=null) {
				try {
					br.close();//关闭流并释放与之相关联的任何系统资源。 
				}catch(IOException el) {
				}
			}
		}
		return list;
	}
	/**
	 * 获取WeChat文件夹下指定文件的内容
	 * @param filename
	 * @return json
	 */
	public JSONArray readFileWx(String filename) {
		FileReader reader = null;
		BufferedReader br = null;
		File file = null;
		JSONArray array = new JSONArray();
		String filePath = getFilePathWx("WeChat",filename);
		String str = "";
		try {
			file= new File(filePath);
			if(file.exists()){
			    //先得到文件的上级目录,并创建上级目录,在创建文件
			    //System.out.println("得到文件的上级目录:"+file.getParentFile().mkdir());
				reader = new FileReader(filePath);		     
				br = new BufferedReader(reader);// 建立一个对象，它把文件内容转成计算机能读懂的语言
				String line = null;
				while ((line = br.readLine()) != null) 
				{	//一次读入一行数据
					str += line;
				}
				if(str!=null&&!"".equals(str)) {
					array = JSONArray.fromObject(str);
				}
			}
			else {
				throw new IOException("读取文件失败！未找到文件："+file.getAbsolutePath()+",请检查文件路径是否正确！");
			}
		} catch (IOException e){
			System.err.println("读取文件："+file.getAbsolutePath()+"失败！");
//			e.printStackTrace();
		} finally {//内容总执行
			if(reader!=null) {
				try {
					reader.close();//关闭流并释放与之相关联的任何系统资源。
				}catch(IOException el) {
				}
			}
			if(br!=null) {
				try {
					br.close();//关闭流并释放与之相关联的任何系统资源。 
				}catch(IOException el) {
				}
			}
		}
		return array;
	}
	/**
	 * 清除文件内容
	 * @param filePath
	 */
	public void clearFile(String filePath){
		FileWriter fileWriter = null;
		try {
			File file =new File(filePath);
			if(file.exists()){
				fileWriter =new FileWriter(file);
	            fileWriter.write("");
	            fileWriter.flush();
			}
			else {
				throw new IOException("清除文件失败！未找到文件："+file.getAbsolutePath()+",请检查文件路径是否正确！");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {      //内容总执行
			if(fileWriter!=null) {
				try {
		            fileWriter.close();  //关闭此输出流并释放与此流相关联的任何系统资源。 
				}catch(IOException el) {
				}
			}
		}
	}
	/**
	 * 清除文件夹下所有文件信息
	 * @param user_filename
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void clearAllFile(String user_filename) throws FileNotFoundException, IOException{
		List<File> list =  readfile(getFilePath(user_filename));
		for(File file:list) {
			clearFile(file.getAbsolutePath());
		}
	}
	/**
	 * 查询文件夹下所有文件信息
	 * @param user_filename
	 * @return 聊天记录集合的集合
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public List<List<Message>> readAllFile(String user_filename) throws FileNotFoundException, IOException {
		List<List<Message>> list = new ArrayList<List<Message>>();
		List<File> list_file =  readfile(getFilePath(user_filename));
		for(File file:list_file) {
			list.add(readFile(file.getAbsolutePath()));
		}
		return list;
	}
	/**
	 * 读取指定文件内容
	 * @param user_filename
	 * @param fileName
	 * @return 聊天记录集合
	 */
	public List<Message> readOneFile(String user_filename,String fileName){
		return readFile(getFilePath(user_filename,fileName));
	}
	/**
	 * 获取文件路径
	 * @param user_filename
	 * @param fileName
	 * @return 用户聊天文件路径
	 */
	public String getFilePath(String user_filename,String fileName) {
		return "C:\\myChattingRecords\\"+user_filename+"\\"+fileName+".txt";
	}
	/**
	 * 获取文件路径
	 * @param user_filename
	 * @param fileName
	 * @return 会员卡数据文件路径
	 */
	public String getFilePathWx(String user_filename,String fileName) {
//		return "WebContent/dist/json/"+user_filename+"/"+fileName+".json";
		return "C:\\myChattingRecords\\"+user_filename+"\\"+fileName+".json";
	}
	/**
	 * 获取文件路径
	 * @param user_filename
	 * @param fileName
	 * @return
	 */
	public String getFilePathXml(String user_filename,String fileName) {
//		return "WebContent/dist/json/"+user_filename+"/"+fileName+".json";
		return "C:\\myChattingRecords\\"+user_filename+"\\"+fileName+".xml";
	}
	/**
	 * 获取文件路径
	 * @param user_filename
	 * @return 用户聊天文件路径
	 */
	public String getFilePath(String user_filename) {
		return "C:\\myChattingRecords\\"+user_filename;
	}
	/**
	 * 遍历文件夹中所有文件
	 * @param filepath
	 * @return 聊天文件集合
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public List<File> readfile(String filepath) throws FileNotFoundException, IOException {
		List<File> list_readfile = new ArrayList<File>();
        try {
                File file = new File(filepath);
                if (!file.isDirectory()) {
                    System.out.println("文件");
                    list_readfile.add(file);
//                  System.out.println("path=" + file.getPath());
//                  System.out.println("absolutepath=" + file.getAbsolutePath());
//                  System.out.println("name=" + file.getName());
                } 
                else if (file.isDirectory()) {
                    System.out.println("文件夹");
                    String[] filelist = file.list();
                    for (int i = 0; i < filelist.length; i++) {
                        File readfile = new File(filepath + "\\" + filelist[i]);
                        if (!readfile.isDirectory()) {
//                          System.out.println("绝对路径(path)=" + readfile.getPath());
//                          System.out.println("相对路径(absolutepath)="+ readfile.getAbsolutePath());
//                          System.out.println("文件名name=" + readfile.getName());
                            list_readfile.add(readfile);
                         } 
                        else if (readfile.isDirectory()) {
                            readfile(filepath + "\\" + filelist[i]);
                        }

                   	}
                }
       	} 
        catch (FileNotFoundException e) {
            System.out.println("readfile()   Exception:" + e.getMessage());
        }
		return list_readfile;
	}
	
//	public static void main(String[] args) {
//		new ChattingRecordsIO().getFilePath("manager_table_2");
//	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
//	  List<File> list = new ChattingRecordsIO().readfile("F:\\Users\\DELL\\eclipse-workspace\\DiplomaProject\\myChattingRecords\\");
//	  for(File file:list) {
//		  System.out.println(file.getAbsolutePath());
//	  }
//	  String fileName = "manager_table_4";//写文件存入目录 
//	  String content = "{\"nickname\":\"Manager_15034771551\",\"content\":\"123456\",\"flag\":\"chatroom\",\"target\":\"MANAGER_TABLE_room_4\"}\n";
//	  System.out.println("以字节为单位："); //调用方法写文件 
//	  try {
//		new ChattingRecordsIO().writeFileByBytes(fileName,content);
//	} catch (IOException e) {
//		e.printStackTrace();
//	}
	  //调用读取文件
//	  List<Message> list= new ChattingRecordsIO().ReadFile(fileName);
//	  SimpleDateFormat sd = new SimpleDateFormat("HH:mm E");
//	  for(Message msg:list) {
//		  msg.setCreat_time_str(sd.format(msg.getCreat_time()));
//	  }
	  
//	  //调用清除文件内容
////	  new ChattingRecordsIO().clearFile(fileName);
////	  System.out.println(new ChattingRecordsIO().ReadFile(fileName));
		JSONObject content = new JSONObject();
		content.put("cadid", "123");
		content.put("name", "啊哈的角色");
		content.put("ahs", "ashdka");
		List<JSONObject> list = new ArrayList<JSONObject>();
		list.add(content);
		new ChattingRecordsIO().writeFileByBytesWx("",list.toString());
	}

}
