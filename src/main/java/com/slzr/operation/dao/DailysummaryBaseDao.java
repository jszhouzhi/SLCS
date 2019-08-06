package com.slzr.operation.dao;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import com.slzr.operation.domain.DailysummaryBaseDO;

@Mapper
public interface DailysummaryBaseDao{

	List<DailysummaryBaseDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
 

}