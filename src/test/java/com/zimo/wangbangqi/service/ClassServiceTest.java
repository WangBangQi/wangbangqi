package com.zimo.wangbangqi.service;

import com.zimo.wangbangqi.model.Class;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ClassServiceTest {
    @Autowired
    ClassService classService;



    @Test
    public void addClass() throws Exception {
        Class c = new Class();
        c.setName("数学");
        c.setNumber("12345678");

        classService.addClass(c);
    }

    @Test
    public void getClassByNumber() throws Exception {
    }

    @Test
    public void getClassById() throws Exception {
    }

    @Test
    public void getClassAll() throws Exception {
    }

    @Test
    public void deleteClass() throws Exception {
    }

    @Test
    public void deleteClass1() throws Exception {
    }

}