package com.jof.springmvc.service;

import com.jof.springmvc.model.Match;

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
}
