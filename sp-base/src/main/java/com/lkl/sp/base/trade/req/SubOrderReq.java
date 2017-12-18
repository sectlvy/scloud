package com.lkl.sp.base.trade.req;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class SubOrderReq {
	@NotNull(message="价格不能为空")
	private Double priceChannel;
	@NotEmpty(message="价格不能为空")
	private String goodNo;
	public Double getPriceChannel() {
		return priceChannel;
	}
	public void setPriceChannel(Double priceChannel) {
		this.priceChannel = priceChannel;
	}
	public String getGoodNo() {
		return goodNo;
	}
	public void setGoodNo(String goodNo) {
		this.goodNo = goodNo;
	}
}
