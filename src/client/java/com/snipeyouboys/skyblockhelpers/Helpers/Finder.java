package com.snipeyouboys.skyblockhelpers.Helpers;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.math.Vec3d;

public class Finder {
    static MinecraftClient client = MinecraftClient.getInstance();
    public static List<Float> angles = new ArrayList<>();
    public static List<Vec3d> positions = new ArrayList<>();

    public static Vec3d target = null;
    
    
    public static void addNewAngle(){
        if (client.player == null || client.world == null || client.isPaused()) return;
        ClientPlayerEntity player = client.player;
        float yaw = player.getYaw();
        yaw %= 360.0f;
        if (yaw >= 180.0f) yaw -= 360.0f;
        if (yaw < -180.0f) yaw += 360.0f;
        if (angles.size() >= 2) {
            angles.remove(0);
        }
        angles.add(yaw);
        Vec3d pos = player.getPos();
        if (positions.size() >= 2) {
            positions.remove(0);
        }
        positions.add(pos);
        
        player.sendMessage(Text.literal("§7Added new measurement as §r" + Math.round(yaw) + " at " + Math.round(pos.x) + " " + Math.round(pos.z)), false);
        
        if (angles.size() >= 2 && positions.size() >= 2){
            target = findTarget(angles.get(0), positions.get(0), angles.get(1), positions.get(1));
        }
        
        if (target != null){
            player.sendMessage(Text.literal("§7Target is at"), false);
            player.sendMessage(Text.literal(Math.round(target.x) + " " + Math.round(target.y) + " " + Math.round(target.z)), false);
        }else{
            if (angles.size() >= 2 && positions.size() >= 2){
                player.sendMessage(Text.literal("Could not find target"), false);
            }
        }
    }
    
    
    public static Vec3d findTarget(float ang1, Vec3d pos1, float ang2, Vec3d pos2) {
        Vec3d dir1 = yawToDir(ang1);
        Vec3d dir2 = yawToDir(ang2);

        double x1 = pos1.x, z1 = pos1.z;
        double x2 = pos2.x, z2 = pos2.z;
        double dx1 = dir1.x, dz1 = dir1.z;
        double dx2 = dir2.x, dz2 = dir2.z;

        double det = dx1 * dz2 - dz1 * dx2;
        if (Math.abs(det) < 1e-6) {
            return null; //the imaginary lines dont intersect
        }

        double t = ((x2 - x1) * dz2 - (z2 - z1) * dx2) / det;
        double ix = x1 + t * dx1;
        double iz = z1 + t * dz1;
        double iy = (pos1.y + pos2.y) / 2.0; // average Y height

        return new Vec3d(ix, iy, iz);
    }

    private static Vec3d yawToDir(float yaw) {
        double rad = Math.toRadians(yaw);
        double dx = -Math.sin(rad);
        double dz =  Math.cos(rad);
        return new Vec3d(dx, 0, dz).normalize();
    }
}