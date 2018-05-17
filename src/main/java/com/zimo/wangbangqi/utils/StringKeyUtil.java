package com.zimo.wangbangqi.utils;

import java.lang.reflect.Method;

public class StringKeyUtil {
    public static String buildKey (Class tClass, Object... params){
        StringBuilder str = new StringBuilder();
        str.append(tClass.getName());
        for (Object param : params){
            if (param != null)
                str.append(":"+param);
        }
        return str.toString();
    }
}
