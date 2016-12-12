package com.jof.springmvc.service;

import net.rithms.riot.api.RiotApi;
import net.rithms.riot.constant.Region;
import net.rithms.riot.dto.Summoner.RunePage;
import net.rithms.riot.dto.Summoner.RunePages;
import net.rithms.riot.dto.Summoner.Summoner;
import org.junit.Before;
import org.mockito.Mock;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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
    }

    @org.junit.Test
    public void testUserHasRunePageMock() throws Exception {
        assertTrue(mockRiotApiService.userHasRunePage(region, summId, trueRunePageName));
    }

    @org.junit.Test
    public void testNoUserHasRunePageMock() throws Exception {
        assertFalse(mockRiotApiService.userHasRunePage(region, summId, "NORUNEPAGE"));
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

}