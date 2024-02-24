package me.trae.arcade.utility;

import me.trae.champions.blood.BloodManager;
import me.trae.champions.build.BuildManager;
import me.trae.champions.role.RoleManager;
import me.trae.champions.skill.SkillManager;
import me.trae.core.framework.SpigotManager;
import me.trae.core.framework.SpigotPlugin;
import me.trae.core.utility.UtilPlugin;

import java.util.Arrays;
import java.util.List;

public class UtilChampions {

    public static void initialize() {
        final SpigotPlugin instance = UtilPlugin.getInstance();

        for (final Class<? extends SpigotManager> clazz : getManagerClasses()) {
            try {
                instance.addManager(clazz.getConstructor(SpigotPlugin.class).newInstance(instance));
            } catch (final Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void shutdown() {
        final SpigotPlugin instance = UtilPlugin.getInstance();

        for (final Class<? extends SpigotManager> clazz : getManagerClasses()) {
            final SpigotManager manager = instance.getManagerByClass(clazz);
            if (manager == null) {
                continue;
            }

            instance.removeManager(manager);
        }
    }

    private static List<Class<? extends SpigotManager>> getManagerClasses() {
        return Arrays.asList(BloodManager.class, BuildManager.class, RoleManager.class, SkillManager.class);
    }
}