package com.jof.springmvc.dao;

import com.jof.springmvc.model.Friend;
import com.jof.springmvc.model.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("friendDao")
public class FriendDaoImpl extends AbstractDao<Integer, Friend> implements FriendDao {

    static final Logger logger = LoggerFactory.getLogger(FriendDaoImpl.class);

    @Override
    public Friend findFriendshipByIds(User id_alpha, User id_omega) {

        Criteria criteria = createEntityCriteria().addOrder(Order.asc("alpha_user_id"));
        criteria.add(Restrictions.eq("alpha_user_id", id_alpha));
        criteria.add(Restrictions.eq("omega_user_id", id_omega));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);// To avoid  duplicates.

        Friend friends = (Friend) criteria.uniqueResult();

        return friends;
    }

    @Override
    public void save(Friend friend) {
        persist(friend);
    }

    
    public void deleteByIds(User alpha_user, User omega_user) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("alpha_user_id", alpha_user));
        crit.add(Restrictions.eq("omega_user_id", omega_user));
        Friend friend = (Friend) crit.uniqueResult();
        delete(friend);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Friend> findAllFriends(User user) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("alpha_user_id", user));
        criteria.add(Restrictions.eq("accepted", true));
        criteria.add(Restrictions.eq("active",true));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        criteria.addOrder(Order.asc("created_at"));

        List<Friend> friends = (List<Friend>) criteria.list();

        return friends;
    }

	@Override
	public List<Friend> findAllIncomingFriendRequests(User user) {
		 Criteria criteria = createEntityCriteria();
	        criteria.add(Restrictions.eq("omega_user_id", user));
	        criteria.add(Restrictions.eq("accepted", false));
	        criteria.add(Restrictions.eq("active",true));
	        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
	        criteria.addOrder(Order.asc("created_at"));

	        List<Friend> friends = (List<Friend>) criteria.list();

	        return friends;
	}

	@Override
	public List<Friend> findAllOutGoingFriendRequests(User user) {
		 Criteria criteria = createEntityCriteria();
	        criteria.add(Restrictions.eq("alpha_user_id", user));
	        criteria.add(Restrictions.eq("accepted", false));
	        criteria.add(Restrictions.eq("active",true));
	        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
	        criteria.addOrder(Order.asc("created_at"));

	        List<Friend> friends = (List<Friend>) criteria.list();

	        return friends;
	}


}
