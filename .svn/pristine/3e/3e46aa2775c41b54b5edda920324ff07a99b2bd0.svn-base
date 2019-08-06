package com.slzr.operation.dao;

import com.slzr.operation.domain.DailysummarySettleDO;
import com.slzr.operation.domain.ICTopupOrderDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface ICTopupOrderDao {

	List<ICTopupOrderDO> list(Map<String, Object> map);

	int count(Map<String, Object> map);

	ICTopupOrderDO get(int id);

	void updateAudit(@Param("id") String id, @Param("auditvalue") int auditvalue, @Param("chkuserid") int chkuserid, @Param("remark") String remark);
}