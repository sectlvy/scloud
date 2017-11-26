package com.lkl.sp.search.thrid;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lkl.sp.db.dc.mapping.gen.bean.SpOrder;
import com.lkl.sp.search.thrid.OrderRemoteInterface.HystrixClientFallback;

@FeignClient(name= "sp-order" ,fallback = HystrixClientFallback.class)
public interface OrderRemoteInterface {
    @RequestMapping(value = "/trade/queryOrder")
    public List<SpOrder> sporders(@RequestParam("applicationName") String applicationName);
    
    @Component
    static class HystrixClientFallback implements OrderRemoteInterface {

		@Override
		public List<SpOrder> sporders(String applicationName) {
			return new ArrayList<SpOrder>();
		}
    	
    }

}