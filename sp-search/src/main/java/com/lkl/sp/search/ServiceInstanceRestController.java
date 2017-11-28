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
	public List<SpOrder> serviceInstancesByApplicationName() {
		List<SpOrder> slist = orderRemoteInterface.sporders("a");
		return slist;
	}

}