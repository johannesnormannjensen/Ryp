package com.jof.springmvc.dao;

import com.jof.springmvc.model.Review;

import java.util.List;

public interface ReviewDao {
	
    Review findById(int id);

    void save(Review comment);

    void deleteById(int id);

    List<Review> findAllReviewByUser(Long source_user_id);
    
    List<Review> findAllReviewAboutUser(Long target_user_id);
    
    List<Review> findAllReviewForGame(int game_id);
}
