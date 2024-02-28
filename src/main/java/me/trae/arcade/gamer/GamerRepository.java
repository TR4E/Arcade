package me.trae.arcade.gamer;

import me.trae.arcade.gamer.enums.GamerProperty;
import me.trae.core.gamer.local.LocalGamerRepository;

public class GamerRepository extends LocalGamerRepository<GamerManager, Gamer, GamerProperty> {

    public GamerRepository(final GamerManager manager) {
        super(manager);
    }
}