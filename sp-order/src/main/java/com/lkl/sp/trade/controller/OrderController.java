package com.lkl.sp.trade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lkl.sp.base.common.ListServiceRsp;
import com.lkl.sp.base.common.ReturnResult;
import com.lkl.sp.db.dc.mapping.gen.bean.SpOrder;
import com.lkl.sp.db.dc.mapping.gen.bean.SpOrderExample;
import com.lkl.sp.trade.service.OrderService;

@RestController
@RequestMapping("trade")
class OrderController {

	@Autowired
	private DiscoveryClient discoveryClient;
	@Autowired
	OrderService orderService;
	/**
	 * 订单查询
	 * @param applicationName
	 * @return
	 */
	@RequestMapping(value = {"v1.0/queryOrders"}, method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public ReturnResult serviceInstancesByApplicationName(@RequestParam String orderNo) {
		ReturnResult returnResult = new ReturnResult();
		ListServiceRsp<SpOrder> listServiceRsp = orderService.queryOrders();
		returnResult.setData(listServiceRsp.getDatalist(), listServiceRsp.getTsize()); ;
		return returnResult;
	}
	
	@RequestMapping(value = {"v1.0/submitOrder"}, method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public ReturnResult submitOrder(){
		
	}
}