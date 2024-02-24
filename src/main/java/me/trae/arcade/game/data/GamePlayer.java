package me.trae.arcade.game.data;

import me.trae.arcade.game.data.interfaces.IGamePlayer;
import org.bukkit.entity.Player;

import java.util.UUID;

public class GamePlayer implements IGamePlayer {

    private final UUID uuid;

    public GamePlayer(final Player player) {
        this.uuid = player.getUniqueId();
    }

    @Override
    public UUID getUUID() {
        return this.uuid;
    }
}