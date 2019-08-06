package com.slzr.account.service;

import com.slzr.account.domain.AccountCancelDO;

import java.util.List;
import java.util.Map;

/**
 * 账户注销管理
 * @author lc
 * @date 2018-03-08 16:45:51
 */
public interface AccountCancelService {
	
	AccountCancelDO get(Integer id);
	
	List<AccountCancelDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	
	int update(AccountCancelDO accountCancel);
	

}
