package com.slzr.common.domain;

import com.alibaba.fastjson.annotation.JSONField;

public class SLRequest {
	@JSONField  (name = "AppType")
	private String appType;
	@JSONField  (name = "AppId")
	private String appId;
	@JSONField  (name = "TimeStamp")
	private String timeStamp;
	@JSONField  (name = "Nonce")
	private String nonce;
	@JSONField  (name = "Url")
	private String url;
	@JSONField  (name = "Data")
	private  Object data;
	@JSONField  (name = "Signature")
	private String Signature;
	
	@JSONField  (name = "SignType")
	private String signType;
	@JSONField  (name = "SignVersion")
	private String signVersion;
	
	
	public String getSignType() {
		return signType;
	}
	public void setSignType(String signType) {
		this.signType = signType;
	}
	public String getSignVersion() {
		return signVersion;
	}
	public void setSignVersion(String signVersion) {
		this.signVersion = signVersion;
	}
	public String getAppType() {
		return appType;
	}
	public void setAppType(String appType) {
		this.appType = appType;
	}
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getNonce() {
		return nonce;
	}
	public void setNonce(String nonce) {
		this.nonce = nonce;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public String getSignature() {
		return Signature;
	}
	public void setSignature(String signature) {
		Signature = signature;
	}
	
	

	
	
}
