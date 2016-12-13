package com.jof.springmvc.dao;

import com.jof.springmvc.model.Comment;
import java.util.List;

public interface CommentDao {

    Comment findById(int id);

    void save(Comment comment);

    void deleteById(int id);

    List<Comment> findAllCommentsForReview(int review_id);

}