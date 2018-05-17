package com.zimo.wangbangqi.service;

import com.zimo.wangbangqi.dao.CommentTagDao;
import com.zimo.wangbangqi.model.CommentTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentTagService {
    @Autowired
    private CommentTagDao commentTagDao;

    public CommentTag searchById(Integer id){
        return commentTagDao.findById(id).get();
    }
    public CommentTag save(CommentTag commentTag){
        return commentTagDao.save(commentTag);
    }

    public List<CommentTag> listAll(){
        return commentTagDao.findAll();
    }

}
