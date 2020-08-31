package com.hlbrc.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.SendFailedException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import org.apache.commons.mail.HtmlEmail;

public class QqEmailSendMessage {
	/**
	 * ���ı�
	 * @return
	 */
	public static boolean sendEmail(String receiver){
	    try {
	        //������ҳ�������
		    HtmlEmail email=new HtmlEmail();
		    //��������
		    email.setDebug(true);
		    //����ΪQQ������Ϊ����������
		    email.setHostName("SMTP.qq.com");
		    email.setSmtpPort(587);
		    //qq�������֤��Ϣ
		    email.setAuthentication("hlbrc.diplomaproject@foxmail.com","uhygapoqnfmydjjd");
		    //�����ʼ�������
		    email.setFrom("hlbrc.diplomaproject@foxmail.com");
		    //�����ʼ�������
		    email.addTo(receiver);
		    //���÷��͵�����
		    email.setContent("��磬�������ˣ�������û��", "text/html;charset=UTF-8");
		    //�����������
		    email.setSubject("��Ա����ϵͳ");
		    //ִ���ʼ�����
	        System.err.println(email.send());
	        return true;
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	    return false;
	}

	
	/**
	 * ����һ�ݱ��ص��ʼ�
	 * @param args
	 * @throws MessagingException 
	 * @throws IOException 
	 */
	public static boolean setCon(String replay) {
		try {
		    //����
		    Session session = Session.getDefaultInstance(new Properties());
		    //�ʼ�
		    MimeMessage msg = new MimeMessage(session);
		    msg.addHeader("X-Mailer","Microsoft Outlook Express 6.00.2900.2869");
		    //��������
		    msg.setSubject("֪ͨ");
		    //�����ˣ�ע�����ĵĴ���
		    msg.setFrom(new InternetAddress("\"" + MimeUtility.encodeText("��Ա����ϵͳ") + "\"<hlbrc.diplomaproject@foxmail.com>"));
		    //�����ʼ��ظ���
		    msg.setReplyTo(new Address[]{new InternetAddress(replay)});
		    //�����ʼ���MINE��Ϣ��
		    MimeMultipart msgMultipart = new MimeMultipart("alternative");//��ϵ���Ϲ�ϵ
		    //�����ʼ���MINE��Ϣ��
		    msg.setContent(msgMultipart);
		    //��������
		    MimeBodyPart content = new MimeBodyPart();
		    //�����ݼ��뵽 MINE��Ϣ����
		    msgMultipart.addBodyPart(content);
		    //���ģ�ͼƬ�����ֲ��֣�
		    //"related"����Я�����ָ����⣬�����Խ�������������Ƕ��Դ�ķ�ʽ�洢���ʼ���
		    MimeMultipart bodyMultipart  = new MimeMultipart("alternative");
		    //��������Ϊ����
		    content.setContent(bodyMultipart);
		    //html���벿��
		    MimeBodyPart htmlPart = new MimeBodyPart();
		    //�������ͼƬ��html����
		    bodyMultipart.addBodyPart(htmlPart);
		    //html��Ƕ�׵�ͼƬ����
		    MimeBodyPart imgPart = new MimeBodyPart();
		    //˵��html�е�img��ǩ��src�����õ��Ǵ�ͼƬ
		    imgPart.setHeader("Content-Location", "/cgi-bin/viewfile?f=CBC89A0D66C7B22374804C974FDFC907EF370F9D6EC9090C33587236FB1E23EA760B6E46F7A2B610B5988E9FDCE9EB81B6674E8EAC666B8577607D802586BD81423B0B14A6588A2567925300D680382641FCBAC2BCFA752EB4DB01BB52468F15&mailid=ZL3410-oIyeOGpFWXZ%7EUglWBMuRTa7&sid=7MBfpPZ7Qm1zazBv&net=58682980");
			String strHtml="<div class=\"WordSection1\">\r\n" + 
					"			<div style=\"height: 330px;\">\r\n" + 
					"				<p>��ã�</p>\r\n" + 
					"				<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;�Һ���ѽ��</p>\r\n" + 
					"			</div>\r\n" + 
					"			<div align=\"right\">\r\n" + 
					"				<p class=\"MsoNormal\" style=\"text-align:right\"><b><span style=\"font-size:13.5pt;font-family:����;color:gray\">��Ա����ϵͳ</span></b><span lang=\"EN-US\" style=\"font-size:13.5pt;font-family:����;color:black\"><o:p></o:p></span></p>\r\n" + 
					"				<p class=\"MsoNormal\" style=\"line-height:15.75pt\"><b><span style=\"font-size:13.5pt;font-family:����;color:gray\">��ABU��Ӫ������</span></b><span lang=\"EN-US\" style=\"font-size:13.5pt;font-family:����;color:black\"><o:p></o:p></span></p>\r\n" + 
					"				<p class=\"MsoNormal\" style=\"line-height:15.75pt\"><b><span style=\"font-size:13.5pt;font-family:����;color:gray\">�����ͻ���ҵ����</span></b><span lang=\"EN-US\" style=\"font-size:13.5pt;font-family:&quot;΢���ź�&quot;,sans-serif;color:black\"><o:p></o:p></span></p>\r\n" + 
					"				<p class=\"MsoNormal\" style=\"line-height:15.75pt\"><b><span style=\"font-size:13.5pt;font-family:����;color:gray\">��������Ƽ��ɷ����޹�˾</span></b><span lang=\"EN-US\" style=\"font-size:13.5pt;font-family:����;color:black\"><o:p></o:p></span></p>\r\n" + 
					"				<p class=\"MsoNormal\" style=\"line-height:15.75pt\"><span style=\"font-size:10.0pt;font-family:����;color:gray\">��ַ��<span onmouseover=\"QMReadMail.showLocationTip(this)\" class=\"readmail_locationTip\" onmouseout=\"QMReadMail.hideLocationTip(this)\" over=\"0\" style=\"z-index: auto;\">�����г�������յ·������������ʮ��·</span><span lang=\"EN-US\">8</span>��¥<span lang=\"EN-US\">B</span>��<span lang=\"EN-US\">2</span>��</span><span lang=\"EN-US\" style=\"font-size:10.0pt;font-family:&quot;Calibri&quot;,sans-serif;color:gray\">&nbsp;</span><span lang=\"EN-US\" style=\"font-size:13.5pt;font-family:����;color:black\"><o:p></o:p></span></p>\r\n" + 
					"				<p class=\"MsoNormal\" style=\"line-height:15.75pt\"><span style=\"font-size:10.0pt;font-family:����;color:gray\">���䣺</span><u><span lang=\"EN-US\" style=\"font-size:10.0pt;font-family:����;color:blue\"><a href=\"mailto:zhangyu18@yonyou.com\" rel=\"noopener\" target=\"_blank\"><span style=\"color:#0563C1\">zhangyu18@yonyou.com</span></a></span></u><span lang=\"EN-US\" style=\"font-size:10.0pt;font-family:&quot;Calibri&quot;,sans-serif;color:gray\">&nbsp;</span><span lang=\"EN-US\" style=\"font-size:13.5pt;font-family:����;color:black\"><o:p></o:p></span></p>\r\n" + 
					"				<p class=\"MsoNormal\" style=\"line-height:15.75pt\"><span style=\"font-size:10.0pt;font-family:����;color:gray\">�绰��<span lang=\"EN-US\"><span style=\"border-bottom:1px dashed #ccc;z-index:1\" t=\"7\" onclick=\"return false;\" data=\"010-86482538\">010-86482538</span> </span>\r\n" + 
					"					</span><span lang=\"EN-US\" style=\"font-size:10.0pt;font-family:&quot;Calibri&quot;,sans-serif;color:gray\">&nbsp;</span><span lang=\"EN-US\" style=\"font-size:10.0pt;font-family:����;color:gray\"> <span style=\"border-bottom: 1px dashed rgb(204, 204, 204); z-index: 1; position: static;\" t=\"7\" onclick=\"return false;\" data=\"15540061217\" isout=\"1\">15540061217</span></span><span lang=\"EN-US\" style=\"font-size:13.5pt;font-family:����;color:black\"><o:p></o:p></span></p>\r\n" + 
					"				<p class=\"MsoNormal\" style=\"line-height:15.75pt;\"><span style=\"font-size:10.0pt;font-family:����;color:gray\">��ַ��<span lang=\"EN-US\"><a href=\"http://www.yonyou.com/\" rel=\"noopener\" target=\"_blank\"><span style=\"color:purple\">www.yonyou.com</span></a>\r\n" + 
					"					</span>\r\n" + 
					"					</span><span lang=\"EN-US\" style=\"font-size:13.5pt;font-family:����;color:black\"><o:p></o:p></span></p>\r\n" + 
					"				<p class=\"MsoNormal\" style=\"line-height:15.75pt\"><span lang=\"EN-US\" style=\"font-size:13.5pt;font-family:����;color:black\"><o:p>&nbsp;</o:p></span></p>\r\n" + 
					"				<p class=\"MsoNormal\" style=\"line-height:15.75pt\"><span lang=\"EN-US\" style=\"font-size:13.5pt;font-family:����;color:black\"><img border=\"0\" width=\"349\" height=\"50\" style=\"width:3.6333in;height:.6333in;float: right ;\" id=\"_x0000_i1025\" src=\"/cgi-bin/viewfile?f=CBC89A0D66C7B22374804C974FDFC907EF370F9D6EC9090C33587236FB1E23EA760B6E46F7A2B610B5988E9FDCE9EB81B6674E8EAC666B8577607D802586BD81423B0B14A6588A2567925300D680382641FCBAC2BCFA752EB4DB01BB52468F15&mailid=ZL3410-oIyeOGpFWXZ%7EUglWBMuRTa7&sid=7MBfpPZ7Qm1zazBv&net=58682980\"><o:p></o:p></span></p>\r\n" + 
					"				<p class=\"MsoNormal\" align=\"left\" style=\"text-align:left\"><span lang=\"EN-US\" style=\"font-size:12.0pt;font-family:����\"><o:p>&nbsp;</o:p></span></p>\r\n" + 
					"			</div>\r\n" + 
					"		</div>";
			 //html����
		    htmlPart.setContent(strHtml,"text/html;charset=utf-8");
		
		    //�����ļ��ʼ�
		    msg.saveChanges();
		    File file = new File("C:/myChattingRecords/QqEmail/demo.eml");
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
		    //���
		    OutputStream os = new FileOutputStream(file);
		    msg.writeTo(os);
		    os.close();
		    return true;
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	    return false;
		}
	/**
	 * ���͸����ʼ�
	 * @param args
	 * @throws FileNotFoundException
	 * @throws MessagingException
	 */
	public static boolean sendComplexEmail(String receiver) {
		try {
		    // ���Զ���
		    Properties properties = new Properties();
		    // ����debug���� ����ӡ��Ϣ
		    properties.setProperty("mail.debug", "true");
		    // ���ͷ�������Ҫ�����֤
		    properties.setProperty("mail.smtp.auth", "true");
		    // ���ͷ������˿ڣ����Բ����ã�Ĭ����25
		    properties.setProperty("mail.smtp.port", "25");
		    // �����ʼ�Э������
		    properties.setProperty("mail.transport.protocol", "smtp");
		    // �����ʼ�������������
		    properties.setProperty("mail.host", "smtp.qq.com");
		    // ������Ϣ
		    Session session = Session.getInstance(properties, new Authenticator() {
		        @Override
		        protected PasswordAuthentication getPasswordAuthentication() {
		            // ��session�������˻���Ϣ��Transport�����ʼ�ʱ��ʹ��
		            return new PasswordAuthentication("hlbrc.diplomaproject@foxmail.com","uhygapoqnfmydjjd");
		        }
		    });
		
		    //��ȡ�����ʼ�
		    Message message = new MimeMessage(session, new FileInputStream(new File("C:/myChattingRecords/QqEmail/demo.eml")));
//		    message.addHeader("X-Mailer","Microsoft Outlook Express 6.00.2900.2869");
		    //�����ʼ�
		    Transport.send(message, InternetAddress.parse(receiver));
		    return true;
	    } catch(SendFailedException e) {
	    	System.err.println(e.getMessage()+":�����ռ��˵�ַ�Ƿ���ȷ��");
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	    return false;
	}
	/**
	 *  ����qq���䷢��
	 * @param zch
	 */
	public static void main(String[] args) {
		String testPople = "1529827884@qq.com";
//	    boolean b = sendEmail(testPople);
//	    System.out.println("����"+(b?"�ɹ�":"ʧ��"));

		boolean A = setCon(testPople);
		System.out.println(new Date());
		System.err.println(A?"Email�����ɹ�":"Email����ʧ��");
		if(A) {
			A = sendComplexEmail(testPople);
			System.err.println("����"+(A?"Email�ɹ�":"Emailʧ��"));
		}
		else {
			System.err.println("����Emailʧ��");
		}
	}
}
