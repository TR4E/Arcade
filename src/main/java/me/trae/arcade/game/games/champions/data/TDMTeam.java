package me.trae.arcade.game.games.champions.data;

import me.trae.arcade.game.types.team.data.Team;
import me.trae.framework.shared.utility.enums.ChatColor;
import org.bukkit.DyeColor;

public class TDMTeam extends Team {

    public TDMTeam(final String name, final ChatColor chatColor, final DyeColor dyeColor) {
        super(name, chatColor, dyeColor);
    }
}