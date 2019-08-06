package com.slzr.operation.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;



/**
 * 订单 圈存异常
 * @author lc
 * @date 2018-03-20 11:15:51
 */
public class TopuporderDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//ID
	private Integer id;
	//充值用户ID
	@JSONField  (ordinal = 1,name = "UID")
	private Integer uid;
	//终端编号
	private String terminalno;
	//订单号
	@JSONField  (ordinal = 2,name = "OrderNO")
	private String orderno;
	//IC卡流水号
	@JSONField  (ordinal = 3,name = "CardNO")
	private String cardno;
	//卡类型ID
	private Integer cardtypeid;
	//计数器
	private Integer counter;
	//卡余额
	private BigDecimal balance;
	//订单金额
	@JSONField  (ordinal = 4,name = "TxnAmount")
	private BigDecimal txnamount;
	//订单时间
	private Date txndatetime;
	//订单状态
	@JSONField  (ordinal = 5,name = "OrderState")
	private Integer orderstate;
	//订单状态描述
	private String orderdescribe;
	//订单更新时间
	private Date orderbackdate;
	//圈存状态
	@JSONField  (ordinal = 6,name = "LoadState")
	private Integer loadstate;
	//圈存状态描述
	private String loaddescribe;
	//圈存时间
	private Date loadbackdate;
	//支付方式ID
	private Integer paymethodid;
	//支付时间
	private Date paytime;
	//支付结果
	@JSONField  (ordinal = 7,name = "PayResult")
	private Integer payresult;
	//支付结果描述
	private String payresultmsg;
	//支付TAC
	@JSONField  (ordinal = 8,name = "TAC")
	private String tac;
	//审核者ID
	private Integer reviewid;
	//审核时间
	private Date reviewtime;
	//日结时间
	private Date summarytime;
	//记录MAC
	private String mac;
	
	private String merchantCode;
	
	private String reviewUserName;
	

	public String getReviewUserName() {
		return reviewUserName;
	}
	public void setReviewUserName(String reviewUserName) {
		this.reviewUserName = reviewUserName;
	}
	public String getMerchantCode() {
		return merchantCode;
	}
	public void setMerchantCode(String merchantCode) {
		this.merchantCode = merchantCode;
	}
	/**
	 * 设置：ID
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：ID
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：UID
	 */
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	/**
	 * 获取：UID
	 */
	public Integer getUid() {
		return uid;
	}
	/**
	 * 设置：TerminalNO
	 */
	public void setTerminalno(String terminalno) {
		this.terminalno = terminalno;
	}
	/**
	 * 获取：TerminalNO
	 */
	public String getTerminalno() {
		return terminalno;
	}
	/**
	 * 设置：OrderNO
	 */
	public void setOrderno(String orderno) {
		this.orderno = orderno;
	}
	/**
	 * 获取：OrderNO
	 */
	public String getOrderno() {
		return orderno;
	}
	/**
	 * 设置：CardNO
	 */
	public void setCardno(String cardno) {
		this.cardno = cardno;
	}
	/**
	 * 获取：CardNO
	 */
	public String getCardno() {
		return cardno;
	}
	/**
	 * 设置：CardTypeID
	 */
	public void setCardtypeid(Integer cardtypeid) {
		this.cardtypeid = cardtypeid;
	}
	/**
	 * 获取：CardTypeID
	 */
	public Integer getCardtypeid() {
		return cardtypeid;
	}
	/**
	 * 设置：Counter
	 */
	public void setCounter(Integer counter) {
		this.counter = counter;
	}
	/**
	 * 获取：Counter
	 */
	public Integer getCounter() {
		return counter;
	}
	/**
	 * 设置：Balance
	 */
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	/**
	 * 获取：Balance
	 */
	public BigDecimal getBalance() {
		return balance;
	}
	/**
	 * 设置：TxnAmount
	 */
	public void setTxnamount(BigDecimal txnamount) {
		this.txnamount = txnamount;
	}
	/**
	 * 获取：TxnAmount
	 */
	public BigDecimal getTxnamount() {
		return txnamount;
	}
	/**
	 * 设置：TxnDateTime
	 */
	public void setTxndatetime(Date txndatetime) {
		this.txndatetime = txndatetime;
	}
	/**
	 * 获取：TxnDateTime
	 */
	public Date getTxndatetime() {
		return txndatetime;
	}
	/**
	 * 设置：OrderState
	 */
	public void setOrderstate(Integer orderstate) {
		this.orderstate = orderstate;
	}
	/**
	 * 获取：OrderState
	 */
	public Integer getOrderstate() {
		return orderstate;
	}
	/**
	 * 设置：OrderDescribe
	 */
	public void setOrderdescribe(String orderdescribe) {
		this.orderdescribe = orderdescribe;
	}
	/**
	 * 获取：OrderDescribe
	 */
	public String getOrderdescribe() {
		return orderdescribe;
	}
	/**
	 * 设置：OrderBackDate
	 */
	public void setOrderbackdate(Date orderbackdate) {
		this.orderbackdate = orderbackdate;
	}
	/**
	 * 获取：OrderBackDate
	 */
	public Date getOrderbackdate() {
		return orderbackdate;
	}
	/**
	 * 设置：LoadState
	 */
	public void setLoadstate(Integer loadstate) {
		this.loadstate = loadstate;
	}
	/**
	 * 获取：LoadState
	 */
	public Integer getLoadstate() {
		return loadstate;
	}
	/**
	 * 设置：LoadDescribe
	 */
	public void setLoaddescribe(String loaddescribe) {
		this.loaddescribe = loaddescribe;
	}
	/**
	 * 获取：LoadDescribe
	 */
	public String getLoaddescribe() {
		return loaddescribe;
	}
	/**
	 * 设置：LoadBackDate
	 */
	public void setLoadbackdate(Date loadbackdate) {
		this.loadbackdate = loadbackdate;
	}
	/**
	 * 获取：LoadBackDate
	 */
	public Date getLoadbackdate() {
		return loadbackdate;
	}
	/**
	 * 设置：PayMethodId
	 */
	public void setPaymethodid(Integer paymethodid) {
		this.paymethodid = paymethodid;
	}
	/**
	 * 获取：PayMethodId
	 */
	public Integer getPaymethodid() {
		return paymethodid;
	}
	/**
	 * 设置：PayTime
	 */
	public void setPaytime(Date paytime) {
		this.paytime = paytime;
	}
	/**
	 * 获取：PayTime
	 */
	public Date getPaytime() {
		return paytime;
	}
	/**
	 * 设置：PayResult
	 */
	public void setPayresult(Integer payresult) {
		this.payresult = payresult;
	}
	/**
	 * 获取：PayResult
	 */
	public Integer getPayresult() {
		return payresult;
	}
	/**
	 * 设置：PayResultMsg
	 */
	public void setPayresultmsg(String payresultmsg) {
		this.payresultmsg = payresultmsg;
	}
	/**
	 * 获取：PayResultMsg
	 */
	public String getPayresultmsg() {
		return payresultmsg;
	}
	/**
	 * 设置：TAC
	 */
	public void setTac(String tac) {
		this.tac = tac;
	}
	/**
	 * 获取：TAC
	 */
	public String getTac() {
		return tac;
	}
	/**
	 * 设置：ReviewID
	 */
	public void setReviewid(Integer reviewid) {
		this.reviewid = reviewid;
	}
	/**
	 * 获取：ReviewID
	 */
	public Integer getReviewid() {
		return reviewid;
	}
	/**
	 * 设置：ReviewTime
	 */
	public void setReviewtime(Date reviewtime) {
		this.reviewtime = reviewtime;
	}
	/**
	 * 获取：ReviewTime
	 */
	public Date getReviewtime() {
		return reviewtime;
	}
	/**
	 * 设置：SummaryTime
	 */
	public void setSummarytime(Date summarytime) {
		this.summarytime = summarytime;
	}
	/**
	 * 获取：SummaryTime
	 */
	public Date getSummarytime() {
		return summarytime;
	}
	/**
	 * 设置：MAC
	 */
	public void setMac(String mac) {
		this.mac = mac;
	}
	/**
	 * 获取：MAC
	 */
	public String getMac() {
		return mac;
	}
}
