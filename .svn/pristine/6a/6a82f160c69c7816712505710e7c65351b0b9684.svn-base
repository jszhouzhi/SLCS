package com.slzr.operation.controller;

import com.slzr.common.annotation.SystemControllerLog;
import com.slzr.common.controller.BaseController;
import com.slzr.common.utils.R;
import com.slzr.operation.domain.OPTDepartmentDO;
import com.slzr.operation.service.OPTDepartmentService;
import com.slzr.set.domain.MerchDo;
import com.slzr.set.service.MerchService;
import com.slzr.system.domain.UserDO;
import com.slzr.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RequestMapping("/operation/optdepartment")
@Controller
public class OPTDepartmentController extends BaseController{
	private String prefix = "operation/optdepartment";
	@Autowired
	private OPTDepartmentService oPTDepartmentService;
	
    @Autowired
    MerchService  merchService;


	@Autowired
	UserService userService;
	@GetMapping("/list")
	@SystemControllerLog(description="0")
	public String list() {
		return prefix + "/list";
	}
	
	@GetMapping("/add")
	public String add(Model model) {
		List<MerchDo> merchList = merchService.list(null);
		model.addAttribute("merchList",merchList);	
		model.addAttribute("parentId", "0");
		return prefix + "/add";
	}
	
	@GetMapping("/add/{id}")
	String addD(Model model, @PathVariable("id") String id) {		
		List<MerchDo> merchList = merchService.list(null);
		model.addAttribute("merchList",merchList);			
		OPTDepartmentDO optDepartment = oPTDepartmentService.getByID(Integer.parseInt(id));
		model.addAttribute("parentId", optDepartment.getiD());
		return prefix + "/add";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(Model model,@PathVariable("id") String id) {
		List<MerchDo> merchList = merchService.list(null);
		model.addAttribute("merchList",merchList);	
		OPTDepartmentDO optDepartmentDO = oPTDepartmentService.getByID(Integer.parseInt(id));		
		model.addAttribute("optDepartmentDO",optDepartmentDO);
		model.addAttribute("model",oPTDepartmentService.getByID(Integer.valueOf(id)));
		model.addAttribute("id",id);
		return prefix + "/edit";
	}
	

	@GetMapping("api/list")
	@ResponseBody
	public List<OPTDepartmentDO> list1() {
		UserDO userDO = userService.get(getId());
		List<OPTDepartmentDO> sysDeptList=null;
		if(userDO.getMerchantCode()==""||userDO.getMerchantCode()==null){
			//查询列表数据
			Map<String, Object> query =  new HashMap();
			sysDeptList = oPTDepartmentService.list(query);
		}else{
			Map<String, Object> query =  new HashMap();
			query.put("merchantCode",userDO.getMerchantCode());
			sysDeptList = oPTDepartmentService.list(query);
		}

		return sysDeptList;
	}
	
	@ResponseBody
	@SystemControllerLog(description="1")
	@PostMapping("api/add")
	public R apiadd(OPTDepartmentDO optDepartmentDO) {
		if (oPTDepartmentService.save(optDepartmentDO) > 0) {
			return R.ok();
		}
		return R.error();
	}
	
	@PostMapping("/exist")
	@ResponseBody
	boolean exit(@RequestParam Map<String, Object> params) {
		// 存在，不通过，false
		return !oPTDepartmentService.exist(params);
	}
	
	@ResponseBody
	@SystemControllerLog(description="2")
	@PostMapping("api/edit")
	public R apiedit(OPTDepartmentDO optDepartmentDO) {
		oPTDepartmentService.update(optDepartmentDO);
		return R.ok();
	}
	
	


	/**
	 * 标记 删除
	 */
	@PostMapping("/deleteDepartment")
	@SystemControllerLog(description="3")
	@ResponseBody
	//	@RequiresPermissions("operation:GuestMessage:remove")
	public R deleteart(Integer id){
		try {
//			GuestMessageDO Do = GuestMessageService.getByID(id);
			oPTDepartmentService.remove(id);
			return R.ok();
		}catch (Exception e) {
			e.printStackTrace();
			return R.error();
		}
	}
	
}
