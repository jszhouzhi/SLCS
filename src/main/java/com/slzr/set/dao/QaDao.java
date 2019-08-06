package com.slzr.set.dao;

 

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.slzr.set.domain.QaDO;

 
@Mapper
public interface QaDao {

	QaDO get(Integer id);
	
	List<QaDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(QaDO qa);
	
	int update(QaDO qa);
	
	int remove(Integer ID);
	
	int batchRemove(Integer[] ids);
}
