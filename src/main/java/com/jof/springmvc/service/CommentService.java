package com.jof.springmvc.service;


import com.jof.springmvc.form.CommentForm;
import com.jof.springmvc.model.Comment;
import com.jof.springmvc.model.Review;

import java.sql.Date;
import java.util.List;

public interface CommentService {

    Comment findById(int id);

    void saveComment(Comment comment);

    void updateComment(Comment comment);

    void deleteCommentById(int id);

    List<Comment> findAllCommentsForReview(Review review);

    List<Comment> findCommentsForReviewFromTo(int review_id, Date from, Date to);

    List<CommentForm> findAllCommentFormsForReview(Review review);

}
