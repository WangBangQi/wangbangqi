package com.zimo.wangbangqi.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.Assert.*;

/**
 * API 的Test
 *
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GirlControllerTest {



    @Autowired
    private MockMvc mvc;

    @Test
    public void addGirl()throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/girls/girlDto/","name='小女'","age=20","workTime=5"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void girlListByName() throws Exception {
//        mvc.perform(MockMvcRequestBuilders.get("/girls/name","name='小红'"))
//                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void getGirlDtoById() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/girls/getGirlDto/{id}",15))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void searchGirlById() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/girls/{id}",1))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    public void getAge() throws Exception {
    }

    @Test
    public void girlListAll() throws Exception {
        /**
         * MockMvcRequestBuilders.get("girls")  构建url请求。
         * andExpect(MockMvcResultMatchers.status().isOk())     //期望状态码是200
         */
        mvc.perform(MockMvcRequestBuilders.get("/girls"))
                .andExpect(MockMvcResultMatchers.status().isOk());
//                .andExpect(MockMvcResultMatchers.content().string("abd"));
    }

}
