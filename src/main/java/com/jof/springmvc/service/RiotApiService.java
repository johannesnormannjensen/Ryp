package com.jof.springmvc.service;

import com.jof.springmvc.model.Match;
import net.rithms.riot.api.RiotApiException;

import java.util.List;

/**
 * Created by Ferenc_S on 12/10/2016.
 */
public interface RiotApiService {
    public final int BLUE_TEAM_ID = 100;
    public final int RED_TEAM_ID = 200;

    long getSummonerIdByName(String summonerName) throws RiotApiException;

    boolean userHasRunePage(long id, String runePageName) throws RiotApiException;

    List<Match> getRecentGames(Long id, String summonerName) throws RiotApiException;
}
