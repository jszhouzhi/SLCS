package com.slzr.common.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.slzr.common.dao.LogDao;
import com.slzr.common.domain.LogContentDo;
import com.slzr.common.domain.LogDO;
import com.slzr.common.service.LogService;
import com.slzr.common.utils.Query;
import com.slzr.set.domain.SysSetting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogServiceImpl implements LogService {
	

	@Autowired
	private LogDao logDao;
	
	@Override
	public int createLog(LogDO log) {
		//return this.logDao.insertSelective(log);
		//System.out.println("模拟日志入库"+log);
		return logDao.createLog(log);
	}
	
	@Override
	public int updateLog(LogDO log) {
		//return this.logDao.updateByPrimaryKeySelective(log);
		//System.out.println("模拟日志更新"+log);
		return logDao.updateLog(log);
	}

	@Override
	public List<LogDO> list(Query query) {
		return logDao.list(query);
	}

	@Override
	public int count(Query query) {
		return logDao.count(query);
	}


}
