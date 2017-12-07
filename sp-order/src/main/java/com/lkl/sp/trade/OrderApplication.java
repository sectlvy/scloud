package com.lkl.sp.trade;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.lkl.sp.db.redis.JedisTemplate;

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
@ComponentScan(basePackages = { "com.lkl" })
@EnableCircuitBreaker
@EnableHystrixDashboard
public class OrderApplication {

    public static void main(String[] args) {
    	ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(OrderApplication.class, args);
    	JedisTemplate jedisTemplate = configurableApplicationContext.getBean(JedisTemplate.class);
    	
    	jedisTemplate.set("a", "d");
    	
    	System.out.println(jedisTemplate.get("a"));
    }
}

