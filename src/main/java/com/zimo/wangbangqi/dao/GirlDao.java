package com.zimo.wangbangqi.dao;

import com.zimo.wangbangqi.model.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GirlDao extends JpaRepository<Girl,Integer> {

    //通过年龄查询
    public List<Girl> findByAge(Integer age);

    public List<Girl> findByName(String name);

    //模糊查询，传递的name = “%” + name + “%”;
    public List<Girl> findAllByNameLike(String name);

    public List<Girl> findByAgeAndCupSize(Integer age,String cupSize);

}
