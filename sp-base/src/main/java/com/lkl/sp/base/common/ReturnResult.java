package com.lkl.sp.base.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ReturnResult<T> implements Serializable {
	private static final long serialVersionUID = -107107916660163194L;
	private T data;
	private String message; // 状态描述信息
	private Integer status = 200; // 响应状态码 默认200代表成功

	private Integer totalSize;
	private List<T> tlist = new ArrayList<>();

	public void setListData(ListServiceRsp<T> listServiceRsp) {
		this.totalSize = listServiceRsp.getTsize();
		this.tlist = listServiceRsp.getDatalist();
	}
	
	public ReturnResult() {
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(Integer totalSize) {
		this.totalSize = totalSize;
	}

	public List<T> getTlist() {
		return tlist;
	}

	public void setTlist(List<T> tlist) {
		this.tlist = tlist;
	}


}
