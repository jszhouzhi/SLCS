package com.slzr.account.service;
 

import java.util.List;
import java.util.Map;

import com.slzr.account.domain.VipMemberApplyDO;

 
public interface VipMemberApplyService{
	
	VipMemberApplyDO get(Integer id);
	
	List<VipMemberApplyDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(VipMemberApplyDO vipmemberapply);
	
	int update(VipMemberApplyDO vipmemberapply);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
