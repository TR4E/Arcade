package me.trae.arcade.scoreboard.modules;

import me.trae.arcade.game.Game;
import me.trae.arcade.game.GameManager;
import me.trae.arcade.game.enums.GameState;
import me.trae.arcade.scoreboard.ArcadeScoreboard;
import me.trae.arcade.scoreboard.ScoreboardManager;
import me.trae.core.framework.types.SpigotListener;
import me.trae.core.scoreboard.events.ScoreboardUpdateEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;

public class HandleScoreboardReceive extends SpigotListener<ScoreboardManager> {

    public HandleScoreboardReceive(final ScoreboardManager manager) {
        super(manager);
    }

    @EventHandler
    public void onScoreboardUpdate(final ScoreboardUpdateEvent event) {
        final Player player = event.getPlayer();
        if (player == null) {
            return;
        }

        final Game<?, ?, ?> game = this.getInstance().getManagerByClass(GameManager.class).getSelectedGame();
        if (game != null && game.isAnyState(GameState.STARTING, GameState.STARTED)) {
            event.setClassOfScoreboard(game.getClassOfScoreboard());
            return;
        }

        event.setClassOfScoreboard(ArcadeScoreboard.class);
    }
}