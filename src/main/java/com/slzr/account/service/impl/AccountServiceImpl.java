package com.slzr.account.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

import com.slzr.account.dao.AccountDao;
import com.slzr.account.domain.AccountDO;
import com.slzr.account.service.AccountService;



@Transactional
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
	
	@Override
	public int updateAccountState(Integer id,Integer operationType){
		return accountDao.updateAccountState(id,operationType);
	}

	@Override
	public int update(AccountDO account){
		return accountDao.update(account);
	}
	
	@Override
	public int updateState(AccountDO account){
		return accountDao.updateState(account);
	}
	
	@Transactional
	@Override
	public int cancelConfirm(String accountno){
		int result1 = accountDao.updateAccountNo(accountno);
		int result2 = accountDao.updateMemberAccountAccountNo(accountno);
		int result3 = accountDao.updateAccountCancelAccountNo(accountno);
		if(result1>0&&result2>0&&result3>0){
			return 1;
		}else{
			return 0;
		}
		
		
	}
	 
}
