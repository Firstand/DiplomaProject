package com.hlbrc.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * @Author: zhangyu 
 * @Description: 微信验证签名
 */
public class WeixinUtils {
    private static final String Token="zyweixin";//这里要与域名绑定时输入的Token一致！
    /**
     * 验证签名
     * @param timestamp
     * @param nonce
     * @param signature
     * @return
     */
    public static boolean check(String timestamp, String nonce, String signature) {
        String [] strs = new String[]{Token,timestamp,nonce};
        System.out.println(strs);
        Arrays.sort(strs);//字典排序
        String str = strs[0]+strs[1]+strs[2];
        String mysig = sha1(str);
        System.out.println(mysig);
        System.out.println(signature);
        return mysig.equalsIgnoreCase(signature);//将排序加密后的mysig字符串与微信传过来的微信加密签名signature比较
    }
    private static String sha1(String str) {
    	//加密
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("sha1");
            byte[] digest = messageDigest.digest(str.getBytes());
            char[] chars = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
            StringBuilder sb = new StringBuilder();
            for (byte b:digest) {
                sb.append(chars[(b>>4)&15]);
                sb.append(chars[(b)&15]);
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
