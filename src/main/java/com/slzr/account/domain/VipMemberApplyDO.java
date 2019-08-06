package com.slzr.account.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;


 
public class VipMemberApplyDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//ID
	private Integer id;
	//用户ID
	private Integer uid;
	//订单编号
	private String orderNo;
	//二维码账号
	private String accountNo;
	//vip会员类型id
	private Integer vipMemberId;
	//购买天数
	private Integer buyDays;
	//价格
	private BigDecimal price;
	//优惠价格
	private BigDecimal discountPrice;
	//申请时间
	private Date applyDateTime;
	//PayMethodId 支付方式
	private Integer payMethodId;
	//支付时间
	private Date payDateTime;
	//支付结果（1：成功，0：未支付，其他失败）
	private Integer payResult;
	//支付结果信息（具体的支付结果描述）
	private String payMessage;
	
	
	private String nickName;
	private String vipMemberName;
	
	private String merchantCode;
	
	
	
	public String getMerchantCode() {
		return merchantCode;
	}
	public void setMerchantCode(String merchantCode) {
		this.merchantCode = merchantCode;
	}
	//@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone="GMT+8")
	private Date oldExpireDateTime;
	
	//@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone="GMT+8")
	private Date newExpireDateTime;
	
	
	
	public Date getOldExpireDateTime() {
		return oldExpireDateTime;
	}
	public void setOldExpireDateTime(Date oldExpireDateTime) {
		this.oldExpireDateTime = oldExpireDateTime;
	}
	public Date getNewExpireDateTime() {
		return newExpireDateTime;
	}
	public void setNewExpireDateTime(Date newExpireDateTime) {
		this.newExpireDateTime = newExpireDateTime;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getVipMemberName() {
		return vipMemberName;
	}
	public void setVipMemberName(String vipMemberName) {
		this.vipMemberName = vipMemberName;
	}
	public VipMemberApplyDO(Integer id, Integer uid, String orderNo, String accountNo, Integer vipMemberId,
			Integer buyDays, BigDecimal price, BigDecimal discountPrice, Date applyDateTime, Integer payMethodId,
			Date payDateTime, Integer payResult, String payMessage) {
		super();
		this.id = id;
		this.uid = uid;
		this.orderNo = orderNo;
		this.accountNo = accountNo;
		this.vipMemberId = vipMemberId;
		this.buyDays = buyDays;
		this.price = price;
		this.discountPrice = discountPrice;
		this.applyDateTime = applyDateTime;
		this.payMethodId = payMethodId;
		this.payDateTime = payDateTime;
		this.payResult = payResult;
		this.payMessage = payMessage;
	}
	public VipMemberApplyDO() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public Integer getVipMemberId() {
		return vipMemberId;
	}
	public void setVipMemberId(Integer vipMemberId) {
		this.vipMemberId = vipMemberId;
	}
	public Integer getBuyDays() {
		return buyDays;
	}
	public void setBuyDays(Integer buyDays) {
		this.buyDays = buyDays;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public BigDecimal getDiscountPrice() {
		return discountPrice;
	}
	public void setDiscountPrice(BigDecimal discountPrice) {
		this.discountPrice = discountPrice;
	}
	public Date getApplyDateTime() {
		return applyDateTime;
	}
	public void setApplyDateTime(Date applyDateTime) {
		this.applyDateTime = applyDateTime;
	}
	public Integer getPayMethodId() {
		return payMethodId;
	}
	public void setPayMethodId(Integer payMethodId) {
		this.payMethodId = payMethodId;
	}
	public Date getPayDateTime() {
		return payDateTime;
	}
	public void setPayDateTime(Date payDateTime) {
		this.payDateTime = payDateTime;
	}
	public Integer getPayResult() {
		return payResult;
	}
	public void setPayResult(Integer payResult) {
		this.payResult = payResult;
	}
	public String getPayMessage() {
		return payMessage;
	}
	public void setPayMessage(String payMessage) {
		this.payMessage = payMessage;
	}


}
