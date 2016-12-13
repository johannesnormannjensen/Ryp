package com.jof.springmvc.service;

import com.jof.springmvc.dao.CommentDao;
import com.jof.springmvc.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("commentService")
@Transactional
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentDao dao;

	public Comment findById(int id) {
		return dao.findById(id);
	}

	public void saveComment(Comment user) {

		dao.save(user);
	}

	/*
	 * Since the method is running with Transaction, No need to call hibernate
	 * update explicitly. Just fetch the entity from db and update it with
	 * proper values within transaction. It will be updated in db once
	 * transaction ends.
	 */
	public void updateComment(Comment comment) {
		Comment entity = dao.findById(comment.getId());
		if (entity != null) {
			entity.setBody(comment.getBody());
		}
	}

	public void deleteCommentById(int id) {
		dao.deleteById(id);
	}

	public List<Comment> findAllCommentsForReview(int review_id) {
		return dao.findAllCommentsForReview(review_id);
	}
}
