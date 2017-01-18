package com.jof.springmvc.service;

import com.jof.springmvc.model.Match;
import net.rithms.riot.api.RiotApiException;

import java.util.List;

/**
 * Created by Ferenc_S on 12/15/2016.
 */
public interface MatchService {
    void save(Match match);

    void saveAll(Iterable<Match> iterable);

    Match findById(Long id);

    List<Match> getRecentCachedGames(Long id) throws RiotApiException;

    List<Match> generateMatchesFor(Long id);
}
