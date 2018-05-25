package com.zimo.wangbangqi.dao;

import com.zimo.wangbangqi.model.AccessToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccessTokenDao extends JpaRepository<AccessToken,Integer> {
    public AccessToken findByToken(String token);
    public void deleteByToken(String token);
}

