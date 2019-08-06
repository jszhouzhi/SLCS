package com.slzr.account.service;
import java.util.List;
import java.util.Map;

import com.slzr.account.domain.CardTypeDO;
import com.slzr.account.domain.IcCardAuditDO;
public interface IcCardAuditService{
 
    
    
    
    
    
	List<IcCardAuditDO> get();
	
	IcCardAuditDO getByid(Long id);
	
	List<IcCardAuditDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(IcCardAuditDO icCardAuditDO);
	
	int update(IcCardAuditDO icCardAuditDO);
	
	int remove(Integer id);
	
	IcCardAuditDO getFirst(Map<String, Object> map);
	
	List<IcCardAuditDO> getBycardNo(String cardNo);
}