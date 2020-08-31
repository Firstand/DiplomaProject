package com.hlbrc.util;

import java.util.HashMap;
import java.util.Map;


import org.apache.http.HttpResponse;



public class WeatherDispose {
	public static void main(String[] args) {
	    String host = "http://iweather.market.alicloudapi.com";
	    String path = "/history";
	    String method = "GET";
	    String appcode = "1d2d98c227144b2485872c21a549a342";
	    Map<String, String> headers = new HashMap<String, String>();
	    //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
	    headers.put("Authorization", "APPCODE " + appcode);
	    Map<String, String> querys = new HashMap<String, String>();
	    querys.put("area", "余杭");
	    querys.put("city", "杭州");
	    querys.put("date", "202001");
	    querys.put("prov", "浙江");

	    try {
	    	/**
	    	* 重要提示如下:
	    	* HttpUtils请从
	    	* https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/src/main/java/com/aliyun/api/gateway/demo/util/HttpUtils.java
	    	* 下载
	    	*
	    	* 相应的依赖请参照
	    	* https://github.com/aliyun/api-gateway-demo-sign-java/blob/master/pom.xml
	    	*/
	    	HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
	    	System.out.println(response.toString());
	    	//获取response的body
	    	//System.out.println(EntityUtils.toString(response.getEntity()));
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	}
	
}
