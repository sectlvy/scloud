package com.lkl.sp.gservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.alibaba.fastjson.JSON;
import com.lkl.sp.base.common.ReturnResult;

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
@ComponentScan(basePackages = { "com.lkl" })
@EnableCircuitBreaker
@EnableHystrixDashboard
public class GServiceApplication {

    public static void main(String[] args) {
    	String xx = "{\"data\":\"OR15136486264892\",\"message\":null,\"status\":200,\"totalSize\":null,\"tlist\":[]}";
//    	ReturnResult<String> dd =JSON.parseObject(xx, ReturnResult.class);
//    	xx = "{\"data\":\"OR15136486264892\",\"status\":200,\"tlist\":[]}";
//    	xx = 	"{\"data\":\"OR15136486264892\",\"status\":200,\"tlist\":[]}";
    	ReturnResult<String> rsd = new ReturnResult<String>();
    	rsd.setData("OR15136486264892");
    	ReturnResult<String> dd =JSON.parseObject(xx, ReturnResult.class);
    	System.out.println(JSON.toJSONString(rsd));
    	ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(GServiceApplication.class, args);
    }
}

