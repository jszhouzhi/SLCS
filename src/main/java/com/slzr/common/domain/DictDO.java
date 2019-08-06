package com.slzr.common.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



/** 
 * 2018.02.08
 * @author Administrator
 */
public class DictDO implements Serializable {
	private static final long serialVersionUID = 1L;
	

	//编号
	private Long id;
	//字典代码
	private String DictCode;
	//字典数据项代码
	private String DataCode;
 	//字典数据项值
	private String DataValue;
	//序号
	private int OrderNo;
	//状态
	private int State;
	
	private int CreatedBy;
	
	private Date CreatedDate;
	
	private int UpdatedBy;
	
	private Date UpdatedDate;
	
	private String Remark;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDictCode() {
		return DictCode;
	}

	public void setDictCode(String dictCode) {
		DictCode = dictCode;
	}

	public String getDataCode() {
		return DataCode;
	}

	public void setDataCode(String dataCode) {
		DataCode = dataCode;
	}

	public String getDataValue() {
		return DataValue;
	}

	public void setDataValue(String dataValue) {
		DataValue = dataValue;
	}

	public int getOrderNo() {
		return OrderNo;
	}

	public void setOrderNo(int orderNo) {
		OrderNo = orderNo;
	}

	public int getState() {
		return State;
	}

	public void setState(int state) {
		State = state;
	}

	public int getCreatedBy() {
		return CreatedBy;
	}

	public void setCreatedBy(int createdBy) {
		CreatedBy = createdBy;
	}

	public Date getCreatedDate() {
		return CreatedDate;
	}

	public void setCreatedDate(Date createdDate) {
		CreatedDate = createdDate;
	}

	public int getUpdatedBy() {
		return UpdatedBy;
	}

	public void setUpdatedBy(int updatedBy) {
		UpdatedBy = updatedBy;
	}

	public Date getUpdatedDate() {
		return UpdatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		UpdatedDate = updatedDate;
	}

	public String getRemark() {
		return Remark;
	}

	public void setRemark(String remark) {
		Remark = remark;
	}

	public DictDO(Long id, String dictCode, String dataCode, String dataValue, int orderNo, int state, int createdBy,
			Date createdDate, int updatedBy, Date updatedDate, String remark) {
		super();
		this.id = id;
		DictCode = dictCode;
		DataCode = dataCode;
		DataValue = dataValue;
		OrderNo = orderNo;
		State = state;
		CreatedBy = createdBy;
		CreatedDate = createdDate;
		UpdatedBy = updatedBy;
		UpdatedDate = updatedDate;
		Remark = remark;
	}

	public DictDO() {
		super();
	}
	
}
