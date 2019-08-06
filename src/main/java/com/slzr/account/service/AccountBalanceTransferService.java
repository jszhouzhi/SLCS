package com.slzr.account.service;



import java.util.List;
import java.util.Map;

import com.slzr.account.domain.AccountBalanceTransferDO;


public interface AccountBalanceTransferService {
	
	AccountBalanceTransferDO get(Integer id);
	
	List<AccountBalanceTransferDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(AccountBalanceTransferDO accountbalancetransfer);
	
	int update(AccountBalanceTransferDO accountbalancetransfer);
	
	int remove(Integer id);
	
	int batchRemove(Integer[] ids);
}
