package com.zimo.wangbangqi.service;

import com.zimo.wangbangqi.model.Token;
import com.zimo.wangbangqi.utils.TokenUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class TokenServiceTest {
    @Autowired
    TokenService tokenService;


    @Test
    public void add() throws Exception {
        for (int i = 0;i<15;i++)
        {
            Map<String,Object > map = new HashMap<>();
            map.put("name","ZiMo"+i);
            map.put("admin",true & (i%2==0));
            String token = TokenUtils.createToken(map);
            tokenService.add(token);
            Thread.sleep(1000);
        }

    }

    @Test
    public void delete() throws Exception {
        tokenService.delete(new Long(15));
    }

    @Test
    public void listToken() throws Exception {
        List<Token > list = tokenService.listToken();
        for (Token token : list){

        }
        assertNotNull(list);
    }

}