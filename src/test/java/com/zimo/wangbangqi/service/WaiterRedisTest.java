package com.zimo.wangbangqi.service;

import com.zimo.wangbangqi.model.Waiter;
import com.zimo.wangbangqi.service.waiter.WaiterRedis;
import com.zimo.wangbangqi.service.waiter.WaiterService;
import com.zimo.wangbangqi.utils.StringKeyUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class WaiterRedisTest {
    @Autowired
    WaiterRedis waiterRedis;
    @Autowired
    WaiterService waiterService;

    @Test
    public void addWaiter() throws Exception {
        Waiter waiter = new Waiter();
        waiter.setAddress("tianxia?");
        waiter.setAge(19);
        waiter.setName("话");
        waiter.setHeadPic("haosgnammg;ams;gmasg");
        waiter.setPrice(100.0);
        waiter.setSex(true);
        waiter.setFakeServiceCount(3);
        waiter.setIntroduction("自我介绍");
        waiter = waiterService.save(waiter);
        String key = StringKeyUtil.buildKey(Waiter.class,waiter.getId());
        waiterRedis.addWaiter(key,waiter);

    }

    @Test
    public void getByKey() throws Exception {
        String key = StringKeyUtil.buildKey(Waiter.class,27);
        Waiter waiter = waiterRedis.getByKey(key);

        assertEquals(new Integer(19),waiter.getAge());

    }
    @Test
    public void add()throws Exception{
        Waiter waiter = waiterService.searchById(27);
        String key = StringKeyUtil.buildKey(Waiter.class,27);
        waiterRedis.addWaiter(key,waiter);
        waiter = waiterRedis.getByKey(key);
        assertNotNull(waiter);
    }


}