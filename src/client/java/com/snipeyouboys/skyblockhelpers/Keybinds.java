package com.snipeyouboys.skyblockhelpers;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

import com.snipeyouboys.skyblockhelpers.Helpers.Finder;
import com.snipeyouboys.skyblockhelpers.Helpers.MouseLock;

public class Keybinds {

    // KeyBinding instances
    private static KeyBinding finderNewAngleKey;
    private static KeyBinding lockMouseKey;

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

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
        
            if (finderNewAngleKey.wasPressed()) {
                Finder.addNewAngle();
            }

            if (lockMouseKey.wasPressed()) {
                MouseLock.enabled = !MouseLock.enabled;
            }

        });
    }
}