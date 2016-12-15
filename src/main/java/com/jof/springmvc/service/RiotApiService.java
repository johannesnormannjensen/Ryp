package com.jof.springmvc.service;

import net.rithms.riot.api.RiotApiException;
import net.rithms.riot.constant.Region;
import net.rithms.riot.dto.Game.Game;

import java.util.List;

/**
 * Created by Ferenc_S on 12/10/2016.
 */
public interface RiotApiService {
    long getSummonerIdByName(Region region, String summonerName) throws RiotApiException;

    boolean userHasRunePage(Region region, long id, String runePageName) throws RiotApiException;

    List<Game> getRecentGames(Region region, Long id) throws RiotApiException;
}
