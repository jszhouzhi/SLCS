package com.slzr.set.domain;

import java.math.BigDecimal;

public class SysSetting {
    // <summary>
    // 微信公众号app Id
    // </summary>
    public String AppId ;

    /// <summary>
    /// 微信公众号密钥
    /// </summary>
    public String SecretKey ;

    /// <summary>
    /// 微信公众号平台Token
    /// </summary>
    public String WxToken ;

    /// <summary>
    /// 微信公众号平台AES密钥
    /// </summary>
    public String WxAESKey ;

    /// <summary>
    /// 微信公众号平台商户Id
    /// </summary>
    public String MchId ;

    /// <summary>
    /// 微信公众号平台商户密钥
    /// </summary>
    public String MchKey ;

    /// <summary>
    /// 微信公众号平台证书路径
    /// </summary>
    public String CertPath ;
    
    
    /// <summary>
    /// 小程序Token
    /// </summary>
    public String WeAppToken;
    /// <summary>
    /// 小程序AESKey
    /// </summary>
    public String WeAppEncodingAESKey;
    /// <summary>
    /// 小程序AppId
    /// </summary>
    public String WeAppAppId;
    /// <summary>
    /// 小程序密钥
    /// </summary>
    public String WeAppAppSecret;


    /// <summary>
    /// 每日统计消息ID
    /// </summary>
    public String DailyReportTemplateMsgId;

    /// <summary>
    /// 微信公众号模板消息Id
    /// </summary>
    public String TemplateMsgId ;

    /// <summary>
    /// 充值模板消息Id
    /// </summary>
    public String TopupTemplateMsgId ;
    /// <summary>
    /// 消费模板消息Id
    /// </summary>
    public String DebitTemplateMsgId ;
    /// <summary>
    /// 注册模板消息Id
    /// </summary>
    public String ApplyTemplateMsgId ;


    /// <summary>
    /// 注销审核消息Id
    /// </summary>
    public String CancelAuditTemplateMsgId ;


    /// <summary>
    /// 注销退款消息Id
    /// </summary>
    public String CancelRefundTemplateMsgId ;

    /// <summary>
    /// 关注公众号推送的欢迎信息
    /// </summary>
    public String WelComeInfo ;


    /// <summary>
    /// 微信开放平台app Id
    /// </summary>
    public String OpenAppId ;
    /// <summary>
    /// 微信开放平台密钥
    /// </summary>
    public String OpenSecretKey ;
    /// <summary>
    /// 微信开放平台商户Id
    /// </summary>
    public String OpenMchId ;
    /// <summary>
    /// 微信开放平台商户密钥
    /// </summary>
    public String OpenMchKey ;
    /// <summary>
    /// 微信开放平台证书路径
    /// </summary>
    public String OpenCertPath ;



    /// <summary>
    /// 支付宝支付app Id
    /// </summary>
    public String AliPayAppId ;
    /// <summary>
    /// 支付宝支付应用私钥
    /// </summary>
    public String AliPayAppPrivateKey ;
    /// <summary>
    ///支付宝支付公钥
    /// </summary>
    public String AliPayPublicKey ;

    /// <summary>
    /// 支付宝支付证书路径
    /// </summary>
    public String AliPayCertPath ;



    /// <summary>
    /// 短信平台访问Key
    /// </summary>
    public String SMSAccessKeyId ;
    /// <summary>
    /// 短信平台访问KeySecret
    /// </summary>
    public String SMSAccessKeySecret ;

    /// <summary>
    /// 短信平台签名
    /// </summary>
    public String SMSSignName ;
    /// <summary>
    /// 短信平台模板代码
    /// </summary>
    public String SMSTemplateCode ;


    /// <summary>
    /// 极光推送AppId
    /// </summary>
    public String JPushAppId ;

    /// <summary>
    /// 极光推送密钥
    /// </summary>
    public String JpushSecretKey ;

    /// <summary>
    /// 联系人
    /// </summary>
    public String Contacter ;

    /// <summary>
    /// 联系电话
    /// </summary>
    public String ContactPhone ;

    /// <summary>
    /// 城市代码
    /// </summary>
    public String CityCode ;

    /// <summary>
    /// 行业代码
    /// </summary>
    public String TradeCode ;

