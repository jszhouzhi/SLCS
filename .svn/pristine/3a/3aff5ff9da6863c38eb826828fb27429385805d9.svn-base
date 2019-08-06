package com.slzr.set.service.impl;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.slzr.common.utils.R;
import com.slzr.set.dao.TicketpriceDao;
import com.slzr.set.domain.TicketpriceDO;
import com.slzr.set.service.TicketpriceService;



@Service
public class TicketpriceServiceImpl implements TicketpriceService {
	@Autowired
	private TicketpriceDao ticketpriceDao;
	
	@Override
	public TicketpriceDO get(Integer id){
		return ticketpriceDao.get(id);
	}
	
	@Override
	public List<TicketpriceDO> list(Map<String, Object> map){
		return ticketpriceDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return ticketpriceDao.count(map);
	}
	
	@Override
	@Transactional(readOnly = false,rollbackFor = Exception.class)
	public R save(TicketpriceDO ticketprice,@RequestParam Map<String, Object> params,Integer uId){
		/*return ticketpriceDao.save(ticketprice);*/
		
        String  content = params.get("content").toString();
        if(content.indexOf("carType")>0) {
            String head = content.substring(0, content.indexOf("&!carType"));

            String end = content.substring(content.indexOf("carType"), content.length());
            String[] ends = end.split("&!");
            
            String merchantcode = head.substring(head.indexOf("merchantcode=") + 13, head.indexOf("&linecode"));
            String linecode = head.substring(head.indexOf("linecode=") + 9, head.indexOf("&isenable"));
           // String pricesetting = head.substring(head.indexOf("pricesetting=") + 13, head.indexOf("&isenable"));
            String isenable = head.substring(head.indexOf("isenable=") + 9, head.length());
            JSONObject discountSettingJosn= new JSONObject(true);
            List<String> list = new ArrayList<>();
            for (int i = 0; i < ends.length; i++) {
                String carType = ends[i].substring(ends[i].indexOf("carType=") + 8, ends[i].indexOf("&disCount"));
                String disCount = ends[i].substring(ends[i].indexOf("disCount=") + 9 , ends[i].length());
 
                //输入价格为空
                if (carType.equals("") || disCount.equals("")) {
                	return R.error("请输入卡类和折扣");
                } 
                Pattern pattern = Pattern.compile("^[0-9]*[1-9][0-9]*$");
                Matcher m = pattern.matcher(carType);
                boolean isValid = m.matches();
                if(!isValid){
                	return R.error("卡类应为正整数 ");
                }
                list.add(carType);
                long count = list.stream().distinct().count();
                boolean isRepeat = count < list.size();                
                if (isRepeat){  //list存在一样的卡类  carType
                	return R.error("卡类不能重复！");
                } 
                
                HashMap<String,Object> p=new HashMap<>();
                p.put("merchantCode", merchantcode);
                p.put("linecode", linecode);
        		List<TicketpriceDO> t = ticketpriceDao.list(p);
        		if(t!=null && t.size()>0){
        			//System.out.println("商户和线路已同时存在,卡类折扣设置时，卡类不能重复");
        			for (TicketpriceDO ticketpriceDO : t) {
        				String j = ticketpriceDO.getDiscountsetting().replace(" ", "");
        				System.out.println(j);
        				JSONObject json = JSON.parseObject(j);
        				System.out.println("KEY:"+json.containsKey(carType));
        				if(json.containsKey(carType)){
        					return R.error("商户和线路相同时，卡类不能重复");
        				}
					}
        		}
       
                discountSettingJosn.put(carType, disCount);
            }
            
            if (isenable.equals("1")) {
            //如果为启用状态1，那么同一个商户和线路 只能启用一个     
            	TicketpriceDO ticketpriceIsNo = new TicketpriceDO();
            	ticketpriceIsNo.setIsenable("0");
            	/*ticketprice.setId(Integer.parseInt(id));*/
                ticketpriceIsNo.setMerchantCode(merchantcode);
                ticketpriceIsNo.setLinecode(linecode);
                ticketpriceDao.updateByEnable(ticketpriceIsNo);
            } 
            
            ticketprice.setMerchantCode(merchantcode);
            ticketprice.setLinecode(linecode);
            ticketprice.setPricesetting("0");
            ticketprice.setDiscountsetting(discountSettingJosn.toJSONString());
            ticketprice.setIsenable(isenable);
            ticketprice.setUmaxstation(0);
            ticketprice.setDmaxstation(0);
            ticketprice.setCreatedby(uId);
            ticketprice.setCreateddate(new Date());
                       
			if(ticketpriceDao.save(ticketprice)>0){
				return R.ok();
			}else{
				return R.error("添加失败");
			}
        }else{
        	return R.error("请添加卡类和折扣！");
        }
	}
	
