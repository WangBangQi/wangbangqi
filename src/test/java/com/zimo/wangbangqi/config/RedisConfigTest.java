package com.zimo.wangbangqi.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisConfigTest {

    @Autowired
    private ValueOperations<String,Object> valueOperations;
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Test
    public void testOps(){
        this.valueOperations.set("zimo","天下第一帅气");
        this.valueOperations.set("wang","My princess");

        Boolean hasKey = redisTemplate.hasKey("wang");
        assertEquals(true,hasKey);
        Object str = valueOperations.get("zimo");
        assertNotNull(str);
        assertEquals("天下第一帅气",str);
    }
}