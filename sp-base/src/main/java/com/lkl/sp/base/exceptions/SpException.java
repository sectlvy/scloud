package com.lkl.sp.base.exceptions;


public class SpException extends RuntimeException {

	private static final long serialVersionUID = -6371381429248690866L;
	public ExpLevel expLevel;
	public SpReturnCodeEnum returnCode;
	public Object[] args;
	/**
	 * @param returnCode
	 * @param args
	 */
	public SpException(SpReturnCodeEnum returnCode,ExpLevel expLevel,String... args) {
		this.expLevel = expLevel;
		this.returnCode = returnCode;
		this.args = args;
		
	}
	
	@Override
	public String getMessage() {
		String statusLine = String.format(" 错误码为%s 异常信息为 %s ", returnCode.getCode(), args);
		StringBuilder message = new StringBuilder(statusLine);
		return message.toString();
	}

}
