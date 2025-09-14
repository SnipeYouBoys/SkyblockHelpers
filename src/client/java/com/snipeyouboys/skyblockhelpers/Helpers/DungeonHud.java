package com.snipeyouboys.skyblockhelpers.Helpers;

import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.network.PlayerListEntry;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.render.RenderTickCounter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DungeonHud {
    public static boolean enabled = true;

    static MinecraftClient client = MinecraftClient.getInstance();
    public static List<String> searchStrings = new ArrayList<>();

    @SuppressWarnings("deprecation")
    public static void init() {
        
        searchStrings.add("team deaths:");
        searchStrings.add("secrets found:");
        searchStrings.add("crypts:");
        searchStrings.add("completed rooms:");
        searchStrings.add("downed:");
        searchStrings.add("your milestone:");
        
        HudRenderCallback.EVENT.register((DrawContext drawContext, RenderTickCounter tickCounter) -> {
            if (!enabled || client.world == null || client.player == null) return;

            ClientPlayNetworkHandler networkHandler = client.getNetworkHandler();
            if (networkHandler == null) return;

            Collection<PlayerListEntry> entriesCollection = networkHandler.getListedPlayerListEntries();
            List<PlayerListEntry> entries = new ArrayList<>(entriesCollection);

            List<String> lines = new ArrayList<>();
            for (PlayerListEntry entry : entries) {
                String line = entry.getDisplayName() != null ? entry.getDisplayName().getString() : entry.getProfile().getName();
                boolean found = searchStrings.stream().anyMatch(string -> line.toLowerCase().contains(string.toLowerCase()));
                if (line.toLowerCase().contains("secrets found:") && line.contains("%")) continue;  //this is to prevent both "secrets found" from showing up (one is a count and one is a percent)
                if (found) {
                    lines.add(line);
                }
            }

            int padding = 2;
            int yStart = 160;
            int x = 2;
            int height = client.textRenderer.fontHeight;

            for (int i = 0; i < lines.size(); i++) {
                String line = lines.get(i);
                int colour = 0xFFFFFFFF;
                if (line.toLowerCase().contains("team deaths:")) {
                    colour = 0xFFFF9090; //red
                }
                if (line.toLowerCase().contains("secrets found:")) {
                    colour = 0xFF90FFFF; //cyan
                }
                if (line.toLowerCase().contains("crypts:")) {
                    colour = 0xFF9090FF; //blue
                }
                if (line.toLowerCase().contains("completed rooms:")) {
                    colour = 0xFF90FF90; //green
                }
                if (line.toLowerCase().contains("downed:")) {
                    colour = 0xFFFFFF90; //yellow
                }
                if (line.toLowerCase().contains("your milestone:")) {
                    colour = 0xFFFF90FF; //magenta
                }
                int y = yStart + ((padding + height) * (i + 1));
                drawContext.drawTextWithShadow(client.textRenderer, line.trim(), x, y, colour);
            }
        });
    }
}