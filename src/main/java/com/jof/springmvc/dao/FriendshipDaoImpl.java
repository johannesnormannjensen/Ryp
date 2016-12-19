package com.jof.springmvc.dao;

import com.jof.springmvc.model.Friendship;
import com.jof.springmvc.model.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("friendDao")
public class FriendshipDaoImpl extends AbstractDao<Integer, Friendship> implements FriendshipDao {

    static final Logger logger = LoggerFactory.getLogger(FriendshipDaoImpl.class);

    @Override
    public Friendship findFriendshipByIds(User id_alpha, User id_omega) {

        Criteria criteria = createEntityCriteria().addOrder(Order.asc("id.alpha_user"));
        criteria.add( Restrictions.disjunction()
                .add( Restrictions.eq("id.alpha_user", id_alpha ) )
                .add( Restrictions.eq("id.omega_user", id_alpha ) )
            );  
        criteria.add( Restrictions.disjunction()
                .add( Restrictions.eq("id.alpha_user", id_omega ) )
                .add( Restrictions.eq("id.omega_user", id_omega ) )
            );  
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);// To avoid  duplicates.

        Friendship friends = (Friendship) criteria.uniqueResult();

        return friends;
    }

    @Override
    public void save(Friendship friend) {
        persist(friend);
    }

    
    public void deleteByIds(User alpha_user, User omega_user) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("id.alpha_user", alpha_user));
        crit.add(Restrictions.eq("id.omega_user", omega_user));
        Friendship friend = (Friendship) crit.uniqueResult();
        delete(friend);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Friendship> findAllFriends(User user) {
        Criteria criteria = createEntityCriteria();
        criteria.add( Restrictions.disjunction()
                .add( Restrictions.eq("id.alpha_user", user ) )
                .add( Restrictions.eq("id.omega_user", user ) )
            );       
        criteria.add(Restrictions.eq("accepted", true));
        criteria.add(Restrictions.eq("active",true));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        criteria.addOrder(Order.asc("created_at"));

        List<Friendship> friends = (List<Friendship>) criteria.list();

        return friends;
    }

	@Override
	public List<Friendship> findAllIncomingFriendRequests(User user) {
		 Criteria criteria = createEntityCriteria();
	        criteria.add(Restrictions.eq("id.omega_user", user));
	        criteria.add(Restrictions.eq("accepted", false));
	        criteria.add(Restrictions.eq("active",true));
	        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
	        criteria.addOrder(Order.asc("created_at"));

	        @SuppressWarnings("unchecked")
			List<Friendship> friends = (List<Friendship>) criteria.list();

	        return friends;
	}

	@Override
	public List<Friendship> findAllOutgoingFriendRequests(User user) {
		 Criteria criteria = createEntityCriteria();
	        criteria.add(Restrictions.eq("id.alpha_user", user));
	        criteria.add(Restrictions.eq("accepted", false));
	        criteria.add(Restrictions.eq("active",true));
	        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
	        criteria.addOrder(Order.asc("created_at"));

	        @SuppressWarnings("unchecked")
			List<Friendship> friends = (List<Friendship>) criteria.list();

	        return friends;
	}


}
