package com.jof.springmvc.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ferenc_S on 12/15/2016.
 */
@Entity
@Table(name = "game")
public class Game implements Serializable {
    @Id
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Integer id;

    @NotEmpty
    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", nullable = true)
    private Date created_at;


    // So that we don't violate the first normal form by stashing 10 player Ids in a single column
    @OneToMany(mappedBy = "game", cascade = CascadeType.REMOVE)
    private List<Player> players = new ArrayList<Player>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public boolean didPlayerWin(Long playerId) {
        for (Player player : players) {
            if (player.getId() == playerId) {
                return player.isWinner();
            }
        }
        return false;
    }
}
