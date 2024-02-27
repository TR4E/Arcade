package me.trae.arcade.game.interfaces;

import me.trae.arcade.game.data.GameData;
import me.trae.arcade.game.data.GamePlayer;
import me.trae.arcade.game.data.GameScoreboard;
import me.trae.arcade.game.enums.GameState;
import me.trae.core.framework.SpigotSubModule;

import java.util.ArrayList;
import java.util.List;

public interface IGame<D extends GameData, P extends GamePlayer, S extends GameScoreboard> {

    default List<Class<? extends SpigotSubModule<?>>> getSubModuleClasses() {
        return new ArrayList<>();
    }

    Class<D> getClassOfData();

    Class<P> getClassOfPlayer();

    Class<S> getClassOfScoreboard();

    GameState getState();

    void setState(final GameState gameState);

    boolean isState(final GameState gameState);

    void start();

    void stop();

    void onStart();

    void onStop();
}