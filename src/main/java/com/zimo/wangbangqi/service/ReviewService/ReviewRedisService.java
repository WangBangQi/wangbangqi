package com.zimo.wangbangqi.service.ReviewService;

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

    private String buildKey(Integer waiterId){
        return StringKeyUtil.buildKey(Review.class,waiterId);
    }
    //新增一评论
    public void addReview(Review review){
        operations.leftPush(buildKey(review.getWaiterId()),review);
    }
    //返回最新的20条评论
    public List<Review> listReviewByWaiterId(Integer waiterId,Integer start,Integer stop) {
       return operations.range(buildKey(waiterId),start.longValue(),stop.longValue());
    }

    public Integer getListLen(Integer waiterId){
        return operations.size(buildKey(waiterId)).intValue();
    }
}
