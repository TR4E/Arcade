package me.trae.arcade.game.types.team.interfaces;

import me.trae.arcade.game.types.team.data.Team;

public interface ITeamGame<T extends Team> {

    Class<T> getClassOfTeam();
}