package com.jof.springmvc.service;

import com.jof.springmvc.dao.CommentDao;
import com.jof.springmvc.form.CommentForm;
import com.jof.springmvc.model.Comment;
import com.jof.springmvc.model.Review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.ArrayList;
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
            entity.setActive(comment.isActive());
        }
    }

    public void deleteCommentById(int id) {
        dao.deleteById(id);
    }

    public List<Comment> findAllCommentsForReview(Review review_id) {
        return dao.findAllCommentsForReview(review_id);
    }

	@Override
	public List<Comment> findCommentsForReviewFromTo(int review_id, Date from, Date to) {
		return dao.findCommentsForReviewFromTo(review_id, from, to);
	}

	@Override
	public List<CommentForm> findAllCommentFormsForReview(Review review) {
		List<Comment> comments = findAllCommentsForReview(review);
		List<CommentForm> forms = new ArrayList<CommentForm>();
		for(int i= 0;i < comments.size();i++)
		{
			CommentForm form = new CommentForm();
			form.setBody(comments.get(i).getBody());
			form.setCreated_at(comments.get(i).getCreated_at());
			form.setUsername(comments.get(i).getCreated_by().getUsername());
			forms.add(form);
		}
		return forms;
	}
}
