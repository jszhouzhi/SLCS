package com.slzr.system.vo;

import java.math.BigDecimal;

public class ZSTodayVO {
	private int freeTopupNum;
	private BigDecimal freeTopupAmount;
	private int freeDebitNum;
	private BigDecimal freeDebitAmount;
	public int getFreeTopupNum() {
		return freeTopupNum;
	}
	public void setFreeTopupNum(int freeTopupNum) {
		this.freeTopupNum = freeTopupNum;
	}
	public BigDecimal getFreeTopupAmount() {
		return freeTopupAmount;
	}
	public void setFreeTopupAmount(BigDecimal freeTopupAmount) {
		this.freeTopupAmount = freeTopupAmount;
	}
	public int getFreeDebitNum() {
		return freeDebitNum;
	}
	public void setFreeDebitNum(int freeDebitNum) {
		this.freeDebitNum = freeDebitNum;
	}
	public BigDecimal getFreeDebitAmount() {
		return freeDebitAmount;
	}
	public void setFreeDebitAmount(BigDecimal freeDebitAmount) {
		this.freeDebitAmount = freeDebitAmount;
	}
}
