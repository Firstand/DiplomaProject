package com.hlbrc.util;

import java.io.UnsupportedEncodingException;

public class UrlProcessing {
	private final static String ENCODE = "utf-8"; 
    /**
     * URL 解码
     *
     * @return String
     * @author lifq
     * @date 2015-3-17 下午04:09:51
     */
    public static String getURLDecoderString(String str) {
        String result = "";
        if (null == str) {
            return "";
        }
        try {
            result = java.net.URLDecoder.decode(str, ENCODE);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }
    /**
     * URL 转码
     *
     * @return String
     * @author lifq
     * @date 2015-3-17 下午04:10:28
     */
    public static String getURLEncoderString(String str) {
        String result = "";
        if (null == str) {
            return "";
        }
        try {
            result = java.net.URLEncoder.encode(str, ENCODE);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }
    public static void main(String[] args) {
    	String str1 = "%3Cp%3E%3Cimg%20src%3D%22http%3A%2F%2F%7BIMGIP%7D%2Fupload%2Fgoods%2F201906161027479513.jpg%22%20title%3D%22G-3126%E8%AF%A6%E6%83%85_03.jpg%22%2F%3E%3C%2Fp%3E%3Cp%3E%3Cimg%20src%3D%22http%3A%2F%2F%7BIMGIP%7D%2Fupload%2Fgoods%2F201906161027487433.jpg%22%20title%3D%22G-3126%E8%AF%A6%E6%83%85_01.jpg%22%2F%3E%3C%2Fp%3E%3Cp%3E%3Cimg%20src%3D%22http%3A%2F%2F%7BIMGIP%7D%2Fupload%2Fgoods%2F201906161027493361.jpg%22%20title%3D%22G-3126%E8%AF%A6%E6%83%85_02.jpg%22%2F%3E%3C%2Fp%3E%3Cp%3E%3Cbr%2F%3E%3C%2Fp%3E";
		String str = "<p><img src=\"http://{IMGIP}/upload/goods/201906161026374064.jpg\"/></p><p><br/></p>";
		System.out.println(getURLDecoderString("http%3A%2F%2Fdemo.dcloud.net.cn%2Fhelloh5%2Fpayment%2F"));
		System.out.println(getURLEncoderString(str));
		
	}
}
