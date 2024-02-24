package me.trae.arcade.scoreboard;

import me.trae.core.client.Client;
import me.trae.core.framework.SpigotPlugin;
import me.trae.core.scoreboard.MainScoreboard;
import org.bukkit.entity.Player;

public class ArcadeScoreboard extends MainScoreboard {

    public ArcadeScoreboard(final SpigotPlugin instance) {
        super(instance);
    }

    @Override
    public void registerLines(final Player player, final Client client) {
        super.registerLines(player, client);
    }
}