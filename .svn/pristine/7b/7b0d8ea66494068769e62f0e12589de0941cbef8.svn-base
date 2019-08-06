package com.slzr.account.service.impl;
import java.util.List;
import java.util.Map;

import com.slzr.account.dao.CardTypeDao;
import com.slzr.account.dao.IcCardAuditDao;
import com.slzr.account.domain.CardTypeDO;
import com.slzr.account.domain.IcCardAuditDO;
import com.slzr.account.service.IcCardAuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class IcCardAuditServiceImpl implements IcCardAuditService{
    @Autowired
    private IcCardAuditDao icCardAuditDao;
  
 
    
 
	
	@Override
	public List<IcCardAuditDO> get(){
		return icCardAuditDao.get();
	}
	
	@Override
	public IcCardAuditDO getByid(Long id){
		return icCardAuditDao.getByid(id);
	}
	
	@Override
	public List<IcCardAuditDO> list(Map<String, Object> map){
		return icCardAuditDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return icCardAuditDao.count(map);
	}
	
	@Override
	public int save(IcCardAuditDO icCardAuditDO){
		return icCardAuditDao.save(icCardAuditDO);
	}
	
	@Override
	public int update(IcCardAuditDO icCardAuditDO){
		return icCardAuditDao.update(icCardAuditDO);
	}
	
	@Override
	public int remove(Integer id){
		return icCardAuditDao.remove(id);
	}
	
	@Override
	public IcCardAuditDO getFirst(Map<String, Object> map){
		return icCardAuditDao.getFirst(map);
	}
	
	@Override
	public List<IcCardAuditDO> getBycardNo(String cardNo){
		return icCardAuditDao.getBycardNo(cardNo);
	}

}