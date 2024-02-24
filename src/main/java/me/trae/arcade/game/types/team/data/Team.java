package me.trae.arcade.game.types.team.data;

import me.trae.arcade.game.types.team.data.interfaces.ITeam;
import me.trae.framework.shared.utility.enums.ChatColor;
import org.bukkit.DyeColor;

public class Team implements ITeam {

    private final String name;
    private final ChatColor chatColor;
    private final DyeColor dyeColor;

    public Team(final String name, final ChatColor chatColor, final DyeColor dyeColor) {
        this.name = name;
        this.chatColor = chatColor;
        this.dyeColor = dyeColor;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public ChatColor getChatColor() {
        return this.chatColor;
    }

    @Override
    public DyeColor getDyeColor() {
        return this.dyeColor;
    }

    @Override
    public String getDisplayName() {
        return this.getChatColor() + this.getName();
    }
}