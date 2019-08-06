package com.slzr.set.service.impl;

import com.slzr.set.dao.MerchDao;
import com.slzr.set.domain.MerchDo;
import com.slzr.set.service.MerchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MerchServiceImpl  implements MerchService{

    @Autowired
    private MerchDao MerchMapper;

    @Override
    public List<MerchDo> list(Map<String, Object> map) {
        return MerchMapper.list(map);
    }

    @Override
    public int count(Map<String,Object> map) {
        return MerchMapper.count(map);
    }

    @Override
    public int remove(Long id) {
        return MerchMapper.remove(id);
    }

    @Override
    public boolean exit(Map<String, Object> params) {
        boolean exit;
        exit = MerchMapper.list(params).size() > 0;
        return exit;
    }

    @Override
    public int save(MerchDo merchant) {
        return MerchMapper.save(merchant);
    }

    @Override
    public MerchDo get(Integer id) {
        return MerchMapper.get(id);
    }

    @Override
    public int update(MerchDo merchant) {
        return MerchMapper.update(merchant);
    }
    
    @Override
    public MerchDo getServiceFee(String merchantcode) {
        return MerchMapper.getServiceFee(merchantcode);
    }
}
