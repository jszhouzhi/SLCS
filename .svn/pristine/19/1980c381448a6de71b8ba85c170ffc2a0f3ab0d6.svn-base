package com.slzr.operation.service;

import com.slzr.operation.domain.SendCaseDo;
import io.swagger.models.auth.In;

import java.util.List;
import java.util.Map;

public interface SendCaseService {


    List<SendCaseDo> list(Map<String, Object> map);

    List<SendCaseDo> lists(Map<String, Object> map);

    int count(Map<String, Object> map);

    int save(Map<String, Object> params);
    int update(Map<String, Object> params);

    /**
     * 移除
     */
    int remove(Integer id);

    /**
     * 修改启用状态
     * @param sendCaseDo
     * @return
     */
    int updateEnable(Integer id);

    /**
     * 修改禁用状态
     */
    int updateUnEnable(Integer id);

}
