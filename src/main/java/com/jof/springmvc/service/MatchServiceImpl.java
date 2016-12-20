package com.jof.springmvc.service;

import com.jof.springmvc.dao.MatchDao;
import com.jof.springmvc.model.Match;
import net.rithms.riot.api.RiotApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Ferenc_S on 12/15/2016.
 */
@Service("matchService")
@Transactional
public class MatchServiceImpl implements MatchService {
    private final int cache_size = 10;

    @Autowired
    MatchDao matchDao;

    @Override
    public void save(Match match) {
        matchDao.saveMatch(match);
    }

    @Override
    public void saveAll(Iterable<Match> matches) {
        for (Match m : matches) {
            matchDao.saveOrUpdate(m);
        }
    }

    @Override
    public Match findById(Long id) {
        Match match = matchDao.findById(id);
        return match;
    }

    @Override
    public List<Match> getRecentCachedGames(Long id) throws RiotApiException {
        return matchDao.getLatestNGames(id, cache_size);
    }
}
