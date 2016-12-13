package com.jof.springmvc.dao;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.jof.springmvc.model.Friend;
import com.jof.springmvc.model.User;

@Repository("friendDao")
public class FriendDaoImpl extends AbstractDao<Integer, Friend> implements FriendDao {

	 static final Logger logger = LoggerFactory.getLogger(FriendDaoImpl.class);
	
	@Override
	public Friend findFriendshipByIds(BigInteger id_alpha, BigInteger id_omega) {
		
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("aplha_user_id"));
		criteria.add(Restrictions.eq("aplha_user_id", id_alpha));
		criteria.add(Restrictions.eq("omega_user_id", id_omega));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);// To avoid  duplicates.
		
		Friend friends = (Friend) criteria.uniqueResult();
		
		return friends;
	}

	@Override
	public void save(Friend friend) {
		 persist(friend);
	}

	@Override
	public void deleteByIds(BigInteger alpha_id,BigInteger omega_id) {
		Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("alpha_user_id", alpha_id));
        crit.add(Restrictions.eq("omega_user_id", omega_id));
        Friend friend = (Friend) crit.uniqueResult();
        delete(friend);
	}

	@Override
	public List<Friend> findAllFriends(User user) {
		 Criteria criteria = createEntityCriteria().addOrder(Order.asc("id"));
	        criteria.add(Restrictions.eq("alpha_user_id", user.getId()));
	        criteria.add(Restrictions.eq("accepted", true));
	        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
	        List<Friend> friends = (List<Friend>) criteria.list();
	      
	        return friends;
	}
}
