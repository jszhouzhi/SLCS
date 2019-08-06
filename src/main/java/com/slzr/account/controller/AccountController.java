package com.slzr.account.controller;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.slzr.common.annotation.SystemControllerLog;
import com.slzr.common.controller.BaseController;
import com.slzr.common.domain.SLResponse;
import com.slzr.common.domain.enums.ErrCode;
import com.slzr.set.domain.MerchDo;
import com.slzr.set.service.MerchService;
import com.slzr.system.domain.UserDO;
import com.slzr.system.service.UserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.slzr.account.domain.AccountCancelDO;
import com.slzr.account.domain.AccountDO;
import com.slzr.account.service.AccountService;
import com.slzr.common.annotation.Log;
import com.slzr.common.config.Constant;
import com.slzr.common.utils.CommUtil;
import com.slzr.common.utils.DateUtils;
import com.slzr.common.utils.ExcelExportTool;
import com.slzr.common.utils.PageUtils;
import com.slzr.common.utils.Query;
import com.slzr.common.utils.R;

/**
 * 账户管理
 * @author lc
 * @date 2018-03-18 16:45:51
 */
 
@Controller
@RequestMapping("/account/account")
public class AccountController extends BaseController{
	@Autowired
	private AccountService accountService;


	@Autowired
	UserService userService;

	@Autowired
	private MerchService merchService;
	
