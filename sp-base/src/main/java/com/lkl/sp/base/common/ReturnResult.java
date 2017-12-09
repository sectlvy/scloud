package com.lkl.sp.base.common;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReturnResult implements Serializable {
	private static final long serialVersionUID = -107107916660163194L;
	private Object data;
	private String message; // 状态描述信息
	private Integer status = 200; // 响应状态码 默认200代表成功

	private Map<String, Object> rmap = new HashMap<>();

	public ReturnResult() {
	}

	public ReturnResult(Object data) {
		this.data = data;
	}

	public <T> ReturnResult(Integer totalSize, List<T> resultBean) {
		rmap.put("totalSize", totalSize);
		rmap.put("resultBean", resultBean);
		this.data = rmap;
	}

	public <T> void setData(List<T> resultBean, Integer totalSize) {
		rmap.put("totalSize", totalSize);
		rmap.put("resultBean", resultBean);
		this.data = rmap;
	}

	public void setData(String jkey, Object dvalue) {
		rmap.put(jkey, dvalue);
		this.data = rmap;
	}

	/**
	 * @return the data
	 */
	public Object getData() {
		return data;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public void setData(Object data) {
		this.data = data;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the status
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
}
