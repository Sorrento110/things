package com.glisco.things.items.trinkets;

import com.glisco.things.ThingsCommon;
import com.glisco.things.items.TrinketItemWithOptionalTooltip;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;

import java.util.ArrayList;
import java.util.List;

public class PlaceboItem extends TrinketItemWithOptionalTooltip {

    private static final List<Text> TOOLTIP;

    static {
        TOOLTIP = new ArrayList<>();
        TOOLTIP.add(new LiteralText("§7Grants a 25% chance to not consume"));
        TOOLTIP.add(new LiteralText("§7a potion when equipped"));
    }

    public PlaceboItem() {
        super(new Settings().maxCount(1).group(ThingsCommon.THINGS_GROUP));
    }

    @Override
    public List<Text> getExtendedTooltip() {
        return TOOLTIP;
    }
}
