package com.slzr.operation.dao;


import com.slzr.operation.domain.GuestMessageDO;
import com.slzr.operation.domain.OPTBusDO;

import java.util.List;
import java.util.Map;

//@Mapper
public interface OPTBusDao {

	List<OPTBusDO> list(Map<String, Object> map);

	int count(Map<String, Object> map);
	
	int save(OPTBusDO oPTBusDO);
	
	int remove(Integer ID);

	int update(OPTBusDO oPTBusDO);

	OPTBusDO getByID(Integer ID);


}