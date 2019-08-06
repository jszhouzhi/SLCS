package com.slzr.operation.service.Impl;

import com.slzr.operation.dao.GuestMessageDao;
import com.slzr.operation.dao.OPTLineDao;
import com.slzr.operation.domain.GuestMessageDO;
import com.slzr.operation.domain.OPTLineDO;
import com.slzr.operation.service.GuestMessageService;
import com.slzr.operation.service.OPTLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OPTLineServiceImpl implements OPTLineService {
	@Autowired
	private OPTLineDao oPTLineDao;

	@Override
	public List<OPTLineDO> list(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return oPTLineDao.list(map);
	}

	@Override
	public int count(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return oPTLineDao.count(map);
	}

	@Override
	public int save(OPTLineDO oPTLineDO) {
		// TODO Auto-generated method stub
		return oPTLineDao.save(oPTLineDO);
	}

	@Override
	public int remove(Integer id) {
		// TODO Auto-generated method stub
		return oPTLineDao.remove(id);
	}

	public int update(OPTLineDO oPTLineDO) {
		return oPTLineDao.update(oPTLineDO);
	}

	public OPTLineDO getByID(int id){
		return oPTLineDao.getByID(id);
	}

}
