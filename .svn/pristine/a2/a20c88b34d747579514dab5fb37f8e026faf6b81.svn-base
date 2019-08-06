package com.slzr.operation.controller;


import com.slzr.common.annotation.Log;
import com.slzr.common.annotation.SystemControllerLog;
import com.slzr.common.controller.BaseController;
import com.slzr.common.domain.DictDO;
import com.slzr.common.utils.*;
import com.slzr.operation.domain.SendCaseDo;
import com.slzr.operation.service.SendCaseService;
import com.slzr.set.domain.ApiDo;
import com.slzr.set.domain.MerchDo;
import com.slzr.set.service.MerchService;
import com.slzr.system.domain.UserDO;
import com.slzr.system.service.UserService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/operation/sendcase")
@Controller
public class SendCaseController extends BaseController{

	private String prefix = "operation/sendcase";

    @Autowired
    private SendCaseService sendCaseService;
    @Autowired
    private MerchService merchService;

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    @SystemControllerLog(description="0")
    @RequiresPermissions("operation:sendcase:list")
    public String list(Model model) {
        HashMap<String,Object> params=new HashMap<>();
        UserDO userDO = userService.get(getId());
        List<MerchDo> merchantList=null;
        if(userDO.getMerchantCode()==""||userDO.getMerchantCode()==null){
            merchantList=merchService.list(params);
        }else{
            params.put("merchantCode",userDO.getMerchantCode());
            merchantList=merchService.list(params);
        }
        model.addAttribute("merchantList",merchantList);
        return prefix + "/list";
    }

    @ResponseBody
    @GetMapping("api/list")
    @RequiresPermissions("operation:sendcase:list")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        UserDO userDO = userService.get(getId());
        PageUtils pageUtil=null;
        if(userDO.getMerchantCode()==""||userDO.getMerchantCode()==null){
            //查询列表数据
            Query query = new Query(params);
            List<SendCaseDo> list = sendCaseService.list(query);
            int total = sendCaseService.count(query);
            pageUtil = new PageUtils(list, total);
        }else{
            params.put("merchantCode",userDO.getMerchantCode());
            //查询列表数据
            Query query = new Query(params);
            List<SendCaseDo> list = sendCaseService.list(query);
            int total = sendCaseService.count(query);
            pageUtil = new PageUtils(list, total);
        }

        return pageUtil;
    }
    
    
	@GetMapping("/add")
	@RequiresPermissions("operation:sendcase:add")
	String add(Model model){
        HashMap<String,Object> params=new HashMap<>();
        UserDO userDO = userService.get(getId());
        List<MerchDo> merchantList=null;
        if(userDO.getMerchantCode()==""||userDO.getMerchantCode()==null){
            merchantList=merchService.list(params);
        }else{
            params.put("merchantCode",userDO.getMerchantCode());
            merchantList=merchService.list(params);
        }
        model.addAttribute("merchantList",merchantList);
        
	    return prefix + "/add";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping(value = "/save")
	@RequiresPermissions("operation:sendcase:add")
	public R save(@RequestParam Map<String, Object> params){
        int result = sendCaseService.save(params);
        if(result==-3){
            return R.error("您输入的价格区间有误,请重新输入!");
        }else if(result==-1){
            return R.error("您输入的价格不合法,请重新输入!");
        }else if(result==-2){
            return R.error("您输入的价格为空,请重新输入!");
        }else if(result==-4){
            return R.error("请输入赠送方案区间!");
        } else {
            return R.ok();
        }

	}
	
	
	
	@GetMapping("/edit/{id}")
	@RequiresPermissions("operation:sendcase:edit")
	String edit(@PathVariable("id") Integer id,Model model){
        Map<String, Object> map=new HashMap<>();
        map.put("id",id);
        List<SendCaseDo> disSettings = sendCaseService.list(map);
        SendCaseDo disSetting=null;
        for (SendCaseDo disSett :disSettings){
            disSetting=disSett;
        }
        disSetting.setEffectiveDateTime(DateUtils.format( DateUtils.ConvertToDate(disSetting.getEffectiveDateTime()), DateUtils.DATE_PATTERN));
        disSetting.setExpiredDateTime(DateUtils.format( DateUtils.ConvertToDate(disSetting.getExpiredDateTime()), DateUtils.DATE_PATTERN));
        List<SendCaseDo> disSettingDeta = sendCaseService.lists(map);
        for(SendCaseDo sendCaseDo:disSettingDeta){
            sendCaseDo.setDiscountAmountUnit(sendCaseDo.getDiscountAmountUnit()==null?"":sendCaseDo.getDiscountAmountUnit());
        }
        model.addAttribute("disSetting",disSetting);

        model.addAttribute("disSettingDeta",disSettingDeta);

        return prefix + "/edit";
	}


    @RequiresPermissions("operation:sendcase:edit")
    @Log("更新商户")
    @PostMapping("/update")
    @ResponseBody
    public R update(@RequestParam Map<String, Object> params){
        int result = sendCaseService.update(params);
        if(result==-3){
            return R.error("您输入的价格区间有误,请重新输入!");
        }else if(result==-1){
            return R.error("您输入的价格不合法,请重新输入!");
        }else if(result==-2){
            return R.error("您输入的价格为空,请重新输入!");
        } else if(result==-4){
            return R.error("请输入赠送方案区间!");
        } else {
            return R.ok();
        }
    }

    /**resetEnabled
     * 启用优惠方案
     */
    @RequiresPermissions("operation:sendcase:esetEnabled")
    @PostMapping("/resetEnabled")
    @ResponseBody
   public  R resetEnabled(Integer id,Model model){

        if(sendCaseService.updateEnable(id)>0){
            return  R.ok();
        }
        return R.error();
    }

    /**resetEnabled
     * 禁用优惠方案
     */
    @RequiresPermissions("operation:sendcase:eesetEnabled")
    @PostMapping("/reesetEnabled")
    @ResponseBody
    public  R reesetEnabled(Integer id,Model model){

        if(sendCaseService.updateUnEnable(id)>0){
            return  R.ok();
        }
        return R.error();
    }



    /**resetEnabled
     * 删除方案
     */
    @RequiresPermissions("operation:sendcase:remove")
    @PostMapping("/remove")
    @ResponseBody
    public  R remove(Integer id,Model model){

        if(sendCaseService.remove(id)>0){
            return  R.ok();
        }
        return R.error();
    }
}
