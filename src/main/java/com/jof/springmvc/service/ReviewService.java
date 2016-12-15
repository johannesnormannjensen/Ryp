package com.jof.springmvc.service;

import com.jof.springmvc.model.Review;
import com.jof.springmvc.model.User;

import java.util.List;

public interface ReviewService {


    Review findById(int id);

    void saveReview(Review review);

    void updateReview(Review review);

    void deleteById(int id);

    List<Review> findAllReviewByUser(User source_user_id);

    List<Review> findAllReviewAboutUser(User target_user_id);

    List<Review> findAllReviewForGame(int game_id);

}
