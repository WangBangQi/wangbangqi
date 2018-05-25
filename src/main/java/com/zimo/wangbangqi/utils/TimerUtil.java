package com.zimo.wangbangqi.utils;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Component
public class TimerUtil {
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("HH:mm:ss");
    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy'年'MM'月'dd'号' , HH'时'mm'分'ss'秒'SS'' z");
    /**
     * 每三秒执行一次
     */
    @Scheduled(fixedRate = 3000)
    public void showTime(){
        System.out.println("现在时间：" +DATE_FORMAT.format(new Date()));
        System.out.println("精确时间: "+SIMPLE_DATE_FORMAT.format(new Date()));
        String str = UUID.randomUUID().toString();
//        System.out.println(str.substring(0,32));
//        //将字符串中的“-”，替换成“”;
////      f1baaa24-591a-44fb-b7d6-5c5c3f75
////      f1baaa24591a44fbb7d65c5c3f752714
//        System.out.println(str.replaceAll("-","").substring(0,32));
    }
}
