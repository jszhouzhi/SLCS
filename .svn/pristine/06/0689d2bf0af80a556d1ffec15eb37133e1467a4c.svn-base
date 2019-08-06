package com.slzr.operation.service.Impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slzr.operation.dao.DailysummaryBaseDao;
import com.slzr.operation.domain.DailysummaryBaseDO;
import com.slzr.operation.service.DailysummaryBaseService;
 
 

@Service
public class DailysummaryBaseServiceImpl implements DailysummaryBaseService {
	@Autowired
	private DailysummaryBaseDao dailysummaryBaseDao;

	@Override
	public List<DailysummaryBaseDO> list(Map<String, Object> map) {
		return dailysummaryBaseDao.list(map);
	}

	@Override
	public int count(Map<String, Object> map) {
		return dailysummaryBaseDao.count(map);
	}



}
