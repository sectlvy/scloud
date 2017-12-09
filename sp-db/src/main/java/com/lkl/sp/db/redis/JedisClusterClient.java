package com.lkl.sp.db.redis;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

@Component
public class JedisClusterClient {
	private static Logger log = LoggerFactory.getLogger(JedisClusterClient.class);
	private JedisPoolConfig getPoolConfig() {
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxTotal(1000);
		config.setMaxIdle(100);
		config.setTestOnBorrow(true);
		return config;
	}

	public JedisCluster getJcluster(){
		Set<HostAndPort> jedisClusterNodes = new HashSet<HostAndPort>();
		jedisClusterNodes.add(new HostAndPort("192.168.168.34", 7000));
		jedisClusterNodes.add(new HostAndPort("192.168.168.34", 7001));
		jedisClusterNodes.add(new HostAndPort("192.168.168.36", 7000));
		jedisClusterNodes.add(new HostAndPort("192.168.168.36", 7001));
		jedisClusterNodes.add(new HostAndPort("192.168.168.37", 7000));
		jedisClusterNodes.add(new HostAndPort("192.168.168.37", 7001));

		JedisCluster jc = new JedisCluster(jedisClusterNodes, getPoolConfig());
		return jc;
	}
	
	
	public void setKey(String key,String value){
		JedisCluster jedisCluster = null;
		try{
			jedisCluster = getJcluster();
			jedisCluster.set(key,value);
		}catch(Exception e){
			log.error("",e);
		}finally{
			if(jedisCluster!=null){
				try {
					jedisCluster.close();
				} catch (IOException e) {
					log.error("",e);
				}
			}
		}
	}
	
	public String getKey(String key){
		JedisCluster jedisCluster = null;
		try{
			jedisCluster = getJcluster();
			return jedisCluster.get(key);
		}catch(Exception e){
			log.error("",e);
			return null;
		}finally{
			if(jedisCluster!=null){
				try {
					jedisCluster.close();
				} catch (IOException e) {
					log.error("",e);
				}
			}
		}
	}
	
	public void lpush(String key,String value){
		JedisCluster jedisCluster = null;
		try{
			jedisCluster = getJcluster();
			jedisCluster.lpush(key,value);
		}catch(Exception e){
			log.error("",e);
		}finally{
			if(jedisCluster!=null){
				try {
					jedisCluster.close();
				} catch (IOException e) {
					log.error("",e);
				}
			}
		}
	}
	
	
	public String blpop(String key){
		JedisCluster jedisCluster = null;
		try{
			jedisCluster = getJcluster();
			return jedisCluster.lpop(key);
		}catch(Exception e){
			log.error("",e);
			return null;
		}finally{
			if(jedisCluster!=null){
				try {
					jedisCluster.close();
				} catch (IOException e) {
					log.error("",e);
				}
			}
		}
	}
}