package com.slzr.account.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.slzr.account.domain.VipMemberApplyDO;
import com.slzr.account.domain.VipMemberPlanDO;
import com.slzr.account.service.VipMemberApplyService;
import com.slzr.account.service.VipMemberPlanService;
import com.slzr.common.controller.BaseController;
import com.slzr.common.utils.PageUtils;
import com.slzr.common.utils.Query;
import com.slzr.common.utils.R;
import com.slzr.set.domain.MerchDo;
import com.slzr.set.service.MerchService;
 

/**
 * 账户会员申请列表
 * @date 2018-11-05 10:43:20
 */
 
@Controller
@RequestMapping("/account/vipMemberApply")
public class VipMemberApplyController extends BaseController{
	
	@Resource
	private VipMemberApplyService vipmemberapplyService;
	
	@Resource
	private VipMemberPlanService vipMemberPlanService;
	
	@Autowired
	private MerchService merchService;
	
	@GetMapping()
	@RequiresPermissions("account:vipMemberApply:vipMemberApply")
	String Vipmemberapply(Model model){			
/*		List<VipMemberPlanDO>  vipMemberPlanlist=null;
		HashMap params = new HashMap();
		if( getMerchantCode()!=null){						
			params.put("companyCode", getMerchantCode());
			vipMemberPlanlist= vipMemberPlanService.list(params);
		}else{
			vipMemberPlanlist= vipMemberPlanService.list(params);
		}
		model.addAttribute("vipMemberPlanlist",vipMemberPlanlist);
	    return "account/vipMemberApply/vipMemberApply";*/
		
		HashMap<String,Object> params=new HashMap<>();
		if(getMerchantCode() != null && getMerchantCode().length() != 0){
			params.put("merchantCode",getMerchantCode());
			params.put("companyCode", getMerchantCode());
		}
		List<VipMemberPlanDO>  vipMemberPlanlist = vipMemberPlanService.list(params);
		List<MerchDo> merchantList=merchService.list(params);
		model.addAttribute("merchantList",merchantList);
		model.addAttribute("vipMemberPlanlist",vipMemberPlanlist);
		 return "account/vipMemberApply/vipMemberApply";
	}
	
	@ResponseBody
	@GetMapping("/account")
	@RequiresPermissions("account:vipMemberApply:vipMemberApply")
	public PageUtils list(@RequestParam Map<String, Object> params){
/*		//查询列表数据
		if( getMerchantCode()!=null && !getMerchantCode().equals("")){
			params.put("merchantCode",getMerchantCode());
		}*/
		if(!params.containsKey("merchantCode") || getMerchantCode() != null && getMerchantCode().length() != 0){
			params.put("merchantCode",getMerchantCode());
		}
		
        Query query = new Query(params);
		List<VipMemberApplyDO> vipmemberapplyList = vipmemberapplyService.list(query);
		int total = vipmemberapplyService.count(query);
		PageUtils pageUtils = new PageUtils(vipmemberapplyList, total);
		return pageUtils;
		
/*		PageUtils pageUtil=null;
		if( getMerchantCode()==null||getMerchantCode().equals("")){
 
			
			Query query = new Query(params);
			List<VipMemberApplyDO> vipmemberapplyList = vipmemberapplyService.list(query);
			int total = vipmemberapplyService.count(query);
			pageUtil = new PageUtils(vipmemberapplyList, total);
		}else{
 
			
			params.put("merchantCode",getMerchantCode());
			Query query = new Query(params);
			List<VipMemberApplyDO> vipmemberapplyList = vipmemberapplyService.list(query);
			int total = vipmemberapplyService.count(query);
			pageUtil = new PageUtils(vipmemberapplyList, total);
		}*/

	}
	
 

 
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("account:vipMemberApply:remove")
	public R remove( Integer id){
		if(vipmemberapplyService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("account:vipMemberApply:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		vipmemberapplyService.batchRemove(ids);
		return R.ok();
	}
	
}
