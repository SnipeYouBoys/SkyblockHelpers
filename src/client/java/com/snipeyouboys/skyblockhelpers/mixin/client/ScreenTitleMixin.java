package com.snipeyouboys.skyblockhelpers.mixin.client;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.Mutable;

@Mixin(Screen.class)
public interface ScreenTitleMixin {
    @Accessor("title")
    @Mutable
    void setTitle(Text title);

    @Accessor("title")
    Text getTitle();
}