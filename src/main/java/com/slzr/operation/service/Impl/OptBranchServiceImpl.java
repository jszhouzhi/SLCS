package com.slzr.operation.service.Impl;
import java.util.List;
import java.util.Map;

import com.slzr.operation.dao.OptBranchDao;
import com.slzr.operation.domain.OptBranchDO;
import com.slzr.operation.service.OptBranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Reference;
import org.springframework.stereotype.Service;
 
@Service
public class OptBranchServiceImpl implements OptBranchService{
  
	@Autowired
	private OptBranchDao branchDao;
	
	@Override
	public OptBranchDO get(Integer id){
		return branchDao.get(id);
	}
	
	@Override
	public List<OptBranchDO> list(Map<String, Object> map){
		return branchDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return branchDao.count(map);
	}
	
	@Override
	public int save(OptBranchDO branch){
		return branchDao.save(branch);
	}
	
	@Override
	public int update(OptBranchDO branch){
		return branchDao.update(branch);
	}
	
	@Override
	public int remove(Integer id){
		return branchDao.remove(id);
	}
	
	@Override
	public int batchRemove(Integer[] ids){
		return branchDao.batchRemove(ids);
	}

}