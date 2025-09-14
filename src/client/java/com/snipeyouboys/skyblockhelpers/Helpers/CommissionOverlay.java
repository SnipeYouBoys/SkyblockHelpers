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

public class CommissionOverlay {
    public static boolean enabled = true;

    static MinecraftClient client = MinecraftClient.getInstance();
    public static List<String> commissionStrings = new ArrayList<>();

    @SuppressWarnings("deprecation")
    public static void init() {
        
        //dwarves
        commissionStrings.add("Mithril"); //all mithril comms
        commissionStrings.add("Titanium"); //all tita comms
        commissionStrings.add("Goblin"); //goblins AND goblin raid
        commissionStrings.add("Glacite Walker");
        commissionStrings.add("Treasure Hoarder");
        commissionStrings.add("Star Sentry");
        commissionStrings.add("Raffle");
        
        //hollows
        commissionStrings.add("Hard Stone");
        commissionStrings.add("Gemstone"); //all gemstone comms
        commissionStrings.add("Chest Looter");
        commissionStrings.add("Slayer"); //all slay * mob comms
        commissionStrings.add("Hunter"); //all hunt * crystal comms

        //tunnels
        commissionStrings.add("Mineshaft Explorer");
        commissionStrings.add("Corpse Looter");
        commissionStrings.add("Glacite");
        commissionStrings.add("Umber");
        commissionStrings.add("Tungsten");
        commissionStrings.add("Scrap");
        
        HudRenderCallback.EVENT.register((DrawContext drawContext, RenderTickCounter tickCounter) -> {
            if (!enabled || client.world == null || client.player == null) return;

            ClientPlayNetworkHandler networkHandler = client.getNetworkHandler();
            if (networkHandler == null) return;

            Collection<PlayerListEntry> entriesCollection = networkHandler.getListedPlayerListEntries();
            List<PlayerListEntry> entries = new ArrayList<>(entriesCollection);

            List<String> commissions = new ArrayList<>();
            for (PlayerListEntry entry : entries) {
                String line = entry.getDisplayName() != null ? entry.getDisplayName().getString() : entry.getProfile().getName();
                if ((line.contains("%")) || (line.contains("DONE"))) {
                    boolean found = commissionStrings.stream().anyMatch(string -> line.toLowerCase().contains(string.toLowerCase()));
                    if (found) {
                        commissions.add(line);
                    }
                }
            }

            int padding = 2;
            int yStart = 32;
            int x = 2;
            int height = client.textRenderer.fontHeight;

            for (int i = 0; i < commissions.size(); i++) {
                String line = commissions.get(i);
                int y = yStart + ((padding + height) * (i + 1));
                int colour = 0xFFFFFFFF;
                if (line.contains("DONE")) {
                    colour = 0xFF90FF90;
                }
                drawContext.drawTextWithShadow(client.textRenderer, line.trim(), x, y, colour);
            }
        });
    }
}