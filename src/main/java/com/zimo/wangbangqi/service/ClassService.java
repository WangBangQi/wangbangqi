package com.zimo.wangbangqi.service;

import com.zimo.wangbangqi.dao.ClassDao;
import com.zimo.wangbangqi.model.Class;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassService {
    @Autowired
    private ClassDao classDao;

    public Class addClass(Class c){
        return classDao.save(c);
    }

    public Class getClassByNumber(String number){
        return classDao.findByNumber(number);
    }
    public Class getClassById(Integer id){
        return classDao.findById(id).get();
    }
    public List<Class> getClassAll(){
        return classDao.findAll();
    }
    public void deleteClass(Integer id){
        classDao.deleteById(id);
    }
    public void deleteClass(String number){
        classDao.deleteByNumber(number);
    }

}
