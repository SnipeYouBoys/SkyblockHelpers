package com.snipeyouboys.skyblockhelpers.Helpers;

import java.util.List;

import com.snipeyouboys.skyblockhelpers.mixin.client.ScreenTitleMixin;

import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.fabricmc.fabric.api.client.rendering.v1.WorldRenderEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.GenericContainerScreen;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;

public class StorageRename {
    public static boolean enabled = true;
    public static boolean isStorage = false;
    public static int currentPage = 1;
    public static boolean isBackpack = false;
    
    
    public static String echest1Name = "EChest 1";
    public static String echest2Name = "EChest 2";
    public static String echest3Name = "EChest 3";
    public static String echest4Name = "EChest 4";
    public static String echest5Name = "EChest 5";
    public static String echest6Name = "EChest 6";
    public static String echest7Name = "EChest 7";
    public static String echest8Name = "EChest 8";
    public static String echest9Name = "EChest 9";

    public static String backpack1Name = "Backpack 1";
    public static String backpack2Name = "Backpack 2";
    public static String backpack3Name = "Backpack 3";
    public static String backpack4Name = "Backpack 4";
    public static String backpack5Name = "Backpack 5";
    public static String backpack6Name = "Backpack 6";
    public static String backpack7Name = "Backpack 7";
    public static String backpack8Name = "Backpack 8";
    public static String backpack9Name = "Backpack 9";
    public static String backpack10Name = "Backpack 10";
    public static String backpack11Name = "Backpack 11";
    public static String backpack12Name = "Backpack 12";
    public static String backpack13Name = "Backpack 13";
    public static String backpack14Name = "Backpack 14";
    public static String backpack15Name = "Backpack 15";
    public static String backpack16Name = "Backpack 16";
    public static String backpack17Name = "Backpack 17";
    public static String backpack18Name = "Backpack 18";
    

    static MinecraftClient client = MinecraftClient.getInstance();

