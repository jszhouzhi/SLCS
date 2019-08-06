package com.slzr.operation.service;

import java.util.List;
import java.util.Map;

import com.slzr.operation.domain.DebitTransDO;

public interface DebitTransService{

	List<DebitTransDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	DebitTransDO get(String id);
}
