package com.slzr.operation.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slzr.operation.dao.GuestMessageDao;
import com.slzr.operation.domain.GuestMessageDO;
import com.slzr.operation.service.GuestMessageService;

import java.util.List;
import java.util.Map;

@Service
public class GuestMessageServiceImpl implements GuestMessageService {
	@Autowired
	private GuestMessageDao guestmessageDao;

	@Override
	public List<GuestMessageDO> list(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return guestmessageDao.list(map);
	}

	@Override
	public int count(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return guestmessageDao.count(map);
	}

	@Override
	public int save(GuestMessageDO guestmessage) {
		// TODO Auto-generated method stub
		return guestmessageDao.save(guestmessage);
	}

	@Override
	public int remove(Integer id) {
		// TODO Auto-generated method stub
		return guestmessageDao.remove(id);
	}

	public int update(GuestMessageDO guestMessageDO) {
		return guestmessageDao.update(guestMessageDO);
	}

	public GuestMessageDO getByID(int id){
		return guestmessageDao.getByID(id);
	}

}
