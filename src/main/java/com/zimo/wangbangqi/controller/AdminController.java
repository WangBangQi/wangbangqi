package com.zimo.wangbangqi.controller;

import com.zimo.wangbangqi.model.Result;
import com.zimo.wangbangqi.service.adminService.AdminService;
import com.zimo.wangbangqi.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService adminService;

    @PostMapping(value = "/login")
    public Result adminLogin(@RequestParam(value = "accNum")String accNum,
                             @RequestParam(value = "password")String password)throws Exception{
        return ResultUtil.success(adminService.getAdminDto(accNum,password));
    }

}