	@Override
	public int update(TicketpriceDO ticketprice){
		return ticketpriceDao.update(ticketprice);
	}
	
	@Override
	public int remove(Integer id){
		return ticketpriceDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return ticketpriceDao.batchRemove(ids);
	}
	
	@Override
	@Transactional(readOnly = false,rollbackFor = Exception.class)
	public R updateByEnable(TicketpriceDO ticketprice,@RequestParam Map<String, Object> params,Integer uId){
        String  content = params.get("content").toString();
        String id = params.get("id")+"";
         
        if(content.indexOf("carType")>0) {
            String head = content.substring(0, content.indexOf("&!carType"));

            String end = content.substring(content.indexOf("carType"), content.length());
            String[] ends = end.split("&!");
            
            String merchantcode = head.substring(head.indexOf("merchantcode=") + 13, head.indexOf("&linecode"));
            String linecode = head.substring(head.indexOf("linecode=") + 9, head.indexOf("&isenable"));
            //String pricesetting = head.substring(head.indexOf("pricesetting=") + 13, head.indexOf("&isenable"));
            String isenable = head.substring(head.indexOf("isenable=") + 9, head.length());
            JSONObject discountSettingJosn= new JSONObject(true);
            List<String> list = new ArrayList<>();
            for (int i = 0; i < ends.length; i++) {
                String carType = ends[i].substring(ends[i].indexOf("carType=") + 8, ends[i].indexOf("&disCount"));
                String disCount = ends[i].substring(ends[i].indexOf("disCount=") + 9 , ends[i].length());
 
                //输入价格为空
                if (carType.equals("") || disCount.equals("")) {
                	return R.error("请输入卡类和折扣");
                }
                Pattern pattern = Pattern.compile("^[0-9]*[1-9][0-9]*$");
                Matcher m = pattern.matcher(carType);
                boolean isValid = m.matches();
                if(!isValid){
                	return R.error("卡类应为正整数 ");
                }
                list.add(carType);
                long count = list.stream().distinct().count();
                boolean isRepeat = count < list.size();                
                if (isRepeat){  //list存在一样的卡类  carType
                	return R.error("卡类不能重复！");
                } 
                
                HashMap<String,Object> p=new HashMap<>();
                p.put("merchantCode", merchantcode.split("=")[1]);
                p.put("linecode", linecode);
                p.put("id", id);
        		List<TicketpriceDO> t = ticketpriceDao.list(p);
        		if(t!=null && t.size()>0){
        			//System.out.println("商户和线路已同时存在,卡类折扣设置时，卡类不能重复");
        			for (TicketpriceDO ticketpriceDO : t) {
        				String j = ticketpriceDO.getDiscountsetting().replace(" ", "");
        				System.out.println(j);
        				JSONObject json = JSON.parseObject(j);
        				System.out.println("KEY:"+json.containsKey(carType));
        				if(json.containsKey(carType)){
        					return R.error("商户和线路相同时，卡类不能重复");
        				}
					}
        		}
       
                discountSettingJosn.put(carType, disCount);
            }
                        
            if (isenable.equals("1")) {
            //如果为启用状态1，那么同一个商户和线路 只能启用一个     
            	TicketpriceDO ticketpriceIsNo = new TicketpriceDO();
            	ticketpriceIsNo.setIsenable("0");
            	ticketprice.setId(Integer.parseInt(id));
                ticketpriceIsNo.setMerchantCode(merchantcode.split("=")[1]);
                ticketpriceIsNo.setLinecode(linecode);
                ticketpriceDao.updateByEnable(ticketpriceIsNo);
            } 

            
            ticketprice.setId(Integer.parseInt(id));
            ticketprice.setMerchantCode(merchantcode.split("=")[1]);
            ticketprice.setLinecode(linecode);
            ticketprice.setPricesetting("0");
            ticketprice.setDiscountsetting(discountSettingJosn.toJSONString());
            ticketprice.setIsenable(isenable);
    		ticketprice.setUpdateby(uId);
    		ticketprice.setUpdatedate(new Date());		    		
                       
			if(ticketpriceDao.update(ticketprice)>0){
				return R.ok();
			}else{
				return R.error("修改失败");
			}
        }else{
        	return R.error("请添加卡类和折扣！");
        }
	}
	
	
}
