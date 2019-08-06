package com.slzr.operation.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.slzr.account.domain.AccountDO;
import com.slzr.account.service.CardTypeService;
import com.slzr.common.controller.BaseController;
import com.slzr.common.utils.PageUtils;
import com.slzr.common.utils.Query;
import com.slzr.common.utils.R;
import com.slzr.operation.domain.OptBranchDO;
import com.slzr.operation.service.OptBranchService;
import com.slzr.set.domain.MerchDo;
import com.slzr.set.service.MerchService;

 
 
@Controller
@RequestMapping("/operation/optBranch")
public class OptBranchController extends BaseController{
	@Autowired
	private  OptBranchService oPTBranchService;
	
	@Autowired
	private MerchService merchService;
	
	@GetMapping()
	@RequiresPermissions("operation:optBranch:optBranch")
	String CardType(Model model){
		List<MerchDo> merchantList =merchService.list(null);
		model.addAttribute("merchantList",merchantList);
		
		if(getMerchantCode()==null||getMerchantCode().equals("")){
			model.addAttribute("isAdmin","y");
		}
	    return "operation/optBranch/optBranch";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("operation:optBranch:optBranch")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
		PageUtils pageUtil=null;
		
		if(getMerchantCode()==null||getMerchantCode().equals("")){
			Query query = new Query(params);
			List<OptBranchDO> sysUserList = oPTBranchService.list(query);
			int total = oPTBranchService.count(query);
			pageUtil = new PageUtils(sysUserList, total);
		}else{
			params.put("merchantCode",getMerchantCode());
			Query query = new Query(params);
			List<OptBranchDO> sysUserList=oPTBranchService.list(query);
			int total = oPTBranchService.count(query);
			pageUtil = new PageUtils(sysUserList, total);
		}
		return pageUtil;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("operation:optBranch:add")
	String add(Model model){
		List<MerchDo> merchantList =merchService.list(null);
		model.addAttribute("merchantList",merchantList);
		
		if(getMerchantCode()==null||getMerchantCode().equals("")){
			model.addAttribute("isAdmin","y");
		}
		
		return "operation/optBranch/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("operation:optBranch:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		OptBranchDO branch = oPTBranchService.get(id);
		model.addAttribute("branch", branch);
		
		List<MerchDo> merchantList =merchService.list(null);
		model.addAttribute("merchantList",merchantList);
		
		if(getMerchantCode()==null||getMerchantCode().equals("")){
			model.addAttribute("isAdmin","y");
		}
		
		return "operation/optBranch/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("operation:optBranch:add")
	public R save( OptBranchDO branch){
		branch.setCreatedDate(new Date());
		branch.setCreatedBy(Integer.parseInt(getUser().getId()+""));
		
		if(getMerchantCode()!=null&&!getMerchantCode().equals("")){
			branch.setMerchantCode(getMerchantCode());
		}
		if(oPTBranchService.save(branch)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("operation:optBranch:edit")
	public R update( OptBranchDO branch){
		branch.setUpdatedDate(new Date());
		branch.setUpdatedBy(Integer.parseInt(getUser().getId()+""));
		oPTBranchService.update(branch);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("operation:optBranch:remove")
	public R remove( Integer id){
		if(oPTBranchService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	

	
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("operation:optBranch:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		oPTBranchService.batchRemove(ids);
		return R.ok();
	}
	
}
