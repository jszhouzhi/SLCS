package com.slzr.operation.service.Impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slzr.account.dao.AccountCancelDao;
import com.slzr.operation.dao.DailysummaryTopupDao;
import com.slzr.operation.domain.DailysummaryTopupDO;
import com.slzr.operation.service.DailysummaryTopupService;

@Service
public class DailysummaryTopupServiceImpl implements DailysummaryTopupService {
	@Autowired
	private DailysummaryTopupDao dailysummaryDao;

	@Override
	public List<DailysummaryTopupDO> list(Map<String, Object> map) {
		return dailysummaryDao.list(map);
	}

	@Override
	public int count(Map<String, Object> map) {
		return dailysummaryDao.count(map);
	}

	@Override
	public DailysummaryTopupDO get(int id) {
		return dailysummaryDao.get(id);
	}

	@Override
	public void updateAudit(int id, int auditvalue, int chkuserid, String remark) {
		dailysummaryDao.updateAudit(id, auditvalue, chkuserid, remark);
	}

	@Override
	public String againDaily(String txndate) {
		return dailysummaryDao.againDaily(txndate);
	}

}
