package me.trae.arcade;

import me.trae.arcade.game.GameManager;
import me.trae.arcade.gamer.GamerManager;
import me.trae.arcade.lobby.LobbyManager;
import me.trae.champions.Champions;
import me.trae.champions.blood.BloodManager;
import me.trae.champions.build.BuildManager;
import me.trae.champions.role.RoleManager;
import me.trae.champions.skill.SkillManager;
import me.trae.core.Core;
import me.trae.core.blockrestore.BlockRestoreManager;
import me.trae.core.chat.ChatManager;
import me.trae.core.client.ClientManager;
import me.trae.core.command.CommandManager;
import me.trae.core.config.ConfigManager;
import me.trae.core.countdown.CountdownManager;
import me.trae.core.database.DatabaseManager;
import me.trae.core.death.DeathManager;
import me.trae.core.donation.global.GlobalDonationManager;
import me.trae.core.donation.local.LocalDonationManager;
import me.trae.core.effect.EffectManager;
import me.trae.core.framework.SpigotPlugin;
import me.trae.core.gamer.global.GlobalGamerManager;
import me.trae.core.item.ItemManager;
import me.trae.core.lunar.LunarManager;
import me.trae.core.menu.MenuManager;
import me.trae.core.network.NetworkManager;
import me.trae.core.player.PlayerManager;
import me.trae.core.punish.PunishManager;
import me.trae.core.recharge.RechargeManager;
import me.trae.core.redis.RedisManager;
import me.trae.core.scoreboard.ScoreboardManager;
import me.trae.core.server.ServerManager;
import me.trae.core.teleport.TeleportManager;
import me.trae.core.updater.UpdaterManager;
import me.trae.core.weapon.WeaponManager;
import me.trae.core.world.WorldManager;

public class Arcade extends SpigotPlugin {

    @Override
    public void registerManagers() {
        addManager(new GameManager(this));
        addManager(new GamerManager(this));
        addManager(new LobbyManager(this));
        addManager(new ScoreboardManager(this));
    }

    @Override
    public void registerFactories() {
        addFactory(new Core() {
            @Override
            public boolean loadOnStart() {
                return true;
            }

            @Override
            public void registerManagers() {
                addManager(BlockRestoreManager.class);
                addManager(ChatManager.class);
                addManager(ClientManager.class);
                addManager(CommandManager.class);
                addManager(ConfigManager.class);
                addManager(CountdownManager.class);
                addManager(DatabaseManager.class);
                addManager(DeathManager.class);
                addManager(GlobalDonationManager.class);
                addManager(LocalDonationManager.class);
                addManager(EffectManager.class);
                addManager(GlobalGamerManager.class);
                addManager(ItemManager.class);
                addManager(LunarManager.class);
                addManager(MenuManager.class);
                addManager(NetworkManager.class);
                addManager(PlayerManager.class);
                addManager(PunishManager.class);
                addManager(RechargeManager.class);
                addManager(RedisManager.class);
                addManager(me.trae.core.scoreboard.ScoreboardManager.class);
                addManager(ServerManager.class);
                addManager(TeleportManager.class);
                addManager(UpdaterManager.class);
                addManager(WeaponManager.class);
                addManager(WorldManager.class);
            }
        });

        addFactory(new Champions() {
            @Override
            public boolean loadOnStart() {
                return false;
            }

            @Override
            public void registerManagers() {
                addManager(BloodManager.class);
                addManager(BuildManager.class);
                addManager(me.trae.champions.effect.EffectManager.class);
                addManager(RoleManager.class);
                addManager(SkillManager.class);
                addManager(me.trae.champions.weapon.WeaponManager.class);
            }
        });
    }
}