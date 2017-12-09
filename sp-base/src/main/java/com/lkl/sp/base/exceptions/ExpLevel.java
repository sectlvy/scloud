package com.lkl.sp.base.exceptions;

public enum ExpLevel {
	EXPLOG(1, "非业务异常 需要反馈"), BUSI(2, "业务异常 属于正常异常"), 

	;

	private int code;
	private String value;

	ExpLevel(int code, String value) {
		this.code = code;
		this.value = value;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
