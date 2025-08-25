package com.snipeyouboys.skyblockhelpers;

import java.io.IOException;

import com.snipeyouboys.skyblockhelpers.Helpers.CleanTooltip;
import com.snipeyouboys.skyblockhelpers.Helpers.Clock;
import com.snipeyouboys.skyblockhelpers.Helpers.InventoryScale;
import com.snipeyouboys.skyblockhelpers.Helpers.PressureWarning;
import com.snipeyouboys.skyblockhelpers.Helpers.SmallHand;

import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.fabricmc.loader.api.FabricLoader;
import java.nio.file.Files;
import java.nio.file.Path;



public class Config {

    private static final Path CONFIG_FILE = FabricLoader.getInstance().getConfigDir().resolve("skyblockhelpers.json");
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    
    public static Screen createConfigScreen(Screen parent) {
        // Create the builder
        ConfigBuilder builder = ConfigBuilder.create()
            .setParentScreen(parent)
            .setTitle(Text.translatable("title.skyblockhelpers.config"));
        ConfigEntryBuilder entryBuilder = builder.entryBuilder();
        


        ConfigCategory pressureWarning = builder.getOrCreateCategory(Text.translatable("category.skyblockhelpers.pressurewarning"));
        
        pressureWarning.addEntry(entryBuilder.startBooleanToggle(Text.translatable("option.skyblockhelpers.pressurewarning.enabled"), PressureWarning.enabled).setDefaultValue(true)
        .setTooltip(Text.translatable("option.skyblockhelpers.pressurewarning.enabled.tooltip")).setSaveConsumer(newValue -> PressureWarning.enabled = newValue).build());
       
        pressureWarning.addEntry(entryBuilder.startIntSlider(Text.translatable("option.skyblockhelpers.pressurewarning.ylevel"), PressureWarning.Y_Level, -64, 100).setDefaultValue(77)
        .setTooltip(Text.translatable("option.skyblockhelpers.pressurewarning.ylevel.tooltip")).setSaveConsumer(newValue -> PressureWarning.Y_Level = newValue).build());

        pressureWarning.addEntry(entryBuilder.startIntSlider(Text.translatable("option.skyblockhelpers.pressurewarning.volume"), PressureWarning.volume, 1, 100).setDefaultValue(100)
        .setTooltip(Text.translatable("option.skyblockhelpers.pressurewarning.volume.tooltip")).setSaveConsumer(newValue -> PressureWarning.volume = newValue).build());



        ConfigCategory inventoryScale = builder.getOrCreateCategory(Text.translatable("category.skyblockhelpers.inventoryscale"));
       
        inventoryScale.addEntry(entryBuilder.startIntSlider(Text.translatable("option.skyblockhelpers.inventoryscale.normalscale"), InventoryScale.normalScale, 0, 4).setDefaultValue(2)
        .setTooltip(Text.translatable("option.skyblockhelpers.inventoryscale.normalscale.tooltip")).setSaveConsumer(newValue -> InventoryScale.normalScale = newValue).build());
        
        inventoryScale.addEntry(entryBuilder.startIntSlider(Text.translatable("option.skyblockhelpers.inventoryscale.containerscale"), InventoryScale.customScale, 0, 4).setDefaultValue(3)
        .setTooltip(Text.translatable("option.skyblockhelpers.inventoryscale.containerscale.tooltip")).setSaveConsumer(newValue -> InventoryScale.customScale = newValue).build());



        ConfigCategory smallHand = builder.getOrCreateCategory(Text.translatable("category.skyblockhelpers.smallhand"));
        
        smallHand.addEntry(entryBuilder.startBooleanToggle(Text.translatable("option.skyblockhelpers.smallhand.enabled"), SmallHand.enabled).setDefaultValue(true)
        .setTooltip(Text.translatable("option.skyblockhelpers.smallhand.enabled.tooltip")).setSaveConsumer(newValue -> SmallHand.enabled = newValue).build());
       
        smallHand.addEntry(entryBuilder.startIntSlider(Text.translatable("option.skyblockhelpers.smallhand.size"), SmallHand.size, 10, 100).setDefaultValue(50)
        .setTooltip(Text.translatable("option.skyblockhelpers.smallhand.size.tooltip")).setSaveConsumer(newValue -> SmallHand.size = newValue).build());



        ConfigCategory clock = builder.getOrCreateCategory(Text.translatable("category.skyblockhelpers.clock"));
        
        clock.addEntry(entryBuilder.startBooleanToggle(Text.translatable("option.skyblockhelpers.clock.enabled"), Clock.enabled).setDefaultValue(true)
        .setTooltip(Text.translatable("option.skyblockhelpers.clock.enabled.tooltip")).setSaveConsumer(newValue -> Clock.enabled = newValue).build());
       
        clock.addEntry(entryBuilder.startIntSlider(Text.translatable("option.skyblockhelpers.clock.utcoffset"), Clock.utcOffset, -11, 12).setDefaultValue(0)
        .setTooltip(Text.translatable("option.skyblockhelpers.clock.utcoffset.tooltip")).setSaveConsumer(newValue -> Clock.utcOffset = newValue).build());

        ConfigCategory cleanTooltip = builder.getOrCreateCategory(Text.translatable("category.skyblockhelpers.cleantooltip"));
        
        cleanTooltip.addEntry(entryBuilder.startBooleanToggle(Text.translatable("option.skyblockhelpers.cleantooltip.enabled"), CleanTooltip.enabled).setDefaultValue(true)
        .setTooltip(Text.translatable("option.skyblockhelpers.cleantooltip.enabled.tooltip")).setSaveConsumer(newValue -> CleanTooltip.enabled = newValue).build());

        cleanTooltip.addEntry(entryBuilder.startBooleanToggle(Text.translatable("option.skyblockhelpers.cleantooltip.removeempty"), CleanTooltip.removeEmpty).setDefaultValue(true)
        .setTooltip(Text.translatable("option.skyblockhelpers.cleantooltip.removeempty.tooltip")).setSaveConsumer(newValue -> CleanTooltip.removeEmpty = newValue).build());

        cleanTooltip.addEntry(entryBuilder.startBooleanToggle(Text.translatable("option.skyblockhelpers.cleantooltip.cleandrills"), CleanTooltip.cleanDrills).setDefaultValue(true)
        .setTooltip(Text.translatable("option.skyblockhelpers.cleantooltip.cleandrills.tooltip")).setSaveConsumer(newValue -> CleanTooltip.cleanDrills = newValue).build());


        
        
        
        builder.setSavingRunnable(() -> {
            save();
        });
        return builder.build();
    }
    
