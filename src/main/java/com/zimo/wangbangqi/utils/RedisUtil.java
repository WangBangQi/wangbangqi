package com.zimo.wangbangqi.utils;

import com.zimo.wangbangqi.enums.DefaultValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/**
 * 缓存工具。
 */
@Component
public class RedisUtil {

    @Autowired
    private ValueOperations<String,Object> valueOperations;
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    //判断是否有该key存在。
    public Boolean hasKey(String key){
        return redisTemplate.hasKey(key)==null?false:redisTemplate.hasKey(key);
    }

    //通过key来获取Value。
    public Object get(String key){
        return valueOperations.get(key);
    }

    //缓存单个数据。
    public void save(String key,Object object){
        valueOperations.set(key,object);
    }

    //缓存一个集合
    public void save(String key, Collection<?> collection){
        valueOperations.set(key,collection);
    }

    //缓存单个数据,有过期时间,单位分钟。
    public void save(String key,Object object,Long time){
        valueOperations.set(key,object,time, DefaultValue.REDIS_TIME_UNIT);
    }

    //缓存一个集合，单位分钟
    public void save(String key, Collection<?> collection,Long time){
        valueOperations.set(key,collection,time,DefaultValue.REDIS_TIME_UNIT);
    }


}
