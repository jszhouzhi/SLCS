package com.slzr.common.utils;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class MD5Utils {
	private static final String SALT = "1qazxsw2";

	private static final String ALGORITH_NAME = "md5";

	private static final int HASH_ITERATIONS = 2;

	public static String encrypt(String pswd) {
		String newPassword = new SimpleHash(ALGORITH_NAME, pswd, ByteSource.Util.bytes(SALT), HASH_ITERATIONS).toHex();
		return newPassword;
	}

	public static String encrypt(String username, String pswd) {
		String newPassword = new SimpleHash(ALGORITH_NAME, pswd, ByteSource.Util.bytes(username + SALT),
				HASH_ITERATIONS).toHex();
		return newPassword;
	}
	public static void main(String[] args) {
		
		//System.out.println(MD5Utils.encrypt("admin", "1"));
		//System.out.println(MD5Utils.encrypt("kjliu", "lkj@2019"));
	}
	
/*	public static void main(String[] args) {
		
		System.out.println(MD5Utils.encrypt("admin", "111111"));
		
		System.out.println(ToMD5("admin1qazxsw2111111"));
		
		String str = ToMD5("admin1qazxsw2111111");
		
		byte[] sa = str.getBytes();
		
		System.out.println(str);
	}

	
	public static String ToMD5(String buff){
		String result = ""; 		
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
	    return result;  		
	}*/

}
