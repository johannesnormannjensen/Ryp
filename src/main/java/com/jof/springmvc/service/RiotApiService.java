package com.jof.springmvc.service;

import net.rithms.riot.api.RiotApiException;

/**
 * Created by Ferenc_S on 12/10/2016.
 */
public interface RiotApiService {
    boolean userHasRunePage(long id, String runePageName) throws RiotApiException;
}
