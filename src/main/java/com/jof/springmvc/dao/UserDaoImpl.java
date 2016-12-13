package com.jof.springmvc.dao;

import com.jof.springmvc.model.User;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;


@Repository("userDao")
public class UserDaoImpl extends AbstractDao<BigInteger, User> implements UserDao {

    static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    public User findById(BigInteger id) {
        User user = getByKey(id);
        if (user != null) {
            Hibernate.initialize(user.getRoles());
        }
        return user;
    }

    public User findByUsername(String username) {
        logger.info("Username : {}", username);
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("username", username));
        User user = (User) crit.uniqueResult();
        if (user != null) {
            Hibernate.initialize(user.getRoles());
        }
        return user;
    }

    @SuppressWarnings("unchecked")
    public List<User> findAllUsers() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("username"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<User> users = (List<User>) criteria.list();

        // No need to fetch userProfiles since we are not showing them on list page. Let them lazy load.
        // Uncomment below lines for eagerly fetching of userProfiles if you want.
        /*
        for(User user : users){
            Hibernate.initialize(user.getRoles());
        }*/
        return users;
    }

    public void save(User user) {
        persist(user);
    }

    public void deleteByUsername(String username) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("username", username));
        User user = (User) crit.uniqueResult();
        delete(user);
    }

}