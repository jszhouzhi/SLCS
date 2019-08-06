package com.slzr.account.dao;
 

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.slzr.account.domain.VipMemberApplyDO;

 
@Mapper
public interface VipMemberApplyDao {

	VipMemberApplyDO get(Integer id);
	
	List<VipMemberApplyDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(VipMemberApplyDO vipmemberapply);
	
	int update(VipMemberApplyDO vipmemberapply);
	
	int remove(Integer ID);
	
	int batchRemove(Integer[] ids);
}
