package com.snipeyouboys.skyblockhelpers.mixin.client;

import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.snipeyouboys.skyblockhelpers.Helpers.ShellwiseHighlight;

@Mixin(Entity.class)
public class EntityGlowMixin {
    
    @Inject(method = "isGlowing", at = @At("HEAD"), cancellable = true)
    private void onIsGlowing(CallbackInfoReturnable<Boolean> cir) {
        Entity entity = (Entity) (Object) this;
        
        Boolean shouldGlow = ShellwiseHighlight.shouldEntityGlow(entity);
        if (shouldGlow != null) {
            cir.setReturnValue(shouldGlow);
        }
    }
}