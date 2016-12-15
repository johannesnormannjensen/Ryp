package com.jof.springmvc.dao;

import com.jof.springmvc.model.Match;
import com.jof.springmvc.model.Match;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by Ferenc_S on 12/15/2016.
 */
public class MatchDaoImpl extends AbstractDao<Long, Match> implements MatchDao {

    @Override
    public Match findById(Long id) {
        return getByKey(id);
    }

    @Override
    public void saveMatch(Match match) {
        persist(match);
    }

    @Override
    public void deleteById(Long id) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("id", id));
        Match match = (Match) crit.uniqueResult();
        delete(match);

    }

    @Override
    public List<Match> findAllMatches() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("Matchname"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<Match> matches = (List<Match>) criteria.list();
        return matches;
    }
}
