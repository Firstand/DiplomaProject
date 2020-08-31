package com.hlbrc.util;  
  
import java.math.BigInteger;  
import java.security.MessageDigest;  

//import com.sun.org.apache.xml.internal.security.utils.Base64;
/**
 * MD5���ܴ���
 * @author ZY
 *
 */
public class MD5 {  
      
	/*MD5,��һ����ϢժҪ�㷨������˵�����ǰ�һ����Ϣ�����ģ���ͨ��һ������ķ�ʽѹ���ɶ������ַ���32λ���ģ���
	 * ��Ϊ����ѹ����ʽ�ǻ���ʧ��Ϣ�ģ��������޷���ԭ�������ġ��ġ�
	 * ��Ȼ�޷�����ѧ���ƽ�MD5�㷨�����������ڼ�����߱�ǿ��ļ������������ǿ���ͨ������ٷ����ƽ���㷨��
	 * ������ø��㷨���ܣ�������ͨ�������Ρ��ķ�ʽ��߽����Ѷȡ�
	 * ���㷨����ഫһ������"salt",ָ��ͨ��MD5���ܵĴ������������ܹ���߽����Ѷȵġ�
	*/
	
     /** 
     * ���ַ���md5����(Сд+��ĸ) 
     * 
     * @param str ����Ҫ���ܵ��ַ��� 
     * @return  MD5���ܺ���ַ��� 
     */  
    public static String getMD5(String str) {  
        try {  
            // ����һ��MD5���ܼ���ժҪ  
            MessageDigest md = MessageDigest.getInstance("MD5");  
            // ����md5����  
            md.update(str.getBytes());  
            // digest()���ȷ������md5 hashֵ������ֵΪ8Ϊ�ַ�������Ϊmd5 hashֵ��16λ��hexֵ��ʵ���Ͼ���8λ���ַ�  
            // BigInteger������8λ���ַ���ת����16λhexֵ�����ַ�������ʾ���õ��ַ�����ʽ��hashֵ  
            return new BigInteger(1, md.digest()).toString(16);  
        } catch (Exception e) {  
           e.printStackTrace();  
           return null;  
        }  
    }  
      
      
    /** 
     * ���ַ���md5����(��д+����) 
     * 
     * @param str ����Ҫ���ܵ��ַ��� 
     * @return  MD5���ܺ���ַ��� 
     */  
      
    public String getMD5s(String s) {  
        char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};         
  
        try {
        	//����ȡ����sת��Ϊ�ֽ����͵�����
            byte[] btInput = s.getBytes();  
            // ���MD5ժҪ�㷨�� MessageDigest ����  
            MessageDigest mdInst = MessageDigest.getInstance("MD5");  
            // ʹ��ָ�����ֽڸ���ժҪ  
            mdInst.update(btInput);  
            // �������  
            byte[] md = mdInst.digest();  
            // ������ת����ʮ�����Ƶ��ַ�����ʽ  
            int j = md.length;  
            char str[] = new char[j * 2];  
            int k = 0;  
            for (int i = 0; i < j; i++) {  
                byte byte0 = md[i];  
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];  
                str[k++] = hexDigits[byte0 & 0xf];  
            }  
            return new String(str);  
        } catch (Exception e) {  
            e.printStackTrace();  
            return null;  
        }  
    }  
    
  
        public static void main(String[] args) {  
        //String md5 = MD5("123456");  
        String md52 = getMD5("123456" ); 
        //System.out.println(md5);
        System.out.println(md52);
    }
}  