package com.zimo.wangbangqi.service.adminService;

import com.zimo.wangbangqi.model.Admin;
import com.zimo.wangbangqi.utils.TransformUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Component;

import java.beans.IntrospectionException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

@Component
public class AdminRedis {

    @Autowired
    TransformUtil transformUtil;
    @Autowired
    private HashOperations<String,String,Object> hashOperations;

    //判断是否对象的所有属性的Key都存在
//    @SuppressWarnings("unchecked")
    public Boolean hasKey(String key){
        Field[] fields = Admin.class.getDeclaredFields();
        for (Field field : fields){
            if(!hashOperations.hasKey(key,field.getName()))
                return false;
        }
        return true;
    }

    public void addAdmin(String key,Admin admin)throws InstantiationException,IntrospectionException
            ,IllegalAccessException,InvocationTargetException{
        hashOperations.putAll(key, transformUtil.classToMap(admin));
    }

    public Admin getByKey(String key) throws InstantiationException,IntrospectionException
            ,IllegalAccessException,InvocationTargetException{
        return (Admin) transformUtil.mapToClass(Admin.class,hashOperations.entries(key));
    }

    public void remove(String key){
        Field[] fields = Admin.class.getDeclaredFields();
        for (Field field : fields){
            hashOperations.delete(key,field.getName());
        }
    }
}
