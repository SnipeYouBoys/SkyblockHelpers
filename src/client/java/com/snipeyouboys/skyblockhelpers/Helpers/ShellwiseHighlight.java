package com.snipeyouboys.skyblockhelpers.Helpers;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.TurtleEntity;
import net.minecraft.particle.ParticleTypes;

public class ShellwiseHighlight {

    public static boolean enabled = true;
    public static int radius = 20;

    static MinecraftClient client = MinecraftClient.getInstance();

    public static void init() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (!enabled || client.player == null) return;
                
            for (TurtleEntity entity : client.world.getEntitiesByClass(TurtleEntity.class, client.player.getBoundingBox().expand(radius), e -> true)) {
                for (int i = 0; i < 20; i++) {
                    client.world.addParticleClient(ParticleTypes.DRAGON_BREATH, entity.getX(), entity.getY() + entity.getHeight() + i/2, entity.getZ(), 0, 0, 0);
                }
            }
        });
    }
    public static boolean shouldEntityGlow(Entity entity){
        if (!(entity instanceof TurtleEntity)) return false;
        else {
            double dx = client.player.getX() - entity.getX(); double dy = client.player.getY() - entity.getY(); double dz = client.player.getZ() - entity.getZ();
            float distance = (float) Math.sqrt(dx*dx + dy*dy + dz*dz);
            if (distance > radius) return false;
            else return true;
        }
    }
}