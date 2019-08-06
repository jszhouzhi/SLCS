package com.slzr.operation.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.slzr.operation.domain.ArticleDO;

@Mapper
public interface ArticleDao {

	List<ArticleDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	ArticleDO get(int id);

	int remove(Integer ID);

	void add(@Param("arttype") String arttype,@Param("arttitle") String arttitle,@Param("artsummary") String artsummary,@Param("content") String content,@Param("imgpath") String imgpath,@Param("userid") int userid,@Param("merchantCode") String merchantCode);
	
	void edit(@Param("id") int id,@Param("arttype") String arttype,@Param("arttitle") String arttitle,@Param("artsummary") String artsummary,@Param("content") String content,@Param("imgpath") String imgpath,@Param("userid") int userid,@Param("merchantCode") String merchantCode);
}
