package me.trae.arcade.game;

import me.trae.arcade.game.commands.GameCommand;
import me.trae.arcade.game.games.champions.TeamDeathmatch;
import me.trae.arcade.game.interfaces.IGameManager;
import me.trae.core.framework.SpigotManager;
import me.trae.core.framework.SpigotPlugin;
import me.trae.core.utility.UtilSearch;
import org.bukkit.command.CommandSender;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class GameManager extends SpigotManager implements IGameManager {

    private Game<?, ?, ?> selectedGame;

    public GameManager(final SpigotPlugin instance) {
        super(instance);
    }

    @Override
    public void registerModules() {
        // Commands
        addModule(new GameCommand(this));

        // Games
        addModule(new TeamDeathmatch(this));
    }

    @Override
    public Game<?, ?, ?> getSelectedGame() {
        return this.selectedGame;
    }

    @Override
    public void setSelectedGame(final Game<?, ?, ?> selectedGame) {
        this.selectedGame = selectedGame;
    }

    @Override
    public Game<?, ?, ?> searchGame(final CommandSender sender, final String name, final boolean inform) {
        final List<Predicate<Game>> predicates = Arrays.asList(
                (game -> game.getClass().getSimpleName().equalsIgnoreCase(name)),
                (game -> game.getClass().getSimpleName().toLowerCase().contains(name.toLowerCase()))
        );

        final Function<Game, String> function = (Game::getName);

        return UtilSearch.search(Game.class, this.getModulesByClass(Game.class), predicates, null, function, "Game Search", sender, name, inform);
    }
}