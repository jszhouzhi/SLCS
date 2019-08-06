package com.slzr;

import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.slzr.SlzrWebApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SlzrWebApplication.class)
public class SlzrWebApplicationTests {

    //注入StringEncryptor
    @Autowired
    StringEncryptor encryptor; 

 
	@Test
	public void contextLoads() {
        String username = encryptor.encrypt("qrpay_union");
        System.out.println(username);        
        String password = encryptor.encrypt("Qrpay_union@2018");
        System.out.println(password);
        
        

		String username2 = encryptor.decrypt(username);
		String password2 = encryptor.decrypt(password);
		System.out.println(username2);                
		System.out.println(password2);    
 
 
	}

}
