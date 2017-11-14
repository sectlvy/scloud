package com.lkl.sp.search;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lkl.sp.db.dc.mapping.gen.bean.SpOrder;
import com.lkl.sp.search.thrid.OrderRemoteInterface;

@RestController
class ServiceInstanceRestController {

	@Autowired
	private OrderRemoteInterface orderRemoteInterface;

	@RequestMapping("/search/order")
	public List<SpOrder> serviceInstancesByApplicationName() {
		List<SpOrder> slist = orderRemoteInterface.sporders();
		return slist;
	}
}