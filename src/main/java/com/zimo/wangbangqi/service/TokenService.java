package com.zimo.wangbangqi.service;

import com.zimo.wangbangqi.model.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *在token中，加入时间戳和签名。即可对请求进行验证。
 */
@Service
public class TokenService {

    @Autowired
    private ListOperations listOperations;

    private static final String  key= "TOKEN_LIST_KEY";

    public void add(String token){
        long insertTimestamp = System.currentTimeMillis()/1000;
        Token redisToken = new Token();
        redisToken.setToken(token);
        redisToken.setExp(insertTimestamp);
        listOperations.leftPush(key,redisToken);
    }

    /**
     * 对list进行修剪。
     * @param count 要保留的list的个数
     */
    public void delete(Long count){
        //当count为0时
        //当count为1时
        listOperations.trim(key,0,count-1);
    }

    //用户定时清理超出有效时间的token
    public List<Token> listToken(){
        List<Token> list = listOperations.range(key,0,listOperations.size(key));
        return list;
    }

}
