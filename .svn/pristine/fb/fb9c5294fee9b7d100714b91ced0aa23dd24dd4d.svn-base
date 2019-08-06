package com.slzr.operation.dao;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.slzr.operation.domain.DailysummarySettleDO;
import com.slzr.operation.domain.DailysummaryTopupDO;

@Mapper
public interface DailysummaryTopupDao{

	List<DailysummaryTopupDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	DailysummaryTopupDO get(int id);

	void updateAudit(@Param("id") int id,@Param("auditvalue") int auditvalue,@Param("chkuserid") int chkuserid,@Param("remark") String remark);
	
	String againDaily(String txndate);

}