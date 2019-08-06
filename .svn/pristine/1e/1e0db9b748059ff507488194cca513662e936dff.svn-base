package com.slzr.ureport.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slzr.ureport.dao.IcTransferCountDao;
import com.slzr.ureport.domain.IcTransferCountDo;
import com.slzr.ureport.service.IcTransferCountService;

/**
 * IC卡圈存统计
 */

@Service
public class IcTransferCountServiceImpl implements IcTransferCountService{
	@Autowired
	private IcTransferCountDao icTransferCountDao;

	@Override
	public List<IcTransferCountDo> list(Map<String, Object> map) {
		return icTransferCountDao.list(map);
	}

}
