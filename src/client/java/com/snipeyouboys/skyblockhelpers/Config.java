package com.snipeyouboys.skyblockhelpers;

import java.io.IOException;

import com.snipeyouboys.skyblockhelpers.Helpers.AutoSkyblock;
import com.snipeyouboys.skyblockhelpers.Helpers.CleanTooltip;
import com.snipeyouboys.skyblockhelpers.Helpers.Clock;
import com.snipeyouboys.skyblockhelpers.Helpers.CommissionOverlay;
import com.snipeyouboys.skyblockhelpers.Helpers.InventoryOverlay;
import com.snipeyouboys.skyblockhelpers.Helpers.InventoryScale;
import com.snipeyouboys.skyblockhelpers.Helpers.PressureWarning;
import com.snipeyouboys.skyblockhelpers.Helpers.ShellwiseHighlight;
import com.snipeyouboys.skyblockhelpers.Helpers.SlowHand;
import com.snipeyouboys.skyblockhelpers.Helpers.SmallHand;
import com.snipeyouboys.skyblockhelpers.Helpers.StorageRename;

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
        

        ConfigCategory misc = builder.getOrCreateCategory(Text.translatable("category.skyblockhelpers.misc"));
        ConfigCategory hud = builder.getOrCreateCategory(Text.translatable("category.skyblockhelpers.hud"));
        ConfigCategory storageRename = builder.getOrCreateCategory(Text.translatable("category.skyblockhelpers.storagerename"));





        misc.addEntry(entryBuilder.startSubCategory(Text.translatable("blank")).build());
        
        misc.addEntry(entryBuilder.startBooleanToggle(Text.translatable("option.skyblockhelpers.pressurewarning.enabled"), PressureWarning.enabled).setDefaultValue(true)
        .setTooltip(Text.translatable("option.skyblockhelpers.pressurewarning.enabled.tooltip")).setSaveConsumer(newValue -> PressureWarning.enabled = newValue).build());
       
        misc.addEntry(entryBuilder.startIntSlider(Text.translatable("option.skyblockhelpers.pressurewarning.ylevel"), PressureWarning.Y_Level, -64, 100).setDefaultValue(77)
        .setTooltip(Text.translatable("option.skyblockhelpers.pressurewarning.ylevel.tooltip")).setSaveConsumer(newValue -> PressureWarning.Y_Level = newValue).build());

        misc.addEntry(entryBuilder.startIntSlider(Text.translatable("option.skyblockhelpers.pressurewarning.volume"), PressureWarning.volume, 1, 100).setDefaultValue(100)
        .setTooltip(Text.translatable("option.skyblockhelpers.pressurewarning.volume.tooltip")).setSaveConsumer(newValue -> PressureWarning.volume = newValue).build());


       
        hud.addEntry(entryBuilder.startSubCategory(Text.translatable("blank")).build());
        
        hud.addEntry(entryBuilder.startBooleanToggle(Text.translatable("option.skyblockhelpers.inventoryscale.enabled"), InventoryScale.enabled).setDefaultValue(false)
        .setTooltip(Text.translatable("option.skyblockhelpers.inventoryscale.enabled.tooltip")).setSaveConsumer(newValue -> InventoryScale.enabled = newValue).build());
        
        hud.addEntry(entryBuilder.startIntSlider(Text.translatable("option.skyblockhelpers.inventoryscale.normalscale"), InventoryScale.normalScale, 0, 4).setDefaultValue(2)
        .setTooltip(Text.translatable("option.skyblockhelpers.inventoryscale.normalscale.tooltip")).setSaveConsumer(newValue -> InventoryScale.normalScale = newValue).build());
        
        hud.addEntry(entryBuilder.startIntSlider(Text.translatable("option.skyblockhelpers.inventoryscale.containerscale"), InventoryScale.customScale, 0, 4).setDefaultValue(3)
        .setTooltip(Text.translatable("option.skyblockhelpers.inventoryscale.containerscale.tooltip")).setSaveConsumer(newValue -> InventoryScale.customScale = newValue).build());



        
        misc.addEntry(entryBuilder.startSubCategory(Text.translatable("blank")).build());
        
        misc.addEntry(entryBuilder.startBooleanToggle(Text.translatable("option.skyblockhelpers.smallhand.enabled"), SmallHand.enabled).setDefaultValue(true)
        .setTooltip(Text.translatable("option.skyblockhelpers.smallhand.enabled.tooltip")).setSaveConsumer(newValue -> SmallHand.enabled = newValue).build());
       
        misc.addEntry(entryBuilder.startIntSlider(Text.translatable("option.skyblockhelpers.smallhand.size"), SmallHand.size, 10, 100).setDefaultValue(50)
        .setTooltip(Text.translatable("option.skyblockhelpers.smallhand.size.tooltip")).setSaveConsumer(newValue -> SmallHand.size = newValue).build());




        misc.addEntry(entryBuilder.startSubCategory(Text.translatable("blank")).build());
        
        misc.addEntry(entryBuilder.startBooleanToggle(Text.translatable("option.skyblockhelpers.slowhand.enabled"), SlowHand.enabled).setDefaultValue(true)
        .setTooltip(Text.translatable("option.skyblockhelpers.slowhand.enabled.tooltip")).setSaveConsumer(newValue -> SlowHand.enabled = newValue).build());

        misc.addEntry(entryBuilder.startIntSlider(Text.translatable("option.skyblockhelpers.slowhand.speed"), SlowHand.speed, 5, 100).setDefaultValue(25)
        .setTooltip(Text.translatable("option.skyblockhelpers.slowhand.speed.tooltip")).setSaveConsumer(newValue -> SlowHand.speed = newValue).build());



        
        hud.addEntry(entryBuilder.startSubCategory(Text.translatable("blank")).build());
        
        hud.addEntry(entryBuilder.startBooleanToggle(Text.translatable("option.skyblockhelpers.clock.enabled"), Clock.enabled).setDefaultValue(true)
        .setTooltip(Text.translatable("option.skyblockhelpers.clock.enabled.tooltip")).setSaveConsumer(newValue -> Clock.enabled = newValue).build());
       
        hud.addEntry(entryBuilder.startIntSlider(Text.translatable("option.skyblockhelpers.clock.utcoffset"), Clock.utcOffset, -11, 12).setDefaultValue(0)
        .setTooltip(Text.translatable("option.skyblockhelpers.clock.utcoffset.tooltip")).setSaveConsumer(newValue -> Clock.utcOffset = newValue).build());



        
        misc.addEntry(entryBuilder.startSubCategory(Text.translatable("blank")).build());
        
        misc.addEntry(entryBuilder.startBooleanToggle(Text.translatable("option.skyblockhelpers.cleantooltip.enabled"), CleanTooltip.enabled).setDefaultValue(true)
        .setTooltip(Text.translatable("option.skyblockhelpers.cleantooltip.enabled.tooltip")).setSaveConsumer(newValue -> CleanTooltip.enabled = newValue).build());

        misc.addEntry(entryBuilder.startBooleanToggle(Text.translatable("option.skyblockhelpers.cleantooltip.removeempty"), CleanTooltip.removeEmpty).setDefaultValue(true)
        .setTooltip(Text.translatable("option.skyblockhelpers.cleantooltip.removeempty.tooltip")).setSaveConsumer(newValue -> CleanTooltip.removeEmpty = newValue).build());

        misc.addEntry(entryBuilder.startBooleanToggle(Text.translatable("option.skyblockhelpers.cleantooltip.cleandrills"), CleanTooltip.cleanDrills).setDefaultValue(true)
        .setTooltip(Text.translatable("option.skyblockhelpers.cleantooltip.cleandrills.tooltip")).setSaveConsumer(newValue -> CleanTooltip.cleanDrills = newValue).build());



        
        misc.addEntry(entryBuilder.startSubCategory(Text.translatable("blank")).build());
        
        misc.addEntry(entryBuilder.startBooleanToggle(Text.translatable("option.skyblockhelpers.autoskyblock.enabled"), AutoSkyblock.enabled).setDefaultValue(true)
        .setTooltip(Text.translatable("option.skyblockhelpers.autoskyblock.enabled.tooltip")).setSaveConsumer(newValue -> AutoSkyblock.enabled = newValue).build());




        storageRename.addEntry(entryBuilder.startBooleanToggle(Text.translatable("option.skyblockhelpers.storagerename.enabled"), StorageRename.enabled).setDefaultValue(true)
        .setTooltip(Text.translatable("option.skyblockhelpers.storagerename.enabled.tooltip")).setSaveConsumer(newValue -> StorageRename.enabled = newValue).build());
        storageRename.addEntry(entryBuilder.startStrField(Text.translatable("option.skyblockhelpers.storagerename.echest1"), StorageRename.echest1Name).setDefaultValue("Echest 1")
        .setTooltip(Text.translatable("option.skyblockhelpers.storagerename.echest1.tooltip")).setSaveConsumer(newValue -> StorageRename.echest1Name = newValue).build());
        storageRename.addEntry(entryBuilder.startStrField(Text.translatable("option.skyblockhelpers.storagerename.echest2"), StorageRename.echest2Name).setDefaultValue("Echest 2")
        .setTooltip(Text.translatable("option.skyblockhelpers.storagerename.echest2.tooltip")).setSaveConsumer(newValue -> StorageRename.echest2Name = newValue).build());
        storageRename.addEntry(entryBuilder.startStrField(Text.translatable("option.skyblockhelpers.storagerename.echest3"), StorageRename.echest3Name).setDefaultValue("Echest 3")
        .setTooltip(Text.translatable("option.skyblockhelpers.storagerename.echest3.tooltip")).setSaveConsumer(newValue -> StorageRename.echest3Name = newValue).build());
        storageRename.addEntry(entryBuilder.startStrField(Text.translatable("option.skyblockhelpers.storagerename.echest4"), StorageRename.echest4Name).setDefaultValue("Echest 4")
        .setTooltip(Text.translatable("option.skyblockhelpers.storagerename.echest4.tooltip")).setSaveConsumer(newValue -> StorageRename.echest4Name = newValue).build());
        storageRename.addEntry(entryBuilder.startStrField(Text.translatable("option.skyblockhelpers.storagerename.echest5"), StorageRename.echest5Name).setDefaultValue("Echest 5")
        .setTooltip(Text.translatable("option.skyblockhelpers.storagerename.echest5.tooltip")).setSaveConsumer(newValue -> StorageRename.echest5Name = newValue).build());
        storageRename.addEntry(entryBuilder.startStrField(Text.translatable("option.skyblockhelpers.storagerename.echest6"), StorageRename.echest6Name).setDefaultValue("Echest 6")
        .setTooltip(Text.translatable("option.skyblockhelpers.storagerename.echest6.tooltip")).setSaveConsumer(newValue -> StorageRename.echest6Name = newValue).build());
        storageRename.addEntry(entryBuilder.startStrField(Text.translatable("option.skyblockhelpers.storagerename.echest7"), StorageRename.echest7Name).setDefaultValue("Echest 7")
        .setTooltip(Text.translatable("option.skyblockhelpers.storagerename.echest7.tooltip")).setSaveConsumer(newValue -> StorageRename.echest7Name = newValue).build());
        storageRename.addEntry(entryBuilder.startStrField(Text.translatable("option.skyblockhelpers.storagerename.echest8"), StorageRename.echest8Name).setDefaultValue("Echest 8")
        .setTooltip(Text.translatable("option.skyblockhelpers.storagerename.echest8.tooltip")).setSaveConsumer(newValue -> StorageRename.echest8Name = newValue).build());
        storageRename.addEntry(entryBuilder.startStrField(Text.translatable("option.skyblockhelpers.storagerename.echest9"), StorageRename.echest9Name).setDefaultValue("Echest 9")
        .setTooltip(Text.translatable("option.skyblockhelpers.storagerename.echest9.tooltip")).setSaveConsumer(newValue -> StorageRename.echest9Name = newValue).build());
        storageRename.addEntry(entryBuilder.startStrField(Text.translatable("option.skyblockhelpers.storagerename.backpack1"), StorageRename.backpack1Name).setDefaultValue("Backpack 1")
        .setTooltip(Text.translatable("option.skyblockhelpers.storagerename.backpack1.tooltip")).setSaveConsumer(newValue -> StorageRename.backpack1Name = newValue).build());
        storageRename.addEntry(entryBuilder.startStrField(Text.translatable("option.skyblockhelpers.storagerename.backpack2"), StorageRename.backpack2Name).setDefaultValue("Backpack 2")
        .setTooltip(Text.translatable("option.skyblockhelpers.storagerename.backpack2.tooltip")).setSaveConsumer(newValue -> StorageRename.backpack2Name = newValue).build());
        storageRename.addEntry(entryBuilder.startStrField(Text.translatable("option.skyblockhelpers.storagerename.backpack3"), StorageRename.backpack3Name).setDefaultValue("Backpack 3")
        .setTooltip(Text.translatable("option.skyblockhelpers.storagerename.backpack3.tooltip")).setSaveConsumer(newValue -> StorageRename.backpack3Name = newValue).build());
        storageRename.addEntry(entryBuilder.startStrField(Text.translatable("option.skyblockhelpers.storagerename.backpack4"), StorageRename.backpack4Name).setDefaultValue("Backpack 4")
        .setTooltip(Text.translatable("option.skyblockhelpers.storagerename.backpack4.tooltip")).setSaveConsumer(newValue -> StorageRename.backpack4Name = newValue).build());
        storageRename.addEntry(entryBuilder.startStrField(Text.translatable("option.skyblockhelpers.storagerename.backpack5"), StorageRename.backpack5Name).setDefaultValue("Backpack 5")
        .setTooltip(Text.translatable("option.skyblockhelpers.storagerename.backpack5.tooltip")).setSaveConsumer(newValue -> StorageRename.backpack5Name = newValue).build());
        storageRename.addEntry(entryBuilder.startStrField(Text.translatable("option.skyblockhelpers.storagerename.backpack6"), StorageRename.backpack6Name).setDefaultValue("Backpack 6")
        .setTooltip(Text.translatable("option.skyblockhelpers.storagerename.backpack6.tooltip")).setSaveConsumer(newValue -> StorageRename.backpack6Name = newValue).build());
        storageRename.addEntry(entryBuilder.startStrField(Text.translatable("option.skyblockhelpers.storagerename.backpack7"), StorageRename.backpack7Name).setDefaultValue("Backpack 7")
        .setTooltip(Text.translatable("option.skyblockhelpers.storagerename.backpack7.tooltip")).setSaveConsumer(newValue -> StorageRename.backpack7Name = newValue).build());
        storageRename.addEntry(entryBuilder.startStrField(Text.translatable("option.skyblockhelpers.storagerename.backpack8"), StorageRename.backpack8Name).setDefaultValue("Backpack 8")
        .setTooltip(Text.translatable("option.skyblockhelpers.storagerename.backpack8.tooltip")).setSaveConsumer(newValue -> StorageRename.backpack8Name = newValue).build());
        storageRename.addEntry(entryBuilder.startStrField(Text.translatable("option.skyblockhelpers.storagerename.backpack9"), StorageRename.backpack9Name).setDefaultValue("Backpack 9")
        .setTooltip(Text.translatable("option.skyblockhelpers.storagerename.backpack9.tooltip")).setSaveConsumer(newValue -> StorageRename.backpack9Name = newValue).build());
        storageRename.addEntry(entryBuilder.startStrField(Text.translatable("option.skyblockhelpers.storagerename.backpack10"), StorageRename.backpack10Name).setDefaultValue("Backpack 10")
        .setTooltip(Text.translatable("option.skyblockhelpers.storagerename.backpack10.tooltip")).setSaveConsumer(newValue -> StorageRename.backpack10Name = newValue).build());
        storageRename.addEntry(entryBuilder.startStrField(Text.translatable("option.skyblockhelpers.storagerename.backpack11"), StorageRename.backpack11Name).setDefaultValue("Backpack 11")
        .setTooltip(Text.translatable("option.skyblockhelpers.storagerename.backpack11.tooltip")).setSaveConsumer(newValue -> StorageRename.backpack11Name = newValue).build());
        storageRename.addEntry(entryBuilder.startStrField(Text.translatable("option.skyblockhelpers.storagerename.backpack12"), StorageRename.backpack12Name).setDefaultValue("Backpack 12")
        .setTooltip(Text.translatable("option.skyblockhelpers.storagerename.backpack12.tooltip")).setSaveConsumer(newValue -> StorageRename.backpack12Name = newValue).build());
        storageRename.addEntry(entryBuilder.startStrField(Text.translatable("option.skyblockhelpers.storagerename.backpack13"), StorageRename.backpack13Name).setDefaultValue("Backpack 13")
        .setTooltip(Text.translatable("option.skyblockhelpers.storagerename.backpack13.tooltip")).setSaveConsumer(newValue -> StorageRename.backpack13Name = newValue).build());
        storageRename.addEntry(entryBuilder.startStrField(Text.translatable("option.skyblockhelpers.storagerename.backpack14"), StorageRename.backpack14Name).setDefaultValue("Backpack 14")
        .setTooltip(Text.translatable("option.skyblockhelpers.storagerename.backpack14.tooltip")).setSaveConsumer(newValue -> StorageRename.backpack14Name = newValue).build());
        storageRename.addEntry(entryBuilder.startStrField(Text.translatable("option.skyblockhelpers.storagerename.backpack15"), StorageRename.backpack15Name).setDefaultValue("Backpack 15")
        .setTooltip(Text.translatable("option.skyblockhelpers.storagerename.backpack15.tooltip")).setSaveConsumer(newValue -> StorageRename.backpack15Name = newValue).build());
        storageRename.addEntry(entryBuilder.startStrField(Text.translatable("option.skyblockhelpers.storagerename.backpack16"), StorageRename.backpack16Name).setDefaultValue("Backpack 16")
        .setTooltip(Text.translatable("option.skyblockhelpers.storagerename.backpack16.tooltip")).setSaveConsumer(newValue -> StorageRename.backpack16Name = newValue).build());
        storageRename.addEntry(entryBuilder.startStrField(Text.translatable("option.skyblockhelpers.storagerename.backpack17"), StorageRename.backpack17Name).setDefaultValue("Backpack 17")
        .setTooltip(Text.translatable("option.skyblockhelpers.storagerename.backpack17.tooltip")).setSaveConsumer(newValue -> StorageRename.backpack17Name = newValue).build());
        storageRename.addEntry(entryBuilder.startStrField(Text.translatable("option.skyblockhelpers.storagerename.backpack18"), StorageRename.backpack18Name).setDefaultValue("Backpack 18")
        .setTooltip(Text.translatable("option.skyblockhelpers.storagerename.backpack18.tooltip")).setSaveConsumer(newValue -> StorageRename.backpack18Name = newValue).build());
        


        
        hud.addEntry(entryBuilder.startSubCategory(Text.translatable("blank")).build());
        
        hud.addEntry(entryBuilder.startBooleanToggle(Text.translatable("option.skyblockhelpers.inventoryoverlay.enabled"), InventoryOverlay.enabled).setDefaultValue(false)
        .setTooltip(Text.translatable("option.skyblockhelpers.inventoryoverlay.enabled.tooltip")).setSaveConsumer(newValue -> InventoryOverlay.enabled = newValue).build());

        hud.addEntry(entryBuilder.startBooleanToggle(Text.translatable("option.skyblockhelpers.inventoryoverlay.corner"), InventoryOverlay.corner).setDefaultValue(false)
        .setTooltip(Text.translatable("option.skyblockhelpers.inventoryoverlay.corner.tooltip")).setSaveConsumer(newValue -> InventoryOverlay.corner = newValue).build());



        
        misc.addEntry(entryBuilder.startSubCategory(Text.translatable("blank")).build());
        
        misc.addEntry(entryBuilder.startBooleanToggle(Text.translatable("option.skyblockhelpers.shellwisehighlight.enabled"), ShellwiseHighlight.enabled).setDefaultValue(true)
        .setTooltip(Text.translatable("option.skyblockhelpers.shellwisehighlight.enabled.tooltip")).setSaveConsumer(newValue -> ShellwiseHighlight.enabled = newValue).build());

        misc.addEntry(entryBuilder.startIntSlider(Text.translatable("option.skyblockhelpers.shellwisehighlight.radius"), ShellwiseHighlight.radius, 5, 25).setDefaultValue(20)
        .setTooltip(Text.translatable("option.skyblockhelpers.shellwisehighlight.radius.tooltip")).setSaveConsumer(newValue -> ShellwiseHighlight.radius = newValue).build());




        hud.addEntry(entryBuilder.startSubCategory(Text.translatable("blank")).build());
        
        hud.addEntry(entryBuilder.startBooleanToggle(Text.translatable("option.skyblockhelpers.commissionoverlay.enabled"), CommissionOverlay.enabled).setDefaultValue(true)
        .setTooltip(Text.translatable("option.skyblockhelpers.commissionoverlay.enabled.tooltip")).setSaveConsumer(newValue -> CommissionOverlay.enabled = newValue).build());


        
        
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

            InventoryScale.enabled = data.inventoryScaleEnabled;
            InventoryScale.normalScale = data.inventoryNormalScale;
            InventoryScale.customScale = data.inventoryCustomScale;

            SmallHand.enabled = data.smallHandEnabled;
            SmallHand.size = data.smallHandSize;

            Clock.enabled = data.clockEnabled;
            Clock.utcOffset = data.clockUTCOffset;

            CleanTooltip.enabled = data.cleanTooltipEnabled;
            CleanTooltip.removeEmpty = data.cleanTooltipRemoveEmpty;
            CleanTooltip.cleanDrills = data.cleanTooltipCleanDrills;

            AutoSkyblock.enabled = data.autoSkyblockEnabled;

            SlowHand.enabled = data.slowHandEnabled;
            SlowHand.speed = data.slowHandSpeed;
            
            StorageRename.echest1Name = data.echest1CustomName;
            StorageRename.echest2Name = data.echest2CustomName;
            StorageRename.echest3Name = data.echest3CustomName;
            StorageRename.echest4Name = data.echest4CustomName;
            StorageRename.echest5Name = data.echest5CustomName;
            StorageRename.echest6Name = data.echest6CustomName;
            StorageRename.echest7Name = data.echest7CustomName;
            StorageRename.echest8Name = data.echest8CustomName;
            StorageRename.echest9Name = data.echest9CustomName;
            
            StorageRename.backpack1Name = data.backpack1CustomName;
            StorageRename.backpack2Name = data.backpack2CustomName;
            StorageRename.backpack3Name = data.backpack3CustomName;
            StorageRename.backpack4Name = data.backpack4CustomName;
            StorageRename.backpack5Name = data.backpack5CustomName;
            StorageRename.backpack6Name = data.backpack6CustomName;
            StorageRename.backpack7Name = data.backpack7CustomName;
            StorageRename.backpack8Name = data.backpack8CustomName;
            StorageRename.backpack9Name = data.backpack9CustomName;
            StorageRename.backpack10Name = data.backpack10CustomName;
            StorageRename.backpack11Name = data.backpack11CustomName;
            StorageRename.backpack12Name = data.backpack12CustomName;
            StorageRename.backpack13Name = data.backpack13CustomName;
            StorageRename.backpack14Name = data.backpack14CustomName;
            StorageRename.backpack15Name = data.backpack15CustomName;
            StorageRename.backpack16Name = data.backpack16CustomName;
            StorageRename.backpack17Name = data.backpack17CustomName;
            StorageRename.backpack18Name = data.backpack18CustomName;

            InventoryOverlay.enabled = data.inventoryOverlayEnabled;
            InventoryOverlay.corner = data.inventoryOverlayCorner;

            ShellwiseHighlight.enabled = data.shellwiseHighlightEnabled;
            ShellwiseHighlight.radius = data.shellwiseHighlightRadius;

            CommissionOverlay.enabled = data.commissionOverlayEnabled;


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void save() {
        try {
            Files.createDirectories(CONFIG_FILE.getParent());

            SerializableConfig data = new SerializableConfig();
            data.pressureWarningEnabled = PressureWarning.enabled;
            data.pressureWarningY = PressureWarning.Y_Level;
            data.pressureWarningVol = PressureWarning.volume;

            data.inventoryScaleEnabled = InventoryScale.enabled;
            data.inventoryNormalScale = InventoryScale.normalScale;
            data.inventoryCustomScale = InventoryScale.customScale;

            data.smallHandEnabled = SmallHand.enabled;
            data.smallHandSize = SmallHand.size;

            data.clockEnabled = Clock.enabled;
            data.clockUTCOffset = Clock.utcOffset;

            data.cleanTooltipEnabled = CleanTooltip.enabled;
            data.cleanTooltipRemoveEmpty = CleanTooltip.removeEmpty;
            data.cleanTooltipCleanDrills = CleanTooltip.cleanDrills;

            data.autoSkyblockEnabled = AutoSkyblock.enabled;

            data.slowHandEnabled = SlowHand.enabled;
            data.slowHandSpeed = SlowHand.speed;

            data.echest1CustomName = StorageRename.echest1Name;
            data.echest2CustomName = StorageRename.echest2Name;
            data.echest3CustomName = StorageRename.echest3Name;
            data.echest4CustomName = StorageRename.echest4Name;
            data.echest5CustomName = StorageRename.echest5Name;
            data.echest6CustomName = StorageRename.echest6Name;
            data.echest7CustomName = StorageRename.echest7Name;
            data.echest8CustomName = StorageRename.echest8Name;
            data.echest9CustomName = StorageRename.echest9Name;

            data.backpack1CustomName = StorageRename.backpack1Name;
            data.backpack2CustomName = StorageRename.backpack2Name;
            data.backpack3CustomName = StorageRename.backpack3Name;
            data.backpack4CustomName = StorageRename.backpack4Name;
            data.backpack5CustomName = StorageRename.backpack5Name;
            data.backpack6CustomName = StorageRename.backpack6Name;
            data.backpack7CustomName = StorageRename.backpack7Name;
            data.backpack8CustomName = StorageRename.backpack8Name;
            data.backpack9CustomName = StorageRename.backpack9Name;
            data.backpack10CustomName = StorageRename.backpack10Name;
            data.backpack11CustomName = StorageRename.backpack11Name;
            data.backpack12CustomName = StorageRename.backpack12Name;
            data.backpack13CustomName = StorageRename.backpack13Name;
            data.backpack14CustomName = StorageRename.backpack14Name;
            data.backpack15CustomName = StorageRename.backpack15Name;
            data.backpack16CustomName = StorageRename.backpack16Name;
            data.backpack17CustomName = StorageRename.backpack17Name;
            data.backpack18CustomName = StorageRename.backpack18Name;

            data.inventoryOverlayEnabled = InventoryOverlay.enabled;
            data.inventoryOverlayCorner = InventoryOverlay.corner;

            data.shellwiseHighlightEnabled = ShellwiseHighlight.enabled;
            data.shellwiseHighlightRadius = ShellwiseHighlight.radius;

            data.commissionOverlayEnabled = CommissionOverlay.enabled;

            String json = GSON.toJson(data);
            Files.writeString(CONFIG_FILE, json);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}