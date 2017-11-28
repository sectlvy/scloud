package com.lkl.sp.db.redis;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedisPool;

@Configuration
public class RedisConfig {
	@Primary
	@Bean(name="shardedJedisPool")
	public ShardedJedisPool getSharedPool(){
		GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
		poolConfig.setMaxIdle(10);
		poolConfig.setMaxTotal(1000);
		poolConfig.setTestOnBorrow(true);
		poolConfig.setMaxWaitMillis(10000);
		
		List<JedisShardInfo> shards = new ArrayList<JedisShardInfo>();
		JedisShardInfo jedisShardInfo = new JedisShardInfo("192.168.168.34",7000);
		shards.add(jedisShardInfo);
		
		JedisShardInfo jedisShardInfo1 = new JedisShardInfo("192.168.168.34",7001);
		shards.add(jedisShardInfo1);
		
		
		JedisShardInfo jedisShardInfo3 = new JedisShardInfo("192.168.168.36",7001);
		shards.add(jedisShardInfo3);
		JedisShardInfo jedisShardInfo4 = new JedisShardInfo("192.168.168.36",7001);
		shards.add(jedisShardInfo4);
		
		
		JedisShardInfo jedisShardInfo5 = new JedisShardInfo("192.168.168.37",7001);
		shards.add(jedisShardInfo5);
		JedisShardInfo jedisShardInfo6 = new JedisShardInfo("192.168.168.37",7001);
		shards.add(jedisShardInfo6);
		ShardedJedisPool shardedJedisPool = new ShardedJedisPool(poolConfig,shards);
		return shardedJedisPool;
	}
}
