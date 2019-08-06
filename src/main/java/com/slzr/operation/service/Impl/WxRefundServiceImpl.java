package com.slzr.operation.service.Impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slzr.operation.dao.TopupTransDao;
import com.slzr.operation.dao.WxRefundDao;
import com.slzr.operation.domain.WxRefundDO;
import com.slzr.operation.service.WxRefundService;

@Service
public class WxRefundServiceImpl implements WxRefundService {
	@Autowired
	private WxRefundDao wxrefundDao;

	@Override
	public List<WxRefundDO> list(Map<String, Object> map) {
		return wxrefundDao.list(map);
	}

	@Override
	public int count(Map<String, Object> map) {
		return wxrefundDao.count(map);
	}

	@Override
	public WxRefundDO get(String id) {
		int value = Integer.parseInt(id);
		return wxrefundDao.get(value);
	}

}
