package com.slzr.set.service.impl;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slzr.set.dao.QaDao;
import com.slzr.set.domain.QaDO;
import com.slzr.set.service.QaService;

import java.util.List;
import java.util.Map;

 



@Service
public class QaServiceImpl implements QaService {
	@Autowired
	private QaDao qaDao;
	
	@Override
	public QaDO get(Integer id){
		return qaDao.get(id);
	}
	
	@Override
	public List<QaDO> list(Map<String, Object> map){
		return qaDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return qaDao.count(map);
	}
	
	@Override
	public int save(QaDO qa){
		return qaDao.save(qa);
	}
	
	@Override
	public int update(QaDO qa){
		return qaDao.update(qa);
	}
	
	@Override
	public int remove(Integer id){
		return qaDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return qaDao.batchRemove(ids);
	}
	
}
