package com.slzr.ureport.bean;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.slzr.common.controller.BaseController;
import com.slzr.common.utils.DateUtils;
import com.slzr.common.utils.TimeConverUtils;
import com.slzr.operation.domain.DailysummaryBaseDO;
import com.slzr.operation.domain.DailysummarySettleDO;
import com.slzr.operation.domain.DailysummaryTopupDO;
import com.slzr.operation.service.DailysummaryBaseService;
import com.slzr.operation.service.DailysummarySettleService;
import com.slzr.operation.service.DailysummaryTopupService;
import com.slzr.system.domain.UserDO;
import com.slzr.ureport.domain.ACountDo;

public class DailysummaryBean extends BaseController{
	
	@Autowired
	private DailysummarySettleService settleservice;
	
	@Autowired
	private DailysummaryBaseService dailysummaryBaseService;
	
	@Autowired
	private DailysummaryTopupService topupservice;
	
	
    public List<DailysummarySettleDO> loadReportDailysummarySettle(String dsName, String datasetName, Map<String, Object> parameters) {  


        		List<DailysummarySettleDO> list = settleservice.list(parameters/*stringObjectMap*/);
        		

        return list;
    }
    
    
    public List<DailysummaryBaseDO> loadReportDailysummaryBase(String dsName, String datasetName, Map<String, Object> parameters) {  


		List<DailysummaryBaseDO> list = dailysummaryBaseService.list(parameters);
		
/*		for(DailysummaryBaseDO objdo : list) {

			objdo.setEnterAmount(objdo.getTopupAmount().multiply(new BigDecimal(1-0.001)));
			//objdo.setSummaryDateTimeText(DateUtils.format(objdo.getSummaryDateTime(), DateUtils.DATE_PATTERN));
			
			if(objdo.getPayMethodId()!=null && objdo.getPayMethodId()==1){ //判断支付方式如果是支付宝 充值金额 = 充值金额-退款金额
				BigDecimal ta = objdo.getTopupAmount();
				BigDecimal ra = objdo.getRefundAmount();
				BigDecimal n = ta.subtract(ra);
				
				objdo.setTopupAmount(n);
			}
 
		}*/
		
/*		DailysummaryBaseDO item = new DailysummaryBaseDO();
		item.setTopupAmount(new BigDecimal(0));
		item.setEnterAmount(new BigDecimal(0));
		item.setRefundAmount(new BigDecimal(0));
		item.setRefundServiceFee(new BigDecimal(0));
		
		item.setTopupNum(0);
		
		item.setRefundNum(0);
		
		for(DailysummaryBaseDO objdo : list) {

			objdo.setEnterAmount(objdo.getTopupAmount().multiply(new BigDecimal(1-0.001)));
			//objdo.setSummaryDateTimeText(DateUtils.format(objdo.getSummaryDateTime(), DateUtils.DATE_PATTERN));
			item.setTopupAmount(item.getTopupAmount().add(objdo.getTopupAmount()));
			item.setEnterAmount(item.getEnterAmount().add(objdo.getEnterAmount()));
			item.setRefundAmount(item.getRefundAmount().add(objdo.getRefundAmount()));
			item.setRefundServiceFee(item.getRefundServiceFee().add(objdo.getRefundServiceFee()));
			item.setTopupNum(item.getTopupNum()+objdo.getTopupNum());			
			item.setRefundNum(item.getRefundNum()+objdo.getRefundNum());
		}
		list.add(0, item);*/

		return list;
	}
    
    
    public List<DailysummaryTopupDO> loadReportDailysummaryTopup(String dsName, String datasetName, Map<String, Object> parameters) {  


		List<DailysummaryTopupDO> list = topupservice.list(parameters);
		for(DailysummaryTopupDO objdo : list) {
			//objdo.setEnterAmount(objdo.getTotalTopupAmount().multiply(new BigDecimal(1-0.001)));
			objdo.setSummaryDateTimeText(DateUtils.format(objdo.getSummaryDateTime(), DateUtils.DATE_PATTERN));
		}

		return list;
	}

}
