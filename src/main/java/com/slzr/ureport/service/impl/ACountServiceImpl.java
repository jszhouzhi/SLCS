package com.slzr.ureport.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slzr.ureport.dao.ACountDao;
import com.slzr.ureport.domain.ACountDo;
import com.slzr.ureport.service.ACountService;

/**
 * 一级统计
 */

@Service
public class ACountServiceImpl implements ACountService{
	@Autowired
	private ACountDao aCountDao;

	@Override
	public List<ACountDo> ACountCarlist(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return aCountDao.ACountCarlist(map);
	}

	@Override
	public List<ACountDo> ACountDeptlist(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return aCountDao.ACountDeptlist(map);
	}

	@Override
	public List<ACountDo> ACountDriverlist(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return aCountDao.ACountDriverlist(map);
	}

	@Override
	public List<ACountDo> ACountLine(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return aCountDao.ACountLine(map);
	}



}
