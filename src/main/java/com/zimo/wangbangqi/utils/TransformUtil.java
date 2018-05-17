package com.zimo.wangbangqi.utils;

import org.springframework.stereotype.Component;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @param <T>
 * @param <HK>
 * @param <HV>
 */
@Component
public class TransformUtil<T,HK,HV> {

    public Map<String,Object> classToMap(T t)throws InstantiationException,IntrospectionException,
            IllegalAccessException, IllegalArgumentException,InvocationTargetException {
        Field[] fields = t.getClass().getDeclaredFields();
        Map<String,Object> map = new HashMap<>();
        //将属性名和属性值写入map中。
        for (Field field : fields){
            PropertyDescriptor tbPropDesc = new PropertyDescriptor(field.getName(),t.getClass());
            Method methodRead = tbPropDesc.getReadMethod();
            map.put(field.getName(),methodRead.invoke(t));
        }
        return map;
    }

    public T mapToClass(Class<T> t,Map<HK,HV> m)throws InstantiationException,IntrospectionException,
            IllegalAccessException, IllegalArgumentException,InvocationTargetException {
        //创建一个T类型的对象
        T t1 = t.newInstance();
        //获取域名
        Field[] fields = t.getDeclaredFields();
        for (Field field : fields){
            PropertyDescriptor descriptor = new PropertyDescriptor(field.getName(),t);
            Method methodWrite = descriptor.getWriteMethod();
            //将该属性名的值写入到T对象中
            methodWrite.invoke(t1,m.get(field.getName()));
        }
        return t1;
     }

}
