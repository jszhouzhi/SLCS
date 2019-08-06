package com.slzr.set.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slzr.set.dao.ICSysSettingDao;
import com.slzr.set.domain.ICSysSettingDo;
import com.slzr.set.service.ICSysSettingService;

@Service
public class ICSysSettingServiceImpl implements ICSysSettingService {
	
	
	@Autowired
	private ICSysSettingDao icSysSettingDao;

	@Override
	public List<ICSysSettingDo> list(Map<String, Object> map) {
		return icSysSettingDao.list(map);
	}

	@Override
	public int count(Map<String, Object> map) {
		return icSysSettingDao.count(map);
	}

	@Override
	public int save(ICSysSettingDo icSysSettingDo) {
		return icSysSettingDao.save(icSysSettingDo);
	}

	@Override
	public ICSysSettingDo get(Long id) {
		return icSysSettingDao.get(id);
	}

	@Override
	public int update(ICSysSettingDo icSysSettingDo) {
		return icSysSettingDao.update(icSysSettingDo);
	}

	@Override
	public int remove(Long id) {
		return icSysSettingDao.remove(id);
	}
	
}
