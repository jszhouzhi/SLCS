package com.slzr.common.dao;

import com.slzr.common.domain.LogDO;
import com.slzr.common.utils.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogDao {
    int createLog(LogDO log);

    int updateLog(LogDO log);

    List<LogDO> list(Query query);

    int count(Query query);
}
