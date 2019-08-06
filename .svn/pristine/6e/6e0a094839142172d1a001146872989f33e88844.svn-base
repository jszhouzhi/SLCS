package com.slzr.operation.service.Impl;

import com.slzr.common.utils.Query;
import com.slzr.operation.dao.FailConsunmDao;
import com.slzr.operation.domain.FailConsumDo;
import com.slzr.operation.service.FailConsunmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class FailConsunmServiceImpl implements FailConsunmService{

    @Autowired
    private FailConsunmDao failConsunmDao;
    @Override
    public List<FailConsumDo> list(Map<String,Object> map) {
        return failConsunmDao.list(map);
    }

    @Override
    public int count(Query query) {
        return failConsunmDao.count(query);
    }
}
