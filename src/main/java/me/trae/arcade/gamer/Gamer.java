package me.trae.arcade.gamer;

import me.trae.arcade.gamer.enums.GamerProperty;
import me.trae.framework.shared.gamer.local.types.LocalGamer;
import me.trae.framework.shared.utility.objects.EnumData;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class Gamer extends LocalGamer<GamerProperty> {

    public Gamer(final UUID uuid) {
        super(uuid);
    }

    public Gamer(final EnumData<GamerProperty> data) {
        super(data);
    }

    @Override
    public Object getPropertyByValue(final GamerProperty property) {
        return null;
    }

    @Override
    public List<GamerProperty> getProperties() {
        return Arrays.asList(GamerProperty.values());
    }
}