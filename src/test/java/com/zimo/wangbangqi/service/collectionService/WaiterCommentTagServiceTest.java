package com.zimo.wangbangqi.service.collectionService;

import com.zimo.wangbangqi.model.collection.WaiterCommentTagCollection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class WaiterCommentTagServiceTest {

    @Autowired
    WaiterCommentTagService wctService;

    @Test
    public void listALLByWaiterId() throws Exception {
    }

    @Test
    public void save() throws Exception {
        WaiterCommentTagCollection waiterCommentTagCollection = new WaiterCommentTagCollection();
        waiterCommentTagCollection.setWaiterId(8);
        waiterCommentTagCollection.setCommentTagId(6);
        wctService.save(waiterCommentTagCollection);
    }

}