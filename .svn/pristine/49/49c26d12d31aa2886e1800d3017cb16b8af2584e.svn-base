package com.slzr.operation.controller;

import com.slzr.common.annotation.SystemControllerLog;
import com.slzr.common.controller.BaseController;
import com.slzr.common.utils.*;
import com.slzr.operation.domain.ICTopupTransactionDO;
import com.slzr.operation.service.ICTopupTransactionService;
import com.slzr.set.domain.MerchDo;
import com.slzr.set.service.MerchService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


// IC卡 圈存查询
@Controller
@RequestMapping("/operation/ictopuptransaction")
public class ICTopupTransactionController extends BaseController{
	private String prefix = "operation/ictopuptransaction";
//	@Autowired
//	private DailysummaryTopupService topupservice;

	@Autowired
	private ICTopupTransactionService icTopupTransactionService;
	
	@Autowired
	private MerchService merchService;
	
	@GetMapping("/list")
	@SystemControllerLog(description="0")
	public String list(ModelMap model) {
		
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
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") String id) {
		return prefix + "/edit";
	}
	
	@GetMapping("/check/{id}")
	public String check(Model model,@PathVariable("id") String id) {
		model.addAttribute("id",id);
		return prefix + "/check";
	}
	
	@ResponseBody
	@GetMapping("api/list")
	/*@RequiresPermissions("operation:topup:list")*/
	public PageUtils list(@RequestParam Map<String, Object> params) {
		
 
		if(!params.containsKey("merchantCode") || getMerchantCode() != null && getMerchantCode().length() != 0){
			params.put("merchantCode",getMerchantCode());
		}
		//查询列表数据
        Query query = new Query(params);
		List<ICTopupTransactionDO> list = icTopupTransactionService.list(query);
		int total = icTopupTransactionService.count(query);
		PageUtils pageUtils = new PageUtils(list, total);
		return pageUtils;

	}
	
//	@ResponseBody
//	@RequestMapping("api/check")
//	@RequiresPermissions("operation:topup:check")
//	public R apicheck(String id,int auditvalue,String remark){
//		ICWXRefundDO settledo = icwxRefundService.get(id);
//		if(settledo.getAuditStatus()==-1)
//		{
//			icwxRefundService.updateAudit(id, auditvalue, this.getUserId().intValue(),remark);
//			return R.ok();
//		}
//        return R.error();
//	}
	
//	@ResponseBody
//	@RequestMapping("api/again")
//	@RequiresPermissions("operation:topup:do")
//	public R apiagain(String id){
//		icTopupTransactionService.updateAudit(id, -1, this.getId().intValue(),"");
//		return R.ok();
//	}
    @RequestMapping("/expexcel")
    public void expExceluser(ModelMap model,HttpServletRequest request,HttpServletResponse response,@RequestParam Map<String, Object> params){
    	
  	  	String fileName = "IC卡圈存查询报表.xls";
  	  	
  	  	String[] title = new String[]{"商户","订单号","终端号","卡号","订单状态","订单金额","支付时间","支付人","圈存结果","圈存时间","审核时间","审核人"};
  	  	
  	    List<ICTopupTransactionDO> list = null;
  	    
		try {
	    	 
			params.put("auditRemark", request.getParameter("auditRemark"));
			params.put("merchantCode", request.getParameter("merchantCode"));
			params.put("oorderState", request.getParameter("oorderState"));
	    	
			list = icTopupTransactionService.list(params);
	    	List<Object[]> data = new ArrayList<Object[]>();
	    	for(int i=0; i<list.size();i++){
		        Object[] str = new Object[title.length];
		        //商户
		        if(null!=list.get(i).getCompanyCode() && !list.get(i).getCompanyCode().equals("")){
		        	str[0] = list.get(i).getCompanyCode().toString();
		        }else{
		        	str[0] = "";
		        }
		        //订单号
		        if(null!=list.get(i).getOrderNO() && !list.get(i).getOrderNO().equals("")){
		        	str[1] = list.get(i).getOrderNO().toString();
		        }else{
		        	str[1] = "";
		        }
		        //终端号
		        if(null!=list.get(i).getTerminalNO() && !list.get(i).getTerminalNO().equals("")){
		        	str[2] = list.get(i).getTerminalNO().toString();
		        }else{
		        	str[2] = "";
		        }
		        //卡号
		        if(null!=list.get(i).getCardAppNO()){
		        	str[3] = list.get(i).getCardAppNO().toString();
		        }else{
		        	str[3] = "";
		        }

		        int oorderState  = list.get(i).getOorderState();
                if(oorderState==1)
                    str[4] = "未支付";
                if(oorderState==2)
                    str[4] = "支付成功";
                if(oorderState==3)
                    str[4] = "支付失败";
                if(oorderState==4)
                    str[4] = "锁定";
                if(oorderState==5)
                    str[4] = "圈存失败";
                if(oorderState==6)
                    str[4] = "圈存成功";
                if(oorderState==7)
                    str[4] = "已退款";


		        //订单金额
                str[5] = "" + list.get(i).getOtxnAmount();

		        //支付时间
		        if(null!=list.get(i).getOpayTime()){
		        	str[6] = DateUtils.format(list.get(i).getOpayTime(),DateUtils.DATE_TIME_PATTERN) ;
		        }else{
		        	str[6] = "";
		        }
		        //支付人
		        if(null!=list.get(i).getbNickName()){
		        	str[7] = list.get(i).getbNickName().toString();
		        }else{
		        	str[7] = "";
		        }


		        //圈存结果
                int oloadState  = list.get(i).getOloadState();
                if(oloadState==1)
                    str[8] = "未支付";
                if(oloadState==2)
                    str[8] = "支付成功";
                if(oloadState==3)
                    str[8] = "支付失败";
                if(oloadState==4)
                    str[8] = "锁定";
                if(oloadState==5)
                    str[8] = "圈存失败";
                if(oloadState==6)
                    str[8] = "圈存成功";
                if(oloadState==7)
                    str[8] = "已退款";


                //圈存时间
		        if(null!=list.get(i).getOloadBackDate()){
		        	str[9] = DateUtils.format(list.get(i).getOloadBackDate(),DateUtils.DATE_TIME_PATTERN)  ;
		        }else{
		        	str[9] = "";
		        }
		        //审核时间
		        if(null!=list.get(i).getOreviewTime()){
		        	str[10] = DateUtils.format(list.get(i).getOreviewTime(),DateUtils.DATE_TIME_PATTERN)  ;
		        }else{
		        	str[10] = "";
		        }
		        //审核人
		        if(null!=list.get(i).getsUserName()){
		        	str[11] = list.get(i).getsUserName().toString();
		        }else{
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

}
