package me.trae.arcade.game.commands;

import me.trae.arcade.game.Game;
import me.trae.arcade.game.GameManager;
import me.trae.arcade.game.enums.GameState;
import me.trae.core.command.subcommand.types.SubCommand;
import me.trae.core.command.types.Command;
import me.trae.core.utility.UtilMessage;
import me.trae.framework.shared.client.enums.Rank;
import org.bukkit.command.CommandSender;

import java.util.Arrays;
import java.util.Collections;

public class GameCommand extends Command<GameManager> {

    public GameCommand(final GameManager manager) {
        super(manager, "game", new String[0], Rank.ADMIN);
    }

    @Override
    public void registerSubModules() {
        addSubModule(new SetCommand(this));
        addSubModule(new StartCommand(this));
        addSubModule(new StopCommand(this));
    }

    @Override
    public String getDescription() {
        return "Game Management";
    }

    @Override
    public void execute(final CommandSender sender, final String[] args) {
        this.executeSubCommand(sender, args);
    }

    private static class SetCommand extends SubCommand<GameCommand> {

        public SetCommand(final GameCommand gameCommand) {
            super(gameCommand, "set");
        }

        @Override
        public String getDescription() {
            return "Set the Game";
        }

        @Override
        public void execute(final CommandSender sender, final String[] args) {
            if (args.length == 0) {
                UtilMessage.message(sender, "Game", "You did not input a Game to Set.");
                return;
            }

            final Game<?, ?, ?> game = this.getModule().getManager().searchGame(sender, args[0], true);
            if (game == null) {
                return;
            }

            if (this.getModule().getManager().getSelectedGame() == game) {
                UtilMessage.message(sender, "Game", "That game has already been selected.");
                return;
            }

            this.getModule().getManager().setSelectedGame(game);

            UtilMessage.simpleBroadcast(null, "<white><bold><var> <aqua><bold>has changed the game to <white><bold><var>", Arrays.asList(sender.getName(), game.getName()), null);
        }
    }

    private static class StartCommand extends SubCommand<GameCommand> {

        public StartCommand(final GameCommand gameCommand) {
            super(gameCommand, "start");
        }

        @Override
        public String getDescription() {
            return "Start the Game";
        }

        @Override
        public void execute(final CommandSender sender, final String[] args) {
            final Game<?, ?, ?> game = this.getModule().getManager().getSelectedGame();
            if (game == null) {
                UtilMessage.message(sender, "Game", "There is currently no game selected.");
                return;
            }

            if (game.getState() != null) {
                UtilMessage.message(sender, "Game", "The game has already been started.");
                return;
            }

            game.start();

            UtilMessage.simpleBroadcast(null, "<white><bold><var> <aqua><bold>has started the game", Collections.singletonList(sender.getName()), null);
        }
    }

    private static class StopCommand extends SubCommand<GameCommand> {

        public StopCommand(final GameCommand gameCommand) {
            super(gameCommand, "stop");
        }

        @Override
        public String getDescription() {
            return "Stop the Game";
        }

        @Override
        public void execute(final CommandSender sender, final String[] args) {
            final Game<?, ?, ?> game = this.getModule().getManager().getSelectedGame();
            if (game == null) {
                UtilMessage.message(sender, "Game", "There is currently no game selected.");
                return;
            }

            if (Arrays.asList(GameState.ENDING, GameState.ENDED).contains(game.getState())) {
                UtilMessage.message(sender, "Game", "The game is already stopping.");
                return;
            }

            game.stop();

            UtilMessage.simpleBroadcast(null, "<white><bold><var> <aqua><bold>has stopped the game", Collections.singletonList(sender.getName()), null);
        }
    }
}