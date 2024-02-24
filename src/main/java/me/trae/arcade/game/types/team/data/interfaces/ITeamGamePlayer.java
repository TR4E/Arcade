package me.trae.arcade.game.types.team.data.interfaces;

import me.trae.arcade.game.types.team.data.Team;

public interface ITeamGamePlayer<T extends Team> {

    T getTeam();

    void setTeam(final T team);
}