package me.trae.arcade.game.games.champions;

import me.trae.arcade.game.GameManager;
import me.trae.arcade.game.games.champions.data.TDMData;
import me.trae.arcade.game.games.champions.data.TDMPlayer;
import me.trae.arcade.game.games.champions.data.TDMScoreboard;
import me.trae.arcade.game.games.champions.data.TDMTeam;
import me.trae.arcade.game.types.champions.ChampionsTeamGame;

public class TeamDeathmatch extends ChampionsTeamGame<TDMData, TDMPlayer, TDMScoreboard, TDMTeam> {

    public TeamDeathmatch(final GameManager manager) {
        super(manager);
    }

    @Override
    public Class<TDMData> getClassOfData() {
        return TDMData.class;
    }

    @Override
    public Class<TDMPlayer> getClassOfPlayer() {
        return TDMPlayer.class;
    }

    @Override
    public Class<TDMScoreboard> getClassOfScoreboard() {
        return TDMScoreboard.class;
    }

    @Override
    public Class<TDMTeam> getClassOfTeam() {
        return TDMTeam.class;
    }
}