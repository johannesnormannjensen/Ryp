package com.jof.springmvc.service;

import java.math.BigInteger;
import java.util.List;

import com.jof.springmvc.model.Review;

public interface ReviewService {

	
	    Review findById(int id);

	    void saveReview(Review review);	    

	    void updateReview(Review review);

	    void deleteById(int id);

	    List<Review> findAllReviewByUser(BigInteger source_user_id);
	    
	    List<Review> findAllReviewAboutUser(BigInteger target_user_id);
	    
	    List<Review> findAllReviewForGame(int game_id);
	    
}
