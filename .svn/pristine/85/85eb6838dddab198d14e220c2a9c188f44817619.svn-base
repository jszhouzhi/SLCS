package com.slzr.account.service.impl;
 
import org.springframework.stereotype.Service;

import com.slzr.account.dao.VipMemberApplyDao;
import com.slzr.account.domain.VipMemberApplyDO;
import com.slzr.account.service.VipMemberApplyService;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
 



@Service
public class VipMemberApplyServiceImpl implements VipMemberApplyService {
	@Resource
	private VipMemberApplyDao vipmemberapplyDao;
	
	@Override
	public VipMemberApplyDO get(Integer id){
		return vipmemberapplyDao.get(id);
	}
	
	@Override
	public List<VipMemberApplyDO> list(Map<String, Object> map){
		return vipmemberapplyDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return vipmemberapplyDao.count(map);
	}
	
	@Override
	public int save(VipMemberApplyDO vipmemberapply){
		return vipmemberapplyDao.save(vipmemberapply);
	}
	
	@Override
	public int update(VipMemberApplyDO vipmemberapply){
		return vipmemberapplyDao.update(vipmemberapply);
	}
	
	@Override
	public int remove(Integer id){
		return vipmemberapplyDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return vipmemberapplyDao.batchRemove(ids);
	}
	
}
