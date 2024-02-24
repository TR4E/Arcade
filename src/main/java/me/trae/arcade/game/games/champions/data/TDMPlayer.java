package me.trae.arcade.game.games.champions.data;

import me.trae.arcade.game.types.team.data.TeamGamePlayer;
import org.bukkit.entity.Player;

public class TDMPlayer extends TeamGamePlayer<TDMTeam> {

    public TDMPlayer(final Player player) {
        super(player);
    }
}