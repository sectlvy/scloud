package com.lkl.sp.trade;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lkl.sp.db.dc.mapping.gen.SpOrderMapper;
import com.lkl.sp.db.dc.mapping.gen.bean.SpOrder;
import com.lkl.sp.db.dc.mapping.gen.bean.SpOrderExample;
import com.lkl.sp.db.redis.JedisTemplate;

@RestController
class ServiceInstanceRestController {

	@Autowired
	private DiscoveryClient discoveryClient;
	@Autowired
	SpOrderMapper spOrderMapper;
	@Autowired
	JedisTemplate jedisTemplate;
	@RequestMapping("/trade/queryOrder")
	public List<SpOrder> serviceInstancesByApplicationName(@RequestParam String applicationName) {
		Random random = new Random();
		int randomInt = random.nextInt(10);
		if (randomInt < 8) { // 模拟调用失败情况
			throw new RuntimeException("call dependency service fail.");
		} else {
			return spOrderMapper.selectByExample(new SpOrderExample());
		}
	}
}