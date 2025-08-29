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
    public static boolean cleanDrills = true;
    public static boolean removeEmpty = true;

    private static final List<String> drillFilterStrings = new ArrayList<>();

    public static void init() {
        drillFilterStrings.add("installed");
        drillFilterStrings.add("Drill Mechanic");
        drillFilterStrings.add("Upgrade Module");
        drillFilterStrings.add("fuel capacity");
        drillFilterStrings.add("installed.");
        drillFilterStrings.add("Drill Parts");
        drillFilterStrings.add("passive upgrade");
        drillFilterStrings.add("with part");
        drillFilterStrings.add("Grants");
        drillFilterStrings.add("DRILL");
        drillFilterStrings.add("ores to drop");
        drillFilterStrings.add("increases your chance");
        drillFilterStrings.add("drops.");
        drillFilterStrings.add("Fleet Bonus");
        drillFilterStrings.add("Cooldown");
        drillFilterStrings.add("Consecutive blocks");
        drillFilterStrings.add("Stops after");
        drillFilterStrings.add("not mining and caps");
        drillFilterStrings.add("Throw your pickaxe");
        drillFilterStrings.add("explosion mining all ores");
        drillFilterStrings.add("radius.");
        drillFilterStrings.add("mining Blocks.");
        drillFilterStrings.add("minecraft:prismarine_shard");
        drillFilterStrings.add("component(s)");
        drillFilterStrings.add("how quickly your tool");
        drillFilterStrings.add("breaks blocks.");
        drillFilterStrings.add("Durability");
        drillFilterStrings.add("Ability");
        drillFilterStrings.add("Bonus");
        drillFilterStrings.add("Earn");
        drillFilterStrings.add("Automatically smelts");
        drillFilterStrings.add("smelted form");
        drillFilterStrings.add("15s");
        
        ItemTooltipCallback.EVENT.register((ItemStack stack, Item.TooltipContext ctx, TooltipType type, List<Text> lines) -> {
            if (!enabled) return;    
            
            boolean isDrill = stack.getName().getString().contains("Drill");

            lines.removeIf(line -> {
                String text = line.getString();
                
                if (text.isEmpty() && removeEmpty) return true;
                
                for (String filter : drillFilterStrings) {
                    if (text.contains(filter) && cleanDrills && isDrill) {
                        return true;
                    }
                }
                return false;
            });
        });
    }
}