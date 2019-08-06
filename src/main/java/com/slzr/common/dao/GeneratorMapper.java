package com.slzr.common.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

public interface GeneratorMapper {
	@Select("select table_name tableName from information_schema.tables")
			
	List<Map<String, Object>> list();

	@Select("select count(*) from information_schema.tables ")
	int count(Map<String, Object> map);

	@Select("select table_name tableName from information_schema.tables \r\n"
			+ "	where table_name = #{tableName}")
	Map<String, String> get(String tableName);

	@Select("select column_name columnName, data_type dataType, "
			+ "column_name columnComment from information_schema.columns\r\n "
			+ "where table_name = #{tableName} order by ordinal_position")
	List<Map<String, String>> listColumns(String tableName);
}
