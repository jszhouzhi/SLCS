package com.slzr.operation.service.Impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slzr.operation.dao.TopupTransDao;
import com.slzr.operation.domain.TopupTransDO;
import com.slzr.operation.service.TopupTransService;

@Service
public class TopupTransServiceImpl implements TopupTransService {
	
	@Autowired
	private TopupTransDao topuptransDao;
	@Override
	public List<TopupTransDO> list(Map<String, Object> map) {
		return topuptransDao.list(map);
	}

	@Override
	public int count(Map<String, Object> map) {
		return topuptransDao.count(map);
	}

	@Override
	public TopupTransDO get(String id) {
		int value = Integer.parseInt(id);
		return topuptransDao.get(value);
	}

}
