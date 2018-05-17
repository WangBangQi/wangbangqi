package com.zimo.wangbangqi.service.waiter;


import com.zimo.wangbangqi.model.Waiter;
import com.zimo.wangbangqi.utils.TransformUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Component;


import java.lang.reflect.Field;

@Component
public class WaiterRedis{

    @Autowired
    TransformUtil transformUtil;
    @Autowired
    private HashOperations<String,String,Object> hashOperations;

    //判断是否对象的所有属性的Key都存在
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

    public Waiter getByKey(String key)throws Exception{
        return (Waiter) transformUtil.mapToClass(Waiter.class,hashOperations.entries(key));
    }

    public void remove(String key){
        Field[] fields = Waiter.class.getDeclaredFields();
        for (Field field : fields){
            hashOperations.delete(key,field.getName());
        }
    }


}
