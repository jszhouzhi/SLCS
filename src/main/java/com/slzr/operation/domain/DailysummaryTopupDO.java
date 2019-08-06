package com.slzr.operation.domain;

import java.math.BigDecimal;

public class DailysummaryTopupDO {
	private Object iD;
	private String auditRemark;
	private String txnDate;
	private BigDecimal refundAmount;
	private Integer topupNum;
	private Integer refundNum;
	private BigDecimal serviceFee;
	private Integer auditUID;
	private Integer auditStatus;
	private java.util.Date auditDateTime;
	private java.util.Date summaryDateTime;
	private Integer payMethodId;
	private BigDecimal topupAmount;
	private String auditUserName;
	private BigDecimal enterAmount;
	private String summaryDateTimeText;

	private String auditStatusName;

	private String payMethodName;

	private Integer icTopupNum;
	private BigDecimal icTopupAmount;
	private Integer icRefundNum;
	private BigDecimal icRefundAmount;

	private String sharePay;//1平台账户  0非平台账户
	
	private BigDecimal settlementAmount;  //日结金额
	
	private BigDecimal pappayAmount;   //免密扣费的收入金额
	private Integer pappayNum;   //免密扣费的笔数
	private BigDecimal pappayFee;   //免密服务费
	
	private BigDecimal totalServicefee;
	
	
	
	public BigDecimal getTotalServicefee() {
		return totalServicefee;
	}

	public void setTotalServicefee(BigDecimal totalServicefee) {
		this.totalServicefee = totalServicefee;
	}

	public BigDecimal getPappayFee() {
		return pappayFee;
	}

	public void setPappayFee(BigDecimal pappayFee) {
		this.pappayFee = pappayFee;
	}

	public BigDecimal getPappayAmount() {
		return pappayAmount;
	}

	public void setPappayAmount(BigDecimal pappayAmount) {
		this.pappayAmount = pappayAmount;
	}

	public Integer getPappayNum() {
		return pappayNum;
	}

	public void setPappayNum(Integer pappayNum) {
		this.pappayNum = pappayNum;
	}

	public BigDecimal getSettlementAmount() {
		return settlementAmount;
	}

	public void setSettlementAmount(BigDecimal settlementAmount) {
		this.settlementAmount = settlementAmount;
	}

	public String getSharePay() {
		return sharePay;
	}

	public void setSharePay(String sharePay) {
		this.sharePay = sharePay;
	}

	public Integer getTotalTopupNum() {
		return (icTopupNum == null ? 0 : icTopupNum) + (topupNum == null ? 0 : topupNum);
	}

	public BigDecimal getTotalTopupAmount() {
		return (icTopupAmount == null ? BigDecimal.ZERO : icTopupAmount)
				.add(topupAmount == null ? BigDecimal.ZERO : topupAmount);
	}
	
	public Integer getTotalRefundNum() {
		return (refundNum == null ? 0 : refundNum) + (icRefundNum == null ? 0 : icRefundNum);
	}
	
	public BigDecimal getTotalRefundAmount() {
		return (icRefundAmount == null ? BigDecimal.ZERO : icRefundAmount)
				.add(refundAmount == null ? BigDecimal.ZERO : refundAmount);
	}

	public Integer getIcTopupNum() {
		return icTopupNum;
	}

	public void setIcTopupNum(Integer icTopupNum) {
		this.icTopupNum = icTopupNum;
	}

	public BigDecimal getIcTopupAmount() {
		return icTopupAmount;
	}

	public void setIcTopupAmount(BigDecimal icTopupAmount) {
		this.icTopupAmount = icTopupAmount;
	}

	public Integer getIcRefundNum() {
		return icRefundNum;
	}

	public void setIcRefundNum(Integer icRefundNum) {
		this.icRefundNum = icRefundNum;
	}

	public BigDecimal getIcRefundAmount() {
		return icRefundAmount;
	}

	public void setIcRefundAmount(BigDecimal icRefundAmount) {
		this.icRefundAmount = icRefundAmount;
	}

	public String getAuditStatusName() {
		return auditStatusName;
	}

	public void setAuditStatusName(String auditStatusName) {
		this.auditStatusName = auditStatusName;
	}

	public String getPayMethodName() {
		return payMethodName;
	}

	public void setPayMethodName(String payMethodName) {
		this.payMethodName = payMethodName;
	}

	public Object getiD() {
		return iD;
	}

	public void setiD(Object iD) {
		this.iD = iD;
	}

	public String getAuditRemark() {
		return auditRemark;
	}

	public void setAuditRemark(String auditRemark) {
		this.auditRemark = auditRemark;
	}

	public String getTxnDate() {
		return txnDate;
	}

	public void setTxnDate(String txnDate) {
		this.txnDate = txnDate;
	}

	public BigDecimal getRefundAmount() {
		return refundAmount;
	}

	public void setRefundAmount(BigDecimal refundAmount) {
		this.refundAmount = refundAmount;
	}

	public Integer getTopupNum() {
		return topupNum;
	}

	public void setTopupNum(Integer topupNum) {
		this.topupNum = topupNum;
	}

	public Integer getRefundNum() {
		return refundNum;
	}

	public void setRefundNum(Integer refundNum) {
		this.refundNum = refundNum;
	}

	public BigDecimal getServiceFee() {
		return serviceFee;
	}

	public void setServiceFee(BigDecimal serviceFee) {
		this.serviceFee = serviceFee;
	}

	public Integer getAuditUID() {
		return auditUID;
	}

	public void setAuditUID(Integer auditUID) {
		this.auditUID = auditUID;
	}

	public Integer getAuditStatus() {
		return auditStatus;
	}

	public void setAuditStatus(Integer auditStatus) {
		this.auditStatus = auditStatus;
	}

	public java.util.Date getAuditDateTime() {
		return auditDateTime;
	}

	public void setAuditDateTime(java.util.Date auditDateTime) {
		this.auditDateTime = auditDateTime;
	}

	public java.util.Date getSummaryDateTime() {
		return summaryDateTime;
	}

	public void setSummaryDateTime(java.util.Date summaryDateTime) {
		this.summaryDateTime = summaryDateTime;
	}

	public Integer getPayMethodId() {
		return payMethodId;
	}

	public void setPayMethodId(Integer payMethodId) {
		this.payMethodId = payMethodId;
	}

	public BigDecimal getTopupAmount() {
		return topupAmount;
	}

	public void setTopupAmount(BigDecimal topupAmount) {
		this.topupAmount = topupAmount;
	}

	public String getAuditUserName() {
		return auditUserName;
	}

	public void setAuditUserName(String auditUserName) {
		this.auditUserName = auditUserName;
	}

	public BigDecimal getEnterAmount() {
		return enterAmount;
	}

	public void setEnterAmount(BigDecimal enterAmount) {
		this.enterAmount = enterAmount;
	}

	public String getSummaryDateTimeText() {
		return summaryDateTimeText;
	}

	public void setSummaryDateTimeText(String summaryDateTimeText) {
		this.summaryDateTimeText = summaryDateTimeText;
	}
}
