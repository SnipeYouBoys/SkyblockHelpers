package com.snipeyouboys.skyblockhelpers;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.Text;

import org.lwjgl.glfw.GLFW;

import com.snipeyouboys.skyblockhelpers.Helpers.Finder;
import com.snipeyouboys.skyblockhelpers.Helpers.MouseLock;

public class Keybinds {

    // KeyBinding instances
    private static KeyBinding finderNewAngleKey;
    private static KeyBinding lockMouseKey;
    
    //echest + backpack keys (different formatting for less clutter)
    private static KeyBinding echest1Key; private static KeyBinding echest2Key; private static KeyBinding echest3Key;
    private static KeyBinding echest4Key; private static KeyBinding echest5Key; private static KeyBinding echest6Key;
    private static KeyBinding echest7Key; private static KeyBinding echest8Key; private static KeyBinding echest9Key;

    private static KeyBinding backpack1Key; private static KeyBinding backpack2Key; private static KeyBinding backpack3Key;
    private static KeyBinding backpack4Key; private static KeyBinding backpack5Key; private static KeyBinding backpack6Key;
    private static KeyBinding backpack7Key; private static KeyBinding backpack8Key; private static KeyBinding backpack9Key;
    private static KeyBinding backpack10Key; private static KeyBinding backpack11Key; private static KeyBinding backpack12Key;
    private static KeyBinding backpack13Key; private static KeyBinding backpack14Key; private static KeyBinding backpack15Key;
    private static KeyBinding backpack16Key; private static KeyBinding backpack17Key; private static KeyBinding backpack18Key;

