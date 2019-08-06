package com.slzr.set.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 常见问答服务
 
 */
public class QaDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//自增id
	private Long id;
	//问题、标题
	private String question;
	//解答、回答
	private String answer;
	//问题所属类型
	private String questionTypeId;
	//点击次数
	private Integer viewNum;
	//排序
	private Integer sortNum;
	//是否可用0不启用 1启用
	private String isEnable;
	//CreatedBy
	private Integer createdBy;
	//CreatedDate
	private Date createdDate;
	//UpdatedBy
	private Integer updatedBy;
	//UpdatedDate
	private Date updatedDate;
	
	private String questionTypeName;
	
	private String createUserName;
	private String updateUserName;
	private String merchantCode;
	
	
	
	public String getMerchantCode() {
		return merchantCode;
	}
	public void setMerchantCode(String merchantCode) {
		this.merchantCode = merchantCode;
	}
	public String getCreateUserName() {
		return createUserName;
	}
	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}
	public String getUpdateUserName() {
		return updateUserName;
	}
	public void setUpdateUserName(String updateUserName) {
		this.updateUserName = updateUserName;
	}
	public String getQuestionTypeName() {
		return questionTypeName;
	}
	public void setQuestionTypeName(String questionTypeName) {
		this.questionTypeName = questionTypeName;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getQuestionTypeId() {
		return questionTypeId;
	}
	public void setQuestionTypeId(String questionTypeId) {
		this.questionTypeId = questionTypeId;
	}
	public Integer getViewNum() {
		return viewNum;
	}
	public void setViewNum(Integer viewNum) {
		this.viewNum = viewNum;
	}
	public Integer getSortNum() {
		return sortNum;
	}
	public void setSortNum(Integer sortNum) {
		this.sortNum = sortNum;
	}
	public String getIsEnable() {
		return isEnable;
	}
	public void setIsEnable(String isEnable) {
		this.isEnable = isEnable;
	}
	public Integer getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Integer getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	public QaDO(Long id, String question, String answer, String questionTypeId, Integer viewNum, Integer sortNum,
			String isEnable, Integer createdBy, Date createdDate, Integer updatedBy, Date updatedDate) {
		super();
		this.id = id;
		this.question = question;
		this.answer = answer;
		this.questionTypeId = questionTypeId;
		this.viewNum = viewNum;
		this.sortNum = sortNum;
		this.isEnable = isEnable;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
	}
	public QaDO() {
		super();
	}


}
