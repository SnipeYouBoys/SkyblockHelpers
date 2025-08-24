package com.snipeyouboys.skyblockhelpers.Helpers;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

public class PressureWarning {
    public static boolean enabled = true;
    public static int Y_Level = 77;
    public static int volume = 100;
    
    private static int tickcount = 0;
    
    public static void init(){
    ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client.player == null || client.world == null || client.isPaused()) return;
            ClientPlayerEntity player = client.player;
            if(!enabled) return;
            Vec3d pos = player.getPos(); double y = pos.y;
            if (isInWater(player) && y < Y_Level){
                client.player.sendMessage(Text.literal("SWIM UP"), true);
                if (tickcount > 5){
                    playSound();
                    tickcount = 0;
                }
            }
            else{
                tickcount = 0;
            }
            tickcount++;
        });
    }
    
    public static void toggle(){
        enabled = !enabled;
    }
    public static boolean isInWater(ClientPlayerEntity player){
        BlockPos pos = player.getBlockPos();
        BlockState state = player.clientWorld.getBlockState(pos);
        return state.isOf(Blocks.WATER);
    }
    private static void playSound(){
        MinecraftClient client = MinecraftClient.getInstance();
        client.player.playSound(
            SoundEvents.BLOCK_COPPER_GRATE_BREAK,
            (float) volume/100f, // volume
            1f  // pitch
        );
    }
}
