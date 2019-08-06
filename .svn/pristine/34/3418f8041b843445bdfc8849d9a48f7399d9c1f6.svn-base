package com.slzr.set.dao;

import com.slzr.set.domain.TicketpriceDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

 
@Mapper
public interface TicketpriceDao {

	TicketpriceDO get(Integer id);
	
	List<TicketpriceDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(TicketpriceDO ticketprice);
	
	int update(TicketpriceDO ticketprice);
	
	int remove(Integer ID);
	
	int batchRemove(Integer[] ids);
	
	int updateByEnable(TicketpriceDO ticketprice);
	 
}
