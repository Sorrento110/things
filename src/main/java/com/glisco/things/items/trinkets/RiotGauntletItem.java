package com.glisco.things.items.trinkets;

import com.glisco.things.ThingsCommon;
import com.glisco.things.items.TrinketItemWithOptionalTooltip;
import dev.emi.trinkets.api.SlotReference;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;

import java.util.Collections;
import java.util.List;

public class RiotGauntletItem extends TrinketItemWithOptionalTooltip {

    public RiotGauntletItem() {
        super(new Settings().maxCount(1).group(ThingsCommon.THINGS_GROUP));
    }

    @Override
    public List<Text> getExtendedTooltip() {
        return Collections.singletonList(new LiteralText("§7Grants permanent Strength"));
    }

    @Override
    public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {
        if (!(entity instanceof ServerPlayerEntity player)) return;

        player.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 5,
                ThingsCommon.CONFIG.effectLevels.riotGauntletStrength - 1, true, false, true));
    }

}