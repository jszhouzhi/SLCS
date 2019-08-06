package com.slzr.operation.service.Impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slzr.operation.dao.TopuporderDao;
import com.slzr.operation.domain.TopuporderDO;
import com.slzr.operation.service.TopuporderService;

import java.util.List;
import java.util.Map;




@Service
public class TopuporderServiceImpl implements TopuporderService {
	@Autowired
	private TopuporderDao topuporderDao;
	
	@Override
	public TopuporderDO get(Integer id){
		return topuporderDao.get(id);
	}
	
	@Override
	public List<TopuporderDO> list(Map<String, Object> map){
		return topuporderDao.list(map);
	}
	@Override
	public List<TopuporderDO> processedFind_list(Map<String, Object> map){
		return topuporderDao.processedFind_list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return topuporderDao.count(map);
	}
	@Override
	public int processedFind_count(Map<String, Object> map){
		return topuporderDao.processedFind_count(map);
	}
	
	@Override
	public int update(TopuporderDO topuporder){
		return topuporderDao.update(topuporder);
	}

	
}
