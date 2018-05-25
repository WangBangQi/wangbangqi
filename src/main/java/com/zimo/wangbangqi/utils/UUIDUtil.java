package com.zimo.wangbangqi.utils;

import java.util.UUID;

public class UUIDUtil {
    public static String getUUID(){
        return UUID.randomUUID().toString().replaceAll("-","").substring(0,32);
    }
}
