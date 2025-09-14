package com.snipeyouboys.skyblockhelpers;

import com.snipeyouboys.skyblockhelpers.Helpers.AutoSkyblock;
import com.snipeyouboys.skyblockhelpers.Helpers.CleanTooltip;
import com.snipeyouboys.skyblockhelpers.Helpers.Clock;
import com.snipeyouboys.skyblockhelpers.Helpers.CommissionOverlay;
import com.snipeyouboys.skyblockhelpers.Helpers.DungeonHud;
import com.snipeyouboys.skyblockhelpers.Helpers.InventoryScale;
import com.snipeyouboys.skyblockhelpers.Helpers.PressureWarning;
import com.snipeyouboys.skyblockhelpers.Helpers.ShellwiseHighlight;
import com.snipeyouboys.skyblockhelpers.Helpers.InventoryOverlay;
import com.snipeyouboys.skyblockhelpers.Helpers.StorageRename;

import net.fabricmc.api.ClientModInitializer;

public class Initialiser implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		//Helper Module Classes (not all have an init() )
		PressureWarning.init();
		InventoryScale.init();
		Clock.init();
		CleanTooltip.init();
		AutoSkyblock.init();
		StorageRename.init();
		InventoryOverlay.init();
		ShellwiseHighlight.init();
		CommissionOverlay.init();
		DungeonHud.init();

		//main classes (not all have init()s)
		Keybinds.init();
		Config.load();
	}
}