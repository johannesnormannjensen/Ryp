package com.jof.springmvc.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

/**
 * Created by Ferenc_S on 12/15/2016.
 * Stores data about a player's actions in a particular game
 */
@Entity
@Table(name = "player")
public class Player {
    @Id
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "game_id", nullable = false, foreignKey = @ForeignKey(name = "FK_PLAYER_GAME_ID"))
    private Game game;

    @ManyToOne(optional = false)
    @JoinColumn(name = "champion_id", nullable = false, foreignKey = @ForeignKey(name = "FK_PLAYER_CHAMPION_ID"))
    private Champion champion;

    @NotEmpty
    @Column(name = "winner", nullable = false, columnDefinition = "TINYINT(1) DEFAULT '0'")
    private boolean winner;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Champion getChampion() {
        return champion;
    }

    public void setChampion(Champion champion) {
        this.champion = champion;
    }

    public boolean isWinner() {
        return winner;
    }

    public void setWinner(boolean winner) {
        this.winner = winner;
    }
}
