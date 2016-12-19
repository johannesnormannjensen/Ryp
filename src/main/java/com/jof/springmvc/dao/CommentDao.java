package com.jof.springmvc.dao;

import com.jof.springmvc.model.Comment;
import com.jof.springmvc.model.Review;

import java.sql.Date;
import java.util.List;

public interface CommentDao {

    Comment findById(int id);

    void save(Comment comment);

    void deleteById(int id);

    List<Comment> findAllCommentsForReview(Review review_id);

    List<Comment> findCommentsForReviewFromTo(int review_id, Date from, Date to);

}