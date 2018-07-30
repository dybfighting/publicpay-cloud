package com.publicpay.base.utils;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.*;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by Shixy on 2017/12/7.
 */
public class RedisUtils {


    private static Logger logger = LoggerFactory.getLogger(RedisUtils.class);

    private static RedisTemplate redisTemplate;
    private static RedisTemplate stringRedisTemplate;

    public RedisUtils(){}

    public RedisUtils(RedisTemplate redisTemplateWired) {
        redisTemplate = redisTemplateWired;
    }

    public RedisUtils(RedisTemplate redisTemplateWired , RedisTemplate stringRedisTemplateWired) {
        redisTemplate = redisTemplateWired;
        stringRedisTemplate = stringRedisTemplateWired;
    }

    /**
     * 写入缓存
     * @param key
     * @param value
     * @return
     */
    public static boolean set(final String key, Object value) {
        boolean result = false;
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    /**
     * 写入缓存设置时效时间
     * @param key
     * @param value
     * @return
     */
    public static boolean set(final String key, Object value, long expireTime) {
        boolean result = false;
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    public static boolean setExpireTime(final String key, long expireTime) {
        boolean result = false;
        try {
            redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    /**
     * 计数器
     * @param key
     */
    public static long increment(String key, long delta, long expireTime) {
    	long inc = 0;
    	try {
    		if (delta > 0) {
    			inc = redisTemplate.opsForValue().increment(key, delta);
    			if (expireTime > 0) {
    				redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
    			}
    		}
        } catch (Exception e) {
            e.printStackTrace();
        }
    	return inc;
    }

    public static long increment(String key, long delta) {
    	long inc = 0;
    	try {
    		if (delta > 0) {
    			inc = redisTemplate.opsForValue().increment(key, delta);
    		}
        } catch (Exception e) {
            e.printStackTrace();
        }
    	return inc;
    }

    public static long incrementByStringTemplete(String key, long delta) {
        long inc = 0;
        try {
            if (delta > 0) {
                inc = stringRedisTemplate.opsForValue().increment(key, delta);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return inc;
    }
    /**
     * 批量删除对应的value
     * @param keys
     */
    public static void remove(final String... keys) {
        for (String key : keys) {
            remove(key);
        }
    }

    /**
     * 批量删除key
     * @param pattern
     */
    public static void removePattern(final String pattern) {
        Set<Serializable> keys = redisTemplate.keys(pattern);
        if (keys.size() > 0)
            redisTemplate.delete(keys);
    }
    /**
     * 删除对应的value
     * @param key
     */
    public static void remove(final String key) {
        if (exists(key)) {
            redisTemplate.delete(key);
        }
    }
    /**
     * 判断缓存中是否有对应的value
     * @param key
     * @return
     */
    public static boolean exists(final String key) {
        return redisTemplate.hasKey(key);
    }
    /**
     * 读取缓存
     * @param key
     * @return
     */
    public static Object get(final String key) {
        Object result = null;
        ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
        result = operations.get(key);
        return result;
    }

    public static Object getStringByStringTemplete(final String key) {
        Object result = null;
        ValueOperations<Serializable, Object> operations = stringRedisTemplate.opsForValue();
        result = operations.get(key);
        return result;
    }
    
    public static String getString(final String prefix, final String key) {
        String realKey = "";
        if (StringUtils.isNotBlank(prefix)) realKey += prefix;
        if (StringUtils.isNotBlank(key)) realKey += key;
        
        ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
        Object result = operations.get(realKey);
        return ComUtils.replaceNull2Space(result+"");
    }
    
    /**
     * 哈希 添加
     * @param key
     * @param hashKey
     * @param value
     */
    public static void hmSet(String key, Object hashKey, Object value){
        HashOperations<String, Object, Object> hash = redisTemplate.opsForHash();
        hash.put(key,hashKey,value);
    }

    /**
     * 哈希获取数据
     * @param key
     * @param hashKey
     * @return
     */
    public static Object hmGet(String key, Object hashKey){
        HashOperations<String, Object, Object>  hash = redisTemplate.opsForHash();
        return hash.get(key,hashKey);
    }

    /**
     * 列表添加
     * @param k
     * @param v
     */
    public static void lPush(String k, Object v){
        ListOperations<String, Object> list = redisTemplate.opsForList();
        //list.rightPush(k,v);
        list.leftPush(k, v);
    }

    /**
     * 表尾添加
     * @param k
     * @param v
     */
    public static void rPush(String k, Object v){
        ListOperations<String, Object> list = redisTemplate.opsForList();
        list.rightPush(k,v);
    }

    /**
     * 表头取出并删除
     * @param k
     */
    public static Object lPop(String k){
        ListOperations<String, Object> list = redisTemplate.opsForList();
        return list.leftPop(k);
    }

    /**
     * 表尾取出并删除
     * @param k
     */
    public static Object rPop(String k){
        ListOperations<String, Object> list = redisTemplate.opsForList();
        return list.rightPop(k);
    }

    /**
     * 列表获取
     * @param k
     * @param l
     * @param l1
     * @return
     */
    public static List<Object> lRange(String k, long l, long l1){
        ListOperations<String, Object> list = redisTemplate.opsForList();
        return list.range(k,l,l1);
    }

    /**
     * 集合添加
     * @param key
     * @param value
     */
    public static void add(String key, Object value){
        SetOperations<String, Object> set = redisTemplate.opsForSet();
        set.add(key,value);
    }

    /**
     * 集合获取
     * @param key
     * @return
     */
    public static Set<Object> setMembers(String key){
        SetOperations<String, Object> set = redisTemplate.opsForSet();
        return set.members(key);
    }

    /**
     * 有序集合添加
     * @param key
     * @param value
     * @param scoure
     */
    public static void zAdd(String key, Object value, double scoure){
        ZSetOperations<String, Object> zset = redisTemplate.opsForZSet();
        zset.add(key,value,scoure);
    }

    /**
     * 有序集合获取
     * @param key
     * @param scoure
     * @param scoure1
     * @return
     */
    public static Set<Object> rangeByScore(String key, double scoure, double scoure1){
        ZSetOperations<String, Object> zset = redisTemplate.opsForZSet();
        return zset.rangeByScore(key, scoure, scoure1);
    }

    /**
     * 获取对列大小
     * @param key 队列名字
     * @return
     */
    public static Long size(String key){

        return redisTemplate.opsForList().size(key);
    }

    /**
     * 获取对列大小
     * @param key 队列名字
     * @return
     */
    public static void trim(String key, long start, long end){
        redisTemplate.opsForList().trim(key, start, end);
    }
}
