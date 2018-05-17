package com.zimo.wangbangqi.service;

import com.zimo.wangbangqi.model.CommentTag;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentTagServiceTest {
    @Autowired
    CommentTagService commentTagService;

    @Test
    public void searchById() throws Exception {
        CommentTag commentTag = commentTagService.searchById(5);
        assertEquals("天涯第一",commentTag.getContent());
    }

    @Test
    public void save() throws Exception {
        CommentTag commentTag = new CommentTag();
        commentTag.setContent("天外飞仙");
        commentTagService.save(commentTag);
    }

}