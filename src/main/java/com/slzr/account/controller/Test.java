package com.slzr.account.controller;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.slzr.account.domain.AccountCancelDO;
import com.slzr.common.domain.SLRequest;
import com.slzr.common.utils.HttpUtil;
import com.slzr.common.utils.R;
import com.slzr.common.utils.SignatureUtil;
import com.slzr.common.utils.YXDate;

public class Test {
	
	public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
/*		String UserName = "WECHAT.oSEhPwKIXVHQnp4p1t0lxYrUdK_Y";
		String Password = tomd5(UserName);*/
/*		String UserName = "WECHAT.oSEhPwCkLDDs-nJs3nvUqByZsKXM";
		String Password = "24A59B00F8EB9B170FCEA86B4EEA3FBC";*/
		String UserName = "WECHAT.oLVxt00bpejjGAN4zXgE_T1fDxgs";
		String Password = "E8564538C5914790E02799486222A156";
		String url ="http://slp1.slzrsz.com:8888/api/sl/GetToken";  //签名接口
		String AppKey= "A0E6C376000F44AEF13F58614C379DD9";

		
		SLRequest slrequest = new SLRequest();
		Map<String, Object> Data = new HashMap<String, Object>();
		Data.put("UserName", UserName);
		Data.put("Password", Password);
		
		slrequest.setAppId("slzrwechat");
		slrequest.setAppType("WECHAT");
		slrequest.setData(Data);
		slrequest.setTimeStamp(YXDate.getTime());
		slrequest.setNonce("62A0E888F5033BC65BF8D786222661"+new java.util.Random().nextInt(100));
		slrequest.setUrl(url);
		
		slrequest.setSignType("MD5");
		slrequest.setSignVersion("1.0");
		
        Map<String,String> paraMap = new HashMap<String,String>();  
        paraMap.put("AppId",slrequest.getAppId());  
        paraMap.put("AppType", slrequest.getAppType());  
        paraMap.put("Data", JSON.toJSONString(slrequest.getData()));  
        paraMap.put("Nonce",slrequest.getNonce()); 
        paraMap.put("TimeStamp",slrequest.getTimeStamp()); 
        paraMap.put("Url",slrequest.getUrl()); 
        paraMap.put("AppKey",AppKey); 
        
        String token = null;
		try {
			String signature =SignatureUtil.formatUrlMap(paraMap, false, false); 
			
			slrequest.setSignature(signature);
			
			String map = JSONObject.toJSONString(slrequest);		
					
			String msg= HttpUtil.sendPost(url,map,"");
			
			JSONObject jsonObject = JSONObject.parseObject(msg);
			JSONObject jsonobj=(JSONObject) jsonObject.get("Data");
			token = (String) jsonobj.get("Token");
		} catch (Exception e1) {
			System.out.println("获取token签名失败"+e1);
			e1.printStackTrace();
			
		}
		System.out.println("token："+token);
		
		
		String appId = "slzrwechat";
		String appType = "WECHAT";
		String nonce = "62A0E888F5033BC65BF8D786222661"+new java.util.Random().nextInt(100);
		String timeStamp = YXDate.getTime();
		String msgurl = "http://slp1.slzrsz.com:8888/api/sl/GetAccountInfo";
		String appKey = "A0E6C376000F44AEF13F58614C379DD9";
		
        Map<String,String> paraMap2 = new HashMap<String,String>();  
        paraMap2.put("AppId",appId);  
        paraMap2.put("AppType",appType);         
        paraMap2.put("Nonce",nonce); 
        paraMap2.put("TimeStamp",timeStamp); 
        paraMap2.put("Url",msgurl); 
        paraMap2.put("AppKey",appKey); 
        paraMap2.put("Data", JSONObject.toJSONString("03578888043706810001"));  
        
		String sign =SignatureUtil.formatUrlMap(paraMap2, false, false); 

		SLRequest slrequest2 = new SLRequest();
		 
		
		slrequest2.setAppType(appType);
		slrequest2.setAppId(appId);
		slrequest2.setTimeStamp(timeStamp);
		slrequest2.setNonce(nonce);
		slrequest2.setUrl(msgurl);
		slrequest2.setData("03578888043706810001");
		
		slrequest2.setSignature(sign);
		slrequest2.setSignType("MD5");
		slrequest2.setSignVersion("1.0");
		

		
		
		
		try {
			String slrequestMap = JSONObject.toJSONString(slrequest2);	
			String msg2= HttpUtil.sendPost(msgurl,slrequestMap,token);
			System.out.println(msg2);
	
		} catch (Exception e) {	
			System.out.println("发送失败"+e);
			e.printStackTrace();
			
		} 
	}
	
	
	public static String  tomd5 (String str) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		
		String result = "";
		//String str = "123456";
		 
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		md5.update((str).getBytes("UTF-8"));
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
