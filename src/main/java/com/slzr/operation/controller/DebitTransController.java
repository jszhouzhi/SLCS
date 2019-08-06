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
import com.slzr.set.domain.MerchDo;
import com.slzr.set.service.MerchService;
import com.slzr.system.domain.UserDO;
import com.slzr.system.service.UserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.slzr.common.utils.DWMQDateUtil;
import com.slzr.common.utils.DWMQDateVO;
import com.slzr.common.utils.DateUtils;
import com.slzr.common.utils.ExcelExportTool;
import com.slzr.common.utils.PageUtils;
import com.slzr.common.utils.Query;
import com.slzr.operation.domain.DebitTransDO;
import com.slzr.operation.domain.OPTBusDO;
import com.slzr.operation.domain.OPTDepartmentDO;
import com.slzr.operation.domain.OPTDriverDO;
import com.slzr.operation.domain.OPTLineDO;
import com.slzr.operation.domain.TopupTransDO;
import com.slzr.operation.service.DebitTransService;
import com.slzr.operation.service.OPTBusService;
import com.slzr.operation.service.OPTDepartmentService;
import com.slzr.operation.service.OPTDriverService;
import com.slzr.operation.service.OPTLineService;

@RequestMapping("/operation/debitTrans")
@Controller
public class DebitTransController extends BaseController{
	@Autowired
	private OPTDepartmentService optDepartmentService;
	@Autowired
	UserService userService;
	@Autowired
	private OPTLineService optLineService;

	private String prefix = "operation/debitTrans";
	@Autowired
	private DebitTransService debittransservice;
	
	@Autowired
	private OPTBusService optBusService;
	
	@Autowired
	private OPTDriverService optDriverService;

	@Autowired
	private MerchService merchService;
	
	@GetMapping("/list")
	@SystemControllerLog(description="0")
	public String list(Model model) {
/*		HashMap<String,Object> params=new HashMap<>();
		UserDO userDO = userService.get(getId());
		List<MerchDo> merchantList=null;
		if(userDO.getMerchantCode()==""||userDO.getMerchantCode()==null){
			merchantList=merchService.list(params);
		}else{
			params.put("merchantCode",userDO.getMerchantCode());
			merchantList=merchService.list(params);
		}
		model.addAttribute("merchantList",merchantList);*/
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
		
		List<OPTDepartmentDO> Dept = optDepartmentService.list(new HashMap<>());
		List<OPTLineDO> lineName = optLineService.list(params);
		List<OPTBusDO> bus = optBusService.list(new HashMap<>());
		List<OPTDriverDO> driverName = optDriverService.list(new HashMap<>());
		
		model.addAttribute("dwmq", dwmq);
		model.addAttribute("lineName",lineName);
		model.addAttribute("Dept",Dept);
		model.addAttribute("bus",bus);
		model.addAttribute("driverName",driverName);
		
		return prefix + "/list";
	}
	
	@ResponseBody
	@GetMapping("api/list")
	@RequiresPermissions("operation:debitTrans:list")
	public PageUtils list(@RequestParam Map<String, Object> params) {

		
		if(!params.containsKey("merchantCode") || getMerchantCode() != null && getMerchantCode().length() != 0){
			params.put("merchantCode",getMerchantCode());
		}
		//查询列表数据
        Query query = new Query(params);
		List<DebitTransDO> list = debittransservice.list(query);
		int total = debittransservice.count(query);
		PageUtils pageUtils = new PageUtils(list, total);
		return pageUtils;
	}

