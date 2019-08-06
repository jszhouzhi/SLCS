package com.slzr.set.dao;


import com.slzr.common.utils.Query;
import com.slzr.set.domain.CompanyDo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface CompanyDao {
    List<CompanyDo> list(Map<String, Object> params);

    int count(Query query);

    int save(CompanyDo companyDo);

    CompanyDo get(Integer id);

    int update(CompanyDo companyDo);
}
