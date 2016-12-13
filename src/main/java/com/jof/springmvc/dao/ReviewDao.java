package com.jof.springmvc.dao;

import java.math.BigInteger;
import java.util.List;

import com.jof.springmvc.model.Review;

public interface ReviewDao {
	
    Review findById(int id);

    void save(Review comment);

    void deleteById(int id);

    List<Review> findAllReviewByUser(BigInteger source_user_id);
    
    List<Review> findAllReviewAboutUser(BigInteger target_user_id);
    
    List<Review> findAllReviewForGame(int game_id);
}
