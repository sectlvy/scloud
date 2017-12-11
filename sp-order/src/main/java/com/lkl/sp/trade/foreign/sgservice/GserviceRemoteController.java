package com.lkl.sp.trade.foreign.sgservice;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lkl.sp.base.common.ReturnResult;

@FeignClient(name= "sp-gservice")
public interface GserviceRemoteController {
	@RequestMapping(value = {"v1.0/genNo"}, method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public ReturnResult genNo(@RequestParam String pre);
    
    @Component
    static class HystrixClientFallback implements GserviceRemoteController {

		@Override
		public ReturnResult genNo(String pre) {
			return null;
		}
    	
    }

}