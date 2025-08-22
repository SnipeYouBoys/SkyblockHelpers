package com.snipeyouboys.skyblockhelpers.Helpers;

import com.snipeyouboys.skyblockhelpers.TimeUtil;

import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;
public class Clock {
    public static boolean enabled = true;
    public static int utcOffset = 0;
    
    static MinecraftClient client = MinecraftClient.getInstance();
    
    @SuppressWarnings("deprecation")
    public static void init() {
        HudRenderCallback.EVENT.register((DrawContext drawContext, RenderTickCounter tickCounter) -> {
            if (!enabled || client.world == null || client.player == null) return;
            
            String time = TimeUtil.getTimeWithOffset(utcOffset);
            
            int textWidth = client.textRenderer.getWidth(time);
            int padding = 4;
            int x = client.getWindow().getScaledWidth() - textWidth - padding;
            int y = padding;
            drawContext.drawTextWithShadow(
                client.textRenderer,
                time,
                x,
                y,
                0xFFFFFFFF //White - AARRGGBB
            );
        });
    }
}
