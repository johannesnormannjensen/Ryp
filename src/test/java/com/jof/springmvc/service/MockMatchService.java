package com.jof.springmvc.service;

import com.jof.springmvc.model.Match;
import net.rithms.riot.api.RiotApiException;

import java.util.List;

/**
 * Created by Ferenc_S on 12/19/2016.
 */
public class MockMatchService implements MatchService{
    @Override
    public void save(Match match) {

    }

    @Override
    public void saveAll(Iterable<Match> iterable) {

    }

    @Override
    public Match findById(Long id) {
        return null;
    }

    @Override
    public List<Match> getRecentCachedGames(Long id) throws RiotApiException {
        return null;
    }

    @Override
    public List<Match> generateMatchesFor(Long id) {
        return null;
    }
}
