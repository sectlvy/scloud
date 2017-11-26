package com.lkl.sp.search;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lkl.sp.db.dc.mapping.gen.bean.SpOrder;
import com.lkl.sp.search.thrid.OrderRemoteInterface;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
class ServiceInstanceRestController {

	@Autowired
	private OrderRemoteInterface orderRemoteInterface;

	@RequestMapping("/search/order")
	@HystrixCommand(fallbackMethod = "fallback")
	public List<SpOrder> serviceInstancesByApplicationName() {
		List<SpOrder> slist = orderRemoteInterface.sporders("a");
		Random random = new Random();
		int randomInt = random.nextInt(10);
		if (randomInt < 8) { // 模拟调用失败情况
			throw new RuntimeException("call dependency service fail.");
		} else {
			return slist;
		}
	}

	public  List<SpOrder> fallback() {
		return new ArrayList<SpOrder>();
	}
}