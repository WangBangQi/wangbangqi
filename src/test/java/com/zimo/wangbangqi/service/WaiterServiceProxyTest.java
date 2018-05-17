package com.zimo.wangbangqi.service;

import com.zimo.wangbangqi.model.Waiter;
import com.zimo.wangbangqi.service.waiter.WaiterServiceProxy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class WaiterServiceProxyTest {

    @Autowired
    WaiterServiceProxy waiterServiceProxy;

    @Test
    public void save() throws Exception {
        Waiter waiter = new Waiter();
        waiter.setName("弓如霹雳弦惊");
        waiter.setPrice(200.0);
        waiter = waiterServiceProxy.save(waiter);
        assertNotNull("ID不能为空",waiter.getId());
    }

    @Test
    public void searchById() throws Exception {
        waiterServiceProxy.searchById(27);
    }

    @Test
    public void update() throws Exception{
        Waiter waiter1 = waiterServiceProxy.searchById(27);
        Waiter waiter2 = waiterServiceProxy.searchById(27);
        waiterServiceProxy.update(waiter2);
        waiter2 = waiterServiceProxy.searchById(27);
        assertNotNull(waiter2);
        waiter1 = waiterServiceProxy.searchById(27);

    }

}