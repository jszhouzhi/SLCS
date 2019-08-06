package com.slzr.ureport.service;

import java.util.List;
import java.util.Map;

import com.slzr.ureport.domain.ACountDo;

/**
 * 一级统计
 */

public interface ACountService {
	
	/**
	 * 一级统计 车辆消费统计
	 * @param map
	 * @return
	 */
	List<ACountDo> ACountCarlist(Map<String, Object> map);
	
	/**
	 * 一级统计  部门消费统计
	 * @param map
	 * @return
	 */
	List<ACountDo> ACountDeptlist(Map<String, Object> map);
	
	
	/**
	 * 一级统计  司机消费统计
	 * @param map
	 * @return
	 */
	List<ACountDo> ACountDriverlist(Map<String, Object> map);
	
	
	/**
	 * 一级统计  线路消费统计
	 * @param map
	 * @return
	 */
	List<ACountDo> ACountLine(Map<String, Object> map);
}
