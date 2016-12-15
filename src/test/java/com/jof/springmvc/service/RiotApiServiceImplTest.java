package com.jof.springmvc.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.jof.springmvc.model.Match;
import org.junit.Before;
import org.mockito.Mock;

import net.rithms.riot.api.RiotApi;
import net.rithms.riot.constant.Region;
import net.rithms.riot.dto.Game.Game;
import net.rithms.riot.dto.Game.RecentGames;
import net.rithms.riot.dto.Summoner.RunePage;
import net.rithms.riot.dto.Summoner.RunePages;
import net.rithms.riot.dto.Summoner.Summoner;

/**
 * Created by Ferenc_S on 12/10/2016.
 */

public class RiotApiServiceImplTest {
    @Mock
    RiotApi mockRiotApi;
    RiotApiService mockRiotApiService;


    // Summoner mock
    @Mock
    Summoner summoner;
    long summId = 1;
    String name = "Summ_name";
    Region region = Region.EUNE;

    private String trueRunePageName;

    @Before
    public void setUp() throws Exception {
        mockRiotApi = mock(RiotApi.class);
        mockRiotApiService = new RiotApiServiceImpl(null, mockRiotApi);

        // Summoner mock
        summoner = mock(Summoner.class);
        when(summoner.getId()).thenReturn(summId);

        // Runepages mock
        RunePages runePages = mock(RunePages.class);
        Set<RunePage> runePages1 = getRunePages();
        when(runePages.getPages()).thenReturn(runePages1);
        when(mockRiotApi.getRunePages(region, summId)).thenReturn(runePages);

        // Games mock
        RecentGames recentGames = mock(RecentGames.class);
        Set<Game> games = getRecentGames();
        when(recentGames.getGames()).thenReturn(games);
        when(mockRiotApi.getRecentGames(region, summId)).thenReturn(recentGames);
    }

    @org.junit.Test
    public void testUserHasRunePageMock() throws Exception {
        assertTrue(mockRiotApiService.userHasRunePage(region, summId, trueRunePageName));
    }

    @org.junit.Test
    public void testNoUserHasRunePageMock() throws Exception {
        assertFalse(mockRiotApiService.userHasRunePage(region, summId, "NORUNEPAGE"));
    }

    @org.junit.Test
    public void testGetRecentGamesSorted() throws Exception {
        List<Match> matches = mockRiotApiService.getRecentGames(region, summId, name);
       assertEquals(matches.size(), 4);

    }

    // Utils
    Set<RunePage> getRunePages() {
        Set<RunePage> pages = new HashSet<>();

        RunePage page = mock(RunePage.class);
        trueRunePageName = "RunePage 1";
        when(page.getName()).thenReturn(trueRunePageName);
        pages.add(page);

        RunePage page2 = mock(RunePage.class);
        when(page2.getName()).thenReturn("RunePage 3");
        pages.add(page2);

        RunePage page3 = mock(RunePage.class);
        when(page3.getName()).thenReturn("RunePage 2");
        pages.add(page3);

        return pages;
    }

    Set<Game> getRecentGames() {
        Set<Game> games = new HashSet<>();

        Game game1 = mock(Game.class);
        when(game1.getCreateDate()).thenReturn(1481796590000L);

        Game game2 = mock(Game.class);
        when(game2.getCreateDate()).thenReturn(1481796590000L - 3600 * 1000);

        Game game3 = mock(Game.class);
        when(game3.getCreateDate()).thenReturn(1481796590000L + 3600 * 1000);

        Game game4 = mock(Game.class);
        when(game4.getCreateDate()).thenReturn(1481796590000L + 3600 * 1000 * 5);

        games.add(game1);
        games.add(game2);
        games.add(game3);
        games.add(game4);
        return games;
    }

    <T extends Comparable> boolean isSortedReverse(Iterable<T> iterable) {
        Iterator<T> iter = iterable.iterator();
        if (!iter.hasNext()) {
            return true;
        }
        T t = iter.next();
        while (iter.hasNext()) {
            T t2 = iter.next();
            if (t.compareTo(t2) < 0) {
                return false;
            }
            t = t2;
        }
        return true;
    }

}