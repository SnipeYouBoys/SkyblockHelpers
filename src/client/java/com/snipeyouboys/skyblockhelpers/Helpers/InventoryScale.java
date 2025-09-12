package com.snipeyouboys.skyblockhelpers.Helpers;

import net.fabricmc.fabric.api.client.rendering.v1.WorldRenderEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;

public class InventoryScale {

    public static boolean enabled = false;
    public static int normalScale = 2;
    public static int customScale = 3;
    private static boolean applied = false;
    
    static MinecraftClient client = MinecraftClient.getInstance();

    public static void init() {
        WorldRenderEvents.START.register(ctx -> {
            if (client.world == null || !enabled) return;

            Screen screen = client.currentScreen;

            if (isInventory(screen)) {
                applyCustomScale(client);
            } else {
                restoreScale(client);
            }
        });
    }

    private static boolean isInventory(Screen screen) {
        return screen instanceof InventoryScreen || screen instanceof HandledScreen<?>;
    }

    private static void applyCustomScale(MinecraftClient client) {
        if (!applied) {
            client.options.getGuiScale().setValue(customScale);
            client.onResolutionChanged();
            applied = true;
        }
    }

    private static void restoreScale(MinecraftClient client) {
        if (applied) {
            client.options.getGuiScale().setValue(normalScale);
            client.onResolutionChanged();
            applied = false;
        }
    }
}