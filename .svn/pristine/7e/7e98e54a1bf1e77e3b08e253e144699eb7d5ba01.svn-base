package com.slzr.operation.service.Impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slzr.operation.dao.DebittransactionDistanceDao;
import com.slzr.operation.domain.DebittransactionDistanceDO;
import com.slzr.operation.service.DebittransactionDistanceService;

  



@Service
public class DebittransactionDistanceServiceImpl implements DebittransactionDistanceService {
	 @Autowired
	private DebittransactionDistanceDao debittransactionDistanceDao;
	
	@Override
	public DebittransactionDistanceDO get(Integer id){
		return debittransactionDistanceDao.get(id);
	}
	
	@Override
	public List<DebittransactionDistanceDO> list(Map<String, Object> map){
		return debittransactionDistanceDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return debittransactionDistanceDao.count(map);
	}
	
 
	
}
