package com.jof.springmvc.service;

import com.jof.springmvc.dao.MatchDao;
import com.jof.springmvc.model.Match;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Ferenc_S on 12/15/2016.
 */
public class MatchServiceImpl implements MatchService {

    @Autowired
    MatchDao matchDao;

    @Override
    public void save(Match match) {
        matchDao.saveMatch(match);
    }

    @Override
    public void saveAll(Iterable<Match> matches) {
        for (Match m : matches) {
            matchDao.saveMatch(m);
        }
    }
}
