package com.jof.springmvc.service;

import com.jof.springmvc.model.Match;

/**
 * Created by Ferenc_S on 12/15/2016.
 */
public interface MatchService {
    void save(Match match);

    void saveAll(Iterable<Match> iterable);
}
