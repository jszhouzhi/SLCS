package com.slzr.ureport.bean;

import com.slzr.common.controller.BaseController;
import com.slzr.common.utils.DateUtils;
import com.slzr.common.utils.TimeConverUtils;
import com.slzr.system.domain.UserDO;
import com.slzr.system.service.UserService;
import com.slzr.ureport.domain.BCountDo;
import com.slzr.ureport.service.BCountService;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class BLineBusBean extends BaseController{

    @Autowired
    private BCountService bCountService;

    @Autowired
    private UserService userService;

    public List<BCountDo> getLineBuslist(String dsName, String datasetName, Map<String, Object> parameters) {
        String startDate = (String) parameters.get("startDate");
        String endDate = (String) parameters.get("endDate");
        Map<String, Object> stringObjectMap=null;
        if (parameters != null) {
            stringObjectMap = TimeConverUtils.converDate(parameters);
        }


        UserDO userDO = userService.get(getId());
        List<BCountDo> list = null;
        if (userDO.getMerchantCode() == "" || userDO.getMerchantCode() == null) {
            list = bCountService.LineBuslist(stringObjectMap);
            for (int i=0;i<list.size();i++){

                //判断日期类型为什么
                if(stringObjectMap.get("datetype").toString().equals("Week")){
                    list.get(i).setTxnDate(list.get(i).getYear()+"-W"+list.get(i).getTxnDate());
                }
                if(stringObjectMap.get("datetype").toString().equals("Month")){
                    list.get(i).setTxnDate(list.get(i).getYear()+"-"+list.get(i).getTxnDate());
                }
                if(stringObjectMap.get("datetype").toString().equals("Quarter")){
                    list.get(i).setTxnDate(list.get(i).getYear()+"-Q"+list.get(i).getTxnDate());
                }
                list.get(i).setLineName("  "+(list.get(i).getLineName()==null?"" :list.get(i).getLineName()));
                list.get(i).setUserName(getUserName());
                //list.get(i).setStartDate(DateUtils.format(DateUtils.ConvertToDate(stringObjectMap.get("startDate").toString()), DateUtils.DATE_PATTERN));
               // list.get(i).setEndDate(DateUtils.format(DateUtils.ConvertToDate(stringObjectMap.get("endDate").toString()), DateUtils.DATE_PATTERN));
                list.get(i).setStartDate(startDate);
                list.get(i).setEndDate(endDate);
                
                list.get(i).setDebitFreeAmount(list.get(i).getDebitFreeAmount() == null ? new BigDecimal(0.00) :  list.get(i).getDebitFreeAmount());
                list.get(i).setDebitFreeNum(list.get(i).getDebitFreeNum() == null ? 0 :  list.get(i).getDebitFreeNum());

            }
        } else {
            parameters.put("merchantCode", userDO.getMerchantCode());
            list = bCountService.LineBuslist(stringObjectMap);
            for (int i=0;i<list.size();i++){

                //判断日期类型为什么
                if(stringObjectMap.get("datetype").toString().equals("Week")){
                    list.get(i).setTxnDate(list.get(i).getYear()+"-W"+list.get(i).getTxnDate());
                }
                if(stringObjectMap.get("datetype").toString().equals("Month")){
                    list.get(i).setTxnDate(list.get(i).getYear()+"-"+list.get(i).getTxnDate());
                }
                if(stringObjectMap.get("datetype").toString().equals("Quarter")){
                    list.get(i).setTxnDate(list.get(i).getYear()+"-Q"+list.get(i).getTxnDate());
                }
                list.get(i).setLineName("  "+(list.get(i).getLineName()==null?"" :list.get(i).getLineName()));
                list.get(i).setUserName(getUserName());

                //list.get(i).setStartDate(DateUtils.format(DateUtils.ConvertToDate(stringObjectMap.get("startDate").toString()), DateUtils.DATE_PATTERN));
                //list.get(i).setEndDate(DateUtils.format(DateUtils.ConvertToDate(stringObjectMap.get("endDate").toString()), DateUtils.DATE_PATTERN));
                list.get(i).setStartDate(startDate);
                list.get(i).setEndDate(endDate);
                
                list.get(i).setDebitFreeAmount(list.get(i).getDebitFreeAmount() == null ? new BigDecimal(0.00) :  list.get(i).getDebitFreeAmount());
                list.get(i).setDebitFreeNum(list.get(i).getDebitFreeNum() == null ? 0 :  list.get(i).getDebitFreeNum());
            }
        }
        return list;
    }
}