    /// <summary>
    /// 机构代码
    /// </summary>
    public String CompanyCode ;

    /// <summary>
    /// 机构名称
    /// </summary>
    public String CompanyName ;

    /// <summary>
    /// 是否实名注册
    /// </summary>
    public boolean RegMode ;

    /// <summary>
    /// 最小充值金额
    /// </summary>
    public BigDecimal MinTopupAmount ;

    /// <summary>
    /// 最低账户余额
    /// </summary>
    public BigDecimal MinBalance ;

    /// <summary>
    /// 最大消费金额
    /// </summary>
    public BigDecimal MaxDebitAmount ;

    /// <summary>
    /// 密钥生成周期
    /// </summary>
    public Integer KeyMakePeriod ;

    /// <summary>
    /// 数据保存路径
    /// </summary>
    public String DataSavePath ;

    /// <summary>
    /// 文件上传路径
    /// </summary>
    public String FileUploadPath ;


    /// <summary>
    /// 消息服务器连接
    /// </summary>
    public String MQConnStr ;

    /// <summary>
    /// 接口APPId
    /// </summary>
    public String ApiAppId ;

    /// <summary>
    /// 接口app密钥
    /// </summary>
    public String ApiAppKey ;

    /// <summary>
    /// 应用类型
    /// </summary>
    public String AppType ;

    /// <summary>
    /// 启用IC卡扫码充值
    /// </summary>
    public Boolean EnableICPrePay ;
    
    /// <summary>
    /// 是否启用免密代扣 （true 启用， false 不启用）
    /// </summary>
    public Boolean EnablePapPay;
    
    /// <summary>
    /// 是否启用后台票价设置 （true 启用， false 不启用）
    /// </summary>
    public Boolean EnablePriceSetting;
    
    /// <summary>
    /// 代扣模板ID
    /// </summary>
    public String WxPlanId ;
    
    /// <summary>
    /// 票价折扣 默认100
    /// </summary>
    public String TicketPriceDiscount;
    
    /// <summary>
    /// 子商户ID
    /// </summary>
    public String SubMchId;
    /// <summary>
    /// 子APP ID
    /// </summary>
    public String SubAppId;

    

	public String getSubMchId() {
		return SubMchId;
	}

	public void setSubMchId(String subMchId) {
		SubMchId = subMchId;
	}

	public String getSubAppId() {
		return SubAppId;
	}

	public void setSubAppId(String subAppId) {
		SubAppId = subAppId;
	}

	public String getTicketPriceDiscount() {
		return TicketPriceDiscount;
	}

	public void setTicketPriceDiscount(String ticketPriceDiscount) {
		TicketPriceDiscount = ticketPriceDiscount;
	}

	public Boolean getEnablePriceSetting() {
		return EnablePriceSetting;
	}

	public void setEnablePriceSetting(Boolean enablePriceSetting) {
		EnablePriceSetting = enablePriceSetting;
	}

	public Boolean getEnablePapPay() {
		return EnablePapPay;
	}

	public void setEnablePapPay(Boolean enablePapPay) {
		EnablePapPay = enablePapPay;
	}

	public String getWxPlanId() {
		return WxPlanId;
	}

	public void setWxPlanId(String wxPlanId) {
		WxPlanId = wxPlanId;
	}

	public String getDailyReportTemplateMsgId() {
        return DailyReportTemplateMsgId;
    }

    public void setDailyReportTemplateMsgId(String dailyReportTemplateMsgId) {
        DailyReportTemplateMsgId = dailyReportTemplateMsgId;
    }

    public String getAppId() {
        return AppId;
    }

    public void setAppId(String appId) {
        AppId = appId;
    }

    public String getSecretKey() {
        return SecretKey;
    }

    public void setSecretKey(String secretKey) {
        SecretKey = secretKey;
    }

    public String getWxToken() {
        return WxToken;
    }

    public void setWxToken(String wxToken) {
        WxToken = wxToken;
    }

    public String getWxAESKey() {
        return WxAESKey;
    }

    public void setWxAESKey(String wxAESKey) {
        WxAESKey = wxAESKey;
    }

    public String getMchId() {
        return MchId;
    }

    public void setMchId(String mchId) {
        MchId = mchId;
    }

