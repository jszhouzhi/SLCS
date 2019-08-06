package com.slzr.set.service.impl;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import com.slzr.common.utils.Query;
import com.slzr.set.dao.ApiDao;
import com.slzr.set.domain.ApiDo;
import com.slzr.set.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ApiServiceImpl implements ApiService{
    @Autowired
    private ApiDao apiDao;


    @Override
    public int count(Map<String,Object> map) {
        return apiDao.count(map);
    }

    @Override
    public List<ApiDo> list(Map<String,Object> map) {
        return apiDao.list(map);
    }

    @Override
    public ApiDo selectApiDoByObj(ApiDo obj){
        return apiDao.selectApiDoByObj(obj);
    }
    @Override
    public ApiDo get(Integer id){
        return apiDao.selectApiDoById(id);
    }
    @Override
    public int save(ApiDo value){
        return apiDao.save(value);
    }
    @Override
    public int insertNonEmptyApiDo(ApiDo value){
        return apiDao.insertNonEmptyApiDo(value);
    }
    @Override
    public int insertApiDoByBatch(List<ApiDo> value){
        return apiDao.insertApiDoByBatch(value);
    }
    @Override
    public int remove(Integer id){
        return apiDao.remove(id);
    }
    @Override
    public int updateApiDoById(ApiDo enti){
        return apiDao.updateApiDoById(enti);
    }
    @Override
    public int updateNonEmptyApiDoById(ApiDo enti){
        return apiDao.updateNonEmptyApiDoById(enti);
    }

    @Override
    public boolean exit(Map<String, Object> params) {
        boolean exit;
        exit = apiDao.list(params).size() > 0;
        return exit;
    }


    public ApiDao getApiDao() {
        return this.apiDao;
    }

    public void setApiDao(ApiDao apiDao) {
        this.apiDao = apiDao;
    }

}