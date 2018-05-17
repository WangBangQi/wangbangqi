package com.zimo.wangbangqi.service;

import com.zimo.wangbangqi.dto.AdminDto;
import com.zimo.wangbangqi.model.Admin;
import com.zimo.wangbangqi.service.adminService.AdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminServiceTest {

    @Autowired
    AdminService adminService;
    @Autowired


    @Test
    public void save() throws Exception {
        Admin admin = new Admin();
        admin.setAccNum("Happ");
        admin.setRoot(true);
        admin.setDel(false);
        admin.setPassword("aa111111");
        admin.setCreateTime(System.currentTimeMillis());
        admin.setUpdateTime(admin.getCreateTime());
        adminService.save(admin);
    }

    @Test
    public void getAdminDto() throws Exception{
        AdminDto adminDto = adminService.getAdminDto("ssss","aa111111");

    }

}