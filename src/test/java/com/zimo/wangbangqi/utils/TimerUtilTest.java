package com.zimo.wangbangqi.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class TimerUtilTest {
    @Autowired
    TimerUtil timerUtil;
    @Test
    public void showTime() throws Exception {
        for (int i=0;i<5;i++){
            timerUtil.showTime();
            Thread.sleep(1000);
        }

    }

}