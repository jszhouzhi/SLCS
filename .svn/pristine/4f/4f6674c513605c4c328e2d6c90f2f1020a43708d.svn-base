package com.slzr.ureport.service.impl;


import com.slzr.ureport.dao.BcountDao;
import com.slzr.ureport.domain.BCountDo;
import com.slzr.ureport.service.BCountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BCountServiceImpl implements BCountService{
    @Autowired
    private BcountDao bcountDao;

    @Override
    public List<BCountDo> BusDriverlist(Map<String, Object> parameters) {
        return bcountDao.BusDriverlist(parameters);
    }

    @Override
    public List<BCountDo> DeptLinelist(Map<String, Object> parameters) {
        return bcountDao.DeptLinelist(parameters);
    }

    @Override
    public List<BCountDo> LineBuslist(Map<String, Object> parameters) {
        return bcountDao.LineBuslist(parameters);
    }
}
