package com.slzr.operation.service;

import com.slzr.operation.domain.ICTopupOrderDO;

import java.util.List;
import java.util.Map;

public interface ICTopupOrderService {

	List<ICTopupOrderDO> list(Map<String, Object> map);

	int count(Map<String, Object> map);

	ICTopupOrderDO get(String id);

	void updateAudit(String id, int auditvalue, int chkuserid, String remark);
}