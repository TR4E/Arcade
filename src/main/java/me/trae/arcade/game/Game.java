package me.trae.arcade.game;

import me.trae.arcade.game.data.GameData;
import me.trae.arcade.game.data.GamePlayer;
import me.trae.arcade.game.data.GameScoreboard;
import me.trae.arcade.game.enums.GameState;
import me.trae.arcade.game.interfaces.IGame;
import me.trae.arcade.scoreboard.ArcadeScoreboard;
import me.trae.core.framework.SpigotModule;
import me.trae.core.framework.SpigotSubModule;
import me.trae.core.scoreboard.ScoreboardManager;
import me.trae.core.scoreboard.events.ScoreboardUpdateEvent;
import me.trae.core.utility.UtilServer;

public abstract class Game<D extends GameData, P extends GamePlayer, S extends GameScoreboard> extends SpigotModule<GameManager> implements IGame<D, P, S> {

    private GameState gameState;

    public Game(final GameManager manager) {
        super(manager);
    }

    @Override
    public GameState getState() {
        return this.gameState;
    }

    @Override
    public void setState(final GameState gameState) {
        this.gameState = gameState;
    }

    @Override
    public boolean isState(final GameState gameState) {
        return this.getState().equals(gameState);
    }

    @Override
    public void start() {
        for (final Class<? extends SpigotSubModule<?>> subModuleClass : this.getSubModuleClasses()) {
            try {
                final SpigotSubModule<?> subModule = subModuleClass.getConstructor(Game.class).newInstance(this);

                subModule.initializeFrame();

                this.addSubModule(subModule);
            } catch (final Exception e) {
                e.printStackTrace();
            }
        }

        this.getInstance().getManagerByClass(ScoreboardManager.class).setClassOfScoreboard(this.getClassOfScoreboard());
        UtilServer.getOnlinePlayers().forEach(player -> UtilServer.callEvent(new ScoreboardUpdateEvent(player)));

        this.setState(GameState.STARTING);

        this.onStart();

        this.setState(GameState.STARTED);
    }

    @Override
    public void stop() {
        this.getSubModules().values().removeIf(subModule -> {
            if (this.getSubModuleClasses().contains(subModule.getClass())) {
                subModule.shutdownFrame();
                return true;
            }

            return false;
        });

        this.setState(GameState.ENDING);

        this.onStop();

        this.setState(GameState.ENDED);

        this.getInstance().getManagerByClass(ScoreboardManager.class).setClassOfScoreboard(ArcadeScoreboard.class);
        UtilServer.getOnlinePlayers().forEach(player -> UtilServer.callEvent(new ScoreboardUpdateEvent(player)));

        this.setState(null);

        this.getManager().setSelectedGame(null);
    }

    @Override
    public void onStart() {
    }

    @Override
    public void onStop() {
    }
}