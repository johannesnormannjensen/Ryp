package com.jof.springmvc.dao;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.jof.springmvc.model.Review;


@Repository("reviewDao")
public class ReviewDaoImpl extends AbstractDao<Integer, Review> implements ReviewDao {

    static final Logger logger = LoggerFactory.getLogger(ReviewDaoImpl.class);

    public Review findById(int id) {
    	Review review = getByKey(id);
        
        return review;
    }
    
    public void save(Review review) {
        persist(review);
    }

    public void deleteById(int id) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("id", id));
        Review review = (Review) crit.uniqueResult();
        delete(review);
    }
  
    @SuppressWarnings("unchecked")
    public List<Review> findAllReviewByUser(BigInteger source_user_id) {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("id"));
        criteria.add(Restrictions.eq("source_user_id", source_user_id));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<Review> reviews = (List<Review>) criteria.list();

      
        return reviews;
    }
    
    @SuppressWarnings("unchecked")
    public List<Review> findAllReviewAboutUser(BigInteger target_user_id) {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("id"));
        criteria.add(Restrictions.eq("target_user_id", target_user_id));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<Review> reviews = (List<Review>) criteria.list();

      
        return reviews;
    }
    
    @SuppressWarnings("unchecked")
    public List<Review> findAllReviewForGame(int game_id) {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("id"));
        criteria.add(Restrictions.eq("game_id", game_id));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<Review> reviews = (List<Review>) criteria.list();

      
        return reviews;
    }

}