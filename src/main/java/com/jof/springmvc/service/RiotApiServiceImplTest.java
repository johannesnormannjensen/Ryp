package com.jof.springmvc.service;

import com.jof.springmvc.model.Match;
import net.rithms.riot.api.RiotApi;
import net.rithms.riot.api.RiotApiException;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ferenc_S on 12/10/2016.
 */
@Service("riotApiService")
@Profile("!prod")
public class RiotApiServiceImplTest implements RiotApiService {
    public RiotApiServiceImplTest() {
        int a = 2;
        int b = 2 - a;
        int c = b - a;
    }
    @PostConstruct
    private void init() {

        int a = 2;
        int b = 2 - a;
        int c = b - a;
    }

    @Override
    public long getSummonerIdByName(String summonerName) throws RiotApiException {
        return 0;
    }

    @Override
    public boolean userHasRunePage(long id, String runePageName) throws RiotApiException {
        return true;
    }

    @Override
    public List<Match> getRecentGames(Long id, String summonerName) throws RiotApiException {
        return new ArrayList<>();
    }
}
