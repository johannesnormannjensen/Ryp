package com.jof.springmvc.dao;

import com.jof.springmvc.model.Review;
import com.jof.springmvc.model.User;

import java.util.List;

public interface ReviewDao {

    Review findById(int id);

    void save(Review comment);

    void deleteById(int id);

    List<Review> findAllReviewByUser(User source_user);

    List<Review> findAllReviewAboutUser(Long target_user);

    List<Review> findAllReviewForGame(int game_id);
}
