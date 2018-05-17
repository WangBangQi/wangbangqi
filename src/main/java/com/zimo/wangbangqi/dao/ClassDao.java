package com.zimo.wangbangqi.dao;

import com.zimo.wangbangqi.model.Class;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassDao extends JpaRepository<Class,Integer> {

    public Class findByNumber(String number);
    public void deleteByNumber(String number);
}
