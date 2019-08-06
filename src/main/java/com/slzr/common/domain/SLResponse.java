package com.slzr.common.domain;

import com.alibaba.fastjson.annotation.JSONField;
import com.slzr.common.domain.enums.ErrCode;

public class SLResponse {
	@JSONField  (name = "Code")
	private Integer code;
	@JSONField  (name = "Message")
	private String message;
	@JSONField  (name = "Data")
	private Object data;
	
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	public SLResponse(ErrCode errCode,String message) {
		this.code = errCode.getValue();
		this.message = message;
	}
	public SLResponse(int errCode,String message) {
		this.code = errCode;
		this.message = message;
	}	 
	
	public SLResponse() {
		// TODO Auto-generated constructor stub
	}

	
	
}
