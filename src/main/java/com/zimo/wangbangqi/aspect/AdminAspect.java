package com.zimo.wangbangqi.aspect;

import com.zimo.wangbangqi.service.adminService.AdminService;
import com.zimo.wangbangqi.utils.SpringUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AdminAspect {
    private static final Logger logger = LoggerFactory.getLogger(AdminAspect.class);

    @Pointcut("execution(public * com.zimo.wangbangqi.controller.Admin*.*(..))")
    public void login(){}

    @After("login()")
    public void loginBefore(){

    }
}
