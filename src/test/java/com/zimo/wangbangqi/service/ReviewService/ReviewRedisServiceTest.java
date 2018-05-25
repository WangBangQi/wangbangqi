package com.zimo.wangbangqi.service.ReviewService;

import com.zimo.wangbangqi.model.Review;
import com.zimo.wangbangqi.utils.StringKeyUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ReviewRedisServiceTest {
    @Autowired
    ReviewRedisService reviewRedisService;

    private String key(Integer waiterId){
        return StringKeyUtil.buildKey(Review.class,waiterId);
    }

    @Test
    public void addReview() throws Exception {
        Review review = new Review();
        review.setWaiterId(27);
        review.setContent("天何芳草32446");

        reviewRedisService.addReview(key(review.getWaiterId()),review);
    }

    @Test
    public void listReviewByWaiterId() throws Exception {
    }

    @Test
    public void getListLen() throws Exception {
        List<Review> reviews = reviewRedisService.listReviewByKey(key(27),1,8);
        assertNotNull(reviews);
        for (Review review : reviews){
            assertEquals(new Integer(27),review.getWaiterId());
            System.out.println("ID:"+review.getWaiterId()+"\nContent:"+review.getContent());
        }
    }

    @Test
    public void deleteAll()throws Exception{
        Review review = new Review();
        review.setWaiterId(27);
        review.setContent("天涯何处");
        reviewRedisService.delete(key(27),review);
    }
}