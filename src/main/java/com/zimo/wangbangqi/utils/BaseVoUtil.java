package com.zimo.wangbangqi.utils;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * @desc: 对PO和VO相同字段copy的封装。
 * @author 子墨
 *
 */
public class BaseVoUtil {

//    V代表VO T代表PO，在这里VO等价于DTO。后端
    /**
     * PO2DTO中copy相同的字段。
     * @param tb   传递的PO对象，
     * @param voClazz   传递的VO对象的类类型。
     * @param <V>   VO
     * @param <T>   PO
     * @return  返回VO对象。
     * @throws InstantiationException
     * @throws IntrospectionException
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     * @throws InvocationTargetException
     */
    public static <V,T> V getVo(T tb ,Class<V> voClazz) throws  InstantiationException,IntrospectionException,
            IllegalAccessException, IllegalArgumentException,InvocationTargetException{
        //获取vo的全部属性值
        Field[] fields = voClazz.getDeclaredFields();   //获取全部的域名
        //创建一个VO对象
        V vo = voClazz.newInstance();

        //获取tb的全部属性名
        Field[] fieldsTb = tb.getClass().getDeclaredFields();
        //将全部的属性名存入到数组集合fieldsTbNameList中。
        List<String > fieldsTbNameList = new ArrayList<String>();
        for (Field field : fieldsTb){
            fieldsTbNameList.add(field.getName());
        }

        for (Field field : fields){
            //获取vo里面的写方法
            //通过PropertyDescriptor内省类两个参数,类名，和属性名来获取该属性。
            PropertyDescriptor voPropDesc = new PropertyDescriptor(field.getName(),voClazz);
            //获取是对应的属性值的写方法。
            Method methodWrite = voPropDesc.getWriteMethod();

            //获取TO里面的读方法
            //如果tb里面存在Vo里面的字段值，就会自动copy
            if(fieldsTbNameList.contains(field.getName())){
                PropertyDescriptor tbPropDesc = new PropertyDescriptor(field.getName(),tb.getClass());
                Method methodRead = tbPropDesc.getReadMethod();
                methodWrite.invoke(vo,methodRead.invoke(tb));
            }
        }
        //返回已经复制好数据的vo。
        return vo;
     }
}
