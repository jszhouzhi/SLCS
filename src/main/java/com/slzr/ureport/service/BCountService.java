package com.slzr.ureport.service;

import com.slzr.ureport.domain.BCountDo;

import java.util.List;
import java.util.Map;

public interface BCountService {

    List<BCountDo> BusDriverlist(Map<String, Object> parameters);
    List<BCountDo> DeptLinelist(Map<String, Object> parameters);
    List<BCountDo> LineBuslist(Map<String, Object> parameters);
}
