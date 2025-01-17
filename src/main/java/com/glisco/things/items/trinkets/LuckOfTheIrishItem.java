package com.glisco.things.items.trinkets;

import com.glisco.things.ThingsCommon;
import com.glisco.things.client.SimplePlayerTrinketRenderer;
import com.glisco.things.items.TrinketItemWithOptionalTooltip;
import dev.emi.trinkets.api.client.TrinketRenderer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.util.math.Vec3f;

import java.util.Collections;
import java.util.List;

public class LuckOfTheIrishItem extends TrinketItemWithOptionalTooltip implements SimplePlayerTrinketRenderer {

    public LuckOfTheIrishItem() {
        super(new Settings().maxCount(1).group(ThingsCommon.THINGS_GROUP));
    }

    @Override
    public List<Text> getExtendedTooltip() {
        return Collections.singletonList(new LiteralText("§7Kinda turns Poisonous Potatoes into Golden Apples"));
    }

    @Override
    @Environment(EnvType.CLIENT)
    public void align(ClientPlayerEntity player, PlayerEntityModel<AbstractClientPlayerEntity> model, MatrixStack matrices, float headYaw, float headPitch) {
        TrinketRenderer.translateToChest(matrices, model, player);
        matrices.multiply(Vec3f.POSITIVE_X.getDegreesQuaternion(180));
        matrices.scale(.25f, .25f, .25f);
        matrices.translate(.45, 1, -.075);
    }
}
