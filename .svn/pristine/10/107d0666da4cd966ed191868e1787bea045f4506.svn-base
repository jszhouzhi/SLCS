package com.slzr.common.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SignatureUtil {
	public static void main(String[] args) {
	       // TODO Auto-generated method stub  
        //字典序列排序  
        Map<String,String> paraMap = new HashMap<String,String>();  
        paraMap.put("total_fee","200");  
        paraMap.put("appid", "wxd678efh567hg6787");  
        paraMap.put("body", "充值中心-会员充值");  
        paraMap.put("out_trade_no","20150806125346");  
        String url =formatUrlMap(paraMap, false, false);  
        System.out.println(url);    
	}
	
	
	
	/** 
	 *  
	 * 方法用途: 对所有传入参数按照字段名的Unicode码从小到大排序（字典序），并且生成url参数串<br> 
	 * 实现步骤: <br> 
	 *  
	 * @param paraMap   要排序的Map对象 
	 * @param urlEncode   是否需要URLENCODE 
	 * @param keyToLower    是否需要将Key转换为全小写 
	 *            true:key转化成小写，false:不转化 
	 * @return 
	 */  
	public static String formatUrlMap(Map<String, String> paraMap, boolean urlEncode, boolean keyToLower)  
	{  
	    String buff = "";  
	    Map<String, String> tmpMap = paraMap;  
	    try  
	    {  
	        List<Map.Entry<String, String>> infoIds = new ArrayList<Map.Entry<String, String>>(tmpMap.entrySet());  
	        // 对所有传入参数按照字段名的 ASCII 码从小到大排序（字典序）  
	        Collections.sort(infoIds, new Comparator<Map.Entry<String, String>>()  
	        {  

	            @Override  
	            public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2)  
	            {  
	                return (o1.getKey()).toString().compareTo(o2.getKey());  
	            }  
	        });  
	        // 构造URL 键值对的格式  
	        StringBuilder buf = new StringBuilder();  
	        for (Map.Entry<String, String> item : infoIds)  
	        {  
	            if (StringUtils.isNotBlank(item.getKey()))  
	            {  
	                String key = item.getKey();  
	                String val = item.getValue();  
	                if (urlEncode)  
	                {  
	                    val = URLEncoder.encode(val, "utf-8");  
	                }  
	                if (keyToLower)  
	                {  
	                    buf.append(key.toLowerCase() + "=" + val);  
	                } else  
	                {  
	                    buf.append(key + "=" + val);  
	                }  
	                buf.append("&");  
	            }  

	        }  
	        buff = buf.toString();  
	        if (buff.isEmpty() == false)  
	        {  
	            buff = buff.substring(0, buff.length() - 1);  
	        }  
	    } catch (Exception e)  
	    {  
	       return null;  
	    }  
	    
	    //最后把签名做MD5   
	    String result = "";  
	    //String str = "123456";  
	      
	    MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	    try {
			md5.update((buff).getBytes("GB2312"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	    byte b[] = md5.digest();  
	      
	    int i;  
	    StringBuffer buf = new StringBuffer("");  
	      
	    for(int offset=0; offset<b.length; offset++){  
	        i = b[offset];  
	        if(i<0){  
	            i+=256;  
	        }  
	        if(i<16){  
	            buf.append("0");  
	        }  
	        buf.append(Integer.toHexString(i));  
	    }  
	      
	    result = buf.toString();  
	    
	    
	    return result.toUpperCase();  
	} 
	
}



 