package com.slzr.operation.service;

import com.slzr.operation.domain.ICTopupOrderDO;
import com.slzr.operation.domain.ICTopupTransactionDO;

import java.util.List;
import java.util.Map;

public interface ICTopupTransactionService {

	List<ICTopupTransactionDO> list(Map<String, Object> map);

	int count(Map<String, Object> map);

	ICTopupTransactionDO get(String id);

	void updateAudit(String id, int auditvalue, int chkuserid, String remark);
}