package me.trae.arcade.game.types.team.data.interfaces;

import me.trae.arcade.game.types.team.data.Team;

import java.util.List;

public interface ITeamGameData<T extends Team> {

    List<T> getTeams();
}