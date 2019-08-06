package com.slzr.operation.dao;


import com.slzr.operation.domain.GuestMessageDO;
import com.slzr.operation.domain.OPTLineDO;

import java.util.List;
import java.util.Map;

//@Mapper
public interface OPTLineDao {

	List<OPTLineDO> list(Map<String, Object> map);

	int count(Map<String, Object> map);
	
	int save(OPTLineDO oPTLineDO);
	
	int remove(Integer ID);

	int update(OPTLineDO oPTLineDO);

	OPTLineDO getByID(Integer ID);


}