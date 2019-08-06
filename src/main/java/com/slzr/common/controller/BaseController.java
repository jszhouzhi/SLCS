package com.slzr.common.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.slzr.common.config.BootdoConfig;
import com.slzr.common.domain.BaseDO;
import com.slzr.common.domain.LoginUserDO;
import com.slzr.common.utils.CommUtil;
import com.slzr.common.utils.ExcelExportTool;
import com.slzr.common.utils.ShiroUtils;
import com.slzr.set.domain.MerchDo;
import com.slzr.set.service.MerchService;
import com.slzr.system.domain.UserDO;

@Controller
public class BaseController {


	public UserDO getUser() {
		return ShiroUtils.getUser();
	}

	public Long getId() {
		return getUser().getId();
	}

	public String getUserName() {
		return getUser().getUserName();
	}
	
	public String getMerchantCode() {
		return getUser().getMerchantCode();
	}
	
	protected BaseDO baseDO = new BaseDO();
	
	@Autowired
	protected MerchService merchService;
	
	@Autowired
	BootdoConfig bootdoConfig;
	
 
	/**
	 * 设置页面通用数据
	 * @param baseDO
	 */
	protected  void initBaseDO() {

		HashMap<String,Object> params=new HashMap<>();
		   
		   
		UserDO userDO = getUser();//userService.get(getId());
		
		//当前用户信息
		LoginUserDO loginUserDO = new LoginUserDO(	userDO.getId(),
													userDO.getUserName(),
													userDO.getTrueName(),
													userDO.getMobilePhone(),
													userDO.getUserTypeID(), 
													userDO.getStateID(), 
													userDO.getLastLoginDate(), 
													userDO.getLastLoginIP(),
													userDO.getLoginNum(), 
													userDO.getMerchantCode(),
													userDO.getRoleIds());
		
		//当前用户可访问的商户列表
		List<MerchDo> merchantList=null;
		String merchantCode = getMerchantCode();
		if(merchantCode ==null|| merchantCode.equals("")){
			merchantList=merchService.list(params);
		}else{
			params.put("merchantCode",merchantCode);
			merchantList=merchService.list(params);
		}
		
		//用户具有哪些按钮权限
		List<String> permissions = new ArrayList<String>();
		for(String permission : baseDO.getPermissionList()) {
			if(ShiroUtils.isPermitted(permission))
				permissions.add(permission);
		}
	
		baseDO.setAppVersion(bootdoConfig.getAppVersion());
		baseDO.setUser(loginUserDO);
		baseDO.setMerchantList(merchantList);
		baseDO.setPermissionList(permissions);
		
		//页面提交状态（默认未提交）
		baseDO.setIsProcessing(false);
		
		CommUtil.setBaseDO(baseDO);
		 
	}
	
	
	public  void export(HttpServletResponse response,/*ExportType exportType,*/String reportTitle,
		LinkedHashMap<String, String> fields,List<?> list) {
		
		try{
		String fileName = reportTitle + ".xls";
		
		byte[] b = fileName.getBytes("UTF-8"); 
	    String formatFileName = new String(b,"ISO-8859-1");		      	 
	    response.setContentType("application/ms-excel");
	    response.setHeader("Content-disposition", "attachment;filename="+formatFileName);	
	    
	    ExcelExportTool.export(reportTitle, fields, list, response);
	    
		} catch(Exception e){
			e.printStackTrace();
		}finally{
			list=null;
		}
	}
}