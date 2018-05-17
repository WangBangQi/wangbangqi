package com.zimo.wangbangqi.dao;

import com.zimo.wangbangqi.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewDao extends JpaRepository<Review,Integer> {
    public List<Review> findAllByWaiterId(Integer waiterId);
}