    public static void load() {
        if (!Files.exists(CONFIG_FILE)) return;
        try {
            String json = Files.readString(CONFIG_FILE);
            SerializableConfig data = GSON.fromJson(json, SerializableConfig.class);

            PressureWarning.enabled = data.pressureWarningEnabled;
            PressureWarning.Y_Level = data.pressureWarningY;
            PressureWarning.volume = data.pressureWarningVol;
            InventoryScale.normalScale = data.inventoryNormalScale;
            InventoryScale.customScale = data.inventoryCustomScale;
            SmallHand.enabled = data.smallHandEnabled;
            SmallHand.size = data.smallHandSize;
            Clock.enabled = data.clockEnabled;
            Clock.utcOffset = data.clockUTCOffset;
            CleanTooltip.enabled = data.cleanTooltipEnabled;
            CleanTooltip.removeEmpty = data.cleanTooltipRemoveEmpty;
            CleanTooltip.cleanDrills = data.cleanTooltipCleanDrills;

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void save() {
        try {
            Files.createDirectories(CONFIG_FILE.getParent());

            // Copy from helpers into serializable object
            SerializableConfig data = new SerializableConfig();
            data.pressureWarningEnabled = PressureWarning.enabled;
            data.pressureWarningY = PressureWarning.Y_Level;
            data.pressureWarningVol = PressureWarning.volume;
            data.inventoryNormalScale = InventoryScale.normalScale;
            data.inventoryCustomScale = InventoryScale.customScale;
            data.smallHandEnabled = SmallHand.enabled;
            data.smallHandSize = SmallHand.size;
            data.clockEnabled = Clock.enabled;
            data.clockUTCOffset = Clock.utcOffset;
            data.cleanTooltipEnabled = CleanTooltip.enabled;
            data.cleanTooltipRemoveEmpty = CleanTooltip.removeEmpty;
            data.cleanTooltipCleanDrills = CleanTooltip.cleanDrills;

            String json = GSON.toJson(data);
            Files.writeString(CONFIG_FILE, json);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}