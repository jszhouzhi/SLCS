package com.slzr.set.service;

import com.slzr.common.utils.R;
import com.slzr.set.domain.TicketpriceDO;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestParam;

 
public interface TicketpriceService {
	
	TicketpriceDO get(Integer id);
	
	List<TicketpriceDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	R save(TicketpriceDO ticketprice,@RequestParam Map<String, Object> params,Integer uId);
	
	int update(TicketpriceDO ticketprice);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
	
	R updateByEnable(TicketpriceDO ticketprice,Map<String, Object> params,Integer uId);
}
