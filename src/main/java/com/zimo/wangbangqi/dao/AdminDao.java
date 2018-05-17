package com.zimo.wangbangqi.dao;

import com.zimo.wangbangqi.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminDao extends JpaRepository<Admin ,Integer>{
    public Admin findByAccNum(String accNum);
}
