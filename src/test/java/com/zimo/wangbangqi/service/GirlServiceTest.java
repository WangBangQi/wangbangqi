package com.zimo.wangbangqi.service;

import com.zimo.wangbangqi.model.Girl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

//该注解表示我们要启动test
@RunWith(SpringRunner.class)
//这注解表示将要启动我们的工程
@SpringBootTest
public class GirlServiceTest {
    @Autowired
    private ValueOperations<String,Object> valueOperations;
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Autowired
    private GirlService girlService;

    @Test
    public void girlList() throws Exception {
    }

    @Test
    public void addGirl() throws Exception {

    }

    @Test
    public void searchById() throws Exception {
        Girl girl = new Girl();
        Integer id = 34;
        girl = girlService.searchById(34);
        assertNotNull(girl);
        Assert.assertEquals(new Integer(19),girl.getAge());
    }

    @Test
    public void updateById() throws Exception {
    }

    @Test
    public void deleteById() throws Exception {
    }

    @Test
    public void girlListByAge() throws Exception {
    }

    @Test
    public void girlListByName() throws Exception {
    }

    @Test
    public void getAge() throws Exception {
    }

}