package com.jof.springmvc.service;


import java.util.List;

import com.jof.springmvc.model.Comment;

public interface CommentService {

	   Comment findById(int id);
	    
	    void saveComment(Comment comment);

	    void updateComment(Comment comment);

	    void deleteCommentById(int id);

	    List<Comment> findAllCommentsForReview(int id);

}
