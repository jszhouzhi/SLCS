package com.slzr.common.controller;

import com.slzr.common.annotation.SystemControllerLog;
import com.slzr.common.domain.DictDO;
import com.slzr.common.service.DictService;
import com.slzr.common.utils.PageUtils;
import com.slzr.common.utils.Query;
import com.slzr.common.utils.R;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** 
 * 字典
 * 2018.02.08
 * @author Administrator
 */

@Controller
@RequestMapping("/common/sysDict")
public class DictController extends BaseController {
	@Autowired
	private DictService sysDictService;

	@GetMapping()
	@SystemControllerLog(description="0")
	@RequiresPermissions("common:sysDict:sysDict")
	String sysDict() {
		return "common/sysDict/sysDict";
	}

	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("common:sysDict:sysDict")
	public PageUtils list(@RequestParam Map<String, Object> params) {
		// 查询列表数据
		Query query = new Query(params);
		List<DictDO> sysDictList = sysDictService.list(query);
		int total = sysDictService.count(query);
		PageUtils pageUtils = new PageUtils(sysDictList, total);
		return pageUtils;
	}

	@GetMapping("/add")
	@RequiresPermissions("common:sysDict:add")
	String add() {
		return "common/sysDict/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("common:sysDict:edit")
	String edit(@PathVariable("id") Long id, Model model) {
		DictDO sysDict = sysDictService.get(id);
		model.addAttribute("sysDict", sysDict);
		
        List<DictDO> sysDictList = sysDictService.listType();
        model.addAttribute("sysDictList", sysDictList);
		return "common/sysDict/edit";
	}

	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@SystemControllerLog(description="1")
	@RequiresPermissions("common:sysDict:add")
	public R save(DictDO sysDict) {
		Long nowId = (long) sysDictService.findMaxid()+1;
		sysDict.setId(nowId);
		if (sysDictService.save(sysDict) > 0) {
			return R.ok();
		}
		return R.error();
	}

	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@SystemControllerLog(description="2")
	@RequiresPermissions("common:sysDict:edit")
	public R update(DictDO sysDict) {
		sysDictService.update(sysDict);
		return R.ok();
	}

	/**
	 * 删除
	 */
	@PostMapping("/remove")
	@ResponseBody
	@SystemControllerLog(description="3")
	@RequiresPermissions("common:sysDict:remove")
	public R remove(Long id) {
		if (sysDictService.remove(id) > 0) {
			return R.ok();
		}
		return R.error();
	}

	/**
	 * 删除
	 */
	@PostMapping("/batchRemove")
	@ResponseBody
	@RequiresPermissions("common:sysDict:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids) {
		sysDictService.batchRemove(ids);
		return R.ok();
	}

	@GetMapping("/type")
	@ResponseBody
	public List<DictDO> listType() {
		return sysDictService.listType();
	};

	// 类别已经指定增加
	@GetMapping("/add/{dictCode}")
	@RequiresPermissions("common:sysDict:add")
	String addD(Model model, @PathVariable("dictCode") String dictCode) {
		model.addAttribute("dictCode", dictCode);
		return "common/sysDict/add";
	}

	@ResponseBody
	@GetMapping("/list/{type}")
	public List<DictDO> listByType(@PathVariable("type") String type) {
		// 查询列表数据
		Map<String, Object> map = new HashMap<>(16);
		map.put("type", type);
		List<DictDO> dictList = sysDictService.list(map);
		return dictList;
	}
}
