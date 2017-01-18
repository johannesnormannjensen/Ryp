package com.jof.springmvc.service;

import com.jof.springmvc.dao.MatchDao;
import com.jof.springmvc.model.Champion;
import com.jof.springmvc.model.Match;
import com.jof.springmvc.model.PlayerInfo;
import net.rithms.riot.api.RiotApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
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

    @Override
    public List<Match> generateMatchesFor(Long id) {
        List<Match> matches = new ArrayList<>();
        for (int i = 0; i < 1500; i++) {
            Match match = new Match();
            match.setId(Long.valueOf(id.toString() + i));
            match.setCreated_at(new Date(1474740958886l + (i * 36000000)));

            List<PlayerInfo> playerInfos = new ArrayList<>();
            PlayerInfo playerInfo = new PlayerInfo();
            playerInfo.setMatch(match);
            playerInfo.setSummonerId(id);
            playerInfo.setSummonerName("FakeUser_" + id);
            playerInfo.setTeamId(100);

            Champion champion = new Champion();
            champion.setId(54);
            playerInfo.setChampion(champion);
            playerInfos.add(playerInfo);
            playerInfo.setTeamId(100);
            match.setWinnerTeamId(100);

            for (int j = 0; j < 9; j++) { // playerinfos
                playerInfo = new PlayerInfo();
                playerInfo.setMatch(match);
                playerInfo.setSummonerId((long) (i * j));
                playerInfo.setSummonerName("FakeSum_" + i * j);
                champion = new Champion();
                champion.setId(54);
                playerInfo.setChampion(champion);
                playerInfo.setTeamId(i < 5 ? 100 : 200);
                playerInfos.add(playerInfo);
            }
            Collections.sort(playerInfos);
            match.setPlayerInfos(playerInfos);
            matches.add(match);
        }

        return matches;
    }
}
