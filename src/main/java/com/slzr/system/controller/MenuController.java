package com.slzr.system.controller;

import com.slzr.common.annotation.Log;
import com.slzr.common.annotation.SystemControllerLog;
import com.slzr.common.config.Constant;
import com.slzr.common.controller.BaseController;
import com.slzr.common.domain.Tree;
import com.slzr.common.utils.R;
import com.slzr.system.domain.MenuDO;
import com.slzr.system.domain.RoleDO;
import com.slzr.system.domain.UserDO;
import com.slzr.system.service.MenuService;

import com.slzr.system.service.UserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** 
 * 菜单
 * 2018.02.08
 * @author Administrator
 */
@RequestMapping("/sys/menu")
@Controller
public class MenuController extends BaseController {
	String prefix = "system/menu";
	@Autowired
	MenuService menuService;

	@Autowired
	private UserService userService;

	@RequiresPermissions("sys:menu:menu")
	@SystemControllerLog(description="0")
	@GetMapping()
	String menu(Model model) {
		return prefix+"/menu";
	}

	@RequiresPermissions("sys:menu:menu")
	@RequestMapping("/list")
	@ResponseBody
/*	List<MenuDO> list(@RequestParam Map<String, Object> params) {

		UserDO userDO = userService.get(getId());
		List<MenuDO> menus =null;
		if(userDO.getMerchantCode()==null||userDO.getMerchantCode().equals("")){

			menus = menuService.list(params);
		}else{
			params.put("merchantCode",userDO.getMerchantCode());
			menus = menuService.list(params);
		}
		return menus;
	}*/
	List<MenuDO> list() {
		HashMap<String,Object> params=new HashMap<>();
		UserDO user = userService.get(getId());
		Long roleId = user.getRoleIds().get(0);
		
		params.put("roleId", roleId);

		List<MenuDO> menus = menuService.list(params);
		return menus;
	}

	@Log("添加菜单")
	@RequiresPermissions("sys:menu:add")
	@GetMapping("/add/{pId}")
	String add(Model model, @PathVariable("pId") Long pId) {
		model.addAttribute("pId", pId);
		if (pId == 0) {
			model.addAttribute("pName", "根目录");
		} else {
			model.addAttribute("pName", menuService.get(pId).getName());
		}
		return prefix + "/add";
	}

	@Log("编辑菜单")
	@RequiresPermissions("sys:menu:edit")
	@GetMapping("/edit/{id}")
	String edit(Model model, @PathVariable("id") Long id) {
		MenuDO mdo = menuService.get(id);
		Long pId = mdo.getParentId();
		model.addAttribute("pId", pId);
		if (pId == 0) {
			model.addAttribute("pName", "根目录");
		} else {
			model.addAttribute("pName", menuService.get(pId).getName());
		}
		model.addAttribute("menu", mdo);
		return prefix+"/edit";
	}

	@Log("保存菜单")
	@RequiresPermissions("sys:menu:add")
	@SystemControllerLog(description="1")
	@PostMapping("/save")
	@ResponseBody
	R save(MenuDO menu) {
		if (Constant.DEMO_ACCOUNT.equals(getUserName())) {
			return R.error(1, "演示系统不允许修改,完整体验请部署程序");
		}
		if (menuService.save(menu) > 0) {
			return R.ok();
		} else {
			return R.error(1, "保存失败");
		}
	}

	@Log("更新菜单")
	@SystemControllerLog(description="2")
	@RequiresPermissions("sys:menu:edit")
	@PostMapping("/update")
	@ResponseBody
	R update(MenuDO menu) {
		if (Constant.DEMO_ACCOUNT.equals(getUserName())) {
			return R.error(1, "演示系统不允许修改,完整体验请部署程序");
		}
		if (menuService.update(menu) > 0) {
			return R.ok();
		} else {
			return R.error(1, "更新失败");
		}
	}

	@Log("删除菜单")
	@SystemControllerLog(description="3")
	@RequiresPermissions("sys:menu:remove")
	@PostMapping("/remove")
	@ResponseBody
	R remove(Long id) {
		if (Constant.DEMO_ACCOUNT.equals(getUserName())) {
			return R.error(1, "演示系统不允许修改,完整体验请部署程序");
		}
		if (menuService.remove(id) > 0) {
			return R.ok();
		} else {
			return R.error(1, "删除失败");
		}
	}

	@GetMapping("/tree")
	@ResponseBody
	Tree<MenuDO> tree() {
		Tree<MenuDO> tree = new Tree<MenuDO>();
		UserDO user = userService.get(getId());
		Long roleId = user.getRoleIds().get(0);
		
		HashMap<String,Object> params = new HashMap<String,Object>();
		if(getMerchantCode() != null && !getMerchantCode().equals(""))
			params.put("roleId", roleId);
		tree = menuService.getTree(0L,params);
		return tree;
	}

	@GetMapping("/tree/{roleId}")
	@ResponseBody
	Tree<MenuDO> tree(@PathVariable("roleId") Long roleId) {
		Tree<MenuDO> tree = new Tree<MenuDO>();
		
		HashMap<String,Object> params = new HashMap<String,Object>();
		if(getMerchantCode() != null && !getMerchantCode().equals("")){
			UserDO user = userService.get(getId());

			params.put("roleId", user.getRoleIds().get(0));
		}
		
		tree = menuService.getTree(roleId,params);
		return tree;
	}
}
