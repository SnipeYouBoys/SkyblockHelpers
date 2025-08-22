package com.snipeyouboys.skyblockhelpers;

import com.snipeyouboys.skyblockhelpers.Helpers.Clock;
import com.snipeyouboys.skyblockhelpers.Helpers.InventoryScale;
import com.snipeyouboys.skyblockhelpers.Helpers.PressureWarning;
import net.fabricmc.api.ClientModInitializer;

public class Initialiser implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		PressureWarning.init();
		InventoryScale.init();
		Clock.init();

		Commands.init();
		Keybinds.init();

		Config.load();
	}
}