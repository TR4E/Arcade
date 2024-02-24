package me.trae.arcade.game.types.champions;

import me.trae.arcade.game.GameManager;
import me.trae.arcade.game.data.GameScoreboard;
import me.trae.arcade.game.types.team.TeamGame;
import me.trae.arcade.game.types.team.data.Team;
import me.trae.arcade.game.types.team.data.TeamGameData;
import me.trae.arcade.game.types.team.data.TeamGamePlayer;
import me.trae.champions.Champions;

public abstract class ChampionsTeamGame<D extends TeamGameData<T>, P extends TeamGamePlayer<T>, S extends GameScoreboard, T extends Team> extends TeamGame<D, P, S, T> {

    public ChampionsTeamGame(final GameManager manager) {
        super(manager);
    }

    @Override
    public void start() {
        super.start();

        this.getInstance().getFactoryByClass(Champions.class).initialize(this.getInstance());
    }

    @Override
    public void stop() {
        super.stop();

        this.getInstance().getFactoryByClass(Champions.class).shutdown(this.getInstance());
    }
}