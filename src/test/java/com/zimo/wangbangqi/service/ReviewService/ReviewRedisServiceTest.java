package com.zimo.wangbangqi.service.ReviewService;

import com.zimo.wangbangqi.model.Review;
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

    @Test
    public void addReview() throws Exception {
        Review review = new Review();
        review.setWaiterId(27);
        review.setContent("天何芳草32446");
        reviewRedisService.addReview(review);
    }

    @Test
    public void listReviewByWaiterId() throws Exception {
    }

    @Test
    public void getListLen() throws Exception {
        List<Review> reviews = reviewRedisService.listReviewByWaiterId(27,3,3);
        assertNotNull(reviews);
        for (Review review : reviews){
            assertEquals(new Integer(27),review.getWaiterId());
            System.out.println("ID:"+review.getWaiterId()+"\nContent:"+review.getContent());
        }
    }

}