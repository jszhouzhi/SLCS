package com.slzr.account.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.slzr.account.domain.CardTypeDO;
import com.slzr.account.domain.IcCardAuditDO;
import com.slzr.account.service.CardTypeService;
import com.slzr.account.service.IcCardAuditService;
import com.slzr.common.controller.BaseController;
import com.slzr.common.utils.PageUtils;
import com.slzr.common.utils.Query;
import com.slzr.common.utils.R;
import com.slzr.set.domain.MerchDo;
import com.slzr.set.service.MerchService;

 
 
@Controller
@RequestMapping("/account/icCardAudit")
public class IcCardAuditController extends BaseController{
	@Autowired
	private IcCardAuditService icCardAuditService;
	
	@Autowired
	private MerchService merchService;
	
	@Autowired
	private CardTypeService cardTypeService;
	
	@GetMapping()
	@RequiresPermissions("account:icCardAudit:icCardAudit")
	String icCardAudit(Model model){
		HashMap<String,Object> params=new HashMap<>();
		if(getMerchantCode() != null && getMerchantCode().length() != 0){
			params.put("merchantCode",getMerchantCode());
		}
		List<MerchDo> merchantList=merchService.list(params);
		model.addAttribute("merchantList",merchantList);
		
	    return "account/icCardAudit/icCardAudit";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("account:icCardAudit:icCardAudit")
	public PageUtils list(@RequestParam Map<String, Object> params){
		
		if(!params.containsKey("merchantCode") || getMerchantCode() != null && getMerchantCode().length() != 0){
			params.put("merchantCode",getMerchantCode());
		}
		
		//查询列表数据
        Query query = new Query(params);
		List<IcCardAuditDO> icCardAuditList = icCardAuditService.list(query);
		int total = icCardAuditService.count(query);
		PageUtils pageUtils = new PageUtils(icCardAuditList, total);
		return pageUtils;
	}
	
 
	/**
	 * 审核页面
	 */
	@GetMapping("/edit/{p}")
	@RequiresPermissions("account:icCardAudit:edit")
	String edit(@PathVariable("p") String p,Model model){
		String [] arr = p.split("&");
		Long id = Long.parseLong(arr[0]);
		String isDetails = arr[1];
		
		IcCardAuditDO icCardAudit = icCardAuditService.getByid(id);
		
		if(icCardAudit.getCertPhotoUrl()!=null && !icCardAudit.getCertPhotoUrl().equals("")){
			icCardAudit.setCertPhotoUrl("/"+icCardAudit.getCertPhotoUrl());
		}
		if(icCardAudit.getCertPhotoBackUrl()!=null && !icCardAudit.getCertPhotoBackUrl().equals("")){
			icCardAudit.setCertPhotoBackUrl("/"+icCardAudit.getCertPhotoBackUrl());
		}
		if(icCardAudit.getPersonPhotoUrl()!=null && !icCardAudit.getPersonPhotoUrl().equals("")){
			icCardAudit.setPersonPhotoUrl("/"+icCardAudit.getPersonPhotoUrl());
		}
		if(icCardAudit.getPersonPhotoBackUrl()!=null && !icCardAudit.getPersonPhotoBackUrl().equals("")){
			icCardAudit.setPersonPhotoBackUrl("/"+icCardAudit.getPersonPhotoBackUrl());
		}
		if(icCardAudit.getConfirmPhotoUrl()!=null && !icCardAudit.getConfirmPhotoUrl().equals("")){
			icCardAudit.setConfirmPhotoUrl("/"+icCardAudit.getConfirmPhotoUrl());
		}
		
		model.addAttribute("icCardAudit", icCardAudit);
		
		List<MerchDo> merchantList =merchService.list(null);
		model.addAttribute("merchantList",merchantList);
		
		if(isDetails.equals("0")){
			model.addAttribute("isDetails","0");
		}else{		
			if(icCardAudit.getCardNO()!=null){
				List<IcCardAuditDO> listIcCardAudit = icCardAuditService.getBycardNo(icCardAudit.getCardNO());
				if(listIcCardAudit!=null){
					if(listIcCardAudit.size()>1){
						Map map = new HashMap<>();
						map.put("cardNO", icCardAudit.getCardNO());
						map.put("id", icCardAudit.getId());
						IcCardAuditDO first_icCardAudit = icCardAuditService.getFirst(map);
						
						if(first_icCardAudit.getCertPhotoUrl()!=null && !first_icCardAudit.getCertPhotoUrl().equals("")){
							first_icCardAudit.setCertPhotoUrl("/"+first_icCardAudit.getCertPhotoUrl());
						}
						if(first_icCardAudit.getCertPhotoBackUrl()!=null && !first_icCardAudit.getCertPhotoBackUrl().equals("")){
							first_icCardAudit.setCertPhotoBackUrl("/"+first_icCardAudit.getCertPhotoBackUrl());
						}
						if(first_icCardAudit.getPersonPhotoUrl()!=null && !first_icCardAudit.getPersonPhotoUrl().equals("")){
							first_icCardAudit.setPersonPhotoUrl("/"+first_icCardAudit.getPersonPhotoUrl());
						}
						if(first_icCardAudit.getPersonPhotoBackUrl()!=null && !first_icCardAudit.getPersonPhotoBackUrl().equals("")){
							first_icCardAudit.setPersonPhotoBackUrl("/"+first_icCardAudit.getPersonPhotoBackUrl());
						}
						if(first_icCardAudit.getConfirmPhotoUrl()!=null && !first_icCardAudit.getConfirmPhotoUrl().equals("")){
							first_icCardAudit.setConfirmPhotoUrl("/"+first_icCardAudit.getConfirmPhotoUrl());
						}
						
						model.addAttribute("lastTime_icCardAudit",first_icCardAudit);
					}else{
						model.addAttribute("isFirst","true");
					}
				}
			}
		}
		
	    return "account/icCardAudit/deal";
	}
	
 
	/**
	 * 审核 保存
	 */
	@ResponseBody
	@RequestMapping("/Deal")
	@RequiresPermissions("account:icCardAudit:edit")
	public R update( Long id,String operationType,String desctext){
		
		IcCardAuditDO icCardAuditDO = icCardAuditService.getByid(id);
		
		int cardTypeID;
		String merchantCode;
		if(icCardAuditDO.getCardTypeID()!=null){
			cardTypeID = icCardAuditDO.getCardTypeID();
			merchantCode = icCardAuditDO.getMerchantCode();
		 
		}else{
			return R.error("卡类型未知，审核失败！");
		}
 
		HashMap map = new HashMap<>();
		map.put("cardTypeID", cardTypeID);
		map.put("merchantCode", merchantCode);
		CardTypeDO cardType = cardTypeService.getByCardTypeID(map);
		if(cardType == null){
			return R.error("审核异常！没有为 "+cardTypeID+" 的CardTypeID，或者商户不对应！");
		}else{
		
			/*int fid = Integer.parseInt(icCardAuditDO.getCardNO());
			CardTypeDO cardType = cardTypeService.getByid(fid);*/
			
			IcCardAuditDO icCardAudit = new IcCardAuditDO();
			
			icCardAudit.setId(id);
			
			icCardAudit.setAuditDesc(desctext);
			icCardAudit.setState(Integer.parseInt(operationType));
			icCardAudit.setUpdatedDate(new Date());
			icCardAudit.setUpdatedByName(getUserName());
			icCardAudit.setUpdatedBy(getId());
			if(cardType.getSubCardTypeID()==null){
				return R.error("审核异常！没有对应SubCardTypeID");
			}
			if(operationType.equals("1")){ //审核通过
				icCardAudit.setSubCardTypeID(cardType.getSubCardTypeID());
				icCardAudit.setTimes(cardType.getTimes());
				
				//Date edate = icCardAuditDO.getCardExpireTime();
				Date edate = icCardAuditDO.getBeforeCardExpireTime();
			    Calendar rightNow = Calendar.getInstance();
			    rightNow.setTime(edate);  
			    rightNow.add(Calendar.DAY_OF_MONTH, +cardType.getAuditvaliddays());
			    Date dt1 = rightNow.getTime();
	 	 
				icCardAudit.setCardExpireTime(dt1);
			}
			
			icCardAuditService.update(icCardAudit);
			return R.ok();
		}
	}
	
 
 
	
}
