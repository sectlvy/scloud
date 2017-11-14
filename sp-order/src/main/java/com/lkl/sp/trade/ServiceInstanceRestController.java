package com.lkl.sp.trade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lkl.sp.db.dc.mapping.gen.SpOrderMapper;
import com.lkl.sp.db.dc.mapping.gen.bean.SpOrder;
import com.lkl.sp.db.dc.mapping.gen.bean.SpOrderExample;

@RestController
class ServiceInstanceRestController {

	@Autowired
	private DiscoveryClient discoveryClient;
	@Autowired
	SpOrderMapper spOrderMapper;
	@RequestMapping("/trade/queryOrder")
	public List<SpOrder> serviceInstancesByApplicationName(@RequestParam String applicationName) {
		return spOrderMapper.selectByExample(new SpOrderExample());
	}
}