    public String getMchKey() {
        return MchKey;
    }

    public void setMchKey(String mchKey) {
        MchKey = mchKey;
    }

    public String getCertPath() {
        return CertPath;
    }

    public void setCertPath(String certPath) {
        CertPath = certPath;
    }

    public String getTemplateMsgId() {
        return TemplateMsgId;
    }

    public void setTemplateMsgId(String templateMsgId) {
        TemplateMsgId = templateMsgId;
    }

    public String getTopupTemplateMsgId() {
        return TopupTemplateMsgId;
    }

    public void setTopupTemplateMsgId(String topupTemplateMsgId) {
        TopupTemplateMsgId = topupTemplateMsgId;
    }

    public String getDebitTemplateMsgId() {
        return DebitTemplateMsgId;
    }

    public void setDebitTemplateMsgId(String debitTemplateMsgId) {
        DebitTemplateMsgId = debitTemplateMsgId;
    }

    public String getApplyTemplateMsgId() {
        return ApplyTemplateMsgId;
    }

    public void setApplyTemplateMsgId(String applyTemplateMsgId) {
        ApplyTemplateMsgId = applyTemplateMsgId;
    }

    public String getCancelAuditTemplateMsgId() {
        return CancelAuditTemplateMsgId;
    }

    public void setCancelAuditTemplateMsgId(String cancelAuditTemplateMsgId) {
        CancelAuditTemplateMsgId = cancelAuditTemplateMsgId;
    }

    public String getCancelRefundTemplateMsgId() {
        return CancelRefundTemplateMsgId;
    }

    public void setCancelRefundTemplateMsgId(String cancelRefundTemplateMsgId) {
        CancelRefundTemplateMsgId = cancelRefundTemplateMsgId;
    }

    public String getWelComeInfo() {
        return WelComeInfo;
    }

    public void setWelComeInfo(String welComeInfo) {
        WelComeInfo = welComeInfo;
    }

    public String getOpenAppId() {
        return OpenAppId;
    }

    public void setOpenAppId(String openAppId) {
        OpenAppId = openAppId;
    }

    public String getOpenSecretKey() {
        return OpenSecretKey;
    }

    public void setOpenSecretKey(String openSecretKey) {
        OpenSecretKey = openSecretKey;
    }

    public String getOpenMchId() {
        return OpenMchId;
    }

    public void setOpenMchId(String openMchId) {
        OpenMchId = openMchId;
    }

    public String getOpenMchKey() {
        return OpenMchKey;
    }

    public void setOpenMchKey(String openMchKey) {
        OpenMchKey = openMchKey;
    }

    public String getOpenCertPath() {
        return OpenCertPath;
    }

    public void setOpenCertPath(String openCertPath) {
        OpenCertPath = openCertPath;
    }

    public String getAliPayAppId() {
        return AliPayAppId;
    }

    public void setAliPayAppId(String aliPayAppId) {
        AliPayAppId = aliPayAppId;
    }

    public String getAliPayAppPrivateKey() {
        return AliPayAppPrivateKey;
    }

    public void setAliPayAppPrivateKey(String aliPayAppPrivateKey) {
        AliPayAppPrivateKey = aliPayAppPrivateKey;
    }

    public String getAliPayPublicKey() {
        return AliPayPublicKey;
    }

    public void setAliPayPublicKey(String aliPayPublicKey) {
        AliPayPublicKey = aliPayPublicKey;
    }

    public String getAliPayCertPath() {
        return AliPayCertPath;
    }

    public void setAliPayCertPath(String aliPayCertPath) {
        AliPayCertPath = aliPayCertPath;
    }

    public String getSMSAccessKeyId() {
        return SMSAccessKeyId;
    }

    public void setSMSAccessKeyId(String SMSAccessKeyId) {
        this.SMSAccessKeyId = SMSAccessKeyId;
    }

    public String getSMSAccessKeySecret() {
        return SMSAccessKeySecret;
    }

    public void setSMSAccessKeySecret(String SMSAccessKeySecret) {
        this.SMSAccessKeySecret = SMSAccessKeySecret;
    }

    public String getSMSSignName() {
        return SMSSignName;
    }

    public void setSMSSignName(String SMSSignName) {
        this.SMSSignName = SMSSignName;
    }

