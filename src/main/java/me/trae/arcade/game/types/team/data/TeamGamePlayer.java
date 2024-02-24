package me.trae.arcade.game.types.team.data;

import me.trae.arcade.game.data.GamePlayer;
import me.trae.arcade.game.types.team.data.interfaces.ITeamGamePlayer;
import org.bukkit.entity.Player;

public class TeamGamePlayer<T extends Team> extends GamePlayer implements ITeamGamePlayer<T> {

    private T team;

    public TeamGamePlayer(final Player player) {
        super(player);
    }

    @Override
    public T getTeam() {
        return this.team;
    }

    @Override
    public void setTeam(final T team) {
        this.team = team;
    }
}