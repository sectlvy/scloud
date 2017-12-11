package com.lkl.sp.trade.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lkl.sp.base.common.ListServiceRsp;
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
}
