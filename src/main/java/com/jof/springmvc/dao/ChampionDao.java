package com.jof.springmvc.dao;

import com.jof.springmvc.model.Champion;
import org.springframework.stereotype.Repository;


@Repository("championDao")
public class ChampionDao extends AbstractDao<Integer, Champion> {
    public void saveAll(Iterable<Champion> champions) {
        for (Champion c : champions) {
            persist(c);
        }
    }

}