    public static void init() {
        finderNewAngleKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
            "key.skyblockhelpers.findernewangle",
            InputUtil.Type.KEYSYM,
            GLFW.GLFW_KEY_U,
            "category.skyblockhelpers"
        ));
        
        lockMouseKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
            "key.skyblockhelpers.lockmouse",
            InputUtil.Type.KEYSYM,
            GLFW.GLFW_KEY_L,
            "category.skyblockhelpers"
        ));

        //echest + backpack keys (different formatting for less clutter)
        echest1Key = KeyBindingHelper.registerKeyBinding(new KeyBinding("key.skyblockhelpers.echest1", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_UNKNOWN, "category.skyblockhelpers"));
        echest2Key = KeyBindingHelper.registerKeyBinding(new KeyBinding("key.skyblockhelpers.echest2", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_UNKNOWN, "category.skyblockhelpers"));
        echest3Key = KeyBindingHelper.registerKeyBinding(new KeyBinding("key.skyblockhelpers.echest3", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_UNKNOWN, "category.skyblockhelpers"));
        echest4Key = KeyBindingHelper.registerKeyBinding(new KeyBinding("key.skyblockhelpers.echest4", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_UNKNOWN, "category.skyblockhelpers"));
        echest5Key = KeyBindingHelper.registerKeyBinding(new KeyBinding("key.skyblockhelpers.echest5", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_UNKNOWN, "category.skyblockhelpers"));
        echest6Key = KeyBindingHelper.registerKeyBinding(new KeyBinding("key.skyblockhelpers.echest6", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_UNKNOWN, "category.skyblockhelpers"));
        echest7Key = KeyBindingHelper.registerKeyBinding(new KeyBinding("key.skyblockhelpers.echest7", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_UNKNOWN, "category.skyblockhelpers"));
        echest8Key = KeyBindingHelper.registerKeyBinding(new KeyBinding("key.skyblockhelpers.echest8", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_UNKNOWN, "category.skyblockhelpers"));
        echest9Key = KeyBindingHelper.registerKeyBinding(new KeyBinding("key.skyblockhelpers.echest9", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_UNKNOWN, "category.skyblockhelpers"));

        backpack1Key = KeyBindingHelper.registerKeyBinding(new KeyBinding("key.skyblockhelpers.backpack1", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_UNKNOWN, "category.skyblockhelpers"));
        backpack2Key = KeyBindingHelper.registerKeyBinding(new KeyBinding("key.skyblockhelpers.backpack2", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_UNKNOWN, "category.skyblockhelpers"));
        backpack3Key = KeyBindingHelper.registerKeyBinding(new KeyBinding("key.skyblockhelpers.backpack3", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_UNKNOWN, "category.skyblockhelpers"));
        backpack4Key = KeyBindingHelper.registerKeyBinding(new KeyBinding("key.skyblockhelpers.backpack4", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_UNKNOWN, "category.skyblockhelpers"));
        backpack5Key = KeyBindingHelper.registerKeyBinding(new KeyBinding("key.skyblockhelpers.backpack5", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_UNKNOWN, "category.skyblockhelpers"));
        backpack6Key = KeyBindingHelper.registerKeyBinding(new KeyBinding("key.skyblockhelpers.backpack6", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_UNKNOWN, "category.skyblockhelpers"));
        backpack7Key = KeyBindingHelper.registerKeyBinding(new KeyBinding("key.skyblockhelpers.backpack7", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_UNKNOWN, "category.skyblockhelpers"));
        backpack8Key = KeyBindingHelper.registerKeyBinding(new KeyBinding("key.skyblockhelpers.backpack8", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_UNKNOWN, "category.skyblockhelpers"));
        backpack9Key = KeyBindingHelper.registerKeyBinding(new KeyBinding("key.skyblockhelpers.backpack9", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_UNKNOWN, "category.skyblockhelpers"));
        backpack10Key = KeyBindingHelper.registerKeyBinding(new KeyBinding("key.skyblockhelpers.backpack10", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_UNKNOWN, "category.skyblockhelpers"));
        backpack11Key = KeyBindingHelper.registerKeyBinding(new KeyBinding("key.skyblockhelpers.backpack11", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_UNKNOWN, "category.skyblockhelpers"));
        backpack12Key = KeyBindingHelper.registerKeyBinding(new KeyBinding("key.skyblockhelpers.backpack12", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_UNKNOWN, "category.skyblockhelpers"));
        backpack13Key = KeyBindingHelper.registerKeyBinding(new KeyBinding("key.skyblockhelpers.backpack13", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_UNKNOWN, "category.skyblockhelpers"));
        backpack14Key = KeyBindingHelper.registerKeyBinding(new KeyBinding("key.skyblockhelpers.backpack14", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_UNKNOWN, "category.skyblockhelpers"));
        backpack15Key = KeyBindingHelper.registerKeyBinding(new KeyBinding("key.skyblockhelpers.backpack15", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_UNKNOWN, "category.skyblockhelpers"));
        backpack16Key = KeyBindingHelper.registerKeyBinding(new KeyBinding("key.skyblockhelpers.backpack16", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_UNKNOWN, "category.skyblockhelpers"));
        backpack17Key = KeyBindingHelper.registerKeyBinding(new KeyBinding("key.skyblockhelpers.backpack17", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_UNKNOWN, "category.skyblockhelpers"));
        backpack18Key = KeyBindingHelper.registerKeyBinding(new KeyBinding("key.skyblockhelpers.backpack18", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_UNKNOWN, "category.skyblockhelpers"));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
        
            if (finderNewAngleKey.wasPressed()) {
                Finder.addNewAngle();
            }

            if (lockMouseKey.wasPressed()) {
                if (MouseLock.enabled){
                    client.player.sendMessage(Text.literal("§7Unlocked Player Rotation"), false);
                } else{
                    client.player.sendMessage(Text.literal("§7Locked Player Rotation"), false);
                }
                MouseLock.enabled = !MouseLock.enabled;
            }
            
            //echest + backpack commands (different formatting for less clutter)
            if (echest1Key.wasPressed()) {client.player.networkHandler.sendChatCommand("echest 1");}
            if (echest2Key.wasPressed()) {client.player.networkHandler.sendChatCommand("echest 2");}
            if (echest3Key.wasPressed()) {client.player.networkHandler.sendChatCommand("echest 3");}
            if (echest4Key.wasPressed()) {client.player.networkHandler.sendChatCommand("echest 4");}
            if (echest5Key.wasPressed()) {client.player.networkHandler.sendChatCommand("echest 5");}
            if (echest6Key.wasPressed()) {client.player.networkHandler.sendChatCommand("echest 6");}
            if (echest7Key.wasPressed()) {client.player.networkHandler.sendChatCommand("echest 7");}
            if (echest8Key.wasPressed()) {client.player.networkHandler.sendChatCommand("echest 8");}
            if (echest9Key.wasPressed()) {client.player.networkHandler.sendChatCommand("echest 9");}

            if (backpack1Key.wasPressed()) {client.player.networkHandler.sendChatCommand("backpack 1");}
            if (backpack2Key.wasPressed()) {client.player.networkHandler.sendChatCommand("backpack 2");}
            if (backpack3Key.wasPressed()) {client.player.networkHandler.sendChatCommand("backpack 3");}
            if (backpack4Key.wasPressed()) {client.player.networkHandler.sendChatCommand("backpack 4");}
            if (backpack5Key.wasPressed()) {client.player.networkHandler.sendChatCommand("backpack 5");}
            if (backpack6Key.wasPressed()) {client.player.networkHandler.sendChatCommand("backpack 6");}
            if (backpack7Key.wasPressed()) {client.player.networkHandler.sendChatCommand("backpack 7");}
            if (backpack8Key.wasPressed()) {client.player.networkHandler.sendChatCommand("backpack 8");}
            if (backpack9Key.wasPressed()) {client.player.networkHandler.sendChatCommand("backpack 9");}
            if (backpack10Key.wasPressed()) {client.player.networkHandler.sendChatCommand("backpack 10");}
            if (backpack11Key.wasPressed()) {client.player.networkHandler.sendChatCommand("backpack 11");}
            if (backpack12Key.wasPressed()) {client.player.networkHandler.sendChatCommand("backpack 12");}
            if (backpack13Key.wasPressed()) {client.player.networkHandler.sendChatCommand("backpack 13");}
            if (backpack14Key.wasPressed()) {client.player.networkHandler.sendChatCommand("backpack 14");}
            if (backpack15Key.wasPressed()) {client.player.networkHandler.sendChatCommand("backpack 15");}
            if (backpack16Key.wasPressed()) {client.player.networkHandler.sendChatCommand("backpack 16");}
            if (backpack17Key.wasPressed()) {client.player.networkHandler.sendChatCommand("backpack 17");}
            if (backpack18Key.wasPressed()) {client.player.networkHandler.sendChatCommand("backpack 18");}
        });
    }
}