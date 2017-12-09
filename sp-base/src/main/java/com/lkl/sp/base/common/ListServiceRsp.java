package com.lkl.sp.base.common;

import java.util.List;

public class ListServiceRsp<T> {
	private List<T> datalist;
	private Integer tsize;

	public List<T> getDatalist() {
		return datalist;
	}

	public void setDatalist(List<T> datalist) {
		this.datalist = datalist;
	}

	public Integer getTsize() {
		return tsize;
	}

	public void setTsize(Long tsize) {
		this.tsize = tsize.intValue();
	}

	public void setTsize(Integer tsize) {
		this.tsize = tsize;
	}

}
