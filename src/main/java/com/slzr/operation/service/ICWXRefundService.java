package com.slzr.operation.service;

import com.slzr.operation.domain.ICTopupOrderDO;
import com.slzr.operation.domain.ICWXRefundDO;

import java.util.List;
import java.util.Map;

public interface ICWXRefundService {

	List<ICWXRefundDO> list(Map<String, Object> map);

	int count(Map<String, Object> map);

	ICWXRefundDO get(String id);

	void updateAudit(String id, int auditvalue, int chkuserid, String remark);
}