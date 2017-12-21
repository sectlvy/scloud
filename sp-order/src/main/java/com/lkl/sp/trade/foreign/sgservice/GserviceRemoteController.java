package com.lkl.sp.trade.foreign.sgservice;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lkl.sp.base.common.ReturnResult;

@FeignClient(name= "sp-gservice")
public interface GserviceRemoteController {
	@RequestMapping(value = {"gservice/v1.0/genNo"}, method = RequestMethod.POST)
	public ReturnResult<String> genNo(@RequestParam("pre") String pre);
    
    @Component
    static class HystrixClientFallback implements GserviceRemoteController {

		@Override
		public ReturnResult<String> genNo(String pre) {
			ReturnResult<String> rs = new ReturnResult<String>();
			rs.setData("无数据");
			return rs;
		}
    	
    }

}