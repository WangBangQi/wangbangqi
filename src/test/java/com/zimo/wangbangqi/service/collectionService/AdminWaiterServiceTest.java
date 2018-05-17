package com.zimo.wangbangqi.service.collectionService;

import com.zimo.wangbangqi.model.collection.AdminWaiterCollection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminWaiterServiceTest {

    @Autowired
    AdminWaiterService adminWaiterService;

    @Test
    public void save() throws Exception {
        AdminWaiterCollection adminWaiterCollection = new AdminWaiterCollection();
        adminWaiterCollection.setAdminId(12);
        adminWaiterCollection.setWaiterId(8);
        adminWaiterCollection.setCreateTime(System.currentTimeMillis());
        adminWaiterService.save(adminWaiterCollection);
    }

}