package com.slzr.set.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.slzr.common.controller.BaseController;
import com.slzr.common.utils.PageUtils;
import com.slzr.common.utils.Query;
import com.slzr.common.utils.R;
import com.slzr.set.domain.MerchDo;
import com.slzr.set.domain.TicketpriceDO;
import com.slzr.set.service.MerchService;
import com.slzr.set.service.TicketpriceService;

/**
 * 票价设置
 * 
 
 */
 
@Controller
@RequestMapping("/set/ticketprice")
public class TicketpriceController extends BaseController{
	@Autowired
	private TicketpriceService ticketpriceService;
	
	@Autowired
	private MerchService merchService;
	
	@GetMapping()
	@RequiresPermissions("set:ticketprice:ticketprice")
	String Ticketprice(ModelMap model){
		
		HashMap<String,Object> params=new HashMap<>();
		if(getMerchantCode() != null && getMerchantCode().length() != 0){
			params.put("merchantCode",getMerchantCode());
		}
		List<MerchDo> merchantList=merchService.list(params);
		model.addAttribute("merchantList",merchantList);
		
	    return "set/ticketprice/ticketprice";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("set:ticketprice:ticketprice")
	public PageUtils list(@RequestParam Map<String, Object> params){
		
		if(!params.containsKey("merchantCode") || getMerchantCode() != null && getMerchantCode().length() != 0){
			params.put("merchantCode",getMerchantCode());
		}
		
		//查询列表数据
        Query query = new Query(params);
		List<TicketpriceDO> ticketpriceList = ticketpriceService.list(query);
		int total = ticketpriceService.count(query);
		PageUtils pageUtils = new PageUtils(ticketpriceList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("set:ticketprice:add")
	String add(Model model){
		HashMap<String,Object> params=new HashMap<>();
		if(getMerchantCode() != null && getMerchantCode().length() != 0){
			params.put("merchantCode",getMerchantCode());
		}
		List<MerchDo> merchantList=merchService.list(params);
		model.addAttribute("merchantList",merchantList);
	    return "set/ticketprice/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("set:ticketprice:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		TicketpriceDO ticketprice = ticketpriceService.get(id);
		model.addAttribute("ticketprice", ticketprice);
		
		HashMap<String,Object> params=new HashMap<>();
		if(getMerchantCode() != null && getMerchantCode().length() != 0){
			params.put("merchantCode",getMerchantCode());
		}
		List<MerchDo> merchantList=merchService.list(params);
		model.addAttribute("merchantList",merchantList);
		
	    return "set/ticketprice/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("set:ticketprice:add")
	public R save( TicketpriceDO ticketprice,@RequestParam Map<String, Object> params){
		return ticketpriceService.save(ticketprice,params,getId().intValue());
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("set:ticketprice:edit")
	public R update( TicketpriceDO ticketprice,@RequestParam Map<String, Object> params){
		return ticketpriceService.updateByEnable(ticketprice,params,getId().intValue());
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("set:ticketprice:remove")
	public R remove( Integer id){
		if(ticketpriceService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	@PostMapping( "/updateByDelete")
	@ResponseBody
	public R updateByDelete( HttpServletRequest request){
		String id= request.getParameter("id");
		String aryJson= request.getParameter("aryJson");
		String key= request.getParameter("key");
		
		JSONObject jsonObject=JSON.parseObject(aryJson.toString()); 
		jsonObject.remove(key);
		
		TicketpriceDO ticketprice = new TicketpriceDO();
		ticketprice.setId(Integer.parseInt(id));
		ticketprice.setDiscountsetting(jsonObject.toJSONString());
		
		if(ticketpriceService.update(ticketprice)>0){
		return R.ok();
		}
		return R.error();
	}
	
}
