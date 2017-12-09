package com.lkl.sp.base.exceptions;


public enum SpReturnCodeEnum implements ReturnCode {
	
	REDIS_EXP(99002, "REDIS 发送失败"),
	HTTPCLIENT_NOT_VALID(99001, "网络发送失败"), 
	REDIS_EXP_PAR(99003, "REDIS 发送失败 %S"),
	SMSVERIFYERR(99004,"验证码错误"),
	SDKERROR(99009,"%"),
	
	PARAM_ERROR(400001,"参数错误 %S")
	;
	
	private int code;
	private String message;

	private SpReturnCodeEnum(int code, String message) {
		this.code = code;
		this.message = message;
	};

	@Override
	public int getCode() {
		return this.code;
	}

	@Override
	public String getMessage() {
		return this.message;
	}

}
