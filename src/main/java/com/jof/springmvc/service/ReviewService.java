package com.jof.springmvc.service;

import com.jof.springmvc.model.Review;

import java.util.List;

public interface ReviewService {

	
	    Review findById(int id);

	    void saveReview(Review review);	    

	    void updateReview(Review review);

	    void deleteById(int id);

	    List<Review> findAllReviewByUser(Long source_user_id);
	    
	    List<Review> findAllReviewAboutUser(Long target_user_id);
	    
	    List<Review> findAllReviewForGame(int game_id);
	    
}
