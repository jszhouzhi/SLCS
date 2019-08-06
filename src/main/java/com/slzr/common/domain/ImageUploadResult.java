package com.slzr.common.domain;

public class ImageUploadResult {
	   //结果码,0表示成功,其他失败    
	   private Integer code;    
	 
	   //结果信息,上传失败后返回    
	   private String msg;    
	 
	   //图片数据    
	   private Data data;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public ImageUploadResult(Integer code, String msg, Data data) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	public ImageUploadResult() {
		super();
	}
	   
	   
}
