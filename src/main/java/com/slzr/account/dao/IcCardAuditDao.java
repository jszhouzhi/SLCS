package com.slzr.account.dao;
import com.slzr.account.domain.IcCardAuditDO;
import java.util.List;
import java.util.Map;
public interface IcCardAuditDao{

    
    
    
    
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