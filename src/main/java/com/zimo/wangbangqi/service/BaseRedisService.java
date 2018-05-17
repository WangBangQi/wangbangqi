package com.zimo.wangbangqi.service;

import com.zimo.wangbangqi.model.Waiter;
import com.zimo.wangbangqi.service.adminService.AdminService;
import com.zimo.wangbangqi.utils.SpringUtil;
import com.zimo.wangbangqi.utils.StringKeyUtil;
import com.zimo.wangbangqi.utils.TransformUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;

import java.io.Serializable;
import java.lang.reflect.Field;

/**
 * 抽象出BaseRedis类，其有四个方法来操作缓存
 * 参数有key,类的类型。类的值。
 * @param <T>
 * @param <K>
 */
public class BaseRedisService <T,K> {

    @Autowired
    private TransformUtil transformUtil;

    @Autowired
    HashOperations hashOperations;

    public Boolean hasKey(String key)throws Exception{
        Field[] fields = Waiter.class.getDeclaredFields();
        for (Field field : fields){
            if(!hashOperations.hasKey(key,field.getName()))
                return false;
        }
        return true;
    }


    public void addWaiter(String key,Waiter waiter)throws Exception{
        hashOperations.putAll(key, transformUtil.classToMap(waiter));
    }

    public<T extends Serializable> T getByKey(Class tClass,K k)throws Exception{
        String key = buildKey(tClass,k);
        return (T) transformUtil.mapToClass(tClass,hashOperations.entries(key));
    }

    public void remove(String key){
        Field[] fields = Waiter.class.getDeclaredFields();
        for (Field field : fields){
            hashOperations.delete(key,field.getName());
        }
    }

    protected String buildKey(Class tClass,K k){
        return StringKeyUtil.buildKey(tClass,k);
    }
}