	@GetMapping()
	@SystemControllerLog(description="0")
	@RequiresPermissions("account:account:account")
	String Account(Model model){
		HashMap<String,Object> params=new HashMap<>();
		UserDO userDO = userService.get(getId());
		List<MerchDo> merchantList=null;
		if(userDO.getMerchantCode()==null||userDO.getMerchantCode().equals("")){
			merchantList=merchService.list(params);
		}else{
			params.put("merchantCode",userDO.getMerchantCode());
			merchantList=merchService.list(params);
		}
		model.addAttribute("merchantList",merchantList);
	    return "account/account/account";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("account:account:account")
	public PageUtils list(@RequestParam Map<String, Object> params){
		UserDO userDO = userService.get(getId());
		PageUtils pageUtil=null;


		if(userDO.getMerchantCode()==null||userDO.getMerchantCode().equals("")){
/*			Query query = new Query(params);
			PageHelper.startPage(Integer.parseInt(params.get("offset").toString()),
					Integer.parseInt(params.get("limit").toString()));
			List<AccountDO> sysUserList = accountService.list(query);
			int total = accountService.count(query);
			 pageUtil = new PageUtils(sysUserList, total);*/
			
			Query query = new Query(params);
			List<AccountDO> sysUserList = accountService.list(query);
			int total = accountService.count(query);
			pageUtil = new PageUtils(sysUserList, total);
		}else{
			/*params.put("merchantCode",userDO.getMerchantCode());
			Query query = new Query(params);
			PageHelper.startPage(Integer.parseInt(params.get("offset").toString()),
					Integer.parseInt(params.get("limit").toString()));
			List<AccountDO> sysUserList = accountService.list(query);
			int total = accountService.count(query);
			 pageUtil = new PageUtils(sysUserList, total);*/
			
			params.put("merchantCode",userDO.getMerchantCode());
			Query query = new Query(params);
			List<AccountDO> sysUserList=accountService.list(query);
			int total = accountService.count(query);
			pageUtil = new PageUtils(sysUserList, total);
		}

		return pageUtil;
	}
	
	/**
	 * 注销
	 * @param accountno
	 * @return
	 */
	
	
	/**
	 * 注销
	 * @param accountno
	 * @return
	 */
	
	
	@PostMapping("/operation")
	@SystemControllerLog(description="6")
	@ResponseBody
	R operation(String accountno,String operationType) {
		
		AccountDO accountDO = accountService.getbyAccountNO(accountno);
		
		AccountDO account = new AccountDO();
		
		account.setMerchantcode(accountDO.getMerchantcode());
		account.setUid(accountDO.getUid());
		account.setAccounttype(accountDO.getAccounttype());
		account.setAccountno(accountno);
		account.setMobilephone(accountDO.getMobilephone());
		account.setCardtypecode(accountDO.getCardtypecode());
		account.setSubcardtypecode(accountDO.getSubcardtypecode());
		account.setTopupcounter(accountDO.getTopupcounter());
		account.setDebitcounter(accountDO.getDebitcounter());
		account.setLastmakepaytickettime(accountDO.getLastmakepaytickettime());
		account.setLasttopupamount(accountDO.getLasttopupamount());
		account.setLasttopuptime(accountDO.getLasttopuptime());
		account.setLastdebitamount(accountDO.getLastdebitamount());		
		account.setLastdebittime(accountDO.getLastdebittime());
		account.setTotaltopupamount(accountDO.getTotaltopupamount());
		account.setTotaldebitamount(accountDO.getTotaldebitamount());
		account.setBalance(accountDO.getBalance());
		account.setScore(accountDO.getScore());
		account.setFreebalance(accountDO.getFreebalance());
		account.setFreetimes(accountDO.getFreetimes());
		account.setAccountexpiretime(accountDO.getAccountexpiretime());
		

		
		AccountDO account2 = new AccountDO();
		if(!accountDO.getMerchantcode().isEmpty()){
		account2.setMerchantcode(accountDO.getMerchantcode());
		}		
		account2.setUid(accountDO.getUid());
		account2.setAccounttype(accountDO.getAccounttype());
		account2.setAccountno(accountno);		
		account2.setMobilephone(accountDO.getMobilephone());		
		account2.setCardtypecode(accountDO.getCardtypecode());		
		account2.setSubcardtypecode(accountDO.getSubcardtypecode());		
		account2.setTopupcounter(accountDO.getTopupcounter());		
		account2.setDebitcounter(accountDO.getDebitcounter());		
		account2.setLastmakepaytickettime(accountDO.getLastmakepaytickettime());		
		account2.setLasttopupamount(accountDO.getLasttopupamount());	
		account2.setLasttopuptime(accountDO.getLasttopuptime());		
		account2.setLastdebitamount(accountDO.getLastdebitamount());				
		account2.setLastdebittime(accountDO.getLastdebittime());			
		account2.setTotaltopupamount(accountDO.getTotaltopupamount());			
		account2.setTotaldebitamount(accountDO.getTotaldebitamount());					
		account2.setBalance(accountDO.getBalance());		
		account2.setScore(accountDO.getScore());		
		account2.setFreebalance(accountDO.getFreebalance());		
		account2.setFreetimes(accountDO.getFreetimes());			
		account2.setAccountexpiretime(accountDO.getAccountexpiretime());
	
		String accountJson = JSONObject.toJSONString(account2);
		
		String value = null;
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5"); 
			sun.misc.BASE64Encoder baseEncoder = new sun.misc.BASE64Encoder(); 
			value = baseEncoder.encode(md5.digest(accountJson.getBytes("GB2312")));
		} catch (NoSuchAlgorithmException e) {
			 
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			 
			e.printStackTrace();
		} 
		
		String newMAC = value.substring(0, 8);
		System.out.println("newMAC---"+newMAC);	
		account.setState(Integer.parseInt(operationType));
		/*account.setCertmac(newMAC);*/
		
		try {
			if(accountService.updateState(account) > 0){
				return R.ok();
			}else{
				return R.error();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return R.error("出错");
		}
		
		
	}
	
	@PostMapping("/Deal")
	@ResponseBody
	R Deal(int id,String operationType,String desctext) {
		
		AccountDO accountDO = accountService.get(id);
		
		AccountDO account = new AccountDO();
		
		account.setMerchantcode(accountDO.getMerchantcode());
		account.setUid(accountDO.getUid());
		account.setAccounttype(accountDO.getAccounttype());
		account.setAccountno(accountDO.getAccountno());
		account.setMobilephone(accountDO.getMobilephone());
		account.setCardtypecode(accountDO.getCardtypecode());
		account.setSubcardtypecode(accountDO.getSubcardtypecode());
		account.setTopupcounter(accountDO.getTopupcounter());
		account.setDebitcounter(accountDO.getDebitcounter());
		account.setLastmakepaytickettime(accountDO.getLastmakepaytickettime());
		account.setLasttopupamount(accountDO.getLasttopupamount());
		account.setLasttopuptime(accountDO.getLasttopuptime());
		account.setLastdebitamount(accountDO.getLastdebitamount());		
		account.setLastdebittime(accountDO.getLastdebittime());
		account.setTotaltopupamount(accountDO.getTotaltopupamount());
		account.setTotaldebitamount(accountDO.getTotaldebitamount());
		account.setBalance(accountDO.getBalance());
		account.setScore(accountDO.getScore());
		account.setFreebalance(accountDO.getFreebalance());
		account.setFreetimes(accountDO.getFreetimes());
		account.setAccountexpiretime(accountDO.getAccountexpiretime());
		

		
		AccountDO account2 = new AccountDO();
		if(!accountDO.getMerchantcode().isEmpty()){
		account2.setMerchantcode(accountDO.getMerchantcode());
		}		
		account2.setUid(accountDO.getUid());
		account2.setAccounttype(accountDO.getAccounttype());
		account2.setAccountno(accountDO.getAccountno());		
		account2.setMobilephone(accountDO.getMobilephone());		
		account2.setCardtypecode(accountDO.getCardtypecode());		
		account2.setSubcardtypecode(accountDO.getSubcardtypecode());		
		account2.setTopupcounter(accountDO.getTopupcounter());		
		account2.setDebitcounter(accountDO.getDebitcounter());		
		account2.setLastmakepaytickettime(accountDO.getLastmakepaytickettime());		
		account2.setLasttopupamount(accountDO.getLasttopupamount());	
		account2.setLasttopuptime(accountDO.getLasttopuptime());		
		account2.setLastdebitamount(accountDO.getLastdebitamount());				
		account2.setLastdebittime(accountDO.getLastdebittime());			
		account2.setTotaltopupamount(accountDO.getTotaltopupamount());			
		account2.setTotaldebitamount(accountDO.getTotaldebitamount());					
		account2.setBalance(accountDO.getBalance());		
		account2.setScore(accountDO.getScore());		
		account2.setFreebalance(accountDO.getFreebalance());		
		account2.setFreetimes(accountDO.getFreetimes());			
		account2.setAccountexpiretime(accountDO.getAccountexpiretime());
	
		String accountJson = JSONObject.toJSONString(account2);
		
		String value = null;
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5"); 
			sun.misc.BASE64Encoder baseEncoder = new sun.misc.BASE64Encoder(); 
			value = baseEncoder.encode(md5.digest(accountJson.getBytes("GB2312")));
		} catch (NoSuchAlgorithmException e) {
			 
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			 
			e.printStackTrace();
		} 
		
		String newMAC = value.substring(0, 8);
		System.out.println("newMAC---"+newMAC);		
		account.setSubAccountState(Integer.parseInt(operationType));
		/*account.setCertmac(newMAC);*/
		account.setAuditDesc(desctext);
		
		try {
			if(accountService.update(account) > 0){
				return R.ok();
			}else{
				return R.error();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return R.error("出错");
		}
		
		
	}
	
	/**
     * 导出
     * @param model
     * @param request
     * @param response
     */
    @RequestMapping("/expexcel")
	@SystemControllerLog(description="4")
    @RequiresPermissions("account:account:expexcel")
    public void expExceluser(ModelMap model,HttpServletRequest request,HttpServletResponse response){
    	   	
    	Map<String, Object> parameterMap = new HashMap<String, Object>();
    	parameterMap.put("searchName", request.getParameter("searchName"));
    	parameterMap.put("state", request.getParameter("state"));
    	parameterMap.put("merchantCode", request.getParameter("merchantCode"));
    	
  	  	String fileName = "二维码账户列表.xls";
  	  	
  	  	String[] title = new String[]{"账号","类型","账户状态	","手机号码","注册时间","账户余额","赠送余额","最后消费时间","最后消费金额","身份证正面照","个人照"};
  	  	
  	    List<AccountDO> list = null;
  	     	    
		try {
			list = accountService.list(parameterMap);		    	 	    	  		    	  		
	    	List<Object[]> data = new ArrayList<Object[]>();
	    	for(int i=0; i<list.size();i++){
		        Object[] str = new Object[title.length];
		        if(null!=list.get(i).getAccountno() && !list.get(i).getAccountno().equals("")){
		        	str[0]=list.get(i).getAccountno().toString();
		        }else{
		        	str[0]="";
		        }
		        if(null!=list.get(i).getAccountTypeName()&& !list.get(i).getAccountTypeName().equals("")){
		        	str[1]=list.get(i).getAccountTypeName().toString();
		        }else{
		        	str[1]="";
		        }
		        if(null!=list.get(i).getStateName()&& !list.get(i).getStateName().equals("")){
		        	str[2]=list.get(i).getStateName().toString();
		        }else{
		        	str[2]="";
		        }
		        if(null!=list.get(i).getMobilephone() && !list.get(i).getMobilephone().equals("")){
		        	str[3]=list.get(i).getMobilephone().toString();
		        }else{
		        	str[3]="";
		        }
		        
		        if(null!=list.get(i).getCreateddate() && !list.get(i).getCreateddate().equals("")){
		        	str[4]=DateUtils.format(list.get(i).getCreateddate(),DateUtils.DATE_TIME_PATTERN);
		        	
		        }else{
		        	str[4]="";
		        }
		        if(null!=list.get(i).getBalance() && !list.get(i).getBalance().equals("")){
		        	str[5]=list.get(i).getBalance().toString();
		        }else{
		        	str[5]="";
		        }

				if(null!=list.get(i).getFreebalance() && !list.get(i).getFreebalance().equals("")){
					str[6]=list.get(i).getFreebalance().toString();
				}else{
					str[6]="";
				}

		        if(null!=list.get(i).getLastdebittime() && !list.get(i).getLastdebittime().equals("")){
		        	str[7]=DateUtils.format(list.get(i).getLastdebittime(),DateUtils.DATE_TIME_PATTERN);
		        }else{
		        	str[7]="";
		        }
		        if(null!=list.get(i).getLastdebitamount() && !list.get(i).getLastdebitamount().equals("")){
		        	str[8]=list.get(i).getLastdebitamount().toString();
		        }else{
		        	str[8]="";
		        }
		        if(null!=list.get(i).getCertphotourl() && !list.get(i).getCertphotourl().equals("")){
		        	str[9]=list.get(i).getCertphotourl().toString();
		        }else{
		        	str[9]="";
		        }

		        if(null!=list.get(i).getPersonphotourl() && !list.get(i).getPersonphotourl().equals("")){
		        	str[10]=list.get(i).getPersonphotourl().toString();
		        }else{
		        	str[10]="";
		        }
			        		        
		        data.add(str);
	    	}
	    	String sheetName = "expExcel";
			byte[] b = fileName.getBytes("UTF-8"); 
		    String formatFileName = new String(b,"ISO-8859-1");		      	 
		    response.setContentType("application/ms-excel");
		    response.setHeader("Content-disposition", "attachment;filename="+formatFileName);	
		    ExcelExportTool.exportExcel(formatFileName, sheetName, title, data, response);
		 } catch (Exception e) {
			 e.printStackTrace();
		 }finally{
			 list=null;
		 }   	
    }
    
	//@RequiresPermissions("account:account:deal")
	@GetMapping("/deal/{accountno}")	
	String deal(@PathVariable("accountno") String accountno,Model model){
		AccountDO account = accountService.getbyAccountNO(accountno);
		if(account!=null){
 
			model.addAttribute("account", account);
			return "account/account/deal";
		}else{
			return "account/accountCancel/error";
		}
	}
	
	
	@GetMapping("/refund/{accountno}")	
	String refund(@PathVariable("accountno") String accountno,Model model){
		AccountDO account = accountService.getbyAccountNO(accountno);
		model.addAttribute("account", account);
		return "account/account/refund";
		 
	}
	
	/**
	 * 退款提交
	 */
	@RequestMapping("/refundSubmit")	
	@ResponseBody
	public SLResponse update( AccountDO accountDO){
		if(accountDO == null) 
			return new SLResponse(ErrCode.ARGUMENT_IS_NULL,"参数[accountDO]为NULL值"); 

		JSONObject json  = new JSONObject();
		json.put("AccountNO", accountDO.getAccountno());
		json.put("RefundAmount", accountDO.getRefundBalance());
		
		//调用接口
		SLResponse slResponse = CommUtil.callApiService("api/weixin/PostWxRefund", json, true);
		return slResponse; 
		
		

	}
	
	public static void main(String[] args) {
		BigDecimal decimal = new BigDecimal("0.00");
		BigDecimal balanceDecimal = new BigDecimal("20.00");
		LinkedHashMap p = new LinkedHashMap<>();
		p.put("MerchantCode", "5230");
		p.put("UID", 7);
		p.put("AccountType", 1);
		p.put("AccountNO", "52308888523007320001");
		p.put("MobilePhone", "17602019326");
		p.put("TopupCounter", 0);
		p.put("DebitCounter", 0);
		p.put("LastTopupAmount", decimal);
		
		p.put("LastDebitAmount", decimal);
		p.put("TotalTopupAmount", decimal);
		p.put("TotalDebitAmount", decimal);
		p.put("Balance", balanceDecimal);
		p.put("FreeBalance", decimal);
		
		String topuporderJson = JSONObject.toJSONString(p);
		String value = null;
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5"); 
			sun.misc.BASE64Encoder baseEncoder = new sun.misc.BASE64Encoder(); 
			value = baseEncoder.encode(md5.digest(topuporderJson.getBytes("GB2312")));	
			String newMAC = value.substring(0, 8);
			System.out.println("newMAC---"+newMAC);	

		} catch (Exception e) {				 
			e.printStackTrace();
		} 
		
/*		BigDecimal decimal = new BigDecimal("0.00");
		AccountDO account2 = new AccountDO();
		//if(!accountDO.getMerchantcode().isEmpty()){
		account2.setMerchantcode("5530");
		//}		
		account2.setUid(7);
		account2.setAccounttype(1);
		account2.setAccountno("52308888523007320001");		
		account2.setMobilephone("17602019326");		
		account2.setCardtypecode(null);		
		account2.setSubcardtypecode(null);		
		account2.setTopupcounter(0);		
		account2.setDebitcounter(0);		
		account2.setLastmakepaytickettime(null);		
		account2.setLasttopupamount(decimal);	
		account2.setLasttopuptime(null);		
		account2.setLastdebitamount(decimal);				
		account2.setLastdebittime(null);			
		account2.setTotaltopupamount(decimal);			
		account2.setTotaldebitamount(decimal);					
		account2.setBalance(decimal);		
		account2.setScore(null);		
		account2.setFreebalance(decimal);		
		account2.setFreetimes(null);			
		account2.setAccountexpiretime(null);
	
		String accountJson = JSONObject.toJSONString(account2);
		
		String value = null;
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5"); 
			sun.misc.BASE64Encoder baseEncoder = new sun.misc.BASE64Encoder(); 
			value = baseEncoder.encode(md5.digest(accountJson.getBytes("GB2312")));
		} catch (NoSuchAlgorithmException e) {
			 
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			 
			e.printStackTrace();
		} 
		
		String newMAC = value.substring(0, 8);
		System.out.println("newMAC---"+newMAC);	*/
	}
	
}
