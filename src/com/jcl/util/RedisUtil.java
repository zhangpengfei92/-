package com.jcl.util;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisUtil {
	
	protected static Logger logger = Logger.getLogger(RedisUtil.class);

	//Redis服务器IP
    private static String ADDR = DeployProperties.getInstance().getRedisUrlPort();
    
    //Redis的端口号
    private static String PORT = DeployProperties.getInstance().getRedisPort();
    
    //访问密码,若你的redis服务器没有设置密码，就不需要用密码去连接
    //private static String AUTH = DeployProperties.getInstance().getRedisSecret();
    
    //可用连接实例的最大数目，默认值为8；
    private static int MAX_TOTAL = 100;
    
    //控制一个pool最多有多少个状态为idle(空闲的)的jedis实例，默认值也是8。
    private static int MAX_IDLE = 50;
    
    //等待可用连接的最大时间，单位毫秒，默认值为-1，表示永不超时。
    private static int MAX_WAIT = 10000;
    
    private static int TIMEOUT = 10000;
    
    //在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
    private static boolean TEST_ON_BORROW = true;
    
    private static JedisPool jedisPool = null;
    
    /**
     * 初始化Redis连接池
     */
    private static void initialPool() {
        try {
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxTotal(MAX_TOTAL);
            config.setMaxIdle(MAX_IDLE);
            config.setMaxWaitMillis(MAX_WAIT);
            config.setTestOnBorrow(TEST_ON_BORROW);
            
            config.setMinIdle(8);//设置最小空闲数
            config.setTestOnReturn(true);
            //Idle时进行连接扫描
            config.setTestWhileIdle(true);
            //表示idle object evitor两次扫描之间要sleep的毫秒数
            config.setTimeBetweenEvictionRunsMillis(30000);
            //表示idle object evitor每次扫描的最多的对象数
            config.setNumTestsPerEvictionRun(10);
            //表示一个对象至少停留在idle状态的最短时间，然后才能被idle object evitor扫描并驱逐；这一项只有在timeBetweenEvictionRunsMillis大于0时才有意义
            config.setMinEvictableIdleTimeMillis(60000);
            jedisPool = new JedisPool(config, ADDR, Integer.parseInt(PORT), TIMEOUT);
        } catch (Exception e) {
        	logger.error("First create JedisPool error : " + e.getMessage());
        	try{
        		JedisPoolConfig config = new JedisPoolConfig();
                config.setMaxTotal(MAX_TOTAL);
                config.setMaxIdle(MAX_IDLE);
                config.setMaxWaitMillis(MAX_WAIT);
                config.setTestOnBorrow(TEST_ON_BORROW);
                
                config.setMinIdle(8);//设置最小空闲数
                config.setTestOnReturn(true);
                //Idle时进行连接扫描
                config.setTestWhileIdle(true);
                //表示idle object evitor两次扫描之间要sleep的毫秒数
                config.setTimeBetweenEvictionRunsMillis(30000);
                //表示idle object evitor每次扫描的最多的对象数
                config.setNumTestsPerEvictionRun(10);
                //表示一个对象至少停留在idle状态的最短时间，然后才能被idle object evitor扫描并驱逐；这一项只有在timeBetweenEvictionRunsMillis大于0时才有意义
                config.setMinEvictableIdleTimeMillis(60000);
                jedisPool = new JedisPool(config, ADDR, Integer.parseInt(PORT), TIMEOUT);
            }catch(Exception e2){
                logger.error("Second create JedisPool error : " + e2.getMessage());
            }
        }
    }
    
	/**
	 * 在多线程环境同步初始化
	 */
	private static synchronized void poolInit() {
		if (jedisPool == null) {
			initialPool();
		}
	}
    
    /**
     * 获取Jedis实例
     * @return
     */
    public synchronized static Jedis getJedis() {
    	/*Jedis jedis = null;
        try {
        	if (jedisPool == null) {
    			poolInit();
    		}
            if (jedisPool != null) {
                jedis = jedisPool.getResource();
            }
        } catch (Exception e) {
        	returnBrokenResource(jedis);
			logger.error("Get jedis error : " + e.getMessage());
		} finally {
			returnResource(jedis);
		}*/
        
        Jedis jedis = null; 
        try {
        	if (jedisPool == null) {
    			poolInit();
    		}
            if (jedisPool != null) {
                jedis = jedisPool.getResource();
            }
        } catch (Exception e) {
        	returnBrokenResource(jedis);
			logger.error("Get jedis error : " + e.getMessage());
			poolInit();
		}
        return jedis;
    }
    
    /**
     * 释放jedis资源
     * @param jedis
     */
	public synchronized static void returnResource(Jedis jedis) {
        if (jedis != null) {
            //jedisPool.returnResource(jedis);
        	jedis.close();
        }
    }
    
    /** 
     * Jedis对象出异常的时候，回收Jedis对象资源 
     *  
     * @param jedis 
     */  
    @SuppressWarnings("deprecation")
	public synchronized static void returnBrokenResource(Jedis jedis) {  
        if (jedis != null) {
            jedisPool.returnBrokenResource(jedis);
        }  
    }

	/**
	 * 设置 String
	 * 
	 * @param key
	 * @param value
	 */
	public static void setString(String key, String value) {
		/*try {
			value = StringUtils.isEmpty(value) ? "" : value;
			getJedis().set(key, value);
		} catch (Exception e) {
			logger.error("Set key error : " + e);
		}*/
		Jedis jedis = null;
	    try {
	    	value = StringUtils.isEmpty(value) ? "" : value;
	    	jedis = getJedis();
	    	jedis.set(key, value);  
	    } catch (Exception e) {  
	        //释放redis对象  
	        if(jedis != null){
	            jedis.close();
	        }
	        logger.error("获取redis缓存数据异常：" + e.getMessage());
	    } finally {
	        //返还到连接池  
	        returnResource(jedis);  
	    }
	}

	/**
	 * 设置 过期时间
	 * 
	 * @param key
	 * @param seconds
	 *            以秒为单位
	 * @param value
	 */
	public static void setString(String key, int seconds, String value) {
		Jedis jedis = null;
		try {
			value = StringUtils.isEmpty(value) ? "" : value;
			jedis = getJedis();
			jedis.setex(key, seconds, value);
		} catch (Exception e) {
			//释放redis对象  
	        if(jedis != null){
	            jedis.close();
	        }
			logger.error("Set keyex error : " + e);
		} finally {
	        //返还到连接池  
	        returnResource(jedis);
	    }
	}

	/**
	 * 获取String值
	 * 
	 * @param key
	 * @return value
	 */
	public static String getString(String key) {
		/*if (getJedis() == null || !getJedis().exists(key)) {
			return null;
		}
		return getJedis().get(key);*/
		
		String value = null;  
	    Jedis jedis = null;
	    try {
	    	jedis = getJedis();
	    	if (jedis == null || !jedis.exists(key)) {
				return null;
			} else {
				value = jedis.get(key); 
			}
	    } catch(Exception e){
	        if(jedis != null){
	            jedis.close();
	        }
	        logger.error("获取redis缓存数据异常：" + e.getMessage());
	    } finally {
	        returnResource(jedis);  
	    }
	    return value;
	}
	
	/**
	 * 获取String值
	 * 
	 * @param key
	 * @return value
	 */
	public static String removeString(String key) {
		/*if (getJedis() == null || !getJedis().exists(key)) {
			return null;
		}
		return getJedis().get(key);*/
		
		String value = null;  
	    Jedis jedis = null;
	    try {
	    	jedis = getJedis();
	    	if (jedis == null || !jedis.exists(key)) {
				return null;
			} else {
				 jedis.del(key); 
			}
	    } catch(Exception e){
	        if(jedis != null){
	            jedis.close();
	        }
	        logger.error("获取redis缓存数据异常：" + e.getMessage());
	    } finally {
	        returnResource(jedis);  
	    }
	    return value;
	}
	
	public static void main(String[] args) {
		setString("18627074562", "785236");
		System.out.println(getString("18627074562"));
	}

}
