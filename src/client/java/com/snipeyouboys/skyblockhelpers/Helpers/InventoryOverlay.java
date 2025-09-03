package com.snipeyouboys.skyblockhelpers.Helpers;

import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;

public class InventoryOverlay {
    public static boolean enabled = false;
    public static boolean corner = false;
    
    private static final MinecraftClient client = MinecraftClient.getInstance();

    @SuppressWarnings("deprecation")
    public static void init() {
        HudRenderCallback.EVENT.register((DrawContext drawContext, RenderTickCounter tickCounter) -> {
            if (!enabled || client.player == null) return;
            PlayerInventory inv = client.player.getInventory();
            
            int screenWidth = drawContext.getScaledWindowWidth();
            int screenHeight = drawContext.getScaledWindowHeight();

            int totalWidth = 9 * 18;
            int totalHeight = 3 * 18;

            int startX = (screenWidth/2) - (totalWidth/2);
            int startY = (screenHeight - totalHeight) - 80;

            if (corner){
                startX = screenWidth - totalWidth - 8;
                startY = (screenHeight - totalHeight) - 8;
            }

            for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 9; col++) {
                int slot = 9 + row * 9 + col;
                
                int drawX = startX + col * 18;
                int drawY = startY + row * 18;
                
                ItemStack stack = inv.getStack(slot);
                
                int count = stack.getCount();
                String countString = Integer.toString(count);
                if (count <= 1){ countString = ""; }
                int w = client.textRenderer.getWidth(countString);
                int h = client.textRenderer.fontHeight;

                drawContext.drawItem(stack, drawX, drawY);
                
                drawContext.getMatrices().push();
                drawContext.getMatrices().translate(0, 0, 200);
                
                drawContext.drawTextWithShadow(
                client.textRenderer,
                countString,
                drawX+(18-w),
                drawY+h,
                0xFFFFFFFF //White - AARRGGBB
                );
                drawContext.getMatrices().pop();
            }
        }
        });
    }

}
