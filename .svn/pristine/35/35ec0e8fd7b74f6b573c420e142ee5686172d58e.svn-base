package com.slzr.account.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.slzr.account.dao.AccountDao;
import com.slzr.account.domain.AccountDO;
import com.slzr.account.service.AccountService;




@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	private AccountDao accountDao;
	
	@Override
	public AccountDO get(Integer id){
		return accountDao.get(id);
	}
	
	@Override
	public AccountDO getbyAccountNO(String accountno){
		return accountDao.getbyAccountNO(accountno);
	}
	
	@Override
	public List<AccountDO> list(Map<String, Object> map){
		return accountDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return accountDao.count(map);
	}
	
	
	public int updateAccountState(String accountno,String operationType){
		return accountDao.updateAccountState(accountno,operationType);
	}

	public int update(AccountDO account){
		return accountDao.update(account);
	}
}
