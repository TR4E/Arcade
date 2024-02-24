package me.trae.arcade.utility;

import me.trae.champions.Champions;
import me.trae.core.framework.SpigotFactory;
import me.trae.core.framework.SpigotPlugin;
import me.trae.core.utility.UtilPlugin;

public class UtilChampions {

    public static void initialize() {
        final SpigotPlugin instance = UtilPlugin.getInstance();

        final SpigotFactory factory = instance.getFactoryByClass(Champions.class);

        factory.initialize(instance);
    }

    public static void shutdown() {
        final SpigotPlugin instance = UtilPlugin.getInstance();

        instance.getFactoryByClass(Champions.class).shutdown(instance);
    }
}