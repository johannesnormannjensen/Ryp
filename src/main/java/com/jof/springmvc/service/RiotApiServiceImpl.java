package com.jof.springmvc.service;

import com.jof.springmvc.model.utils.GameComparator;
import net.rithms.riot.api.RiotApi;
import net.rithms.riot.api.RiotApiException;
import net.rithms.riot.constant.Region;
import net.rithms.riot.dto.Game.Game;
import net.rithms.riot.dto.Game.RecentGames;
import net.rithms.riot.dto.Summoner.RunePage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;

/**
 * Created by Ferenc_S on 12/10/2016.
 */
@Service("riotApiService")
public class RiotApiServiceImpl implements RiotApiService {

    private final Environment environment;

    RiotApi riotApi;

    @Autowired
    public RiotApiServiceImpl(Environment environment) {
        this.environment = environment;
    }

    public RiotApiServiceImpl(Environment environment, RiotApi riotApi) {
        this.environment = environment;
        this.riotApi = riotApi;
    }

    @PostConstruct
    private void init() {
        this.riotApi = new RiotApi(environment.getRequiredProperty("riot.api.key"));

    }

    @Override
    public long getSummonerIdByName(Region region, String summonerName) throws RiotApiException {
        return riotApi.getSummonerByName(region, summonerName).getId();
    }

    @Override
    public boolean userHasRunePage(Region region, long id, String runePageName) throws RiotApiException {
        Set<RunePage> pages = riotApi.getRunePages(region, id).getPages();
        for (RunePage page : pages) {
            if (page.getName().equals(runePageName)) return true;
        }
        return false;
    }

    @Override
    public List<Game> getRecentGames(Region region, Long id) throws RiotApiException {
        RecentGames recentGames = riotApi.getRecentGames(region, id);
        List<Game> games = new ArrayList<>(recentGames.getGames());
        Collections.sort(games, new GameComparator()); // Let's not trust a SET to be ordered in any manner :)
        Collections.reverse(games); // newest / biggest number first, to the top
        return games;
    }
}
