package me.trae.arcade.game.types.champions;

import me.trae.arcade.game.Game;
import me.trae.arcade.game.GameManager;
import me.trae.arcade.game.data.GameData;
import me.trae.arcade.game.data.GamePlayer;
import me.trae.arcade.game.data.GameScoreboard;
import me.trae.champions.Champions;

public abstract class ChampionsGame<D extends GameData, P extends GamePlayer, S extends GameScoreboard> extends Game<D, P, S> {

    public ChampionsGame(final GameManager manager) {
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