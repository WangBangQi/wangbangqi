package com.zimo.wangbangqi.service;

import com.zimo.wangbangqi.dto.WaiterDto;
import com.zimo.wangbangqi.model.Waiter;
import com.zimo.wangbangqi.service.waiter.WaiterService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WaiterServiceTest {
    @Autowired
    WaiterService waiterService;

    @Test
    public void save() throws Exception {
        Waiter waiter = new Waiter();
        waiter.setAddress("你那儿的?");
        waiter.setAge(19);
        waiter.setName("话");
        waiter.setHeadPic("haosgnammg;ams;gmasg");
        waiter.setPrice(100.0);
        waiter.setSex(true);
        waiter.setFakeServiceCount(3);
        waiter.setIntroduction("自我介绍");
        waiterService.save(waiter);
    }

    @Test
    public void update() throws Exception {
    }

    @Test
    public void searchById() throws Exception {
    }

    @Test
    public void searchDtoById() throws Exception{
        WaiterDto waiterDto =  waiterService.searchDtoById(8);
        assertEquals(new Integer(20),waiterDto.getAge());
    }

}