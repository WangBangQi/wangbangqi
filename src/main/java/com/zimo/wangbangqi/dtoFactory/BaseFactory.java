package com.zimo.wangbangqi.dtoFactory;

import java.beans.IntrospectionException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

import com.sun.tools.javac.util.Context;
import com.zimo.wangbangqi.utils.BaseVoUtil;


/**
 * BaseFactory提取的是PO2DTO的过程，总共有两个部分，第一个部分是PO与DTO中相同的字段的COPY，
 * 第二部分是其他表的字段、对象或者不存在的字段的值的设置。
 *
 * @param <T>   PO
 * @param <V>   DTO
 */

public abstract class BaseFactory <T,V extends Object> implements Context.Factory<T> {
    private T tb;
    private Class<V> clazz;
    private V vo;
    //构造时需要传入PO，与VO的class
    public BaseFactory(T t ,Class<V> clazz) throws InstantiationException, IllegalAccessException {
        this.clazz = clazz;
        this.tb=t;
    }
    //方便复用
    public void setTb(T tb){
        this.tb=tb;
    }

    //调用该方法造一个VO
    public V build() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, IntrospectionException{
        vo = BaseVoUtil.getVo(getTb(), clazz);//普通字段copy
        doOrderThingForVo(vo);//特殊字段注入
        return vo;
    }

    //把需要处理的特殊字段交给子类
    protected abstract void doOrderThingForVo(V vo);

    //给子类提供一个途径可以访问po
    protected T getTb(){
        return this.tb;
    }
}
