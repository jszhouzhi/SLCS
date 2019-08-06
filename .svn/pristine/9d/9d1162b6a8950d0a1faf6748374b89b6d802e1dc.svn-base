package com.slzr.account.service.impl;

 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slzr.account.dao.AccountBalanceTransferDao;
import com.slzr.account.domain.AccountBalanceTransferDO;
import com.slzr.account.service.AccountBalanceTransferService;

import java.util.List;
import java.util.Map;

 



@Service
public class AccountbalancetransferServiceImpl implements AccountBalanceTransferService {
	@Autowired
	private AccountBalanceTransferDao accountbalancetransferDao;
	
	@Override
	public AccountBalanceTransferDO get(Integer id){
		return accountbalancetransferDao.get(id);
	}
	
	@Override
	public List<AccountBalanceTransferDO> list(Map<String, Object> map){
		return accountbalancetransferDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return accountbalancetransferDao.count(map);
	}
	
	@Override
	public int save(AccountBalanceTransferDO accountbalancetransfer){
		return accountbalancetransferDao.save(accountbalancetransfer);
	}
	
	@Override
	public int update(AccountBalanceTransferDO accountbalancetransfer){
		return accountbalancetransferDao.update(accountbalancetransfer);
	}
	
	@Override
	public int remove(Integer id){
		return accountbalancetransferDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return accountbalancetransferDao.batchRemove(ids);
	}
	
}
