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
 * �������ַ�ʽ��д�ļ�����
 * @author ZY
 *
 */
public class ChattingRecordsIO {
	/**
	 * ���ֽ�Ϊ��λд���ļ�
	 * @param user_filename �û��ļ���
	 * @param fileName �ļ���
	 * @param content ����
	 * @throws IOException
	 */
	public void writeFileByBytes(String user_filename,String fileName,String content) throws IOException {
		OutputStream out =null;//�ֽ������
		File file = null;
		try {
			String filePath = getFilePath(user_filename,fileName);
			file = new File(filePath);
			if(!file.exists()){
			    //�ȵõ��ļ����ϼ�Ŀ¼,�������ϼ�Ŀ¼,�ڴ����ļ�
				if(!file.getParentFile().mkdir()) {
					file.getParentFile().getParentFile().mkdir();
				}
			    try {
			        //�����ļ�
			        file.createNewFile();
			    } catch (IOException e) {
			        e.printStackTrace();
			    }
			}
			out=new FileOutputStream(file,true);  //���ļ������
			content = content+"\n";
			byte[] bytes= content.getBytes();  //��ȡ������е��ֽ�
			out.write(bytes);     //д���ļ�
			out.flush();
			System.out.println("д�ļ���"+file.getAbsolutePath()+"�ɹ���");
		} catch(IOException e) {
			throw new IOException("д�ļ���"+file.getAbsolutePath()+"ʧ�ܣ�\n"+e.getMessage());
		} finally {      //������ִ��
			if(out!=null) {
				try {
					out.close();  //�رմ���������ͷ��������������κ�ϵͳ��Դ�� 
				}catch(IOException el) {
				}
			}
		}
	}
	/**
	 * ���ֽ�Ϊ��λд���ļ�
	 * @param content ����
	 * @throws IOException"WeChat", "creat_member_card.json"
	 */
	public void writeFileByBytesWx(String filename,String content) throws IOException {
		OutputStream out =null;//�ֽ������
		File file = null;
		try {
			String filePath = getFilePathWx("WeChat",filename);
			System.out.println(filePath);
			file = new File(filePath);
			if(!file.exists()){
			    //�ȵõ��ļ����ϼ�Ŀ¼,�������ϼ�Ŀ¼,�ڴ����ļ�
				if(!file.getParentFile().mkdir()) {
					file.getParentFile().getParentFile().mkdir();
				}
			    try {
			        //�����ļ�
			        file.createNewFile();
			    } catch (IOException e) {
			        e.printStackTrace();
			    }
			}
			out=new FileOutputStream(file);  //���ļ������
			content = content+"\n";
			byte[] bytes= content.getBytes();  //��ȡ������е��ֽ�
			out.write(bytes);     //д���ļ�
			out.flush();
			System.out.println("д�ļ���"+file.getAbsolutePath()+"�ɹ���");
		} catch(IOException e) {
			throw new IOException("д�ļ���"+file.getAbsolutePath()+"ʧ�ܣ�\n"+e.getMessage());
		} finally {      //������ִ��
			if(out!=null) {
				try {
					out.close();  //�رմ���������ͷ��������������κ�ϵͳ��Դ�� 
				}catch(IOException el) {
				}
			}
		}
	}
	/**
	 * ���ֽ�Ϊ��λд���ļ�
	 * @param content ����
	 * @throws IOException"WeChat", "creat_member_card_taken.xml,creat_member_card_appid_appsecret.xml"
	 */
	public void writeFileByBytesXml(String filename,Object content,@SuppressWarnings("rawtypes") Class myclass) throws IOException {
		File file = null;
		try {
			String filePath = getFilePathXml("WeChat",filename);
			System.out.println(filePath);
			file = new File(filePath);
			if(!file.exists()){
			    //�ȵõ��ļ����ϼ�Ŀ¼,�������ϼ�Ŀ¼,�ڴ����ļ�
				if(!file.getParentFile().mkdir()) {
					file.getParentFile().getParentFile().mkdir();
				}
			    try {
			        //�����ļ�
			        file.createNewFile();
			    } catch (IOException e) {
			        e.printStackTrace();
			    }
			}
			JAXBContext context = JAXBContext.newInstance(myclass);		
			Marshaller shaller = context.createMarshaller();				
			shaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);				
			shaller.marshal(content, file);  //������ļ�d:\\customer.xml		
			shaller.marshal(content, System.out);//���������̨
			System.out.println("д�ļ���"+file.getAbsolutePath()+"�ɹ���");
		} catch(JAXBException e) {
			throw new IOException("д�ļ���"+file.getAbsolutePath()+"ʧ�ܣ�\n"+e.getMessage());
		}
	}
	/**
	 * ��xml�ļ�ת��λjava����
	 * @param filename
	 * @param myclass
	 * @return
	 * @throws IOException 
	 */
	public Object getContentXml(String filename,@SuppressWarnings("rawtypes") Class myclass) throws IOException {
		Object xmlObject = null;
		String filePath = getFilePathXml("WeChat",filename);
	    try {
	    	//��ȡXML�ļ�
	        BufferedReader bf = new BufferedReader(new FileReader(filePath));
	        StringBuilder builder = new StringBuilder();
	        String line = "";
	        while((line = bf.readLine()) != null){
	            builder.append(line);
	        }
	        JAXBContext context = JAXBContext.newInstance(myclass);
	        // ���н�Xmlת�ɶ���ĺ��Ľӿ�  
	        Unmarshaller unmarshaller = context.createUnmarshaller();
	        StringReader sr = new StringReader(builder.toString()); 
	        xmlObject = unmarshaller.unmarshal(sr);
	        bf.close();
	    } catch (JAXBException e) {
	    	throw new IOException("д�ļ���"+filePath+"ʧ�ܣ�\n"+e.getMessage());
	    }
	    return xmlObject; 
	}
	/**
	 * ��ȡ�ļ�����
	 * @param filePath
	 * @return �����¼����
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
			    //�ȵõ��ļ����ϼ�Ŀ¼,�������ϼ�Ŀ¼,�ڴ����ļ�
			    //System.out.println("�õ��ļ����ϼ�Ŀ¼:"+file.getParentFile().mkdir());
				reader = new FileReader(filePath);		     
				br = new BufferedReader(reader);// ����һ�����������ļ�����ת�ɼ�����ܶ���������
				String line = null;
				Message m = null;
				while ((line = br.readLine()) != null) 
				{	//һ�ζ���һ������
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
				throw new IOException("��ȡ�ļ�ʧ�ܣ�δ�ҵ��ļ���"+file.getAbsolutePath()+",�����ļ�·���Ƿ���ȷ��");
			}
		} catch (IOException e){
			System.err.println("��ȡ�ļ���"+file.getAbsolutePath()+"ʧ�ܣ�");
//			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} finally {//������ִ��
			if(reader!=null) {
				try {
					reader.close();//�ر������ͷ���֮��������κ�ϵͳ��Դ��
				}catch(IOException el) {
				}
			}
			if(br!=null) {
				try {
					br.close();//�ر������ͷ���֮��������κ�ϵͳ��Դ�� 
				}catch(IOException el) {
				}
			}
		}
		return list;
	}
	/**
	 * ��ȡWeChat�ļ�����ָ���ļ�������
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
			    //�ȵõ��ļ����ϼ�Ŀ¼,�������ϼ�Ŀ¼,�ڴ����ļ�
			    //System.out.println("�õ��ļ����ϼ�Ŀ¼:"+file.getParentFile().mkdir());
				reader = new FileReader(filePath);		     
				br = new BufferedReader(reader);// ����һ�����������ļ�����ת�ɼ�����ܶ���������
				String line = null;
				while ((line = br.readLine()) != null) 
				{	//һ�ζ���һ������
					str += line;
				}
				if(str!=null&&!"".equals(str)) {
					array = JSONArray.fromObject(str);
				}
			}
			else {
				throw new IOException("��ȡ�ļ�ʧ�ܣ�δ�ҵ��ļ���"+file.getAbsolutePath()+",�����ļ�·���Ƿ���ȷ��");
			}
		} catch (IOException e){
			System.err.println("��ȡ�ļ���"+file.getAbsolutePath()+"ʧ�ܣ�");
//			e.printStackTrace();
		} finally {//������ִ��
			if(reader!=null) {
				try {
					reader.close();//�ر������ͷ���֮��������κ�ϵͳ��Դ��
				}catch(IOException el) {
				}
			}
			if(br!=null) {
				try {
					br.close();//�ر������ͷ���֮��������κ�ϵͳ��Դ�� 
				}catch(IOException el) {
				}
			}
		}
		return array;
	}
	/**
	 * ����ļ�����
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
				throw new IOException("����ļ�ʧ�ܣ�δ�ҵ��ļ���"+file.getAbsolutePath()+",�����ļ�·���Ƿ���ȷ��");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {      //������ִ��
			if(fileWriter!=null) {
				try {
		            fileWriter.close();  //�رմ���������ͷ��������������κ�ϵͳ��Դ�� 
				}catch(IOException el) {
				}
			}
		}
	}
	/**
	 * ����ļ����������ļ���Ϣ
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
	 * ��ѯ�ļ����������ļ���Ϣ
	 * @param user_filename
	 * @return �����¼���ϵļ���
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
	 * ��ȡָ���ļ�����
	 * @param user_filename
	 * @param fileName
	 * @return �����¼����
	 */
	public List<Message> readOneFile(String user_filename,String fileName){
		return readFile(getFilePath(user_filename,fileName));
	}
	/**
	 * ��ȡ�ļ�·��
	 * @param user_filename
	 * @param fileName
	 * @return �û������ļ�·��
	 */
	public String getFilePath(String user_filename,String fileName) {
		return "C:\\myChattingRecords\\"+user_filename+"\\"+fileName+".txt";
	}
	/**
	 * ��ȡ�ļ�·��
	 * @param user_filename
	 * @param fileName
	 * @return ��Ա�������ļ�·��
	 */
	public String getFilePathWx(String user_filename,String fileName) {
//		return "WebContent/dist/json/"+user_filename+"/"+fileName+".json";
		return "C:\\myChattingRecords\\"+user_filename+"\\"+fileName+".json";
	}
	/**
	 * ��ȡ�ļ�·��
	 * @param user_filename
	 * @param fileName
	 * @return
	 */
	public String getFilePathXml(String user_filename,String fileName) {
//		return "WebContent/dist/json/"+user_filename+"/"+fileName+".json";
		return "C:\\myChattingRecords\\"+user_filename+"\\"+fileName+".xml";
	}
	/**
	 * ��ȡ�ļ�·��
	 * @param user_filename
	 * @return �û������ļ�·��
	 */
	public String getFilePath(String user_filename) {
		return "C:\\myChattingRecords\\"+user_filename;
	}
	/**
	 * �����ļ����������ļ�
	 * @param filepath
	 * @return �����ļ�����
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public List<File> readfile(String filepath) throws FileNotFoundException, IOException {
		List<File> list_readfile = new ArrayList<File>();
        try {
                File file = new File(filepath);
                if (!file.isDirectory()) {
                    System.out.println("�ļ�");
                    list_readfile.add(file);
//                  System.out.println("path=" + file.getPath());
//                  System.out.println("absolutepath=" + file.getAbsolutePath());
//                  System.out.println("name=" + file.getName());
                } 
                else if (file.isDirectory()) {
                    System.out.println("�ļ���");
                    String[] filelist = file.list();
                    for (int i = 0; i < filelist.length; i++) {
                        File readfile = new File(filepath + "\\" + filelist[i]);
                        if (!readfile.isDirectory()) {
//                          System.out.println("����·��(path)=" + readfile.getPath());
//                          System.out.println("���·��(absolutepath)="+ readfile.getAbsolutePath());
//                          System.out.println("�ļ���name=" + readfile.getName());
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
//	  String fileName = "manager_table_4";//д�ļ�����Ŀ¼ 
//	  String content = "{\"nickname\":\"Manager_15034771551\",\"content\":\"123456\",\"flag\":\"chatroom\",\"target\":\"MANAGER_TABLE_room_4\"}\n";
//	  System.out.println("���ֽ�Ϊ��λ��"); //���÷���д�ļ� 
//	  try {
//		new ChattingRecordsIO().writeFileByBytes(fileName,content);
//	} catch (IOException e) {
//		e.printStackTrace();
//	}
	  //���ö�ȡ�ļ�
//	  List<Message> list= new ChattingRecordsIO().ReadFile(fileName);
//	  SimpleDateFormat sd = new SimpleDateFormat("HH:mm E");
//	  for(Message msg:list) {
//		  msg.setCreat_time_str(sd.format(msg.getCreat_time()));
//	  }
	  
//	  //��������ļ�����
////	  new ChattingRecordsIO().clearFile(fileName);
////	  System.out.println(new ChattingRecordsIO().ReadFile(fileName));
		JSONObject content = new JSONObject();
		content.put("cadid", "123");
		content.put("name", "�����Ľ�ɫ");
		content.put("ahs", "ashdka");
		List<JSONObject> list = new ArrayList<JSONObject>();
		list.add(content);
		new ChattingRecordsIO().writeFileByBytesWx("",list.toString());
	}

}
