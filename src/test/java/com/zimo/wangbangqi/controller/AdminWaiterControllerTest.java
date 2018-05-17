package com.zimo.wangbangqi.controller;

import com.zimo.wangbangqi.dto.WaiterDto;
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

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AdminWaiterControllerTest {


    @Autowired
    private MockMvc mvc;

    @Test
    public void searchById() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/admin/{adminId}/waiter/{waiterId}",12,8))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void updateWaiterDto() throws Exception {
        WaiterDto waiterDto = new WaiterDto();
        waiterDto.setId(8);
        waiterDto.setAge(111);
        mvc.perform(MockMvcRequestBuilders.put("/admin/{adminId}/waiter",12,waiterDto))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}