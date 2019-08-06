package com.slzr.operation.service.Impl;

import com.slzr.operation.dao.ICTopupOrderDao;
import com.slzr.operation.dao.ICTopupTransactionDao;
import com.slzr.operation.domain.ICTopupOrderDO;
import com.slzr.operation.domain.ICTopupTransactionDO;
import com.slzr.operation.service.ICTopupOrderService;
import com.slzr.operation.service.ICTopupTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ICTopupTransactionServiceImpl implements ICTopupTransactionService {
	@Autowired
	private ICTopupTransactionDao icTopupTransactionDao;

	@Override
	public List<ICTopupTransactionDO> list(Map<String, Object> map) {
		return icTopupTransactionDao.list(map);
	}

	@Override
	public int count(Map<String, Object> map) {
		return icTopupTransactionDao.count(map);
	}

	@Override
	public ICTopupTransactionDO get(String id) {
		int value = Integer.parseInt(id);
		return icTopupTransactionDao.get(value);
	}

	@Override
	public void updateAudit(String id, int auditvalue, int chkuserid, String remark) {
		icTopupTransactionDao.updateAudit(id, auditvalue, chkuserid, remark);
	}

}
