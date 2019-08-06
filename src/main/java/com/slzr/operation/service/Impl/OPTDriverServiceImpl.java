package com.slzr.operation.service.Impl;

import com.slzr.operation.dao.GuestMessageDao;
import com.slzr.operation.dao.OPTDriverDao;
import com.slzr.operation.domain.GuestMessageDO;
import com.slzr.operation.domain.OPTDriverDO;
import com.slzr.operation.service.GuestMessageService;
import com.slzr.operation.service.OPTDriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OPTDriverServiceImpl implements OPTDriverService {
	@Autowired
	private OPTDriverDao oPTDriverDao;

	@Override
	public List<OPTDriverDO> list(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return oPTDriverDao.list(map);
	}

	@Override
	public int count(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return oPTDriverDao.count(map);
	}

	@Override
	public int save(OPTDriverDO oPTDriverDO) {
		// TODO Auto-generated method stub
		return oPTDriverDao.save(oPTDriverDO);
	}

	@Override
	public int remove(Integer id) {
		// TODO Auto-generated method stub
		return oPTDriverDao.remove(id);
	}

	public int update(OPTDriverDO oPTDriverDO) {
		return oPTDriverDao.update(oPTDriverDO);
	}

	public OPTDriverDO getByID(int id){
		return oPTDriverDao.getByID(id);
	}

}
