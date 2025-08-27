package com.snipeyouboys.skyblockhelpers.Helpers;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
public class AutoSkyblock {
    public static boolean enabled = true;

    static MinecraftClient client = MinecraftClient.getInstance();
    static boolean sentCommand = false;
    
    public static void init() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {    
            if (client.player == null) return;
            String firstSlotItemName = client.player.getInventory().getStack(0).getName().getString();
            if (firstSlotItemName.contains("Game Menu")){
                if (!sentCommand && enabled){
                    client.player.networkHandler.sendChatCommand("skyblock");
                    sentCommand = true;
                }
            }else{
                sentCommand = false;
            }
        });
    }
}