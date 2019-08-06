package com.slzr.operation.service.Impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slzr.operation.dao.DailysummarySettleDao;
import com.slzr.operation.domain.DailysummarySettleDO;
import com.slzr.operation.service.DailysummarySettleService;

@Service
public class DailysummarySettleServiceImpl implements DailysummarySettleService {
	@Autowired
	private DailysummarySettleDao dailysummaryDao;

	@Override
	public List<DailysummarySettleDO> list(Map<String, Object> map) {
		return dailysummaryDao.list(map);
	}

	@Override
	public int count(Map<String, Object> map) {
		return dailysummaryDao.count(map);
	}

	@Override
	public DailysummarySettleDO get(String id) {
		int value = Integer.parseInt(id);
		return dailysummaryDao.get(value);
	}

	@Override
	public void updateAudit(String id, int auditvalue, int chkuserid) {
		dailysummaryDao.updateAudit(id, auditvalue, chkuserid);
	}

	@Override
	public void updateTransStatus(String id, int chkuserid, String remark, BigDecimal amount, Date transdate,
			String transno, int transstatus) {
		dailysummaryDao.updateTransStatus(id, chkuserid, remark, amount, transdate, transno, transstatus);
	}

}
