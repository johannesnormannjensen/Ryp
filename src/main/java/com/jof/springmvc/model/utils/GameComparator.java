package com.jof.springmvc.model.utils;

import net.rithms.riot.dto.Game.Game;

import java.util.Comparator;

/**
 * Created by Ferenc_S on 12/15/2016.
 */
public class GameComparator implements Comparator<Game> {
    @Override
    public int compare(Game o1, Game o2) {
        return Long.compare(o1.getCreateDate(), o2.getCreateDate());
    }
}
