package com.slzr.common.domain;

import java.util.List;

import com.slzr.set.domain.MerchDo;
import com.slzr.system.domain.UserDO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 基础业务数据
 * Created by zhy on 18/05/31.
 */


@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseDO {
	
	 //登录用户
	 LoginUserDO user;
	 
	 //商户列表
	 List<MerchDo> merchantList;
	 
	 //当前页面权限列表
	 List<String> permissionList;
	 
	 //当前程序版本
	 String appVersion;
	 
	 //操作（控制器）地址前缀
	 String prefixUrl;
	 
	 //弹出框宽、高度（px）
	 List<String> popupArea;

	 
	 //页面标题
	 String pageTitle;
	 
	 //页面是否加载中，默认False
	 Boolean isProcessing;
	 
	 //调用API的令牌
	 String apiToken;
	 
}
