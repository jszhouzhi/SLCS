package com.slzr.ureport.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.slzr.ureport.domain.IcTransferCountDo;

/**
 * IC卡圈存统计
 */

@Mapper
public interface IcTransferCountDao {
	List<IcTransferCountDo> list(Map<String, Object> map);
}
