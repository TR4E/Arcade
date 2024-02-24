package me.trae.arcade.game.types.team.data.interfaces;

import me.trae.framework.shared.utility.enums.ChatColor;
import org.bukkit.DyeColor;

public interface ITeam {

    String getName();

    ChatColor getChatColor();

    DyeColor getDyeColor();

    String getDisplayName();
}