	@SystemControllerLog(description="4")
    @RequestMapping("/expexcel")
	public void expExceluser(ModelMap model,HttpServletRequest request,HttpServletResponse response,@RequestParam Map<String, Object> params){
		String fileName = "消费交易报表.xls";
		
		String[] title = new String[]{"商户","帐号","线路","车辆","司机","消费金额","账号余额","消费时间","扣费时间","交易状态","扣费来源"};
		List<DebitTransDO> list = null;
		
			try {
				list = debittransservice.list(params);
				List<Object[]> data = new ArrayList<Object[]>();
				for(int i=0; i<list.size();i++){
		        Object[] str = new Object[title.length];
		        //商户
		        if(null!=list.get(i).getMerchantName() && !list.get(i).getMerchantName().equals("")){
	        		str[0] = list.get(i).getMerchantName().toString();
		        }
        		else {
		        	str[0] = "";
		        }
			        //账号
			        if(null!=list.get(i).getAccountNO() && !list.get(i).getAccountNO().equals("")){
		        		str[1] = list.get(i).getAccountNO().toString();
			        }
	        		else {
			        	str[1] = "";
			        }
			        //线路
			        if(null!=list.get(i).getLineNO() && !list.get(i).getLineNO().equals("")){
		        		str[2] = list.get(i).getLineNO().toString();
			        }
	        		else {
			        	str[2] = "";
			        }
			        //车辆
			        if(null!=list.get(i).getTerminalNO()){
		        		str[3] = list.get(i).getTerminalNO().toString();
			        }
	        		else {
			        	str[3] = "";
			        }
			        //司机
			        if(null!=list.get(i).getDriverNO() && !list.get(i).getDriverNO().equals("")){
		        		str[4] = list.get(i).getDriverNO().toString();
			        }
	        		else {
			        	str[4] = "";
			        }
			        //消费金额
			        if(null!=list.get(i).getTxnAmount()){
		        		str[5] = list.get(i).getTxnAmount().toString();
			        }
	        		else {
			        	str[5] = "";
			        }
			        //账号余额
			        if(null!=list.get(i).getBalance()){
		        		str[6] = list.get(i).getBalance().toString();
			        }
	        		else {
			        	str[6] = "";
			        }
			        //消费时间
			        if(null!=list.get(i).getTxnDateTime()){
		        		str[7] = DateUtils.format(list.get(i).getTxnDateTime(), DateUtils.DATE_TIME_PATTERN);
			        }
	        		else {
			        	str[7] = "";
			        }
			        //扣费时间
			        if(null!=list.get(i).getUpdateStatusDateTime()){
		        		str[8] = DateUtils.format(list.get(i).getUpdateStatusDateTime(), DateUtils.DATE_TIME_PATTERN);
			        }
	        		else {
			        	str[8] = "";
			        }
			        //交易状态
					if(list.get(i).getDebitStatus()==1)
						str[9]= "正常扣费";
					else if(list.get(i).getDebitStatus()==0)
						str[9]= "未补扣";
 
	        		else {
			        	str[9] = "";
			        }

					//扣费来源
					if("1".equals(list.get(i).getPapPayFlag())){
						str[10]= "免密扣款";
					}else if("1".equals(list.get(i).getDebitFrom())){					
						str[10]= "赠送扣款";
					}else if("0".equals(list.get(i).getDebitFrom())){					
						str[10]= "余额扣款";
					}else {
						str[10] = "";
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
	
	//线路
	@ResponseBody
	@RequestMapping(value="/findLineByMerchantCode",method=RequestMethod.POST)
	public List<OPTLineDO> findLineByMerchantCode(HttpServletRequest request) {
		String merchantCode = request.getParameter("merchantCode");
		HashMap<String,Object> params=new HashMap<>();
		params.put("merchantCode",merchantCode); 
		List<OPTLineDO> list = optLineService.list(params); 
		return list;
	}
	

	//车辆
	@ResponseBody
	@RequestMapping(value="/findBusByMerchantCode",method=RequestMethod.POST)
	public List<OPTBusDO> findBusByMerchantCode(HttpServletRequest request) {
		String merchantCode = request.getParameter("merchantCode");
		HashMap<String,Object> params=new HashMap<>();
		params.put("merchantCode",merchantCode); 
		List<OPTBusDO> list = optBusService.list(params); 
		return list;
	}
	
	//司机
	@ResponseBody
	@RequestMapping(value="/findDriverByMerchantCode",method=RequestMethod.POST)
	public List<OPTDriverDO> findDriverByMerchantCode(HttpServletRequest request) {
		String merchantCode = request.getParameter("merchantCode");
		HashMap<String,Object> params=new HashMap<>();
		params.put("merchantCode",merchantCode); 
		List<OPTDriverDO> list = optDriverService.list(params); 
		return list;
	}
	
	//部门
	@ResponseBody
	@RequestMapping(value="/findDepartmentByMerchantCode",method=RequestMethod.POST)
	public List<OPTDepartmentDO> findDepartmentByMerchantCode(HttpServletRequest request) {
		String merchantCode = request.getParameter("merchantCode");
		HashMap<String,Object> params=new HashMap<>();
		params.put("merchantCode",merchantCode); 
		List<OPTDepartmentDO> list = optDepartmentService.list(params); 
		return list;
	}
 
}
