package com.lkl.sp.trade.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.lkl.sp.base.common.ListServiceRsp;
import com.lkl.sp.base.common.ReturnResult;
import com.lkl.sp.base.exceptions.ExpLevel;
import com.lkl.sp.base.exceptions.SpException;
import com.lkl.sp.base.exceptions.SpReturnCodeEnum;
import com.lkl.sp.base.trade.req.SubOrderReq;
import com.lkl.sp.db.dc.mapping.gen.SpOrderMapper;
import com.lkl.sp.db.dc.mapping.gen.bean.SpOrder;
import com.lkl.sp.db.dc.mapping.gen.bean.SpOrderExample;
import com.lkl.sp.db.redis.JedisClusterClient;
import com.lkl.sp.trade.foreign.sgservice.GserviceRemoteController;

@Component
public class OrderService {
	@Autowired
	SpOrderMapper spOrderMapper;
	@Autowired
	JedisClusterClient jedisClusterClient;
	@Autowired
	GserviceRemoteController gserviceRemoteController;
	public ListServiceRsp<SpOrder> queryOrders(){
		ListServiceRsp<SpOrder> listServiceRsp = new ListServiceRsp<SpOrder>();
		
		SpOrderExample spOrderExample = new SpOrderExample();
		listServiceRsp.setDatalist(spOrderMapper.selectByExample(spOrderExample));
		listServiceRsp.setTsize(spOrderMapper.countByExample(spOrderExample));
		return listServiceRsp;
	}
	@Transactional
	public SpOrder submitOrder(SubOrderReq subOrderReq){
		ReturnResult<String> returnResult = gserviceRemoteController.genNo("OR");
		String orderNo = returnResult.getData();
		
		SpOrder spOrder = new SpOrder();
		spOrder.setCreateTime(new Date());
		spOrder.setGoodNo(subOrderReq.getGoodNo());
		spOrder.setOrderNo(orderNo);
		spOrder.setPriceChannel(subOrderReq.getPriceChannel());
		int optNum = spOrderMapper.insert(spOrder);
		if(optNum==1){
			return spOrder;
		}else{
			throw new SpException(SpReturnCodeEnum.SDKERROR,ExpLevel.EXPLOG,"生成订单错误");
		}
	}
}
