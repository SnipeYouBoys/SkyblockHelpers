package com.snipeyouboys.skyblockhelpers;

import com.mojang.brigadier.CommandDispatcher;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;

import com.snipeyouboys.skyblockhelpers.Helpers.Clock;
import com.snipeyouboys.skyblockhelpers.Helpers.InventoryScale;
import com.snipeyouboys.skyblockhelpers.Helpers.PressureWarning;
import com.snipeyouboys.skyblockhelpers.Helpers.SmallHand;

import static net.fabricmc.fabric.api.client.command.v2.ClientCommandManager.*;
import com.mojang.brigadier.arguments.BoolArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;



public class Commands {  
    static MinecraftClient client = MinecraftClient.getInstance();
    public static void init() {
        ClientCommandRegistrationCallback.EVENT.register((dispatcher, registryAccess) -> registerCommands(dispatcher));
    }

    private static void registerCommands(CommandDispatcher<FabricClientCommandSource> dispatcher) {
        dispatcher.register(literal("skyblockhelpers")
            .then(literal("pressurewarning")
                .then(literal("enabled")
                    .then(argument("enabled", BoolArgumentType.bool())
                        .executes(ctx -> {
                            boolean enabled = BoolArgumentType.getBool(ctx, "enabled");
                            PressureWarning.enabled = enabled;
                            if(enabled)client.player.sendMessage(Text.literal("§7PressureWarning has been §9enabled"), false);
                            else client.player.sendMessage(Text.literal("§7PressureWarning has been §cdisabled"), false);
                            return 1;
                        })
                    )
                )
                .then(literal("YLevel")
                    .then(argument("YLevel", IntegerArgumentType.integer())
                        .executes(ctx -> {
                            int yLevel = IntegerArgumentType.getInteger(ctx, "YLevel");
                            PressureWarning.Y_Level = yLevel;
                            client.player.sendMessage(Text.literal("§7PressureWarning Y Level has been set to §9" + yLevel), false);
                            return 1;
                        })
                    )
                )
            )

            .then(literal("inventoryscale")
                .then(literal("containerscale")
                    .then(argument("containerscale", IntegerArgumentType.integer())
                        .executes(ctx -> {
                            int scale = IntegerArgumentType.getInteger(ctx, "containerscale");
                            if (scale > 4){
                                scale = 4;
                            }
                            if (scale < 0){
                                scale = 0;
                            }
                            InventoryScale.customScale = scale;
                            client.player.sendMessage(Text.literal("§7Inventory/Container GUI scale has been set to §9 " + scale), false);
                            return 1;
                        })
                    )
                )
                .then(literal("normalscale")
                    .then(argument("normalscale", IntegerArgumentType.integer())
                        .executes(ctx -> {
                            int scale = IntegerArgumentType.getInteger(ctx, "normalscale");
                            if (scale > 4){
                                scale = 4;
                            }
                            if (scale < 0){
                                scale = 0;
                            }
                            InventoryScale.normalScale = scale;
                            client.player.sendMessage(Text.literal("§7Normal GUI scale has been set to §9 " + scale), false);
                            return 1;
                        })
                    )
                )
            )
            
            .then(literal("smallhand")
                .then(literal("enabled")
                    .then(argument("enabled", BoolArgumentType.bool())
                        .executes(ctx -> {
                            boolean enabled = BoolArgumentType.getBool(ctx, "enabled");
                            SmallHand.enabled = enabled;
                            if(enabled)client.player.sendMessage(Text.literal("§7SmallHand has been §9enabled"), false);
                            else client.player.sendMessage(Text.literal("§7SmallHand has been §cdisabled"), false);
                            return 1;
                        })
                    )
                )
                .then(literal("size")
                    .then(argument("size", IntegerArgumentType.integer(10, 100))
                        .executes(ctx -> {
                            int size = IntegerArgumentType.getInteger(ctx, "size");
                            SmallHand.size = size;
                            client.player.sendMessage(Text.literal("§7SmallHand Size has been set to §9" + size), false);
                            return 1;
                        })
                    )
                )
            )
            
            .then(literal("clock")
                .then(literal("enabled")
                    .then(argument("enabled", BoolArgumentType.bool())
                        .executes(ctx -> {
                            boolean enabled = BoolArgumentType.getBool(ctx, "enabled");
                            Clock.enabled = enabled;
                            if(enabled)client.player.sendMessage(Text.literal("§7Clock has been §9enabled"), false);
                            else client.player.sendMessage(Text.literal("§7Clock has been §cdisabled"), false);
                            return 1;
                        })
                    )
                )
                .then(literal("UTCOffset")
                    .then(argument("UTCOffset", IntegerArgumentType.integer(-11, 12))
                        .executes(ctx -> {
                            int utcOffset = IntegerArgumentType.getInteger(ctx, "UTCOffset");
                            Clock.utcOffset = utcOffset;
                            client.player.sendMessage(Text.literal("§7Clock UTC Offset has been set to §9" + utcOffset), false);
                            return 1;
                        })
                    )
                )
            )

            .executes(ctx -> {
                // If just /skyblockhelpers is run without args
                ctx.getSource().getPlayer().sendMessage(Text.literal("§Not a Valid SkyblockHelpers Command"), false);
                return 1;
            })
        );
    }

}