package com.zimo.wangbangqi.service;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.zimo.wangbangqi.dao.AccessTokenDao;
import com.zimo.wangbangqi.model.AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;


@Service
public class AccessTokenService {
    @Autowired
    AccessTokenDao accessTokenDao;

    public AccessToken getAccessTokenById(Integer id){
        Assert.notNull(id,"The given id can not be null !");
        return accessTokenDao.findById(id).get();
    }
    public void delete(Integer id){
        accessTokenDao.deleteById(id);
    }
    public void delete(String token){
        accessTokenDao.deleteByToken(token);
    }

    public String getTokenById(Integer id){
        return getAccessTokenById(id).getToken();
    }
    public AccessToken save(AccessToken accessToken){
        return accessTokenDao.save(accessToken);
    }
    public AccessToken save(String token){
        if (tokenExist(token))
            return null;
        AccessToken accessToken = new AccessToken();
        accessToken.setToken(token);
        return save(accessToken);
    }


    public Boolean tokenExist(Integer id ,String token){
        Assert.notNull(token,"The token can not be null！");
        if(id == null)
            return false;
        AccessToken accessToken = getAccessTokenById(id);
        if (accessToken == null)
            return false;
        if (!token.equals(accessToken.getToken()))
            return false;
        return true;
    }
    public Boolean tokenExist(AccessToken accessToken){
        return  this.tokenExist(accessToken.getId(),accessToken.getToken());
    }
    public Boolean tokenExist(String token){
        AccessToken accessToken = accessTokenDao.findByToken(token);
        if (accessToken == null)
            return false;
        return true;
    }


}
