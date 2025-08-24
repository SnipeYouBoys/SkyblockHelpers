package com.snipeyouboys.skyblockhelpers.Helpers;


import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;

import java.util.ArrayList;
import java.util.List;

public class CleanTooltip {
    public static boolean enabled = true;

    private static final List<String> filterStrings = new ArrayList<>();

    public static void init() {
        filterStrings.add("Fuel Tank");
        filterStrings.add("Drill Engine"); 
        filterStrings.add("installed");
        filterStrings.add("Drill Mechanic");
        filterStrings.add("Upgrade Module");
        filterStrings.add("fuel capacity");
        filterStrings.add("installed.");
        filterStrings.add("Drill Parts");
        filterStrings.add("passive upgrade");
        filterStrings.add("Grants");
        filterStrings.add("with part");
        ItemTooltipCallback.EVENT.register((ItemStack stack, Item.TooltipContext ctx, TooltipType type, List<Text> lines) -> {
            if (!enabled) return;
            
            lines.removeIf(line -> {
                String text = line.getString();
                for (String filter : filterStrings) {
                    if (text.contains(filter)) {
                        return true;
                    }
                }
                return false;
            });
        });
    }
}