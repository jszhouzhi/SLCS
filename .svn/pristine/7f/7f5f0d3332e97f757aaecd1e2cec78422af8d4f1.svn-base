package com.slzr.operation.service.Impl;

import com.slzr.operation.dao.GuestMessageDao;
import com.slzr.operation.dao.OPTBusDao;
import com.slzr.operation.domain.GuestMessageDO;
import com.slzr.operation.domain.OPTBusDO;
import com.slzr.operation.service.GuestMessageService;
import com.slzr.operation.service.OPTBusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OPTBusServiceImpl implements OPTBusService {
	@Autowired
	private OPTBusDao oPTBusDao;

	@Override
	public List<OPTBusDO> list(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return oPTBusDao.list(map);
	}

	@Override
	public int count(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return oPTBusDao.count(map);
	}

	@Override
	public int save(OPTBusDO oPTBusDO) {
		// TODO Auto-generated method stub
		return oPTBusDao.save(oPTBusDO);
	}

	@Override
	public int remove(Integer id) {
		// TODO Auto-generated method stub
		return oPTBusDao.remove(id);
	}

	public int update(OPTBusDO oPTBusDO) {
		return oPTBusDao.update(oPTBusDO);
	}

	public OPTBusDO getByID(int id){
		return oPTBusDao.getByID(id);
	}

}
