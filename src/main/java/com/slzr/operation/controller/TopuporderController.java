package com.slzr.operation.controller;

 
import java.security.MessageDigest;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.slzr.common.annotation.SystemControllerLog;
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
import com.slzr.common.controller.BaseController;
import com.slzr.common.utils.DWMQDateUtil;
import com.slzr.common.utils.DWMQDateVO;
import com.slzr.common.utils.DateUtils;
import com.slzr.common.utils.ExcelExportTool;
import com.slzr.common.utils.PageUtils;
import com.slzr.common.utils.Query;
import com.slzr.common.utils.R;
import com.slzr.operation.domain.TopuporderDO;
import com.slzr.operation.service.TopuporderService;
import com.slzr.set.domain.MerchDo;
import com.slzr.set.service.MerchService;

/**
 * 订单 圈存异常
 * @date 2018-03-20 11:15:51
 */
 
@Controller
@RequestMapping("/operation/icQuancunfail")
public class TopuporderController extends BaseController{
	@Autowired
	private TopuporderService topuporderService;
	
	@Autowired
	private MerchService merchService;
	
	@GetMapping()
	@SystemControllerLog(description="0")
	@RequiresPermissions("operation:icQuancunfail:list")
	String Topuporder(Model model){
		HashMap<String,Object> params=new HashMap<>();
		if(getMerchantCode() != null && getMerchantCode().length() != 0){
			params.put("merchantCode",getMerchantCode());
		}
		List<MerchDo> merchantList=merchService.list(params);
		model.addAttribute("merchantList",merchantList);
		
	    return "operation/icQuancunfail/list";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("operation:icQuancunfail:list")
	public PageUtils list(@RequestParam Map<String, Object> params){
		
		if(!params.containsKey("merchantCode") || getMerchantCode() != null && getMerchantCode().length() != 0){
			params.put("merchantCode",getMerchantCode());
		}

		//查询列表数据
        Query query = new Query(params);
		List<TopuporderDO> list = topuporderService.list(query);
		int total = topuporderService.count(query);
		PageUtils pageUtils = new PageUtils(list, total);
		return pageUtils;
	}
	


	@GetMapping("/edit/{id}")
	String edit(@PathVariable("id") Integer id,Model model){
		TopuporderDO topuporder = topuporderService.get(id);
		model.addAttribute("topuporder", topuporder);
		model.addAttribute("id", id);
	    return "operation/icQuancunfail/edit";
	}
	



	/**
     * 导出
     * @param model
     * @param request
     * @param response
     */
	  @SystemControllerLog(description="4")
	  @RequestMapping({"/expexcel"})
	  public void expExceluser(ModelMap model, HttpServletRequest request, HttpServletResponse response)
	  {
	    Map<String, Object> parameterMap = new HashMap();
	    parameterMap.put("searchName", request.getParameter("searchName"));
	    parameterMap.put("merchantCode", request.getParameter("merchantCode"));
	    parameterMap.put("sdate", request.getParameter("sdate"));
	    parameterMap.put("edate", request.getParameter("edate"));
	    parameterMap.put("rState", request.getParameter("rState"));
	    
	    String fileName = "圈存异常.xls";
	    
	    String[] title = { "商户","卡号","订单号","交易金额","余额","状态","描述","交易时间","支付时间","自助终端编号" };
	    
	    List<TopuporderDO> list = null;
	    try
	    {
	      list = this.topuporderService.list(parameterMap);
	      List<Object[]> data = new ArrayList();
	      for (int i = 0; i < list.size(); i++)
	      {
	        Object[] str = new Object[title.length];
	        if (null!=list.get(i).getMerchantCode() && !list.get(i).getMerchantCode().equals("")){
	        	str[0]=list.get(i).getMerchantCode().toString();
	        }else{
	        	str[0]="";
	        }
	        if ((null != ((TopuporderDO)list.get(i)).getCardno()) && (!((TopuporderDO)list.get(i)).getCardno().equals(""))) {
	          str[1] = ((TopuporderDO)list.get(i)).getCardno().toString();
	        } else {
	          str[1] = "";
	        }
	        if ((null != ((TopuporderDO)list.get(i)).getOrderno()) && (!((TopuporderDO)list.get(i)).getOrderno().equals(""))) {
	          str[2] = ((TopuporderDO)list.get(i)).getOrderno().toString();
	        } else {
	          str[2] = "";
	        }
	        if ((null != ((TopuporderDO)list.get(i)).getTxnamount()) && (!((TopuporderDO)list.get(i)).getTxnamount().equals(""))) {
	          str[3] = ((TopuporderDO)list.get(i)).getTxnamount().toString();
	        } else {
	          str[3] = "";
	        }
	        if ((null != ((TopuporderDO)list.get(i)).getBalance()) && (!((TopuporderDO)list.get(i)).getBalance().equals(""))) {
	          str[4] = ((TopuporderDO)list.get(i)).getBalance().toString();
	        } else {
	          str[4] = "";
	        }
	        if ((null != ((TopuporderDO)list.get(i)).getLoadstate()) && (!((TopuporderDO)list.get(i)).getLoadstate().equals(""))) {
	          //str[5] = ((TopuporderDO)list.get(i)).getLoadstate().toString();
	        	if(list.get(i).getLoadstate().toString().equals("-1")){
	        		str[5]="待审核";
	        	}
	        	if(list.get(i).getLoadstate().toString().equals("0")){
	        		str[5]="圈存失败";
	        	}
	        	if(list.get(i).getLoadstate().toString().equals("1")){
	        		str[5]="圈存成功";
	        	}
	        } else {
	          str[5] = "";
	        }
	        if ((null != ((TopuporderDO)list.get(i)).getLoaddescribe()) && (!((TopuporderDO)list.get(i)).getLoaddescribe().equals(""))) {
	          str[6] = ((TopuporderDO)list.get(i)).getLoaddescribe().toString();
	        } else {
	          str[6] = "";
	        }
	        if ((null != ((TopuporderDO)list.get(i)).getLoadbackdate()) && (!((TopuporderDO)list.get(i)).getLoadbackdate().equals(""))) {
	          str[7] = DateUtils.format(((TopuporderDO)list.get(i)).getLoadbackdate(), "yyyy-MM-dd HH:mm:ss");
	        } else {
	          str[7] = "";
	        }
	        if ((null != ((TopuporderDO)list.get(i)).getPaytime()) && (!((TopuporderDO)list.get(i)).getPaytime().equals(""))) {
		      str[8] = DateUtils.format(((TopuporderDO)list.get(i)).getPaytime(), "yyyy-MM-dd HH:mm:ss");
		    } else {
		      str[8] = "";
		    }
	        if ((null != ((TopuporderDO)list.get(i)).getTerminalno()) && (!((TopuporderDO)list.get(i)).getTerminalno().equals(""))) {
	          str[9] = ((TopuporderDO)list.get(i)).getTerminalno().toString();
	        } else {
	          str[9] = "";
	        }
	        data.add(str);
	      }
	      String sheetName = "expExcel";
	      byte[] b = fileName.getBytes("UTF-8");
	      String formatFileName = new String(b, "ISO-8859-1");
	      response.setContentType("application/ms-excel");
	      response.setHeader("Content-disposition", "attachment;filename=" + formatFileName);
	      ExcelExportTool.exportExcel(formatFileName, sheetName, title, data, response);
	    }
	    catch (Exception e)
	    {
	      e.printStackTrace();
	    }
	    finally
	    {
	      list = null;
	    }
	  }
    
    /**
     * 审核 操作
     * @param id
     * @return
     */
	@PostMapping("/operation")
	@SystemControllerLog(description="9")
	@ResponseBody
	R operation(String id,String operationType) {

		
		TopuporderDO tDO = topuporderService.get(Integer.parseInt(id));
		String mac = reckonMac(tDO);
		if(mac.equals(tDO.getMac())){
			System.out.println("mac正确，继续审核更新状态");

			Date loadBackDateTime = new Date();
			
			TopuporderDO topuporder = new TopuporderDO();
			topuporder.setId(Integer.parseInt(id));
			topuporder.setReviewid(getId().intValue());
			topuporder.setReviewtime(loadBackDateTime);
			
			if(operationType.equals("0")){ //不通过

				topuporder.setOrderstate(2);
				
				topuporder.setLoadstate(0);
				topuporder.setLoadbackdate(loadBackDateTime);
				topuporder.setLoaddescribe("人工审核失败");
				
				topuporder.setReviewid(getId().intValue());
				topuporder.setReviewtime(new Date());
				
				tDO.setOrderstate(2);
				tDO.setLoadstate(0);
				String newMAC=reckonMac(tDO);
					
				topuporder.setMac(newMAC);

				if (topuporderService.update(topuporder) > 0){
					return R.ok();
				}else{return R.error();}
				
			}else{ //通过
				topuporder.setOrderstate(6);
				
				topuporder.setLoadstate(1);
				topuporder.setLoadbackdate(loadBackDateTime);
				topuporder.setLoaddescribe("人工审核成功");
				
				topuporder.setReviewid(getId().intValue());
				topuporder.setReviewtime(new Date());
				
				tDO.setOrderstate(6);
				tDO.setLoadstate(1);
				String newMAC=reckonMac(tDO);
					
				topuporder.setMac(newMAC);

				
				if (topuporderService.update(topuporder) > 0){
					return R.ok();
				}else{return R.error();}
			}
		}else{
			System.out.println("mac错误，停止审核");
			return R.error("MAC数据被篡改");
		}
		

		
	}
	
	public String  reckonMac(TopuporderDO tDO){
		TopuporderDO to = new TopuporderDO();
		
		String newMAC = null;
		try {
			if(tDO.getUid()!=null && !tDO.getUid().equals("")) to.setUid(tDO.getUid());
			if(tDO.getOrderno()!=null && !tDO.getOrderno().equals("")) to.setOrderno(tDO.getOrderno());
			if(tDO.getCardno()!=null && !tDO.getCardno().equals("")) to.setCardno(tDO.getCardno());
			if(tDO.getTxnamount()!=null && !tDO.getTxnamount().equals("")) to.setTxnamount(tDO.getTxnamount());
			if(tDO.getOrderstate()!=null && !tDO.getOrderstate().equals("")) to.setOrderstate(tDO.getOrderstate());
			if(tDO.getLoadstate()!=null && !tDO.getLoadstate().equals("")) to.setLoadstate(tDO.getLoadstate());
			if(tDO.getPayresult()!=null && !tDO.getPayresult().equals("")) to.setPayresult(tDO.getPayresult());
			if(tDO.getTac()!=null && !tDO.getTac().equals("")) to.setTac(tDO.getTac());
			
			String topuporderJson = JSONObject.toJSONString(to);
			String value = null;
			 
			MessageDigest md5 = MessageDigest.getInstance("MD5"); 
			sun.misc.BASE64Encoder baseEncoder = new sun.misc.BASE64Encoder(); 
			value = baseEncoder.encode(md5.digest(topuporderJson.getBytes("GB2312")));	
			newMAC = value.substring(0, 8);
			System.out.println("newMAC---"+newMAC);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return newMAC;		
	}
	
	
	@GetMapping("/processedFind")
	@SystemControllerLog(description="0")
	@RequiresPermissions("operation:icQuancunfail:processedFind")
	String processedFind(Model model){
		HashMap<String,Object> params=new HashMap<>();
		if(getMerchantCode() != null && getMerchantCode().length() != 0){
			params.put("merchantCode",getMerchantCode());
		}
		List<MerchDo> merchantList=merchService.list(params);
		model.addAttribute("merchantList",merchantList);
		
		DWMQDateVO dwmq = null;
		try {
			dwmq = DWMQDateUtil.GetDWMQDateVO(DateUtils.format(Calendar.getInstance().getTime(), DateUtils.DATE_PATTERN));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		model.addAttribute("dwmq", dwmq);
		
	    return "operation/icQuancunfail/processedFind";
	}
	
	@ResponseBody
	@GetMapping("/processedFind_list")
	public PageUtils processedFind_list(@RequestParam Map<String, Object> params){
		
		if(!params.containsKey("merchantCode") || getMerchantCode() != null && getMerchantCode().length() != 0){
			params.put("merchantCode",getMerchantCode());
		}

		//查询列表数据
        Query query = new Query(params);
		List<TopuporderDO> list = topuporderService.processedFind_list(query);
		int total = topuporderService.processedFind_count(query);
		PageUtils pageUtils = new PageUtils(list, total);
		return pageUtils;
	}
	
	
	/**
     * 已处理的 -导出
     * @param model
     * @param request
     * @param response
     */
	@SystemControllerLog(description="4")
	@RequestMapping("/processed_expexcel")
    public void processed_expExceluser(ModelMap model,HttpServletRequest request,HttpServletResponse response){
    	   	
    	Map<String, Object> parameterMap = new HashMap<String, Object>();
    	parameterMap.put("searchName", request.getParameter("searchName"));
    	parameterMap.put("merchantCode", request.getParameter("merchantCode"));
	    parameterMap.put("sdate", request.getParameter("sdate"));
	    parameterMap.put("edate", request.getParameter("edate"));
	    parameterMap.put("rState", request.getParameter("rState"));
    	
  	  	String fileName = "IC卡人工审核记录表.xls";
  	  	
  	  	String[] title = new String[]{"商户","卡号","订单号","交易金额","余额","状态","描述","审核时间","审核人","交易时间","支付时间","自助终端编号",};
  	  	
  	    List<TopuporderDO> list = null;
  	     	    
		try {
			list = topuporderService.processedFind_list(parameterMap);		    	 	    	  		    	  		
	    	List<Object[]> data = new ArrayList<Object[]>();
	    	for(int i=0; i<list.size();i++){
		        Object[] str = new Object[title.length];
		        if (null!=list.get(i).getMerchantCode() && !list.get(i).getMerchantCode().equals("")){
		        	str[0]=list.get(i).getMerchantCode().toString();
		        }else{
		        	str[0]="";
		        }
		        if ((null != ((TopuporderDO)list.get(i)).getCardno()) && (!((TopuporderDO)list.get(i)).getCardno().equals(""))) {
		          str[1] = ((TopuporderDO)list.get(i)).getCardno().toString();
		        } else {
		          str[1] = "";
		        }
		        if ((null != ((TopuporderDO)list.get(i)).getOrderno()) && (!((TopuporderDO)list.get(i)).getOrderno().equals(""))) {
		          str[2] = ((TopuporderDO)list.get(i)).getOrderno().toString();
		        } else {
		          str[2] = "";
		        }
		        if ((null != ((TopuporderDO)list.get(i)).getTxnamount()) && (!((TopuporderDO)list.get(i)).getTxnamount().equals(""))) {
		          str[3] = ((TopuporderDO)list.get(i)).getTxnamount().toString();
		        } else {
		          str[3] = "";
		        }
		        if ((null != ((TopuporderDO)list.get(i)).getBalance()) && (!((TopuporderDO)list.get(i)).getBalance().equals(""))) {
		          str[4] = ((TopuporderDO)list.get(i)).getBalance().toString();
		        } else {
		          str[4] = "";
		        }
		        if ((null != ((TopuporderDO)list.get(i)).getLoadstate()) && (!((TopuporderDO)list.get(i)).getLoadstate().equals(""))) {
		          //str[5] = ((TopuporderDO)list.get(i)).getLoadstate().toString();
		        	if(list.get(i).getLoadstate().toString().equals("0")){
		        		str[5]="圈存失败";
		        	}
		        	if(list.get(i).getLoadstate().toString().equals("1")){
		        		str[5]="圈存成功";
		        	}
		        } else {
		          str[5] = "";
		        }
		        if ((null != ((TopuporderDO)list.get(i)).getLoaddescribe()) && (!((TopuporderDO)list.get(i)).getLoaddescribe().equals(""))) {
		          str[6] = ((TopuporderDO)list.get(i)).getLoaddescribe().toString();
		        } else {
		          str[6] = "";
		        }
		        if(null!=list.get(i).getReviewUserName() && !list.get(i).getReviewUserName().equals("")){
		        	str[7]=list.get(i).getReviewUserName().toString();
		        }else{
		        	str[7]="";
		        }
		        if(null!=list.get(i).getReviewtime() && !list.get(i).getReviewtime().equals("")){
		        	str[8]=DateUtils.format(list.get(i).getReviewtime(),DateUtils.DATE_TIME_PATTERN);
		        }else{
		        	str[8]="";
		        }
		        if ((null != ((TopuporderDO)list.get(i)).getLoadbackdate()) && (!((TopuporderDO)list.get(i)).getLoadbackdate().equals(""))) {
		          str[9] = DateUtils.format(((TopuporderDO)list.get(i)).getLoadbackdate(), "yyyy-MM-dd HH:mm:ss");
		        } else {
		          str[9] = "";
		        }
		        if ((null != ((TopuporderDO)list.get(i)).getPaytime()) && (!((TopuporderDO)list.get(i)).getPaytime().equals(""))) {
			      str[10] = DateUtils.format(((TopuporderDO)list.get(i)).getPaytime(), "yyyy-MM-dd HH:mm:ss");
			    } else {
			      str[10] = "";
			    }
		        if ((null != ((TopuporderDO)list.get(i)).getTerminalno()) && (!((TopuporderDO)list.get(i)).getTerminalno().equals(""))) {
		          str[11] = ((TopuporderDO)list.get(i)).getTerminalno().toString();
		        } else {
		          str[11] = "";
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
	
//	public static void main(String[] args) {
//        BigDecimal decimal = new BigDecimal("100.00");
//
///*		TopuporderDO to = new TopuporderDO();
//		to.setUid(0);
//		to.setOrderno("000020037700001");
//		to.setCardno("123456464");
//		to.setTxnamount(decimal);
//		to.setOrderstate(1);
//		to.setLoadstate(1);
//		to.setPayresult(1);
//		to.setTac("s9AI02TP");*/
//		
//		LinkedHashMap p = new LinkedHashMap<>();
//		p.put("UID", 97313);
//		p.put("OrderNO", "402980850704001");
//		p.put("CardNO", "4420001110298085");
//		p.put("TxnAmount", decimal);
//		p.put("OrderState", 6);
//		p.put("LoadState", -1);
//		p.put("PayResult", 1);
//		p.put("TAC", "s9AI02TP");
//		
//		String topuporderJson = JSONObject.toJSONString(p);
//		String value = null;
//		try {
//			MessageDigest md5 = MessageDigest.getInstance("MD5"); 
//			sun.misc.BASE64Encoder baseEncoder = new sun.misc.BASE64Encoder(); 
//			value = baseEncoder.encode(md5.digest(topuporderJson.getBytes("GB2312")));	
//			String newMAC = value.substring(0, 8);
//			System.out.println("newMAC---"+newMAC);	
//
//		} catch (Exception e) {				 
//			e.printStackTrace();
//		} 
//	}
	
}
