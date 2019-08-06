package com.slzr.operation.service.Impl;

import com.slzr.operation.dao.ICTopupOrderDao;
import com.slzr.operation.dao.ICWXRefundDao;
import com.slzr.operation.domain.ICTopupOrderDO;
import com.slzr.operation.domain.ICWXRefundDO;
import com.slzr.operation.service.ICTopupOrderService;
import com.slzr.operation.service.ICWXRefundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ICWXRefundServiceImpl implements ICWXRefundService {
	@Autowired
	private ICWXRefundDao icwxRefundDao;

	@Override
	public List<ICWXRefundDO> list(Map<String, Object> map) {
		return icwxRefundDao.list(map);
	}

	@Override
	public int count(Map<String, Object> map) {
		return icwxRefundDao.count(map);
	}

	@Override
	public ICWXRefundDO get(String id) {
		int value = Integer.parseInt(id);
		return icwxRefundDao.get(value);
	}

	@Override
	public void updateAudit(String id, int auditvalue, int chkuserid, String remark) {
		icwxRefundDao.updateAudit(id, auditvalue, chkuserid, remark);
	}

}
