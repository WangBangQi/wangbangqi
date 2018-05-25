package com.zimo.wangbangqi.service.ReviewService;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.zimo.wangbangqi.model.Review;
import com.zimo.wangbangqi.utils.StringKeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewRedisService {

    @Autowired
    private ListOperations operations;

    //新增一评论
    public void addReview(String key,Review review){
        operations.leftPush(key,review);
    }
    //返回最新的20条评论
    public List<Review> listReviewByKey(String key,Integer start,Integer stop) {
       return operations.range(key,start.longValue(),stop.longValue());
    }

    public Integer getListLen(String key){
        return operations.size(key).intValue();
    }
    public void delete(String key,Review review){
        operations.remove(key,new Integer(6).longValue(),review);
    }


}
