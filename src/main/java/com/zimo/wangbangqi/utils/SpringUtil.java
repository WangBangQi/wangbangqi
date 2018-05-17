package com.zimo.wangbangqi.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 这样我们就可以实现基本的数据封装，那我们如何获取那些该PO里面没有，又存在另外一个表的字段值呢？
 * 使用SpringUtil
 * 这个没有什么特殊性，只要完全抄过去的可以了，然后在spring配置文件中注册就可以用了，用途是取spring对象池里面的对象
 */

@Component
public class SpringUtil implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if(SpringUtil.applicationContext == null)
            SpringUtil.applicationContext = applicationContext;
    }
    //通过class获取bean
    public static<T> T getBean(Class<T> tClass){
        return applicationContext.getBean(tClass);
    }


    //通过名字获取bean
    public static Object getBean(String name){
        return applicationContext.getBean(name);
    }

    //通过name,以及Clazz返回指定的Bean
    public static <T> T getBean(String name,Class<T> clazz){
        return applicationContext.getBean(name, clazz);
    }
}
