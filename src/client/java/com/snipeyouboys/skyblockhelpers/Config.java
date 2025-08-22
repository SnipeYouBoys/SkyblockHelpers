package com.snipeyouboys.skyblockhelpers;

import java.io.IOException;

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
        .setTooltip(Text.translatable("Whether PressureWarning Is Enabled")).setSaveConsumer(newValue -> PressureWarning.enabled = newValue).build()); // Builds the option entry for cloth config
       
        pressureWarning.addEntry(entryBuilder.startIntSlider(Text.translatable("option.skyblockhelpers.pressurewarning.ylevel"), PressureWarning.Y_Level, -64, 100).setDefaultValue(77)
        .setTooltip(Text.translatable("Y Level To Trigger PressureWarning At")).setSaveConsumer(newValue -> PressureWarning.Y_Level = newValue).build()); // Builds the option entry for cloth config



        ConfigCategory inventoryScale = builder.getOrCreateCategory(Text.translatable("category.skyblockhelpers.inventoryscale"));
       
        inventoryScale.addEntry(entryBuilder.startIntSlider(Text.translatable("option.skyblockhelpers.inventoryscale.normalscale"), InventoryScale.normalScale, 0, 4).setDefaultValue(2)
        .setTooltip(Text.translatable("Normal Gameplay GUI Scale")).setSaveConsumer(newValue -> InventoryScale.normalScale = newValue).build()); // Builds the option entry for cloth config
        
        inventoryScale.addEntry(entryBuilder.startIntSlider(Text.translatable("option.skyblockhelpers.inventoryscale.containerscale"), InventoryScale.customScale, 0, 4).setDefaultValue(3)
        .setTooltip(Text.translatable("Container/Inventory GUI Scale")).setSaveConsumer(newValue -> InventoryScale.customScale = newValue).build()); // Builds the option entry for cloth config



        ConfigCategory smallHand = builder.getOrCreateCategory(Text.translatable("category.skyblockhelpers.smallhand"));
        
        smallHand.addEntry(entryBuilder.startBooleanToggle(Text.translatable("option.skyblockhelpers.smallhand.enabled"), SmallHand.enabled).setDefaultValue(true)
        .setTooltip(Text.translatable("Whether SmallHand Is Enabled")).setSaveConsumer(newValue -> SmallHand.enabled = newValue).build()); // Builds the option entry for cloth config
       
        smallHand.addEntry(entryBuilder.startIntSlider(Text.translatable("option.skyblockhelpers.smallhand.size"), SmallHand.size, 10, 100).setDefaultValue(50)
        .setTooltip(Text.translatable("The Size Of Your Hand")).setSaveConsumer(newValue -> SmallHand.size = newValue).build()); // Builds the option entry for cloth config



        ConfigCategory clock = builder.getOrCreateCategory(Text.translatable("category.skyblockhelpers.clock"));
        
        clock.addEntry(entryBuilder.startBooleanToggle(Text.translatable("option.skyblockhelpers.clock.enabled"), Clock.enabled).setDefaultValue(true)
        .setTooltip(Text.translatable("Whether Clock Is Enabled")).setSaveConsumer(newValue -> Clock.enabled = newValue).build()); // Builds the option entry for cloth config
       
        clock.addEntry(entryBuilder.startIntSlider(Text.translatable("option.skyblockhelpers.clock.utcoffset"), Clock.utcOffset, -11, 12).setDefaultValue(0)
        .setTooltip(Text.translatable("What UTC Offset To Use For The Clock")).setSaveConsumer(newValue -> Clock.utcOffset = newValue).build()); // Builds the option entry for cloth config


        
        
        
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
            InventoryScale.normalScale = data.inventoryNormalScale;
            InventoryScale.customScale = data.inventoryCustomScale;
            SmallHand.enabled = data.smallHandEnabled;
            SmallHand.size = data.smallHandSize;
            Clock.enabled = data.clockEnabled;
            Clock.utcOffset = data.clockUTCOffset;

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
            data.inventoryNormalScale = InventoryScale.normalScale;
            data.inventoryCustomScale = InventoryScale.customScale;
            data.smallHandEnabled = SmallHand.enabled;
            data.smallHandSize = SmallHand.size;
            data.clockEnabled = Clock.enabled;
            data.clockUTCOffset = Clock.utcOffset;

            String json = GSON.toJson(data);
            Files.writeString(CONFIG_FILE, json);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}