package com.jof.springmvc.service;

import com.jof.springmvc.dao.ReviewDao;
import com.jof.springmvc.model.Review;
import com.jof.springmvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("reviewService")
@Transactional
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewDao dao;

    @Override
    public Review findById(int id) {
        return dao.findById(id);
    }

    @Override
    public void saveReview(Review review) {
        dao.save(review);

    }

    @Override
    public void updateReview(Review review) {
        Review entity = dao.findById(review.getId());
        if (entity != null) {
            entity.setSource_user_id(review.getSource_user_id());
            entity.setTarget_user_id(review.getTarget_user_id());
            entity.setTitle(review.getTitle());
            entity.setGame_id(review.getGame_id());
            entity.setBody(review.getBody());
        }

    }

    @Override
    public void deleteById(int id) {

        Review review = findById(id);
        review.setActive(false);
        updateReview(review);

        //we just set them as inactive
        //dao.deleteById(id);
    }

    @Override
    public List<Review> findAllReviewByUser(User source_user) {
        return dao.findAllReviewByUser(source_user);
    }

    @Override
    public List<Review> findAllReviewAboutUser(Long target_user) {
        return dao.findAllReviewAboutUser(target_user);
    }

    @Override
    public List<Review> findAllReviewForGame(int game_id) {
        return dao.findAllReviewForGame(game_id);
    }

}
