package com.slzr.set.service;
import java.util.List;
import java.util.Map;
import com.slzr.common.utils.Query;
import com.slzr.set.domain.ApiDo;
import com.slzr.set.domain.MerchDo;

public interface ApiService{
	/**
	 * 获得ApiDo数据的总行数
	 * @return
	 */
	int count(Map<String,Object> map);
	/**
	 * 获得ApiDo数据集合
	 * @return
	 */
	List<ApiDo> list(Map<String,Object> map);
	/**
	 * 获得一个ApiDo对象,以参数ApiDo对象中不为空的属性作为条件进行查询
	 * @param obj
	 * @return
	 */
    ApiDo selectApiDoByObj(ApiDo obj);
	/**
	 * 通过ApiDo的id获得ApiDo对象
	 * @param id
	 * @return
	 */
    ApiDo get(Integer id);
	/**
	 * 插入ApiDo到数据库,包括null值
	 * @param value
	 * @return
	 */
    int save(ApiDo value);
	/**
	 * 插入ApiDo中属性值不为null的数据到数据库
	 * @param value
	 * @return
	 */
    int insertNonEmptyApiDo(ApiDo value);
	/**
	 * 批量插入ApiDo到数据库
	 * @param value
	 * @return
	 */
    int insertApiDoByBatch(List<ApiDo> value);
	/**
	 * 通过ApiDo的id删除ApiDo
	 * @param id
	 * @return
	 */
    int remove(Integer id);
	/**
	 * 通过ApiDo的id更新ApiDo中的数据,包括null值
	 * @param enti
	 * @return
	 */
    int updateApiDoById(ApiDo enti);
	/**
	 * 通过ApiDo的id更新ApiDo中属性不为null的数据
	 * @param enti
	 * @return
	 */
    int updateNonEmptyApiDoById(ApiDo enti);


    boolean exit(Map<String, Object> params);

}