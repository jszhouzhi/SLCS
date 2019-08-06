package com.slzr.set.service.impl;

import com.slzr.common.utils.Query;
import com.slzr.set.dao.CompanyDao;
import com.slzr.set.domain.CompanyDo;
import com.slzr.set.domain.MerchDo;
import com.slzr.set.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class CompanyServiceImpl implements CompanyService{
    @Autowired
    private CompanyDao companyDao;

    @Override
    public List<CompanyDo> list(Map<String, Object> params) {
        return companyDao.list(params);
    }

    @Override
    public int count(Query query) {
        return companyDao.count(query);
    }

    @Override
    public boolean exit(Map<String, Object> params) {
        boolean exit;
        exit = companyDao.list(params).size() > 0;
        return exit;
    }

    @Override
    public int save(CompanyDo companyDo) {
        return companyDao.save(companyDo);
    }

    @Override
    public CompanyDo get(Integer id) {
        return companyDao.get(id);
    }

    @Override
    public int update(CompanyDo company) {
        return companyDao.update(company);
    }
}
