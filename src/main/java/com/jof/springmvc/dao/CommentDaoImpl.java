package com.jof.springmvc.dao;

import com.jof.springmvc.model.Comment;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("commentDao")
public class CommentDaoImpl extends AbstractDao<Integer, Comment> implements CommentDao {

    static final Logger logger = LoggerFactory.getLogger(CommentDaoImpl.class);

    public Comment findById(int id) {
        Comment comment = getByKey(id);
       
        return comment;
    }    

    @SuppressWarnings("unchecked")
    public List<Comment> findAllCommentsForReview(int review_id) 
    {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("created_at"));
        criteria.add(Restrictions.eq("review_id", review_id));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<Comment> comments = (List<Comment>) criteria.list();
       
        return comments;
    }

    public void save(Comment comment) {
        persist(comment);
    }

    public void deleteById(int id) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("id", id));
        Comment comment = (Comment) crit.uniqueResult();
        delete(comment);
    }

}