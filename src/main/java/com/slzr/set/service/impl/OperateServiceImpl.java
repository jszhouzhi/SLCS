package com.slzr.set.service.impl;
import java.util.List;
import com.slzr.set.dao.OperateDao;
import com.slzr.set.domain.OperateDo;
import com.slzr.set.service.OperateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class OperateServiceImpl implements OperateService{
    @Autowired
    private OperateDao operateDao;
    @Override
    public long getOperateDoRowCount(){
        return operateDao.getOperateDoRowCount();
    }
    @Override
    public OperateDo selectOperateDo(){
        return operateDao.selectOperateDo();
    }
    @Override
    public OperateDo selectOperateDoByObj(OperateDo obj){
        return operateDao.selectOperateDoByObj(obj);
    }
    @Override
    public OperateDo selectOperateDoById(Object id){
        return operateDao.selectOperateDoById(id);
    }
    @Override
    public int insertOperateDo(OperateDo value){
        return operateDao.insertOperateDo(value);
    }
    @Override
    public int insertNonEmptyOperateDo(OperateDo value){
        return operateDao.insertNonEmptyOperateDo(value);
    }
    @Override
    public int insertOperateDoByBatch(List<OperateDo> value){
        return operateDao.insertOperateDoByBatch(value);
    }
    @Override
    public int deleteOperateDoById(Object id){
        return operateDao.deleteOperateDoById(id);
    }
    @Override
    public int update(OperateDo enti){
        return operateDao.updateOperateDoById(enti);
    }
    @Override
    public int updateNonEmptyOperateDoById(OperateDo enti){
        return operateDao.updateNonEmptyOperateDoById(enti);
    }

    public OperateDao getOperateDao() {
        return this.operateDao;
    }

    public void setOperateDao(OperateDao operateDao) {
        this.operateDao = operateDao;
    }

}