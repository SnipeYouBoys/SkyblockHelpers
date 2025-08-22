package com.snipeyouboys.skyblockhelpers.mixin.client;

import com.snipeyouboys.skyblockhelpers.Helpers.SmallHand;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.HeldItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(HeldItemRenderer.class)
public class SmallHandMixin {

    @Inject(method = "renderFirstPersonItem", at = @At("HEAD"))
    private void moveHandIfEnabled(AbstractClientPlayerEntity player,
                                    float tickDelta,
                                    float pitch,
                                    Hand hand,
                                    float swingProgress,
                                    ItemStack item,
                                    float equipProgress,
                                    MatrixStack matrices,
                                    VertexConsumerProvider vertexConsumers,
                                    int light,
                                    CallbackInfo ci) {
        if (SmallHand.enabled) {
            float size = ((float) SmallHand.size)/100;
            double z = getHandDistance(size);
            matrices.translate(-z/2, (z/4), z);
        }
    }
    private static double getHandDistance(double s) {
        s = Math.max(0.1, Math.min(1.0, s));
        return 2.0 * (Math.log(s) / Math.log(2.0));
    }
}