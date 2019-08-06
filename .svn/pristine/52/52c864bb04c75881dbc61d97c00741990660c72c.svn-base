package com.slzr.operation.service.Impl;

import com.slzr.operation.dao.DailysummaryTopupDao;
import com.slzr.operation.dao.ICTopupOrderDao;
import com.slzr.operation.domain.DailysummaryTopupDO;
import com.slzr.operation.domain.ICTopupOrderDO;
import com.slzr.operation.service.DailysummaryTopupService;
import com.slzr.operation.service.ICTopupOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ICTopupOrderServiceImpl implements ICTopupOrderService {
	@Autowired
	private ICTopupOrderDao icTopupOrderDao;

	@Override
	public List<ICTopupOrderDO> list(Map<String, Object> map) {
		return icTopupOrderDao.list(map);
	}

	@Override
	public int count(Map<String, Object> map) {
		return icTopupOrderDao.count(map);
	}

	@Override
	public ICTopupOrderDO get(String id) {
		int value = Integer.parseInt(id);
		return icTopupOrderDao.get(value);
	}

	@Override
	public void updateAudit(String id, int auditvalue, int chkuserid, String remark) {
		icTopupOrderDao.updateAudit(id, auditvalue, chkuserid, remark);
	}

}
