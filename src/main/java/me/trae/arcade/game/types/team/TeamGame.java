package me.trae.arcade.game.types.team;

import me.trae.arcade.game.Game;
import me.trae.arcade.game.GameManager;
import me.trae.arcade.game.data.GameScoreboard;
import me.trae.arcade.game.types.team.data.Team;
import me.trae.arcade.game.types.team.data.TeamGameData;
import me.trae.arcade.game.types.team.data.TeamGamePlayer;
import me.trae.arcade.game.types.team.interfaces.ITeamGame;

public abstract class TeamGame<D extends TeamGameData<T>, P extends TeamGamePlayer<T>, S extends GameScoreboard, T extends Team> extends Game<D, P, S> implements ITeamGame<T> {

    public TeamGame(final GameManager manager) {
        super(manager);
    }
}