package com.snipeyouboys.skyblockhelpers.mixin.client;


import com.snipeyouboys.skyblockhelpers.Helpers.SlowHand;
import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public class SlowHandMixin {

    @Inject(method = "getHandSwingDuration", at = @At("RETURN"), cancellable = true)
    private void modifySwingDuration(CallbackInfoReturnable<Integer> cir) {
        if (SlowHand.enabled) {
            int original = cir.getReturnValue();
            float factor = SlowHand.speed / 100f;

            int modified = Math.max(1, (int)(original / factor));
            cir.setReturnValue(modified);
        }
    }
}