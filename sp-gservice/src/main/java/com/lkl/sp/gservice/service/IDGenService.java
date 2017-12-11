package com.lkl.sp.gservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lkl.sp.db.dc.mapping.gen.SpOrderMapper;
import com.lkl.sp.db.redis.JedisClusterClient;

@Component
public class IDGenService {
	@Autowired
	SpOrderMapper spOrderMapper;
	@Autowired
	JedisClusterClient jedisClusterClient;
	
	public String getGenNo(String pre){
		Long seqNo = jedisClusterClient.increKeyExpire("Nogen");
		String timstr = System.currentTimeMillis()+"";
		return pre+timstr + seqNo;
	}
}
