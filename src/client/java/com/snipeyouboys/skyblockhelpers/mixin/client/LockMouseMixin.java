package com.snipeyouboys.skyblockhelpers.mixin.client;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.snipeyouboys.skyblockhelpers.Helpers.MouseLock;

@Mixin(net.minecraft.client.Mouse.class)
public class LockMouseMixin {
    @Inject(method = "updateMouse", at = @At("HEAD"), cancellable = true)
    private void lockMouse(CallbackInfo ci) {
        if (MouseLock.enabled) {
            ci.cancel();
        }
    }
}