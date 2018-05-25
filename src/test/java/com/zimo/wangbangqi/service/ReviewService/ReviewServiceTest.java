package com.zimo.wangbangqi.service.ReviewService;

import com.zimo.wangbangqi.model.Review;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReviewServiceTest {
    @Autowired
    ReviewService reviewService;

    @Test
    public void save() throws Exception {
        for (int i = 0;i<6;i++){
            Review review = new Review();
            review.setWaiterId(8);
            review.setContent("大家好的的规划"+i);
            reviewService.save(review);
        }

    }

    @Test
    public void deleteById() throws Exception {

    }

    @Test
    public void listByWaiterId() throws Exception {
    }

    @Test
    public void getListLen() throws Exception {
    }

}