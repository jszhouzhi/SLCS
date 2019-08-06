package com.slzr.operation.service;

import com.slzr.common.utils.Query;
import com.slzr.operation.domain.FailConsumDo;

import java.util.List;
import java.util.Map;

public interface FailConsunmService {
    List<FailConsumDo> list(Map<String,Object> map);

    int count(Query query);
}
