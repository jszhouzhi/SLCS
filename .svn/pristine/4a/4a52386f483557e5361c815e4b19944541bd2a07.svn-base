package com.slzr.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.slzr.common.utils.CommUtil;

@Component
@ConfigurationProperties(prefix="slzr")
public class BootdoConfig {
	//上传路径
	private String uploadPath;
	
	//登录页项目名
	private String proName;
	
	//title标题
	private String proTitle;
	
	//默认接口地址URL配置
	private String interfaceUrl;
	
	//当前程序版本
	private String appVersion;
	
	
	private String appId;
	
	private String appKey;
	
	private String appType;
	
	
	
	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getAppKey() {
		return appKey;
	}

	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}

	public String getAppType() {
		return appType;
	}

	public void setAppType(String appType) {
		this.appType = appType;
	}

	public String getAppVersion() {
		return appVersion;
	}

	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}

	public String getInterfaceUrl() {
		return interfaceUrl;
	}

	public void setInterfaceUrl(String interfaceUrl) {
		this.interfaceUrl = interfaceUrl;
	}

	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public String getProTitle() {
		return proTitle;
	}

	public void setProTitle(String proTitle) {
		this.proTitle = proTitle;
	}

	public String getUploadPath() {
		return uploadPath;
	}

	public void setUploadPath(String uploadPath) {
		this.uploadPath = uploadPath;
	}
	
	
	@Bean
	public int readPropToStatic() {
		
		/**
		 * 设置CommUtil的apiDomain
		 */
		CommUtil.setApiDomain(interfaceUrl);
		CommUtil.setAppId(appId);
		CommUtil.setAppType(appType);
		CommUtil.setAppKey(appKey);
		return 0;
	}
}
