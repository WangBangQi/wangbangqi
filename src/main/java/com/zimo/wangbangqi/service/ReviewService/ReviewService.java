package com.zimo.wangbangqi.service.ReviewService;

import com.zimo.wangbangqi.dao.ReviewDao;
import com.zimo.wangbangqi.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public class ReviewService {

    @Autowired
    ReviewDao reviewDao;
    @Autowired
    ReviewRedisService reviewRedisService;

    /**
     * 由于已经提交到后台的评论不会再出现更改的情况，
     * 所以在保存评论后，会将该评论放入缓存内。
     * @param review
     * @return
     */
    public Review save(Review review){
        Review reviewRedis = reviewDao.save(review);
        reviewRedisService.addReview(reviewRedis);
        return reviewRedis;
    }

    /**
     * 目前不对外提供该服务
     * @param id
     */
    public void deleteById(Integer id){
        reviewDao.deleteById(id);
    }

    /**
     * 返回查询的结果集,从缓存中查询
     * @param waiterId
     * @param pageNo
     * @param pageSize
     * @return
     */
    public List<Review> listByWaiterId(Integer waiterId,Integer pageNo,Integer pageSize){
        return reviewRedisService.listReviewByWaiterId(waiterId,(pageNo-1)*pageSize,(pageNo-1)*pageSize+pageSize-1);
    }

    /**
     * 获取队列长度
     * @param waiterId
     * @return
     */
    public Integer getListLen(Integer waiterId){
        return reviewRedisService.getListLen(waiterId);
    }
}
