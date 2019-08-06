package com.slzr.account.service;

import com.slzr.account.domain.AccountDO;

import java.util.List;
import java.util.Map;

/**
 * 账户管理
 * @author lc
 * @date 2018-03-18 16:55:51
 */
public interface AccountService {
	
	AccountDO get(Integer id);
	AccountDO getbyAccountNO(String accountno); 
	
	List<AccountDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int updateAccountState(Integer id,Integer operationType);

	int update(AccountDO account);
	
	int updateState (AccountDO account);
	
	int cancelConfirm (String accountno); 
}
