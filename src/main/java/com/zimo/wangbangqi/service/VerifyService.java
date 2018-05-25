package com.zimo.wangbangqi.service;

import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

/**
 * 短信验证码的校验
 */
@Service
public class VerifyService {
    private static final String url = "";
    private static final Pattern pattern = Pattern.compile("^1[3|4|5|7|8]\\d{9}$");


}