    public static void init() {
        //renaming container title
        WorldRenderEvents.START.register(ctx -> {
            if (client.world == null) return;
            currentPage = 1;
            isBackpack = false;
            isStorage = false;
            Screen screen = client.currentScreen;
            if (!isContainer(screen)) return;
            String title = screen.getTitle().getString();
            
            // Ender Chest pages
            if (title.startsWith("Ender Chest (")) {
                isStorage = true;
                isBackpack = false;
                int start = title.indexOf("(") + 1;
                int end = title.indexOf("/", start);
                
                if (start > 0 && end > start) {
                    String numberString = title.substring(start, end);
                    try {
                        currentPage = Integer.parseInt(numberString);
                    } catch (NumberFormatException ignored) {}
                }
            }
            // Backpacks
            else if (title.contains("Backpack")) {
                isStorage = true;
                isBackpack = true;
                int hash = title.indexOf("#");
                int end = title.indexOf(")", hash);
                
                if (hash != -1 && end > hash) {
                    String numberString = title.substring(hash + 1, end).trim();
                    try {
                        currentPage = Integer.parseInt(numberString);
                    } catch (NumberFormatException ignored) {}
                }
            }
        
            if (!isStorage) return;
            if (!enabled) return;

            if (isBackpack) {
                if (currentPage == 1) { setScreenTitle(backpack1Name); }
                if (currentPage == 2) { setScreenTitle(backpack2Name); }
                if (currentPage == 3) { setScreenTitle(backpack3Name); }
                if (currentPage == 4) { setScreenTitle(backpack4Name); }
                if (currentPage == 5) { setScreenTitle(backpack5Name); }
                if (currentPage == 6) { setScreenTitle(backpack6Name); }
                if (currentPage == 7) { setScreenTitle(backpack7Name); }
                if (currentPage == 8) { setScreenTitle(backpack8Name); }
                if (currentPage == 9) { setScreenTitle(backpack9Name); }
                if (currentPage == 10) { setScreenTitle(backpack10Name); }
                if (currentPage == 11) { setScreenTitle(backpack11Name); }
                if (currentPage == 12) { setScreenTitle(backpack12Name); }
                if (currentPage == 13) { setScreenTitle(backpack13Name); }
                if (currentPage == 14) { setScreenTitle(backpack14Name); }
                if (currentPage == 15) { setScreenTitle(backpack15Name); }
                if (currentPage == 16) { setScreenTitle(backpack16Name); }
                if (currentPage == 17) { setScreenTitle(backpack17Name); }
                if (currentPage == 18) { setScreenTitle(backpack18Name); }
            } else {
                if (currentPage == 1) { setScreenTitle(echest1Name); }
                if (currentPage == 2) { setScreenTitle(echest2Name); }
                if (currentPage == 3) { setScreenTitle(echest3Name); }
                if (currentPage == 4) { setScreenTitle(echest4Name); }
                if (currentPage == 5) { setScreenTitle(echest5Name); }
                if (currentPage == 6) { setScreenTitle(echest6Name); }
                if (currentPage == 7) { setScreenTitle(echest7Name); }
                if (currentPage == 8) { setScreenTitle(echest8Name); }
                if (currentPage == 9) { setScreenTitle(echest9Name); }
            }


        });
        
        //renaming echest/backpack opening button items
        ItemTooltipCallback.EVENT.register((ItemStack stack, Item.TooltipContext ctx, TooltipType type, List<Text> lines) -> {
            Boolean isStorageItem = false;
            Boolean isBackpack = false;
            int number = 1;
            if (!enabled) return;
            if (lines.isEmpty()) return;
            String firstTooltipLine = lines.get(0).getString();
            String[] parts = firstTooltipLine.split(" ");
            if (parts.length == 0) return;
            String last = parts[parts.length - 1];
            
            if (firstTooltipLine.contains("Ender Chest Page")) {
                isStorageItem = true;
                isBackpack = false;
                try {
                    number = Integer.parseInt(last);
                } catch (NumberFormatException ignored) {}
            }

            if (firstTooltipLine.contains("Backpack Slot")) {
                isStorageItem = true;
                isBackpack = true;
                try {
                    number = Integer.parseInt(last);
                } catch (NumberFormatException ignored) {}
            }

            //backpacks
            if (!isStorageItem) return;
            lines.remove(0);
            if (isBackpack){
                if (number == 1) { lines.addFirst(Text.literal(StorageRename.backpack1Name)); }
                if (number == 2) { lines.addFirst(Text.literal(StorageRename.backpack2Name)); }
                if (number == 3) { lines.addFirst(Text.literal(StorageRename.backpack3Name)); }
                if (number == 4) { lines.addFirst(Text.literal(StorageRename.backpack4Name)); }
                if (number == 5) { lines.addFirst(Text.literal(StorageRename.backpack5Name)); }
                if (number == 6) { lines.addFirst(Text.literal(StorageRename.backpack6Name)); }
                if (number == 7) { lines.addFirst(Text.literal(StorageRename.backpack7Name)); }
                if (number == 8) { lines.addFirst(Text.literal(StorageRename.backpack8Name)); }
                if (number == 9) { lines.addFirst(Text.literal(StorageRename.backpack9Name)); }
                if (number == 10) { lines.addFirst(Text.literal(StorageRename.backpack10Name)); }
                if (number == 11) { lines.addFirst(Text.literal(StorageRename.backpack11Name)); }
                if (number == 12) { lines.addFirst(Text.literal(StorageRename.backpack12Name)); }
                if (number == 13) { lines.addFirst(Text.literal(StorageRename.backpack13Name)); }
                if (number == 14) { lines.addFirst(Text.literal(StorageRename.backpack14Name)); }
                if (number == 15) { lines.addFirst(Text.literal(StorageRename.backpack15Name)); }
                if (number == 16) { lines.addFirst(Text.literal(StorageRename.backpack16Name)); }
                if (number == 17) { lines.addFirst(Text.literal(StorageRename.backpack17Name)); }
                if (number == 18) { lines.addFirst(Text.literal(StorageRename.backpack18Name)); }
            }
            
            //echests
            if (!isBackpack) {
                if (number == 1) { lines.addFirst(Text.literal(StorageRename.echest1Name)); }
                if (number == 2) { lines.addFirst(Text.literal(StorageRename.echest2Name)); }
                if (number == 3) { lines.addFirst(Text.literal(StorageRename.echest3Name)); }
                if (number == 4) { lines.addFirst(Text.literal(StorageRename.echest4Name)); }
                if (number == 5) { lines.addFirst(Text.literal(StorageRename.echest5Name)); }
                if (number == 6) { lines.addFirst(Text.literal(StorageRename.echest6Name)); }
                if (number == 7) { lines.addFirst(Text.literal(StorageRename.echest7Name)); }
                if (number == 8) { lines.addFirst(Text.literal(StorageRename.echest8Name)); }
                if (number == 9) { lines.addFirst(Text.literal(StorageRename.echest9Name)); }
            }
        });
    }
    
    
    public static void setScreenTitle(String newTitle) {
        Screen screen = client.currentScreen;
        if (newTitle == null) newTitle = "Storage Title Is null :(";
        if (screen != null) {
            ((ScreenTitleMixin) screen).setTitle(Text.literal(newTitle));
        }
    }

    private static boolean isContainer(Screen screen) {
        return screen instanceof GenericContainerScreen;
    }
}
