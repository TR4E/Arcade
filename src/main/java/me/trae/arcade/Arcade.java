package me.trae.arcade;

import me.trae.arcade.effect.EffectManager;
import me.trae.arcade.game.GameManager;
import me.trae.arcade.lobby.LobbyManager;
import me.trae.arcade.scoreboard.ArcadeScoreboard;
import me.trae.core.chat.ChatManager;
import me.trae.core.client.ClientManager;
import me.trae.core.command.CommandManager;
import me.trae.core.config.ConfigManager;
import me.trae.core.countdown.CountdownManager;
import me.trae.core.database.DatabaseManager;
import me.trae.core.death.DeathManager;
import me.trae.core.donation.global.GlobalDonationManager;
import me.trae.core.donation.local.LocalDonationManager;
import me.trae.core.framework.SpigotPlugin;
import me.trae.core.gamer.global.GlobalGamerManager;
import me.trae.core.item.ItemManager;
import me.trae.core.menu.MenuManager;
import me.trae.core.network.NetworkManager;
import me.trae.core.player.PlayerManager;
import me.trae.core.recharge.RechargeManager;
import me.trae.core.redis.RedisManager;
import me.trae.core.scoreboard.ScoreboardManager;
import me.trae.core.server.ServerManager;
import me.trae.core.updater.UpdaterManager;

public class Arcade extends SpigotPlugin {

    @Override
    public void registerManagers() {
        // Core
        addManager(new ChatManager(this));
        addManager(new ClientManager(this));
        addManager(new CommandManager(this));
        addManager(new ConfigManager(this));
        addManager(new CountdownManager(this));
        addManager(new DatabaseManager(this));
        addManager(new DeathManager(this));
        addManager(new GlobalDonationManager(this));
        addManager(new LocalDonationManager(this));
        addManager(new GlobalGamerManager(this));
        addManager(new ItemManager(this));
        addManager(new MenuManager(this));
        addManager(new NetworkManager(this));
        addManager(new PlayerManager(this));
        addManager(new RechargeManager(this));
        addManager(new RedisManager(this));
        addManager(new ScoreboardManager(this, ArcadeScoreboard.class));
        addManager(new ServerManager(this));
        addManager(new UpdaterManager(this));

        // Arcade
        addManager(new EffectManager(this));
        addManager(new GameManager(this));
        addManager(new LobbyManager(this));
    }
}