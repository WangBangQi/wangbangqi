package com.zimo.wangbangqi.controller;

import com.zimo.wangbangqi.dto.AdminDto;
import com.zimo.wangbangqi.model.Result;
import com.zimo.wangbangqi.service.AccessTokenService;
import com.zimo.wangbangqi.service.ReviewService.ReviewService;
import com.zimo.wangbangqi.service.adminService.AdminService;
import com.zimo.wangbangqi.utils.ResultUtil;
import com.zimo.wangbangqi.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService adminService;

    @Autowired
    ReviewService reviewService;
    @Autowired
    AccessTokenService accessTokenService;

    @PostMapping(value = "/login")
    public Result adminLogin(@RequestParam(value = "accNum")String accNum,
                             @RequestParam(value = "password")String password)throws Exception{
        AdminDto adminDto  = adminService.getAdminDto(accNum,password);
        Map<String,Object> claims = new HashMap<>();
        claims.put("name",adminDto.getAccNum());
        claims.put("id",adminDto.getId());
        claims.put("admin",true);
        String token = TokenUtils.createToken(claims);
        System.out.println(token);
        //传送给客户端。
        adminDto.setToken(token);
        //本地保存
        accessTokenService.save(token);
        return ResultUtil.success(adminDto);
    }

    @GetMapping(value = "getAll")
    public Result getAllAdmin(){
        return ResultUtil.success(adminService.getAll());
    }

}

