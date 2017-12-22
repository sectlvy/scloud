package com.lkl.sp.trade;

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
public class OrderApplication {

    public static void main(String[] args) {
    	ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(OrderApplication.class, args);
    }
}

