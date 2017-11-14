package com.lkl.sp.search.thrid;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lkl.sp.db.dc.mapping.gen.bean.SpOrder;

@FeignClient(name= "sp-order")
public interface OrderRemoteInterface {
    @RequestMapping(value = "/trade/queryOrder")
    public List<SpOrder> sporders(@RequestParam("applicationName") String applicationName);
}