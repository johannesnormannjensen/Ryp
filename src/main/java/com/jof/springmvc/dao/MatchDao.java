package com.jof.springmvc.dao;

import com.jof.springmvc.model.Match;

import java.util.List;

/**
 * Created by Ferenc_S on 12/15/2016.
 */
public interface MatchDao {

    Match findById(Long id);

    void createOrUpdateMatch(Match match);

    void saveMatch(Match match);

    void deleteById(Long id);

    List<Match> findAllMatches();

    List<Match> getLatestNGames(Long id, int cache_size);
}
