package com.slzr.common.domain.enums;

/**
 * 自定义命令类型
 * @author zhy
 *
 */
public enum ErrCode {
	/**
	 * 成功
	 */
	SUCCESS(0),
	/**
	 * 参数为NULL
	 */
	ARGUMENT_IS_NULL(-5001),
	/**
	 * 非法参数
	 */
	ARGUMENT_IS_VALID(-5002),
	
	/**
	 * 更新失败
	 */
	UPDATE_FAILED(-5103),
	
	/**
	 * 记录已经存在
	 */
	RECORD_EXISTED(-5101),
	
	/**
	 * 记录不存在
	 */
	RECORD_NOT_FOUND(-5002),
	
	
	/**
	 * MAC 校验失败
	 */
	MAC_VERIFY_FAILED(-5500),
	
	/**
	 * 数据库操作错误
	 */
	DB_EXECUTE_ERROR(-5100),
	
	/**
	 * 调用接口错误
	 */
	CALL_API_ERROR(-5200),
	
	/**
	 * 服务器通用错误
	 */
	SERVER_ERROR(-500)
	;
	
	
	// 定义私有变量
    private Integer errCode;
	
    private ErrCode( Integer errCode) {
        this.errCode = errCode;
    }

    @Override
    public String toString() {
        return String.valueOf ( this.errCode );
    }
    
    public Integer getValue()
    {
    	return errCode;
    }  
    		
}