package me.trae.arcade.game.types.team.data;

import me.trae.arcade.game.data.GameData;
import me.trae.arcade.game.types.team.data.interfaces.ITeamGameData;

import java.util.ArrayList;
import java.util.List;

public class TeamGameData<T extends Team> extends GameData implements ITeamGameData<T> {

    private final List<T> teams;

    public TeamGameData() {
        this.teams = new ArrayList<>();
    }

    @Override
    public List<T> getTeams() {
        return this.teams;
    }
}