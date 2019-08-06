package com.slzr.account.dao;

import com.slzr.account.domain.AccountBalanceTransferDO;
import com.slzr.account.domain.AccountCancelDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface AccountBalanceTransferDao {

	AccountBalanceTransferDO get(Integer id);
	
	List<AccountBalanceTransferDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(AccountBalanceTransferDO accountbalancetransfer);
	
	int update(AccountBalanceTransferDO accountbalancetransfer);
	
	int remove(Integer ID);
	
	int batchRemove(Integer[] ids);
}
