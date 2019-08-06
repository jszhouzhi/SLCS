package com.slzr.operation.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.slzr.common.annotation.SystemControllerLog;
import com.slzr.common.controller.BaseController;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.slzr.common.utils.DWMQDateUtil;
import com.slzr.common.utils.DWMQDateVO;
import com.slzr.common.utils.DateUtils;
import com.slzr.common.utils.ExcelExportTool;
import com.slzr.common.utils.PageUtils;
import com.slzr.common.utils.Query;
import com.slzr.operation.domain.WxRefundDO;
import com.slzr.operation.service.WxRefundService;
import com.slzr.set.domain.MerchDo;
import com.slzr.set.service.MerchService;

@RequestMapping("/operation/wxRefund")
@Controller
public class WxRefundController extends BaseController{
	private String prefix = "operation/wxRefund";
	@Autowired
	private WxRefundService wxrefundservice;
	
	@Autowired
	private MerchService merchService;
	
	@GetMapping("/list")
	@SystemControllerLog(description="0")
	public String list(Model model) {
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
		return prefix + "/list";
	}
	
	@ResponseBody
	@GetMapping("api/list")
	@RequiresPermissions("operation:wxRefund:list")
	public PageUtils list(@RequestParam Map<String, Object> params) {
		
		if(!params.containsKey("merchantCode") || getMerchantCode() != null && getMerchantCode().length() != 0){
			params.put("merchantCode",getMerchantCode());
		}
		
		//查询列表数据
        Query query = new Query(params);
		List<WxRefundDO> list = wxrefundservice.list(query);
		int total = wxrefundservice.count(query);
		PageUtils pageUtils = new PageUtils(list, total);
		return pageUtils;
	}

	@SystemControllerLog(description="4")
    @RequestMapping("/expexcel")
	public void expExceluser(ModelMap model,HttpServletRequest request,HttpServletResponse response,@RequestParam Map<String, Object> params){
		String fileName = "退款明细.xls";
		
		String[] title = new String[]{"帐号","订单号","退款单号","退款金额","退款时间","退款结果","退款人"};
		
		List<WxRefundDO> list = null;
		
			try {
				list = wxrefundservice.list(params);
				List<Object[]> data = new ArrayList<Object[]>();
				for(int i=0; i<list.size();i++){
		        Object[] str = new Object[title.length];
			        //帐号
			        if(null!=list.get(i).getAccountNO() && !list.get(i).getAccountNO().equals("")){
		        		str[0] = list.get(i).getAccountNO().toString();
			        }else{
			        	str[0] = "";
			        }
			        //订单号
			        if(null!=list.get(i).getOrderNO() && !list.get(i).getOrderNO().equals("")){
		        		str[1] = list.get(i).getOrderNO().toString();
			        }else{
			        	str[1] = "";
			        }
			        //退款单号
			        if(null!=list.get(i).getRefundOrderNO() && !list.get(i).getRefundOrderNO().equals("")){
		        		str[2] = list.get(i).getRefundOrderNO().toString();
			        }else{
			        	str[2] = "";
			        }
			        //退款金额
			        if(null!=list.get(i).getRefundAmount()){
		        		str[3] = list.get(i).getRefundAmount().toString();
			        }else{
			        	str[3] = "";
			        }
			        //退款时间
			        if(null!=list.get(i).getRefundTime()){
		        		str[4] = DateUtils.format(list.get(i).getRefundTime(),DateUtils.DATE_TIME_PATTERN);
			        }else{
			        	str[4] = "";
			        }
			        //退款结果
			        if(list.get(i).getRefundResult()==1){
		        		str[5] = "成功";
			        }else{
			        	str[5] = "失败";
			        }
			        //退款人
			        if(null!=list.get(i).getNickName() && !list.get(i).getNickName().equals("")){
		        		str[6] = list.get(i).getNickName().toString();
			        }else{
			        	str[6] = "";
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
}
