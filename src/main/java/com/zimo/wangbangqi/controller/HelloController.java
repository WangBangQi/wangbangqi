package com.zimo.wangbangqi.controller;

import com.zimo.wangbangqi.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    GirlProperties girlProperties;

    /**
     * 通过hello,hi都能访问到这个方法
     * @return
     */
    @RequestMapping(value = {"hello","hi"} ,method = RequestMethod.GET)
    public String say(){

        return girlProperties.getCupSize();
    }
}
