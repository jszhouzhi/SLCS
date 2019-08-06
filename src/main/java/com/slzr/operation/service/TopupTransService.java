package com.slzr.operation.service;

import java.util.List;
import java.util.Map;

import com.slzr.operation.domain.TopupTransDO;

public interface TopupTransService {

	List<TopupTransDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	TopupTransDO get(String id);
}
