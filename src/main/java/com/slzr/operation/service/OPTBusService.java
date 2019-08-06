package com.slzr.operation.service;

import com.slzr.operation.domain.GuestMessageDO;
import com.slzr.operation.domain.OPTBusDO;

import java.util.List;
import java.util.Map;

public interface OPTBusService {

	List<OPTBusDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(OPTBusDO oPTBusDO);
		
	int remove(Integer id);

	int update(OPTBusDO oPTBusDO);

	OPTBusDO getByID(int id);
	
}