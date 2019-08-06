package com.slzr.operation.service.Impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slzr.operation.dao.DebitTransDao;
import com.slzr.operation.domain.DebitTransDO;
import com.slzr.operation.service.DebitTransService;

@Service
public class DebitTransServiceImpl implements DebitTransService{
	
	@Autowired
	private DebitTransDao debittransDao;

	@Override
	public List<DebitTransDO> list(Map<String, Object> map) {
		return debittransDao.list(map);
	}

	@Override
	public int count(Map<String, Object> map) {
		return debittransDao.count(map);
	}

	@Override
	public DebitTransDO get(String id) {
		int value = Integer.parseInt(id);
		return debittransDao.get(value);
	}

}
