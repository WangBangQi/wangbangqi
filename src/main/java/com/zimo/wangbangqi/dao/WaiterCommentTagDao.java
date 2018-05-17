package com.zimo.wangbangqi.dao;

import com.zimo.wangbangqi.model.collection.WaiterCommentTagCollection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WaiterCommentTagDao extends JpaRepository<WaiterCommentTagCollection,Integer> {

    public List<WaiterCommentTagCollection> findAllByWaiterId(Integer waiterId);
    public List<WaiterCommentTagCollection> findAllByCommentTagId(Integer commentTagId);
    public WaiterCommentTagCollection findByCommentTagIdAndWaiterId(Integer commentTagId, Integer waiterId);
}
