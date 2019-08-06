package com.slzr.operation.service;

import com.slzr.operation.domain.TopuporderDO;

import java.util.List;
import java.util.Map;

/**
 * 订单 圈存异常
 * @author lc
 * @date 2018-03-20 11:15:51
 */
public interface TopuporderService {
	
	TopuporderDO get(Integer id);
	
	List<TopuporderDO> list(Map<String, Object> map);
	List<TopuporderDO> processedFind_list(Map<String, Object> map);
	int count(Map<String, Object> map);
	int processedFind_count(Map<String, Object> map);
	
	int update(TopuporderDO topuporder);
	

}
