package com.zimo.wangbangqi.enums;

import java.util.concurrent.TimeUnit;

public class DefaultValue {
    public static final TimeUnit REDIS_TIME_UNIT = TimeUnit.MINUTES;
    public static final TimeUnit WAITER_REDIS_TIME_UNIT = TimeUnit.MINUTES;

    public static final Integer GIRL_WORK_TIME = 5;
    public static final String  GIRL_CUP_SIZE = "B";
    public static final Double  GIRL_MONEY = 0.0;
    public static final String GIRL_STATUS= GirlStatusEnum.NORMAL.getValue();
}
