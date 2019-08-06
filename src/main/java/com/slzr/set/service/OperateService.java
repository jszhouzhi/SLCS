package com.slzr.set.service;
import java.util.List;
import com.slzr.set.domain.OperateDo;
public interface OperateService{
	/**
	 * 获得OperateDo数据的总行数
	 * @return
	 */
    long getOperateDoRowCount();
	/**
	 * 获得OperateDo数据集合
	 * @return
	 */
    OperateDo selectOperateDo();
	/**
	 * 获得一个OperateDo对象,以参数OperateDo对象中不为空的属性作为条件进行查询
	 * @param obj
	 * @return
	 */
    OperateDo selectOperateDoByObj(OperateDo obj);
	/**
	 * 通过OperateDo的id获得OperateDo对象
	 * @param id
	 * @return
	 */
    OperateDo selectOperateDoById(Object id);
	/**
	 * 插入OperateDo到数据库,包括null值
	 * @param value
	 * @return
	 */
    int insertOperateDo(OperateDo value);
	/**
	 * 插入OperateDo中属性值不为null的数据到数据库
	 * @param value
	 * @return
	 */
    int insertNonEmptyOperateDo(OperateDo value);
	/**
	 * 批量插入OperateDo到数据库
	 * @param value
	 * @return
	 */
    int insertOperateDoByBatch(List<OperateDo> value);
	/**
	 * 通过OperateDo的id删除OperateDo
	 * @param id
	 * @return
	 */
    int deleteOperateDoById(Object id);
	/**
	 * 通过OperateDo的id更新OperateDo中的数据,包括null值
	 * @param enti
	 * @return
	 */
    int update(OperateDo operate);
	/**
	 * 通过OperateDo的id更新OperateDo中属性不为null的数据
	 * @param enti
	 * @return
	 */
    int updateNonEmptyOperateDoById(OperateDo enti);
}