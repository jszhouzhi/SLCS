package com.slzr.set.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mysql.jdbc.StringUtils;
import com.slzr.common.controller.BaseController;
import com.slzr.common.domain.DictDO;
import com.slzr.common.service.DictService;
import com.slzr.common.utils.PageUtils;
import com.slzr.common.utils.Query;
import com.slzr.common.utils.R;
import com.slzr.operation.domain.ArticleDO;
import com.slzr.set.domain.MerchDo;
import com.slzr.set.domain.QaDO;
import com.slzr.set.service.MerchService;
import com.slzr.set.service.QaService;

/**
 * 常见问答服务
 * 
 */
 
@Controller
@RequestMapping("/set/qa")
public class QaController extends BaseController{
	@Autowired
	private QaService qaService;
	
	@Autowired
	private DictService dictService;
	
	@Autowired
	private MerchService merchService;
	
	@GetMapping()
	@RequiresPermissions("set:qa:qa")
	String Qa(Model model){
		HashMap<String,Object> dictMap=new HashMap<>();
		dictMap.put("type", "QAType");
		
		List<DictDO> listDictDO = dictService.list(dictMap);
		model.addAttribute("dictType", listDictDO);
		
		HashMap<String,Object> params=new HashMap<>();
		if(getMerchantCode() != null && getMerchantCode().length() != 0){
			params.put("merchantCode",getMerchantCode());
		}
		List<MerchDo> merchantList=merchService.list(params);
		model.addAttribute("merchantList",merchantList);
		
	    return "set/qa/qa";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("set:qa:qa")
	public PageUtils list(@RequestParam Map<String, Object> params){
		if(!params.containsKey("merchantCode") || getMerchantCode() != null && getMerchantCode().length() != 0){
			params.put("merchantCode",getMerchantCode());
		}
		
		//查询列表数据
        Query query = new Query(params);
		List<QaDO> qaList = qaService.list(query);
		int total = qaService.count(query);
		PageUtils pageUtils = new PageUtils(qaList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("set:qa:add")
	String add(Model model){
		
		HashMap<String,Object> params=new HashMap<>();
		if(getMerchantCode() != null && getMerchantCode().length() != 0){
			params.put("merchantCode",getMerchantCode());
		}
		List<MerchDo> merchantList=merchService.list(params);
		model.addAttribute("merchantList",merchantList);
		
		HashMap<String,Object> dictMap=new HashMap<>();
		dictMap.put("type", "QAType");
		List<DictDO> listDictDO = dictService.list(dictMap);
		model.addAttribute("dictType", listDictDO);
	    return "set/qa/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("set:qa:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		QaDO qa = qaService.get(id);
		model.addAttribute("qa", qa);
		
		HashMap<String,Object> dictMap=new HashMap<>();
		dictMap.put("type", "QAType");
		List<DictDO> listDictDO = dictService.list(dictMap);
		model.addAttribute("dictType", listDictDO);
		
		HashMap<String,Object> params=new HashMap<>();
		if(getMerchantCode() != null && getMerchantCode().length() != 0){
			params.put("merchantCode",getMerchantCode());
		}
		List<MerchDo> merchantList=merchService.list(params);
		model.addAttribute("merchantList",merchantList);
		
	    return "set/qa/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("set:qa:add")
	public R save( QaDO qa,@RequestParam Map<String, Object> params){
		String questionTypeId = qa.getQuestionTypeId();
		String question = qa.getQuestion();
		
		String content = params.get("content").toString();
		String merchantCode = qa.getMerchantCode();
		
		String isEnable = qa.getIsEnable();
 
		 
		
		if(StringUtils.isNullOrEmpty(questionTypeId))
		{
			return R.error("问题类型不能为空");
		}
		if(StringUtils.isNullOrEmpty(question))
		{
			return R.error("问题不能为空");
		}
		if(StringUtils.isNullOrEmpty(content))
		{
			return R.error("答案内容不能为空");
		}
		if(StringUtils.isNullOrEmpty(isEnable))
		{
			return R.error("开启状态不能为空");
		}
		
		qa.setQuestionTypeId(questionTypeId);
		qa.setQuestion(question);
		qa.setIsEnable(isEnable);
		qa.setAnswer(content);
		qa.setCreatedBy(getId().intValue());
		qa.setCreatedDate(new Date());
		qa.setMerchantCode(merchantCode);
		
		if(qaService.save(qa)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("set:qa:edit")
	public R update( QaDO qa,@RequestParam Map<String, Object> params){
		
		String questionTypeId = qa.getQuestionTypeId();
		String question = qa.getQuestion();
		
		String content = params.get("content").toString();
		
		String isEnable = qa.getIsEnable();
		String merchantCode = qa.getMerchantCode();
		Long id =Long.parseLong(params.get("id").toString());
		 
		
		if(StringUtils.isNullOrEmpty(questionTypeId))
		{
			return R.error("问题类型不能为空");
		}
		if(StringUtils.isNullOrEmpty(question))
		{
			return R.error("问题不能为空");
		}
		if(StringUtils.isNullOrEmpty(content))
		{
			return R.error("答案内容不能为空");
		}
		if(StringUtils.isNullOrEmpty(isEnable))
		{
			return R.error("开启状态不能为空");
		}
		qa.setId(id);
		qa.setQuestionTypeId(questionTypeId);
		qa.setQuestion(question);
		qa.setIsEnable(isEnable);
		qa.setAnswer(content);
		qa.setUpdatedBy(getId().intValue());
		qa.setUpdatedDate(new Date());
		qa.setMerchantCode(merchantCode);
		
		qaService.update(qa);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("set:qa:remove")
	public R remove( Integer id){
		if(qaService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("set:qa:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		qaService.batchRemove(ids);
		return R.ok();
	}
	
}
