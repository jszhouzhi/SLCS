package com.slzr.operation.service;
import java.util.List;
import java.util.Map;

import com.slzr.operation.domain.OptBranchDO;
public interface OptBranchService{
	
	OptBranchDO get(Integer id);
	
	List<OptBranchDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(OptBranchDO branch);
	
	int update(OptBranchDO branch);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
 
}