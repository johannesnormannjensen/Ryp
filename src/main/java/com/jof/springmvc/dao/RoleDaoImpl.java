package com.jof.springmvc.dao;

import com.jof.springmvc.model.Role;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("roleDao")
public class RoleDaoImpl extends AbstractDao<Integer, Role> implements RoleDao {

    public Role findById(int id) {
        return getByKey(id);
    }

    public Role findByType(String type) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("type", type));
        return (Role) crit.uniqueResult();
    }

    @SuppressWarnings("unchecked")
    public List<Role> findAll() {
        Criteria crit = createEntityCriteria();
        crit.addOrder(Order.asc("type"));
        return (List<Role>) crit.list();
    }

}