    public String getSMSTemplateCode() {
        return SMSTemplateCode;
    }

    public void setSMSTemplateCode(String SMSTemplateCode) {
        this.SMSTemplateCode = SMSTemplateCode;
    }

    public String getJPushAppId() {
        return JPushAppId;
    }

    public void setJPushAppId(String JPushAppId) {
        this.JPushAppId = JPushAppId;
    }

    public String getJpushSecretKey() {
        return JpushSecretKey;
    }

    public void setJpushSecretKey(String jpushSecretKey) {
        JpushSecretKey = jpushSecretKey;
    }

    public String getContacter() {
        return Contacter;
    }

    public void setContacter(String contacter) {
        Contacter = contacter;
    }

    public String getContactPhone() {
        return ContactPhone;
    }

    public void setContactPhone(String contactPhone) {
        ContactPhone = contactPhone;
    }

    public String getCityCode() {
        return CityCode;
    }

    public void setCityCode(String cityCode) {
        CityCode = cityCode;
    }

    public String getTradeCode() {
        return TradeCode;
    }

    public void setTradeCode(String tradeCode) {
        TradeCode = tradeCode;
    }

    public String getCompanyCode() {
        return CompanyCode;
    }

    public void setCompanyCode(String companyCode) {
        CompanyCode = companyCode;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public boolean isRegMode() {
        return RegMode;
    }

    public void setRegMode(boolean regMode) {
        RegMode = regMode;
    }

    public BigDecimal getMinTopupAmount() {
        return MinTopupAmount;
    }

    public void setMinTopupAmount(BigDecimal minTopupAmount) {
        MinTopupAmount = minTopupAmount;
    }

    public BigDecimal getMinBalance() {
        return MinBalance;
    }

    public void setMinBalance(BigDecimal minBalance) {
        MinBalance = minBalance;
    }

    public BigDecimal getMaxDebitAmount() {
        return MaxDebitAmount;
    }

    public void setMaxDebitAmount(BigDecimal maxDebitAmount) {
        MaxDebitAmount = maxDebitAmount;
    }

    public Integer getKeyMakePeriod() {
        return KeyMakePeriod;
    }

    public void setKeyMakePeriod(Integer keyMakePeriod) {
        KeyMakePeriod = keyMakePeriod;
    }

    public String getDataSavePath() {
        return DataSavePath;
    }

    public void setDataSavePath(String dataSavePath) {
        DataSavePath = dataSavePath;
    }

    public String getFileUploadPath() {
        return FileUploadPath;
    }

    public void setFileUploadPath(String fileUploadPath) {
        FileUploadPath = fileUploadPath;
    }

    public String getMQConnStr() {
        return MQConnStr;
    }

    public void setMQConnStr(String MQConnStr) {
        this.MQConnStr = MQConnStr;
    }

    public String getApiAppId() {
        return ApiAppId;
    }

    public void setApiAppId(String apiAppId) {
        ApiAppId = apiAppId;
    }

    public String getApiAppKey() {
        return ApiAppKey;
    }

    public void setApiAppKey(String apiAppKey) {
        ApiAppKey = apiAppKey;
    }

    public String getAppType() {
        return AppType;
    }

    public void setAppType(String appType) {
        AppType = appType;
    }

    public Boolean getEnableICPrePay() {
        return EnableICPrePay;
    }

    public void setEnableICPrePay(Boolean enableICPrePay) {
        EnableICPrePay = enableICPrePay;
    }

	public String getWeAppToken() {
		return WeAppToken;
	}

	public void setWeAppToken(String weAppToken) {
		WeAppToken = weAppToken;
	}

	public String getWeAppEncodingAESKey() {
		return WeAppEncodingAESKey;
	}

	public void setWeAppEncodingAESKey(String weAppEncodingAESKey) {
		WeAppEncodingAESKey = weAppEncodingAESKey;
	}

	public String getWeAppAppId() {
		return WeAppAppId;
	}

	public void setWeAppAppId(String weAppAppId) {
		WeAppAppId = weAppAppId;
	}

	public String getWeAppAppSecret() {
		return WeAppAppSecret;
	}

	public void setWeAppAppSecret(String weAppAppSecret) {
		WeAppAppSecret = weAppAppSecret;
	}
    
}
