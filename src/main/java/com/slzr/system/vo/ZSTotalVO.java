package com.slzr.system.vo;

import java.math.BigDecimal;

public class ZSTotalVO {
	private int topupFreeNum;
	private BigDecimal topupFreeAmount;
	private int debitFreeNum;
	private BigDecimal debitFreeAmount;
	public int getTopupFreeNum() {
		return topupFreeNum;
	}
	public void setTopupFreeNum(int topupFreeNum) {
		this.topupFreeNum = topupFreeNum;
	}
	public BigDecimal getTopupFreeAmount() {
		return topupFreeAmount;
	}
	public void setTopupFreeAmount(BigDecimal topupFreeAmount) {
		this.topupFreeAmount = topupFreeAmount;
	}
	public int getDebitFreeNum() {
		return debitFreeNum;
	}
	public void setDebitFreeNum(int debitFreeNum) {
		this.debitFreeNum = debitFreeNum;
	}
	public BigDecimal getDebitFreeAmount() {
		return debitFreeAmount;
	}
	public void setDebitFreeAmount(BigDecimal debitFreeAmount) {
		this.debitFreeAmount = debitFreeAmount;
	}
}
