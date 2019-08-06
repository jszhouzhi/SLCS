package com.slzr.common.domain;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.slzr.set.domain.MerchDo;
import com.slzr.system.domain.UserDO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 当前登录用户
 * Created by zhy on 18/05/31.
 */


@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginUserDO {
	//用户ID
    Long id;

   // 用户名
    String userName;

    // 真实姓名
    String trueName;
    
    //手机号码
    String mobilePhone;

    // 用户类型ID
    Integer userTypeID;
    // 用户状态ID （0:禁用 1:正常）
    Integer stateID;
    // 最后登录时间
    Date lastLoginDate;
    // 最后登录IP
    String lastLoginIP;
    //登录次数
    Integer loginNum;
    
    //商户编码,用于区分不同县城
    String merchantCode;

    //角色
    List<Long> roleIds;
    
	 
	 
}
