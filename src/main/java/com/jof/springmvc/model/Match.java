package com.jof.springmvc.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by Ferenc_S on 12/15/2016.
 */
@Entity
@Table(name = "game")
public class Match implements Serializable, Comparable {
    @Id
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Long id;

    @NotEmpty
    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", nullable = true)
    private Date created_at;


    // So that we don't violate the first normal form by stashing 10 player Ids in a single column
    @OneToMany(mappedBy = "match", cascade = CascadeType.REMOVE)
    private List<PlayerInfo> playerInfos = new ArrayList<PlayerInfo>();

    @NotEmpty
    @Column(name = "winner_team_id", nullable = false)
    private int winnerTeamId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public List<PlayerInfo> getPlayerInfos() {
        return playerInfos;
    }

    public void setPlayerInfos(List<PlayerInfo> playerInfos) {
        this.playerInfos = playerInfos;
    }

    public int getWinnerTeamId() {
        return winnerTeamId;
    }

    public void setWinnerTeamId(int winnerTeamId) {
        this.winnerTeamId = winnerTeamId;
    }

    public boolean didPlayerWin(Long playerId) {
        for (PlayerInfo playerInfo : playerInfos) {
            if (playerInfo.getSummonerId().equals(playerId)) {
                return playerInfo.getTeamId() == winnerTeamId;
            }
        }
        return false;
    }

    @Override
    public int compareTo(Object o) {
        if (!(o instanceof Match)) {return 0;}
        Match match = (Match) o;
        if (this.created_at.compareTo(match.created_at) < 0) {
            return -1;
        } else if (this.created_at.compareTo(match.created_at) > 0) {
            return 1;
        }
        return 0;
    }
}
