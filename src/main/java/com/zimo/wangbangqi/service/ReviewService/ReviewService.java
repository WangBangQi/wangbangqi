package com.zimo.wangbangqi.service.ReviewService;

import com.zimo.wangbangqi.dao.ReviewDao;
import com.zimo.wangbangqi.exception.JudgeException;
import com.zimo.wangbangqi.model.Review;
import com.zimo.wangbangqi.utils.StringKeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

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

    private String buildKey(Integer waiterId){
        return StringKeyUtil.buildKey(Review.class,waiterId);
    }
    /**
     * 由于已经提交到后台的评论不会再出现更改的情况，
     * 所以在保存评论后，会将该评论放入缓存内。
     * @param review
     * @return
     */
    @Transactional
    public Review save(Review review){
        Assert.isNull(review.getId(),"The new element's id must be null!");
        //增加稳定性。
//        if(review.getId() != null)
//            throw new JudgeException("新增对象的id应该为空");
        Review reviewRedis = reviewDao.save(review);

        reviewRedisService.addReview(buildKey(reviewRedis.getWaiterId()),reviewRedis);
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
        Assert.notNull(waiterId,"The given waiterId must not be null !");
        String key = buildKey(waiterId);
        return reviewRedisService.listReviewByKey(key,(pageNo-1)*pageSize,(pageNo-1)*pageSize+pageSize-1);
    }

    /**
     * 获取队列长度
     * @param waiterId
     * @return
     */
    public Integer getListLen(Integer waiterId){
        return reviewRedisService.getListLen(buildKey(waiterId));
    }

    public Boolean  idIsExist(Integer id){
        return reviewDao.findById(id).get()==null? false : true;
    }
}
