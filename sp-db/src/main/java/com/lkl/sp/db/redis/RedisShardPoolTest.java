package com.lkl.sp.db.redis;

import java.util.ArrayList;
import java.util.List;

import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

public class RedisShardPoolTest {
    
    static ShardedJedisPool pool;

    static{
        JedisPoolConfig config =new JedisPoolConfig();//Jedis池配置
        config.setMaxTotal(500);//最大活动的对象个数
        config.setMaxIdle(1000 * 60);//对象最大空闲时间
        config.setTestOnBorrow(true);

        List<JedisShardInfo> jdsInfoList =new ArrayList<JedisShardInfo>(2);
        
		JedisShardInfo info1 = new JedisShardInfo("192.168.168.34", 7000);
		JedisShardInfo info2 = new JedisShardInfo("192.168.168.34", 7001);
		JedisShardInfo info3 = new JedisShardInfo("192.168.168.36", 7000);
		JedisShardInfo info4 = new JedisShardInfo("192.168.168.36", 7001);
		JedisShardInfo info5 = new JedisShardInfo("192.168.168.37", 7000);
		JedisShardInfo info6 = new JedisShardInfo("192.168.168.37", 7001);

		
        jdsInfoList.add(info1);
        jdsInfoList.add(info2);
        jdsInfoList.add(info3);
        jdsInfoList.add(info4);
        jdsInfoList.add(info5);
        jdsInfoList.add(info6);
        
        pool =new ShardedJedisPool(config, jdsInfoList);
     }

       

    /**
    
     * @param args
    
     */
    
    public static void main(String[] args) {
        for(int i=0; i<100; i++){
            String key = generateKey();
            ShardedJedis jds = null;
            try {
                jds = pool.getResource();
                System.out.println(key+":"+jds.getShard(key).getClient().getHost());
                System.out.println(jds.set(key,Math.random()+""));
                
                System.out.println(jds.get(key));
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                pool.returnResource(jds);
            }
        }
    }
    
    private static int index = 1;
    public static String generateKey(){
        return String.valueOf(Thread.currentThread().getId())+"_"+(index++);
    }
}