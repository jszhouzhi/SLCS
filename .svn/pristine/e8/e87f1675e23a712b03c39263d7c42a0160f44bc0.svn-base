package com.slzr.operation.dao;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.slzr.operation.domain.OptBranchDO;
@Mapper
public interface OptBranchDao{
	OptBranchDO get(Integer id);
	
	List<OptBranchDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(OptBranchDO branch);
	
	int update(OptBranchDO branch);
	
	int remove(Integer ID);
	
	int batchRemove(Integer[] ids);
}