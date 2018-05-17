package com.zimo.wangbangqi.utils;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

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
    }
}
