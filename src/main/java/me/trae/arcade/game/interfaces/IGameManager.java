package me.trae.arcade.game.interfaces;

import me.trae.arcade.game.Game;
import org.bukkit.command.CommandSender;

public interface IGameManager {

    Game<?, ?, ?> getSelectedGame();

    void setSelectedGame(final Game<?, ?, ?> selectedGame);

    Game<?, ?, ?> searchGame(final CommandSender sender, final String name, final boolean inform);
}