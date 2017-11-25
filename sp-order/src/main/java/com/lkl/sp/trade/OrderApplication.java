package com.lkl.sp.trade;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.lkl.sp.db.redis.JedisTemplate;

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
@ComponentScan(basePackages = { "com.lkl" })
public class OrderApplication {

    public static void main(String[] args) {
    	ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(OrderApplication.class, args);
    	JedisTemplate jedisTemplate = configurableApplicationContext.getBean(JedisTemplate.class);
    	jedisTemplate.set("aa", "dd");
    	
    	String aa  = jedisTemplate.get("aa");
    	
    	System.out.println(aa);
    }
}

