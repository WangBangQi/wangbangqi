package com.zimo.wangbangqi.service.collectionService;

import com.zimo.wangbangqi.model.collection.GirlClassCollection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlClassCollectionServiceTest {
    @Autowired
    GirlClassCollectionService girlClassCollectionService;


    @Test
    public void addGirlClassCollection() throws Exception {
        GirlClassCollection g = new GirlClassCollection();
        g.setClassId(35);
        g.setGirlId(15);
        girlClassCollectionService.addGirlClassCollection(g);
    }

    @Test
    public void listAllByGirlId() throws Exception {
    }

    @Test
    public void listAllByClassId() throws Exception {
    }

    @Test
    public void searchById() throws Exception {
    }

    @Test
    public void searchByClassIdAndGirlId() throws Exception {
    }

}