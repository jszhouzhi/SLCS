package com.slzr.operation.dao;

import com.slzr.common.utils.Query;
import com.slzr.operation.domain.FailConsumDo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Repository
public interface FailConsunmDao {
    List<FailConsumDo> list(Map<String,Object> map);

    int count(Query query);
}
